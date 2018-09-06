package io.github.fuadreza.whowantstobeethical.ukur;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import io.github.fuadreza.whowantstobeethical.R;
import io.github.fuadreza.whowantstobeethical.data.DataSkor;
import io.github.fuadreza.whowantstobeethical.data.Skor;

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 02/09/2018.
 */
public class LogSeekbar extends AppCompatActivity implements View.OnClickListener {

    private DataSkor ds;

    private SeekBar sbUtil1, sbUtil2, sbDeon1, sbDeon2, sbRight1, sbRight2, sbRight3, sbRight4, sbVirtue1, sbVirtue2, sbTeonom2;
    private RadioGroup rgTeonom;

    private Button btnClose;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_seekbar);
        ds = Skor.ds;

        // Toolbar title dan back button
        Toolbar toolbar = findViewById(R.id.toolbare);
        toolbar.setTitle("Jawaban Seekbar");
        setSupportActionBar(toolbar);

        sbUtil1 = findViewById(R.id.sb_jawaban_util_1);
        sbUtil2 = findViewById(R.id.sb_jawaban_util_2);
        sbDeon1 = findViewById(R.id.sb_jawaban_deon_1);
        sbDeon2 = findViewById(R.id.sb_jawaban_deon_2);
        sbRight1 = findViewById(R.id.sb_jawaban_right_1);
        sbRight2 = findViewById(R.id.sb_jawaban_right_2);
        sbRight3 = findViewById(R.id.sb_jawaban_right_3);
        sbRight4 = findViewById(R.id.sb_jawaban_right_4);
        sbVirtue1 = findViewById(R.id.sb_jawaban_virtue_1);
        sbVirtue2 = findViewById(R.id.sb_jawaban_virtue_2);
        sbTeonom2 = findViewById(R.id.sb_jawaban_teonom_2);

        sbUtil1.setEnabled(false);
        sbUtil2.setEnabled(false);
        sbDeon1.setEnabled(false);
        sbDeon2.setEnabled(false);
        sbRight1.setEnabled(false);
        sbRight2.setEnabled(false);
        sbRight3.setEnabled(false);
        sbRight4.setEnabled(false);
        sbVirtue1.setEnabled(false);
        sbVirtue2.setEnabled(false);
        sbTeonom2.setEnabled(false);

        sbUtil1.setProgress(ds.getUtil_1());
        sbUtil2.setProgress(ds.getUtil_2());
        sbDeon1.setProgress(ds.getDeon_1());
        sbDeon2.setProgress(ds.getDeon_2());
        sbRight1.setProgress(ds.getRight_1());
        sbRight2.setProgress(ds.getRight_2());
        sbRight3.setProgress(ds.getRight_3());
        sbRight4.setProgress(ds.getRight_4());
        sbVirtue1.setProgress(ds.getVirtue_1());
        sbVirtue2.setProgress(ds.getVirtue_2());
        sbTeonom2.setProgress(ds.getTeonom_2());

        rgTeonom = findViewById(R.id.radio_group_soal);
        rgTeonom.getChildAt(0).setEnabled(false);
        rgTeonom.getChildAt(1).setEnabled(false);

        if (ds.getTeonom_1() == 1) {
            rgTeonom.check(R.id.red);
        } else {
            rgTeonom.check(R.id.green);
        }

        btnClose = findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent pindah = new Intent(LogSeekbar.this, HasilActivity.class);
        pindah.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(pindah);
    }
}
