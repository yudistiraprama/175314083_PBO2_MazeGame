/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user only
 */
public class Sel {

    private int posisiX;
    private int posisiY;
    private char nilai;

    public Sel() {
    }

    public Sel(int posisiX, int posisiY, char nilai) {
        this.posisiX = posisiX;
        this.posisiY = posisiY;
        this.nilai = nilai;
    }

    public int getPosisiX() {
        return posisiX;
    }

    public void setPosisiX(int posisiX) {
        this.posisiX = posisiX;
    }

    public int getPosisiY() {
        return posisiY;
    }

    public void setPosisiY(int posisiY) {
        this.posisiY = posisiY;
    }

    public char getNilai() {
        return nilai;
    }

    public void setNilai(char nilai) {
        this.nilai = nilai;
    }

    @Override
    public String toString() {
        return posisiX + "," + posisiY + "," + nilai;
    }

    public boolean isPemain() {
        return nilai == '@';
    }

    public boolean isHambatan() {
        return nilai == '#';
    }
}
