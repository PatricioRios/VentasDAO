/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventasdao.ui.grilla;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.Factura;

/**
 *
 * @author patriciorios
 */
public class FacturaGrilla extends AbstractTableModel {
    
    private List<Factura> facturas;
    
    public static int COLUMNS = 3;


    public FacturaGrilla(List<Factura> facturas) {
        this.facturas = facturas;
    }

    @Override
    public int getRowCount() {
        return facturas.size();
    }

    @Override
    public int getColumnCount() {
        return this.COLUMNS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
           Factura c = facturas.get(rowIndex);
                
          switch(columnIndex){
              case 0: return c.getId();
              case 1: return c.getDate();
              case 2: return c.getTypeOfPayment();
              default: return "";
          }
    }

    @Override
    public String getColumnName(int column) {
        
        switch(column){
            case 0: return "ID";
            case 1: return "Fecha";
            case 2: return "Tipo de Pago";
            default: return "";
        }
    }
    public Factura getFacturaByIndex(Integer index){
        return this.facturas.get(index);
    }
    
}
