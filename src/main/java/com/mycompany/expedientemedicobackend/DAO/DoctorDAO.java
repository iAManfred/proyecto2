package com.mycompany.expedientemedicobackend.DAO;

import com.mycompany.expedientemedicobackend.logic.Doctor;
import com.mycompany.expedientemedicobackend.logic.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean create(Doctor doc){
        String sql = "INSERT INTO doctor(cedula,nombre,especialidad,locacion,"+
        "correo,precio,tiempo,contrasena) VALUES(?,?,?,?,?,?,?,?)";
        
        try{
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,doc.getCedula());
            ps.setString(2, doc.getNombre());
            ps.setString(3, doc.getEspecialidad());
            ps.setString(4, doc.getLocacion());
            ps.setString(5, doc.getCorreo());
            ps.setInt(6, doc.getPrecio());
            ps.setInt(7, doc.getTiempo());
            ps.setString(8, doc.getContrasena());
            ps.execute();
            new SlotDAO().create(doc.getHorario(),doc.getCedula());
            
            
        }
        catch(Exception e){ 
            return false;   
        }
        
        return true;
    }
   
   public Doctor read(String cedula) {
        String sql = "SELECT * FROM doctor WHERE cedula=?;";
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            rs = ps.executeQuery();
            while (rs.next()) {
                Doctor aux = new Doctor();

                aux.setCedula(rs.getString("cedula"));
                aux.setNombre(rs.getString("nombre"));
                aux.setEspecialidad(rs.getString("especialidad"));
                aux.setLocacion(rs.getString("locacion"));
                aux.setContrasena("");
                aux.setCorreo(rs.getString("correo"));
                aux.setPrecio(rs.getInt("precio"));
                aux.setTiempo(rs.getInt("tiempo"));
                aux.setHorario(new SlotDAO().read(aux.getCedula()));
                
                return aux;
            }
        } 
        catch (Exception e) {
            return null;
        }
        
        return null;
    }

    
    public void delete(String cedula) {
        String sql = "DELETE FROM slot WHERE doctor=?;";
        sql += "DELETE FROM doctor WHERE cedula=?;";
        
        try {
            PersonaDAO perDAO = new PersonaDAO();
            for(Persona per:perDAO.read(cedula)){
                perDAO.delete(per.getId());
            }
            
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            ps.setString(2, cedula);
            ps.execute();
        } 
        catch (Exception e) {
        }
    }
    
    public boolean validate(String cedula,String contrasena) {
        String sql = "SELECT * FROM doctor WHERE cedula=? AND contrasena=?;";
        Doctor aux = null;
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            while (rs.next()) {
                aux = new Doctor();

                aux.setCedula(rs.getString("cedula"));
                aux.setNombre(rs.getString("nombre"));
                aux.setEspecialidad(rs.getString("especialidad"));
                aux.setLocacion(rs.getString("locacion"));
                aux.setLocacion(rs.getString("contrasena"));
                aux.setCorreo(rs.getString("correo"));
                aux.setPrecio(rs.getInt("precio"));
                aux.setTiempo(rs.getInt("tiempo"));
            }
        } 
        catch (Exception e) {
            return false;
        }
        
        return (aux==null)? false : true;
    }
    
}//FIN CLASE
