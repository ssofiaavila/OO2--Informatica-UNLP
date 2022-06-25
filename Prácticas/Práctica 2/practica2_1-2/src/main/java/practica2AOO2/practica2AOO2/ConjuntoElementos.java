package practica2AOO2.practica2AOO2;

import java.util.ArrayList;

public class ConjuntoElementos extends Topografia {
	ArrayList<Topografia> components = new ArrayList<Topografia>();
	
	public ConjuntoElementos(Topografia primer, Topografia segundo, Topografia tercer,
			Topografia cuarto){
		this.addElementos(primer, segundo, tercer, cuarto);
	}
	
	@Override
	public void addElementos(Topografia primer, Topografia segundo, Topografia tercer,
			Topografia cuarto) {
		if (components.isEmpty() == false)
			components.clear();
		components.add(0, primer);
		components.add(1, segundo);
		components.add(2, tercer);
		components.add(3, cuarto);
	}
	
	@Override
	public void clearElementos() {
		components.clear();
	}

	@Override
	public double getProportion() {
		float result = 0;
		for(Topografia component : components) {
			result += component.getProportion();
		}
		return result / 4;
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
 	  
		if (other instanceof ConjuntoElementos) {
			int index = 0;
			Boolean eq = true;
			
			ConjuntoElementos c = (ConjuntoElementos)t;
			for (Topografia component : components) {
				eq = eq && component.equals(c.getElemento(index));
				index++;
			}
			
			return eq;
		}
 	  
		return true;
	}

	@Override
	public Topografia getElemento(int index) {
		return components.get(index);
	}
}
