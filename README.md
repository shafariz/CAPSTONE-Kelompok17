# SISTEM PENDISTRIBUSIAN AIR BERSIH

# Deskripsi Singkat Program

Program *Sistem Pendistribusian Air Bersih* adalah aplikasi berbasis Java yang dirancang untuk membantu pengelolaan data dan proses distribusi air bersih secara terstruktur. Aplikasi ini memiliki dua jenis pengguna utama, yaitu *admin* dan *warga*, yang masing-masing memiliki hak akses dan fungsi berbeda.

Admin memiliki peran penting dalam mengelola sistem, seperti menambah, melihat, mengubah, dan menghapus data sumber air, melakukan uji kualitas air, serta mencatat dan memantau proses pendistribusian air ke berbagai daerah. Selain itu, admin juga dapat melihat dan menindaklanjuti laporan yang dibuat oleh warga untuk memastikan distribusi dan kualitas air berjalan dengan baik.

Sementara itu, warga dapat melakukan registrasi dan login ke sistem, membuat laporan terkait kondisi air di wilayahnya, serta melihat riwayat laporan yang pernah dibuat. Dengan sistem ini, proses pengawasan dan distribusi air bersih dapat dilakukan lebih efisien, transparan, dan mudah dipantau oleh semua pihak yang terlibat.

Seluruh data pada program ini tersimpan dalam basis data relasional yang terhubung antar entitas seperti *pengguna, sumber_air, kualitas_air, distribusi_air, daerah,* dan *laporan*, sehingga mendukung pengelolaan informasi secara terintegrasi dan akurat.


# Fitur Program

# Penerapan 5 Pilar OOP

## Encapsulation

## Inheritance

## Abstraction

## Polymorphism

## Interface

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


# Library dan Framework

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
