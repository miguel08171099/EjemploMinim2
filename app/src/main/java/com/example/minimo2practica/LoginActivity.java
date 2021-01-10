package com.example.minimo2practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences mySharedPreferences;
    String user;

    public String getUser(View v){
        EditText usernameContainer;
        usernameContainer = (EditText)findViewById(R.id.editTextTextPersonName);
        return usernameContainer.getText().toString();
    }

    public String getPassword(View v){
        EditText usernameContainer;
        usernameContainer = (EditText)findViewById(R.id.editTextTextPassword);
        return usernameContainer.getText().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mySharedPreferences = getSharedPreferences("mySharedPreferences", MODE_PRIVATE);

        if(mySharedPreferences.getAll().size()!=0){
            user = (String)mySharedPreferences.getAll().get("User");
            Toast.makeText(getApplicationContext(), "Welcome back, " + user + "!", Toast.LENGTH_SHORT).show();
            openMainActivity();
        }
    }
    public void onLoginClick(View v){
        user = getUser(v);
        String password = getPassword(v);
        if(user.equals("user")&& password.equals("dsamola")){
            SharedPreferences.Editor edito = getSharedPreferences("mySharedPreferences", MODE_PRIVATE).edit();
            edito.putString("User", user);
            edito.apply();
            openMainActivity();
        } else{
            Toast.makeText(getApplicationContext(), "Wrong credentials!", Toast.LENGTH_SHORT).show();
        }
    }

    public  void openMainActivity(){
        Intent mainActvity = new Intent(this, MainActivity.class);
        startActivity(mainActvity);
    }

}