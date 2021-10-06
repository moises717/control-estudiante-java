package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Archivos {

    private String ruta;
    private String nombreImagen = null;

    public void seleccionarArchivo(JLabel lblTemplate, JDialog ventana) {
        // Instanciar la clase JFileChooser
        JFileChooser fc = new JFileChooser();
        // Tipos de archivos a filtrar en el modal
        FileNameExtensionFilter fil = new FileNameExtensionFilter("SELECCIONAR IMAGEN JPG, PNG", "JPG", "jpg", "JPEG", "png", "PNG");
        fc.setFileFilter(fil);

        // Abrir el modal para seleccionar el archivo
        int res = fc.showOpenDialog(ventana);

        // verificar si selecciono un archivo
        if (res == JFileChooser.APPROVE_OPTION) {
            // Asignar ruta
            ruta = fc.getSelectedFile().getPath();
            // Asignar nombre de la imagen
            this.setImagenName(fc.getSelectedFile().getName());

            // Abrir el preview
            rsscalelabel.RSScaleLabel.setScaleLabel(lblTemplate, ruta);

        }
    }

    public void moverArchivo() {
        // Path donde gardar el archivo
        String newPath = "images/" + this.nombreImagen;
        // verificar directorio
        File dir = new File(newPath);
        // verificar si existe el directorio si no crearlo
        if (!dir.exists()) {
            dir.mkdirs();
        }
        
        // Origen del archivo seleccionado
        File origen = new File(ruta);

        try {
            // Copiar el archivo al nuevo directorio
            Files.copy(origen.toPath(), dir.toPath(), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Metodos
    public String getImagenName() {
        return nombreImagen;
    }

    public void setImagenName(String img) {
        this.nombreImagen = img;
    }

}
