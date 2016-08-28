package com.example.a747.smartlearningmanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInstaller;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class more_setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_setting);
    }

    public void gotoTodo(View v){
        Intent intent = new Intent(this, Todo.class);
        startActivity(intent);
    }
    public void gotoSetting(View v){
        Intent intent = new Intent(this, more_setting.class);
        startActivity(intent);
    }

    public void gotoHome(View v){
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }
    public void logout(View v){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
