package io.github.fuadreza.whowantstobeethical.ukur;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;

import io.github.fuadreza.whowantstobeethical.R;
import io.github.fuadreza.whowantstobeethical.data.DataSkor;
import io.github.fuadreza.whowantstobeethical.data.Skor;

public class UkurActivity extends AppCompatActivity implements View.OnClickListener {

    private DataSkor ds;

    private int bobotUtil;
    private int bobotDeon;
    private int bobotRight;
    private int bobotVirtue;
    private int bobotTeonom;

    private EditText edUtil;
    private EditText edDeon;
    private EditText edRight;
    private EditText edVirtue;
    private EditText edTeonom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ukur);
        ds = Skor.ds;

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Ukur Pendekatan");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Edit gambar
        ImageView iv = findViewById(R.id.iv_ukur_1);
        ImageView iv2 = findViewById(R.id.iv_ukur_2);
        DrawableImageViewTarget imageViewTarget = new DrawableImageViewTarget(iv);
        Glide.with(this).load(R.raw.instrucone).into(imageViewTarget);

        imageViewTarget = new DrawableImageViewTarget(iv2);
        Glide.with(this).load(R.raw.instructwo).into(imageViewTarget);

        //Tombol submit
        Button btnHitung = findViewById(R.id.btn_hitung);
        btnHitung.setOnClickListener(this);

        //Bobot EditText

        edUtil = findViewById(R.id.bobot_util);
        edDeon = findViewById(R.id.bobot_deon);
        edRight = findViewById(R.id.bobot_right);
        edVirtue = findViewById(R.id.bobot_virtue);
        edTeonom = findViewById(R.id.bobot_teonom);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_hitung) {
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            //Yes button clicked
                            if (bobotBenar()) {
                                ds.setBobot_util(bobotUtil);
                                ds.setBobot_deon(bobotDeon);
                                ds.setBobot_right(bobotRight);
                                ds.setBobot_virtue(bobotVirtue);
                                ds.setBobot_teonom(bobotTeonom);
                                Intent pindah = new Intent(UkurActivity.this, HasilActivity.class);
                                startActivity(pindah);
                            } else {
                                Toast.makeText(UkurActivity.this, "Bobot harus berjumlah 100", Toast.LENGTH_SHORT).show();
                            }
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            //No button clicked
                            break;
                    }
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setMessage("Apakah sudah yakin dengan bobot anda?").setPositiveButton("Ya", dialogClickListener)
                    .setNegativeButton("Tidak", dialogClickListener).show();
        }
    }

    private boolean bobotBenar() {
        bobotUtil = Integer.valueOf(edUtil.getText().toString());
        bobotDeon = Integer.valueOf(edDeon.getText().toString());
        bobotRight = Integer.valueOf(edRight.getText().toString());
        bobotVirtue = Integer.valueOf(edVirtue.getText().toString());
        bobotTeonom = Integer.valueOf(edTeonom.getText().toString());
        int total = bobotUtil + bobotDeon + bobotRight + bobotVirtue + bobotTeonom;

        if (total == 100) {
            return true;
        } else {
            return false;
        }

    }
}
