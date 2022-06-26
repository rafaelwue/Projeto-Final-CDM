package com.example.projeto_final_cdm.Aplicativo.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projeto_final_cdm.R;
import com.example.projeto_final_cdm.SQLite.DBhelper;

public class LoginActivity extends AppCompatActivity {
    public static final String TAG = "LoginActivity";
    EditText txtLoginUser, txtLoginSenha;
    Button btnLoginEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);
        getSupportActionBar().hide();

        txtLoginUser = (EditText) findViewById(R.id.txtLoginUser);
        txtLoginSenha = (EditText) findViewById(R.id.txtLoginSenha);
        btnLoginEntrar = (Button) findViewById(R.id.btnLoginEntrar);
        /*btnLoginEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    DBhelper db = new DBhelper(LoginActivity.this);
                    String userType = db.checkUsrPermission(txtLoginUser.getText().toString());
                    Log.d(TAG, "strsql: " + userType);
                    if(userType == "admin"){
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(LoginActivity.this, UserMainActivity.class);
                         startActivity(intent);
                    }
            }
        });*/
    }
      public void goToMain(View view) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}