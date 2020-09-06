package com.example.immortalandroidtask;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.immortalandroidtask.view.DashboardFragment;

public class FragmentCollectionAdatpor extends FragmentPagerAdapter {
    public FragmentCollectionAdatpor(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        DashboardFragment fragment = new DashboardFragment();
        Bundle bundle = new Bundle();
        position = position+1;
        bundle.putString("hello messgage",""+position);
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    public int getCount() {
        return 5;
    }
}
