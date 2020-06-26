package com.example.proyekpam;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyekpam.APIClient;
import com.example.proyekpam.APIService;

public class Register extends AppCompatActivity {
    EditText textId, textUsername, textPassword, textEmail, textAlamat;
    String id, username, password, alamat, email;
    Button btnDaftar;
    APIService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textId = findViewById(R.id.textId);
        textUsername = findViewById(R.id.textUsername);
        textPassword = findViewById(R.id.textPassword);
        textAlamat = findViewById(R.id.textAlamat);
        textEmail = findViewById(R.id.textEmail);

        btnDaftar = findViewById(R.id.btnDaftar);

        id = textId.getText().toString();
        username = textUsername.getText().toString();
        password = textPassword.getText().toString();
        alamat = textAlamat.getText().toString();
        email = textEmail.getText().toString();

        service = APIClient.getRetrofit().create(APIService.class);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = textId.getText().toString().trim();
                String username = textUsername.getText().toString().trim();
                String password = textPassword.getText().toString().trim();
                String alamat = textAlamat.getText().toString().trim();
                String email = textEmail.getText().toString().trim();

                if(TextUtils.isEmpty(id)){
                    textId.setError("Id tidak boleh kosong");
                }else if(TextUtils.isEmpty(username)){
                    textUsername.setError("Username tidak boleh kosong");
                }else if(TextUtils.isEmpty(password)){
                    textPassword.setError("Password tidak boleh kosong");
                }else if(TextUtils.isEmpty(password)){
                    textAlamat.setError("Alamat tidak boleh kosong");
                }else if(TextUtils.isEmpty(alamat)){
                    textEmail.setError("Email tidak boleh kosong");
                }else{
                    daftar(id, username, password, alamat, email);
                }
            }
        });
    }

    public void daftar(final String id, final String username, final String password, final String alamat, final String email){

        String idS = textId.getText().toString();
        String usernameS = textUsername.getText().toString();
        String passwordS = textPassword.getText().toString();
        String alamatS = textAlamat.getText().toString();
        String emailS = textEmail.getText().toString();

        service.daftar(idS, usernameS, passwordS, alamatS, emailS).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Intent move = new Intent(Register.this, Login.class);
                startActivity(move);
                Toast.makeText(getApplicationContext(), "Akun telah dibuat", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Kesalahan : " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
