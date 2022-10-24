package PlantacionDeArboles;

public class Arbol {

    private Integer alto;
    private Integer horizontal;
    private String color;
    private String tipoArbol;

    public Arbol(String tipoArbol) {
       this.tipoArbol = tipoArbol;
    }



    public void setAlto(Integer alto) {
        this.alto = alto;
    }


    public void setHorizontal(Integer horizontal) {
        this.horizontal = horizontal;
    }

    public String getColor() {
        return color;
    }

    public String getTipoArbol() {
        return tipoArbol;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
