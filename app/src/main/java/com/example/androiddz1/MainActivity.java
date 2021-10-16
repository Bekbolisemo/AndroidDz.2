package com.example.androiddz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText username, password;
    private ImageView imV;
    private Button btn_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setinitView();
        setImage();
        intent();
    }

    private void intent() {
        btn_go.setOnClickListener(v -> {
            if (password.getText().toString().length() > 6 && username.getText().toString().length() > 1) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("password",password.getText().toString() );
                intent.putExtra("username", username.getText().toString());
                startActivity(intent);
            } else if (password.getText().toString().length() > 6) {
                password.setError("пароль меньше 6");
            } else if (username.getText().toString().length() > 1) {
                username.setError("Вы забыли username");
            }
        });
    }

    private void setImage() {
        Glide.with(this).load("https://i.pinimg.com/474x/23/ab/a6/23aba60b66ef08174bb7455c4a8a2d2f.jpg").into(imV);
    }

    private void setinitView() {
        username = findViewById(R.id.username_Input_Edit_Text);
        password = findViewById(R.id.password_Input_Edit_Text);
        imV = findViewById(R.id.im_car);
        btn_go = findViewById(R.id.go);
    }


}