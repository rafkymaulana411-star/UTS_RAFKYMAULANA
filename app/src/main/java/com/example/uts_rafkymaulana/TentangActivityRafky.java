package com.example.uts_rafkymaulana;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uts_rafkymaulana.databinding.ActivityTentangRafkyBinding;

public class TentangActivityRafky extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTentangRafkyBinding binding = ActivityTentangRafkyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnKembali.setOnClickListener(v -> finish());
    }
}
