package ventasdao.ui.grilla;

import ventasdao.objetos.TipoCliente;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TipoClienteGrilla extends AbstractTableModel {

    private List<TipoCliente> tiposDeClientes;
    public static int COLUMNS = 3;

    public TipoClienteGrilla(List<TipoCliente> tiposDeClientes) {
        this.tiposDeClientes = tiposDeClientes;
    }

    @Override
    public int getRowCount() {
        return this.tiposDeClientes.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nombre";
            case 2:
                return "Descripcion";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TipoCliente tc = tiposDeClientes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tc.getId();
            case 1:
                return tc.getNombre();
            case 2:
                return tc.getDescripcion();
            default:
                return "";
        }
    }

    public TipoCliente getTipoClienteAt(int rowIndex) {
        return tiposDeClientes.get(rowIndex);
    }
}
