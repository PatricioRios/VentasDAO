/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventasdao.ui.grilla;

import ventasdao.objetos.LineaFactura;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author patriciorios
 */
public class LineaGrilla extends AbstractTableModel {

    private List<LineaFactura> lineas;
    public static int COLUMNS = 6;

    public LineaGrilla(List<LineaFactura> lineas) {
        this.lineas = lineas;
    }

    @Override
    public int getRowCount() {
        return lineas.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Linea";
            case 1:
                return "ID Producto";
            case 2:
                return "Producto";
            case 3:
                return "Cantidad";
            case 4:
                return "Precio Unitario";
            case 5:
                return "Total";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LineaFactura lf = lineas.get(rowIndex);
        switch (columnIndex) {
            case 0://<-- LineaFactura ID
                return lf.getId();
            case 1://<-- Producto ID
                return lf.getProducto().getId();
            case 2://<-- Producto ID
                return lf.getProducto().getNombre();
            case 3://<-- Cantidad
                return lf.getCantidad();
            case 4://<-- Precio Unitario
                return lf.getProducto().getPrecio();
            case 5://<-- Total
                return (lf.getCantidad() * lf.getProducto().getPrecio());
            default:
                return "";
        }
    }

    public LineaFactura getLineaFacturaByIndex(Integer selectedRow) {
        return lineas.get(selectedRow);
    }
}
