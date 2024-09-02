package com.example.my_app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DataActivity extends AppCompatActivity {

    TextView nameTextView;
    TextView phoneNumberTextView;
    TextView addressTextView;
    TextView birthdayTextView;
    TextView genderTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_data);

        nameTextView = findViewById(R.id.name);
        phoneNumberTextView = findViewById(R.id.phonenumber);
        addressTextView = findViewById(R.id.address);
        birthdayTextView = findViewById(R.id.birthday);
        genderTextView = findViewById(R.id.gender);

        String name = getIntent().getExtras().getString("name");
        String phoneNumber = getIntent().getExtras().getString("number");
        String address = getIntent().getExtras().getString("address");
        String birthday = getIntent().getExtras().getString("birthday");
        String clickGender = getIntent().getExtras().getString("ClickGender");

        nameTextView.setText(name);
        phoneNumberTextView.setText(phoneNumber);
        addressTextView.setText(address);
        birthdayTextView.setText(birthday);
        genderTextView.setText(clickGender);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}