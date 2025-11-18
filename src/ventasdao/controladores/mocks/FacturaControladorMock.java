package ventasdao.controladores.mocks;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ventasdao.controladores.ICrud;
import ventasdao.objetos.Categoria;
import ventasdao.objetos.Factura;
import ventasdao.objetos.LineaFactura;
import ventasdao.objetos.Producto;
import ventasdao.objetos.TipoDePagoDeFactura;

public class FacturaControladorMock implements ICrud<Factura> {

    private final List<Factura> facturas = new ArrayList<>();

    public FacturaControladorMock() {
        try {
            ProductoControladorMock productoControladorMock = new ProductoControladorMock();
            List<Producto> productos = productoControladorMock.listar();

            // Factura 1
            List<LineaFactura> lineas1 = new ArrayList<>();
            lineas1.add(new LineaFactura(1, 2, productos.get(0), 1)); // Leche
            lineas1.add(new LineaFactura(2, 1, productos.get(1), 1)); // Queso
            facturas.add(new Factura(1, new Date(), lineas1, TipoDePagoDeFactura.CONTADO));

            // Factura 2
            List<LineaFactura> lineas2 = new ArrayList<>();
            lineas2.add(new LineaFactura(3, 5, productos.get(2), 2)); // Pan
            facturas.add(new Factura(2, new Date(), lineas2, TipoDePagoDeFactura.DEBITO));

            // Factura 3
            List<LineaFactura> lineas3 = new ArrayList<>();
            lineas3.add(new LineaFactura(4, 3, productos.get(3), 3)); // Gaseosa
            lineas3.add(new LineaFactura(5, 2, productos.get(4), 3)); // Lavandina
            lineas3.add(new LineaFactura(6, 1, productos.get(5), 3)); // Asado
            facturas.add(new Factura(3, new Date(), lineas3, TipoDePagoDeFactura.TARJETA));

            // Factura 4
            List<LineaFactura> lineas4 = new ArrayList<>();
            lineas4.add(new LineaFactura(7, 10, productos.get(6), 4)); // Yogurt
            lineas4.add(new LineaFactura(8, 4, productos.get(0), 4)); // Leche
            facturas.add(new Factura(4, new Date(), lineas4, TipoDePagoDeFactura.CONTADO));

            // Factura 5
            List<LineaFactura> lineas5 = new ArrayList<>();
            lineas5.add(new LineaFactura(9, 1, productos.get(1), 5)); // Queso
            lineas5.add(new LineaFactura(10, 2, productos.get(2), 5)); // Pan
            lineas5.add(new LineaFactura(11, 6, productos.get(3), 5)); // Gaseosa
            facturas.add(new Factura(5, new Date(), lineas5, TipoDePagoDeFactura.DEBITO));

        } catch (Exception e) {
            // In a mock, we can print the stack trace for debugging
            e.printStackTrace();
        }
    }

    @Override
    public boolean crear(Factura entidad) throws SQLException, Exception {
        entidad.setId(facturas.size() + 1);
        return facturas.add(entidad);
    }

    @Override
    public boolean eliminar(Factura entidad) throws SQLException, Exception {
        return facturas.remove(entidad);
    }

    @Override
    public Factura extraer(int id) throws SQLException, Exception {
        for (Factura factura : facturas) {
            if (factura.getId() == id) {
                return factura;
            }
        }
        return null;
    }

    @Override
    public boolean modificar(Factura entidad) throws SQLException, Exception {
        int index = -1;
        for (int i = 0; i < facturas.size(); i++) {
            if (facturas.get(i).getId().equals(entidad.getId())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            facturas.set(index, entidad);
            return true;
        }
        return false;
    }

    @Override
    public List<Factura> listar() throws SQLException, Exception {
        return new ArrayList<>(facturas);
    }
}