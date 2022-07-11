public class LlamadaNacional extends Llamada{


  public LlamadaNacional(String s, String p, String p2,int dur){
    super();
  }

  public double calcularCosto(){
    int duracion= this.getDuracion();
    double costo= (duracion*3) + (duracion*3*0.21);
    return costo;
  }

}
