package com.suriyal.shailendra.recyclerviewdemo.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.suriyal.shailendra.recyclerviewdemo.data.NoteRepository;

/**
 * Created by shailendra.suriyal
 */
public class CustomViewModelFactory implements ViewModelProvider.Factory {

    private final NoteRepository mListItemRepository;

    public CustomViewModelFactory(NoteRepository listItemRepository) {
        mListItemRepository = listItemRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(NoteCollectionViewModel.class)) {

            return (T) new NoteCollectionViewModel(mListItemRepository);

        } else if(modelClass.isAssignableFrom(NoteViewModel.class)) {

            return (T) new NoteViewModel(mListItemRepository);

        } else if(modelClass.isAssignableFrom(NewNoteViewModel.class)) {

            return (T) new NewNoteViewModel(mListItemRepository);

        } else {

            throw new IllegalArgumentException("viewModel not present");

        }
    }

}
