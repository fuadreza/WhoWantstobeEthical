package io.github.fuadreza.whowantstobeethical.pertanyaan;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;

import io.github.fuadreza.whowantstobeethical.R;
import io.github.fuadreza.whowantstobeethical.data.DataSkor;
import io.github.fuadreza.whowantstobeethical.data.Skor;

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 17/08/2018.
 */
public class Question3Fragment extends Fragment implements View.OnClickListener{

    private Question4Fragment mQuestionFragment;
    private Button btnNext, btnPrev;
    private TextView tvSoal;
    private EditText etJawaban;

    private DataSkor ds;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_soal_dua, container, false);
        ds = Skor.ds;
        btnNext = view.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);

        btnPrev = view.findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(this);

        //Edit gambar
        ImageView iv1 = view.findViewById(R.id.iv_gbr1);
        DrawableImageViewTarget imageViewTarget = new DrawableImageViewTarget(iv1);
        Glide.with(this).load(R.raw.thinking_bulb).into(imageViewTarget);

        //Edit Soal
        tvSoal = view.findViewById(R.id.tv_soal);
        tvSoal.setText(R.string.soal3);

        etJawaban = view.findViewById(R.id.et_jawaban);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_next){
            //todo to Question3
            if(mQuestionFragment==null){
                mQuestionFragment = new Question4Fragment();
            }

            ds.setSoal3(etJawaban.getText().toString());

            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.layout_starter, mQuestionFragment, Question4Fragment.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        } else if (view.getId() == R.id.btn_prev){
            //todo to Question2
            getActivity().onBackPressed();
        }
    }
}