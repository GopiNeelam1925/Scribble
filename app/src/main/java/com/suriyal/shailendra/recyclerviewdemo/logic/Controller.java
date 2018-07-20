package com.suriyal.shailendra.recyclerviewdemo.logic;

import android.view.View;

import com.suriyal.shailendra.recyclerviewdemo.data.ListItemDAO;
import com.suriyal.shailendra.recyclerviewdemo.data.ListItem;
import com.suriyal.shailendra.recyclerviewdemo.list.ViewInterface;

/**
 * Created by shailendra.suriyal
 */
public class Controller {

    private ViewInterface mViewInterface;
    private ListItemDAO mListItemDAO;

    private  ListItem temporaryListItem;
    private int temporaryListItemPosition;

    public Controller(ViewInterface viewInterface, ListItemDAO listItemDAO) {
        mViewInterface = viewInterface;
        mListItemDAO = listItemDAO;

        getListFromDataSource();
    }

    public void getListFromDataSource() {
        mViewInterface.setupAdapterAndView(
                mListItemDAO.getListItems()
        );
        return;
    }

    public void onListItemClicked(ListItem testItem, View viewRoot) {

        mViewInterface.startDetailActivity(
                testItem.getDateAndTime(),
                testItem.getMessage(),
                testItem.getColorResource(),
                viewRoot);

        return;
    }

    public void createNewListItem() {
        ListItem listItem = mListItemDAO.createNewListItem();

        mViewInterface.addNewListItemToView(listItem);
    }

    public void onListItemSwiped(int position, ListItem listItem) {
        mListItemDAO.deleteListItem(listItem);
        mViewInterface.deleteListItemAt(position);

        temporaryListItem = listItem;
        temporaryListItemPosition = position;

        mViewInterface.showUndoSnackBar();
    }

    public void onUndoConfirmed() {
        if (temporaryListItem != null) {
            //
            mListItemDAO.insertListItemAt(temporaryListItemPosition);
            mViewInterface.insertListItemAt(temporaryListItemPosition,temporaryListItem);
            temporaryListItem = null;
            temporaryListItemPosition = 0;
        }
    }

    public void onSnackbarTimeOut() {
        temporaryListItem = null;
        temporaryListItemPosition = 0;
    }
}
