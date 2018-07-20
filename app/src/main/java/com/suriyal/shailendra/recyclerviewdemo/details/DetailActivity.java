package com.suriyal.shailendra.recyclerviewdemo.details;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.suriyal.shailendra.recyclerviewdemo.R;
import com.suriyal.shailendra.recyclerviewdemo.list.ListFragment;
import com.suriyal.shailendra.recyclerviewdemo.util.BaseActivity;

public class DetailActivity extends BaseActivity {


    private static final String DETAIL_FRAG = "DETAIL_FRAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager manager = getSupportFragmentManager();
        ListFragment fragment = (ListFragment) manager.findFragmentByTag(DETAIL_FRAG);
        if(fragment == null){
            fragment = DetailFragment.newInstance();
        }

        addFragmentToActivity(manager,fragment, R.id.root_activity_list, DETAIL_FRAG );
    }
}
