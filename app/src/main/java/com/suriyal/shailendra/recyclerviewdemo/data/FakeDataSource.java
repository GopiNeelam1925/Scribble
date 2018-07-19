package com.suriyal.shailendra.recyclerviewdemo.data;

import com.suriyal.shailendra.recyclerviewdemo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by shailendra.suriyal
 */
public class FakeDataSource implements DataSourceInterface{

    private static  final int SIZE_OF_COLLECTION = 12;
    private Random mRandom;

    private final  String[] datesAndTime = {
            "6:30AM",
            "9:30AM",
            "11:30AM",
            "00:30AM",
    };

    private final  String[] messages = {
            "HI",
            "H3llo",
            "How",
            "are you"
    };

    private final int[] drawables = {
            R.drawable.red_drawable,
            R.drawable.green_drawable,
            R.drawable.blue_drawable,
            R.drawable.yellow_drawable
    };

    public FakeDataSource() {
        mRandom = new Random();

    }

    @Override
    public List<ListItem> getListOfData() {
        ArrayList<ListItem> listOfData = new ArrayList<>();

        for (int i = 0; i< 12; i++) {
            listOfData.add(createNewListItem());
        }
        return listOfData;
    }

    @Override
    public ListItem createNewListItem() {
        int randOne ;
        int randTwo ;
        int randThree;
        randOne = mRandom.nextInt(4);
        randTwo = mRandom.nextInt(4);
        randThree = mRandom.nextInt(4);
        ListItem listItem = new ListItem(datesAndTime[randOne], messages[randTwo], drawables[randThree]);
        return  listItem;
    }

    @Override
    public void deleteListItem(ListItem listItem) {

    }

    @Override
    public void insertListItemAt(int temporaryListItemPosition) {

    }
}
