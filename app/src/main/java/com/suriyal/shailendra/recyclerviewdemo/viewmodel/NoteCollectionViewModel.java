package com.suriyal.shailendra.recyclerviewdemo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.suriyal.shailendra.recyclerviewdemo.data.Note;
import com.suriyal.shailendra.recyclerviewdemo.data.NoteRepository;

import java.util.List;

/**
 * Created by shailendra.suriyal
 */
public class NoteCollectionViewModel extends ViewModel {

    private NoteRepository mListItemRepository;


    public NoteCollectionViewModel(NoteRepository listItemRepository) {
        mListItemRepository = listItemRepository;
    }

    public LiveData<List<Note>> getListItems(){
        return mListItemRepository.getListOfData();
    }

    public void deleteListItem(Note note){
        DeleteItemTask deleteItemTask = new DeleteItemTask();
        deleteItemTask.execute(note);
    }

    private class DeleteItemTask extends AsyncTask<Note, Void, Void> {

        @Override
        protected Void doInBackground(Note... note) {
            mListItemRepository.deleteListItem(note[0]);
            return null;
        }
    }
}
