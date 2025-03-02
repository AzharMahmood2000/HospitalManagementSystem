/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Patients;
import View.LoginPage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class admitPatient extends javax.swing.JFrame implements Runnable {
    int hour,seconds,minutes;

    /**
     * Creates new form admitPatient
     */
    public admitPatient() {
        initComponents();
        showDate();
        Thread t =new Thread(this);
        t.start();
    }
    void showDate(){
    Date d=new Date();
    SimpleDateFormat sd =new SimpleDateFormat("dd-MM-yyyy");
    pad.setText(sd.format(d));
    
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pn = new javax.swing.JTextField();
        pd = new javax.swing.JTextField();
        pad = new javax.swing.JTextField();
        pat = new javax.swing.JTextField();
        pid = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 102));
        jLabel1.setText("ADMIT PATIENT");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 207, -1));

        jLabel2.setText("ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 30, 22));

        jLabel3.setText("Patient's Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel4.setText("Diseas:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        jLabel5.setText("Admit Date:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        jLabel6.setText("Admit Time:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, -1, -1));
        getContentPane().add(pn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 207, -1));
        getContentPane().add(pd, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 207, -1));

        pad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                padActionPerformed(evt);
            }
        });
        getContentPane().add(pad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 207, -1));
        getContentPane().add(pat, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 207, -1));

        pid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pidActionPerformed(evt);
            }
        });
        getContentPane().add(pid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 207, -1));

        jButton1.setText("LOGOUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, -1, -1));

        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, -1, -1));

        jButton3.setText("Admit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\Hospital\\iStock-1273890900.jpeg")); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pidActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root","");
           String sql="insert into patient_record values(?,?,?,?,?)";
           PreparedStatement ptst = conn.prepareStatement(sql);
           ptst.setString(1, pid.getText());
           ptst.setString(2, pn.getText());
           ptst.setString(3, pd.getText());
           ptst.setString(4, pad.getText());
           ptst.setString(5, pat.getText());
           ptst.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "Data inserted Successfully");
           conn.close();
           pid.setText(""); pn.setText(""); pd.setText("");
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);}
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            Patients obj =new Patients();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LoginPage obj =new LoginPage();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void padActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_padActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_padActionPerformed

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
            java.util.logging.Logger.getLogger(admitPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admitPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admitPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admitPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admitPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField pad;
    private javax.swing.JTextField pat;
    private javax.swing.JTextField pd;
    private javax.swing.JTextField pid;
    private javax.swing.JTextField pn;
    // End of variables declaration//GEN-END:variables
   

    @Override
    public void run() {
        while(true){
            Calendar cal= Calendar.getInstance();
            hour= cal.get(Calendar.HOUR_OF_DAY);
             minutes=cal.get(Calendar.MINUTE);
             seconds= cal.get(Calendar.SECOND);
             
             SimpleDateFormat sdf24 = new SimpleDateFormat("HH:mm:ss:aa");
             Date dat= cal.getTime();
             String time24=sdf24.format(dat);
             pat.setText(time24);
             
            
        }
    }




}


