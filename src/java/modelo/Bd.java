/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno_2DAW
 */
public class Bd {
    private final static String drv="com.mysql.jdbc.Driver";
    private final static String db="jdbc:mysql://localhost:3306/sakila?useSSL=false";
    private final static String user="root";
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement pst;

    public Bd() throws ClassNotFoundException, SQLException {
        abrirConexion();

    }

    public void abrirConexion() throws ClassNotFoundException, SQLException {
        Class.forName(drv);
        cn=DriverManager.getConnection(db,user,"");
        System.out.println("La conexion se realizo con exito");
    }
    
    public void cerrarConexion() throws SQLException{
        if(rs!=null){
            rs.close();
        }
        if (pst!=null) {
            pst.close();
        }
        if (cn!=null) {
            cn.close();
        }
        
        System.out.println("Conexion cerrada");
    }

    public List<Categoria> getListaCategoria() throws SQLException {
        List<Categoria>lista=new ArrayList<>();
        String sql="SELECT * FROM category";
        pst=cn.prepareStatement(sql);
        rs=pst.executeQuery();
        
        while (rs.next()) {            
            int idCategoria=rs.getInt(1);
            String categoria=rs.getString(2);
            Categoria cate=new Categoria(idCategoria, categoria);
            lista.add(cate);
        }
        return lista;
    }
}
