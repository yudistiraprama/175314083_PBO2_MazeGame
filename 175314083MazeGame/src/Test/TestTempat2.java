/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.File;
import model.Tempat2;

/**
 *
 * @author jarkom
 */
public class TestTempat2 {
    public static void main(String[] args) {
        Tempat2 test = new Tempat2();
        test.setIsi("######"
                + "\n#...O#"
                + "\n#..O.#"
                + "\n######");
        test.simpanKonfigurasi(new File("tempat2.txt"));
    }
}
