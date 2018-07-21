package com.suriyal.shailendra.recyclerviewdemo;

import com.suriyal.shailendra.recyclerviewdemo.data.ListItemDAO;
import com.suriyal.shailendra.recyclerviewdemo.data.Note;
import com.suriyal.shailendra.recyclerviewdemo.logic.Controller;
import com.suriyal.shailendra.recyclerviewdemo.list.ViewInterface;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ControllerUnitTest {

    @Mock
    ListItemDAO mListItemDAO;

    @Mock
    ViewInterface mViewInterface;

    Controller mController;
    private static final Note testItem = new Note("6:30AM","H3llo",R.color.RED);

    @Before
    public void setUpTest() {
        MockitoAnnotations.initMocks(this);
        mController = new Controller(mViewInterface, mListItemDAO);
    }

    @Test
    public void onGetListDataSuccessful() {
        //Set up any data we need for the test
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(testItem);

        //Set up our mocjs to return the data we want
        Mockito.when(mListItemDAO.getListItems()).thenReturn(notes);

        //Call the method(Unit) we are testing
        mController.getListFromDataSource();

        //Check how the tested class responds to the data it receives

        Mockito.verify(mViewInterface).setupAdapterAndView(notes);
    }

    @Test
    public  void onListItemClicked() {
        mController.onListItemClicked(testItem);

        Mockito.verify(mViewInterface).startDetailActivity(
                testItem.getNoteId(),
                testItem.getMessage(),
                testItem.getColorResource());
    }
}
