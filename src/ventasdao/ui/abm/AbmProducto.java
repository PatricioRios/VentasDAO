/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.abm;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import sun.net.util.ProxyUtil;
import org.postgresql.util.PSQLException;
import ventasdao.controladores.ICrud;
import ventasdao.controladores.ProductoControlador;
import ventasdao.objetos.Categoria;
import ventasdao.objetos.Producto;
import ventasdao.ui.grilla.GrillaProducto;

/**
 *
 * @author Administrador
 */
public class AbmProducto extends javax.swing.JInternalFrame {
    
    private ProductoControlador productoControlador;
    private ICrud<Categoria> categoriaControlador;
    private GrillaProducto grillaProducto;
    private DefaultComboBoxModel modelCombo;

    private Producto productSelected;
  
    public AbmProducto(ProductoControlador productoControlador, ICrud<Categoria> categoriaControlador) {
        this.productoControlador = productoControlador;
        this.categoriaControlador = categoriaControlador;
        initComponents();
        
        try {
            grillaProducto = new GrillaProducto((ArrayList<Producto>) this.productoControlador.listar());
            productoTable.setModel(grillaProducto);
        } catch (Exception ex) {
            Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al cargar los productos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            ArrayList<Categoria> categorias = (ArrayList<Categoria>) this.categoriaControlador.listar();
            
            modelCombo = new DefaultComboBoxModel(categorias.toArray());
            categoriaComboBox.setModel(modelCombo);
        } catch (Exception ex) {
            Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al cargar las categorias", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fechaCreacionDatePicker = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        descripcioTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        categoriaComboBox = new javax.swing.JComboBox<>();
        registrarProductoButton = new javax.swing.JButton();
        precioTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        productoTable = new javax.swing.JTable();
        actualizarProductoButton = new javax.swing.JButton();
        eliminarProductoButton = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setText("Nombre");

        jLabel2.setText("Descripcion");

        jLabel3.setText("Categoria");

        jLabel4.setText("Precio");

        jLabel5.setText("Fecha Creacion");

        categoriaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        categoriaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaComboBoxActionPerformed(evt);
            }
        });

        registrarProductoButton.setText("Registrar Producto");
        registrarProductoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarProductoButtonActionPerformed(evt);
            }
        });

        productoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        productoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productoTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productoTable);

        actualizarProductoButton.setText("Actualizar Producto");
        actualizarProductoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarProductoButtonActionPerformed(evt);
            }
        });

        eliminarProductoButton.setText("Eliminar Producto");
        eliminarProductoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProductoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addContainerGap(1010, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel5)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(registrarProductoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fechaCreacionDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(precioTextField)
                            .addComponent(categoriaComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(descripcioTextField)
                            .addComponent(actualizarProductoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(eliminarProductoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(nombreTextField)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(261, 261, 261))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descripcioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(2, 2, 2)
                        .addComponent(categoriaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaCreacionDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(registrarProductoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actualizarProductoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarProductoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(197, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarProductoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarProductoButtonActionPerformed
        // TODO add your handling code here:


        if(!validateFields()){
            return;
        }

        Producto producto = new Producto();
        producto.setDescripcion(descripcioTextField.getText());
        producto.setNombre(nombreTextField.getText());
        producto.setPrecio(Float.parseFloat(precioTextField.getText()));
        producto.setFechaCreacion(fechaCreacionDatePicker.getDate());
        producto.setCategoria((Categoria)categoriaComboBox.getSelectedItem());
        
        try {
            productoControlador.crear(producto);
            limpiarCampos();
            this.updateGrilla();
        } catch (Exception ex) {
            Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al registrar el producto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_registrarProductoButtonActionPerformed

    private void categoriaComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoriaComboBoxActionPerformed

    private void productoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productoTableMouseClicked
        int filaSeleccionada = productoTable.getSelectedRow();
        if (filaSeleccionada != -1) {
            Integer productoId = (Integer) grillaProducto.getValueAt(filaSeleccionada, 0);
            this.productSelected = grillaProducto.getProductByIndex(filaSeleccionada);

            this.updateProductDetails(productSelected);

        }
    }//GEN-LAST:event_productoTableMouseClicked

    private void actualizarProductoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarProductoButtonActionPerformed
        if (this.productSelected != null) {
            if(!validateFields()){
                return;
            }
            productSelected.setNombre(nombreTextField.getText());
            productSelected.setDescripcion(descripcioTextField.getText());
            productSelected.setPrecio(Float.parseFloat(precioTextField.getText()));
            productSelected.setFechaCreacion(fechaCreacionDatePicker.getDate());
            productSelected.setCategoria((Categoria) categoriaComboBox.getSelectedItem());

            try {
                productoControlador.modificar(productSelected);
                this.limpiarCampos();
                this.updateGrilla();
            } catch (Exception ex) {
                Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error al actualizar el producto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un producto de la grilla", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_actualizarProductoButtonActionPerformed

    private void eliminarProductoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProductoButtonActionPerformed
        if (productSelected != null) {
            int response = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres eliminar este producto?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                try {
                    productoControlador.eliminar(productSelected);
                    limpiarCampos();
                    updateGrilla();
                } catch (Exception ex) {
                    if (ex instanceof PSQLException && ((PSQLException) ex).getSQLState().equals("23503")) {
                        JOptionPane.showMessageDialog(this, "No se puede eliminar el producto porque está siendo utilizado en una o más facturas.", "Error de eliminación", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, "Error al eliminar el producto", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_eliminarProductoButtonActionPerformed

    //retorna falso si hay erores
    private boolean validateFields() {
        if (nombreTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (precioTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El precio no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Float.parseFloat(precioTextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un numero valido", "Error", JOptionPane.ERROR_MESSAGE);

            return false;
        }
        if (fechaCreacionDatePicker.getDate() == null) {
            JOptionPane.showMessageDialog(this, "La fecha de creacion no puede estar vacia", "Error", JOptionPane.ERROR_MESSAGE);

            return false;
        }
        return true;
    }

    private void updateGrilla(){
        try {
            grillaProducto.setProductos((ArrayList<Producto>) this.productoControlador.listar());
            grillaProducto.fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al actualizar la grilla", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateProductDetails(Producto productSelected) {
        nombreTextField.setText(productSelected.getNombre());
        descripcioTextField.setText(productSelected.getDescripcion());
        precioTextField.setText(String.valueOf(productSelected.getPrecio()));
        fechaCreacionDatePicker.setDate(productSelected.getFechaCreacion());
        categoriaComboBox.setSelectedItem(productSelected.getCategoria());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarProductoButton;
    private javax.swing.JComboBox<String> categoriaComboBox;
    private javax.swing.JTextField descripcioTextField;
    private javax.swing.JButton eliminarProductoButton;
    private com.toedter.calendar.JDateChooser fechaCreacionDatePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JTextField precioTextField;
    private javax.swing.JTable productoTable;
    private javax.swing.JButton registrarProductoButton;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
       descripcioTextField.setText("");
       nombreTextField.setText("");
       precioTextField.setText("");
    }
}
