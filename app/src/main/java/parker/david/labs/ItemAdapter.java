package parker.david.labs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {
    private Context mContext;
    private List<Item> mItemList;

    public ItemAdapter(@NonNull Context pContext, ArrayList<Item> pList){
        super(pContext,0,pList);
        mContext = pContext;
        mItemList = pList;
    }

    @Override
    public  View getView(int position, View convertView,ViewGroup parent){
        View listItem = convertView;
        if(listItem==null){
            listItem = LayoutInflater.from(mContext).inflate(R.layout.item_layout,parent,false);
        }
        Item currentItem = mItemList.get(position);

        TextView name = (TextView) listItem.findViewById(R.id.textView_title);
        name.setText(currentItem.getTitle());

        TextView release = (TextView) listItem.findViewById(R.id.textView_date);
        name.setText(currentItem.getDate());

        return listItem;
    }
}
