package com.example.android.rssreader;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public static String EXTRA_URL = "Url";

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rssitem_detail,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle != null){
            String link = bundle.getString(EXTRA_URL);
            setText(link);
        }
    }

    public void setText(String url) {
        TextView view = (TextView)getView().findViewById(R.id.detailsText);
        view.setText(url);

    }
}
