package com.mycompany.expedientemedicobackend.DAO;

import com.mycompany.expedientemedicobackend.logic.Cita;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {
    
    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean create(Cita cita){
        String sql = "INSERT INTO cita(doctor=?,persona=?,dia=?,from=?,to=?,"+
        "text=?) VALUES(?,?,?,?,?,?)";
        
        try{
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cita.getDoc());
            ps.setInt(2, cita.getPer().getId());
            ps.setDate(3, Date.valueOf(cita.getDia()));
            ps.setTime(4, Time.valueOf(cita.getFrom()));
            ps.setTime(5, Time.valueOf(cita.getTo()));
            ps.setString(6, cita.getTexto());
            ps.execute();
        }
        catch(Exception e){ 
            return false;   
        }
        
        return true;
    }
    
    public List read(LocalDate dia,String cedulaDoc) {
        ArrayList<Cita> citas = new ArrayList<>();
        String sql = "SELECT * FROM citas Where dia=? AND doctor=?;";
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(dia));
            ps.setString(2, cedulaDoc);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cita aux = new Cita();
                
                aux.setId(rs.getInt("id"));
                aux.setPer(new PersonaDAO().read(rs.getInt("persona")));
                Date diaCita = rs.getDate("dia");
                aux.setDia(diaCita.toLocalDate());
                Time from = rs.getTime("from");
                aux.setFrom(from.toLocalTime());
                Time to = rs.getTime("to");
                aux.setTo(from.toLocalTime());
                aux.setTexto(rs.getString("texto"));
                
                citas.add(aux);
            }
        } 
        catch (Exception e) {
            return null;
        }

        return citas;
    }
   
    public List read(String cedulaPer,String cedulaDoc) {
        ArrayList<Cita> citas = new ArrayList<>();
        String sql = "SELECT * FROM citas Where persona=? AND doctor=?;";
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cedulaPer);
            ps.setString(2, cedulaDoc);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cita aux = new Cita();
                
                aux.setId(rs.getInt("id"));
                Date diaCita = rs.getDate("dia");
                aux.setDia(diaCita.toLocalDate());
                Time from = rs.getTime("from");
                aux.setFrom(from.toLocalTime());
                Time to = rs.getTime("to");
                aux.setTo(from.toLocalTime());
                aux.setTexto(rs.getString("texto"));
                
                citas.add(aux);
            }
        } 
        catch (Exception e) {
            return null;
        }

        return citas;
    }
    
    public boolean update(Cita cita){
        String sql = "UPDATE cita set dia=?, from=?, to=?,texto=? Where id=?;";
      
        try{
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(cita.getDia()));
            ps.setTime(2, Time.valueOf(cita.getFrom()));
            ps.setTime(3, Time.valueOf(cita.getTo()));
            ps.setString(4, cita.getTexto());
            ps.setInt(5, cita.getId());
            ps.executeUpdate();
        } 
        catch (SQLException e) {
            return false;
        }
        
        return true;
    }
    
    public void delete(int id) {
        String sql = "DELETE FROM cita WHERE id=?;";
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } 
        catch (Exception e) {
        }
    }
    
}//FIN CLASE
