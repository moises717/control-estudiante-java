package controlBL;

public class Estudiantes extends Docente {

    private int id;
    private int id_docente;
    private int id_seccion;
    private String nombres;
    private String apellidos;
    private String imagen;
    private boolean actulaizar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_docente() {
        return id_docente;
    }

    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
    }

    public int getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(int id_seccion) {
        this.id_seccion = id_seccion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isActulaizar() {
        return actulaizar;
    }

    public void setActulaizar(boolean actulaizar) {
        this.actulaizar = actulaizar;
    }

    @Override
    public String getNombresDocente() {
        return super.getNombresDocente();
    }

    @Override
    public void setNombresDocente(String nombres) {
        super.setNombresDocente(nombres);
    }

    @Override
    public String getApellidosDocente() {
        return super.getApellidosDocente();
    }

    @Override
    public void setApellidosDocente(String apellidos) {
        super.setApellidosDocente(apellidos);
    }

}
