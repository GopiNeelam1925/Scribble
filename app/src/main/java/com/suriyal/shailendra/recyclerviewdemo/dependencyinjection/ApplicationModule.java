package com.suriyal.shailendra.recyclerviewdemo.dependencyinjection;

import android.app.Application;

import com.suriyal.shailendra.recyclerviewdemo.RoomDemoApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shailendra.suriyal
 */

@Module
public class ApplicationModule {
    private final RoomDemoApplication application;
    public ApplicationModule(RoomDemoApplication application) {
        this.application = application;
    }

    @Provides
    RoomDemoApplication provideRoomDemoApplication(){
        return application;
    }

    @Provides
    Application provideApplication(){
        return application;
    }
}
