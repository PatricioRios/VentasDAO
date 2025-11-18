
package ventasdao.controladores.mocks;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ventasdao.controladores.ICrud;
import ventasdao.objetos.Categoria;
import ventasdao.objetos.Producto;

public class ProductoControladorMock implements ICrud<Producto> {

    private final List<Producto> productos = new ArrayList<>();
    private final CategoriaControladorMock categoriaControladorMock;

    public ProductoControladorMock() throws Exception {
        this.categoriaControladorMock = new CategoriaControladorMock();
        List<Categoria> categorias = categoriaControladorMock.listar();

        Producto p1 = new Producto();
        p1.setId(1);
        p1.setNombre("Leche");
        p1.setDescripcion("Leche entera");
        p1.setPrecio(100.0f);
        p1.setCategoria(categorias.get(0));
        p1.setFechaCreacion(new Date());
        productos.add(p1);

        Producto p2 = new Producto();
        p2.setId(2);
        p2.setNombre("Queso");
        p2.setDescripcion("Queso cremoso");
        p2.setPrecio(200.0f);
        p2.setCategoria(categorias.get(0));
        p2.setFechaCreacion(new Date());
        productos.add(p2);
        
        Producto p3 = new Producto();
        p3.setId(3);
        p3.setNombre("Pan");
        p3.setDescripcion("Pan felipe");
        p3.setPrecio(50.0f);
        p3.setCategoria(categorias.get(1));
        p3.setFechaCreacion(new Date());
        productos.add(p3);

        Producto p4 = new Producto();
        p4.setId(4);
        p4.setNombre("Gaseosa");
        p4.setDescripcion("Bebida gaseosa sabor cola");
        p4.setPrecio(120.0f);
        p4.setCategoria(categorias.get(2));
        p4.setFechaCreacion(new Date());
        productos.add(p4);

        Producto p5 = new Producto();
        p5.setId(5);
        p5.setNombre("Lavandina");
        p5.setDescripcion("Lavandina concentrada");
        p5.setPrecio(80.0f);
        p5.setCategoria(categorias.get(3));
        p5.setFechaCreacion(new Date());
        productos.add(p5);

        Producto p6 = new Producto();
        p6.setId(6);
        p6.setNombre("Asado");
        p6.setDescripcion("Corte de carne para asado");
        p6.setPrecio(500.0f);
        p6.setCategoria(categorias.get(4));
        p6.setFechaCreacion(new Date());
        productos.add(p6);

        Producto p7 = new Producto();
        p7.setId(7);
        p7.setNombre("Yogurt");
        p7.setDescripcion("Yogurt de frutilla");
        p7.setPrecio(90.0f);
        p7.setCategoria(categorias.get(0));
        p7.setFechaCreacion(new Date());
        productos.add(p7);
    }

    @Override
    public boolean crear(Producto entidad) throws SQLException, Exception {
        entidad.setId(productos.size() + 1);
        return productos.add(entidad);
    }

    @Override
    public boolean eliminar(Producto entidad) throws SQLException, Exception {
        return productos.remove(entidad);
    }

    @Override
    public Producto extraer(int id) throws SQLException, Exception {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    @Override
    public boolean modificar(Producto entidad) throws SQLException, Exception {
        int index = -1;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId().equals(entidad.getId())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            productos.set(index, entidad);
            return true;
        }
        return false;
    }

    @Override
    public List<Producto> listar() throws SQLException, Exception {
        return new ArrayList<>(productos);
    }

    public List<Producto> listarPorCategoria(Categoria categoria) throws SQLException, Exception {
        List<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getCategoria().getId().equals(categoria.getId())) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }

    public List<Producto> nameStartsWith(String prefix) throws SQLException, Exception {
        List<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : productos) {
            System.out.println("Checking product: " + producto.getNombre() + " against prefix: " + prefix);
            if (producto.getNombre().toLowerCase().startsWith(prefix.toLowerCase())) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }

    public List<Producto> filterByNameAndCategory(String prefix, Categoria categoria) throws SQLException, Exception {
        List<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : productos) {
            boolean nameMatches = producto.getNombre().toLowerCase().startsWith(prefix.toLowerCase());
            boolean categoryMatches = (categoria == null) || (producto.getCategoria() != null && producto.getCategoria().getId().equals(categoria.getId()));

            if (nameMatches && categoryMatches) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }
}
