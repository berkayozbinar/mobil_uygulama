package com.example.mobilvize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Converter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        EditText etDecimal = findViewById(R.id.et_decimal);
        EditText etMegabyte = findViewById(R.id.et_megabyte);
        EditText etCelcius = findViewById(R.id.et_celcius);
        Spinner sPinner0 = findViewById(R.id.spinner0);
        Spinner sPinner1 = findViewById(R.id.spinner1);
        TextView tvSonuc0 = findViewById(R.id.tv_sonuc0);
        TextView tvSonuc1 = findViewById(R.id.tv_sonuc1);
        TextView tvSonuc2 = findViewById(R.id.tv_sonuc2);
        RadioButton rbFahrenhayt = findViewById(R.id.rb_fahrenhayt);
        RadioButton rbKelvin = findViewById(R.id.rb_kelvin);
        Button btnDecimal = findViewById(R.id.btn_decimal);
        Button btnMegabyte = findViewById(R.id.btn_megabyte);
        Button btnCelcius = findViewById(R.id.btn_celcius);

        ArrayList<String> list0 = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();

        list0.add("Binary");
        list0.add("Octal");
        list0.add("Hexadecimal");
        list1.add("Bit");
        list1.add("Byte");
        list1.add("Kilobyte");
        list1.add("Kibibyte");

        ArrayAdapter<String> adapter0 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list0);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list1);
        sPinner0.setAdapter(adapter0);
        sPinner1.setAdapter(adapter1);

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etDecimal.getText().toString().isEmpty()) {
                    tvSonuc0.setText("Sonuç : ");
                }
                else {
                    int decimalSayi = Integer.parseInt(etDecimal.getText().toString());
                    String index = sPinner0.getSelectedItem().toString();

                    switch (index) {
                        case "Binary":
                            tvSonuc0.setText("Sonuç : " + Integer.toBinaryString(decimalSayi));
                            break;
                        case "Octal":
                            tvSonuc0.setText("Sonuç : " + Integer.toOctalString(decimalSayi));
                            break;
                        case "Hexadecimal":
                            tvSonuc0.setText("Sonuç : " + Integer.toHexString(decimalSayi).toUpperCase());
                            break;
                    }
                }
            }
        });

        btnMegabyte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etMegabyte.getText().toString().isEmpty()) {
                    tvSonuc1.setText("Sonuç : ");
                }
                else {
                    int megabyteSayi = Integer.parseInt(etMegabyte.getText().toString());
                    String index = sPinner1.getSelectedItem().toString();

                    switch (index) {
                        case "Bit":
                            tvSonuc1.setText("Sonuç : " + (megabyteSayi * 8000000));
                            break;
                        case "Byte":
                            tvSonuc1.setText("Sonuç : " + (megabyteSayi * 1000000));
                            break;
                        case "Kilobyte":
                            tvSonuc1.setText("Sonuç : " + (megabyteSayi * 1000));
                            break;
                        case "Kibibyte":
                            tvSonuc1.setText("Sonuç : " + (megabyteSayi * 1024));
                            break;
                    }
                }
            }
        });

        btnCelcius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etCelcius.getText().toString().isEmpty()) {
                    tvSonuc2.setText("Sonuç : ");
                }
                else {
                    if (rbFahrenhayt.isChecked()) {
                        tvSonuc2.setText("Sonuç : " + ((Double.parseDouble(etCelcius.getText().toString()) * 9/5) + 32));
                    }
                    else {
                        tvSonuc2.setText("Sonuç : " + (Double.parseDouble(etCelcius.getText().toString()) + 273.15));
                    }
                }
            }
        });
    }
}