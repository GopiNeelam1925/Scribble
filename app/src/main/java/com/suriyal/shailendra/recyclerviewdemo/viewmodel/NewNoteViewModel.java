package com.suriyal.shailendra.recyclerviewdemo.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;
import android.util.Log;

import com.suriyal.shailendra.recyclerviewdemo.data.Note;
import com.suriyal.shailendra.recyclerviewdemo.data.NoteRepository;
import com.suriyal.shailendra.recyclerviewdemo.networking.APIClient;
import com.suriyal.shailendra.recyclerviewdemo.networking.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shailendra.suriyal
 */
public class NewNoteViewModel extends ViewModel {

    private NoteRepository repository;

    NewNoteViewModel(NoteRepository repository) {
        this.repository = repository;
        mAPIInterface = APIClient.getClient().create(APIInterface.class);
    }

    private APIInterface mAPIInterface;
    /**
     * Attach our LiveData to the Database
     */
    public void addNewItemToDatabase(Note note){

        new AddItemTaskToDatabase().execute(note);
        new AddItemTaskToServerDatabase().execute(note);
    }

    private class AddItemTaskToServerDatabase extends AsyncTask<Note, Void, Void> {

        @Override
        protected Void doInBackground(Note... item) {
            Call<Note> call1 = mAPIInterface.createListItem(item[0]);
            call1.enqueue(new Callback<Note>() {
                @Override
                public void onResponse(Call<Note> call, Response<Note> response) {
                    Log.d(this.getClass().getCanonicalName(), "Item Successfully added Shailu");
                }

                @Override
                public void onFailure(Call<Note> call, Throwable t) {
                    Log.d(this.getClass().getCanonicalName(), "Item Successfully added Shailu");

                    call.cancel();
                }
            });
            return null;
        }
    }


    private class AddItemTaskToDatabase extends AsyncTask<Note, Void, Void> {

        @Override
        protected Void doInBackground(Note... item) {
            repository.insertListItem(item[0]);
            return null;
        }
    }
}

