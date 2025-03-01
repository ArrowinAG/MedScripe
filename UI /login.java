package com.example.medscripe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {  // Class name should start with uppercase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Apply Window Insets for Edge-to-Edge display (FIXED)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI elements
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnProceed = findViewById(R.id.btnProceed);
        TextView tvForgotPassword = findViewById(R.id.tvForgotPassword);

        // Proceed Button Click Listener
        btnProceed.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();

                // Navigate to MainActivity (You must create this activity)
                Intent intent = new Intent(login.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Forgot Password Click Listener
        tvForgotPassword.setOnClickListener(v ->
                Toast.makeText(this, "Forgot Password Clicked", Toast.LENGTH_SHORT).show());

        // Delay before navigating to MainActivity (5 minutes)
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(login.this, SignIn.class);
            startActivity(intent);
            finish();
        }, 3000);
    }
}
