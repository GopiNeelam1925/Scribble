package com.suriyal.shailendra.recyclerviewdemo.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by shailendra.suriyal
 */
public abstract class BaseActivity extends AppCompatActivity {
    public static void addFragmentToActivity(FragmentManager fragmentManager,
                                             Fragment fragment,
                                             int frameId,
                                             String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(frameId,fragment,tag);
        fragmentTransaction.commit();
    }
}
