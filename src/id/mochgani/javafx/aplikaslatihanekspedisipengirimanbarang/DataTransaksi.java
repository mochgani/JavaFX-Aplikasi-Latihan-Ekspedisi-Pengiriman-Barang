package id.mochgani.javafx.aplikaslatihanekspedisipengirimanbarang;

import java.util.Scanner;

public class DataTransaksi extends Resi {
    public String namaPengirim;
    public String alamatPengirim;
    public String noTeleponPengirim;
    public String namaPenerima;
    public String alamatPenerima;
    public String kotaPenerima;
    public String noTeleponPenerima;
    public double berat;
    public String jenisBarang;
    public String keterangan;
    public String layanan;
    Scanner sc = new Scanner(System.in);
    
    public void inputDataPengirim(String nama, String alamat, String noTelepon){
        
        namaPengirim = nama;
        alamatPengirim = alamat;
        noTeleponPengirim = noTelepon;
        
    }
    
    public void inputDataPenerima(String nama, String alamat, String noTelepon){
        
        namaPenerima = nama;
        alamatPenerima = alamat;
        noTeleponPenerima = noTelepon;
        
    }
    
    public double inputDataBarang(String kota, String tipe, String jenis, double berat, String keteranganBarang){
        
        Tujuan tujuan = new Tujuan();
        
        tujuan.kotaLayanan = kota;
        tujuan.tipeLayanan = tipe;
        tujuan.pilihLayanan(kota, tipe);
        
        kotaPenerima = kota;
        layanan = tipe;
        jenisBarang = jenis;
        keterangan = keteranganBarang;
        
        this.berat = berat;
        return tujuan.kalkulasiHarga(berat);
        
    }
    
}