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

    private final int[] colors = {
            R.color.RED,
            R.color.GREEN,
            R.color.BLUE,
            R.color.YELLOW,
    };

    public FakeDataSource() {

    }

    @Override
    public List<ListItem> getListOfData() {
        ArrayList<ListItem> listOfData = new ArrayList<>();
        int randOne ;
        int randTwo ;
        int randThree;

        Random random = new Random();

        for (int i = 0; i< 12; i++) {

            randOne = random.nextInt(4);
            randTwo = random.nextInt(4);
            randThree = random.nextInt(4);
            ListItem listItem = new ListItem(datesAndTime[randOne], messages[randTwo], colors[randThree]);
            listOfData.add(listItem);
        }
        return listOfData;
    }
}
