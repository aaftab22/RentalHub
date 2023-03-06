package com.example.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class product_page_desc_adapter extends FragmentPagerAdapter {
    private int totalTabs;
    public product_page_desc_adapter(@NonNull FragmentManager fm,int totalTabs) {
        super(fm);
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                product_desc_fragment product_description_fragment = new product_desc_fragment();
                return product_description_fragment;
            case 1:
                depositeFragment depositeFragment = new depositeFragment();
                return depositeFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
