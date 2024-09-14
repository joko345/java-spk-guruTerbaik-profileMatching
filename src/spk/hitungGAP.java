/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spk;
import java.sql.*;
import java.time.LocalDate;
import java.util.Locale;
import java.awt.Color;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
/**
 *
 * @author Joko Prasetyo Utomo
 */
public class hitungGAP extends javax.swing.JFrame {
private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    String oldId = null;
    /**
     * Creates new form home
     */

 protected void aktif() {
        idGap.setEnabled(true);
        idGuru.setEnabled(false);
        disiplin.setEnabled(false);
        komitmen.setEnabled(false);
        loyal.setEnabled(false);
        prestasi.setEnabled(false);
        idGap.requestFocus();;
    }

    protected void kosong() {
        idGap.setText("");
        idGuru.setText("");
        disiplin.setText("");
        komitmen.setText("");
        loyal.setText("");
        prestasi.setText("");
        nilaiGap.setText("");
    }
private void dataTable() {
    Object[] Baris = {"Id Gap", "Nilai Awal","Id Guru", "Nama Guru", "Disiplin", "Komitmen", "Loyal", "Prestasi", "Target"};
    tabmode = new DefaultTableModel(null, Baris);
    jTable1.setModel(tabmode);
    
    String sql = "SELECT a.nilaiAwal, a.nilaiDisiplin, a.nilaiPrestasi, a.nilaiKomitmen, a.nilaiLoyal,  a.idGuru, a.namaGuru, g.idGap, g.nilaiGap " +
                 "FROM gaptabel g " +
                 "JOIN awaltabel a ON a.nilaiAwal = g.nilaiAwal";

    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        
        while (hasil.next()) {
            String idGap = hasil.getString("idGap");
            String nilaiAwal = hasil.getString("nilaiAwal");
            String idGuru = hasil.getString("idGuru");
            String namaGuru = hasil.getString("namaGuru");
            String disiplin = hasil.getString("nilaiDisiplin");
            String komitmen = hasil.getString("nilaiKomitmen");
            String loyal = hasil.getString("nilaiLoyal");
            String prestasi = hasil.getString("nilaiPrestasi");
            String gap = hasil.getString("nilaiGap");
            
            String[] data = {idGap, nilaiAwal, idGuru, namaGuru, disiplin, komitmen, loyal, prestasi, gap};
            tabmode.addRow(data);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
    private void dataGap() {
        Object[] Baris ={"Id Gap", "nilaiAwal","id Guru", "Nama Guru", "Disiplin", "Komitmen", "Loyal", "Prestasi", "Target"};
        tabmode = new DefaultTableModel(null, Baris);
        jTable1.setModel(tabmode);
        String sql = "select * from gaptabel";
        try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        
        while (hasil.next()) {
            String idGap = hasil.getString("idGap");
            String nilaiAwal = hasil.getString("nilaiAwal");
            String idGuru = hasil.getString("idGuru");
            String namaGuru = hasil.getString("namaGuru");
            String disiplin = hasil.getString("nilaiDisiplin");
            String komitmen = hasil.getString("nilaiKomitmen");
            String loyal = hasil.getString("nilaiLoyal");
            String prestasi = hasil.getString("nilaiPrestasi");
            String gap = hasil.getString("nilaiGap");
            
            String[] data = {idGap, nilaiAwal, idGuru, namaGuru, disiplin, komitmen, loyal, prestasi, gap};
            tabmode.addRow(data);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
     private void setWelcomeMessage(JLabel tanggal) {
        String today = getFormattedDate();  
        tanggal.setText("Selamat datang. Sekarang hari " + today + " di Smk Yappa Depok");   
    }

    private String getFormattedDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("id", "ID"));
        return today.format(formatter);
    }
    
    /**
     * Creates new form home
     */
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
    public hitungGAP() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        displayUsername();
        dataTable();
        setWelcomeMessage(tanggal);
        dataGap();
        setIdGuru();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        gapteks = new javax.swing.JLabel();
        idGap = new javax.swing.JTextField();
        awalTeks = new javax.swing.JLabel();
        boxAwal = new javax.swing.JComboBox<>();
        guruTeks = new javax.swing.JLabel();
        idGuru = new javax.swing.JTextField();
        namaGuru = new javax.swing.JTextField();
        nama1 = new javax.swing.JLabel();
        DisiplinTeks = new javax.swing.JLabel();
        disiplin = new javax.swing.JTextField();
        komitmenTeks = new javax.swing.JLabel();
        komitmen = new javax.swing.JTextField();
        loyalTeks = new javax.swing.JLabel();
        loyal = new javax.swing.JTextField();
        prestasiTeks = new javax.swing.JLabel();
        prestasi = new javax.swing.JTextField();
        nilaiGapTeks = new javax.swing.JLabel();
        nilaiGap = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
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

        gapteks.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        gapteks.setText("Id Gap");
        jPanel1.add(gapteks, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 140, -1));

        idGap.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jPanel1.add(idGap, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 90, -1));

        awalTeks.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        awalTeks.setText("Id Nilai Awal");
        jPanel1.add(awalTeks, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 140, -1));

        boxAwal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        boxAwal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxAwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxAwalActionPerformed(evt);
            }
        });
        jPanel1.add(boxAwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 90, 30));

        guruTeks.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        guruTeks.setText("Id Guru");
        jPanel1.add(guruTeks, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 140, -1));

        idGuru.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jPanel1.add(idGuru, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 90, -1));

        namaGuru.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jPanel1.add(namaGuru, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, 90, -1));

        nama1.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        nama1.setText("Nama Guru");
        jPanel1.add(nama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 500, 140, -1));

        DisiplinTeks.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        DisiplinTeks.setText("Nilai Disiplin");
        jPanel1.add(DisiplinTeks, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 540, 140, -1));

        disiplin.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jPanel1.add(disiplin, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, 90, -1));

        komitmenTeks.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        komitmenTeks.setText("Nilai Komitmen");
        jPanel1.add(komitmenTeks, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 580, 140, -1));

        komitmen.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jPanel1.add(komitmen, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 580, 90, 30));

        loyalTeks.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        loyalTeks.setText("Nilai Loyal");
        jPanel1.add(loyalTeks, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 620, 140, 40));

        loyal.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jPanel1.add(loyal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 620, 90, -1));

        prestasiTeks.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        prestasiTeks.setText("Nilai Prestasi");
        jPanel1.add(prestasiTeks, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 660, 140, 40));

        prestasi.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jPanel1.add(prestasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 660, 90, -1));

        nilaiGapTeks.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        nilaiGapTeks.setText("Nilai Target");
        jPanel1.add(nilaiGapTeks, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 700, 140, 40));

        nilaiGap.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jPanel1.add(nilaiGap, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 700, 90, -1));

        save.setText("Simpan");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 80, 40));

        edit.setText("Ubah");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel1.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 80, 40));

        delete.setText("Hapus");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 550, 80, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 670, 310));

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

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg/spkawal.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1420, 790));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1360, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
      
     String sql = "INSERT INTO gaptabel VALUES (?,?,?,?,?,?,?,?,?)";
    try {   
        String idGapText = idGap.getText();
        String boxAwalText = boxAwal.getSelectedItem().toString();
        String idGuruText = idGuru.getText();
        String namaGuruText = namaGuru.getText();
        int nilaiGapValue = Integer.parseInt(nilaiGap.getText());
        
       
        int disiplinValue = Integer.parseInt(disiplin.getText()) - nilaiGapValue;
        int komitmenValue = Integer.parseInt(komitmen.getText()) - nilaiGapValue;
        int loyalValue = Integer.parseInt(loyal.getText()) - nilaiGapValue;
        int prestasiValue = Integer.parseInt(prestasi.getText()) - nilaiGapValue;

        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, idGapText);
        stat.setString(2, boxAwalText);
        stat.setString(3, idGuruText);
        stat.setString(4, namaGuruText);
        stat.setInt(5, disiplinValue);
        stat.setInt(6, komitmenValue);
        stat.setInt(7, loyalValue);
        stat.setInt(8, prestasiValue);
        stat.setInt(9, nilaiGapValue);
        stat.executeUpdate();
        JOptionPane.showMessageDialog(null, "Berhasil Simpan");

        kosong();
        idGap.requestFocus();
        dataGap();    
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal Simpan: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Format angka tidak valid: " + e.getMessage());
    }

    }//GEN-LAST:event_saveActionPerformed

    private void boxAwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAwalActionPerformed
    String sql1 = "SELECT * FROM awaltabel WHERE nilaiAwal = ?";
    String sql2 = "SELECT * FROM gurutabel WHERE idGuru = ?";

    try {
        // Query pertama untuk mendapatkan detail dari awaltabel
        PreparedStatement stat1 = conn.prepareStatement(sql1);
        stat1.setString(1, boxAwal.getSelectedItem().toString());
        ResultSet hasil1 = stat1.executeQuery();
        
        if (hasil1.next()) {
            idGuru.setText(hasil1.getString("idGuru"));
            disiplin.setText(hasil1.getString("nilaiDisiplin"));
            komitmen.setText(hasil1.getString("nilaiKomitmen"));
            loyal.setText(hasil1.getString("nilaiLoyal"));
            prestasi.setText(hasil1.getString("nilaiPrestasi"));
        }

        // Query kedua untuk mendapatkan namaGuru dari gurutabel berdasarkan idGuru
        PreparedStatement stat2 = conn.prepareStatement(sql2);
        stat2.setString(1, idGuru.getText());
        ResultSet hasil2 = stat2.executeQuery();
        
        if (hasil2.next()) {
            namaGuru.setText(hasil2.getString("namaGuru"));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_boxAwalActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
               try {
       String sql = "UPDATE gaptabel set idGap=?, nilaiAwal=?, nilaiGap=? where idGap=? ";
       PreparedStatement stat= conn.prepareStatement(sql);
            stat.setString(1, idGap.getText());         
            stat.setString(2, boxAwal.getSelectedItem().toString());
            stat.setString(3, nilaiGap.getText());
            stat.setString(4, oldId);
            
       stat.executeUpdate();
       JOptionPane.showMessageDialog(null, "Berhasil Update");
       kosong();
       idGap.requestFocus();
       dataTable();
    } catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Gagal Update: " + e.getMessage());
}
    }//GEN-LAST:event_editActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
                aktif();
       // TODO add your handling code here:
        int bar = jTable1.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 7).toString();
        
        this.oldId = a;
        idGap.setText(a);
        boxAwal.setSelectedItem(b);
        nilaiGap.setText(e);


    }//GEN-LAST:event_jTable1MouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
           int ok=JOptionPane.showConfirmDialog(null, "Hapus", "Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            String sql= "delete from gaptabel where idGap = '"+idGap.getText()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong();
                idGap.requestFocus();
                dataTable();
            }catch(SQLException e){
                 JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
            }
        }

    }//GEN-LAST:event_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(hitungGAP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hitungGAP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hitungGAP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hitungGAP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hitungGAP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DisiplinTeks;
    private javax.swing.JLabel awalTeks;
    private javax.swing.JButton back;
    private javax.swing.JLabel bg;
    private javax.swing.JComboBox<String> boxAwal;
    private javax.swing.JButton buttonAkhir;
    private javax.swing.JButton buttonAwal;
    private javax.swing.JButton buttonCsfs;
    private javax.swing.JButton buttonGap;
    private javax.swing.JButton buttonGuru3;
    private javax.swing.JButton buttonKelas;
    private javax.swing.JButton buttonkonvert;
    private javax.swing.JButton delete;
    private javax.swing.JTextField disiplin;
    private javax.swing.JButton edit;
    private javax.swing.JLabel gapteks;
    private javax.swing.JLabel guruTeks;
    private javax.swing.JTextField idGap;
    private javax.swing.JTextField idGuru;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField komitmen;
    private javax.swing.JLabel komitmenTeks;
    private javax.swing.JTextField loyal;
    private javax.swing.JLabel loyalTeks;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel nama1;
    private javax.swing.JTextField namaGuru;
    private javax.swing.JTextField nilaiGap;
    private javax.swing.JLabel nilaiGapTeks;
    private javax.swing.JTextField prestasi;
    private javax.swing.JLabel prestasiTeks;
    private javax.swing.JButton rank;
    private javax.swing.JButton report;
    private javax.swing.JButton save;
    private javax.swing.JLabel tanggal;
    // End of variables declaration//GEN-END:variables

    public void setIdGuru(){
        List<String> awalList = new ArrayList<>();//Objek ArrayList yang akan digunakan untuk menyimpan semua idGuru yang diambil dari database.
        String sql = "SELECT nilaiAwal FROM awaltabel";//Query SQL untuk mengambil semua idGuru dari tabel gurutabel

    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        
        while (hasil.next()) {
                String nilaiAwal = hasil.getString("nilaiAwal");
                awalList.add(nilaiAwal);
            }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
        DefaultComboBoxModel<String> cbawal = new DefaultComboBoxModel();
        for (String nilaiAwal : awalList) {
            cbawal.addElement(nilaiAwal);
        }
        
        boxAwal.setModel(cbawal);
    
    }
   public void setIdGuru2(){
        List<String> awalList1 = new ArrayList<>();//Objek ArrayList yang akan digunakan untuk menyimpan semua idGuru yang diambil dari database.
        String sql = "SELECT idGuru FROM gurutabel";//Query SQL untuk mengambil semua idGuru dari tabel gurutabel

    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        
        while (hasil.next()) {
                String nilaiAwal = hasil.getString("idGuru");
                awalList1.add(nilaiAwal);
            }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
        DefaultComboBoxModel<String> cbawal1 = new DefaultComboBoxModel();
        for (String nilaiAwal1 : awalList1) {
            cbawal1.addElement(nilaiAwal1);
        }
        
        boxAwal.setModel(cbawal1);
    
    }
       
}




