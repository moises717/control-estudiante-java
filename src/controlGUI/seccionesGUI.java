package controlGUI;

import DB.*;
import controlBL.Secciones;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import org.greenrobot.eventbus.Subscribe;
import utils.CustomTable;

public class seccionesGUI extends javax.swing.JFrame {

    static int xMouse, yMouse;

    private static final Conexion con = new Conexion();
    private static final Secciones objSecciones = new Secciones();

    public seccionesGUI() {
        initComponents();
        this.tblSecciones.setDefaultRenderer(Object.class, new CustomTable());
        // Cargar datos al iniciar la ventana
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSecciones = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        titlebarJpanel = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        bgPanel.setBackground(new java.awt.Color(233, 234, 236));
        bgPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSecciones.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblSecciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NUMERO SECCION", "ASIGNATURA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblSecciones.setShowGrid(true);
        tblSecciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblSeccionesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblSecciones);

        bgPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 780, 460));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        bgPanel.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 190, 30));

        btnAgregar.setBackground(new java.awt.Color(96, 92, 255));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btnAgregar.setText("Agregar seccion");
        btnAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAgregar.setBorderPainted(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setMargin(new java.awt.Insets(2, 14, 20, 14));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAgregarMousePressed(evt);
            }
        });
        bgPanel.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 150, 30));

        titlebarJpanel.setBackground(new java.awt.Color(2, 62, 138));
        titlebarJpanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titlebarJpanelMouseDragged(evt);
            }
        });
        titlebarJpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titlebarJpanelMousePressed(evt);
            }
        });
        titlebarJpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblClose.setBackground(new java.awt.Color(255, 51, 51));
        lblClose.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/close.png"))); // NOI18N
        lblClose.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCloseMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCloseMousePressed(evt);
            }
        });
        titlebarJpanel.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(793, 0, 30, 30));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/icon.png"))); // NOI18N
        jLabel1.setText("Secciones");
        titlebarJpanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 2, -1, 20));

        bgPanel.add(titlebarJpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 25));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/buscar.png"))); // NOI18N
        bgPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 33, 30, 40));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/update.png"))); // NOI18N
        btnActualizar.setText("Actulizar");
        btnActualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnActualizar.setBorderPainted(false);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        bgPanel.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 100, 30));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEliminar.setBorderPainted(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setEnabled(false);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        bgPanel.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 30));

        btnVer.setBackground(new java.awt.Color(42, 157, 143));
        btnVer.setForeground(new java.awt.Color(255, 255, 255));
        btnVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/estudents_23px.png"))); // NOI18N
        btnVer.setText("VER ESTUDIANTES");
        btnVer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnVer.setBorderPainted(false);
        btnVer.setEnabled(false);
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });
        bgPanel.add(btnVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 160, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseEntered

        this.lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/closeHover.png")));
    }//GEN-LAST:event_lblCloseMouseEntered

    private void lblCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseExited
        this.lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/close.png")));
    }//GEN-LAST:event_lblCloseMouseExited

    private void lblCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMousePressed
        // cancelar eventos de envio de informacion entre ventanas
        cleanupEvents();
        // Inicar la ventana principal
        new CSPrincipal().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblCloseMousePressed

    private void titlebarJpanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titlebarJpanelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_titlebarJpanelMouseDragged

    private void titlebarJpanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titlebarJpanelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_titlebarJpanelMousePressed

    private void openModal() {

        // otener la fila seccionada
        int tblFila = tblSecciones.getSelectedRow();

        // verificar que existan datos seleccionados
        if (tblFila >= 0) {

            // obtener datos de la fila y convertirlos el tipo de dato
            int id = Integer.parseInt(tblSecciones.getValueAt(tblFila, 0).toString());
            int numeroSeccion = Integer.parseInt(tblSecciones.getValueAt(tblFila, 1).toString());
            String asignatura = tblSecciones.getValueAt(tblFila, 2).toString();

            // Agregar los datos a la clase seccion
            objSecciones.setId(id);
            objSecciones.setNum_seccion(numeroSeccion);
            objSecciones.setAsignatura(asignatura);
            objSecciones.setActualizar(true);

            // Abrir modal y pasarle los datos a actualizar
            new AddSeccion(this, true, objSecciones).setVisible(true);
        } else {
            btnActualizar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }

    }

    // Crear los datos de la tabla 
    private void crearTabla(ResultSet rs) {

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("ID");
        tableModel.addColumn("NUMERO SECCION");
        tableModel.addColumn("ASIGNATURAS");

        try {
            // Agregar datos a la tabla
            while (rs.next() == true) {
                String[] fila = new String[3];

                fila[0] = rs.getString("ID");
                fila[1] = rs.getString("NUM_SECCION");
                fila[2] = rs.getString("ASIGNATURAS");

                tableModel.addRow(fila);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        tblSecciones.setModel(tableModel);
    }

    private void cargarDatos() {

        con.connect();
        try {
            // ejecutar la sentencia para obtener todas las secciones
            ResultSet rs = con.consultarRegistro("SELECT * FROM secciones ORDER BY ID DESC");
            // Listar los datos en la tabla
            crearTabla(rs);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void btnAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMousePressed
        new AddSeccion(this, true).setVisible(true);
    }//GEN-LAST:event_btnAgregarMousePressed

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        // obtener fila seccionada
        int tblFila = tblSecciones.getSelectedRow();

        if (tblFila >= 0) {
            Conexion.connect();
            //obtener el id de la tabla 
            int deleteId = Integer.parseInt(tblSecciones.getValueAt(tblFila, 0).toString());
            // sentencia sql para eliminar la seccion por id
            String strQuery = "DELETE FROM secciones WHERE ID = ?";

            try {
                // Preparar la sentencia
                PreparedStatement pstm = con.ejecuatarSenteciaSQL(strQuery);
                //Pasarle el parametro 
                pstm.setInt(1, deleteId);
                // Ejecutar la sentencia
                pstm.execute();

                // Desactivar los botones
                this.btnEliminar.setEnabled(false);
                this.btnActualizar.setEnabled(false);
                this.cargarDatos();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            btnActualizar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }

    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        openModal();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tblSeccionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSeccionesMousePressed
        this.btnActualizar.setEnabled(true);
        this.btnEliminar.setEnabled(true);
        this.btnVer.setEnabled(true);
    }//GEN-LAST:event_tblSeccionesMousePressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        Conexion.connect();

        try {
            // verificar que exista texto a buscar
            if (!txtBuscar.getText().isEmpty()) {
                // Preparar sentencia
                String strQuery = "SELECT * FROM secciones WHERE NUM_SECCION LIKE '%" + txtBuscar.getText() + "%' ";
                ResultSet rs = con.consultarRegistro(strQuery);
                // Crear la tabla
                crearTabla(rs);

            } else {
                // Si no hay texto a buscar cargar todos los datos
                cargarDatos();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        // seleccionar la celda
        int tblFila = tblSecciones.getSelectedRow();

        // verificar que haya celda seleccionada
        if (tblFila >= 0) {

            // Obtener id
            int id = Integer.parseInt(tblSecciones.getValueAt(tblFila, 0).toString());
            // Abrir ventana estudiantes
            EstudiantesGUI estu = new EstudiantesGUI(0, id, 0);
            estu.setVisible(true);
            CSPrincipal.eventos.register(estu);
            this.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(this, "No hay celda seleccionadas.");
        }
    }//GEN-LAST:event_btnVerActionPerformed
    // Escuchar en eventos enviados desde el modal
    @Subscribe
    public void recargarVentana(Boolean msg) {

        if (msg) {
            this.cargarDatos();
        }

    }

    // Desuscribir eventos al cerrar el modal
    public void cleanupEvents() {
        CSPrincipal.eventos.unregister(this);

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new seccionesGUI().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPanel;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClose;
    private javax.swing.JTable tblSecciones;
    private javax.swing.JPanel titlebarJpanel;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
