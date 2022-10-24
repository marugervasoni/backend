package PlantacionDeArboles;

import java.util.*;

public class Bosque {

    private Integer cantArbolesOrnamentales;
    private Integer cantAarbolesFrutales;
    private Integer cantAarbolesFlorales;
    private Integer cantArbolesTotales;

    private List <Arbol> listaDeArboles = new ArrayList<Arbol>();

    public Bosque() {
        this.cantArbolesOrnamentales = 0;
        this.cantAarbolesFrutales = 0;
        this.cantAarbolesFlorales = 0;
    }

    public void plantarArbol(Arbol arbol){
        listaDeArboles.add(arbol);
    }

    public void mostrarArbolesPlantados(){

        for (Arbol arbol: listaDeArboles){
            switch (arbol.getColor()){
                case "verde": this.cantArbolesOrnamentales +=1;
                break;
                case "rojo": this.cantAarbolesFrutales +=1;
                break;
                default: this.cantAarbolesFlorales +=1;
            }
        }


        System.out.println("Arboles Ornamentales: " + cantArbolesOrnamentales);
        System.out.println("Arboles florales: " + cantAarbolesFlorales);
        System.out.println("Arboles frutales: " + cantAarbolesFrutales);
    }
}
