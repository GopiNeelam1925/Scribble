package com.suriyal.shailendra.recyclerviewdemo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;
import android.util.Log;

import com.suriyal.shailendra.recyclerviewdemo.data.Note;
import com.suriyal.shailendra.recyclerviewdemo.data.NoteRepository;
import com.suriyal.shailendra.recyclerviewdemo.networking.APIClient;
import com.suriyal.shailendra.recyclerviewdemo.networking.APIInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shailendra.suriyal
 */
public class NoteCollectionViewModel extends ViewModel {

    private NoteRepository mListItemRepository;
    private APIInterface mAPIInterface;

    public NoteCollectionViewModel(NoteRepository listItemRepository) {
        mListItemRepository = listItemRepository;
        mAPIInterface = APIClient.getClient().create(APIInterface.class);
    }

    public LiveData<List<Note>> getListItems(){
        return mListItemRepository.getListOfData();
    }

    public void deleteListItem(Note note){
        DeleteItemTask deleteItemTask = new DeleteItemTask();
        DeleteItemTaskFromServer deleteItemTaskFromServer = new DeleteItemTaskFromServer();

        deleteItemTask.execute(note);
        deleteItemTaskFromServer.execute(note);
    }

    private class DeleteItemTaskFromServer extends AsyncTask<Note, Void, Void> {

        @Override
        protected Void doInBackground(Note... note) {
            Call<Void> responseCall = mAPIInterface.deleteListItem(note[0].getId());
            responseCall.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    Log.d("Shailu","Deletion successfull");
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Log.d("Shailu","Deletion unsuccessfull");
                }
            });

            return null;
        }
    }

    private class DeleteItemTask extends AsyncTask<Note, Void, Void> {

        @Override
        protected Void doInBackground(Note... note) {
            mListItemRepository.deleteListItem(note[0]);
            return null;
        }
    }
}
