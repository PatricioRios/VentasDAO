/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.controladores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.Categoria;
import ventasdao.objetos.Producto;

/**
 *
 * @author hchanampe
 */
public class ProductoControlador implements ICrud<Producto>{

   private Connection connection;

    private Statement statementmt;

    private PreparedStatement ps;

    private ResultSet resultSet;

    private String query;

    private String sql;
    
    private CategoriaControlador categoriaControlador;

  ;

    @Override
    public boolean crear(Producto entidad) throws SQLException, Exception {
        
        connection = Conexion.obtenerConexion ();
        String sql = "INSERT INTO productos (nombre,descripcion,precio,fecha_creacion, categoria_id) VALUES (?,?,?,?,?)";
        Date fecha = new Date(entidad.getFechaCreacion().getTime());
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.setFloat(3, entidad.getPrecio());
            ps.setDate(4, fecha);
            ps.setInt(5, entidad.getCategoria().getId());
            ps.executeUpdate();
            connection.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(Producto entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "DELETE FROM productos WHERE id = ?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, entidad.getId());
        int filas = ps.executeUpdate();
        connection.close();
        return filas > 0;
    }


    @Override
    public Producto extraer(int id) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        query = "SELECT * FROM productos WHERE id = ?";
        ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        resultSet = ps.executeQuery();
        connection.close();

        if (resultSet.next()) {
            Producto p = new Producto();
            p.setId(id);
            p.setDescripcion(resultSet.getString("descripcion"));
            p.setPrecio(resultSet.getFloat("precio"));
            return p;
        }

        return null;
    }


    @Override
    public boolean modificar(Producto entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "UPDATE productos SET descripcion = ?, precio = ?, categoria_id = ? WHERE id = ?";
        ps = connection.prepareStatement(sql);
        ps.setString(1, entidad.getDescripcion());
        ps.setDouble(2, entidad.getPrecio());
        ps.setInt(3, entidad.getCategoria().getId());
        ps.setInt(4, entidad.getId());
        ps.executeUpdate();
        connection.close();
        return true;
    }


    @Override
    public ArrayList <Producto> listar() throws Exception {
         connection = Conexion.obtenerConexion ();
        try{
            
            this.statementmt = connection.createStatement();
            this.query = "SELECT * FROM productos";
            this.resultSet   = statementmt.executeQuery(query);
            connection.close();
            
            ArrayList<Producto> productos = new ArrayList();
            
            while(resultSet.next()){
                
                Producto producto = new Producto();
                
                producto.setNombre(resultSet.getString("nombre"));
                producto.setDescripcion(resultSet.getString("descripcion"));
                producto.setId(resultSet.getInt("id"));
                producto.setPrecio (resultSet.getFloat("precio"));
                producto.setFechaCreacion(resultSet.getDate("fecha_creacion"));
                producto.setCategoria(getCategoria(resultSet.getInt("categoria_id")));
                        //System.out.println(cliente);

                productos.add(producto);
                
            }
            //System.out.println(cont);
            return productos;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
 private Categoria getCategoria(Integer id) throws Exception{
     this.categoriaControlador = new CategoriaControlador();
     
     Categoria categoria = categoriaControlador.extraer(id);
     
     return categoria;
 }
    public List<Producto> nameStartsWith(String prefix) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        query = "SELECT * FROM productos WHERE descripcion ILIKE ?";
        ps = connection.prepareStatement(query);
        ps.setString(1, prefix + "%");
        resultSet = ps.executeQuery();
        connection.close();

        List<Producto> lista = new ArrayList<>();
        while (resultSet.next()) {
            Producto p = new Producto();
            p.setId(resultSet.getInt("id"));
            p.setDescripcion(resultSet.getString("descripcion"));
            p.setPrecio(resultSet.getFloat("precio"));
            lista.add(p);
        }
        return lista;
    }

    public List<Producto> filterByNameAndCategory(String prefix, Categoria categoria) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        query = "SELECT * FROM productos WHERE descripcion ILIKE ? AND categoria_id = ?";
        ps = connection.prepareStatement(query);
        ps.setString(1, prefix + "%");
        ps.setInt(2, categoria.getId());
        resultSet = ps.executeQuery();
        connection.close();

        List<Producto> lista = new ArrayList<>();
        while (resultSet.next()) {
            Producto p = new Producto();
            p.setId(resultSet.getInt("id"));
            p.setDescripcion(resultSet.getString("descripcion"));
            p.setPrecio(resultSet.getFloat("precio"));
            lista.add(p);
        }
        return lista;
    }

}
