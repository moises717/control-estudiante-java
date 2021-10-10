package controlGUI;

import DB.Conexion;
import controlBL.*;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JComboBox;
import utils.Archivos;
import utils.ValidarDatosEstudiantes;

public class AddEstudiante extends javax.swing.JDialog {

    private final Conexion con = new Conexion();
    private Estudiantes globalObjEstudiantes = new Estudiantes();
    private Archivos files = new Archivos();

    // constructor para agregtar un estudiante
    public AddEstudiante(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/estudents.png")));

        // Rellenar conbobox secciones
        rellenarCbxSecciones();
        // Rellenar combobox docentes
        rellenarCbxDocentes();

    }

    // Constructor para actualizar un estudiante 
    public AddEstudiante(java.awt.Frame parent, boolean modal, Estudiantes objEstudiantes) {
        super(parent, modal);
        initComponents();

        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/estudents.png")));

        // rellenar conbobox secciones
        rellenarCbxSecciones();
        // rellenar combobox docentes
        rellenarCbxDocentes();

        // rellenar datos a actualizar
        rellenarDatosActualizar(objEstudiantes);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbxDocentes = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbxSecciones = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAgregar = new javax.swing.JButton();
        lblTemplate = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar estudiante");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cbxDocentes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un docente" }));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Asignar seccion");

        cbxSecciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una seccion" }));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Asignar docente");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Nombres");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Apellidos");

        txtAgregar.setBackground(new java.awt.Color(96, 92, 255));
        txtAgregar.setForeground(new java.awt.Color(255, 255, 255));
        txtAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        txtAgregar.setText("AGREGAR");
        txtAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(96, 92, 255)));
        txtAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgregarActionPerformed(evt);
            }
        });

        lblTemplate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTemplate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/template.jpg"))); // NOI18N
        lblTemplate.setToolTipText("Seccionar imagen");
        lblTemplate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jButton1.setText("SELECCIONAR IMAGEN");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTemplate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbxSecciones, 0, 223, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(txtNombres)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(txtApellidos)
                        .addComponent(cbxDocentes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbxDocentes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21)
                        .addComponent(cbxSecciones, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblTemplate, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtAgregar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgregarActionPerformed
        if (!globalObjEstudiantes.isActulaizar()) {
            agregarEstudiante();
        } else {
            actualizarEstudiante();
        }
    }//GEN-LAST:event_txtAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        files.seleccionarArchivo(lblTemplate, this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rellenarCbxSecciones() {
        Conexion.connect();

        try {
            String strQuery = "SELECT * FROM secciones";
            ResultSet rs = con.consultarRegistro(strQuery);
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("ID"));
                int seccion = Integer.parseInt(rs.getString("NUM_SECCION"));

                cbxSecciones.addItem(new Secciones(id, seccion));

            }
            Conexion.disconnect();
        } catch (NumberFormatException | SQLException e) {

            System.out.println(e.getMessage());
        }
    }

    private void rellenarCbxDocentes() {
        con.connect();

        try {
            String strQuery = "SELECT * FROM docentes";
            ResultSet rs = con.consultarRegistro(strQuery);
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("ID"));
                String nombres = rs.getString("NOMBRES");
                String apellidos = rs.getString("APELLIDOS");
                cbxDocentes.addItem(new Docente(id, nombres, apellidos));

            }
            Conexion.disconnect();
        } catch (NumberFormatException | SQLException e) {

            System.out.println(e.getMessage());
        }
    }

    private void selectItemComboBoxByValueDocente(JComboBox cbx, String idItemToSelect) {
        for (int i = 1; i < cbx.getItemCount(); i++) {

            Docente item = (Docente) cbx.getItemAt(i);

            String valor = item.getNombresDocente();

            if (idItemToSelect.equalsIgnoreCase(valor)) {
                cbx.setSelectedIndex(i);
                break;
            }
        }
    }

    private void selectItemComboBoxByValueSeccion(JComboBox cbx, int idItemToSelect) {
        for (int i = 1; i < cbx.getItemCount(); i++) {

            Secciones item = (Secciones) cbx.getItemAt(i);

            int valor = item.getNum_seccion();

            if (valor == idItemToSelect) {
                cbx.setSelectedIndex(i);
                break;
            }
        }
    }

    private void rellenarDatosActualizar(Estudiantes objEstuante) {

        // agregar datos al objeto global
        globalObjEstudiantes.setActulaizar(objEstuante.isActulaizar());
        globalObjEstudiantes.setId(objEstuante.getId());
        // agregar datos en los textField
        txtNombres.setText(objEstuante.getNombres());
        txtApellidos.setText(objEstuante.getApellidos());
        selectItemComboBoxByValueDocente(cbxDocentes, objEstuante.getNombresDocente());
        selectItemComboBoxByValueSeccion(cbxSecciones, objEstuante.getId_seccion());

        txtAgregar.setText("Actualizar");
    }

    private void agregarEstudiante() {

        ValidarDatosEstudiantes validarEstudiante = new ValidarDatosEstudiantes(txtNombres, txtApellidos, cbxSecciones, cbxDocentes);

        if (validarEstudiante.isValid()) {

            Conexion.connect();

            Docente doc = (Docente) cbxDocentes.getSelectedItem();
            Secciones sec = (Secciones) cbxSecciones.getSelectedItem();

            String strQuery = "INSERT INTO estudiantes (ID, ID_DOCENTE, ID_SECCION, NOMBRES, APELLIDOS, IMAGEN) VALUES(null, ?, ?, ?, ?, ?)";
            try {

                PreparedStatement req = con.ejecuatarSenteciaSQL(strQuery);
                req.setInt(1, doc.getIdDocente());
                req.setInt(2, sec.getId());
                req.setString(3, txtNombres.getText());
                req.setString(4, txtApellidos.getText());
                req.setString(5, files.getImagenName() != null ? files.getImagenName() : "template.jpg");

                req.executeUpdate();

                generarNotas(req.getGeneratedKeys().getInt(1));

                if (files.getImagenName() != null) {
                    files.moverArchivo();
                }
                Conexion.disconnect();
                CSPrincipal.eventos.post(true);
                txtNombres.setText("");
                txtApellidos.setText("");
                cbxSecciones.setSelectedIndex(0);
                cbxDocentes.setSelectedIndex(0);
                lblTemplate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/template.jpg")));

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
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

    private void actualizarEstudiante() {

        ValidarDatosEstudiantes validarEstudiante = new ValidarDatosEstudiantes(txtNombres, txtApellidos, cbxSecciones, cbxDocentes);
        if (validarEstudiante.isValid()) {
            Conexion.connect();
            Secciones cbxSeccion = (Secciones) this.cbxSecciones.getSelectedItem();
            Docente cbxDocente = (Docente) this.cbxDocentes.getSelectedItem();
            String nombres = txtNombres.getText();
            String apellidos = txtApellidos.getText();

            try {
                String strQuery = "UPDATE estudiantes SET ID_DOCENTE = ?, ID_SECCION = ?, NOMBRES = ?, APELLIDOS = ?, IMAGEN = ? WHERE ID = ?";
                PreparedStatement pstm = con.ejecuatarSenteciaSQL(strQuery);
                pstm.setInt(1, cbxDocente.getIdDocente());
                pstm.setInt(2, cbxSeccion.getId());
                pstm.setString(3, nombres);
                pstm.setString(4, apellidos);
                pstm.setString(5, files.getImagenName() != null ? files.getImagenName() : "template.jpg");
                pstm.setInt(6, globalObjEstudiantes.getId());
                pstm.executeUpdate();

                if (files.getImagenName() != null) {
                    files.moverArchivo();
                }
                Conexion.disconnect();
                CSPrincipal.eventos.post(true);

                this.setVisible(false);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

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
            java.util.logging.Logger.getLogger(AddEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddEstudiante dialog = new AddEstudiante(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> cbxDocentes;
    private javax.swing.JComboBox<Object> cbxSecciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTemplate;
    private javax.swing.JButton txtAgregar;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
