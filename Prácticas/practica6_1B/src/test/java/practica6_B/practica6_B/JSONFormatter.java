package practica6_B.practica6_B;
import java.util.logging.*;
import org.json.*;
public class JSONFormatter extends Formatter{

	@Override
	public String format(LogRecord record) {
		// TODO Auto-generated method stub
		JSONObject obj= new JSONObject();
		obj.put("message: ",record.getMessage());
		obj.put("level:", record.getLevel());
		return obj.toJSONString();
	}
	
}
