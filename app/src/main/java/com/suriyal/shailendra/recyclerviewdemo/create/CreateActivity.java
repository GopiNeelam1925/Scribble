package com.suriyal.shailendra.recyclerviewdemo.create;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.suriyal.shailendra.recyclerviewdemo.R;
import com.suriyal.shailendra.recyclerviewdemo.util.BaseActivity;

public class CreateActivity extends BaseActivity {


    private static final String CREATE_FRAG = "CREATE_FRAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        FragmentManager manager = getSupportFragmentManager();
        CreateFragment fragment = (CreateFragment) manager.findFragmentByTag(CREATE_FRAG);
        if(fragment == null){
            fragment = CreateFragment.newInstance();
        }

        addFragmentToActivity(manager,fragment, R.id.root_activity_create, CREATE_FRAG);
    }
}
