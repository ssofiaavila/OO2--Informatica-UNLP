public class Cliente{
  private String nombre;
  private ClientType tipo;
  private List<Compra>compras;

  public Cliente(String unNombre){
    this.nombre=unNombre;
    this.tipo="basico";
    this.compras= new ArrayList<Compra>();
  }

  public Compra comprar(List<Producto> productos){
    new Compra n= new Compra(productos, this.tipo.getDiferencial());
    this.compras.add(n);
    tipo= this.tipo.setState(this.montoAcumuladoEnCompras());
    return n;
  }
// REFACTORIZADO



    if (this.montoAcumuladoEnCompras() > 10000){
      this.tipo= "advance";
    }
    else if(this.montoAcumuladoEnCompras() > 5000){
      this.tipo= "premium";
    }
    return n;
  }

  public double montoAcumuladoEnCompras(){

  }


}
