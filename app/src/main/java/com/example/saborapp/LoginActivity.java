package com.example.saborapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText mail;
    private EditText Password;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail = (EditText) findViewById(R.id.et_mail);
        Password = (EditText) findViewById(R.id.et_pass);
        Login = (Button) findViewById(R.id.btn_login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(mail.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String username, String pass) {
        if ((username.equals("ahmedsabry")) && (pass.equals("generic"))) {
            Intent intent = new Intent(LoginActivity.this, ListActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
        }
    }
}