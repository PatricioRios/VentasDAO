
package ventasdao.controladores.mocks;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ventasdao.controladores.ICrud;
import ventasdao.objetos.Categoria;

public class CategoriaControladorMock implements ICrud<Categoria> {

    private final List<Categoria> categorias = new ArrayList<>();

    public CategoriaControladorMock() {
        Categoria cat1 = new Categoria();
        cat1.setId(1);
        cat1.setDenominacion("Lacteos");
        cat1.setDescripcion("Productos derivados de la leche");
        categorias.add(cat1);

        Categoria cat2 = new Categoria();
        cat2.setId(2);
        cat2.setDenominacion("Panificados");
        cat2.setDescripcion("Productos de panaderia");
        categorias.add(cat2);

        Categoria cat3 = new Categoria();
        cat3.setId(3);
        cat3.setDenominacion("Bebidas");
        cat3.setDescripcion("Bebidas con y sin alcohol");
        categorias.add(cat3);

        Categoria cat4 = new Categoria();
        cat4.setId(4);
        cat4.setDenominacion("Limpieza");
        cat4.setDescripcion("Articulos de limpieza");
        categorias.add(cat4);

        Categoria cat5 = new Categoria();
        cat5.setId(5);
        cat5.setDenominacion("Carnes");
        cat5.setDescripcion("Carnes rojas y blancas");
        categorias.add(cat5);
    }

    @Override
    public boolean crear(Categoria entidad) throws SQLException, Exception {
        entidad.setId(categorias.size() + 1);
        return categorias.add(entidad);
    }

    @Override
    public boolean eliminar(Categoria entidad) throws SQLException, Exception {
        return categorias.remove(entidad);
    }

    @Override
    public Categoria extraer(int id) throws SQLException, Exception {
        for (Categoria categoria : categorias) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }

    @Override
    public boolean modificar(Categoria entidad) throws SQLException, Exception {
        int index = -1;
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).getId().equals(entidad.getId())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            categorias.set(index, entidad);
            return true;
        }
        return false;
    }

    @Override
    public List<Categoria> listar() throws SQLException, Exception {
        return new ArrayList<>(categorias);
    }
}
