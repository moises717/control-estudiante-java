package controlBL;

public class Secciones {

    private int id;
    private int num_seccion;
    private String asignatura;
    private boolean actualizar;

    public Secciones(int id, int num_seccion) {
        this.id = id;
        this.num_seccion = num_seccion;
    }
    
    public Secciones(){
        // constructor sin parametros.
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public boolean isActualizar() {
        return actualizar;
    }

    public void setActualizar(boolean actualizar) {
        this.actualizar = actualizar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum_seccion() {
        return num_seccion;
    }

    public void setNum_seccion(int num_seccion) {
        this.num_seccion = num_seccion;
    }

    @Override
    public String toString() {
        return String.valueOf(num_seccion);
    }
    
    

}
