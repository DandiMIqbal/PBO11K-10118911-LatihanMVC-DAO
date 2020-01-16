/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dandimiqbal.latihanmvcjdbc.controller;

import edu.dandimiqbal.latihanmvcjdbc.model.PelangganModel;
import edu.dandimiqbal.latihanmvcjdbc.view.PelangganView;
import javax.swing.JOptionPane;

/**
 * NIM   : 10118911
 * NAMA  : DANDI MUHAMMAD IQBAL
 * KELAS : IF11K
 */
public class PelangganController {

    private PelangganModel model;

    public void setModel(PelangganModel model) {
        this.model = model;
    }

    public void resetPelanggan(PelangganView view) {
        model.resetPelangggan();
    }

    public void insertPelanggan(PelangganView view) {
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();

        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else if (nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh lebih dari 255 karakter");
        } else if (telepon.length() > 12) {
            JOptionPane.showMessageDialog(view, "Nomor telepon tidak boleh lebih dari 12 digit");
        } else if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email tidak valid");
        } else {
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);

            try {
                model.insertPelangggan();
                JOptionPane.showMessageDialog(view, "Data Pelanggan Berhasil Ditambahkan");
                model.resetPelangggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan ", throwable.getMessage()});
            }
        }
    }

    public void updatePelanggan(PelangganView view) {
        if (view.getTablePelanggan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan seleksi baris data yang akan di ubah");
            return;
        }

        Integer id = Integer.parseInt(view.getTxtId().getText());
        String nama = view.getTxtNama().getText();
        String alamat = view.getTxtAlamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtEmail().getText();

        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong");
        } else if (nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh lebih dari 255 karakter");
        } else if (telepon.length() > 12) {
            JOptionPane.showMessageDialog(view, "Nomor telepon tidak boleh lebih dari 12 digit");
        } else if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email tidak valid");
        } else {
            model.setId(id);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);

            try {
                model.updatePelangggan();
                JOptionPane.showMessageDialog(view, "Data Pelanggan Berhasil Di Ubah");
                model.resetPelangggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan ", throwable.getMessage()});
            }
        }
    }

    public void deletePelanggan(PelangganView view) {
        if (view.getTablePelanggan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan seleksi baris data yang akan di hapus");
            return;
        }

        if (JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus?")== JOptionPane.OK_OPTION) {
            Integer id = Integer.parseInt(view.getTxtId().getText());
            model.setId(id);
            
            try {
                model.deletePelangggan();
                JOptionPane.showMessageDialog(view, "Data Pelanggan Berhasil Di Hapus");
                model.resetPelangggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan ", throwable.getMessage()});
            }
        }
    }

}
