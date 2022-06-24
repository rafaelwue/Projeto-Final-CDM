package com.example.projeto_final_cdm.Aplicativo.view;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.projeto_final_cdm.R;
import com.example.projeto_final_cdm.SQLite.DBhelper;

public class CadastroActivity extends AppCompatActivity {
    public ActionBarDrawerToggle actionBarDrawerToggle;
    EditText txtUsuario, txtEmail, txtSenha;
    Button btnCadastrar;
    RadioButton rdoUser, rdoAdmin;
    String admChk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);

        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        rdoUser = (RadioButton) findViewById(R.id.rdoUser);
        rdoAdmin = (RadioButton) findViewById(R.id.rdoAdmin);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhelper db = new DBhelper(CadastroActivity.this);
                db.cadastrar(txtUsuario.getText().toString(),
                        txtEmail.getText().toString(),
                        txtSenha.getText().toString(),
                        admChk);
            }
        });
    }

    public void onRadioButtonClicked (View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rdoUser:
                if (checked)
                    rdoAdmin.setChecked(false);
                    admChk = "user";
                break;
            case R.id.rdoAdmin:
                if(checked)
                    rdoUser.setChecked(false);
                    admChk = "admin";
                break;
        }
    }
}





