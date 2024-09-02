package com.example.my_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Form extends AppCompatActivity {


    Button btn;
    EditText etName, etPhoneNumber, etAddress, etBirthday;
    Spinner spinner;
    String[] gender = {"Male", "Female"};


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form);

        btn = findViewById(R.id.button2);
        etName = findViewById(R.id.edittext1);
        etPhoneNumber = findViewById(R.id.edittext2);
        etAddress = findViewById(R.id.edittext3);
        etBirthday = findViewById(R.id.edittext4);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, gender);
        spinner.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get text from each EditText
                String name = etName.getText().toString();
                String phoneNumber = etPhoneNumber.getText().toString();
                String address = etAddress.getText().toString();
                String birthday = etBirthday.getText().toString();
                String selectedGender = spinner.getSelectedItem().toString();

                // Create Intent to pass data to DataActivity
                Intent intent = new Intent(Form.this, DataActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("number", phoneNumber);
                intent.putExtra("address", address);
                intent.putExtra("birthday", birthday);
                intent.putExtra("ClickGender", selectedGender);
                startActivity(intent);
                finish();
            }
        });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
    }
}