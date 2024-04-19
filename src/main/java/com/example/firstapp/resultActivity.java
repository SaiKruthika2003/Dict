package com.example.firstapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firstapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class resultActivity extends AppCompatActivity {
    ArrayList<String> arr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String word = getIntent().getStringExtra("word");
        read_json(word);
        TextView tvResult = findViewById(R.id.tvResult);
        tvResult.setText("Definition of " + word);
    }

    public void read_json(String str) {
        String json = null;
        try {
            char s = str.toLowerCase().charAt(0);
            InputStream inputStream = getAssets().open(s + ".json");
            json = new java.util.Scanner(inputStream).useDelimiter("\\A").next();
            JSONArray jsonarr = new JSONArray(json);
            for (int i = 0; i < jsonarr.length(); i++) {
                JSONObject jsonobj = jsonarr.getJSONObject(i);
                if (jsonobj.getString("word").equals(str)) {
                    arr.add(jsonobj.getString("type") + "-" + jsonobj.getString("description"));
                }
            }
            ArrayAdapter<String> adpt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
            ListView json_list = findViewById(R.id.json_list);
            json_list.setAdapter(adpt);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}