package com.suriyal.shailendra.recyclerviewdemo.data;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by shailendra.suriyal
 */
public class NoteRepository {


    private final NoteDAO mNoteDAO;

    @Inject
    public NoteRepository(NoteDAO noteDAO){
        this.mNoteDAO = noteDAO;
    }

    public LiveData<List<Note>> getListOfData() {
        return mNoteDAO.getNotes();
    }

    public LiveData<Note> getListItemBy(String itemId){
        return mNoteDAO.getNoteById(itemId);
    }

    public void insertListItem(Note note) {
         mNoteDAO.insertNote(note);
    }

    public void deleteListItem(Note note){
        mNoteDAO.deleteNote(note);
    }

}
