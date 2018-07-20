package com.suriyal.shailendra.recyclerviewdemo.create;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.suriyal.shailendra.recyclerviewdemo.R;
import com.suriyal.shailendra.recyclerviewdemo.list.ListFragment;
import com.suriyal.shailendra.recyclerviewdemo.util.BaseActivity;

public class CreateActivity extends BaseActivity {


    private static final String CREATE_FRAG = "CREATE_FRAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager manager = getSupportFragmentManager();
        ListFragment fragment = (ListFragment) manager.findFragmentByTag(CREATE_FRAG);
        if(fragment == null){
            fragment = CreateFragment.newInstance();
        }

        addFragmentToActivity(manager,fragment, R.id.root_activity_list, CREATE_FRAG);
    }
}
