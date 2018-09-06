package io.github.fuadreza.whowantstobeethical.ukur;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.github.fuadreza.whowantstobeethical.R;
import io.github.fuadreza.whowantstobeethical.data.DataSkor;
import io.github.fuadreza.whowantstobeethical.data.Skor;

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 02/09/2018.
 */
public class LogEsai extends AppCompatActivity implements View.OnClickListener {

    private DataSkor ds;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_esai);

        ds = Skor.ds;

        // Toolbar title dan back button
        Toolbar toolbar = findViewById(R.id.toolbare);
        toolbar.setTitle("Jawaban Essai");
        setSupportActionBar(toolbar);

        TextView tvSoal1 = findViewById(R.id.tv_soal_1);
        TextView tvSoal2 = findViewById(R.id.tv_soal_2);
        TextView tvSoal3 = findViewById(R.id.tv_soal_3);
        TextView tvSoal4 = findViewById(R.id.tv_soal_4);

        TextView tvJawaban1 = findViewById(R.id.tv_jawaban_1);
        TextView tvJawaban2 = findViewById(R.id.tv_jawaban_2);
        TextView tvJawaban3 = findViewById(R.id.tv_jawaban_3);
        TextView tvJawaban4_1 = findViewById(R.id.tv_jawaban_4_1);
        TextView tvJawaban4_2 = findViewById(R.id.tv_jawaban_4_2);
        TextView tvJawaban4_3 = findViewById(R.id.tv_jawaban_4_3);
        TextView tvJawaban4_4 = findViewById(R.id.tv_jawaban_4_4);

        Button btnNext = findViewById(R.id.btn_next);

        tvSoal1.setText(R.string.soal1);
        tvSoal2.setText(R.string.soal2);
        tvSoal3.setText(R.string.soal3);
        tvSoal4.setText(R.string.soal3);

        tvJawaban1.setText(ds.getSoal1());
        tvJawaban2.setText(ds.getSoal2());
        tvJawaban3.setText(ds.getSoal3());
        tvJawaban4_1.setText(ds.getSoal4_1());
        tvJawaban4_2.setText(ds.getSoal4_2());
        tvJawaban4_3.setText(ds.getSoal4_3());
        tvJawaban4_4.setText(ds.getSoal4_4());

        btnNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent pindah = new Intent(LogEsai.this, LogSeekbar.class);
        startActivity(pindah);
    }
}
