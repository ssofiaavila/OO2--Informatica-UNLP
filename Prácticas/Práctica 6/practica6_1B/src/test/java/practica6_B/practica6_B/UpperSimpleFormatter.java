package practica6_B.practica6_B;
import java.util.logging.*;
public class UpperSimpleFormatter extends SimpleFormatter{

	
	@Override
	public String format(LogRecord record) {
		return super.format(record).toUpperCase();
	}
}
