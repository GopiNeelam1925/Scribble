package com.suriyal.shailendra.recyclerviewdemo.list;

import android.view.View;

import com.suriyal.shailendra.recyclerviewdemo.data.Note;

import java.util.List;

/**
 * Created by shailendra.suriyal
 */
public interface ViewInterface {

    void startDetailActivity(String dateAndTime, String message, int colorResource, View viewRoot);

    void setupAdapterAndView(List<Note> listData);

    void addNewListItemToView(Note note);

    void deleteListItemAt(int position);

    void showUndoSnackBar();

    void insertListItemAt(int temporaryListItemPosition, Note temporaryNote);
}
