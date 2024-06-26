package com.example.progmob;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize UI components
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);

        // Set click listener for login button
        loginButton.setOnClickListener(v -> {
            if (validateInputs()) {
                // Proceed to HomeActivity
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish(); // Finish LoginActivity to prevent back navigation to login screen
            }
        });
    }

    // Method to validate input fields
    private boolean validateInputs() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(username)) {
            usernameEditText.setError("Nama User tidak boleh kosong");
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            passwordEditText.setError("Kata Sandi tidak boleh kosong");
            return false;
        }

        return true;
    }
}
