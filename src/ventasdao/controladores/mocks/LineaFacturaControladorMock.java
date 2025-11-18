
package ventasdao.controladores.mocks;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ventasdao.controladores.ICrud;
import ventasdao.objetos.Factura;
import ventasdao.objetos.LineaFactura;

public class LineaFacturaControladorMock implements ICrud<LineaFactura> {

    private final FacturaControladorMock facturaControladorMock;

    public LineaFacturaControladorMock() {
        this.facturaControladorMock = new FacturaControladorMock();
    }

    @Override
    public boolean crear(LineaFactura entidad) throws SQLException, Exception {
        Factura factura = facturaControladorMock.extraer(entidad.getFacturaId());
        if (factura != null) {
            List<LineaFactura> lineas = factura.getLineaFactura();
            entidad.setId(lineas.size() + 1); // Simple ID generation
            return lineas.add(entidad);
        }
        return false;
    }

    @Override
    public boolean eliminar(LineaFactura entidad) throws SQLException, Exception {
        Factura factura = facturaControladorMock.extraer(entidad.getFacturaId());
        if (factura != null) {
            return factura.getLineaFactura().removeIf(linea -> linea.getId().equals(entidad.getId()));
        }
        return false;
    }

    @Override
    public LineaFactura extraer(int id) throws SQLException, Exception {
        for (Factura factura : facturaControladorMock.listar()) {
            for (LineaFactura lineaFactura : factura.getLineaFactura()) {
                if (lineaFactura.getId() == id) {
                    return lineaFactura;
                }
            }
        }
        return null;
    }

    @Override
    public boolean modificar(LineaFactura entidad) throws SQLException, Exception {
        Factura factura = facturaControladorMock.extraer(entidad.getFacturaId());
        if (factura != null) {
            for (int i = 0; i < factura.getLineaFactura().size(); i++) {
                if (factura.getLineaFactura().get(i).getId().equals(entidad.getId())) {
                    factura.getLineaFactura().set(i, entidad);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<LineaFactura> listar() throws SQLException, Exception {
        List<LineaFactura> todasLasLineas = new ArrayList<>();
        for (Factura factura : facturaControladorMock.listar()) {
            todasLasLineas.addAll(factura.getLineaFactura());
        }
        return todasLasLineas;
    }

    public List<LineaFactura> listarPorFacturaId(int facturaId) throws SQLException, Exception {
        Factura factura = facturaControladorMock.extraer(facturaId);
        if (factura != null) {
            return factura.getLineaFactura();
        }
        return new ArrayList<>();
    }
}
