package parker.david.labs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListItemFragment extends Fragment {

    private  static  final  String ARG_INDEX = "index";

    private  int mIndex;

    public  int getShownIndex() {
        return  mIndex;
    }


    public ListItemFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ListItemFragment newInstance(int index) {
        ListItemFragment fragment = new ListItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mIndex = getArguments().getInt(ARG_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i(this.getClass().getSimpleName() + " Observer", "onCreateView");
        View inflatedView = inflater.inflate(R.layout.fragment_list_item,container,false);
        TextView text = inflatedView.findViewById(R.id.listItemTextView);
        text.setText(DummyData.DATA_CONTENT[mIndex]);
        return inflatedView;
    }
}