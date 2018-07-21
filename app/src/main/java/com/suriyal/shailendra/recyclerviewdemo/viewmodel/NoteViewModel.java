package com.suriyal.shailendra.recyclerviewdemo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.suriyal.shailendra.recyclerviewdemo.data.Note;
import com.suriyal.shailendra.recyclerviewdemo.data.NoteRepository;

/**
 * Created by shailendra.suriyal
 */
public class NoteViewModel extends ViewModel {

    private NoteRepository repository;

    NoteViewModel(NoteRepository repository) {
        this.repository = repository;
    }

    public LiveData<Note> getListItemById(String itemId){
        return repository.getListItemBy(itemId);
    }

}
