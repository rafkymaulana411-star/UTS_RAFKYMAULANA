package com.example.uts_rafkymaulana;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uts_rafkymaulana.databinding.ActivityPetunjukRafkyBinding;

public class PetunjukActivityRafky extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPetunjukRafkyBinding binding = ActivityPetunjukRafkyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnKembali.setOnClickListener(v -> finish());
    }
}
