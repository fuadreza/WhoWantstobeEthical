package io.github.fuadreza.whowantstobeethical.utilitarianisme;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;

import io.github.fuadreza.whowantstobeethical.R;

public class UtilitarianismeActivity extends AppCompatActivity {

    private UtilitarianismeFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_seekbar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Utilitarianisme");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Text View
        TextView tvDesc = findViewById(R.id.tv_deskripsi);

        tvDesc.setText(R.string.util_des);

        //Edit gambar
        ImageView iv = findViewById(R.id.image_1);
        DrawableImageViewTarget imageViewTarget = new DrawableImageViewTarget(iv);
        Glide.with(this).load(R.raw.family).into(imageViewTarget);

        // Find the view pager that will allow the user to swipe between fragment
        ViewPager viewPager = findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        if (adapter == null) {
            adapter = new UtilitarianismeFragmentPagerAdapter(this, getSupportFragmentManager());

            // Set the adapter onto the view pager
            viewPager.setAdapter(adapter);

            // Give the TabLayout the ViewPager
            TabLayout tabLayout = findViewById(R.id.sliding_tabs);
            tabLayout.setupWithViewPager(viewPager);
        }

    }
}
