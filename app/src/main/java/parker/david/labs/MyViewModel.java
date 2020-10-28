package parker.david.labs;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class MyViewModel extends AndroidViewModel {
    private LiveData<ArrayList<Item>> mItems;
    private LiveData<Item> mSelectedItem;
    private ItemsRepository mItemsRepository;
    private int mSelectedIndex;

    public MyViewModel(@NonNull Application pApplication){
        super(pApplication);
        mItemsRepository = ItemsRepository.getInstance(getApplication());
    }
/*
    private  void  generateItems() {
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("First","Link1","01/11/19","blah blah 1"));
        items.add(new Item("Second","Link2","02/11/19","blah blah 2"));
        items.add(new Item("Third","Link3","03/11/19","blah blah 3"));
        items.add(new Item("Fourth","Link4","04/11/19","blah blah 4"));
        items.add(new Item("Fifth","Link5","05/11/19","blah blah 5"));
        mItems.setValue(items);
    }*/

    public LiveData<ArrayList<Item>> getItems(){
        if (mItems == null){
            mItems = mItemsRepository.getItems();
        }
        return mItems;
    }

    public LiveData<Item> getItem(int pItemIndex) {
        return mItemsRepository.getItem(pItemIndex);
    }

    public void  selectItem(int pIndex){
        if(pIndex != mSelectedIndex || mSelectedItem == null){
        mSelectedIndex = pIndex;
        mSelectedItem = getItem(mSelectedIndex);

    }}

    public LiveData<Item> getSelectedItem(){
        return mSelectedItem;
    }
}
