package ventasdao.ui.grilla;

import org.omg.CORBA.PUBLIC_MEMBER;
import ventasdao.objetos.Producto;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ProductoGrillaOnFacturaScreen extends AbstractTableModel {

    private List<Producto> productos;

    public static int COLUMNS = 3;

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Producto";
            case 1:
                return "Nombre";
            case 2:
                return "Precio";
            default:
                return "";
        }
    }


    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void getProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public ProductoGrillaOnFacturaScreen(List<Producto> productos) {
        this.productos = productos;
    }

    public ProductoGrillaOnFacturaScreen() {
        this.productos = new ArrayList<Producto>();
    }

    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto p = productos.get(rowIndex);
        switch (columnIndex) {
            case 0://<-- Producto ID
                return p.getId();
            case 1://<-- Producto Nombre
                return p.getNombre();
            case 2://<-- Producto Precio
                return p.getPrecio();
            default:
                return "";
        }
    }
    public Producto getProductoByIndex(int rowIndex) {
        return productos.get(rowIndex);
    }

    @Override
    public String toString() {
        return "ProductoGrillaOnFacturaScreen{" +
                "productos=" + productos +
                '}';
    }
}
