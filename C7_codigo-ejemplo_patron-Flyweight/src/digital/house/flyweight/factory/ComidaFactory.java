package digital.house.flyweight.factory;

import java.util.HashMap;
import java.util.Objects;

import digital.house.flyweight.dto.ComidaDTO;

//1) codigo de la clasee que define el metodo antes de crear el objeto
public class ComidaFactory {

	private static final HashMap<String, ComidaDTO> COMIDA_MAP = new HashMap<>();

	public ComidaDTO getComida(final String tipoComida) {
		ComidaDTO comida = COMIDA_MAP.get(tipoComida);
		//valida si existe un objeto identico al solicitado:
			//si no existe: crea el nuevo objeto y lo almacena en cache para reutil.
		if (Objects.isNull(comida)) {
			comida = new ComidaDTO(tipoComida);
			COMIDA_MAP.put(tipoComida, comida);
			System.out.println("Creando Objecto de comida tipo: " + tipoComida);
			return comida;

		}
			//si existe lo retorna
		System.out.println("Recuperando Objecto de comida tipo: " + tipoComida);
		return comida;

	}
}
