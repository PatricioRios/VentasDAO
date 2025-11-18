
package ventasdao.controladores.mocks;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ventasdao.controladores.ICrud;
import ventasdao.objetos.TipoCliente;

public class TipoClienteControladorMock implements ICrud<TipoCliente> {

    private final List<TipoCliente> tiposCliente = new ArrayList<>();

    public TipoClienteControladorMock() {
        tiposCliente.add(new TipoCliente(1, "Consumidor Final", "Cliente que compra para consumo propio"));
        tiposCliente.add(new TipoCliente(2, "Responsable Inscripto", "Cliente con CUIT"));
        tiposCliente.add(new TipoCliente(3, "Monotributista", "Cliente bajo régimen de Monotributo"));
        tiposCliente.add(new TipoCliente(4, "Exento", "Cliente exento de IVA"));
        tiposCliente.add(new TipoCliente(5, "No Responsable", "Cliente no responsable de IVA"));
    }

    @Override
    public boolean crear(TipoCliente entidad) throws SQLException, Exception {
        entidad.setId(tiposCliente.size() + 1);
        return tiposCliente.add(entidad);
    }

    @Override
    public boolean eliminar(TipoCliente entidad) throws SQLException, Exception {
        return tiposCliente.remove(entidad);
    }

    @Override
    public TipoCliente extraer(int id) throws SQLException, Exception {
        for (TipoCliente tipoCliente : tiposCliente) {
            if (tipoCliente.getId() == id) {
                return tipoCliente;
            }
        }
        return null;
    }

    @Override
    public boolean modificar(TipoCliente entidad) throws SQLException, Exception {
        int index = -1;
        for (int i = 0; i < tiposCliente.size(); i++) {
            if (tiposCliente.get(i).getId().equals(entidad.getId())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            tiposCliente.set(index, entidad);
            return true;
        }
        return false;
    }

    @Override
    public List<TipoCliente> listar() throws SQLException, Exception {
        return new ArrayList<>(tiposCliente);
    }
}
