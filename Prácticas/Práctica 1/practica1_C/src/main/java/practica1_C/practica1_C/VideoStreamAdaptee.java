package practica1_C.practica1_C;

public class VideoStreamAdaptee implements Media{
	private VideoStream adaptee;

	@Override
	public void play() {
		this.adaptee.reproduce();
		
	}
	
	
	
}
