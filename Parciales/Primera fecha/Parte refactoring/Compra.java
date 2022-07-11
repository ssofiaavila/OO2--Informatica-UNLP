public class Compra{
  private List<Producto> productos;
  private double subtotal;
  private double envio;
  private String estado;

public Compra(List<Producto> productos, double diferencial){
  this.productos=productos;
  this.subtotal= productos.stream().mapToDouble(p -> p.getPrecio().sum());
  this.envio= diferencial * subtotal;
}



}
