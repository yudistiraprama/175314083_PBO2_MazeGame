/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jarkom
 */
public class Tempat2 {

    private String isi;
    private int tinggi;
    private int lebar;

    public Tempat2() {
    }

    public Tempat2(String isi, int tinggi, int lebar) {
        this.isi = isi;
        this.tinggi = tinggi;
        this.lebar = lebar;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public int getLebar() {
        return lebar;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    public void simpanKonfigurasi(File file) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(isi.getBytes());
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tempat2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void bacaKonfigurasi(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            String hasilbaca = "";
            int dataInt;

            while ((dataInt = fis.read()) != -1) {
                if ((char) dataInt != '\n') {
                    if ((char) dataInt == '#') {
                        hasilbaca = hasilbaca + (char) dataInt;
                    } else if ((char) dataInt == '.') {
                        hasilbaca = hasilbaca + (char) dataInt;
                    } else if ((char) dataInt == 'O') {
                        hasilbaca = hasilbaca + (char) dataInt;
                    }
                }else{
                    hasilbaca = hasilbaca + '\n';
                }
            }
            this.setIsi(hasilbaca);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tempat2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int hitungJumlahKress() {
        int jumlah = 0;
        String[] data = getIsi().split("");
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals("#")) {
                jumlah = jumlah + (i + 1);
            }
        }
        return jumlah;
    }

    public int hitungJumlahO() {
        int jumlah = 0;
        String[] data = getIsi().split("");
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals("O")) {
                jumlah = jumlah + (i + 1);
            }
        }
        return jumlah;
    }

    public int hitungJumlahDot() {
        int jumlah = 0;
        String[] data = getIsi().split("");
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(".")) {
                jumlah = jumlah + (i + 1);
            }
        }
        return jumlah;
    }

    public void hitungLebar() {

    }

    public void hitungTinggi() {

    }
}
