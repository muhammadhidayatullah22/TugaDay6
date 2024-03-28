package com.example.tugaday6;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterMobil adapterMobil;
    private ArrayList<ModelMobil> modelMobil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        getData();

        recyclerView = findViewById(R.id.cars);
        adapterMobil = new AdapterMobil(modelMobil);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterMobil);

        adapterMobil.setOnItemClickListener(new AdapterMobil.OnItemClickListener() {
            @Override
            public void onItemClick(ModelMobil model) {

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                intent.putExtra("nama_barang", model.getNamaMobil());
                intent.putExtra("deskripsi_barang", getDeskripsi(model.getNamaMobil()));
                intent.putExtra("harga_barang", getHarga(model.getNamaMobil()));
                intent.putExtra("gambar_barang", model.getGambarMobil());
                startActivity(intent);
            }
        });
    }

    private void getData() {
        modelMobil = new ArrayList<>();
        modelMobil.add(new ModelMobil("Bugatti Veyron", R.drawable.bugatti_veyron, "Mesin: 8.0-liter quad-turbocharged W16, Tenaga: 1.200 - 1.500 PS, Torsi: 1.500 Nm\\nPerforma: Kecepatan Maksimum: Terbatas hingga sekitar 415 km/jam untuk menjaga kestabilan, Akselerasi 0-100 km/jam: Sekitar 2,5 detik\\nTransmisi: 7-kecepatan DSG (Direct-Shift Gearbox) dengan paddle shifters\\nRangka dan Suspensi: Rangka: Monokok karbon-fiber, Suspensi: Suspensi independen dengan pengaturan kinerja tinggi\\nRem: Rem Depan: Brembo rem keramik karbon, Rem Belakang: Brembo rem keramik karbon\\nDimensi dan Bobot: Panjang: Sekitar 4.462 mm, Lebar: Sekitar 1.998 mm, Tinggi: Sekitar 1.204 mm, Berat: Sekitar 1.888 kg\\nInterior: Interior yang mewah dengan material berkualitas tinggi, Sistem hiburan canggih dan sistem navigasi\\nEksterior: Desain aerodinamis yang agresif, Material konstruksi ringan untuk meningkatkan performa\\nFitur Lainnya: Sistem kontrol traksi, Sistem kontrol stabilitas, Sistem pengereman anti-blokir (ABS), Sistem pengurangan kecepatan darurat, Sistem pengukur tekanan ban", 2000000));
        modelMobil.add(new ModelMobil("Bugatti Chiron", R.drawable.bugatti_chiron, "Ditenagai oleh mesin quad-turbocharged W16 8.0 liter yang menghasilkan lebih dari 1.500 tenaga kuda dan torsi sebesar 1.600 Nm, Chiron mampu melaju dengan kecepatan yang mengagumkan. Dengan percepatan dari 0 hingga 100 km/jam dalam waktu kurang dari 2,5 detik dan kecepatan maksimum yang terbatas secara elektronik, melebihi 420 km/jam, Chiron mempertahankan posisinya sebagai salah satu mobil super tercepat di dunia. Desain eksterior Chiron menggabungkan aerodinamika yang canggih dengan garis-garis yang halus dan identitas ikonik Bugatti, sementara interiornya menawarkan kenyamanan dan kemewahan dengan material berkualitas tinggi seperti kulit, kayu eksotis, dan aluminium. Teknologi canggih yang terintegrasi dalam Chiron, termasuk sistem hiburan dan kontrol terbaru serta fitur-fitur keselamatan yang mutakhir, menjamin pengalaman berkendara yang tak tertandingi. Dengan produksi yang sangat terbatas, Bugatti Chiron tidak hanya sekadar mobil, tetapi juga sebuah karya seni yang menetapkan standar baru dalam dunia otomotif.", 3000000));
        modelMobil.add(new ModelMobil("Bugatti Divo", R.drawable.bugatti_divo, "Divo didukung oleh mesin yang sama dengan Bugatti Chiron, yakni mesin quad-turbocharged W16 8.0 liter yang menghasilkan lebih dari 1.500 tenaga kuda. Namun, Divo menawarkan peningkatan aerodinamika yang signifikan, dengan fokus pada downforce dan manuverabilitas di lintasan. Garis-garis yang tajam dan agresif pada desain eksterior Divo tidak hanya memperkuat estetika, tetapi juga meningkatkan performa aerodinamis secara keseluruhan.\n" +
                "\n" +
                "Interior Divo dirancang untuk memberikan kenyamanan dan kontrol maksimal bagi pengemudi di lintasan. Material berkualitas tinggi dan desain ergonomis menciptakan lingkungan yang mewah dan fungsional. Sistem kontrol dan pengendalian yang canggih memastikan responsivitas yang luar biasa, sementara fitur-fitur keselamatan terbaru memberikan perlindungan optimal.", 5000000));
        modelMobil.add(new ModelMobil("Bugatti La Voiture Noire", R.drawable.ic_la_voiture_noire, "La Voiture Noire, yang secara harfiah diterjemahkan sebagai \"mobil hitam,\" adalah mobil yang didedikasikan untuk kemewahan, eksklusivitas, dan kecepatan tak tertandingi. Dengan desain yang memukau dan aerodinamika yang canggih, La Voiture Noire menampilkan garis-garis yang halus dan elegan yang membuatnya terlihat seperti karya seni yang bergerak.\n" +
                "\n" +
                "Mobil ini didukung oleh mesin quad-turbocharged W16 8.0 liter yang sama dengan Bugatti Chiron dan Divo, namun dengan peningkatan performa yang lebih lanjut. Mesin ini mampu menghasilkan tenaga yang luar biasa, memberikan akselerasi yang cepat dan kecepatan maksimum yang mengesankan.", 12000000));
        modelMobil.add(new ModelMobil("Bugatti Centodieci", R.drawable.cen, "Dengan desain yang revolusioner, Bugatti Centodieci menggabungkan elemen-elemen futuristik dengan ciri khas retro dari EB110. Garis-garis yang tajam dan aerodinamika yang canggih memberikan mobil ini penampilan yang unik dan menakjubkan di jalan raya.\n" +
                "\n" +
                "Di bawah kap mesinnya yang elegan terletak mesin quad-turbocharged W16 8.0 liter, yang merupakan mesin yang sama dengan yang ditemukan di Bugatti Chiron. Namun, dalam Centodieci, mesin ini telah ditingkatkan untuk memberikan lebih banyak tenaga dan kinerja yang luar biasa. Dengan tenaga lebih dari 1.600 tenaga kuda, Bugatti Centodieci memiliki kemampuan akselerasi yang mengesankan, memungkinkan untuk mencapai kecepatan yang sangat tinggi dalam waktu yang sangat singkat.\n" +
                "\n", 9000000));
        modelMobil.add(new ModelMobil("Porsche Taycan", R.drawable.taycan, "Porsche Taycan adalah mobil listrik yang menandai langkah ambisius Porsche ke dalam era kendaraan ramah lingkungan. Diluncurkan pada tahun 2019, Taycan membawa warisan Porsche dalam hal performa dan kecanggihan ke dunia mobilitas listrik.\n" +
                "\n" +
                "Dari segi desain, Taycan memiliki tampilan yang menggabungkan elemen-elemen ikonik Porsche dengan estetika yang modern dan futuristik. Garis-garis yang tajam dan proporsi yang proporsional memberikan mobil ini penampilan yang sporty dan elegan.\n" +
                "\n" +
                "Performa menjadi fokus utama Taycan, dengan berbagai varian yang menawarkan kombinasi tenaga dan jangkauan yang mengesankan. Mesin listriknya mampu menghasilkan akselerasi yang cepat dan responsif, memberikan pengalaman berkendara yang serba cepat dan dinamis yang diharapkan dari sebuah Porsche.", 100000));
        modelMobil.add(new ModelMobil("Porsche 718 GT4 RS", R.drawable.ic_718_cayman_gt4_rs, "Porsche 718 Cayman GT4 RS adalah mobil sport yang menggabungkan performa tinggi dengan presisi yang luar biasa. Ditenagai oleh mesin bokser enam silinder yang bertenaga, Cayman GT4 RS menawarkan peningkatan signifikan dalam hal tenaga dibandingkan dengan model-model sebelumnya. Mesin ini dipasangkan dengan transmisi manual enam percepatan, memungkinkan pengemudi untuk merasakan pengalaman berkendara yang otentik dan memuaskan. Sistem suspensi yang disempurnakan dan rem kinerja tinggi memberikan kontrol yang luar biasa di lintasan balap, sementara elemen aerodinamis yang ditingkatkan meningkatkan downforce dan stabilitas di kecepatan tinggi. Interior Cayman GT4 RS didesain sepenuhnya untuk pengemudi, dengan kursi balap yang ergonomis, kemudi yang responsif, dan fitur-fitur pengemudi yang canggih. ", 150000));
        modelMobil.add(new ModelMobil("Porsche 911 GT3 RS", R.drawable.ic_911_gt3_rs, "Porsche 911 GT3 RS adalah mobil sport yang dibuat untuk mengeksploitasi batas performa di lintasan balap. Mengadaptasi warisan panjang Porsche di dunia balap, GT3 RS adalah pengembangan dari model 911 yang telah menjadi legenda dalam dunia otomotif.\n" +
                "\n" +
                "Ditenagai oleh mesin bensin berperforma tinggi yang dipasang di tengah mobil, Porsche 911 GT3 RS menawarkan performa yang memukau. Mesin bokser enam silindernya menghasilkan tenaga yang besar, disalurkan melalui transmisi PDK atau manual, memberikan akselerasi yang cepat dan respon yang tajam di lintasan.", 300000));
        modelMobil.add(new ModelMobil("Porsche 911 Carrera", R.drawable.ic_911_carrera, "Porsche 911 Carrera adalah mobil sport legendaris yang memadukan performa tinggi dengan kenyamanan sehari-hari. Sebagai salah satu model ikonik dari Porsche, 911 Carrera menawarkan kombinasi yang unik antara performa yang mengesankan, desain yang ikonik, dan kenyamanan yang dapat dinikmati sehari-hari.\n" +
                "\n" +
                "Ditenagai oleh mesin bensin bokser enam silinder yang terletak di bagian belakang, Porsche 911 Carrera menghasilkan tenaga yang impresif. Mesin ini dipasangkan dengan transmisi manual atau PDK (Porsche Doppelkupplung) yang memberikan akselerasi responsif dan pengalaman berkendara yang memuaskan.", 120000));
        modelMobil.add(new ModelMobil("Porsche 718 Spyder RS", R.drawable.ic_718_spyder_rs, "Mesin: 4.0-liter naturally aspirated flat-six, Tenaga: Sekitar 420 PS, Torsi: Sekitar 420 Nm\\nPerforma: Kecepatan Maksimum: Lebih dari 300 km/jam, Akselerasi 0-100 km/jam: Sekitar 4,0 detik\\nTransmisi: 6-kecepatan manual\\nRangka dan Suspensi: Rangka: Monokok alumunium, Suspensi: Suspensi olahraga yang disesuaikan untuk performa\\nRem: Rem Depan: Rem karbon-seramik opsional, Rem Belakang: Rem karbon-seramik opsional\\nDimensi dan Bobot: Panjang: 4.460 mm, Lebar: 1.801 mm, Tinggi: 1.257 mm, Berat: Sekitar 1.400 kg\\nInterior: Interior yang fokus pada performa dengan kemudi sport, Kursi balap opsional\\nEksterior: Desain aerodinamis yang elegan dengan spoiler belakang, Grille depan khas RS\\nFitur Lainnya: Sistem kontrol traksi, Sistem kontrol stabilitas, Sistem pengereman anti-blokir (ABS), Sistem pengukur tekanan ban", 130000));
        modelMobil.add(new ModelMobil("Koenigsegg One", R.drawable.ic_koenigsegg_one_1, "Mesin: 5.0-liter twin-turbocharged V8, Tenaga: 1.360 PS, Torsi: 1.371 Nm\\nPerforma: Kecepatan Maksimum: Lebih dari 440 km/jam, Akselerasi 0-100 km/jam: Sekitar 2,8 detik\\nTransmisi: Transmisi 7-kecepatan paddle-shift atau transmisi 7-kecepatan manual\\nRangka dan Suspensi: Rangka: Monokok karbon-fiber, Suspensi: Suspensi aktif dengan pengaturan kinerja tinggi\\nRem: Rem Depan: Brembo rem karbon-seramik, Rem Belakang: Brembo rem karbon-seramik\\nDimensi dan Bobot: Panjang: Sekitar 4.500 mm, Lebar: Sekitar 2.000 mm, Tinggi: Sekitar 1.100 mm, Berat: Sekitar 1.360 kg\\nInterior: Interior yang mewah dengan desain kustom, Kemudi dengan tombol-tombol kontrol terintegrasi\\nEksterior: Desain aerodinamis yang khas, Fitur-fitur aerodinamis aktif\\nFitur Lainnya: Sistem kontrol traksi, Sistem kontrol stabilitas, Sistem pengereman anti-blokir (ABS), Sistem pengukur tekanan ban", 3000000));
        modelMobil.add(new ModelMobil("Koenigsegg Agera", R.drawable.ic_koenigsegg_agera, "Koenigsegg Agera adalah simbol dari keterampilan teknik tinggi dan ambisi dalam dunia otomotif. Dibuat oleh Koenigsegg, perusahaan otomotif Swedia yang terkenal dengan mobil-mobil super eksklusif, Agera adalah perpaduan sempurna antara kekuatan, keindahan, dan inovasi.\n" +
                "\n" +
                "Dari segi desain, Agera memancarkan aura agresif yang diimbangi dengan garis-garis yang halus dan aerodinamis. Desainnya memperlihatkan perhatian yang detail terhadap performa aerodinamis, dengan berbagai elemen seperti ventilasi udara yang disempurnakan dan aerofin untuk mencapai downforce maksimum.", 1900000));
        modelMobil.add(new ModelMobil("Koenigsegg Agera RS", R.drawable.ic_koenigsegg_agera_rs, "Koenigsegg Agera RS adalah mobil super yang merupakan salah satu pencapaian paling cemerlang dari pabrikan otomotif Swedia, Koenigsegg. Diluncurkan pada tahun 2015, Agera RS menempati posisi puncak dalam hal performa, teknologi, dan eksklusivitas.\n" +
                "\n" +
                "Ditenagai oleh mesin V8 twin-turbocharged yang sangat bertenaga, Agera RS mampu menghasilkan tenaga luar biasa yang melebihi 1.000 tenaga kuda, menjadikannya salah satu mobil paling kuat di dunia. Transmisi otomatis atau transmisi sekuensial memastikan akselerasi yang responsif dan halus, sementara sistem penggerak roda belakang memberikan kontrol yang luar biasa di lintasan balap.\n" +
                "\n", 5000000));
        modelMobil.add(new ModelMobil("Koenigsegg Jesko", R.drawable.ic_koenigsegg_jesko, "Koenigsegg Jesko adalah mobil super terbaru yang dibuat oleh Koenigsegg, pabrikan otomotif Swedia yang terkenal dengan kendaraan-kendaraan eksklusif dan performa tinggi. Diluncurkan pada Geneva International Motor Show 2019, Jesko diilhami oleh ayah pendiri perusahaan, Jesko von Koenigsegg, dan mempersembahkan teknologi canggih serta performa tak tertandingi.\n" +
                "\n" +
                "Ditenagai oleh mesin V8 twin-turbocharged yang dirancang ulang, Jesko menawarkan tenaga luar biasa hingga lebih dari 1.600 tenaga kuda pada bahan bakar bensin standar, dan bahkan lebih tinggi pada bahan bakar E85. Transmisi Koenigsegg LST (Light Speed Transmission) baru memberikan perpindahan gigi yang luar biasa cepat, menghasilkan akselerasi yang spektakuler.\n" +
                "\n", 7000000));
        modelMobil.add(new ModelMobil("Koenigsegg Regera", R.drawable.ic_koenigsegg_regera, "Koenigsegg Regera adalah mobil super hibrida plug-in yang menunjukkan pencapaian luar biasa dalam hal teknologi dan performa. Diluncurkan pada Geneva Motor Show 2015, Regera menampilkan pendekatan yang inovatif terhadap penggerak hibrida, dengan kombinasi antara mesin bensin bertenaga tinggi dan motor listrik.\n" +
                "\n" +
                "Mesin bensin V8 twin-turbocharged yang dipasang di tengah mobil, bersama dengan tiga motor listrik, menghasilkan tenaga luar biasa yang mencapai lebih dari 1.500 tenaga kuda secara total. Sistem transmisi Koenigsegg Direct Drive (KDD) yang unik menggabungkan kecepatan dan efisiensi, menghilangkan kebutuhan akan transmisi konvensional dan memberikan akselerasi yang mulus dan responsif.\n" +
                "\n", 3000000));
    }

    private String getDeskripsi(String namaMobil) {
        for (ModelMobil mobil : modelMobil) {
            if (mobil.getNamaMobil().equals(namaMobil)) {
                return mobil.getDeskripsiMobil();
            }
        }
        return "";
    }

    private double getHarga(String namaMobil) {
        for (ModelMobil mobil : modelMobil) {
            if (mobil.getNamaMobil().equals(namaMobil)) {
                return mobil.getHargaMobil();
            }
        }
        return 0.0;
    }
}