package com.example.home_work_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView welcome;
    private TextView makeEnter;
    private TextView makeRegister;
    private TextView enter;
    private EditText gmail;
    private EditText password;
    private Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcome = findViewById(R.id.tv_welcome);
        makeEnter = findViewById(R.id.make_enter);
        makeRegister = findViewById(R.id.tv_make_register);
        enter = findViewById(R.id.tv_enter);
        gmail = findViewById(R.id.gmail);
        password = findViewById(R.id.password);
        button = findViewById(R.id.button);

        gmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (gmail.getText().toString().isEmpty()){
                    button.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.grey));
                }else {
                    button.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (password.getText().toString().isEmpty()){
                    button.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.grey));
                }else {
                    button.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        button.setOnClickListener(view -> {
            if (gmail.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                gmail.setVisibility(View.GONE);
                password.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
                enter.setVisibility(View.GONE);
                makeEnter.setVisibility(View.GONE);
                makeRegister.setVisibility(View.GONE);
                Toast.makeText(this, "Вы успешно зарегестрировались", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
            }
        });


    }
}