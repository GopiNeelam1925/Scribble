package com.suriyal.shailendra.recyclerviewdemo;

import android.app.Application;

import com.suriyal.shailendra.recyclerviewdemo.create.CreateFragment;
import com.suriyal.shailendra.recyclerviewdemo.dependencyinjection.ApplicationComponent;
import com.suriyal.shailendra.recyclerviewdemo.dependencyinjection.ApplicationModule;
import com.suriyal.shailendra.recyclerviewdemo.dependencyinjection.RoomModule;
import com.suriyal.shailendra.recyclerviewdemo.details.DetailFragment;
import com.suriyal.shailendra.recyclerviewdemo.list.ListFragment;

/**
 * Created by shailendra.suriyal
 */

import javax.inject.Singleton;

import dagger.Component;

/**
 * Annotated as a Singelton since we don't want to have multiple instances of a Single Database,
 * <p>
 * Created by R_KAY on 8/15/2017.
 */

public class RoomDemoApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .roomModule(new RoomModule(this))
                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
