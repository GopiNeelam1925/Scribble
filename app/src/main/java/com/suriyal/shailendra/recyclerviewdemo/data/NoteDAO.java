package com.suriyal.shailendra.recyclerviewdemo.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by shailendra.suriyal
 */
@Dao
public interface NoteDAO {

    @Query("SELECT * FROM Note")
    LiveData<List<Note>> getNotes();

    @Query("SELECT * FROM Note WHERE mNoteId = :itemId")
    LiveData<Note> getNoteById(String itemId);

    @Insert(onConflict = REPLACE)
    Long insertNote(Note note);

    @Delete
    void deleteNote(Note note);


}
