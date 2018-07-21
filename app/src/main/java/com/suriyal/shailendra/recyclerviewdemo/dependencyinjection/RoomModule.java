package com.suriyal.shailendra.recyclerviewdemo.dependencyinjection;

/**
 * Created by shailendra.suriyal
 */
import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.Room;

import com.suriyal.shailendra.recyclerviewdemo.data.NoteDAO;
import com.suriyal.shailendra.recyclerviewdemo.data.NoteDatabase;
import com.suriyal.shailendra.recyclerviewdemo.data.NoteRepository;
import com.suriyal.shailendra.recyclerviewdemo.viewmodel.CustomViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private final NoteDatabase database;

    public RoomModule(Application application) {
        this.database = Room.databaseBuilder(
                application,
                NoteDatabase.class,
                "Note.db"
        ).build();
    }

    @Provides
    @Singleton
    NoteRepository provideNoteRepository(NoteDAO listItemDao){
        return new NoteRepository(listItemDao);
    }

    @Provides
    @Singleton
    NoteDAO provideListItemDao(NoteDatabase database){
        return database.mNoteDAO();
    }

    @Provides
    @Singleton
    NoteDatabase provideNoteDatabase(Application application){
        return database;
    }

    @Provides
    @Singleton
    ViewModelProvider.Factory provideViewModelFactory(NoteRepository repository){
        return new CustomViewModelFactory(repository);
    }
}
