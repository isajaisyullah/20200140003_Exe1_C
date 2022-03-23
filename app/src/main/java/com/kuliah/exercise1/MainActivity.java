package com.kuliah.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button signin;
    TextView tRegis;
    EditText edNama, edPassword;

    String nama,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tRegis = findViewById(R.id.tRegister);
        signin = findViewById(R.id.btsign);
        edNama = findViewById(R.id.user1);
        edPassword = findViewById(R.id.pass1);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edNama.getText().toString();
                password = edPassword.getText().toString();

                Bundle b = new Bundle();

                b.putString("name", nama.trim());

                if (TextUtils.isEmpty(nama) && TextUtils.isEmpty(password)){
                    edNama.setError("Nama diperlukan");

                    Toast t = Toast.makeText(getApplicationContext(), "Masukkan Nama dan Password!", Toast.LENGTH_LONG);
                    t.show();
                }
                else if (TextUtils.isEmpty(password)){
                    Toast t = Toast.makeText(getApplicationContext(), "Password Salah", Toast.LENGTH_SHORT);
                    t.show();
                    edPassword.setError("Password diperlukan");

                }
                else if (TextUtils.isEmpty(nama)){
                    edNama.setError("Nama diperlukan");
                }
                else {
                    if (nama.equals("Pascal") && password.equals("iniPascal")){
                        Toast t = Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT);
                        t.show();

                        Intent log = new Intent(getApplicationContext(), TaskPage.class);
                        log.putExtras(b);
                        startActivity(log);
                    }
                    else if (nama.equals("Pascal") && !password.equals("iniPascal")){
                        Toast t = Toast.makeText(getApplicationContext(), "Password Salah", Toast.LENGTH_SHORT);
                        t.show();
                    }
                    else if(!nama.equals("Pascal") && password.equals("iniPascal")){
                        Toast t = Toast.makeText(getApplicationContext(), "Nama Salah", Toast.LENGTH_LONG);
                        t.show();
                    }
                    else {
                        Toast t = Toast.makeText(getApplicationContext(), "User tidak ditemukan", Toast.LENGTH_LONG);
                        t.show();
                    }
                }
            }
        });

        tRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegisterPage.class);
                startActivity(i);
            }
        });
    }
}