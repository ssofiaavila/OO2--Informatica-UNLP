package practica2AOO2.practica2AOO2;

public class Pantano extends Topografia {
	@Override
	public double getProportion() {
		return 0.7;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (other == null)
        {
            return false;
        }
	  
		if (other == this)
		{
			return true;
		}
	  
	 
 	  if (other instanceof Topografia == false) {
		  return false;
	  }
 	  
 	  Topografia t = (Topografia)other;
 	  if (this.getProportion() != t.getProportion()) {
 		  return false;
 	  }
 	  
 	  return true;
	}
}
