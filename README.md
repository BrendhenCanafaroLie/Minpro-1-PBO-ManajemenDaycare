# Minpro - PBO - Sistem Manajemen Daycare (Penitipan Anak)
### Brendhen Canafaro Lie 2509116033 (Kelas A)

## 1. Deskripsi Singkat Program

Program ini adalah aplikasi **CRUD (Create, Read, Update, Delete)** berbasis konsol (command line) yang mensimulasikan sistem rekap digital tempat penitipan anak (daycare). Program ini dibuat menggunakan bahasa **Java** dengan menerapkan konsep **Pemrograman Berorientasi Objek (PBO)**.

Program ini mengelola tiga entitas utama:

1. **OrangTua** — data wali yang mendaftarkan atau menjemput anak (`idOrangTua`, `namaOrangTua`, `noHp` bertipe `long`, `alamat`). Catatan: karena `noHp` disimpan sebagai tipe angka, angka `0` di paling depan nomor HP (misal `081234567890`) akan otomatis hilang menjadi `81234567890`.
2. **Anak** — data anak yang dititipkan di daycare (`idAnak`, `namaAnak`, `umur`, `catatanKesehatan`), yang juga direlasikan ke `idOrangTua` sebagai wali penanggung jawabnya.
3. **CatatanHarian** — jurnal harian yang diisi pengasuh untuk memantau kegiatan anak selama berada di daycare (`idCatatan`, `idAnak`, `tanggal`, `aktivitas`).

Seluruh data disimpan sementara di memori menggunakan `ArrayList` selama program berjalan (tanpa database eksternal), sehingga cocok digunakan sebagai simulasi pencatatan sederhana.


## 2. Struktur Program

```
src/
├── Main.java                      # Class entry point (menu utama)
├── model/
│   ├── OrangTua.java               # Entitas data orang tua/wali
│   ├── Anak.java                   # Entitas data anak
│   └── CatatanHarian.java          # Entitas jurnal harian
├── service/
│   ├── OrangTuaService.java        # Logic CRUD untuk OrangTua
│   ├── AnakService.java            # Logic CRUD untuk Anak
│   └── CatatanHarianService.java   # Logic CRUD untuk CatatanHarian
└── util/
    └── InputValidator.java         # Helper validasi input pengguna
```

Program dibagi menjadi 3 lapisan (di luar class entry point `Main`):
- **Model** — menyimpan struktur data (entitas).
- **Service** — menyimpan seluruh logika/fungsi CRUD serta ArrayList penampung data.
- **Util** — menyimpan fungsi bantu untuk validasi input.

![Struktur Folder Project]
<img width="238" height="353" alt="image" src="https://github.com/user-attachments/assets/60f8d766-950e-443c-941a-96124c7c253e" />



## 3. Penjelasan Alur Program

1. Saat dijalankan, program menampilkan pesan selamat datang lalu masuk ke **Menu Utama** yang berisi 4 pilihan:
   1. Menu Data Orang Tua
   2. Menu Data Anak
   3. Menu Catatan Harian
   4. Keluar

   ![Menu Utama]
   <img width="400" height="200" alt="image" src="https://github.com/user-attachments/assets/44855c6f-39e7-4e45-bc4f-000680dd7a7f" />

2. Menu Utama akan terus muncul kembali (perulangan `while`) selama pengguna belum memilih opsi **Keluar**.
3. Setiap pilihan menu (1–3) akan mengarahkan pengguna ke **submenu** masing-masing entitas, yang juga memiliki perulangannya sendiri agar pengguna bisa melakukan banyak operasi berturut-turut sebelum kembali ke Menu Utama:
   - **Menu Data Orang Tua**: Tambah, Tampilkan Semua, Update, Hapus, Kembali.
   - **Menu Data Anak**: Daftarkan Anak Baru, Tampilkan Semua, Update, Hapus, Kembali.
   - **Menu Catatan Harian**: Input Laporan Harian, Lihat Riwayat Aktivitas Anak, Edit Laporan, Hapus Laporan, Kembali.

   ![Submenu Orang Tua, Anak, dan Catatan Harian]
   <img width="241" height="126" alt="image" src="https://github.com/user-attachments/assets/60ca5dd5-5116-401c-8024-05c4c542b99b" />
   <img width="211" height="126" alt="image" src="https://github.com/user-attachments/assets/ec21df25-6f36-4c35-8eaa-b3eb24c06f50" />
   <img width="251" height="130" alt="image" src="https://github.com/user-attachments/assets/625fa500-d397-4642-af5b-033760154bc5" />


4. Pemilihan menu dilakukan sepenuhnya melalui **inputan angka** dari keyboard, diproses menggunakan struktur percabangan `switch-case`.
5. Setiap operasi Create/Update akan meminta input data satu per satu, dan setiap input divalidasi sebelum diterima oleh sistem.

   ![Contoh Input Data (Tambah Orang Tua/Anak)]
   <img width="294" height="256" alt="image" src="https://github.com/user-attachments/assets/47f86005-4590-4cab-bf03-bf8b21fdc434" />


   ![Contoh Data Berhasil Ditambahkan]
   <img width="559" height="186" alt="image" src="https://github.com/user-attachments/assets/e98b1610-0d93-4ea4-8ec2-514f29bc6f88" />


7. Relasi antar data dijaga secara sederhana:
   - Anak tidak bisa didaftarkan jika `idOrangTua` yang dimasukkan belum terdaftar di data OrangTua.
   - Catatan Harian tidak bisa dibuat jika `idAnak` yang dimasukkan belum terdaftar di data Anak.

   ![Validasi Relasi Data Gagal]
   <img width="477" height="180" alt="image" src="https://github.com/user-attachments/assets/278791f6-454b-4e0f-9263-50782a5ed44e" />


8. Fungsi **Read** menampilkan data menggunakan perulangan `for`, baik untuk menampilkan seluruh daftar (anak/orang tua) maupun untuk menampilkan riwayat aktivitas harian milik seorang anak tertentu.

   ![Riwayat Aktivitas Harian Anak]
   <img width="685" height="203" alt="image" src="https://github.com/user-attachments/assets/0a6d835b-7367-41e0-bcbb-0a5e7e1d19b8" />


9. Program hanya berhenti ketika pengguna memilih menu **Keluar (4)** pada Menu Utama.

   ![Program Keluar]
   <img width="544" height="243" alt="image" src="https://github.com/user-attachments/assets/0c1f158a-99a1-4aed-9223-d35df9a88463" />



## 3. Penjelasan Penerapan Nilai Tambah

### a. Access Modifier
Seluruh atribut pada class model (`OrangTua`, `Anak`, `CatatanHarian`) dideklarasikan sebagai `private`, sedangkan method yang perlu diakses dari luar class dideklarasikan `public`. Pada `Main.java`, method-method submenu (`menuOrangTua`, `menuAnak`, `menuCatatanHarian`, `tampilkanMenuUtama`) dideklarasikan `private static` karena hanya digunakan secara internal di dalam class `Main`.

### b. Encapsulation
Setiap class model menyembunyikan atributnya (`private`) dan hanya mengizinkan akses melalui `getter` dan `setter` publik. Contoh: atribut `catatanKesehatan` pada class `Anak` tidak bisa diubah langsung dari luar class, melainkan harus melalui `getCatatanKesehatan()` / `setCatatanKesehatan()`. Hal ini menjaga integritas data agar tidak diubah secara sembarangan dari class lain.

### c. Validasi Input
Seluruh input dari pengguna divalidasi melalui class `InputValidator` sebelum digunakan, di antaranya:
- **Input tidak boleh kosong** (`ambilTeksWajibIsi`) — digunakan untuk nama, alamat, ID, aktivitas, dll.
- **Angka positif** (`ambilAngkaPositif`) — digunakan untuk validasi umur anak, menolak input huruf atau angka negatif/nol.
- **Nomor HP** (`ambilNomorHp`) — memastikan input berupa angka murni dengan panjang 8–15 digit, lalu dikonversi ke tipe `long`.
- **Format tanggal** (`ambilTanggal`) — memastikan tanggal diinput dengan format `YYYY-MM-DD`.
- **Pilihan menu dalam rentang valid** (`ambilPilihanMenu`) — menolak input huruf atau angka di luar rentang pilihan menu yang tersedia.

![Contoh Validasi Input Gagal]
<img width="298" height="132" alt="image" src="https://github.com/user-attachments/assets/a038fb0d-f413-4861-9933-358e35593fc6" />

Selain itu, terdapat validasi penting, seperti:
- Mencegah pendaftaran ID yang sudah dipakai (ID Orang Tua/Anak harus unik).
- Mencegah pendaftaran anak dengan `idOrangTua` yang belum terdaftar.
- Mencegah pembuatan catatan harian dengan `idAnak` yang belum terdaftar.



## 4. Catatan Tambahan
- ID Catatan Harian (`idCatatan`) dibuat otomatis oleh sistem (auto-increment, format `C1`, `C2`, dst.) agar pengasuh tidak perlu menghafal/mengetik ID secara manual.
