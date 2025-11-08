package ventasdao.objetos;

public class LineaFactura {
    
    private Integer id;
    
    private Double cantidad;
    private Integer facturaId;
    
    private Producto producto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public LineaFactura(Integer id, Double cantidad, Producto producto, Integer facturaId) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
        this.facturaId = facturaId;
    }

    public Integer getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Integer facturaId) {
        this.facturaId = facturaId;
    }
    
}
