package io.github.fuadreza.whowantstobeethical.pertanyaan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import io.github.fuadreza.whowantstobeethical.utilitarianisme.UtilitarianismeActivity;

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 17/08/2018.
 */
public class Question4Fragment extends Fragment implements View.OnClickListener {

    private Button btnNext, btnPrev;
    private TextView tvSoal;
    private EditText etJawaban1, etJawaban2, etJawaban3, etJawaban4;

    private DataSkor ds;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_soal_empat, container, false);
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
        tvSoal.setText(R.string.soal4);

        etJawaban1 = view.findViewById(R.id.input_jawaban_1);
        etJawaban2 = view.findViewById(R.id.input_jawaban_2);
        etJawaban3 = view.findViewById(R.id.input_jawaban_3);
        etJawaban4 = view.findViewById(R.id.input_jawaban_4);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_prev){
            //todo to Question1
            getActivity().onBackPressed();
        } else if (view.getId() == R.id.btn_next){
            //todo to Util

            ds.setSoal4_1(etJawaban1.getText().toString());
            ds.setSoal4_2(etJawaban2.getText().toString());
            ds.setSoal4_3(etJawaban3.getText().toString());
            ds.setSoal4_4(etJawaban4.getText().toString());

            Intent pindah = new Intent(this.getContext(), UtilitarianismeActivity.class);
            startActivity(pindah);
        }
    }
}
