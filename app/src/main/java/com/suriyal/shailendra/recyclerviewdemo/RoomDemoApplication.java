package com.suriyal.shailendra.recyclerviewdemo;

import android.app.Application;

import com.suriyal.shailendra.recyclerviewdemo.dependencyinjection.ApplicationComponent;
import com.suriyal.shailendra.recyclerviewdemo.dependencyinjection.ApplicationModule;
import com.suriyal.shailendra.recyclerviewdemo.dependencyinjection.DaggerApplicationComponent;
import com.suriyal.shailendra.recyclerviewdemo.dependencyinjection.RoomModule;

/**
 * Created by shailendra.suriyal
 */

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
