package com.mycompany.expedientemedicobackend.DAO;

import com.mycompany.expedientemedicobackend.logic.Slot;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class SlotDAO {
    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean create(List<Slot> horario,String idDoc){
        String sql = "INSERT INTO slot(doctor,checked,dia,desde,hasta) "+
        "VALUES(?,?,?,?,?)";
        
        for(int i=0;i<horario.size();i++){
            try{
                con = cn.getConexion();
                ps = con.prepareStatement(sql);
                ps.setString(1, idDoc);
                ps.setBoolean(2, horario.get(i).isChecked());
                ps.setInt(3, i);
                ps.setInt(4, horario.get(i).getFrom());
                ps.setInt(5, horario.get(i).getTo());
                ps.execute();
            }
            catch(Exception e){ 
                return false;   
            }
        }
        
        return true;
    }
    
    public List read(String idDoc) {
        ArrayList<Slot> horario = new ArrayList<>();
        String sql = "SELECT * FROM slot Where doctor=? order by dia;";
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, idDoc);
            rs = ps.executeQuery();
            while (rs.next()) {
                Slot aux = new Slot();
                
                aux.setChecked(rs.getBoolean("checked"));
                aux.setFrom(rs.getInt("desde"));
                aux.setFrom(rs.getInt("hasta"));
                
                horario.add(aux);
            }
        } 
        catch (Exception e) {
            return null;
        }

        return horario;
    }
    
}//FIN CLASE
