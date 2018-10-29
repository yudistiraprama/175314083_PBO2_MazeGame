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
    
    public String toString(){
        return posisiX+","+posisiY+","+nilai;
    }
    
    public boolean isPemain(){
        if (nilai == '@') {
            return true;
        }
        return false;
    }
    
    public boolean isHAmbatan(){
        if (nilai == '#') {
            return true;
        }
        return false;
    }
    
    
}
