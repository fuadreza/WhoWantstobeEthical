package io.github.fuadreza.whowantstobeethical.ukur;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;

import io.github.fuadreza.whowantstobeethical.R;
import io.github.fuadreza.whowantstobeethical.data.DataSkor;
import io.github.fuadreza.whowantstobeethical.data.Skor;
import io.github.fuadreza.whowantstobeethical.welcome.WelcomeActivity;

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 02/09/2018.
 */
public class HasilActivity extends AppCompatActivity implements View.OnClickListener {

    private DataSkor ds;
    private int skor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        ds = Skor.ds;

        // Toolbar title dan back button
        Toolbar toolbar = findViewById(R.id.toolbare);
        toolbar.setTitle("Evaluasi Keputusan");
        setSupportActionBar(toolbar);

        //Menghitung skor akhir
        hitungSkor();

        ImageView ivSkor = findViewById(R.id.image_hasil);
        TextView tvSkor = findViewById(R.id.tv_skor);
        TextView tvEvaluasi = findViewById(R.id.tv_evaluasi);
        Button btnLog = findViewById(R.id.btn_log);
        Button btnEval = findViewById(R.id.btn_evaluasi);

        btnLog.setOnClickListener(this);
        btnEval.setOnClickListener(this);

        DrawableImageViewTarget imageViewTarget = new DrawableImageViewTarget(ivSkor);

        skor = ds.getTotal_skor();

        if (skor < 500) {
            Glide.with(this).load(R.raw.buruk).into(imageViewTarget);
            tvEvaluasi.setText(R.string.buruk);
            tvSkor.setTextColor(getResources().getColor(R.color.bad));
        } else if (500 <= skor && skor < 800) {
            Glide.with(this).load(R.raw.medium).into(imageViewTarget);
            tvEvaluasi.setText(R.string.medium);
            tvSkor.setTextColor(getResources().getColor(R.color.medium));
        } else {
            Glide.with(this).load(R.raw.bagus).into(imageViewTarget);
            tvEvaluasi.setText(R.string.bagus);
            tvSkor.setTextColor(getResources().getColor(R.color.good));
        }

        tvSkor.setText(String.valueOf(skor));

    }

    private void hitungSkor() {
        //Util
        int total_util = ((ds.getUtil_1() + ds.getUtil_2()) / 2) * ds.getBobot_util();

        //Deon
        int total_deon = ((ds.getDeon_1() + ds.getDeon_2()) / 2) * ds.getBobot_deon();

        //Right
        int skor_right3;
        if (ds.getRight_3() > ds.getRight_4()) {
            skor_right3 = ds.getRight_3();
        } else {
            skor_right3 = ds.getRight_4();
        }
        int total_right = ((ds.getRight_1() + ds.getRight_2() + skor_right3) / 3) * ds.getBobot_right();

        //Virtue
        int total_virtue = ((ds.getVirtue_1() + ds.getVirtue_2()) / 2) * ds.getBobot_virtue();

        //Teonom
        int total_teonom = ((ds.getTeonom_1() + ds.getTeonom_2()) / 2) * ds.getBobot_teonom();

        int total = total_util + total_deon + total_right + total_virtue + total_teonom;

        Log.d("SKOR", "SKOR UTIL ADALAH " + total_util);
        Log.d("SKOR", "SKOR DEON ADALAH " + total_deon);
        Log.d("SKOR", "SKOR RIGHT ADALAH " + total_right);
        Log.d("SKOR", "SKOR VIRTUE ADALAH " + total_virtue);
        Log.d("SKOR", "SKOR TEONOM ADALAH " + total_teonom);

        ds.setTotal_skor(total);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_log) {
            Intent pindah = new Intent(HasilActivity.this, LogEsai.class);
            startActivity(pindah);
        } else if (view.getId() == R.id.btn_evaluasi) {
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            //Yes button clicked
                            Intent startMain = new Intent(HasilActivity.this, WelcomeActivity.class);
                            startMain.addCategory(Intent.CATEGORY_HOME);
                            startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(startMain);
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            //No button clicked
                            break;
                    }
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(HasilActivity.this);
            builder.setMessage("Mengevaluasi ulang akan menghapus hasil ini").setPositiveButton("Ok", dialogClickListener)
                    .setNegativeButton("Batal", dialogClickListener).show();

        }
    }

    @Override
    public void onBackPressed() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        finishAffinity();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(HasilActivity.this);
        builder.setMessage("Apakah ingin keluar?").setPositiveButton("Ya", dialogClickListener)
                .setNegativeButton("Tidak", dialogClickListener).show();
    }
}
