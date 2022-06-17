package practica1BOO2.practica1BOO2;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class JacksonExporterAdapter extends VoorheesExporter {

	private String exportar(Socio socio) {
		JSONObject obj = new JSONObject();
		obj.put("nombre", socio.getNombre());
		obj.put("email", socio.getEmail());
		obj.put("legajo", socio.getLegajo());		
		return obj.toJSONString();
	}

	public String exportar(List<Socio> socios) {
		if (socios.isEmpty()) {
			return "[]";
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			return mapper.writeValueAsString(socios);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "[]";
		}		
		// return list.toJSONString().replaceAll("\\\\","");
	}
}
