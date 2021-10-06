package controlGUI;

import DB.Conexion;
import com.formdev.flatlaf.FlatLightLaf;
import controlBL.*;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import org.greenrobot.eventbus.Subscribe;
import utils.CustomTable;

public class EstudiantesGUI extends javax.swing.JFrame {

    private static int xMouse;
    private static int yMouse;
    private static final Conexion con = new Conexion();

    // constructor carga todos estudiantes
    public EstudiantesGUI() {
        initComponents();

        this.tblEstudiantes.setDefaultRenderer(Object.class, new CustomTable());
        this.cargarEstudiantes();
        this.tblEstudiantes.setDefaultEditor(Object.class, null);
    }

    // Constructor para cargar estudiantes por docente
    public EstudiantesGUI(int idDocente, int idSeccion, int type) {
        initComponents();
        this.tblEstudiantes.setDefaultRenderer(Object.class, new CustomTable());
        this.cargarEstudiantesPorDS(idDocente, idSeccion, type);
        this.tblEstudiantes.setDefaultEditor(Object.class, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstudiantes = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        titlebarJpanel = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnActulizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        bgPanel.setBackground(new java.awt.Color(233, 234, 236));
        bgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Seccion", "Nota Final", "Docente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblEstudiantes.setShowGrid(false);
        tblEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblEstudiantesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblEstudiantes);
        if (tblEstudiantes.getColumnModel().getColumnCount() > 0) {
            tblEstudiantes.getColumnModel().getColumn(2).setResizable(false);
        }

        bgPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 820, 550));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        bgPanel.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(533, 40, 190, 30));

        btnAgregar.setBackground(new java.awt.Color(96, 92, 255));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btnAgregar.setText("Agregar estudiante");
        btnAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAgregar.setBorderPainted(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setMargin(new java.awt.Insets(2, 14, 20, 14));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        bgPanel.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 150, 30));

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
        jLabel1.setText("Estudiantes");
        titlebarJpanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 2, -1, 20));

        bgPanel.add(titlebarJpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 25));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/buscar.png"))); // NOI18N
        bgPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 33, 30, 40));

        btnActulizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/update.png"))); // NOI18N
        btnActulizar.setText("Actulizar");
        btnActulizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnActulizar.setBorderPainted(false);
        btnActulizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActulizar.setEnabled(false);
        btnActulizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActulizarActionPerformed(evt);
            }
        });
        bgPanel.add(btnActulizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 100, 30));

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
        bgPanel.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void titlebarJpanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titlebarJpanelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_titlebarJpanelMousePressed

    private void titlebarJpanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titlebarJpanelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_titlebarJpanelMouseDragged

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        new AddEstudiante(this, true).setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        filtrarDatos();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblEstudiantesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEstudiantesMousePressed
        btnEliminar.setEnabled(true);
        btnActulizar.setEnabled(true);
    }//GEN-LAST:event_tblEstudiantesMousePressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarEstudiante();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActulizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActulizarActionPerformed
        if (getDatosActulizar() != null) {
            new AddEstudiante(this, true, getDatosActulizar()).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No hay una celda seleccionada.");
        }
    }//GEN-LAST:event_btnActulizarActionPerformed

    public Estudiantes getDatosActulizar() {
        Estudiantes objEstudiantes = new Estudiantes();

        // Obtener la fila seccionada
        int tblFila = tblEstudiantes.getSelectedRow();
        String docente;
        int seccion;
        // verificar que existan datos seleccionados
        if (tblFila >= 0) {

            // obtener datos de la fila y convertirlos el tipo de dato
            int id = Integer.parseInt(tblEstudiantes.getValueAt(tblFila, 0).toString());
            String nombres = tblEstudiantes.getValueAt(tblFila, 1).toString();
            String apellidos = tblEstudiantes.getValueAt(tblFila, 2).toString();

            if (tblEstudiantes.getValueAt(tblFila, 3) != null) {
                docente = tblEstudiantes.getValueAt(tblFila, 3).toString();
            } else {
                docente = "0";
            }

            if (tblEstudiantes.getValueAt(tblFila, 4) != null) {
                seccion = Integer.parseInt(tblEstudiantes.getValueAt(tblFila, 4).toString());
            } else {
                seccion = 0;
            }

            // Agregar los datos a la clase seccion
            objEstudiantes.setId(id);
            objEstudiantes.setNombres(nombres);
            objEstudiantes.setApellidos(apellidos);
            objEstudiantes.setNombresDocente(docente);
            objEstudiantes.setId_seccion(seccion);
            objEstudiantes.setActulaizar(true);
            return objEstudiantes;
        } else {
            btnActulizar.setEnabled(false);
            btnEliminar.setEnabled(false);
            return null;
        }

    }

    private void cargarEstudiantes() {
        Conexion.connect();

        try {
            String strQuery = "SELECT estudiantes.NOMBRES as NOMBRE_ESTUDIANTE, estudiantes.APELLIDOS as APELLIDO_ESTUDIANTE, estudiantes.ID as ID, docentes.NOMBRES as NOMBRE_DOCENTE, secciones.NUM_SECCION as SECCION, secciones.ASIGNATURAS as ASIGNATURAS "
                    + "FROM estudiantes LEFT JOIN docentes on (estudiantes.ID_DOCENTE = docentes.ID)"
                    + " LEFT JOIN secciones on (estudiantes.ID_SECCION = secciones.ID) "
                    + "LEFT JOIN notas on (estudiantes.ID = notas.ID_ESTUDIANTE) ORDER BY ID DESC";

            ResultSet rs = con.consultarRegistro(strQuery);

            crearTabla(rs);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    // CARGAR LOS ALUMNOS POR DOCENTE O SECCION
    private void cargarEstudiantesPorDS(int idDocente, int idSeccion, int type) {
        int idCargar;
        String column;
        if (type == 1) {
            idCargar = idDocente;
            column = "ID_DOCENTE";
        } else {
            idCargar = idSeccion;
            column = "ID_SECCION";
        }
//ORDER BY ID DESC
        Conexion.connect();

        try {
            String strQuery = "SELECT estudiantes.NOMBRES as NOMBRE_ESTUDIANTE, estudiantes.APELLIDOS as APELLIDO_ESTUDIANTE, estudiantes.ID as ID, docentes.NOMBRES as NOMBRE_DOCENTE, secciones.NUM_SECCION as SECCION, secciones.ASIGNATURAS as ASIGNATURAS "
                    + "FROM estudiantes LEFT JOIN docentes on (estudiantes.ID_DOCENTE = docentes.ID)"
                    + " LEFT JOIN secciones on (estudiantes.ID_SECCION = secciones.ID) "
                    + "INNER JOIN notas on (estudiantes.ID = notas.ID_ESTUDIANTE) WHERE "
                    + column
                    + " ="
                    + idCargar
                    + " ORDER BY ID DESC";

            ResultSet rs = con.consultarRegistro(strQuery);

            crearTabla(rs);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    private void filtrarDatos() {
        Conexion.connect();

        try {

            String strQuery = "SELECT estudiantes.NOMBRES as NOMBRE_ESTUDIANTE, estudiantes.APELLIDOS as APELLIDO_ESTUDIANTE, estudiantes.ID as ID, docentes.NOMBRES as NOMBRE_DOCENTE, secciones.NUM_SECCION as SECCION, secciones.ASIGNATURAS as ASIGNATURAS "
                    + "FROM estudiantes LEFT JOIN docentes on (estudiantes.ID_DOCENTE = docentes.ID)"
                    + " LEFT JOIN secciones on (estudiantes.ID_SECCION = secciones.ID) "
                    + "LEFT JOIN notas on (estudiantes.ID = notas.ID_ESTUDIANTE) WHERE estudiantes.NOMBRES like '%" + txtBuscar.getText() + "%' "
                    + "OR estudiantes.APELLIDOS like '%" + txtBuscar.getText() + "%' ";

            ResultSet rs = con.consultarRegistro(strQuery);

            crearTabla(rs);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Crear los datos de la tabla 
    private void crearTabla(ResultSet rs) {

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("ID");
        tableModel.addColumn("NOMBRE");
        tableModel.addColumn("APELLIDO");
        tableModel.addColumn("DOCENTE");
        tableModel.addColumn("SECCION");
        tableModel.addColumn("ASIGNATURAS");

        try {
            // Agregar datos a la tabla
            while (rs.next() == true) {
                String[] fila = new String[6];

                fila[0] = rs.getString("ID");
                fila[1] = rs.getString("NOMBRE_ESTUDIANTE");
                fila[2] = rs.getString("APELLIDO_ESTUDIANTE");
                fila[3] = rs.getString("NOMBRE_DOCENTE");
                fila[4] = rs.getString("SECCION");
                fila[5] = rs.getString("ASIGNATURAS");

                tableModel.addRow(fila);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        tblEstudiantes.setModel(tableModel);
    }

    private int getIdFromSelectedRow() {
        int fila = tblEstudiantes.getSelectedRow();

        int idDelete = Integer.parseInt(tblEstudiantes.getValueAt(fila, 0).toString());

        return idDelete;
    }

    private void eliminarEstudiante() {
        //  ELIMINAR LA NOTAS DEL ESTUDINATE
        String strQuery1 = "DELETE FROM estudiantes WHERE ID = ?";
        String strQuery2 = "DELETE FROM notas WHERE ID_ESTUDIANTE = ?";
        // ID del estudiante a eliminar
        int idDelete = getIdFromSelectedRow();

        // Conexion y preparacionde la ejecucion
        Connection conn = null;
        PreparedStatement pstm1 = null, pstm2 = null;

        try {
            // asignar conexion
            conn = Conexion.getConexion();

            // si la conexion en null detener todo el proceso
            if (conn == null) {
                return;
            }

            conn.setAutoCommit(false);
            // preparar primera sentencia
            pstm1 = conn.prepareStatement(strQuery1);
            pstm1.setInt(1, idDelete);
            int rowAffected = pstm1.executeUpdate();

            // verificar que se afecto la primera sentencia 
            if (rowAffected != 1) {
                conn.rollback();
            }

            // Preparar segunda sentencia
            pstm2 = conn.prepareStatement(strQuery2);
            pstm2.setInt(1, idDelete);
            pstm2.executeUpdate();

            // Procesar todas las solicitudes
            conn.commit();
            // rellenar la tabla
            this.cargarEstudiantes();

        } catch (SQLException e1) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e2) {
                System.out.println(e2.getMessage());
            }
            System.out.println(e1.getMessage());
        } finally {
            try {

                if (pstm1 != null) {
                    pstm1.close();
                }
                if (pstm2 != null) {
                    pstm2.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e3) {
                System.out.println(e3.getMessage());
            }
        }

    }

    @Subscribe
    public void recargarVentana(Boolean msg) {
        if (msg) {
            this.cargarEstudiantes();
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
                new EstudiantesGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPanel;
    private javax.swing.JButton btnActulizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClose;
    private javax.swing.JTable tblEstudiantes;
    private javax.swing.JPanel titlebarJpanel;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
