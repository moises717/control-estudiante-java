package controlBL;

public class Docente {

    private int id;
    private String nombres;
    private String apellidos;
    private boolean actulizar;

    public Docente(int id, String nombres, String apellidos) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;

    }

    public Docente() {
        // constructor sin parametros 
    }

    public boolean isActulizar() {
        return actulizar;
    }

    public void setActulizar(boolean actulizar) {
        this.actulizar = actulizar;
    }

    public int getIdDocente() {
        return id;
    }

    public void setIdDocente(int id) {
        this.id = id;
    }

    public String getNombresDocente() {
        return nombres;
    }

    public void setNombresDocente(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidosDocente() {
        return apellidos;
    }

    public void setApellidosDocente(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return nombres + " " + apellidos;
    }

}
