package com.example.android.rssreader;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class RssfeedActivity extends Activity implements MyListFragment.OnItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Two Pane Mode : "+getResources().getBoolean(R.bool.twoPaneMode));
        if(getResources().getBoolean(R.bool.twoPaneMode)){
             return;
        }

        if(savedInstanceState != null){
            getFragmentManager().executePendingTransactions();
            Fragment fragmentById = getFragmentManager().findFragmentById(R.id.fragment_container);
            if(fragmentById != null){
                getFragmentManager().beginTransaction().remove(fragmentById).commit();
            }
        }
        MyListFragment listFragment = new MyListFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragment_container,listFragment).commit();
    }

    @Override
    public void onRssItemSelected(String link) {
        System.out.println("ors Two Pane Mode : "+getResources().getBoolean(R.bool.twoPaneMode));
        if(getResources().getBoolean(R.bool.twoPaneMode)){
            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detailFragment);
            detailFragment.setText(link);
        }else{
            DetailFragment detailFragment = new DetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString(DetailFragment.EXTRA_URL, link);
            detailFragment.setArguments(bundle);

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,detailFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }


    }
}
