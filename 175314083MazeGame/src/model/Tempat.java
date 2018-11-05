/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user only
 */
public class Tempat {

    private int tinggi;
    private int lebar;
    private ArrayList<Sel> isiTempat = new ArrayList<Sel>();

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

    public ArrayList<Sel> getIsiTempat() {
        return isiTempat;
    }

    public void setIsiTempat(ArrayList<Sel> isiTempat) {
        this.isiTempat = isiTempat;
    }

    public void bacaFileKonfigurasi(File file) {
        try {

            String HasilBaca = "";
            int dataInt = 0;
            FileInputStream fis = new FileInputStream(file);
            int baris = 0;

            while ((dataInt = fis.read()) != -1) {
                if ((char) dataInt == '\n') {
                    for (int i = 0; i < HasilBaca.length(); i++) {
                        Sel sel = new Sel();
                        sel.setNilai(HasilBaca.charAt(i));
                        sel.setPosisiX(baris);
                        sel.setPosisiY(i);
                        isiTempat.add(sel);
                    }
                    tinggi++;
                    baris++;
                    HasilBaca = "";
                } else {
                    HasilBaca = HasilBaca + (char) dataInt;
                    lebar++;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void simpanConfigurasi(File file) {

    }

    private Sel cariPemain() {
        for (int i = 0; i < isiTempat.size(); i++) {
            if (isiTempat.get(i).isPemain()) {
                return isiTempat.get(i);
            }
        }
        return null;
    }

    public void up(int langkah) {

    }

    public void down(int langkah) {

    }

    public void left(int langkah) {

    }

    public void right(int langkah) {

    }
}
