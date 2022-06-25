package practica2_3.practica2_3;

public class File extends Composite {

	public File(String name, int size) {
		super(name, size);
		
	}

	@Override
	public File biggestFile() {
		return this;
	}

	@Override
	public File newestFile() {
		return this;
	}

}
