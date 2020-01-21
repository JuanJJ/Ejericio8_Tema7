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
            
    public List<Videoclub> getVideoclub(int categoria) throws SQLException {
        List<Videoclub>lista=new ArrayList<>();
        String sql="SELECT DISTINCT store.* FROM store,inventory,film,film_category,category WHERE (store.store_id=inventory.store_id)AND (inventory.film_id=film.film_id)AND(film.film_id=film_category.film_id)AND(film_category.category_id=category.category_id)AND category.category_id="+categoria;
        pst=cn.prepareStatement(sql);
        rs=pst.executeQuery();
        
        while (rs.next()) {            
            int idVideoclub=rs.getInt(1);
            String nombre=rs.getString("nombre");
            Videoclub videclub=new Videoclub(idVideoclub, nombre);
            lista.add(videclub);
        }
        return lista;
    }
    
    public List<Pelicula> getPelicula(int idVideoclub, int idCategoria) throws SQLException {
        List<Pelicula>lista=new ArrayList<>();
        String sql="SELECT DISTINCT film.* FROM inventory, film, film_category WHERE ( inventory.film_id = film.film_id ) AND( film.film_id = film_category.film_id ) AND inventory.store_id = "+idVideoclub+" AND film_category.category_id ="+idCategoria; 
        pst=cn.prepareStatement(sql);
        rs=pst.executeQuery();
        
        while (rs.next()) {            
            int idPelicula=rs.getInt(1);
            String titulo=rs.getString(2);
            Pelicula peli=new Pelicula(idPelicula, titulo);
            lista.add(peli);
        }
        return lista;
    }
}
