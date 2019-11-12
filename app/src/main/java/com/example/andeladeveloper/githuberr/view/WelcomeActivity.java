package com.example.andeladeveloper.githuberr.view;

import android.content.Intent;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.andeladeveloper.githuberr.all_users.MainActivity;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.andeladeveloper.githuberr.R;

/**
 * The type Welcome activity.
 */
public class WelcomeActivity extends AppCompatActivity {
    /**
     * The Email.
     */
    EditText email, /**
     * The Password.
     */
    password;
    /**
     * The Login button.
     */
    Button loginButton;
    /**
     * The Container.
     */
    ConstraintLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        container = findViewById(R.id.layout_welcome_container);
        email = findViewById(R.id.text_email);
        password = findViewById(R.id.text_password);
        loginButton = findViewById(R.id.btn_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserIn();
            }
        });
    }

    /**
     * Log user in.
     */

    private void loginUserIn() {
        String emailValue = email.getText().toString();
        String passwordValue = password.getText().toString();

        if (emailValue.isEmpty() || passwordValue.isEmpty()) {
            Snackbar.make(container, "One or more fields are empty!", Snackbar.LENGTH_LONG)
                    .show();
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }


    }
}
