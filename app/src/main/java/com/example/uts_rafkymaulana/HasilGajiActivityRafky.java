package com.example.uts_rafkymaulana;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uts_rafkymaulana.databinding.ActivityHasilGajiRafkyBinding;

import java.text.NumberFormat;
import java.util.Locale;

public class HasilGajiActivityRafky extends AppCompatActivity {

    private ActivityHasilGajiRafkyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHasilGajiRafkyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Ambil data dari Intent
        String nik = getIntent().getStringExtra("EXTRA_NIK");
        String nama = getIntent().getStringExtra("EXTRA_NAMA");
        double gajiPokok = getIntent().getDoubleExtra("EXTRA_GAJI_POKOK", 0);
        double tunjanganJabatan = getIntent().getDoubleExtra("EXTRA_TUNJANGAN_JABATAN", 0);
        int hariKerja = getIntent().getIntExtra("EXTRA_HARI_KERJA", 0);
        double tunjanganMakan = getIntent().getDoubleExtra("EXTRA_TUNJANGAN_MAKAN", 0);
        double tunjanganTransport = getIntent().getDoubleExtra("EXTRA_TUNJANGAN_TRANSPORT", 0);
        double gajiKotor = getIntent().getDoubleExtra("EXTRA_GAJI_KOTOR", 0);
        double pajak = getIntent().getDoubleExtra("EXTRA_PAJAK", 0);
        double gajiBersih = getIntent().getDoubleExtra("EXTRA_GAJI_BERSIH", 0);

        // Tampilkan ke TextView
        binding.tvHasilNik.setText(nik);
        binding.tvHasilNama.setText(nama);
        binding.tvHasilGajiPokok.setText(formatRupiah(gajiPokok));
        binding.tvHasilTunjanganJabatan.setText(formatRupiah(tunjanganJabatan));
        binding.tvHasilHariKerja.setText(hariKerja + " Hari");

        binding.tvHasilTunjanganMakan.setText(formatRupiah(tunjanganMakan));
        binding.tvHasilTunjanganTransport.setText(formatRupiah(tunjanganTransport));
        binding.tvHasilGajiKotor.setText(formatRupiah(gajiKotor));
        binding.tvHasilPajak.setText(formatRupiah(pajak));
        binding.tvHasilGajiBersih.setText(formatRupiah(gajiBersih));

        // Button Kembali / Hitung Lagi
        binding.btnKembaliGaji.setOnClickListener(v -> finish());
    }

    private String formatRupiah(double amount) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(amount);
    }
}
