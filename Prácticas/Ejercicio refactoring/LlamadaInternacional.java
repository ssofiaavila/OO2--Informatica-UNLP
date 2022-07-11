public class LlamadaInternacional extends Llamada{


  public LlamadaInternacional(String s, String p, String p2,int dur){
    super();
  }


  public double calcularCosto(){
    int duracion= this.getDuracion();
    int costo= duracion*200 + (duracion*200*0.21);
    return costo;
  }

}
