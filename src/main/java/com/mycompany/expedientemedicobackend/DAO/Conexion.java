package com.mycompany.expedientemedicobackend.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private final String base = "sistema_expediente_medico";
    private final String user = "root";
    private final String password = "root";
    private final String url = "jdbc:mysql://localhost:3306/"+base;
    private Connection con = null;
    
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL_Conexion = this.url+"?user="+this.user+"&password="+
            this.password+"&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            con = DriverManager.getConnection(URL_Conexion);
            System.out.println("CONECCION EXITOSA");
        }
        catch(ClassNotFoundException | SQLException e){
            System.err.println("ERROR: "+e);
        }
        return con;
    }
}
