package com.suriyal.shailendra.recyclerviewdemo.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.suriyal.shailendra.recyclerviewdemo.data.ListItemRepository;

/**
 * Created by shailendra.suriyal
 */
public class CustomViewModelFactory implements ViewModelProvider.Factory {

    private final ListItemRepository mListItemRepository;

    public CustomViewModelFactory(ListItemRepository listItemRepository) {
        mListItemRepository = listItemRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(ListItemCollectionViewModel.class)) {

            return (T) new ListItemCollectionViewModel(mListItemRepository);

        } else if(modelClass.isAssignableFrom(ListItemViewModel.class)) {

            return (T) new ListItemCollectionViewModel(mListItemRepository);

        } else if(modelClass.isAssignableFrom(NewListItemViewModel.class)) {

            return (T) new NewListItemViewModel(mListItemRepository);

        } else {

            throw new IllegalArgumentException("viewModel not present");

        }
    }

}
