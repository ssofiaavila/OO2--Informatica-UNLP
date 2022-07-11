public AdvancedClient implements ClientType{

  public double getDiferencialEnvio(){
    return 0;
  }

  pubic ClientType setState(double monto){
    if (monto > 5000){
      return new PremiumClient();
    }

  }



}
