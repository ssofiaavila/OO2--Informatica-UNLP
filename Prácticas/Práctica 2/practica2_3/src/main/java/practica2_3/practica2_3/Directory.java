package practica2_3.practica2_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Directory  extends Composite {
	private List<Composite> files;
	
	
	public Directory(String name) {
		super(name,32);
		files= new ArrayList<Composite>();		
	}
	
	public void addFile(Composite newest) {
		this.files.add(newest);
	}

	public File biggestFile() {
		File biggest= this.files.stream().map(comp -> comp.biggestFile()).filter(arch -> arch != null).max(Comparator.comparingLong(a -> a.getSize())).orElse(null);
		return biggest;
	}


	@Override
	public File newestFile() {
		File newest= this.files.stream()
			 	.map(fso -> fso.newestFile())
			 	.filter(archivo -> archivo != null)
			 	.max(Comparator.comparing(a -> a.getDate())) 
			 	.orElse(null); 
		return newest;
	}
	
	public int getSize() {
		return super.getSize()+ (this.files.stream().mapToInt(a -> a.getSize()).sum());
	}
	
	
}
