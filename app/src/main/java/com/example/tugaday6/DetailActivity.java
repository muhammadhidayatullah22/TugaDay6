package com.example.tugaday6;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.text.NumberFormat;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        String namaMobil = getIntent().getStringExtra("nama_barang");
        String deskripsiMobil = getIntent().getStringExtra("deskripsi_barang");
        double hargaMobil = getIntent().getDoubleExtra("harga_barang", 0.0);
        int gambarMobil = getIntent().getIntExtra("gambar_barang", R.drawable.ic_launcher_background);

        TextView namaTextView = findViewById(R.id.nama_barang);
        TextView deskripsiTextView = findViewById(R.id.deskripsi_barang);
        TextView hargaTextView = findViewById(R.id.harga_barang);
        ImageView gambarImageView = findViewById(R.id.gambar_barang);
        Button shareButton = findViewById(R.id.share);

        namaTextView.setText(namaMobil);
        deskripsiTextView.setText(deskripsiMobil);
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        String formattedHarga = formatter.format(hargaMobil);
        hargaTextView.setText("Harga: " + formattedHarga);
        gambarImageView.setImageResource(gambarMobil);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), gambarMobil);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, bytes);
                String path = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "Title", null);
                Uri imageUri = Uri.parse(path);

                String shareText = "Check out this car: " + namaMobil + "\n\nDescription: " + deskripsiMobil + "\n\nPrice: " + hargaMobil;
                Intent shareIntent = new Intent(Intent.ACTION_SEND);

                shareIntent.setType("image/*");
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });
    }
}
