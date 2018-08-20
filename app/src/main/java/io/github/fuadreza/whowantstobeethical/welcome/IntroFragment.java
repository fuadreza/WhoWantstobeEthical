package io.github.fuadreza.whowantstobeethical.welcome;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;

import io.github.fuadreza.whowantstobeethical.R;

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 16/08/2018.
 */
public class IntroFragment extends Fragment implements View.OnClickListener{

    private ImageView iv1, iv2;

    public IntroFragment(){
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.content_welcome, container, false);
        Button btnCategory = view.findViewById(R.id.btn_next);
        btnCategory.setOnClickListener(this);

        iv1 = view.findViewById(R.id.iv_gbr1);
        iv2 = view.findViewById(R.id.iv_gbr2);

        DrawableImageViewTarget imageViewTarget = new DrawableImageViewTarget(iv1);
        Glide.with(this).load(R.raw.thinking).into(imageViewTarget);

        imageViewTarget = new DrawableImageViewTarget(iv2);
        Glide.with(this).load(R.raw.diagram).into(imageViewTarget);

        return view;
    }

    @Override
    public void onClick(View view) {
        //Tombol next
        if (view.getId() == R.id.btn_next){
            //todo to Question1
            Intro2Fragment mFragment = new Intro2Fragment();
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.layout_starter, mFragment, Intro2Fragment.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
    }
}
