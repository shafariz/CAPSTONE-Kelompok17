# SISTEM PENDISTRIBUSIAN AIR BERSIH

# Deskripsi Singkat Program

Program *Sistem Pendistribusian Air Bersih* adalah aplikasi berbasis Java yang dirancang untuk membantu pengelolaan data dan proses distribusi air bersih secara terstruktur. Aplikasi ini memiliki dua jenis pengguna utama, yaitu *admin* dan *warga*, yang masing-masing memiliki hak akses dan fungsi berbeda.

Admin memiliki peran penting dalam mengelola sistem, seperti menambah, melihat, mengubah, dan menghapus data sumber air, melakukan uji kualitas air, serta mencatat dan memantau proses pendistribusian air ke berbagai daerah. Selain itu, admin juga dapat melihat dan menindaklanjuti laporan yang dibuat oleh warga untuk memastikan distribusi dan kualitas air berjalan dengan baik.

Sementara itu, warga dapat melakukan registrasi dan login ke sistem, membuat laporan terkait kondisi air di wilayahnya, serta melihat riwayat laporan yang pernah dibuat. Dengan sistem ini, proses pengawasan dan distribusi air bersih dapat dilakukan lebih efisien, transparan, dan mudah dipantau oleh semua pihak yang terlibat.

Seluruh data pada program ini tersimpan dalam basis data relasional yang terhubung antar entitas seperti *pengguna, sumber_air, kualitas_air, distribusi_air, daerah,* dan *laporan*, sehingga mendukung pengelolaan informasi secara terintegrasi dan akurat.


# Fitur Program

## Fitur untuk Admin

### 1. Login
Admin dapat masuk ke sistem untuk mendapatkan akses penuh terhadap pengelolaan data.

### 2. Manajemen Sumber Air (CRUD)
Admin dapat menambah, melihat, memperbarui, dan menghapus data sumber air seperti lokasi, kapasitas, dan kondisi sumber.

### 3. Uji Kualitas Air
Admin melakukan pengujian terhadap kualitas sumber air.

### 4. Lihat Riwayat Uji Kualitas Air
Admin dapat memantau hasil uji kualitas air sebelumnya untuk memastikan sumber air masih layak distribusi.

### 5. Pendistribusian Air
Admin mengatur distribusi air dari sumber ke berbagai daerah sesuai kebutuhan masyarakat.

### 6. Lihat Riwayat Distribusi Air
Admin dapat melihat data historis tentang ke mana air telah didistribusikan dan dalam jumlah berapa.

### 7. Manajemen Laporan (CRUD)
Admin dapat melihat, memperbarui, dan menindaklanjuti laporan yang dikirim oleh warga terkait kondisi air.

## Fitur untuk Warga

### 1. Register dan Login
Warga dapat membuat akun dan login agar bisa mengakses fitur pelaporan.

### 2. Buat Laporan Kondisi Air (CRUD)
Warga dapat membuat laporan mengenai kondisi sumber air di daerahnya (misalnya keruh, kering, atau tercemar).
Mereka juga dapat melihat, memperbarui, atau menghapus laporan yang telah dibuat.

### 3. Lihat Riwayat Distribusi Air
Warga dapat melihat data pendistribusian air di daerahnya.

# Penerapan 5 Pilar OOP

## Encapsulation

Potongan kode tersebut mendefinisikan empat atribut objek DAO, yaitu sumberAirDao, kualitasAirDao, laporanDao, dan distribusiAirDao, yang masing-masing berfungsi untuk mengelola data dari tabel berbeda di database. Penggunaan modifier private menandakan bahwa atribut-atribut ini hanya dapat diakses di dalam class itu sendiri, yang merupakan penerapan dari konsep Encapsulation dalam OOP, karena melindungi data agar tidak dapat diubah secara langsung dari luar class. Kata kunci final digunakan agar objek-objek DAO tersebut tidak dapat diganti setelah diinisialisasi, sehingga menjaga konsistensi referensi dan kestabilan koneksi antar komponen. Selain itu, deklarasi ini juga memperlihatkan adanya komposisi antar class, di mana adminController membentuk hubungan erat dengan objek-objek DAO untuk menangani operasi data seperti penambahan, pembacaan, dan pembaruan informasi. Dengan demikian, potongan kode ini mencerminkan prinsip abstraction dan encapsulation secara bersamaan—adminController hanya berfokus pada logika bisnis, sementara detail pengolahan data diserahkan sepenuhnya kepada class DAO yang bersangkutan

![WhatsApp Image 2025-11-04 at 22 22 00_3f9d310f](https://github.com/user-attachments/assets/1aadd1a7-b97b-4993-903b-90858564775f)

## Inheritance

Kode interface iPenggunaDao ini belum menunjukkan inheritance secara langsung, tapi bisa menjadi dasar pewarisan bagi class lain. Dalam konsep OOP, inheritance (pewarisan) terjadi ketika sebuah class mewarisi sifat dan perilaku dari class atau interface lain. Dalam hal ini, interface iPenggunaDao akan diwarisi oleh class konkret seperti penggunaDao, yang kemudian wajib mengimplementasikan semua metode di dalamnya (insert, findByUsername, dan getAll).

![WhatsApp Image 2025-11-04 at 23 18 56_de6b7b7a](https://github.com/user-attachments/assets/1166ecc8-2c5f-4d48-a0de-b80ed6da544e)

## Abstraction

Potongan kode tambahSumber(sumberAir s) ini merupakan contoh penerapan abstraction dalam pemrograman berorientasi objek. Method ini berfungsi sebagai penghubung antara lapisan controller dan data access layer (DAO). Objek sumberAir yang diterima sebagai parameter mewakili data sumber air yang akan disimpan ke database, sedangkan pemanggilan sumberDao.insert(s) menugaskan proses penyimpanan ke class DAO tanpa controller perlu mengetahui bagaimana detail proses penyimpanannya dilakukan. Hal ini menunjukkan penerapan abstraction, karena detail implementasi disembunyikan di balik pemanggilan method yang sederhana. Dengan cara ini, controller hanya fokus pada logika bisnis, sementara pengelolaan data dilakukan oleh objek DAO, menjadikan kode lebih rapi, terpisah dengan jelas, dan mudah dipelihara.

![WhatsApp Image 2025-11-04 at 22 35 51_977c88fa](https://github.com/user-attachments/assets/1b903042-6fd0-46d9-acde-c196352cab12)

Potongan kode getDaerahAdmin(int idPengguna) ini merupakan contoh penerapan abstraction dalam konsep OOP. Method ini menyembunyikan detail kompleks proses pengambilan data dari database, seperti pembuatan query SQL, eksekusi PreparedStatement, dan pengolahan ResultSet, dari class lain yang memanggilnya. Pihak yang menggunakan method ini cukup memanggil getDaerahAdmin() dan akan langsung mendapatkan objek daerah yang sudah siap digunakan, tanpa perlu mengetahui bagaimana data tersebut diambil atau bagaimana koneksi ke database dilakukan. Dengan cara ini, kode menjadi lebih bersih dan mudah dipahami karena detail teknis tersembunyi di balik satu method yang sederhana. Abstraksi semacam ini membantu menjaga pemisahan tanggung jawab (separation of concerns), di mana class DAO bertugas mengelola akses data, sedangkan class lain cukup menggunakan hasil akhirnya saja.

![WhatsApp Image 2025-11-04 at 23 11 10_7d5fc419](https://github.com/user-attachments/assets/e62ccaef-bc3d-4dd4-8f5e-d10f4027dc0d)

## Polymorphism

Potongan kode konstruktor adminController() ini dapat dikaitkan dengan konsep polymorphism, karena objek-objek DAO (sumberAirDao, kualitasAirDao, laporanDao, distribusiAirDao) kemungkinan besar mengimplementasikan antarmuka (interface) masing-masing, seperti iSumberAirDao atau iLaporanDao. Dengan begitu, variabel-variabel ini bisa mereferensikan objek dari berbagai class yang berbeda tetapi memiliki metode dengan nama yang sama — misalnya, insert() atau getAll() — yang bisa berperilaku berbeda tergantung pada implementasinya. Inilah esensi polymorphism: satu nama method yang sama dapat memiliki perilaku berbeda sesuai objek yang memanggilnya. Dalam konteks ini, controller tidak peduli bagaimana setiap DAO bekerja secara internal; yang penting setiap DAO memenuhi kontrak dari interfacenya, sehingga memungkinkan kode tetap konsisten, fleksibel, dan mudah diperluas.

![WhatsApp Image 2025-11-04 at 23 15 58_5f5d511b](https://github.com/user-attachments/assets/3e7ee140-e035-4a00-aaa1-d641a518dab6)


## Interface

Potongan kode ini menunjukkan penerapan konsep interface dalam OOP. Interface iPenggunaDao berfungsi sebagai kontrak atau cetak biru yang menentukan metode apa saja yang harus diimplementasikan oleh class lain yang menggunakannya, seperti insert(), findByUsername(), dan getAll(). Interface ini tidak berisi implementasi logika, melainkan hanya mendefinisikan struktur dasar yang wajib diikuti. Dengan adanya interface, kode menjadi lebih fleksibel dan mudah dikembangkan karena berbagai class DAO dapat mengimplementasikan cara mereka sendiri untuk mengakses database, tetapi tetap mengikuti pola yang sama. Konsep ini juga memperkuat prinsip loose coupling — artinya, class lain hanya bergantung pada kontrak interface, bukan pada detail implementasinya, sehingga sistem menjadi lebih modular dan mudah dikelola.

![WhatsApp Image 2025-11-04 at 23 13 05_63aa0aeb](https://github.com/user-attachments/assets/0b48ba08-a783-41b8-9657-7a3c44011b64)


# Struktur Folder / Package

<img width="305" height="355" alt="image" src="https://github.com/user-attachments/assets/2346b1df-a535-40f7-997a-b8c8702c3572" />

## Controller

Controller digunakan untuk mengatur alur logika antara tampilan dan data. Package ini menangani interaksi pengguna dari antarmuka dan meneruskannya ke bagian yang memproses data.

<img width="298" height="93" alt="image" src="https://github.com/user-attachments/assets/3fc86d82-a74e-41b3-a080-4e520c804368" />

## DAO

DAO berfungsi untuk menghubungkan program dengan database. Semua proses pengambilan, penyimpanan, pembaruan, dan penghapusan data dilakukan di package ini.

<img width="297" height="157" alt="image" src="https://github.com/user-attachments/assets/df885a71-fe99-4811-beb8-52594976cce7" />

## DAO Interface

DAO.Interfaces berisi interface yang mendefinisikan struktur dasar dari class DAO agar lebih terorganisir dan mudah dikembangkan.

<img width="297" height="137" alt="image" src="https://github.com/user-attachments/assets/17b799ac-89dd-4a25-9f9f-41de5208f776" />

## Main

Main berisi class utama yang menjalankan program dan menjadi titik awal aplikasi dimulai.

<img width="294" height="46" alt="image" src="https://github.com/user-attachments/assets/0e9d8c6b-d4a5-495a-af2d-890d1c44b10d" />

## Model

Model digunakan untuk merepresentasikan struktur data dari setiap tabel di database. Setiap class di package ini berfungsi sebagai model dari entitas yang ada.

<img width="291" height="201" alt="image" src="https://github.com/user-attachments/assets/e93a9842-bf30-49d3-9097-af4a8a497828" />

## Service

<img width="298" height="49" alt="image" src="https://github.com/user-attachments/assets/1d7d72a7-0420-4ac6-9a64-74a367bd843a" />

## Util

<img width="297" height="66" alt="image" src="https://github.com/user-attachments/assets/562eee7d-f4d3-4883-b6a6-46fb12b64b1b" />

## View1

<img width="277" height="500" alt="image" src="https://github.com/user-attachments/assets/49d8ee12-f0c4-46bf-8c7d-df0c88449d38" />

## Libraries

<img width="378" height="95" alt="image" src="https://github.com/user-attachments/assets/ed43fa5a-88ee-4e3f-b88b-9dd999ed2c2d" />

# Library

## mysql-connector-j-9.4.0.jar

Digunakan sebagai penghubung antara aplikasi Java dan database MySQL. Library ini berfungsi untuk memungkinkan program melakukan operasi seperti menyimpan, mengambil, mengubah, dan menghapus data pada database melalui koneksi JDBC (Java Database Connectivity).

## AbsoluteLayout.jar

Library yang digunakan untuk pengaturan tata letak (layout) komponen antarmuka grafis pada aplikasi Java, khususnya di NetBeans. Dengan Absolute Layout, posisi dan ukuran setiap komponen dapat diatur secara bebas menggunakan koordinat absolut (x, y, lebar, dan tinggi).

## JDK 24 (Default)

Merupakan Java Development Kit versi 24 yang berfungsi sebagai lingkungan utama untuk pengembangan aplikasi Java. JDK menyediakan compiler, pustaka standar, dan Java Virtual Machine (JVM) yang diperlukan untuk menulis, mengompilasi, dan menjalankan program Java.

# Cara Menggunakan Program

1. Gambar di bawah menunjukkan tampilan dari menu utama. Jika belum memiliki akun, warga harus melakukan registrasi terlebih dahulu.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/cb245702-8739-4645-95c6-22ad418ba9e4" />

2. Pada menu registrasi warga diminta untuk memasukkan Nama, Username, Password, No HP, dan Daerah.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/ddeb1a04-65f1-4be0-bc5a-26207e68f844" />

3. Registrasi berhasil.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/8b5173d4-fa7f-48ba-8ae1-287c843786d1" />

4. Setelah berhasil melakukan registrasi maka tampilan akan kembali ke menu utama. Lalu masukkan username dan password yang telah diregistrasi tadi untuk melakukan login.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/c8e9ac19-8ba8-4828-a1b2-1c50098f5e07" />

5. Login berhasil.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/70563408-7578-4c96-95b9-e7a54efcfb6d" />

6. Setelah berhasil melakukan login maka akan muncul tampilan menu warga. Di sini terdapat beberapa menu yaitu menu Buat Laporan dan Lihat Riwayat Distribusi.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/1a3d9267-b811-489c-87d2-6822d3f3e4ea" />

7. Masuk ke menu Buat Laporan. Di sini warga bisa membuat laporan terkait dengan keluhan tentang air pada daerahnya masing - masing. Jika telah memasukkan Tanggal dan Deskripsi warga bisa langsung menekan tombol kirim untuk mengirimkan laporan.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/788082c8-150f-45d5-ab7e-9177acbcf422" />

8. Laporan berhasil dikirim.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/8574411e-f9ec-40ae-8f83-6a877dd50a8f" />

9. Masuk ke menu riwayat distribusi. Di sini warga bisa melihat daerah mana saja yang telah mendapatkan distribusi air.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/ff4b8aa4-3c4c-41d9-8176-60d7ccaf10a3" />

10. Jika warga menekan tombol kembali setelah warga selesai mengirimkan laporan ataupun melihat riwayat distribusi maka tampilan akan kembali ke menu warga.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/e5f3bdd3-8fb0-4997-943c-4cde935e0f02" />

11. Jika warga menekan tombol Log out pada menu warga tadi maka tampilan akan kembali ke menu utama.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/e93b608f-1382-4b18-a281-edf1e807a2b4" />
