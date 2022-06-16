package com.mycompany.expedientemedicobackend.DAO;


import com.mycompany.expedientemedicobackend.logic.Enfermedad;
import com.mycompany.expedientemedicobackend.logic.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PersonaDAO {
    
    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean create(Persona per,String id_doc){
        String sql = "INSERT INTO persona(id,cedula,nombre,sexo,id_doc)"+
        "VALUES(?,?,?,?,?)";
        
        try{
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, per.getId());
            ps.setString(2, per.getCedula());
            ps.setString(3, per.getNombre());
            ps.setString(4, per.getSexo());
            ps.setString(5, id_doc);
            ps.execute();
        }
        catch(Exception e){ 
            return false;   
        }
        
        return true;
    }
    
    public List<Enfermedad> readEnf(int id){
        ArrayList<Enfermedad> enfermedades = new ArrayList<>();
        String sql = "SELECT * FROM perxenf WHERE persona=?;";
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Enfermedad aux = new Enfermedad();

                aux.setId(rs.getInt("id"));
                aux.setNombre(rs.getString("nombre"));
                
                enfermedades.add(aux);
            }
        } 
        catch (Exception e) {
            return null;
        }

        return enfermedades;
        
    }
    
   public List<Persona> read(String idDoc) {
        ArrayList<Persona> personas = new ArrayList<>();
        String sql = "SELECT * FROM persona WHERE doctor=?;";
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, idDoc);
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona aux = new Persona();

                aux.setId(rs.getInt("id"));
                aux.setCedula(String.valueOf(rs.getInt("cedula")));
                aux.setNombre(rs.getString("nombre"));
                aux.setSexo(rs.getString("sexo"));
                aux.setEnfermedades(this.readEnf(aux.getId()));
                
                personas.add(aux);
            }
        } 
        catch (Exception e) {
            return null;
        }

        return personas;
    }
   
   public Persona read(int id) {
        String sql = "SELECT * FROM persona WHERE id=?;";
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona aux = new Persona();

                aux.setId(rs.getInt("id"));
                aux.setCedula(String.valueOf(rs.getInt("cedula")));
                aux.setNombre(rs.getString("nombre"));
                aux.setSexo(rs.getString("sexo"));
                aux.setEnfermedades(this.readEnf(aux.getId()));
                
                return aux;
            }
        } 
        catch (Exception e) {
            return null;
        }
        
        return null;
    }
   
   public Persona read(String cedula,String idDoc) {
        String sql = "SELECT * FROM persona WHERE doctor=? AND cedula=?;";
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, idDoc);
            ps.setString(1, cedula);
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona aux = new Persona();

                aux.setId(rs.getInt("id"));
                aux.setCedula(String.valueOf(rs.getInt("cedula")));
                aux.setNombre(rs.getString("nombre"));
                aux.setSexo(rs.getString("sexo"));
                aux.setEnfermedades(this.readEnf(aux.getId()));
                
                return aux;
            }
        } 
        catch (Exception e) {
            return null;
        }
        
        return null;
    }
    
    public boolean update(Persona per){
        String sql = "UPDATE persona set nombre=?, sexo=?, correo=? Where id=?;";
        sql += "DELETE FROM perxenf WHERE persona=?";
        
        for(Enfermedad enf:per.getEnfermedades()){
            sql+="INSERT INTO perxenf (persona,enfermedad) VALUES(?,?);";
        }
        try{
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getSexo());
            ps.setString(3, per.getCorreo());
            ps.setInt(4, per.getId());
            ps.setInt(5, per.getId());
            int j = 0;
            for(int i = 6;j<per.getEnfermedades().size();i++){
                ps.setInt(i, per.getId());
                i++;
                ps.setInt(i, per.getEnfermedades().get(j).getId());
                j++;
            }
            
            ps.executeUpdate();
        } 
        catch (SQLException e) {
            return false;
        }
        
        return true;
    }
    
    public void delete(int id) {
        String sql = "DELETE FROM cita WHERE persona=?;";
        sql += "DELETE FROM examen WHERE persona=?;";
        sql += "DELETE FROM perxenf WHERE persona=?;";
        sql += "DELETE FROM persona WHERE id=?;";
        
        try {
            ExamenDAO examDAO = new ExamenDAO();
            examDAO.deletePer(id);
            
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            ps.setInt(3, id);
            ps.setInt(4, id);
            
            ps.execute();
        } 
        catch (Exception e) {
        }
    }
    
}//FIN CLASE
