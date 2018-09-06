package io.github.fuadreza.whowantstobeethical.right;

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
import io.github.fuadreza.whowantstobeethical.virtue.VirtueActivity;

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 24/08/2018.
 */
public class Right4Fragment extends Fragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private Intent pindah;
    private DataSkor ds;

    public Right4Fragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_soal_seekbar, container, false);
        ds = Skor.ds;

        //Teks Soal
        TextView tvSoal = view.findViewById(R.id.tv_soal);
        tvSoal.setText(R.string.soal_right_4);

        //Seekbar
        SeekBar sbJawaban = view.findViewById(R.id.sb_jawaban);
        TextView tvMin = view.findViewById(R.id.tv_min);
        TextView tvMax = view.findViewById(R.id.tv_max);

        sbJawaban.setOnSeekBarChangeListener(this);
        ds.setRight_4(sbJawaban.getProgress());
        tvMin.setText(R.string.min_right_3);
        tvMax.setText(R.string.max_right_3);

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
                pindah = new Intent(this.getContext(), VirtueActivity.class);
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
        ds.setRight_4(seekBar.getProgress());
        Toast.makeText(getActivity(), String.valueOf(seekBar.getProgress()), Toast.LENGTH_LONG).show();
    }
}
