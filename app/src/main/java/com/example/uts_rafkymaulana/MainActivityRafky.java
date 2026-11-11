package com.example.uts_rafkymaulana;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uts_rafkymaulana.databinding.ActivityMainRafkyBinding;

public class MainActivityRafky extends AppCompatActivity {

    private ActivityMainRafkyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainRafkyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Menu 1: Info Gaji Karyawan
        binding.btnInfoGaji.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityRafky.this, GajiActivityRafky.class);
            startActivity(intent);
        });

        // Menu 2: Petunjuk Penggunaan
        binding.btnPetunjuk.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityRafky.this, PetunjukActivityRafky.class);
            startActivity(intent);
        });

        // Menu 3: Tentang Aplikasi
        binding.btnTentang.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityRafky.this, TentangActivityRafky.class);
            startActivity(intent);
        });

        // Menu 4: Exit
        binding.btnExit.setOnClickListener(v -> showExitConfirmationDialog());
    }

    private void showExitConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Konfirmasi Keluar")
                .setMessage("Apakah Anda yakin ingin keluar dari aplikasi?")
                .setPositiveButton("Ya", (dialog, which) -> finishAffinity())
                .setNegativeButton("Tidak", null)
                .show();
    }
}
