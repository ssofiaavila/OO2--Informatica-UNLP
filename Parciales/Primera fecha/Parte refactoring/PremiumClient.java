public class PremiumClient implement ClientType{
  public double getDiferencialEnvio(){
    return 0.05;
  }

  pubic ClientType setState(double monto){
    if (monto > 10000){
      return new AdvancedClient();
    }

  }
}
