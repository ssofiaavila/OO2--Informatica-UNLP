public class PersoonaFisica extends Persoona{
  private String doc;

  public PersoonaFisica(String nombre,String data,String nro,String tipo,Persoonal empresa){
    super(nombre,nro, tipo,empresa);
    this.doc=data;
  }

  public double calcularMontoTotalLlamadas(){
      double costo= super.getlamadas.stream.mapToDouble(llamada -> llamada.calcularCosto()).sum(); //implementar
      costo -= costo*0;
      return costo;
  }


}
