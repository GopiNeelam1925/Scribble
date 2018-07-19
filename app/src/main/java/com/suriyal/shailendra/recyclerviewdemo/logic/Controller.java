package com.suriyal.shailendra.recyclerviewdemo.logic;

import android.view.View;

import com.suriyal.shailendra.recyclerviewdemo.data.DataSourceInterface;
import com.suriyal.shailendra.recyclerviewdemo.data.ListItem;
import com.suriyal.shailendra.recyclerviewdemo.view.ViewInterface;

/**
 * Created by shailendra.suriyal
 */
public class Controller {

    private ViewInterface mViewInterface;
    private DataSourceInterface mDataSourceInterface;

    private  ListItem temporaryListItem;
    private int temporaryListItemPosition;

    public Controller(ViewInterface viewInterface, DataSourceInterface dataSourceInterface) {
        mViewInterface = viewInterface;
        mDataSourceInterface = dataSourceInterface;

        getListFromDataSource();
    }

    public void getListFromDataSource() {
        mViewInterface.setupAdapterAndView(
                mDataSourceInterface.getListOfData()
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
        ListItem listItem = mDataSourceInterface.createNewListItem();

        mViewInterface.addNewListItemToView(listItem);
    }

    public void onListItemSwiped(int position, ListItem listItem) {
        mDataSourceInterface.deleteListItem(listItem);
        mViewInterface.deleteListItemAt(position);

        temporaryListItem = listItem;
        temporaryListItemPosition = position;

        mViewInterface.showUndoSnackBar();
    }

    public void onUndoConfirmed() {
        if (temporaryListItem != null) {
            //
            mDataSourceInterface.insertListItemAt(temporaryListItemPosition);
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
