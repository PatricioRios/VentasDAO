
package ventasdao.controladores.mocks;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ventasdao.controladores.ICrud;
import ventasdao.objetos.Cliente;
import ventasdao.objetos.TipoCliente;

public class ClienteControladorMock implements ICrud<Cliente> {

    private final List<Cliente> clientes = new ArrayList<>();
    private final TipoClienteControladorMock tipoClienteControladorMock;

    public ClienteControladorMock() throws Exception {
        this.tipoClienteControladorMock = new TipoClienteControladorMock();
        List<TipoCliente> tiposCliente = tipoClienteControladorMock.listar();

        Cliente c1 = new Cliente();
        c1.setId(1);
        c1.setNombre("Juan");
        c1.setApellido("Perez");
        c1.setDocumento("12345678");
        c1.setCuil("20-12345678-5");
        c1.setFechaNacimiento(new Date());
        c1.setTipoCliente(tiposCliente.get(0));
        clientes.add(c1);

        Cliente c2 = new Cliente();
        c2.setId(2);
        c2.setNombre("Maria");
        c2.setApellido("Gomez");
        c2.setDocumento("87654321");
        c2.setCuil("27-87654321-5");
        c2.setFechaNacimiento(new Date());
        c2.setTipoCliente(tiposCliente.get(1));
        clientes.add(c2);

        Cliente c3 = new Cliente();
        c3.setId(3);
        c3.setNombre("Carlos");
        c3.setApellido("Rodriguez");
        c3.setDocumento("11223344");
        c3.setCuil("20-11223344-5");
        c3.setFechaNacimiento(new Date());
        c3.setTipoCliente(tiposCliente.get(2));
        clientes.add(c3);

        Cliente c4 = new Cliente();
        c4.setId(4);
        c4.setNombre("Ana");
        c4.setApellido("Lopez");
        c4.setDocumento("44332211");
        c4.setCuil("27-44332211-5");
        c4.setFechaNacimiento(new Date());
        c4.setTipoCliente(tiposCliente.get(3));
        clientes.add(c4);

        Cliente c5 = new Cliente();
        c5.setId(5);
        c5.setNombre("Luis");
        c5.setApellido("Martinez");
        c5.setDocumento("55667788");
        c5.setCuil("20-55667788-5");
        c5.setFechaNacimiento(new Date());
        c5.setTipoCliente(tiposCliente.get(4));
        clientes.add(c5);
    }

    @Override
    public boolean crear(Cliente entidad) throws SQLException, Exception {
        entidad.setId(clientes.size() + 1);
        return clientes.add(entidad);
    }

    @Override
    public boolean eliminar(Cliente entidad) throws SQLException, Exception {
        return clientes.remove(entidad);
    }

    @Override
    public Cliente extraer(int id) throws SQLException, Exception {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public boolean modificar(Cliente entidad) throws SQLException, Exception {
        int index = -1;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equals(entidad.getId())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            clientes.set(index, entidad);
            return true;
        }
        return false;
    }

    @Override
    public List<Cliente> listar() throws SQLException, Exception {
        return new ArrayList<>(clientes);
    }
}
