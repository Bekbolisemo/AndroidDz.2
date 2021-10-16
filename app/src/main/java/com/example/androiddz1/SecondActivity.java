package com.example.androiddz1;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;

public class SecondActivity extends AppCompatActivity {
    private TextInputEditText maill,password;
    private TextView photo;
    private ImageView image;
    private final int GALIREA = 12;
    private final int CAMERA = 13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setinitView();
        imageClik();
        photoClik();
        putExtra();

    }

    private void putExtra() {
        String m = getIntent().getStringExtra("username");
        String p = getIntent().getStringExtra("password");
        maill.setText(m);
        password.setText(p);
    }

    private void photoClik() {
        photo.setOnClickListener(v ->{
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,CAMERA);

        });
    }

    private void imageClik() {
        image.setOnClickListener(v ->{
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent,GALIREA);
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GALIREA && resultCode == RESULT_OK && data != null ){
            Glide.with(this).load(data.getData().toString()).circleCrop().into(image);

        }
        if(requestCode == CAMERA && resultCode == RESULT_OK && data != null ){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            image.setImageBitmap(imageBitmap);
            Glide.with(image).load(imageBitmap).circleCrop().into(image);
        }
    }


    private void setinitView() {
        password = findViewById(R.id.password_Input_EditText_second_activity);
        maill = findViewById(R.id.email_Input_EditText_second_activity);
        image = findViewById(R.id.image_view);
        photo = findViewById(R.id.edit_photo);
    }

}