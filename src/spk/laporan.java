    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spk;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Joko Prasetyo Utomo
 */
public class laporan extends javax.swing.JFrame {
private Connection conn = new koneksi().connect();
    /**
     * Creates new form laporan
     */
    public laporan() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonKriteria = new javax.swing.JButton();
        buttonGuru = new javax.swing.JButton();
        buttonRank = new javax.swing.JButton();
        buttonKelas = new javax.swing.JButton();
        Beranda = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonKriteria.setBackground(new java.awt.Color(0, 0, 0));
        buttonKriteria.setForeground(new java.awt.Color(255, 255, 255));
        buttonKriteria.setText("TOTAL KATEGORI");
        buttonKriteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKriteriaActionPerformed(evt);
            }
        });
        getContentPane().add(buttonKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 180, 60));

        buttonGuru.setBackground(new java.awt.Color(0, 0, 0));
        buttonGuru.setForeground(new java.awt.Color(255, 255, 255));
        buttonGuru.setText("DATA GURU");
        buttonGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuruActionPerformed(evt);
            }
        });
        getContentPane().add(buttonGuru, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 180, 60));

        buttonRank.setBackground(new java.awt.Color(0, 0, 0));
        buttonRank.setForeground(new java.awt.Color(255, 255, 255));
        buttonRank.setText("PERINGKAT AKHIR");
        buttonRank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRankActionPerformed(evt);
            }
        });
        getContentPane().add(buttonRank, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 480, 180, 60));

        buttonKelas.setBackground(new java.awt.Color(0, 0, 0));
        buttonKelas.setForeground(new java.awt.Color(255, 255, 255));
        buttonKelas.setText("DATA KELAS");
        buttonKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKelasActionPerformed(evt);
            }
        });
        getContentPane().add(buttonKelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 180, 60));

        Beranda.setBackground(new java.awt.Color(0, 0, 0));
        Beranda.setForeground(new java.awt.Color(255, 255, 255));
        Beranda.setText("BERANDA");
        Beranda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BerandaActionPerformed(evt);
            }
        });
        getContentPane().add(Beranda, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 110, 50));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg/spklaporan.png"))); // NOI18N
        bg.setText("jLabel1");
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonKriteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKriteriaActionPerformed
        // TODO add your handling code here:
        try {
    Connection conn = new koneksi().connect();
    
            String nfile = "src/spk/ranking.jasper";
            HashMap<String, Object> parameter = new HashMap<>();
            File file_report = new File(nfile);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file_report);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);
            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }//GEN-LAST:event_buttonKriteriaActionPerformed

    private void buttonGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGuruActionPerformed
        // TODO add your handling code here:
            try {
            String nfile = "src/spk/dataGuruReport.jasper";
            HashMap<String, Object> parameter = new HashMap<>();
            File file_report = new File(nfile);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file_report);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);
            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }//GEN-LAST:event_buttonGuruActionPerformed

    private void buttonRankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRankActionPerformed
        // TODO add your handling code here:
            try {
    Connection conn = new koneksi().connect();
    
            String nfile = "src/spk/kate.jasper";
            HashMap<String, Object> parameter = new HashMap<>();
            File file_report = new File(nfile);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file_report);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);
            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }//GEN-LAST:event_buttonRankActionPerformed

    private void buttonKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKelasActionPerformed
        // TODO add your handling code here:
         try {
            String nfile = "src/spk/dataKelasReport.jasper";
            HashMap<String, Object> parameter = new HashMap<>();
            File file_report = new File(nfile);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file_report);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);
            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_buttonKelasActionPerformed

    private void BerandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BerandaActionPerformed
        // TODO add your handling code here:
        home kelas=new home();
        kelas.setVisible(true);
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
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Beranda;
    private javax.swing.JLabel bg;
    private javax.swing.JButton buttonGuru;
    private javax.swing.JButton buttonKelas;
    private javax.swing.JButton buttonKriteria;
    private javax.swing.JButton buttonRank;
    // End of variables declaration//GEN-END:variables
}
