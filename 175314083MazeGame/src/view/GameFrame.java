/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Sel;
import model.Tempat;

/**
 *
 * @author user only
 */
public class GameFrame extends JFrame {

    private TempatPanel tempatPanel;

    private JLabel perintahlabel;
    private JTextField perintahText;
    private JButton okButton;
    private JButton undoButton;
    private JButton redoButton;
    private JButton tambahButton;
    private JButton hapusButton;

    private JMenuBar menuBar;
    private JMenu gameMenu;
    private JMenuItem exitMenuItem;
    private JMenuItem bacaKonfigurasiMenuItem;
    private JMenuItem simpanKonfigurasiMenuItem;

    public GameFrame(String title) {
        this.setTitle(title);
        this.init();
    }

    public GameFrame(String title, TempatPanel tempatPanel) {
        setTitle(title);
        this.tempatPanel = tempatPanel;
        this.init();
    }

    public void init() {
        // set ukuran dan layout
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());

        // set menu Bar
        menuBar = new JMenuBar();
        gameMenu = new JMenu("Game");
        exitMenuItem = new JMenuItem("Keluar");
        bacaKonfigurasiMenuItem = new JMenuItem("Baca");
        simpanKonfigurasiMenuItem = new JMenuItem("Simpan");
        gameMenu.add(bacaKonfigurasiMenuItem);
        gameMenu.add(simpanKonfigurasiMenuItem);
        gameMenu.add(exitMenuItem);
        menuBar.add(gameMenu);
        setJMenuBar(menuBar);

        bacaKonfigurasiMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser jf = new JFileChooser();
                int returnVal = jf.showOpenDialog(null);
                Tempat tempat = new Tempat();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    tempat.bacaKonfigurasi(jf.getSelectedFile());
                }
                Tempat.batasKanan = 500;
                Tempat.batasBawah = 500;
                // buat tempatPanel dan tambahkan tempat ke tempatPanel
                tempatPanel = new TempatPanel();
                tempatPanel.setTempat(tempat);
                init();
            }
        }
        );

        simpanKonfigurasiMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int returnVal = fc.showSaveDialog(null);
                Tempat tempat = new Tempat();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    tempat.setIsi(getTempatPanel().getTempat().getIsi());
                    tempat.simpanKonfigurasi(fc.getSelectedFile());
                }
            }
        });

        //action perform for exitMenuItem
        exitMenuItem.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                System.exit(0);
            }
        }
        );

        // panel selatan
        JPanel southPanel = new JPanel();

        southPanel.setLayout(
                new FlowLayout());

        this.perintahlabel = new JLabel("Perintah");

        southPanel.add(perintahlabel);

        this.perintahText = new JTextField(20);

        southPanel.add(perintahText);

        this.okButton = new JButton("Ok");

        southPanel.add(okButton);

        okButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                String x = perintahText.getText().substring(0, 1);
                if (perintahText.getText().equalsIgnoreCase((x) + "L")) {
                    int y = Integer.valueOf(x);
                    pindahKiri(y);
                } else if (perintahText.getText().equalsIgnoreCase((x) + "R")) {
                    int y = Integer.valueOf(x);
                    pindahKanan(y);
                } else if (perintahText.getText().equalsIgnoreCase((x) + "U")) {
                    int y = Integer.valueOf(x);
                    pindahAtas(y);
                } else if (perintahText.getText().equalsIgnoreCase((x) + "D")) {
                    int y = Integer.valueOf(x);
                    pindahBawah(y);
                }
            }
        }
        );

        this.undoButton = new JButton("Undo");

        southPanel.add(undoButton);

        undoButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                String x = perintahText.getText().substring(0, 1);
                if (perintahText.getText().equalsIgnoreCase((x) + "L")) {
                    int y = Integer.valueOf(x);
                    pindahKanan(y);
                } else if (perintahText.getText().equalsIgnoreCase((x) + "R")) {
                    int y = Integer.valueOf(x);
                    pindahKiri(y);
                } else if (perintahText.getText().equalsIgnoreCase((x) + "U")) {
                    int y = Integer.valueOf(x);
                    pindahBawah(y);
                } else if (perintahText.getText().equalsIgnoreCase((x) + "D")) {
                    int y = Integer.valueOf(x);
                    pindahAtas(y);
                }
            }
        }
        );

        this.redoButton = new JButton("Redo");

        southPanel.add(redoButton);

        redoButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                String x = perintahText.getText().substring(0, 1);
                if (perintahText.getText().equalsIgnoreCase((x) + "L")) {
                    int y = Integer.valueOf(x);
                    pindahKanan(y);
                } else if (perintahText.getText().equalsIgnoreCase((x) + "R")) {
                    int y = Integer.valueOf(x);
                    pindahKiri(y);
                } else if (perintahText.getText().equalsIgnoreCase((x) + "U")) {
                    int y = Integer.valueOf(x);
                    pindahBawah(y);
                } else if (perintahText.getText().equalsIgnoreCase((x) + "D")) {
                    int y = Integer.valueOf(x);
                    pindahAtas(y);
                }
            }
        }
        );

//        this.tambahButton = new JButton("tambahBola");
//
//        southPanel.add(tambahButton);
//
//        tambahButton.addActionListener(
//                new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e
//            ) {
//                tambahBola();
//            }
//        }
//        );
//
//        this.hapusButton = new JButton("hapusBola");
//
//        southPanel.add(hapusButton);
//
//        hapusButton.addActionListener(
//                new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e
//            ) {
//                hapusBola();
//            }
//        }
//        );
        // set contentPane
        Container cp = this.getContentPane();
        if (tempatPanel
                != null) {
            cp.add(getTempatPanel(), BorderLayout.CENTER);
        }

        cp.add(southPanel, BorderLayout.SOUTH);

        // set visible= true
        this.setVisible(
                true);
    }

    /**
     * Fungsi untuk tambahBola
     */
    public void tambahBola() {
        tempatPanel.getTempat().tambahSel(new Sel(0, 0, 40, 40, '@', Color.BLUE));
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }

    /**
     * Fungsi hapus bola
     */
    public void hapusBola() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                tempatPanel.getTempat().hapusSel(getTempatPanel().getTempat().getDaftarSel().get(i));
                // gambar ulang tempat Panel
                getTempatPanel().repaint();
                break;
            }
        }
    }

    /**
     * Fungsi untuk memindahkan sel dan menggambar ulang
     * @param x
     */
    public void pindahKanan(int x) {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke kanan
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserKanan(x);
                getTempatPanel().getTempat().getDaftarSel().get(i + x).geserKiri(x);
            }
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
        Tempat tmp = new Tempat();
        tmp.setDaftarSel(getTempatPanel().getTempat().getDaftarSel());
        tmp.setIsi(getTempatPanel().getTempat().getIsi());
        tempatPanel.setTempat(tmp);
    }

    public void pindahKiri(int x) {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke kiri
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserKiri(x);
                getTempatPanel().getTempat().getDaftarSel().get(i - x).geserKanan(x);
            }
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
        Tempat tmp = new Tempat();
        tmp.setDaftarSel(getTempatPanel().getTempat().getDaftarSel());
        tmp.setIsi(getTempatPanel().getTempat().getIsi());
        tempatPanel.setTempat(tmp);
    }

    public void pindahAtas(int x) {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke atas
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserAtas(x);
                getTempatPanel().getTempat().getDaftarSel().get(i - 8 * x).geserBawah(x);
            }
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
        Tempat tmp = new Tempat();
        tmp.setDaftarSel(getTempatPanel().getTempat().getDaftarSel());
        tmp.setIsi(getTempatPanel().getTempat().getIsi());
        tempatPanel.setTempat(tmp);
    }

    public void pindahBawah(int x) {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke bawah
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserBawah(x);
                getTempatPanel().getTempat().getDaftarSel().get(i + 8 * x).geserAtas(x);
            }
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
        Tempat tmp = new Tempat();
        tmp.setDaftarSel(getTempatPanel().getTempat().getDaftarSel());
        tmp.setIsi(getTempatPanel().getTempat().getIsi());
        tempatPanel.setTempat(tmp);
    }

    /**
     * @return the tempatPanel
     */
    public TempatPanel getTempatPanel() {
        return tempatPanel;
    }

    /**
     * @param tempatPanel the tempatPanel to set
     */
    public void setTempatPanel(TempatPanel tempatPanel) {
        this.tempatPanel = tempatPanel;
    }

}
