/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.controladores;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ventasdao.dominio.Conexion;
import ventasdao.objetos.Factura;
import ventasdao.objetos.TipoDePagoDeFactura;


/**
 *
 * @author hchanampe
 */
public class FacturaControlador implements ICrud<Factura>{

    private Connection connection;

    private Statement stmt;

    private PreparedStatement ps;

    private ResultSet rs;

    private String sql;



    @Override
    public boolean crear(Factura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "INSERT INTO facturas (date, tipo_pago) VALUES (?, ?)";
        ps = connection.prepareStatement(sql);
        ps.setDate(1, new java.sql.Date(entidad.getDate().getTime()));
        ps.setString(2, entidad.getTypeOfPayment().name());
        ps.executeUpdate();
        connection.close();
        return true;
    }



    @Override
    public boolean eliminar(Factura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "DELETE FROM facturas WHERE id = ?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, entidad.getId());
        int filas = ps.executeUpdate();
        connection.close();
        return filas > 0;
    }




    @Override
    public Factura extraer(int id) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "SELECT * FROM facturas WHERE id = ?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        connection.close();

        if (rs.next()) {
            Factura f = new Factura(
                    id,
                    rs.getDate("date"),
                    null,
                    TipoDePagoDeFactura.valueOf(rs.getString("tipo_pago"))
            );
            return f;
        }

        return null;
    }




    @Override
    public boolean modificar(Factura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "UPDATE facturas SET date = ?, tipo_pago = ? WHERE id = ?";
        ps = connection.prepareStatement(sql);
        ps.setDate(1, new java.sql.Date(entidad.getDate().getTime()));
        ps.setString(2, entidad.getTypeOfPayment().name());
        ps.setInt(3, entidad.getId());
        ps.executeUpdate();
        connection.close();
        return true;
    }


    @Override
    public List<Factura> listar() throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "SELECT * FROM facturas";
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();
        connection.close();

        List<Factura> lista = new ArrayList<>();
        while (rs.next()) {
            Factura f = new Factura(
                    rs.getInt("id"),
                    rs.getDate("date"),
                    null,
                    TipoDePagoDeFactura.valueOf(rs.getString("tipo_pago"))
            );
            lista.add(f);
        }

        return lista;
    }



}
