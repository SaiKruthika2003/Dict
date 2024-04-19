package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class searchActivity extends AppCompatActivity {
    private EditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Button btnSearch = findViewById(R.id.btnSearch);
        etSearch = findViewById(R.id.etSearch);
        btnSearch.setOnClickListener(v -> {
            Intent intent = new Intent(this, resultActivity.class);
            intent.putExtra("word", etSearch.getText().toString());
            startActivity(intent);
        });
    }
}