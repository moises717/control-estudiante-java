package controlGUI;

import DB.Conexion;
import com.formdev.flatlaf.FlatLightLaf;
import controlBL.Docente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import org.greenrobot.eventbus.Subscribe;
import utils.CustomTable;

public class DocentesGUI extends javax.swing.JFrame {

    static int xMouse;
    static int yMouse;
    private static final Conexion con = new Conexion();

    public DocentesGUI() {
        initComponents();
        this.tblDocentes.setDefaultRenderer(Object.class, new CustomTable());
        cargarDocentes();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDocentes = new javax.swing.JTable();
        tfBuscar = new javax.swing.JTextField();
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
        bgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDocentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Seccion", "Nota Final", "Docente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDocentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDocentesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDocentes);

        bgPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 800, 530));

        tfBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfBuscarKeyReleased(evt);
            }
        });
        bgPanel.add(tfBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 40, 190, 30));

        btnAgregar.setBackground(new java.awt.Color(96, 92, 255));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btnAgregar.setText("Agregar docente");
        btnAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAgregar.setBorderPainted(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setMargin(new java.awt.Insets(2, 14, 20, 14));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAgregarMousePressed(evt);
            }
        });
        bgPanel.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 170, 30));

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
        jLabel1.setText("Docentes");
        titlebarJpanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 2, -1, 20));

        bgPanel.add(titlebarJpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 25));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/buscar.png"))); // NOI18N
        bgPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 33, 30, 40));

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
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        bgPanel.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 30));

        btnVer.setBackground(new java.awt.Color(42, 157, 143));
        btnVer.setForeground(new java.awt.Color(255, 255, 255));
        btnVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/estudents_23px.png"))); // NOI18N
        btnVer.setText("VER ESTUDIANTES");
        btnVer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnVer.setBorderPainted(false);
        btnVer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVer.setEnabled(false);
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });
        bgPanel.add(btnVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
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

    private void btnAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMousePressed
        new AddDocente(this, true).setVisible(true);
    }//GEN-LAST:event_btnAgregarMousePressed

    private void tblDocentesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDocentesMousePressed
        this.btnEliminar.setEnabled(true);
        this.btnActualizar.setEnabled(true);
        this.btnVer.setEnabled(true);
    }//GEN-LAST:event_tblDocentesMousePressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        this.eliminarDocente();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        this.openModal();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tfBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarKeyReleased
        filtrarDatos();
    }//GEN-LAST:event_tfBuscarKeyReleased

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        // seleccionar la celda
        int tblFila = tblDocentes.getSelectedRow();
        
        // verificar que haya celda seleccionada
        if (tblFila >= 0) {
            
            // Obtener id
            int id = Integer.parseInt(tblDocentes.getValueAt(tblFila, 0).toString());
            // Abrir ventana estudiantes
            new EstudiantesGUI(id, 0, 1).setVisible(true);
            this.setVisible(false);
            
        }else{
            JOptionPane.showMessageDialog(this, "No hay celda seleccionadas.");
        }


    }//GEN-LAST:event_btnVerActionPerformed

    private void openModal() {
        Docente objDocentes = new Docente();

        // otener la fila seccionada
        int tblFila = tblDocentes.getSelectedRow();

        // verificar que existan datos seleccionados
        if (tblFila >= 0) {

            // obtener datos de la fila y convertirlos el tipo de dato
            int id = Integer.parseInt(tblDocentes.getValueAt(tblFila, 0).toString());
            String nombres = tblDocentes.getValueAt(tblFila, 1).toString();
            String apellidos = tblDocentes.getValueAt(tblFila, 2).toString();

            // Agregar los datos a la clase seccion
            objDocentes.setIdDocente(id);
            objDocentes.setNombresDocente(nombres);
            objDocentes.setApellidosDocente(apellidos);
            objDocentes.setActulizar(true);

            // Abrir modal y pasarle los datos a actualizar
            new AddDocente(this, true, objDocentes).setVisible(true);
        } else {
            btnActualizar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }
    }

    private void crearTabla(ResultSet rs) {

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("ID");
        tableModel.addColumn("NOMBRES");
        tableModel.addColumn("APELLIDOS");

        try {

            // Agregar datos a la tabla
            while (rs.next() == true) {

                Object[] objs = {rs.getString("ID"), rs.getString("NOMBRES"), rs.getString("APELLIDOS")};

                tableModel.addRow(objs);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        tblDocentes.setModel(tableModel);
    }

    private void cargarDocentes() {

        Conexion.connect();

        try {

            String strQuery = "SELECT * FROM docentes";

            ResultSet rs = con.consultarRegistro(strQuery);

            crearTabla(rs);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void eliminarDocente() {
        Conexion.connect();
        int tblFila = tblDocentes.getSelectedRow();

        if (tblFila >= 0) {
            int idDelete = Integer.parseInt(tblDocentes.getValueAt(tblFila, 0).toString());
            String strQuery = "DELETE FROM docentes WHERE ID = ?";

            try {

                PreparedStatement pstm = con.ejecuatarSenteciaSQL(strQuery);
                pstm.setInt(1, idDelete);
                pstm.execute();

                this.cargarDocentes();

            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }

    private void filtrarDatos() {
        Conexion.connect();

        try {

            String strQuery = "SELECT * FROM docentes WHERE NOMBRES LIKE '%" + tfBuscar.getText() + "%' ";

            ResultSet rs = con.consultarRegistro(strQuery);

            crearTabla(rs);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recargarVentana(Boolean msg) {
        if (msg) {
            this.cargarDocentes();
        }
    }

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println(e.getMessage());
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DocentesGUI().setVisible(true);
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
    private javax.swing.JTable tblDocentes;
    private javax.swing.JTextField tfBuscar;
    private javax.swing.JPanel titlebarJpanel;
    // End of variables declaration//GEN-END:variables
}
