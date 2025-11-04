# SISTEM PENDISTRIBUSIAN AIR BERSIH

# Deskripsi Singkat Program

Program *Sistem Pendistribusian Air Bersih* adalah aplikasi berbasis Java yang dirancang untuk membantu pengelolaan data dan proses distribusi air bersih secara terstruktur. Aplikasi ini memiliki dua jenis pengguna utama, yaitu *admin* dan *warga*, yang masing-masing memiliki hak akses dan fungsi berbeda.

Admin memiliki peran penting dalam mengelola sistem, seperti menambah, melihat, mengubah, dan menghapus data sumber air, melakukan uji kualitas air, serta mencatat dan memantau proses pendistribusian air ke berbagai daerah. Selain itu, admin juga dapat melihat dan menindaklanjuti laporan yang dibuat oleh warga untuk memastikan distribusi dan kualitas air berjalan dengan baik.

Sementara itu, warga dapat melakukan registrasi dan login ke sistem, membuat laporan terkait kondisi air di wilayahnya, serta melihat riwayat laporan yang pernah dibuat. Dengan sistem ini, proses pengawasan dan distribusi air bersih dapat dilakukan lebih efisien, transparan, dan mudah dipantau oleh semua pihak yang terlibat.

Seluruh data pada program ini tersimpan dalam basis data relasional yang terhubung antar entitas seperti *pengguna, sumber_air, kualitas_air, distribusi_air, daerah,* dan *laporan*, sehingga mendukung pengelolaan informasi secara terintegrasi dan akurat.

# USE CASE

<img width="943" height="1291" alt="Copy of Flowchart CAPSTONE-USE CASE drawio (1)" src="https://github.com/user-attachments/assets/aa4042d1-62c6-4920-a29a-291efed1cd40" />

# FLOWCHART

## Menu Utama

<img width="1034" height="1001" alt="Copy of Flowchart CAPSTONE-Menu Utama drawio (1)" src="https://github.com/user-attachments/assets/7895f59f-874c-45e8-83d9-4d71875cdfa7" />


## Menu Registrasi

<img width="765" height="921" alt="Copy of Flowchart CAPSTONE-Menu Registrasi drawio (1)" src="https://github.com/user-attachments/assets/63e08a95-ebd5-442d-bd39-99eba7a30d3a" />


## Menu Admin

<img width="280" height="962" alt="Copy of Flowchart CAPSTONE-Menu Admin drawio (1)" src="https://github.com/user-attachments/assets/5975122a-8190-437d-b2bf-125f23f5bb16" />


## Menu Warga

<img width="801" height="612" alt="Copy of Flowchart CAPSTONE-Menu Warga drawio (1)" src="https://github.com/user-attachments/assets/c8120af5-913e-46e9-86f8-38d2d211f121" />


## Kelola Sumber Air

<img width="1261" height="1302" alt="Copy of Flowchart CAPSTONE-Kelola Sumber Air drawio (1)" src="https://github.com/user-attachments/assets/f3e4f26e-bdd2-4332-89f4-adc41ef57112" />


## Uji Kualitas Air

<img width="1651" height="962" alt="Copy of Flowchart CAPSTONE-Uji Kualitas Air drawio (1)" src="https://github.com/user-attachments/assets/bd5be9c3-015e-4a86-9d0a-fb23193f00ad" />


## Kelola Laporan

<img width="1601" height="1012" alt="Copy of Flowchart CAPSTONE-Kelola Laporan drawio" src="https://github.com/user-attachments/assets/0534b846-1533-43b3-8d4e-117a37b37f46" />

## Distribusi Air

<img width="1981" height="840" alt="Copy of Flowchart CAPSTONE-Distribusi Air drawio (1)" src="https://github.com/user-attachments/assets/b6c667fa-6637-4dff-be0a-4a6de6b9afa7" />


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

<img width="231" height="185" alt="image" src="https://github.com/user-attachments/assets/0c892ddf-1121-493e-b413-dca73ed31860" />


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

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/f899049c-59e0-4171-b42e-18bd92630acd" />


2. Pada menu registrasi warga diminta untuk memasukkan Nama, Username, Password, No HP, dan Daerah.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/4e932051-5538-4b81-b8f7-f3bea20689d2" />


3. Registrasi berhasil.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/9ea61cc3-aa43-4d41-835a-43366ec9fb2a" />


4. Setelah berhasil melakukan registrasi maka tampilan akan kembali ke menu utama. Lalu masukkan username dan password yang telah diregistrasi tadi untuk melakukan login.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/2cc9d69b-d1ef-4e1d-ae15-bb8c315cb4fa" />


5. Akan muncul tampilan pop up yes/no, jika memilih yes maka akan masuk ke menu warga.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/735dd506-56a5-400f-9774-acd55124fc26" />

6. Lalu disini disambut dengan pop up selamat datang.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/93a62a2c-3085-4602-b39d-1b94c0e33119" />

7. Masuk ke menu warga. Di sini terdapat menu Buat Laporan dan Lihat Riwayat Distribusi

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/688be0a7-7a45-4cda-a5f3-6c7227560359" />

8. Di menu laporan warga bisa membuat laporan dengan memasukkan tanggal dan deskripsi.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/a999d4ff-cc2e-4269-a688-191b4ea11bf6" />

9. Jika menekan tombol kirim maka akan menampilkan pop up seperti gambar di bawah.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/61910f57-3cac-47b9-a74a-c0c26af929d4" />

10. Masuk ke menu Lihat Riwayat Distribusi. Di sini warga bisa melihat riwayat distribusi di setiap daerah.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/77c06a1d-456a-4a1f-b851-1a7dad2a228e" />

11. Jika menekan kembali dari dua menu warga tadi kita akan kembali ke menu warga. Jika menekan log out maka akan muncul pop up seperti gambar di bawah. Jika menekan Yes maka akan kembali ke menu utama.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/94cf6f57-0b91-47b1-bb27-fd94051e9495" />

12. Berhasil Log out.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/d1021036-2795-4228-bc36-dece3d67c402" />

13. Login menggunakan akun admin agar menjadi admin. Masukkan username dan password milik admin.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/5a70a973-c229-418f-830b-f2278c8e8008" />

14. Akan muncul pop up yes/no. Jika menekan yes maka akan masuk ke menu admin.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/f97f9a9a-947a-4118-905d-3931e51ed273" />

15. Akan muncul pop up selamat datang.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/490cf4e9-d4ec-409c-9b9b-d9c94fd36543" />

16. Masuk ke menu admin. Di sini terdapat menu Kelola Sumber Air, Uji Kualitas Air, Kelola Laporan, dan Distribusi Air.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/090d2b77-58d3-49a0-a1e9-aedf7100baae" />

17. Masuk ke menu kelola sumber air. Di sini admin menambah sumber air.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/70f8e725-301e-44b5-8b5b-a6641e00e62c" />

18. Jika ingin mengubah sumber air klik sumber yang ingin diubah lalu pencet tombol Edit Sumber.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/f90dc9f7-9118-4b7e-821e-7e1c4f3cecae" />

19. Akan muncul pop up konfirmasi yes/no.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/e100ecb5-e55d-444a-9c67-561f1c4379e7" />

20. Data sumber air berhasil dihapus.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/8a36b831-ebc2-4716-95c6-77919b25b5e8" />

21. Masuk ke menu Uji Kualitas Air. Di sini admin masukkan tanggal uji dan sumber airnya.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/2456d2fa-5ae1-4917-9cd8-0186c398bafc" />

22. Masuk ke menu Kelola Laporan. Di sini admin bisa melihat laporan dari warga dan menindaknya.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/ebbf81bd-b478-47eb-86c5-188da582d425" />

23. Masuk ke menu distribusi air. Di sini admin harus memasukkan sumber air, tanggal, dan volume untuk mendistribusikan air.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/9b90560d-5559-4a99-9585-cca85a5d344d" />

24. Jika memilih kembali dari semua menu admin tadi maka tampilan akan kembali ke menu admin. Jika memilih log out akan muncul pop up konfirmasi.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/ddbe7a90-e14b-4938-818f-6eb2ac3c0d2f" />

25. Berhasil logout.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/113a7d4b-a0f6-4715-b478-619488abeefb" />

26. Setelah logout berhasil maka tampilan akan kembali ke menu utama.

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/b55f6e35-c691-45b5-bdd7-75d237bb4abc" />
