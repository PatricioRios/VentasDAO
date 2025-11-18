package ventasdao.controladores;

import ventasdao.objetos.LineaFactura;
import ventasdao.objetos.Producto;
import ventasdao.dominio.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LineaFacturaControlador implements ICrud<LineaFactura> {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    @Override
    public boolean crear(LineaFactura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "INSERT INTO lineas_factura (cantidad, producto_id, factura_id) VALUES (?, ?, ?)";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, entidad.getCantidad());
        ps.setInt(2, entidad.getProducto().getId());
        ps.setInt(3, entidad.getFacturaId());
        ps.executeUpdate();
        connection.close();
        return true;
    }

    @Override
    public boolean eliminar(LineaFactura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "DELETE FROM lineas_factura WHERE id = ?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, entidad.getId());
        int filas = ps.executeUpdate();
        connection.close();
        return filas > 0;
    }

    @Override
    public LineaFactura extraer(int id) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "SELECT * FROM lineas_factura WHERE id = ?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        LineaFactura linea = null;
        ProductoControlador productoControlador = new ProductoControlador();

        if (rs.next()) {
            Producto p = productoControlador.extraer(rs.getInt("producto_id"));

            linea = new LineaFactura(
                    rs.getInt("id"),
                    rs.getInt("cantidad"),
                    p,
                    rs.getInt("factura_id")
            );
        }

        connection.close();
        return linea;
    }

    @Override
    public boolean modificar(LineaFactura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "UPDATE lineas_factura SET cantidad = ?, producto_id = ?, factura_id = ? WHERE id = ?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, entidad.getCantidad());
        ps.setInt(2, entidad.getProducto().getId());
        ps.setInt(3, entidad.getFacturaId());
        ps.setInt(4, entidad.getId());
        ps.executeUpdate();
        connection.close();
        return true;
    }

    @Override
    public List<LineaFactura> listar() throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "SELECT * FROM lineas_factura";
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();

        List<LineaFactura> lista = new ArrayList<>();
        ProductoControlador productoControlador = new ProductoControlador();

        while (rs.next()) {
            Producto p = productoControlador.extraer(rs.getInt("producto_id"));

            LineaFactura linea = new LineaFactura(
                    rs.getInt("id"),
                    rs.getInt("cantidad"),
                    p,
                    rs.getInt("factura_id")
            );

            lista.add(linea);
        }

        connection.close();
        return lista;
    }

    public List<LineaFactura> listarPorFacturaId(int facturaId) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "SELECT * FROM lineas_factura WHERE factura_id = ?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, facturaId);
        rs = ps.executeQuery();

        List<LineaFactura> lista = new ArrayList<>();
        ProductoControlador productoControlador = new ProductoControlador();

        while (rs.next()) {
            Producto p = productoControlador.extraer(rs.getInt("producto_id"));

            LineaFactura linea = new LineaFactura(
                    rs.getInt("id"),
                    rs.getInt("cantidad"),
                    p,
                    rs.getInt("factura_id")
            );

            lista.add(linea);
        }

        connection.close();
        return lista;
    }
}
