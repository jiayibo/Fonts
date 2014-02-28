
package com.apf.androidfontlist;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Menu;
import android.widget.TextView;

public class ShowFont extends Activity {

    private static final String str = "You attempted to reach wiki.sonyericsson.net, "
            + "but the server presented a certificate issued by an entity that is not "
            + "trusted by your computer's operating system. "
            + "This may mean that the server has generated its own security credentials, "
            + "which Chrome cannot rely on for identity information, "
            + "or an attacker may be trying to intercept your communications.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_font);

        Typeface tf = null;
        //TODO pass typeface from fontlist intent
        int style  = getIntent().getIntExtra(Utils.STYLLE, 0);
        tf = Typeface.create(Typeface.SANS_SERIF, style);
        TextView tv = (TextView)findViewById(R.id.font_text);
        tv.setTypeface(tf);
        tv.setText(str);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.show_font, menu);
        return true;
    }

}
