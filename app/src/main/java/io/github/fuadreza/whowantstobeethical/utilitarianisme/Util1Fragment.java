package io.github.fuadreza.whowantstobeethical.utilitarianisme;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import io.github.fuadreza.whowantstobeethical.R;
import io.github.fuadreza.whowantstobeethical.data.*;


/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 21/08/2018.
 */
public class Util1Fragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    private SeekBar sbJawaban;
    private DataSkor ds;

    public Util1Fragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_soal_seekbar, container, false);

        ds = Skor.ds;

        //Teks Soal
        TextView tvSoal = view.findViewById(R.id.tv_soal);
        tvSoal.setText(R.string.soal_util_1);

        //Seekbar
        sbJawaban = view.findViewById(R.id.sb_jawaban);
        sbJawaban.setOnSeekBarChangeListener(this);
        TextView tvMin = view.findViewById(R.id.tv_min);
        TextView tvMax = view.findViewById(R.id.tv_max);

        ds.setUtil_1(sbJawaban.getProgress());

        tvMin.setText(R.string.min_util_1);
        tvMax.setText(R.string.max_util_1);

        return view;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        ds.setUtil_1(seekBar.getProgress());
        Toast.makeText(getActivity(), String.valueOf(seekBar.getProgress()), Toast.LENGTH_LONG).show();
    }
}
