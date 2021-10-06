package controlGUI;

import com.formdev.flatlaf.*;
import javax.swing.UIManager;
import org.greenrobot.eventbus.EventBus;

public class CSPrincipal extends javax.swing.JFrame {

    static int xMouse, yMouse;
    public static EventBus eventos = new EventBus();

    public CSPrincipal() {
        initComponents();

        // Bordes redondeados en el jframe
        //this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 11, 11));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbldoor = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbladd = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbladd1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbladd2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        bgPanel.setBackground(new java.awt.Color(255, 255, 255));
        bgPanel.setMinimumSize(new java.awt.Dimension(783, 349));
        bgPanel.setPreferredSize(new java.awt.Dimension(783, 349));
        bgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerPanel.setBackground(new java.awt.Color(0, 48, 73));
        headerPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerPanelMouseDragged(evt);
            }
        });
        headerPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerPanelMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CONTROL ESTUDIANTES");

        lbldoor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/door.png"))); // NOI18N
        lbldoor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbldoor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbldoorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbldoorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbldoorMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SALIR");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logo_book.png"))); // NOI18N

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addGap(101, 101, 101)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addGap(75, 75, 75)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbldoor)
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lbldoor, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bgPanel.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, -1));

        lbladd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbladd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/estudents.png"))); // NOI18N
        lbladd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbladd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbladdMousePressed(evt);
            }
        });
        bgPanel.add(lbladd, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 60, 50));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Estudiantes");
        bgPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 205, 110, 30));

        lbladd1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbladd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/docentes.png"))); // NOI18N
        lbladd1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbladd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbladd1MousePressed(evt);
            }
        });
        bgPanel.add(lbladd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 160, 60, 50));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Docentes");
        bgPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 205, 110, 30));

        lbladd2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbladd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/classroom.png"))); // NOI18N
        lbladd2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbladd2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbladd2MousePressed(evt);
            }
        });
        bgPanel.add(lbladd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 60, 50));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Secciones");
        bgPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 205, 110, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 686, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void headerPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerPanelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerPanelMousePressed

    private void headerPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerPanelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerPanelMouseDragged

    private void lbldoorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldoorMouseEntered
        lbldoor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/doorexit.png")));
    }//GEN-LAST:event_lbldoorMouseEntered

    private void lbldoorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldoorMouseExited
        lbldoor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/door.png")));
    }//GEN-LAST:event_lbldoorMouseExited

    private void lbldoorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldoorMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lbldoorMouseClicked

    private void lbladdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbladdMousePressed
        EstudiantesGUI frmEstudiantes = new EstudiantesGUI();
        frmEstudiantes.setVisible(true);
        this.setVisible(false);
        eventos.register(frmEstudiantes);
    }//GEN-LAST:event_lbladdMousePressed

    private void lbladd1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbladd1MousePressed
        DocentesGUI frmDoc = new DocentesGUI();
        frmDoc.setVisible(true);
        this.setVisible(false);
        eventos.register(frmDoc);
    }//GEN-LAST:event_lbladd1MousePressed

    private void lbladd2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbladd2MousePressed
        seccionesGUI frmSecciones = new seccionesGUI();
        frmSecciones.setVisible(true);
        this.setVisible(false);
        eventos.register(frmSecciones);
    }//GEN-LAST:event_lbladd2MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CSPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbladd;
    private javax.swing.JLabel lbladd1;
    private javax.swing.JLabel lbladd2;
    private javax.swing.JLabel lbldoor;
    // End of variables declaration//GEN-END:variables
}
