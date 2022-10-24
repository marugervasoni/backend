package digital.house.flyweight.dto;

//2) objeto comida
public class ComidaDTO {

	//atributos
	private String tipoComida;
	private int precio;
	private boolean tieneLechuga;

	//constructor de lo que no vamos a cambiar
	public ComidaDTO(String tipoComida) {
		super();
		this.tipoComida = tipoComida;
	}

	public ComidaDTO() {
		super();
	}

	//getters y setters de lo que vamos a cambiar en tiempo compartido
	public String getTipoComida() {
		return tipoComida;
	}

	public void setTipoComida(String tipoComida) {
		this.tipoComida = tipoComida;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public boolean isTieneLechuga() {
		return tieneLechuga;
	}

	public void setTieneLechuga(boolean tieneLechuga) {
		this.tieneLechuga = tieneLechuga;
	}

	public void descripcionDeLaComida() {
		System.out.println("Es un/una " + getTipoComida() + " que sale: " + getPrecio());
	}

	//metodo
	@Override
	public String toString() {
		return "ComidaDTO [tipoComida=" + tipoComida + ", precio=" + precio + ", tieneLechuga=" + tieneLechuga + "]";
	}
}
