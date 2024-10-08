/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spk;
import java.awt.Color;
import java.sql.*;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import koneksi.koneksi;

/**
 *
 * @author Joko Prasetyo Utomo
 */
public class dataGuru extends javax.swing.JFrame {
    String adminName;
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    String oldId = null;
 
    
    public void displayUsername() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT username FROM login"; // Query untuk mengambil username dari tabel login
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();

            if (rs.next()) {
                String username = rs.getString("username");
                nama.setText("Hai "+username); // Menetapkan nama username ke jLabel5
            } else {
                JOptionPane.showMessageDialog(null, "Data username tidak ditemukan");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stat != null) stat.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error closing statement or result set: " + e.getMessage());
            }
        }
    }
    protected void aktif() {
        idGuru.setEnabled(true);
        namaGuru.setEnabled(true);
        usia1.setEnabled(true);
        mengajar.requestFocus();;
    }

    protected void kosong() {
        idGuru.setEnabled(true);
        namaGuru.setEnabled(true);
        usia1.setEnabled(true);
        mengajar.requestFocus();;
        idGuru.setText("");
        namaGuru.setText("");
        usia1.setText("");
        priaButton.setSelected(true);
        mengajar.setText("");
    }
    private void dataTable() {
        Object[] Baris = {"Id Guru", "Nama Guru", "Usia Guru", "kelamin", "Lama Mengajar"};
        tabmode = new DefaultTableModel(null, Baris);
        jTable1.setModel(tabmode);
        String sql = "select * from gurutabel";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String idGuru = hasil.getString("idGuru");
                String namaGuru = hasil.getString("namaGuru");
                String usiaGuru = hasil.getString("usiaGuru");
                String kelamin = hasil.getString("kelamin");
                String lamaMengajar = hasil.getString("lamaMengajar");

                String[] data = {idGuru, namaGuru, usiaGuru, kelamin, lamaMengajar};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * Creates new form home
     */
      private void setWelcomeMessage(JLabel tanggal) {
        String today = getFormattedDate();  
        tanggal.setText("Selamat datang. Sekarang hari " + today + " di Smk Yappa Depok");   
    }

    private String getFormattedDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("id", "ID"));
        return today.format(formatter);
    }
    
    public dataGuru() {
        nama = new javax.swing.JLabel();
        initComponents();
        displayUsername();
        dataTable();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setWelcomeMessage(tanggal);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kelamin = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        idTeks1 = new javax.swing.JLabel();
        idGuru = new javax.swing.JTextField();
        namaTeks = new javax.swing.JLabel();
        namaGuru = new javax.swing.JTextField();
        usiaTeks = new javax.swing.JLabel();
        usia1 = new javax.swing.JTextField();
        mengajarTeks = new javax.swing.JLabel();
        mengajar = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delet = new javax.swing.JButton();
        idKelamin = new javax.swing.JLabel();
        priaButton = new javax.swing.JRadioButton();
        perempuan = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tanggal = new javax.swing.JLabel();
        nama = new javax.swing.JLabel();
        buttonCsfs = new javax.swing.JButton();
        rank = new javax.swing.JButton();
        buttonAwal = new javax.swing.JButton();
        report = new javax.swing.JButton();
        buttonKelas = new javax.swing.JButton();
        back = new javax.swing.JButton();
        buttonGuru3 = new javax.swing.JButton();
        buttonkonvert = new javax.swing.JButton();
        buttonAkhir = new javax.swing.JButton();
        buttonGap = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idTeks1.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        idTeks1.setText("Id Guru                 :");
        jPanel1.add(idTeks1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 140, -1));

        idGuru.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jPanel1.add(idGuru, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 90, -1));

        namaTeks.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        namaTeks.setText("Nama Guru         :");
        jPanel1.add(namaTeks, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, 140, -1));

        namaGuru.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jPanel1.add(namaGuru, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 90, -1));

        usiaTeks.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        usiaTeks.setText("Usia                      :");
        jPanel1.add(usiaTeks, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 130, -1));

        usia1.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jPanel1.add(usia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, 90, -1));

        mengajarTeks.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        mengajarTeks.setText("Lama Mengajar  :");
        jPanel1.add(mengajarTeks, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 140, -1));

        mengajar.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jPanel1.add(mengajar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 580, 90, -1));

        save.setText("Simpan");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, -1, -1));

        edit.setText("Ubah");
        edit.setMaximumSize(new java.awt.Dimension(67, 23));
        edit.setMinimumSize(new java.awt.Dimension(67, 23));
        edit.setPreferredSize(new java.awt.Dimension(67, 23));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel1.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, -1, -1));

        delet.setText("Hapus");
        delet.setPreferredSize(new java.awt.Dimension(67, 23));
        delet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletActionPerformed(evt);
            }
        });
        jPanel1.add(delet, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 540, -1, -1));

        idKelamin.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        idKelamin.setText("Jenis Kelamin     :");
        jPanel1.add(idKelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, 140, -1));

        kelamin.add(priaButton);
        priaButton.setText("Laki - laki");
        jPanel1.add(priaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 520, -1, -1));

        kelamin.add(perempuan);
        perempuan.setText("Perempuan");
        jPanel1.add(perempuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 550, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 410, 590, 240));

        tanggal.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 18)); // NOI18N
        tanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal.setText("jLabel1");
        jPanel1.add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 280, 1120, 120));

        nama.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nama.setForeground(new java.awt.Color(255, 255, 255));
        nama.setText("nama");
        jPanel1.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 80, -1, -1));

        buttonCsfs.setBackground(new java.awt.Color(135, 104, 61));
        buttonCsfs.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonCsfs.setText("Nilai CFSF");
        buttonCsfs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCsfsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonCsfsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonCsfsMouseExited(evt);
            }
        });
        jPanel1.add(buttonCsfs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 140, 40));

        rank.setBackground(new java.awt.Color(135, 104, 61));
        rank.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rank.setText("Ranking");
        rank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rankMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rankMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rankMouseExited(evt);
            }
        });
        rank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankActionPerformed(evt);
            }
        });
        jPanel1.add(rank, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 140, 40));

        buttonAwal.setBackground(new java.awt.Color(135, 104, 61));
        buttonAwal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonAwal.setText("Nilai Awal");
        buttonAwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAwalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAwalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAwalMouseExited(evt);
            }
        });
        jPanel1.add(buttonAwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 140, 40));

        report.setBackground(new java.awt.Color(135, 104, 61));
        report.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        report.setText("Laporan");
        report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportMouseExited(evt);
            }
        });
        jPanel1.add(report, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 140, 40));

        buttonKelas.setBackground(new java.awt.Color(135, 104, 61));
        buttonKelas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonKelas.setText("Data Kelas");
        buttonKelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonKelasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonKelasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonKelasMouseExited(evt);
            }
        });
        jPanel1.add(buttonKelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 140, 40));

        back.setBackground(new java.awt.Color(135, 104, 60));
        back.setText("Back");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMouseExited(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        buttonGuru3.setBackground(new java.awt.Color(135, 104, 61));
        buttonGuru3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonGuru3.setText("Data Guru");
        buttonGuru3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonGuru3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonGuru3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonGuru3MouseExited(evt);
            }
        });
        jPanel1.add(buttonGuru3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 140, 40));

        buttonkonvert.setBackground(new java.awt.Color(135, 104, 61));
        buttonkonvert.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonkonvert.setText("Konversi Gap");
        buttonkonvert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonkonvertMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonkonvertMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonkonvertMouseExited(evt);
            }
        });
        buttonkonvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonkonvertActionPerformed(evt);
            }
        });
        jPanel1.add(buttonkonvert, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 140, 40));

        buttonAkhir.setBackground(new java.awt.Color(135, 104, 61));
        buttonAkhir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonAkhir.setText("Nilai Akhir");
        buttonAkhir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAkhirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAkhirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAkhirMouseExited(evt);
            }
        });
        jPanel1.add(buttonAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 140, 40));

        buttonGap.setBackground(new java.awt.Color(135, 104, 61));
        buttonGap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonGap.setText("Hitung Awal");
        buttonGap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonGapMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonGapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonGapMouseExited(evt);
            }
        });
        jPanel1.add(buttonGap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 140, 40));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg/bgj.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1420, 790));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1360, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
          String sql= "insert into gurutabel values (?,?,?,?,?)";
        try{
            PreparedStatement stat= conn.prepareStatement(sql);
            stat.setString(1, idGuru.getText());
            stat.setString(2, namaGuru.getText());         
            stat.setString(3, usia1.getText());
            String kelamin= "";
            if(priaButton.isSelected()) kelamin= "Laki - Laki";
            else kelamin= "Perempuan";
            stat.setString(4, kelamin);
            stat.setString(5, mengajar.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Simpan");
            kosong();
            idGuru.requestFocus();
            dataTable();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null, "gagal");
        }
    }//GEN-LAST:event_saveActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
          try {
       String sql = "UPDATE gurutabel SET namaGuru=?, usiaGuru=?, kelamin=?, lamaMengajar=?, idGuru=? WHERE idGuru=?";
       PreparedStatement stat= conn.prepareStatement(sql);
  
            stat.setString(1, namaGuru.getText());         
            stat.setString(2, usia1.getText());
            String kelamin= "";
            if(priaButton.isSelected()) kelamin= "Laki - Laki";
            else kelamin= "Perempuan";
            stat.setString(3, kelamin);
            stat.setString(4, mengajar.getText());
            stat.setString(5, idGuru.getText());
            stat.setString(6, oldId);
            
       stat.executeUpdate();
       JOptionPane.showMessageDialog(null, "Berhasil Update");
       kosong();
       idGuru.requestFocus();
       dataTable();
    } catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Gagal Update: " + e.getMessage());
}
  

    }//GEN-LAST:event_editActionPerformed

    private void deletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletActionPerformed
        // TODO add your handling code here:
          int ok=JOptionPane.showConfirmDialog(null, "Hapus", "Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            String sql= "delete from gurutabel where idGuru = '"+idGuru.getText()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong();
                idGuru.requestFocus();
                dataTable();
            }catch(SQLException e){
                 JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
            }
        }
    }//GEN-LAST:event_deletActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int bar = jTable1.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        
        System.out.println(a+" "+b+" "+c+" "+d+" "+e);
        
        this.oldId = a;
        idGuru.setText(a);
        namaGuru.setText(b);
        usia1.setText(c);
        if (d.equals("Laki - Laki")) {
            priaButton.setSelected(true);
            perempuan.setSelected(false);
            } else {
                    priaButton.setSelected(false);
                    perempuan.setSelected(true);
            }
            mengajar.setText(e);  // 
    }//GEN-LAST:event_jTable1MouseClicked

    private void buttonCsfsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCsfsMouseClicked
        // TODO add your handling code here:
        hitungCFSF cfsf=new hitungCFSF();
        cfsf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonCsfsMouseClicked

    private void buttonCsfsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCsfsMouseEntered
        // TODO add your handling code here:
        buttonCsfs.setBackground(new Color(160, 127, 82));
    }//GEN-LAST:event_buttonCsfsMouseEntered

    private void buttonCsfsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCsfsMouseExited
        // TODO add your handling code here:
        buttonCsfs.setBackground(new Color(135, 104, 60));
    }//GEN-LAST:event_buttonCsfsMouseExited

    private void rankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rankMouseClicked
        // TODO add your handling code here:
        ranking rk=new ranking();
        rk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rankMouseClicked

    private void rankMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rankMouseEntered
        // TODO add your handling code here:
        rank.setBackground(new Color(160, 127, 82));
    }//GEN-LAST:event_rankMouseEntered

    private void rankMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rankMouseExited
        // TODO add your handling code here:
        rank.setBackground(new Color(135, 104, 60));
    }//GEN-LAST:event_rankMouseExited

    private void rankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankActionPerformed
        // TODO add your handling code here:
        ranking rk=new ranking();
        rk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rankActionPerformed

    private void buttonAwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAwalMouseClicked
        // TODO add your handling code here:
        hitungAwal awal=new hitungAwal();
        awal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonAwalMouseClicked

    private void buttonAwalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAwalMouseEntered
        // TODO add your handling code here:
        buttonAwal.setBackground(new Color(160, 127, 82));
    }//GEN-LAST:event_buttonAwalMouseEntered

    private void buttonAwalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAwalMouseExited
        // TODO add your handling code here:
        buttonAwal.setBackground(new Color(135, 104, 60));
    }//GEN-LAST:event_buttonAwalMouseExited

    private void reportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMouseClicked
        // TODO add your handling code here:
        laporan rp=new laporan();
        rp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_reportMouseClicked

    private void reportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMouseEntered
        // TODO add your handling code here:
        report.setBackground(new Color(160, 127, 82));
    }//GEN-LAST:event_reportMouseEntered

    private void reportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMouseExited
        // TODO add your handling code here:
        report.setBackground(new Color(135, 104, 60));
    }//GEN-LAST:event_reportMouseExited

    private void buttonKelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonKelasMouseClicked
        // TODO add your handling code here:
        dataKelas kelas=new dataKelas();
        kelas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonKelasMouseClicked

    private void buttonKelasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonKelasMouseEntered
        // TODO add your handling code here:

        buttonKelas.setBackground(new Color(160, 127, 82));
    }//GEN-LAST:event_buttonKelasMouseEntered

    private void buttonKelasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonKelasMouseExited
        // TODO add your handling code here:[154,100,61]
        buttonKelas.setBackground(new Color(135, 104, 60));
    }//GEN-LAST:event_buttonKelasMouseExited

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        // TODO add your handling code here:
        back.setBackground(new Color(210, 4, 45));
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        // TODO add your handling code here:
        back.setBackground(new Color(135, 104, 60));
    }//GEN-LAST:event_backMouseExited

    private void buttonGuru3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonGuru3MouseClicked
        // TODO add your handling code here:
        dataGuru guru=new dataGuru();
        guru.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonGuru3MouseClicked

    private void buttonGuru3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonGuru3MouseEntered
        // TODO add your handling code here:
        buttonGuru3.setBackground(new Color(160, 127, 82));
    }//GEN-LAST:event_buttonGuru3MouseEntered

    private void buttonGuru3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonGuru3MouseExited
        // TODO add your handling code here:
        buttonGuru3.setBackground(new Color(135, 104, 60));
    }//GEN-LAST:event_buttonGuru3MouseExited

    private void buttonkonvertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonkonvertMouseClicked
        // TODO add your handling code here:
        hitungGAP gap=new hitungGAP();
        gap.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonkonvertMouseClicked

    private void buttonkonvertMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonkonvertMouseEntered
        // TODO add your handling code here:
        buttonkonvert.setBackground(new Color(160, 127, 82));
    }//GEN-LAST:event_buttonkonvertMouseEntered

    private void buttonkonvertMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonkonvertMouseExited
        // TODO add your handling code here:
        buttonkonvert.setBackground(new Color(135, 104, 60));
    }//GEN-LAST:event_buttonkonvertMouseExited

    private void buttonkonvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonkonvertActionPerformed
        // TODO add your handling code here:
        gapkonvert gp=new gapkonvert();
        gp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonkonvertActionPerformed

    private void buttonAkhirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAkhirMouseClicked
        // TODO add your handling code here:
        menuHasil end=new menuHasil();
        end.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonAkhirMouseClicked

    private void buttonAkhirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAkhirMouseEntered
        // TODO add your handling code here:
        buttonAkhir.setBackground(new Color(160, 127, 82));
    }//GEN-LAST:event_buttonAkhirMouseEntered

    private void buttonAkhirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAkhirMouseExited
        // TODO add your handling code here:
        buttonAkhir.setBackground(new Color(135, 104, 60));
    }//GEN-LAST:event_buttonAkhirMouseExited

    private void buttonGapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonGapMouseClicked
        // TODO add your handling code here:
        hitungGAP hg=new hitungGAP();
        hg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonGapMouseClicked

    private void buttonGapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonGapMouseEntered
        // TODO add your handling code here:
        back.setBackground(new Color(210, 4, 45));
    }//GEN-LAST:event_buttonGapMouseEntered

    private void buttonGapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonGapMouseExited
        // TODO add your handling code here:
        back.setBackground(new Color(135, 104, 60));
    }//GEN-LAST:event_buttonGapMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dataGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dataGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dataGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dataGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dataGuru().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel bg;
    private javax.swing.JButton buttonAkhir;
    private javax.swing.JButton buttonAwal;
    private javax.swing.JButton buttonCsfs;
    private javax.swing.JButton buttonGap;
    private javax.swing.JButton buttonGuru3;
    private javax.swing.JButton buttonKelas;
    private javax.swing.JButton buttonkonvert;
    private javax.swing.JButton delet;
    private javax.swing.JButton edit;
    private javax.swing.JTextField idGuru;
    private javax.swing.JLabel idKelamin;
    private javax.swing.JLabel idTeks1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.ButtonGroup kelamin;
    private javax.swing.JTextField mengajar;
    private javax.swing.JLabel mengajarTeks;
    private javax.swing.JLabel nama;
    private javax.swing.JTextField namaGuru;
    private javax.swing.JLabel namaTeks;
    private javax.swing.JRadioButton perempuan;
    private javax.swing.JRadioButton priaButton;
    private javax.swing.JButton rank;
    private javax.swing.JButton report;
    private javax.swing.JButton save;
    private javax.swing.JLabel tanggal;
    private javax.swing.JTextField usia1;
    private javax.swing.JLabel usiaTeks;
    // End of variables declaration//GEN-END:variables
}
