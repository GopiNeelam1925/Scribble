package com.suriyal.shailendra.recyclerviewdemo.dependencyinjection;

/**
 * Created by shailendra.suriyal
 */
import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.Room;

import com.suriyal.shailendra.recyclerviewdemo.data.ListItemDAO;
import com.suriyal.shailendra.recyclerviewdemo.data.ListItemDatabase;
import com.suriyal.shailendra.recyclerviewdemo.data.ListItemRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private final ListItemDatabase database;

    public RoomModule(Application application) {
        this.database = Room.databaseBuilder(
                application,
                ListItemDatabase.class,
                "ListItem.db"
        ).build();
    }

    @Provides
    @Singleton
    ListItemRepository provideListItemRepository(ListItemDAO listItemDao){
        return new ListItemRepository(listItemDao);
    }

    @Provides
    @Singleton
    ListItemDAO provideListItemDao(ListItemDatabase database){
        return database.mListItemDAO();
    }

    @Provides
    @Singleton
    ListItemDatabase provideListItemDatabase(Application application){
        return database;
    }

    @Provides
    @Singleton
    ViewModelProvider.Factory provideViewModelFactory(ListItemRepository repository){
        return new CustomViewModelFactory(repository);
    }
}
