package com.example.progmob;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText name, email, password, phone;
    private CheckBox terms;
    private Button registerButton;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        terms = findViewById(R.id.terms);
        registerButton = findViewById(R.id.register_button);
        login = findViewById(R.id.login);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    // Perform registration logic here
                    Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle login click
                Toast.makeText(RegisterActivity.this, "Navigate to login screen", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateInputs() {
        if (name.getText().toString().isEmpty()) {
            name.setError("Nama diperlukan");
            return false;
        }
        if (email.getText().toString().isEmpty()) {
            email.setError("Email diperlukan");
            return false;
        }
        if (password.getText().toString().isEmpty()) {
            password.setError("Kata Sandi diperlukan");
            return false;
        }
        if (phone.getText().toString().isEmpty()) {
            phone.setError("Nomor Telepon diperlukan");
            return false;
        }
        if (!terms.isChecked()) {
            Toast.makeText(this, "Harap setujui syarat dan ketentuan", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
