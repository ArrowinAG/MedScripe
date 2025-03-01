package com.example.medscripe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignIn extends AppCompatActivity {

    private EditText etName, etGender, etAge;
    private Button btnProceed;
    private ImageView imgIllustration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);

        // Apply Edge-to-Edge insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI components
        imgIllustration = findViewById(R.id.imgIllustration);
        etName = findViewById(R.id.etName);
        etGender = findViewById(R.id.etGender);
        etAge = findViewById(R.id.etAge);
        btnProceed = findViewById(R.id.btnProceed);

        // Proceed button click event
        btnProceed.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String gender = etGender.getText().toString().trim();
            String age = etAge.getText().toString().trim();

            if (name.isEmpty() || gender.isEmpty() || age.isEmpty()) {
                Toast.makeText(SignIn.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                // Move to Symptoms activity and pass user details
                Intent intent = new Intent(SignIn.this, Symptoms.class);
                intent.putExtra("NAME", name);
                intent.putExtra("GENDER", gender);
                intent.putExtra("AGE", age);
                startActivity(intent);
                finish(); // Close SignIn screen to prevent going back
            }
        });
    }
}
