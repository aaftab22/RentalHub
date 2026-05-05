package com.darksun.rentalhub;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.darksun.rentalhub.Adapters.product_page_desc_adapter;
import com.darksun.rentalhub.Adapters.product_page_image_adapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class productPage_Activity extends AppCompatActivity {

    private ViewPager productImageViewPager;
    private TabLayout viewPagerIndicator;
    FloatingActionButton wishlist_btn;
    private ViewPager productDescriptionViewPager;
    private TabLayout productDescriptionTabLayout;
    TextView productName;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);
        getSupportActionBar().hide();
        productImageViewPager = findViewById(R.id.prodyct_images_viewpager);
        viewPagerIndicator = findViewById(R.id.viewPager_Indicator);
        toolbar = findViewById(R.id.toolbar_ID);
        wishlist_btn = findViewById(R.id.floatingActionBtn_ID);
        productName = findViewById(R.id.product_name_ID);


        productName.setText(getIntent().getStringExtra("name"));


        productDescriptionTabLayout = findViewById(R.id.product_details_tablayout);
        productDescriptionViewPager = findViewById(R.id.products_details_viewPager2);


//        String imageurl =  getIntent().getStringExtra("pImage");

        List<Integer> productImages = new ArrayList<>();
        productImages.add(R.drawable.iphone1);
        productImages.add(R.drawable.iphone2);
        productImages.add(R.drawable.iphone3);
        productImages.add(R.drawable.iphone4);

        product_page_image_adapter product_images_adapter = new product_page_image_adapter(productImages);
        productImageViewPager.setAdapter(product_images_adapter);
        viewPagerIndicator.setupWithViewPager(productImageViewPager,true);
        productDescriptionViewPager.setAdapter(new product_page_desc_adapter(getSupportFragmentManager(),productDescriptionTabLayout.getTabCount()));
        productDescriptionViewPager.addOnAdapterChangeListener(new ViewPager.OnAdapterChangeListener() {
            @Override
            public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter oldAdapter, @Nullable PagerAdapter newAdapter) {
                new TabLayout.TabLayoutOnPageChangeListener(productDescriptionTabLayout);
                productDescriptionTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        productDescriptionViewPager.setCurrentItem(tab.getPosition());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_cart_icon,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.search_item_ID)
        {
            Toast.makeText(this, "This is search", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.cart_item_ID)
        {
            Toast.makeText(this, "This is cart", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item) ;
    }
}