package com.example.mobilvize;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class RandomGenerator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_generator);

        EditText etAdet = findViewById(R.id.et_adet);
        EditText etMax = findViewById(R.id.et_max);
        EditText etMin = findViewById(R.id.et_min);
        Button btnOlustur = findViewById(R.id.btn_olustur);

        btnOlustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBarEkle();
            }
        });
    }

        public void progressBarEkle() {
            Random random = new Random();
            EditText etAdet = findViewById(R.id.et_adet);
            EditText etMax = findViewById(R.id.et_max);
            EditText etMin = findViewById(R.id.et_min);

            LinearLayout lL = findViewById(R.id.l_layout);

            for(int i = 0; i < Integer.parseInt(etAdet.getText().toString()); i++) {
                int etMinDeger = Integer.parseInt(etMin.getText().toString());

                int max = random.nextInt(Integer.parseInt(etMax.getText().toString()));
                int min = etMinDeger;

                while (max <= min) {
                    max = random.nextInt(Integer.parseInt(etMax.getText().toString()));
                }

                min = random.nextInt(max - etMinDeger) + etMinDeger;

                int deger  = random.nextInt(max - min) + min;
                int yuzde = (int)((deger - min) / (double)(max - min) * 100);

                View view = getLayoutInflater().inflate(R.layout.progress_bar, null);

                TextView tvMin = view.findViewById(R.id.tv_minbar);
                TextView tvMax = view.findViewById(R.id.tv_maxbar);
                TextView tvDegerYuzde = view.findViewById(R.id.tv_degeryuzde);
                ProgressBar progressBar = view.findViewById(R.id.pBar);

                tvMin.setText(String.valueOf(min));
                tvMax.setText(String.valueOf(max));
                tvDegerYuzde.setText(deger + " = %" + yuzde);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    progressBar.setMin(min);
                }
                progressBar.setMax(max);
                progressBar.setProgress(deger);

                lL.addView(view);
            }
    }
}