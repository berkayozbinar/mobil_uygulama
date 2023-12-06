package com.example.mobilvize;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sms extends AppCompatActivity {

    EditText etTel, etMesaj;

    Button btnGonder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        etTel = findViewById(R.id.et_tel);
        etMesaj = findViewById(R.id.et_mesaj);
        btnGonder = findViewById(R.id.btn_gonder);

        btnGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(Sms.this, Manifest.permission.SEND_SMS) ==
                        PackageManager.PERMISSION_GRANTED) {
                    smsGonder();
                }
                else {
                    ActivityCompat.requestPermissions(Sms.this, new String[] {Manifest.permission.SEND_SMS}, 100);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 100 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            smsGonder();
        }
        else {
            Toast.makeText(this, "Gerekli izinler verilmedi.", Toast.LENGTH_SHORT).show();
        }
    }

    private void smsGonder() {
        String tel = etTel.getText().toString();
        String mesaj = etMesaj.getText().toString();

        if (!tel.isEmpty() && !mesaj.isEmpty()) {
            SmsManager  smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(tel, null, mesaj, null, null);

            Toast.makeText(this, "Sms gönderildi.", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Sms gönderilemedi.", Toast.LENGTH_SHORT).show();
        }
    }
}