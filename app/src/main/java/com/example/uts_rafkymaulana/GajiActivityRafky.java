package com.example.uts_rafkymaulana;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uts_rafkymaulana.databinding.ActivityGajiRafkyBinding;

public class GajiActivityRafky extends AppCompatActivity {

    private ActivityGajiRafkyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGajiRafkyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Button Hitung Gaji
        binding.btnHitung.setOnClickListener(v -> hitungGaji());

        // Button Reset Input
        binding.btnReset.setOnClickListener(v -> resetForm());

        // Button Kembali
        binding.btnKembali.setOnClickListener(v -> finish());
    }

    private void hitungGaji() {
        String nik = binding.etNik.getText() != null ? binding.etNik.getText().toString().trim() : "";
        String nama = binding.etNama.getText() != null ? binding.etNama.getText().toString().trim() : "";
        String strGajiPokok = binding.etGajiPokok.getText() != null ? binding.etGajiPokok.getText().toString().trim() : "";
        String strTunjanganJabatan = binding.etTunjanganJabatan.getText() != null ? binding.etTunjanganJabatan.getText().toString().trim() : "";
        String strHariKerja = binding.etHariKerja.getText() != null ? binding.etHariKerja.getText().toString().trim() : "";

        // Validasi input
        if (TextUtils.isEmpty(nik)) {
            binding.etNik.setError("NIK wajib diisi!");
            binding.etNik.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(nama)) {
            binding.etNama.setError("Nama Karyawan wajib diisi!");
            binding.etNama.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(strGajiPokok)) {
            binding.etGajiPokok.setError("Gaji Pokok wajib diisi!");
            binding.etGajiPokok.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(strTunjanganJabatan)) {
            binding.etTunjanganJabatan.setError("Tunjangan Jabatan wajib diisi!");
            binding.etTunjanganJabatan.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(strHariKerja)) {
            binding.etHariKerja.setError("Jumlah Hari Kerja wajib diisi!");
            binding.etHariKerja.requestFocus();
            return;
        }

        double gajiPokok;
        double tunjanganJabatan;
        int hariKerja;

        try {
            gajiPokok = Double.parseDouble(strGajiPokok);
            tunjanganJabatan = Double.parseDouble(strTunjanganJabatan);
            hariKerja = Integer.parseInt(strHariKerja);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Format angka yang dimasukkan tidak valid!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Perhitungan sesuai petunjuk soal:
        // - Tunjangan makan = jumlah hari kerja * Rp 10.000
        // - Tunjangan transportasi = jumlah hari kerja * Rp 5.000
        // - Gaji Kotor = gaji pokok + tunjangan jabatan + tunjangan makan + tunjangan transportasi
        // - Pajak = 10% dari gaji kotor
        // - Gaji Bersih = gaji kotor - pajak
        double tunjanganMakan = hariKerja * 10000.0;
        double tunjanganTransport = hariKerja * 5000.0;
        double gajiKotor = gajiPokok + tunjanganJabatan + tunjanganMakan + tunjanganTransport;
        double pajak = 0.10 * gajiKotor;
        double gajiBersih = gajiKotor - pajak;

        // Kirim data ke HasilGajiActivityRafky
        Intent intent = new Intent(GajiActivityRafky.this, HasilGajiActivityRafky.class);
        intent.putExtra("EXTRA_NIK", nik);
        intent.putExtra("EXTRA_NAMA", nama);
        intent.putExtra("EXTRA_GAJI_POKOK", gajiPokok);
        intent.putExtra("EXTRA_TUNJANGAN_JABATAN", tunjanganJabatan);
        intent.putExtra("EXTRA_HARI_KERJA", hariKerja);
        intent.putExtra("EXTRA_TUNJANGAN_MAKAN", tunjanganMakan);
        intent.putExtra("EXTRA_TUNJANGAN_TRANSPORT", tunjanganTransport);
        intent.putExtra("EXTRA_GAJI_KOTOR", gajiKotor);
        intent.putExtra("EXTRA_PAJAK", pajak);
        intent.putExtra("EXTRA_GAJI_BERSIH", gajiBersih);

        startActivity(intent);
    }

    private void resetForm() {
        binding.etNik.setText("");
        binding.etNama.setText("");
        binding.etGajiPokok.setText("");
        binding.etTunjanganJabatan.setText("");
        binding.etHariKerja.setText("");

        binding.etNik.setError(null);
        binding.etNama.setError(null);
        binding.etGajiPokok.setError(null);
        binding.etTunjanganJabatan.setError(null);
        binding.etHariKerja.setError(null);

        binding.etNik.requestFocus();
        Toast.makeText(this, "Form telah direset", Toast.LENGTH_SHORT).show();
    }
}
