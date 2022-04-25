package practica1BOO2.practica1BOO2;

import java.util.List;

public class VoorheesExporter {

	//representación para socio
	private String exportar(Socio socio) {
		String separator = System.lineSeparator(); // es un separador para en vez de usar \n
		return "\t{" + separator 
			+ "\t\t\"nombre\": \"" + socio.getNombre() + "\"," + separator
			+ "\t\t\"email\": \"" + socio.getEmail() + "\"," + separator
			+ "\t\t\"legajo\": \"" + socio.getLegajo() + "\"" + separator
			+ "\t}";
	}

	//represento y obtengo representacion JSON de lista de socios
	
	public String exportar(List<Socio> socios) {
		if (socios.isEmpty()) {
			return "[]";
		}
		String separator = System.lineSeparator(); 
		StringBuilder buffer = new StringBuilder("[" + separator); //los stringBuilder crean clases de string que pueden ser modificadas sin necesidad de crear objetos nuevos
		socios.forEach(socio -> {
			buffer.append(this.exportar(socio))
				.append(",") 							///// ?
				.append(separator);
		});
		// remueve la última coma y fin de línea
		buffer.setLength(buffer.length() - (separator.length() + 1));
		buffer.append(separator).append("]");
		return buffer.toString(); // retorna el string de la representacion del JSON
	}
}
