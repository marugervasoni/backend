package PlantacionDeArboles;



public class Test {
    public static void main(String[] args) {
        Arbol arbolOrnamental = ArbolFactory.generarTipoArbol("ornamental");
        Arbol arbolFrutal = ArbolFactory.generarTipoArbol("frutal");

        Bosque bosque1 = new Bosque();

        for (int i = 0; i < 250000; i++) {
            bosque1.plantarArbol(arbolOrnamental);
        }

        for (int i = 0; i < 250000; i++) {
            bosque1.plantarArbol(arbolFrutal);
        }

        bosque1.mostrarArbolesPlantados();

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));


    }
}