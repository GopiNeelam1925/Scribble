package com.suriyal.shailendra.recyclerviewdemo.logic;

import com.suriyal.shailendra.recyclerviewdemo.data.DataSourceInterface;
import com.suriyal.shailendra.recyclerviewdemo.data.ListItem;
import com.suriyal.shailendra.recyclerviewdemo.view.ViewInterface;

/**
 * Created by shailendra.suriyal
 */
public class Controller {

    private ViewInterface mViewInterface;
    private DataSourceInterface mDataSourceInterface;
    private Object mListFromDataSource;

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

    public void onListItemClicked(ListItem testItem) {

        mViewInterface.startDetailActivity(
                testItem.getDateAndTime(),
                testItem.getMessage(),
                testItem.getColorResource());
        return;
    }
}
