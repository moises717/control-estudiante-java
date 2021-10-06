package utils;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ValidarDatosEstudiantes {

    private JTextField nombres;
    private JTextField apellidos;
    private JComboBox secciones;
    private JComboBox docentes;
    private boolean errorNombre = false;
    private boolean errorApellido = false;
    private boolean errorDocentes = false;
    private boolean errorSeccion = false;

    public ValidarDatosEstudiantes(JTextField nombre, JTextField apellido, JComboBox seccion, JComboBox docente) {
        this.nombres = nombre;
        this.apellidos = apellido;
        this.secciones = seccion;
        this.docentes = docente;

        // convertir a objecto las clases combobox para validar
        validarDocente(this.docentes);
        validarSeccion(this.secciones);
        validarNombre(this.nombres);
        validarApellido(this.apellidos);
    }

    private void validarNombre(JTextField nombre) {
        if (nombre.getText().isEmpty()) {
            nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51)));
            this.setErrorNombre(true);
        } else {
            this.setErrorNombre(false);
            nombre.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));

        }
    }

    private void validarApellido(JTextField apellido) {
        if (apellido.getText().isEmpty()) {
            apellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51)));
            this.setErrorApellido(true);
        } else {
            setErrorApellido(false);
            apellido.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
        }
    }

    private void validarSeccion(JComboBox seccion) {
        System.out.println(seccion.getSelectedItem());
        if (seccion.getSelectedIndex() == 0) {
            seccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51)));
            this.setErrorSeccion(true);
        } else {
            this.setErrorSeccion(false);
            seccion.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
        }
    }

    private void validarDocente(JComboBox docente) {
        if (docente.getSelectedIndex() == 0) {
            docente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51)));
            this.setErrorDocentes(true);
        } else {
            this.setErrorDocentes(false);
            docente.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
        }
    }

    public boolean isValid() {
        if (this.isErrorDocentes() || this.isErrorSeccion() || this.isErrorNombre() || this.isErrorApellido()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isErrorNombre() {
        return errorNombre;
    }

    public void setErrorNombre(boolean errorNombre) {
        this.errorNombre = errorNombre;
    }

    public boolean isErrorApellido() {
        return errorApellido;
    }

    public void setErrorApellido(boolean errorApellido) {
        this.errorApellido = errorApellido;
    }

    public boolean isErrorDocentes() {
        return errorDocentes;
    }

    public void setErrorDocentes(boolean errorDocentes) {
        this.errorDocentes = errorDocentes;
    }

    public boolean isErrorSeccion() {
        return errorSeccion;
    }

    public void setErrorSeccion(boolean errorSecciones) {
        this.errorSeccion = errorSecciones;
    }

}
