package PlantacionDeArboles;

import com.company.listaCanciones.Cancion;

import java.util.HashMap;

public class ArbolFactory {
    private static final HashMap<String, Arbol> cancionMap = new HashMap<>();



    public static Arbol generarTipoArbol(String tipoArbol){
        Arbol arbol = cancionMap.get(tipoArbol);
        if(arbol == null){
            arbol = new Arbol(tipoArbol);
            if (arbol.getTipoArbol().equals("ornamental")){
                arbol.setAlto(200);
                arbol.setHorizontal(400);
                arbol.setColor("verde");
                System.out.println("Se crea 1 Arbol Ornamental");
            }else if(arbol.getTipoArbol().equals("ornamental")){
                arbol.setAlto(500);
                arbol.setHorizontal(300);
                arbol.setColor("rojo");
                System.out.println("Se crea 1 Arbol Frutal");
            }else{
                arbol.setAlto(100);
                arbol.setHorizontal(200);
                arbol.setColor("celeste");
                System.out.println("Se crea 1 Arbol Floral");
            }
        }
        return arbol;
    }



}