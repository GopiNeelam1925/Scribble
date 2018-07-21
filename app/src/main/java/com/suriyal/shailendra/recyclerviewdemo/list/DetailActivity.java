package com.suriyal.shailendra.recyclerviewdemo.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.suriyal.shailendra.recyclerviewdemo.R;

/**
 * Created by shailendra.suriyal
 */

public class DetailActivity extends AppCompatActivity {

    private static final String EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";
    private static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private static final String EXTRA_DRAWABLES = "EXTRA_DRAWABLES";


    private TextView mDateAndTime;
    private TextView mMessage;
    private View mColoredBackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();
        String dateAndTime = i.getStringExtra(EXTRA_DATE_AND_TIME);
        String message = i.getStringExtra(EXTRA_MESSAGE);
        int drawableResourceExtra = i.getIntExtra(EXTRA_DRAWABLES,0);

        mDateAndTime = (TextView) findViewById(R.id.lbl_date_and_time_header);
        mDateAndTime.setText(dateAndTime);

        mMessage = (TextView) findViewById(R.id.lbl_message_body);
        mMessage.setText(message);

        mColoredBackground = (View) findViewById(R.id.imv_colored_background);
        mColoredBackground.setBackgroundResource(drawableResourceExtra);





    }
}
