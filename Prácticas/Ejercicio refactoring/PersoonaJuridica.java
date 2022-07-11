public class PersoonaJuridica extends Persoona{
  private String cuit;


  public PersoonaJuridica(String nombre,String data,String nro,String tipo,Persoonal empresa){
    super(nombre,nro, tipo,empresa);
    this.cuit=data;
  }

  public double calcularMontoTotalLlamadas(){
      double costo= super.getlamadas.stream.mapToDouble(llamada -> llamada.calcularCosto()).sum(); //implementar
      costo -= costo*0.15;
      return costo;
  }
}
