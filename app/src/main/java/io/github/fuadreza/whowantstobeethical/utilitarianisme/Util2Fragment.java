package io.github.fuadreza.whowantstobeethical.utilitarianisme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import io.github.fuadreza.whowantstobeethical.R;
import io.github.fuadreza.whowantstobeethical.data.DataSkor;
import io.github.fuadreza.whowantstobeethical.data.Skor;
import io.github.fuadreza.whowantstobeethical.deontologi.DeontologiActivity;

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 21/08/2018.
 */
public class Util2Fragment extends Fragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private Intent pindah;
    private DataSkor ds;

    public Util2Fragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_soal_seekbar, container, false);

        //Teks Soal
        TextView tvSoal = view.findViewById(R.id.tv_soal);
        tvSoal.setText(R.string.soal_util_2);

        ds = Skor.ds;

        //Seekbar
        SeekBar sbJawaban = view.findViewById(R.id.sb_jawaban);
        TextView tvMin = view.findViewById(R.id.tv_min);
        TextView tvMax = view.findViewById(R.id.tv_max);

        ds.setUtil_2(sbJawaban.getProgress());
        sbJawaban.setOnSeekBarChangeListener(this);


        tvMin.setText(R.string.min_util_2);
        tvMax.setText(R.string.max_util_2);

        //Button next
        Button btn = view.findViewById(R.id.btn_next);
        btn.setOnClickListener(this);
        btn.setVisibility(View.VISIBLE);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_next) {
            if (pindah == null) {
                pindah = new Intent(this.getContext(), DeontologiActivity.class);
            }
            startActivity(pindah);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        ds.setUtil_2(seekBar.getProgress());
        Toast.makeText(getActivity(), String.valueOf(seekBar.getProgress()), Toast.LENGTH_LONG).show();
//        Toast.makeText(getActivity(), String.valueOf(ds.getUtil_1()),Toast.LENGTH_LONG).show();
//        Toast.makeText(getActivity(), String.valueOf(ds.getUtil_2()),Toast.LENGTH_LONG).show();
    }
}
