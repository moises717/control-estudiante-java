package controlGUI;

import DB.Conexion;
import controlBL.Estudiantes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.CustomTable;

public class InfoEstudiante extends javax.swing.JFrame {

    private int idEstudiante;
    private Estudiantes estudiantes;
    private int idNotaActual;
    private final Conexion con = new Conexion();

    public InfoEstudiante() {
        initComponents();

    }

    public InfoEstudiante(int id) {
        initComponents();
        this.idEstudiante = id;

        this.tblNotas.setDefaultRenderer(Object.class, new CustomTable());
        obtenerInfoEstudiante();

        obtenerNotasActuales();

        this.setTitle(estudiantes.getNombres() + " " + estudiantes.getApellidos());
        rsscalelabel.RSScaleLabel.setScaleLabel(lblImage, "images/" + estudiantes.getImagen());

        obtenerInfoNotas();

    }

    private void crearTabla(ResultSet rs) {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("I");
        model.addColumn("II");
        model.addColumn("III");
        model.addColumn("EXAMEN");
        model.addColumn("ESTADO");

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        try {
            while (rs.next()) {
                double promedio = (rs.getInt("NOTA1") + rs.getInt("NOTA2") + rs.getInt("NOTA3")) / 3 * 0.60;
                double examenF = rs.getInt("EXAMEN");
                String aprobo;

                double notaFinal = promedio + examenF;

                if (rs.getInt("EXAMEN") == 0) {
                    aprobo = "EN PROCESO";
                } else {
                    if (notaFinal > 60) {
                        aprobo = "APROBADO";
                    } else {
                        aprobo = "REPROBADO";
                    }
                }

                Object[] objs = {rs.getString("ID"), rs.getString("NOTA1"), rs.getString("NOTA2"), rs.getString("NOTA3"), rs.getString("EXAMEN"), aprobo};

                model.addRow(objs);
            }

            tblNotas.setModel(model);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private void obtenerInfoNotas() {
        Conexion.connect();

        String strQuery = String.format("SELECT * FROM notas WHERE ID_ESTUDIANTE = %d AND FINALIZADO = 1 ORDER BY ID DESC", this.idEstudiante);

        ResultSet rs = con.consultarRegistro(strQuery);

        crearTabla(rs);
        Conexion.disconnect();
    }

    private void obtenerInfoEstudiante() {
        Conexion.connect();

        estudiantes = new Estudiantes();
        String strQuery = String.format("SELECT * FROM estudiantes WHERE ID = %d", this.idEstudiante);

        try {
            ResultSet rs = con.consultarRegistro(strQuery);

            if (rs != null) {
                estudiantes.setNombres(rs.getString("NOMBRES"));
                estudiantes.setApellidos(rs.getString("APELLIDOS"));
                estudiantes.setImagen(rs.getString("IMAGEN"));
            }

            Conexion.disconnect();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private void obtenerNotasActuales() {
        Conexion.connect();

        String strQuery = String.format("SELECT * FROM notas WHERE ID_ESTUDIANTE = %d AND FINALIZADO = %d", this.idEstudiante, 0);

        try {
            ResultSet rs = con.consultarRegistro(strQuery);
            System.out.println(rs.next());
            this.idNotaActual = rs.getInt("ID");
            this.txtNota1.setText(rs.getString("NOTA1"));
            this.txtNota2.setText(rs.getString("NOTA2"));
            this.txtNota3.setText(rs.getString("NOTA3"));
            this.txtExamen.setText(rs.getString("EXAMEN"));

            Conexion.disconnect();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private void actualizarNotaActual() {
        Conexion.connect();
        PreparedStatement pstm;
        try {
            String strQuery = "UPDATE notas SET NOTA1 = ?, NOTA2 = ?, NOTA3 = ?, EXAMEN = ? WHERE ID = ?";

            pstm = con.ejecuatarSenteciaSQL(strQuery);

            pstm.setInt(1, Integer.parseInt(txtNota1.getText()));
            pstm.setInt(2, Integer.parseInt(txtNota2.getText()));
            pstm.setInt(3, Integer.parseInt(txtNota3.getText()));
            pstm.setInt(4, Integer.parseInt(txtExamen.getText()));
            pstm.setInt(5, this.idNotaActual);

            pstm.executeUpdate();
            pstm.close();

            CSPrincipal.eventos.post(true);

            JOptionPane.showMessageDialog(this, "Nota actualizada correctamente!", estudiantes.getNombres(), JOptionPane.INFORMATION_MESSAGE);

            Conexion.disconnect();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void finalizarEvaluacion() {
        Conexion.connect();

        try {
            String strQuery = "UPDATE notas SET FINALIZADO = 1 WHERE ID = ?";
            PreparedStatement pstm = con.ejecuatarSenteciaSQL(strQuery);
            pstm.setInt(1, this.idNotaActual);
            pstm.executeUpdate();
            pstm.close();

            this.generarNotas(this.idEstudiante);
            this.obtenerNotasActuales();

            this.obtenerInfoNotas();

            CSPrincipal.eventos.post(true);

            Conexion.disconnect();

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

    }

    private void generarNotas(int id) {
        Conexion.connect();
        String strQuery = "INSERT INTO notas (ID, ID_ESTUDIANTE) VALUES(null, ?)";

        try {

            PreparedStatement req = con.ejecuatarSenteciaSQL(strQuery);
            req.setInt(1, id);
            req.execute();
            Conexion.disconnect();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        txtExamen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNota1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNota2 = new javax.swing.JTextField();
        txtNota3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNotas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel1.add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 227, 248));

        btnFinalizar.setBackground(new java.awt.Color(96, 92, 255));
        btnFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizar.setText("NUEVA EVALUACION");
        btnFinalizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(96, 92, 255)));
        btnFinalizar.setBorderPainted(false);
        btnFinalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 90, 140, 28));
        jPanel1.add(txtExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 61, 33));

        jLabel2.setText("NOTA I");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        jLabel3.setText("EXAMEN");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, -1));
        jPanel1.add(txtNota1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 61, 33));

        jLabel4.setText("NOTA II");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));
        jPanel1.add(txtNota2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 61, 33));
        jPanel1.add(txtNota3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 61, 33));

        jLabel5.setText("NOTA III");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        btnActualizar.setBackground(new java.awt.Color(96, 92, 255));
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("AGREGAR");
        btnActualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(96, 92, 255)));
        btnActualizar.setBorderPainted(false);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 50, 140, 28));

        tblNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblNotasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblNotas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 610, 210));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setText("EVALUACIONES");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setText("EVALUACION ACTUAL");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        this.actualizarNotaActual();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        this.finalizarEvaluacion();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void tblNotasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNotasMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNotasMousePressed

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
            java.util.logging.Logger.getLogger(InfoEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTable tblNotas;
    private javax.swing.JTextField txtExamen;
    private javax.swing.JTextField txtNota1;
    private javax.swing.JTextField txtNota2;
    private javax.swing.JTextField txtNota3;
    // End of variables declaration//GEN-END:variables
}
