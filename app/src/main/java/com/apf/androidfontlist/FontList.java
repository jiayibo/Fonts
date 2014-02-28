
package com.apf.androidfontlist;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FontList extends ExpandableListActivity {

    protected List<String> files = new ArrayList<String>();

    protected List<String> nameset = new ArrayList<String>();

    protected String[][] fileset = {
            {
                    "Regular", "Italic", "Bold", "BoldItalic"
            }, {
                    "Regular", "Italic", "Bold", "BoldItalic"
            }, {
                    "Regular", "Italic", "Bold", "BoldItalic"
            }, {
                    "Regular", "Italic", "Bold", "BoldItalic"
            }
    };

    ExpandableListAdapter mAdapter;

    private void initFontData() {
        nameset = Utils.getAllSystemFontFiles();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initFontData();
        mAdapter = new MyExpandableListAdapter();
        setListAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.font_list, menu);
        return true;
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
            int childPosition, long id) {

        Intent intent = new Intent(this, ShowFont.class);
        // intent.putExtra(Utils.FAMILYNAME, Typeface.SANS_SERIF);


        String styleString = fileset[groupPosition][childPosition].toString();
        int style = 0;

        if (styleString.equals("Regular")) {
            style = 0;
        } else if (styleString.equals("Italic")) {
            style = 1;
        } else if (styleString.equals("Bold")) {
            style = 2;
        } else if (styleString.equals("BoldItalic")) {
            style = 3;
        }

        intent.putExtra(Utils.STYLLE, style);

        startActivity(intent);
        return true;
    }

    public class MyExpandableListAdapter extends BaseExpandableListAdapter {
        @Override
        public int getGroupCount() {
            return nameset.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return fileset[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return nameset.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return fileset[groupPosition][childPosition];
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

        private TextView buildTextView() {
            // Layout parameters for the ExpandableListView
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, 64);

            TextView tv = new TextView(FontList.this);
            tv.setLayoutParams(lp);
            // Center the text vertically
            tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            // Set the text starting position
            tv.setPaddingRelative(360, 0, 0, 0);
            // Set the text alignment
            tv.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
            return tv;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                ViewGroup parent) {
            TextView tv = buildTextView();
            tv.setText(nameset.get(groupPosition).toString());
            return tv;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                View convertView, ViewGroup parent) {
            TextView tv = buildTextView();
            tv.setText(fileset[groupPosition][childPosition].toString());
            return tv;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }

}
