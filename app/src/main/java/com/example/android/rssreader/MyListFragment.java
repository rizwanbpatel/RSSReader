package com.example.android.rssreader;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyListFragment extends Fragment {

    private OnItemSelectedListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rsslist_overview,container,false);
        Button updateButton = (Button)view.findViewById(R.id.updateButton);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("fake");
            }
        });

        return view;

    }

    private void updateDetail(String fake) {
        String newTime = String.valueOf(System.currentTimeMillis());
        listener.onRssItemSelected(newTime);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnItemSelectedListener){
            listener = (OnItemSelectedListener)context;
        }else{
            throw new ClassCastException(context.toString()+ " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    public interface OnItemSelectedListener{
        void onRssItemSelected(String link);
    }

}
