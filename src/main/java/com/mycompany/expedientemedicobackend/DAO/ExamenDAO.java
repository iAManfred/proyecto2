package com.mycompany.expedientemedicobackend.DAO;


import com.mycompany.expedientemedicobackend.logic.Examen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ExamenDAO {
    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean create(Examen examen){
        String sql = "INSERT INTO examen(id,nombre,direccion,persona) VALUES(?,?,?,?)";
        
        try{
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1,examen.getId());
            ps.setString(2, examen.getNombre());
            ps.setString(3, examen.getDireccion());
            ps.setInt(4, examen.getIdPersona());
            ps.execute();
        }
        catch(Exception e){ 
            return false;   
        }
        
        return true;
    }
    
    
    public List<Examen> read(int idPer) {
        List examenes = new ArrayList();
        String sql = "SELECT * FROM examen WHERE persona=?;";
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPer);
            rs = ps.executeQuery();
            while (rs.next()) {
                Examen aux = new Examen();

                aux.setId(rs.getInt("id"));
                aux.setNombre(rs.getString("nombre"));
                aux.setIdPersona(rs.getInt("persona"));
                aux.setDireccion(rs.getString("direccion"));
                
                examenes.add(aux);
            }
        } 
        catch (Exception e) {
            return null;
        }
        
        return examenes;
    }
    
    public void delete(int id) {
        String sql = "DELETE FROM examen WHERE id=?;";
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } 
        catch (Exception e) {
        }
    }
    
    public void deletePer(int idPer) {
        String sql = "DELETE FROM examen WHERE persona=?;";
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPer);
            ps.execute();
        } 
        catch (Exception e) {
        }
    }
    
    
    
    
}//FIN CLASE


