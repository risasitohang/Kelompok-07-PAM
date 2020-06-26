package com.example.proyekpam;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Login extends AppCompatActivity {
    private static final String TAG = Login.class.getSimpleName();
    EditText etUsername, etPassword;
    Button btnLogin, btnDaftar;
    String username;
    String pw;
    String role;
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnDaftar = (Button) findViewById(R.id.btnDaftar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = etUsername.getText().toString();
                pw = etPassword.getText().toString();

                if (username.equals("") || pw.equals("")) {
                    Toast.makeText(Login.this,"Username atau Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }else{
                    loginProcess(username, pw);
                }
            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pageDaftar = new Intent(Login.this, Register.class);
                startActivity(pageDaftar);
            }
        });
    }

    public void loginProcess(final String username, final String pw){
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Login in process");
        showDialog();

        APIService service = APIClient.getRetrofit().create(APIService.class);
        Call<UserOutput> call = service.getUser();

        call.enqueue(new Callback<UserOutput>() {
            @Override
            public void onResponse(Call<UserOutput> call, Response<UserOutput> response) {
                List<User> usr = response.body().getUser();

                int jml = response.body().getUser().size();

                System.out.println(jml);

                System.out.println(username + "|||"+  pw);
                if(jml>0){
                    for(int i=0; i<jml; i++){
                        if (username.equals(usr.get(i).getId_consumer()) && pw.equals(usr.get(i).getPassword())){
                            Intent home = new Intent(Login.this, HomeConsumer.class);
                            startActivity(home);
                        };
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Username atau password salah",
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserOutput> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "AKSES KE SERVER GAGAL "+t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    private void showDialog() {
        if(progress.isShowing()){
            progress.show();
        }
    }

    private void hideDialog() {
        if(progress.isShowing()){
            progress.dismiss();
        }
    }
}
