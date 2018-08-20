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
import io.github.fuadreza.whowantstobeethical.pertanyaan.Question1Fragment;

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 20/08/2018.
 */
public class Intro2Fragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.content_welcome_dua, container, false);
        Button btnCategory = view.findViewById(R.id.btn_next);
        btnCategory.setOnClickListener(this);

        ImageView iv1 = view.findViewById(R.id.iv_gbr1);
        ImageView iv2 = view.findViewById(R.id.iv_gbr2);

        DrawableImageViewTarget imageViewTarget = new DrawableImageViewTarget(iv1);
        Glide.with(this).load(R.raw.thinking).into(imageViewTarget);

        imageViewTarget = new DrawableImageViewTarget(iv2);
        Glide.with(this).load(R.raw.diagram).into(imageViewTarget);

        return view;
    }

    @Override
    public void onClick(View view) {
//Tombol next
        if (view.getId() == R.id.btn_next) {
            //todo to Question1
            Question1Fragment mQuestionFragment = new Question1Fragment();
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.layout_starter, mQuestionFragment, Question1Fragment.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
    }
}
