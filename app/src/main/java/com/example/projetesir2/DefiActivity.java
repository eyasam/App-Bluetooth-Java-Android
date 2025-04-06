package com.example.projetesir2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class DefiActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defi);

        TextView textView = findViewById(R.id.defiText);
        textView.setText("Défi 1 - Prêt ?");
    }
}
