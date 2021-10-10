package DB;

import java.sql.*;

public class Conexion {

    private static Connection conn = null;
    private static final String url = "jdbc:sqlite:C:\\Users\\Moises\\OneDrive\\Documentos\\db\\control.s3db";

    public static void connect() {
        try {

            conn = DriverManager.getConnection(url);
            System.out.println("Conexion a la base de datos establecidad.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Connection getConexion() {
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return conn;
    }

    public static void disconnect() {
        try {
            conn.close();

            System.out.println("Conexion cerrada.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public PreparedStatement ejecuatarSenteciaSQL(String strSenSQL) {

        try {
            PreparedStatement pstm = conn.prepareStatement(strSenSQL);
            return pstm;

        } catch (SQLException e) {
            System.out.println(e);

            return null;
        }

    }

    public ResultSet consultarRegistro(String sentenciaSQL) {
        try {

            PreparedStatement pstm = conn.prepareStatement(sentenciaSQL);

            ResultSet respuesta = pstm.executeQuery();

            return respuesta;
        } catch (SQLException e) {

            System.out.println(e);
            return null;

        }
    }
}
