package com.suriyal.shailendra.recyclerviewdemo.dependencyinjection;

import com.suriyal.shailendra.recyclerviewdemo.create.CreateFragment;
import com.suriyal.shailendra.recyclerviewdemo.details.DetailFragment;
import com.suriyal.shailendra.recyclerviewdemo.list.ListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by shailendra.suriyal
 */

@Singleton
@Component(modules = {ApplicationModule.class, RoomModule.class})
public interface ApplicationComponent {

    void inject(ListFragment listFragment);
    void inject(CreateFragment createFragment);
    void inject(DetailFragment detailFragment);

}
