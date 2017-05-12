package com.example.android.rssreader;

import android.app.Activity;
import android.os.Bundle;

public class RssfeedActivity extends Activity implements MyListFragment.OnItemSelectedListener{
    @Override
    public void onRssItemSelected(String link) {
        DetailFragment fragment = (DetailFragment)getFragmentManager().findFragmentById(R.id.detailFragment);
        fragment.setText(link);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
