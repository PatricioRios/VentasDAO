/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.grilla;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.Cliente;

/**
 *
 * @author Hugo Chanampe
 */
public class GrillaCliente extends AbstractTableModel{
    
    private List<Cliente> clientes = new ArrayList<>();
    
    
    
    public GrillaCliente(List<Cliente> datos) {
        this.clientes = datos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public int getRowCount() {
        return clientes.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
         return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        switch(columnIndex){
              case 0: return cliente.getId();
              case 1: return cliente.getNombre();
              case 2: return cliente.getCuil();
              case 3: return cliente.getApellido();
              case 4: return cliente.getFechaNacimiento();
              default: return "";
          }
        
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "NOMBRE";
            case 2: return "CUIL";
            case 3: return "Razon Social";
            case 4: return "Fecha Nacimiento";
            default: return "";
        
        
        } //To change body of generated methods, choose Tools | Templates.
    }

    public Cliente getClienteAt(int rowIndex){
        return clientes.get(rowIndex);
    }
    
}
