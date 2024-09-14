/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spk;
import java.awt.Color;
import java.sql.*;
import java.time.LocalDate;
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
public class ranking extends javax.swing.JFrame {
 private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    String oldId = null;

private void dataTable() {
    Object[] Baris = {"Id Rank", "id cf", "Id Total", "Id Guru", "Nama Guru", "Disiplin", "Komitmen", "P.Materi", "Loyal", "Prestasi", "nilaiCore", "nilaiSecond", "total akhir"};
    tabmode = new DefaultTableModel(null, Baris);
    jTable1.setModel(tabmode);
    
    String sql = "SELECT r.idRank, c.idcf, g.idGuru, t.idTotal, g.namaGuru, c.nilaiDisiplin, c.nilaiKomitmen, c.totalMateri, c.nilaiLoyal, c.nilaiPrestasi, t.nilaiCore, t.nilaiSecond, t.totalakhir " +
                 "FROM ranktabel r " +
                 "JOIN gurutabel g ON g.idGuru = r.idGuru " +
                 "JOIN totaltabel t ON t.idTotal = r.idTotal " +
                 "JOIN cftabel c ON c.idcf = r.idcf";

    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);

        while (hasil.next()) {
            String idRank = hasil.getString("idRank");
            String idcf = hasil.getString("idcf");
            String idTotal = hasil.getString("idTotal");
            String idGuru = hasil.getString("idGuru");
            String namaGuru = hasil.getString("namaGuru");
            String disiplin = hasil.getString("nilaiDisiplin");
            String komitmen = hasil.getString("nilaiKomitmen");
            String materi = hasil.getString("totalMateri");
            String loyal = hasil.getString("nilaiLoyal");
            String prestasi = hasil.getString("nilaiPrestasi");
            String cf = hasil.getString("nilaiCore");
            String sf = hasil.getString("nilaiSecond");
            String akhir = hasil.getString("totalakhir");

            String[] data = {idRank, idcf, idTotal, idGuru, namaGuru, disiplin, komitmen, materi, loyal, prestasi, cf, sf, akhir};
            tabmode.addRow(data);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
private void dataTableRank() {
    Object[] Baris = {"Id Rank", "id cf", "Id Total", "Id Guru", "Nama Guru", "Disiplin", "Komitmen", "P.Materi", "Loyal", "Prestasi", "nilaiCore", "nilaiSecond", "total akhir"};
    tabmode = new DefaultTableModel(null, Baris);
    jTable1.setModel(tabmode);
    
    String sql = "SELECT * FROM ranktabel "+"ORDER BY idRanK ASC";
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);

        while (hasil.next()) {
            String idRank = hasil.getString("idRank");
            String idcf = hasil.getString("idcf");
            String idTotal = hasil.getString("idTotal");
            String idGuru = hasil.getString("idGuru");
            String namaGuru = hasil.getString("namaGuru");
            String disiplin = hasil.getString("nilaiDisiplin");
            String komitmen = hasil.getString("nilaiKomitmen");
            String materi = hasil.getString("totalMateri");
            String loyal = hasil.getString("nilaiLoyal");
            String prestasi = hasil.getString("nilaiPrestasi");
            String cf = hasil.getString("nilaiCore");
            String sf = hasil.getString("nilaiSecond");
            String akhir = hasil.getString("totalakhir");

            String[] data = {idRank, idcf, idTotal, idGuru, namaGuru, disiplin, komitmen, materi, loyal, prestasi, cf, sf, akhir};
            tabmode.addRow(data);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }}
    
private void dataTablePeringkat() {
    Object[] Baris = {"Id Rank", "id cf", "Id Total", "Id Guru", "Nama Guru", "Disiplin", "Komitmen", "P.Materi", "Loyal", "Prestasi", "nilaiCore", "nilaiSecond", "total akhir"};
    tabmode = new DefaultTableModel(null, Baris);
    jTable1.setModel(tabmode);
    
    String sql = "SELECT * FROM peringkattable ";
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);

        while (hasil.next()) {
            String idRank = hasil.getString("idRank");
            String idcf = hasil.getString("idcf");
            String idTotal = hasil.getString("idTotal");
            String idGuru = hasil.getString("idGuru");
            String namaGuru = hasil.getString("namaGuru");
            String disiplin = hasil.getString("nilaiDisiplin");
            String komitmen = hasil.getString("nilaiKomitmen");
            String materi = hasil.getString("totalMateri");
            String loyal = hasil.getString("nilaiLoyal");
            String prestasi = hasil.getString("nilaiPrestasi");
            String cf = hasil.getString("nilaiCore");
            String sf = hasil.getString("nilaiSecond");
            String akhir = hasil.getString("totalakhir");

            String[] data = {idRank, idcf, idTotal, idGuru, namaGuru, disiplin, komitmen, materi, loyal, prestasi, cf, sf, akhir};
            tabmode.addRow(data);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }}
    protected void kosong() {
      boxcf.setSelectedItem(0);
      boxTotal.setSelectedItem(0);
      boxGuru.setSelectedItem(0);
      namaGuru.setText("");
      disiplin.setText("");
      komitmen.setText("");
      materi.setText("");
      loyal.setText("");
      prestasi.setText("");
      core.setText("");
      second.setText("");
      end.setText("");
      idRank.setText(""); 

}

    /**
     * Creates new form ranking
     */
    public ranking() {
        initComponents();
        dataTable();
        setIdGuru();
        setIdTotal();
        setIdcf();  
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        dataTableRank();
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
        save = new javax.swing.JButton();
        Ubah = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        idRanktext = new javax.swing.JLabel();
        idRank = new javax.swing.JTextField();
        idcfText = new javax.swing.JLabel();
        boxcf = new javax.swing.JComboBox<>();
        idTotaltext = new javax.swing.JLabel();
        boxTotal = new javax.swing.JComboBox<>();
        idGurutext = new javax.swing.JLabel();
        boxGuru = new javax.swing.JComboBox<>();
        nmGuruText = new javax.swing.JLabel();
        namaGuru = new javax.swing.JTextField();
        disiplinText = new javax.swing.JLabel();
        disiplin = new javax.swing.JTextField();
        komitmenTeks = new javax.swing.JLabel();
        komitmen = new javax.swing.JTextField();
        materiTeks = new javax.swing.JLabel();
        materi = new javax.swing.JTextField();
        loyalTeks = new javax.swing.JLabel();
        loyal = new javax.swing.JTextField();
        prestasiTeks = new javax.swing.JLabel();
        prestasi = new javax.swing.JTextField();
        coretext = new javax.swing.JLabel();
        core = new javax.swing.JTextField();
        secondtext = new javax.swing.JLabel();
        second = new javax.swing.JTextField();
        akhirText = new javax.swing.JLabel();
        end = new javax.swing.JTextField();
        sortnama = new javax.swing.JButton();
        relevan = new javax.swing.JButton();
        nilai = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        deleteTable = new javax.swing.JButton();
        simpanTable = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Beranda = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1360, 760));
        setPreferredSize(new java.awt.Dimension(1360, 768));
        setSize(new java.awt.Dimension(1368, 768));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        save.setText("Simpan");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save);
        save.setBounds(260, 710, 80, 30);

        Ubah.setText("Ubah");
        Ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UbahActionPerformed(evt);
            }
        });
        jPanel1.add(Ubah);
        Ubah.setBounds(350, 710, 60, 30);

        delete.setText("Hapus");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete);
        delete.setBounds(420, 710, 80, 30);

        idRanktext.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        idRanktext.setText("Id Peringkat");
        jPanel1.add(idRanktext);
        idRanktext.setBounds(30, 280, 100, 20);

        idRank.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jPanel1.add(idRank);
        idRank.setBounds(150, 270, 90, 30);

        idcfText.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        idcfText.setText("Id CFSF");
        jPanel1.add(idcfText);
        idcfText.setBounds(30, 310, 70, 32);

        boxcf.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        boxcf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxcf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxcfActionPerformed(evt);
            }
        });
        jPanel1.add(boxcf);
        boxcf.setBounds(150, 310, 90, 30);

        idTotaltext.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        idTotaltext.setText("Id Total");
        jPanel1.add(idTotaltext);
        idTotaltext.setBounds(30, 350, 90, 32);

        boxTotal.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        boxTotal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTotalActionPerformed(evt);
            }
        });
        jPanel1.add(boxTotal);
        boxTotal.setBounds(150, 350, 90, 30);

        idGurutext.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        idGurutext.setText("Id Guru");
        jPanel1.add(idGurutext);
        idGurutext.setBounds(30, 390, 100, 32);

        boxGuru.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        boxGuru.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxGuruActionPerformed(evt);
            }
        });
        jPanel1.add(boxGuru);
        boxGuru.setBounds(150, 390, 90, 30);

        nmGuruText.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        nmGuruText.setText("Nama Guru");
        jPanel1.add(nmGuruText);
        nmGuruText.setBounds(260, 270, 100, 32);

        namaGuru.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jPanel1.add(namaGuru);
        namaGuru.setBounds(360, 270, 90, 30);

        disiplinText.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        disiplinText.setText("Nilai Disiplin");
        jPanel1.add(disiplinText);
        disiplinText.setBounds(30, 430, 120, 32);

        disiplin.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jPanel1.add(disiplin);
        disiplin.setBounds(150, 430, 90, 30);

        komitmenTeks.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        komitmenTeks.setText("Nilai Komitmen");
        jPanel1.add(komitmenTeks);
        komitmenTeks.setBounds(30, 470, 115, 32);

        komitmen.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jPanel1.add(komitmen);
        komitmen.setBounds(150, 470, 90, 30);

        materiTeks.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        materiTeks.setText("Nilai P.Materi");
        jPanel1.add(materiTeks);
        materiTeks.setBounds(30, 510, 103, 32);

        materi.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jPanel1.add(materi);
        materi.setBounds(150, 510, 90, 30);

        loyalTeks.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        loyalTeks.setText("Nilai Loyal");
        jPanel1.add(loyalTeks);
        loyalTeks.setBounds(30, 550, 77, 32);

        loyal.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jPanel1.add(loyal);
        loyal.setBounds(150, 550, 90, 30);

        prestasiTeks.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        prestasiTeks.setText("Nilai Prestasi");
        jPanel1.add(prestasiTeks);
        prestasiTeks.setBounds(30, 590, 100, 32);

        prestasi.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jPanel1.add(prestasi);
        prestasi.setBounds(150, 590, 90, 30);

        coretext.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        coretext.setText("Nilai Core");
        jPanel1.add(coretext);
        coretext.setBounds(460, 270, 90, 32);

        core.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jPanel1.add(core);
        core.setBounds(540, 270, 90, 30);

        secondtext.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        secondtext.setText("Nilai Second");
        jPanel1.add(secondtext);
        secondtext.setBounds(640, 270, 90, 32);

        second.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jPanel1.add(second);
        second.setBounds(740, 270, 90, 30);

        akhirText.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        akhirText.setText("Nilai Akhir");
        jPanel1.add(akhirText);
        akhirText.setBounds(30, 630, 90, 32);

        end.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jPanel1.add(end);
        end.setBounds(150, 630, 90, 30);

        sortnama.setBackground(new java.awt.Color(135, 104, 61));
        sortnama.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sortnama.setText("Nama");
        sortnama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sortnamaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sortnamaMouseExited(evt);
            }
        });
        sortnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortnamaActionPerformed(evt);
            }
        });
        jPanel1.add(sortnama);
        sortnama.setBounds(330, 150, 80, 40);

        relevan.setBackground(new java.awt.Color(135, 104, 61));
        relevan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        relevan.setText("Relevan");
        relevan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                relevanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                relevanMouseExited(evt);
            }
        });
        relevan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relevanActionPerformed(evt);
            }
        });
        jPanel1.add(relevan);
        relevan.setBounds(240, 150, 80, 40);

        nilai.setBackground(new java.awt.Color(135, 104, 61));
        nilai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nilai.setText("Nilai");
        nilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nilaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nilaiMouseExited(evt);
            }
        });
        nilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nilaiActionPerformed(evt);
            }
        });
        jPanel1.add(nilai);
        nilai.setBounds(420, 150, 80, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null5", "null6", "null7", "null8", "null9", "null10", "null11", "null12", "null13"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false, false, false, false, false, false
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
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(260, 310, 1060, 390);

        deleteTable.setBackground(new java.awt.Color(135, 104, 61));
        deleteTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteTable.setText("Kosongkan Peringkat");
        deleteTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteTableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteTableMouseExited(evt);
            }
        });
        deleteTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTableActionPerformed(evt);
            }
        });
        jPanel1.add(deleteTable);
        deleteTable.setBounds(660, 150, 170, 40);

        simpanTable.setBackground(new java.awt.Color(135, 104, 61));
        simpanTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        simpanTable.setText("Simpan Peringkat");
        simpanTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                simpanTableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                simpanTableMouseExited(evt);
            }
        });
        simpanTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanTableActionPerformed(evt);
            }
        });
        jPanel1.add(simpanTable);
        simpanTable.setBounds(510, 150, 140, 40);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Urutkan Data Berdasarkan : ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 150, 160, 30);

        Beranda.setBackground(new java.awt.Color(135, 104, 61));
        Beranda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Beranda.setText("Beranda");
        Beranda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BerandaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BerandaMouseExited(evt);
            }
        });
        Beranda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BerandaActionPerformed(evt);
            }
        });
        jPanel1.add(Beranda);
        Beranda.setBounds(840, 150, 120, 40);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg/bgRANK.png"))); // NOI18N
        jPanel1.add(bg);
        bg.setBounds(0, -2, 1390, 760);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1370, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
         String sql = "INSERT INTO ranktabel VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    try {
    PreparedStatement stat = conn.prepareStatement(sql);
    stat.setString(1, idRank.getText());
    stat.setString(2, boxcf.getSelectedItem().toString());
    stat.setString(3, boxTotal.getSelectedItem().toString());
    stat.setString(4, boxGuru.getSelectedItem().toString());
    stat.setString(5, namaGuru.getText());
    stat.setString(6, disiplin.getText());
    stat.setString(7, komitmen.getText());
    stat.setString(8, materi.getText());
    stat.setString(9, loyal.getText());
    stat.setString(10, prestasi.getText());
    stat.setString(11, core.getText());
    stat.setString(12, second.getText());
    stat.setString(13, end.getText());
    
    stat.executeUpdate();
    JOptionPane.showMessageDialog(null, "Berhasil Simpan");
    idRank.requestFocus();
    dataTableRank();
    } catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Gagal Simpan: " + e.getMessage());
    }

    }//GEN-LAST:event_saveActionPerformed

    private void boxGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxGuruActionPerformed
        // TODO add your handling code here:
        String sql = "SELECT * FROM gurutabel WHERE idGuru = ?";
    
    try {
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, boxGuru.getSelectedItem().toString());
        ResultSet hasil = stat.executeQuery();
        
        while (hasil.next()) {
            namaGuru.setText(hasil.getString("namaGuru"));
            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_boxGuruActionPerformed

    private void boxTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTotalActionPerformed
        // TODO add your handling code here:
           String sql = "SELECT * FROM totaltabel WHERE idTotal = ?";
    
    try {
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, boxTotal.getSelectedItem().toString());
        ResultSet hasil = stat.executeQuery();
        
        while (hasil.next()) {
            core.setText(hasil.getString("nilaiCore"));
            second.setText(hasil.getString("nilaiSecond"));
            end.setText(hasil.getString("totalakhir"));            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_boxTotalActionPerformed

    private void boxcfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxcfActionPerformed
        // TODO add your handling code here:
          String sql = "SELECT * FROM cftabel WHERE idcf = ?";
    
    try {
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, boxcf.getSelectedItem().toString());
        ResultSet hasil = stat.executeQuery();
        
        while (hasil.next()) {
            disiplin.setText(hasil.getString("nilaiDisiplin"));
            komitmen.setText(hasil.getString("nilaiKomitmen"));
            materi.setText(hasil.getString("totalMateri"));
            loyal.setText(hasil.getString("nilaiLoyal"));
            prestasi.setText(hasil.getString("nilaiPrestasi"));
           }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_boxcfActionPerformed

    private void sortnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortnamaActionPerformed
        // TODO add your handling code here:
    Object[] Baris = {"Id Rank", "id cf", "Id Total", "Id Guru", "Nama Guru", "Disiplin", "Komitmen", "P.Materi", "Loyal", "Prestasi", "nilaiCore", "nilaiSecond", "total akhir"};
    tabmode = new DefaultTableModel(null, Baris);
    jTable1.setModel(tabmode);
    
     String sql =  "SELECT * FROM ranktabel " + "ORDER BY namaGuru";

    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);

        while (hasil.next()) {
            String idRank = hasil.getString("idRank");
            String idcf = hasil.getString("idcf");
            String idTotal = hasil.getString("idTotal");
            String idGuru = hasil.getString("idGuru");
            String namaGuru = hasil.getString("namaGuru");
            String disiplin = hasil.getString("nilaiDisiplin");
            String komitmen = hasil.getString("nilaiKomitmen");
            String materi = hasil.getString("totalMateri");
            String loyal = hasil.getString("nilaiLoyal");
            String prestasi = hasil.getString("nilaiPrestasi");
            String cf = hasil.getString("nilaiCore");
            String sf = hasil.getString("nilaiSecond");
            String akhir = hasil.getString("totalakhir");

            String[] data = {idRank, idcf, idTotal, idGuru, namaGuru, disiplin, komitmen, materi, loyal, prestasi, cf, sf, akhir};
            tabmode.addRow(data);
     
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }

    }//GEN-LAST:event_sortnamaActionPerformed

    private void relevanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relevanActionPerformed
        // TODO add your handling code here:
      
    String sql = "SELECT * FROM ranktabel ORDER BY idRank ASC";

    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);

        // Bersihkan tabel sebelum mengisi dengan data yang baru
        tabmode.setRowCount(0);

        while (hasil.next()) {
            String idRank = hasil.getString("idRank");
            String idcf = hasil.getString("idcf");
            String idTotal = hasil.getString("idTotal");
            String idGuru = hasil.getString("idGuru");
            String namaGuru = hasil.getString("namaGuru");
            String disiplin = hasil.getString("nilaiDisiplin");
            String komitmen = hasil.getString("nilaiKomitmen");
            String materi = hasil.getString("totalMateri");
            String loyal = hasil.getString("nilaiLoyal");
            String prestasi = hasil.getString("nilaiPrestasi");
            String cf = hasil.getString("nilaiCore");
            String sf = hasil.getString("nilaiSecond");
            String akhir = hasil.getString("totalakhir");

            String[] data = {idRank, idcf, idTotal, idGuru, namaGuru, disiplin, komitmen, materi, loyal, prestasi, cf, sf, akhir};
            tabmode.addRow(data);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }

    }//GEN-LAST:event_relevanActionPerformed

    private void nilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nilaiActionPerformed
        // TODO add your handling code here:
    tabmode.setRowCount(0);
    // Query SQL dengan penambahan ORDER BY untuk mengurutkan berdasarkan totalakhir secara ascending
    String sql =  "SELECT * FROM ranktabel ORDER BY totalakhir DESC";  
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);

        while (hasil.next()) {
            String idRank = hasil.getString("idRank");
            String idcf = hasil.getString("idcf");
            String idTotal = hasil.getString("idTotal");
            String idGuru = hasil.getString("idGuru");
            String namaGuru = hasil.getString("namaGuru");
            String disiplin = hasil.getString("nilaiDisiplin");
            String komitmen = hasil.getString("nilaiKomitmen");
            String materi = hasil.getString("totalMateri");
            String loyal = hasil.getString("nilaiLoyal");
            String prestasi = hasil.getString("nilaiPrestasi");
            String cf = hasil.getString("nilaiCore");
            String sf = hasil.getString("nilaiSecond");
            String akhir = hasil.getString("totalakhir");

            String[] data = {idRank, idcf, idTotal, idGuru, namaGuru, disiplin, komitmen, materi, loyal, prestasi, cf, sf, akhir};
            tabmode.addRow(data);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }

    }//GEN-LAST:event_nilaiActionPerformed

    private void deleteTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteTableMouseClicked


    }//GEN-LAST:event_deleteTableMouseClicked

    private void simpanTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanTableActionPerformed
    if (jTable1 == null) {
        JOptionPane.showMessageDialog(null, "Tabel tidak ditemukan.");
        return;
    }
    
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    
    if (model.getRowCount() == 0) {
        JOptionPane.showMessageDialog(null, "Tabel kosong.");
        return;
    }
    
    // Pastikan bahwa conn telah diinisialisasi dengan benar sebelum digunakan
    if (conn == null) {
        JOptionPane.showMessageDialog(null, "Koneksi ke database gagal.");
        return;
    }

    // Query SQL untuk truncate table
    String truncateSql = "TRUNCATE TABLE peringkattable";
    // Query SQL untuk memasukkan data ke dalam peringkattable
    String insertSql = "INSERT INTO peringkattable VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

    try {
        java.sql.Statement truncateStat = conn.createStatement();
        truncateStat.execute(truncateSql);
        
        try (PreparedStatement insertStat = conn.prepareStatement(insertSql)) {
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < 13; j++) {
                    if (model.getValueAt(i, j) != null) {
                        insertStat.setString(j + 1, model.getValueAt(i, j).toString());
                    } else {
                        insertStat.setString(j + 1, "");
                    }
                }
                insertStat.addBatch();
            }
            insertStat.executeBatch();
            JOptionPane.showMessageDialog(null, "Berhasil Simpan");
            idRank.requestFocus();
            dataTablePeringkat();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Simpan: " + e.getMessage());
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal Truncate: " + e.getMessage());
    }
    }//GEN-LAST:event_simpanTableActionPerformed

    private void deleteTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTableActionPerformed
      if (conn == null) {
        JOptionPane.showMessageDialog(null, "Koneksi ke database gagal.");
        return;
    }

    String truncateSql = "TRUNCATE TABLE peringkattable";

    try {
        java.sql.Statement truncateStat = conn.createStatement();
        truncateStat.execute(truncateSql);
        truncateStat.close();

        JOptionPane.showMessageDialog(null, "Tabel berhasil dikosongkan");
        
        dataTablePeringkat();
        
        JOptionPane.showMessageDialog(null, "Menampilkan data sebelum sortir");
        
        dataTableRank();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal Truncate: " + e.getMessage());
    }
    }//GEN-LAST:event_deleteTableActionPerformed

    private void UbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UbahActionPerformed

              String sql = "UPDATE ranktabel SET idcf = ?, idTotal = ?, idGuru = ?, namaGuru = ?, nilaiDisiplin = ?, nilaiKomitmen = ?, totalMateri = ?, nilaiLoyal = ?, nilaiPrestasi = ?, nilaiCore = ?, nilaiSecond = ?, totalakhir = ? WHERE idRank = ?";
    
    try {
        PreparedStatement stat = conn.prepareStatement(sql);
        
        stat.setString(1, boxcf.getSelectedItem().toString());
        stat.setString(2, boxTotal.getSelectedItem().toString());
        stat.setString(3, boxGuru.getSelectedItem().toString());
        stat.setString(4, namaGuru.getText());
        stat.setString(5, disiplin.getText());
        stat.setString(6, komitmen.getText());
        stat.setString(7, materi.getText());
        stat.setString(8, loyal.getText());
        stat.setString(9, prestasi.getText());
        stat.setString(10, core.getText());
        stat.setString(11, second.getText());
        stat.setString(12, end.getText());
        stat.setString(13, idRank.getText());  // ID yang digunakan untuk menentukan baris mana yang diperbarui
        
        int rowsAffected = stat.executeUpdate();
        
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Berhasil Update");
        } else {
            JOptionPane.showMessageDialog(null, "Tidak ada data yang diperbarui. Pastikan ID yang dimasukkan benar.");
        }
        
        idRank.requestFocus();
        
        dataTableRank();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal Update: " + e.getMessage());
    }
    }//GEN-LAST:event_UbahActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     if (jTable1 == null || tabmode == null) {
        JOptionPane.showMessageDialog(null, "Tabel atau model tabel belum diinisialisasi.");
        return;
    }
    
    // Mendapatkan baris yang dipilih
    int bar = jTable1.getSelectedRow();
    
    // Pastikan ada baris yang dipilih
    if (bar != -1) {
        // Pastikan tabmode memiliki data yang valid
        if (tabmode.getRowCount() > 0 && tabmode.getColumnCount() >= 13) {
            // Mengambil nilai dari baris yang dipilih
            String a = tabmode.getValueAt(bar, 0).toString();
            String b = tabmode.getValueAt(bar, 1).toString();
            String c = tabmode.getValueAt(bar, 2).toString();
            String d = tabmode.getValueAt(bar, 3).toString();
            String e = tabmode.getValueAt(bar, 4).toString();
            String f = tabmode.getValueAt(bar, 5).toString();
            String g = tabmode.getValueAt(bar, 6).toString();
            String h = tabmode.getValueAt(bar, 7).toString();
            String i = tabmode.getValueAt(bar, 8).toString();
            String j = tabmode.getValueAt(bar, 9).toString();
            String k = tabmode.getValueAt(bar, 10).toString();
            String l = tabmode.getValueAt(bar, 11).toString();
            String m = tabmode.getValueAt(bar, 12).toString();

            // Menampilkan data yang dipilih di konsol (untuk debugging)
            System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g + " " + h + " " + i + " " + j + " " + k + " " + l + " " + m);

            // Mengatur ID lama
            this.oldId = a;

            // Mengisi field dengan data dari tabel
            if (idRank != null) idRank.setText(a);
            if (boxcf != null) boxcf.setSelectedItem(b);
            if (boxTotal != null) boxTotal.setSelectedItem(c);
            if (boxGuru != null) boxGuru.setSelectedItem(d);
            if (namaGuru != null) namaGuru.setText(e);
            if (disiplin != null) disiplin.setText(f);
            if (komitmen != null) komitmen.setText(g);
            if (materi != null) materi.setText(h);
            if (loyal != null) loyal.setText(i);
            if (prestasi != null) prestasi.setText(j);
            if (core != null) core.setText(k);
            if (second != null) second.setText(l);
            if (end != null) end.setText(m);
        } else {
            JOptionPane.showMessageDialog(null, "Data tabel tidak valid.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Tidak ada baris yang dipilih.");
    }
    }//GEN-LAST:event_jTable1MouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int ok=JOptionPane.showConfirmDialog(null, "Hapus", "Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0){
            String sql= "delete from ranktabel where idRank = '"+idRank.getText()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong();
                idRank.requestFocus();
                dataTable();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void relevanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_relevanMouseEntered
        // TODO add your handling code here:
        relevan.setBackground(new Color(160, 127, 82));
    }//GEN-LAST:event_relevanMouseEntered

    private void relevanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_relevanMouseExited
        // TODO add your handling code here:
        relevan.setBackground(new Color(135, 104, 60));
    }//GEN-LAST:event_relevanMouseExited

    private void sortnamaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sortnamaMouseEntered
        // TODO add your handling code here:
        sortnama.setBackground(new Color(160, 127, 82));
    }//GEN-LAST:event_sortnamaMouseEntered

    private void sortnamaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sortnamaMouseExited
        // TODO add your handling code here:
        sortnama.setBackground(new Color(135, 104, 60));
    }//GEN-LAST:event_sortnamaMouseExited

    private void nilaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nilaiMouseEntered
        // TODO add your handling code here:
        nilai.setBackground(new Color(160, 127, 82));
    }//GEN-LAST:event_nilaiMouseEntered

    private void nilaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nilaiMouseExited
        // TODO add your handling code here:
        nilai.setBackground(new Color(135, 104, 60));
    }//GEN-LAST:event_nilaiMouseExited

    private void simpanTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanTableMouseEntered
        // TODO add your handling code here:
        simpanTable.setBackground(new Color(160, 127, 82));
    }//GEN-LAST:event_simpanTableMouseEntered

    private void simpanTableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanTableMouseExited
        // TODO add your handling code here:
        simpanTable.setBackground(new Color(135, 104, 60));
    }//GEN-LAST:event_simpanTableMouseExited

    private void deleteTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteTableMouseEntered
        // TODO add your handling code here:
        deleteTable.setBackground(new Color(160, 127, 82));
    }//GEN-LAST:event_deleteTableMouseEntered

    private void deleteTableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteTableMouseExited
        // TODO add your handling code here:
        deleteTable.setBackground(new Color(135, 104, 60));
    }//GEN-LAST:event_deleteTableMouseExited

    private void BerandaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BerandaMouseEntered
        // TODO add your handling code here:
         Beranda.setBackground(new Color(160, 127, 82));
    }//GEN-LAST:event_BerandaMouseEntered

    private void BerandaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BerandaMouseExited
        // TODO add your handling code here:
        Beranda.setBackground(new Color(135, 104, 60));
    }//GEN-LAST:event_BerandaMouseExited

    private void BerandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BerandaActionPerformed
          // TODO add your handling code here:
        home hm=new home();
        hm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BerandaActionPerformed

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
            java.util.logging.Logger.getLogger(ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ranking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Beranda;
    private javax.swing.JButton Ubah;
    private javax.swing.JLabel akhirText;
    private javax.swing.JLabel bg;
    private javax.swing.JComboBox<String> boxGuru;
    private javax.swing.JComboBox<String> boxTotal;
    private javax.swing.JComboBox<String> boxcf;
    private javax.swing.JTextField core;
    private javax.swing.JLabel coretext;
    private javax.swing.JButton delete;
    private javax.swing.JButton deleteTable;
    private javax.swing.JTextField disiplin;
    private javax.swing.JLabel disiplinText;
    private javax.swing.JTextField end;
    private javax.swing.JLabel idGurutext;
    private javax.swing.JTextField idRank;
    private javax.swing.JLabel idRanktext;
    private javax.swing.JLabel idTotaltext;
    private javax.swing.JLabel idcfText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField komitmen;
    private javax.swing.JLabel komitmenTeks;
    private javax.swing.JTextField loyal;
    private javax.swing.JLabel loyalTeks;
    private javax.swing.JTextField materi;
    private javax.swing.JLabel materiTeks;
    private javax.swing.JTextField namaGuru;
    private javax.swing.JButton nilai;
    private javax.swing.JLabel nmGuruText;
    private javax.swing.JTextField prestasi;
    private javax.swing.JLabel prestasiTeks;
    private javax.swing.JButton relevan;
    private javax.swing.JButton save;
    private javax.swing.JTextField second;
    private javax.swing.JLabel secondtext;
    private javax.swing.JButton simpanTable;
    private javax.swing.JButton sortnama;
    // End of variables declaration//GEN-END:variables
public void setIdGuru() {
    List<String> guruList = new ArrayList<>(); // Objek ArrayList yang akan digunakan untuk menyimpan semua idGap yang diambil dari database.
    String sql = "SELECT idGuru FROM gurutabel"; // Query SQL untuk mengambil semua idGap dari tabel gaptabel

    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);

        while (hasil.next()) {
            String idGuru = hasil.getString("idGuru");
            guruList.add(idGuru);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }

    DefaultComboBoxModel<String> cbGuru = new DefaultComboBoxModel<>();
    for (String idGuru : guruList) {
        cbGuru.addElement(idGuru);
    }

    boxGuru.setModel(cbGuru);
}
public void setIdTotal() {
    List<String> totalList = new ArrayList<>(); // Objek ArrayList yang akan digunakan untuk menyimpan semua idGap yang diambil dari database.
    String sql = "SELECT idTotal FROM totaltabel"; // Query SQL untuk mengambil semua idGap dari tabel gaptabel

    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);

        while (hasil.next()) {
            String idTotal = hasil.getString("idTotal");
            totalList.add(idTotal);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }

    DefaultComboBoxModel<String> cbTotal = new DefaultComboBoxModel<>();
    for (String idTotal : totalList) {
        cbTotal.addElement(idTotal);
    }

    boxTotal.setModel(cbTotal);
}
public void setIdcf() {
    List<String> cfList = new ArrayList<>(); // Objek ArrayList yang akan digunakan untuk menyimpan semua idGap yang diambil dari database.
    String sql = "SELECT idcf FROM cftabel"; // Query SQL untuk mengambil semua idGap dari tabel gaptabel

    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);

        while (hasil.next()) {
            String idcf = hasil.getString("idcf");
            cfList.add(idcf);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }

    DefaultComboBoxModel<String> cbcf = new DefaultComboBoxModel<>();
    for (String idcf : cfList) {
        cbcf.addElement(idcf);
    }

    boxcf.setModel(cbcf);
}
}

