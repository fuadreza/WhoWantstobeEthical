package io.github.fuadreza.whowantstobeethical.teonom;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import io.github.fuadreza.whowantstobeethical.R;
import io.github.fuadreza.whowantstobeethical.data.DataSkor;
import io.github.fuadreza.whowantstobeethical.data.Skor;

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 24/08/2018.
 */
public class Teonom1Fragment extends Fragment implements RadioGroup.OnCheckedChangeListener {

    private DataSkor ds;

    public Teonom1Fragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_soal_radio, container, false);
        ds = Skor.ds;

        //Teks Soal
        TextView tvSoal = view.findViewById(R.id.tv_soal);
        tvSoal.setText(R.string.soal_teonom_1);

        //Radio
        RadioGroup rg = view.findViewById(R.id.radio_group_soal);
        rg.check(R.id.green);

        rg.setOnCheckedChangeListener(this);
        ds.setTeonom_1(10);

        return view;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.red:
                ds.setTeonom_1(1);
                break;
            case R.id.green:
                ds.setTeonom_1(10);
                break;
            default:
                break;
        }
        Toast.makeText(getActivity(), String.valueOf(ds.getTeonom_1()), Toast.LENGTH_LONG).show();
    }
}
