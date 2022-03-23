package com.kuliah.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {

    Button btnRegis;

    EditText edNama, edEmail, edPass, edRepass;
    String nama, email, password, repassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegis = findViewById(R.id.bRegister);
        edNama = findViewById(R.id.txNama);
        edEmail = findViewById(R.id.txEmail);
        edPass = findViewById(R.id.regPass);
        edRepass = findViewById(R.id.regRepass);

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edNama.getText().toString();
                email = edEmail.getText().toString();
                password = edPass.getText().toString();
                repassword = edRepass.getText().toString();

                if (TextUtils.isEmpty(nama) && TextUtils.isEmpty(email)
                        && TextUtils.isEmpty(password) && TextUtils.isEmpty(repassword)){
                    Toast t = Toast.makeText(getApplicationContext(),"Harap isi semua kolom diatas",Toast.LENGTH_LONG);
                    t.show();

                    edNama.setError("Nama harus diisi");
                    edEmail.setError("Email harus diisi");
                }
                else if(TextUtils.isEmpty(nama) || TextUtils.isEmpty(email)
                        || TextUtils.isEmpty(password) || TextUtils.isEmpty(repassword)){
                    Toast t = Toast.makeText(getApplicationContext(),"Harap isi semua data!",Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    if (!password.equals(repassword)){
                        Toast t = Toast.makeText(getApplicationContext(),"Password harus sama!",Toast.LENGTH_LONG);
                        t.show();

                        edRepass.setError("Password harus sama");
                    }
                    else {
                        Bundle b = new Bundle();

                        b.putString("name", nama.trim());

                        Intent i = new Intent(getApplicationContext(), TaskPage.class);
                        i.putExtras(b);
                        startActivity(i);
                    }
                }
            }
        });
    }
}