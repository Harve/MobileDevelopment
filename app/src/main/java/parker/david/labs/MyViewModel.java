package parker.david.labs;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class MyViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Item>> mItems;
    private MutableLiveData<Item> mSelectedItem;
    private int mSelectedIndex;

    public MyViewModel(@NonNull Application pApplication){
        super(pApplication);
        getItems();
    }

    private  void  generateItems() {
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("First","Link1","01/11/19","blah blah 1"));
        items.add(new Item("Second","Link2","02/11/19","blah blah 2"));
        items.add(new Item("Third","Link3","03/11/19","blah blah 3"));
        items.add(new Item("Fourth","Link4","04/11/19","blah blah 4"));
        items.add(new Item("Fifth","Link5","05/11/19","blah blah 5"));
        mItems.setValue(items);
    }

    public LiveData<ArrayList<Item>> getItems(){
        if (mItems == null){
            mItems = new MutableLiveData<ArrayList<Item>>();
            generateItems();
            selectItem(0);
        }
        return mItems;
    }

    public void  selectItem(int pIndex){
        mSelectedIndex = pIndex;
        Item selectedItem = mItems.getValue().get(mSelectedIndex);
        mSelectedItem = new MutableLiveData<Item>();
        mSelectedItem.setValue(selectedItem);
    }

    public LiveData<Item> getSelectedItem(){
        if(mSelectedItem == null){
            mSelectedItem = new MutableLiveData<Item>();
            selectItem(mSelectedIndex);
        }
        return mSelectedItem;
    }
}
