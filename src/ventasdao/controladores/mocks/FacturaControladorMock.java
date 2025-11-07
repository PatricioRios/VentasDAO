
package ventasdao.controladores.mocks;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ventasdao.controladores.ICrud;
import ventasdao.objetos.Factura;
import ventasdao.objetos.LineaFactura;

public class FacturaControladorMock implements ICrud<Factura> {

    private List<Factura> facturas = new ArrayList<>();
    
    

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
