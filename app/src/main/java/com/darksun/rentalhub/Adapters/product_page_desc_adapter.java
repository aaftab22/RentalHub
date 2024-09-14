package com.darksun.rentalhub.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.darksun.rentalhub.depositeFragment;
import com.darksun.rentalhub.product_desc_fragment;

public class product_page_desc_adapter extends FragmentPagerAdapter {
    private final int totalTabs;
    public product_page_desc_adapter(@NonNull FragmentManager fm,int totalTabs) {
        super(fm);
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new product_desc_fragment();
            case 1:
                return new depositeFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
