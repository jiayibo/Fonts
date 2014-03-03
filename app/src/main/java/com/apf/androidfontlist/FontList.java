
package com.apf.androidfontlist;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FontList extends Activity {

    private static final String TAG = "FontList";

    protected List<String> systemFontFiles = new ArrayList<String>();

    protected List<String> groupList = new ArrayList<String>();

    protected HashMap<String, List<String>> fontMap = new HashMap<String, List<String>>();
    ExpandableListView expandableListView;
    ExpandableListAdapter mAdapter;
    TextView preview;
    SeekBar sb;
    private SharedPreferences prefs;

    private void storeFontData() {
        String font, type;
        systemFontFiles = Utils.getAllSystemFontFiles();
        for (int i = 0; i < systemFontFiles.size(); i++) {
            String[] ret = Utils.getNameAndStyle(systemFontFiles.get(i));
            font = ret[0];
            type = ret[1];

            if (!fontMap.containsKey(font)) {
                groupList.add(font);
                List<String> list = new ArrayList<String>();
                list.add(type);
                fontMap.put(font, list);
            } else {
                fontMap.get(font).add(type);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_font_list);

        storeFontData();

        expandableListView = (ExpandableListView)findViewById(R.id.expandableListView);
        preview = (TextView)findViewById(R.id.textView);
        sb = (SeekBar)findViewById(R.id.seekBar);

        mAdapter = new MyExpandableListAdapter();
        expandableListView.setAdapter(mAdapter);


        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPostion, long l) {
                int location = 0;
                for(int i = 0; i < groupPostion; i++){
                    location += fontMap.get(groupList.get(i)).size();
                }

                String path = systemFontFiles.get(location);
                changePreviewLanguage(path);

                preview.setTypeface(Typeface.createFromFile(path));
                expandableListView.expandGroup(groupPostion, true);

                return true;
            }
        });
        // Listview on child click listener
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                int location = 0;

                for(int i = 0; i < groupPosition; i++){
                    location += fontMap.get(groupList.get(i)).size();
                }
                location = location + childPosition;
                String path = systemFontFiles.get(location);
                changePreviewLanguage(path);

                preview.setTypeface(Typeface.createFromFile(path));

                return true;
            }
        });

        prefs = getPreferences(MODE_PRIVATE);

        float fs = prefs.getFloat("fontsize", 40);
        sb.setProgress((int)fs);
        preview.setTextSize(TypedValue.COMPLEX_UNIT_PX, sb.getProgress()*(float)1.3 );

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                preview.setTextSize(TypedValue.COMPLEX_UNIT_PX, i*(float)1.3);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                prefs = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor ed = prefs.edit();
                ed.putFloat("fontsize", preview.getTextSize());
                ed.commit();
            }
        });
    }

    private void changePreviewLanguage(String path) {
        int locale = 0;
        final int CN = 1;
        final int JA = 2;
        final int EMOJI = 3;
        if (path == "/system/fonts/MTLmr3m.ttf") {
            preview.setText(R.string.fontStringJa);
        } else if (path == "/system/fonts/DroidSansFallback.ttf") {
            preview.setText(R.string.fontStringCn);
        } else if (path == "/system/fonts/DroidSansHebrew-Regular.ttf") {
            preview.setText(R.string.fontStringHebrew);
        } else if (path == "/system/fonts/DroidSansHebrew-Bold.ttf") {
            preview.setText(R.string.fontStringHebrew);
        } else if (path == "/system/fonts/AndroidEmoji.ttf") {
            preview.setText("\uE415");
        } else if (path == "/system/fonts/NotoColorEmoji.ttf") {
            preview.setText("\uE415");
        } else {
            preview.setText(R.string.fontString);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.font_list, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_reset:
                resetPreview();
                resetSeekBar();
                collapseAll();
                break;
        }
        return true;
    }

    private void resetSeekBar() {
        sb.setProgress(40);
        preview.setTextSize(TypedValue.COMPLEX_UNIT_PX, (float)(40 * 1.3));
    }

    private void resetPreview() {
        preview.setText(R.string.fontString);
        preview.setTypeface(null);
    }

    private boolean collapseAll() {
        for (int i = 0; i < groupList.size(); i++) {
            expandableListView.collapseGroup(i);
        }
        return true;
    }




    public class MyExpandableListAdapter extends BaseExpandableListAdapter {
        @Override
        public int getGroupCount() {
            return fontMap.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return fontMap.get(groupList.get(groupPosition)).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groupList.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return fontMap.get(groupList.get(groupPosition)).get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                ViewGroup parent) {

            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater)
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.list_group, null);
            }

            TextView lblListHeader = (TextView) convertView
                    .findViewById(R.id.lblListHeader);
            lblListHeader.setTypeface(null, Typeface.BOLD);

            lblListHeader.setText(groupList.get(groupPosition).toString());
            return lblListHeader;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                View convertView, ViewGroup parent) {


            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater)getSystemService
                        (Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.list_item, null);
            }

            TextView txtListChild = (TextView) convertView
                    .findViewById(R.id.lblListItem);

            txtListChild.setText(fontMap.get(groupList.get(groupPosition)).get(childPosition));
            return txtListChild;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }

}
