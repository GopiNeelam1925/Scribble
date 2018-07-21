package com.suriyal.shailendra.recyclerviewdemo.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by shailendra.suriyal
 */
@Database(entities = {Note.class},version = 2)
public abstract class NoteDatabase extends RoomDatabase {

    public abstract NoteDAO mNoteDAO();
}
