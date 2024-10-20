package com.example.formvalidationapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextSurname;
    private EditText editNumberPhone;
    private EditText editTextPassword;
    private EditText editTextPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSurname = findViewById(R.id.editTextSurname);
        editNumberPhone = findViewById(R.id.editNumberPhone);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPasswordConfirm = findViewById(R.id.editTextPasswordConfirm);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String surname = editTextSurname.getText().toString().trim();
                String numberphone = editNumberPhone.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String passwordconfirm = editTextPasswordConfirm.getText().toString().trim();

                if (name.isEmpty()) {
                    showToast("Proszę wprowadzić imię");
                } else if (surname.isEmpty()) {
                    showToast("Proszę wprowadzić nazwisko");
                } else if (email.isEmpty()) {
                    showToast("Proszę wprowadzić adres e-mail");
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    showToast("Niepoprawny adres e-mail");
                } else if (numberphone.isEmpty()) {
                    showToast("Proszę wprowadzić numer telefonu");
                } else if (numberphone.length() < 9) {
                    showToast("Niepoprawny numer telefonu");
                } else if (password.isEmpty()) {
                    showToast("Proszę wprowadzić hasło");
                } else if (password.length() < 6) {
                    showToast("Hasło jest za krótkie");
                } else if (passwordconfirm.isEmpty()) {
                    showToast("Proszę potwierdzić hasło");
                } else if (!passwordconfirm.equals(password)) {
                    showToast("Hasła się nie zgadzają");
                } else {
                    showToast("Formularz przesłany poprawnie");
                }
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
