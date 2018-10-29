/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author user only
 */
public class Tempat {

    private int tinggi;
    private int lebar;
    private ArrayList<Sel> isi = new ArrayList<Sel>();

    public void bacaConfigurasi(File file) {

    }

    public void simpanConfigurasi(File file) {

    }

    private Sel cariPemain() {
        for (int i = 0; i < isi.size(); i++) {
            if (isi.get(i).isPemain()) {
                return isi.get(i);
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
