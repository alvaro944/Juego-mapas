import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private Map<Integer, Ubicacion> ubicaciones;

    public Main() {
        ubicaciones = new HashMap<>();

        ubicaciones.put(0,new Ubicacion(0, "\n\t[+] Estás sentado en la clase de programación"));
        ubicaciones.put(1, new Ubicacion(1, "\n\t[+] Estás en la cima de una montaña"));
        ubicaciones.put(2, new Ubicacion(2, "\n\t[+] Estás bañándote en la playa"));
        ubicaciones.put(3, new Ubicacion(3, "\n\t[+] Estás dentro de un edificio muy alto"));
        ubicaciones.put(4, new Ubicacion(4, "\n\t[+] Estás de pie en un puente"));
        ubicaciones.put(5, new Ubicacion(5, "\n\t[+] Estás en un bosque"));

        //Ubicacion 1 - Montaña
        ubicaciones.get(1).addExit("N", 5); // Norte hacia el bosque
        ubicaciones.get(1).addExit("S", 4); // Sur hacia la playa
        ubicaciones.get(1).addExit("E", 3); // Este hacia el edificio
        ubicaciones.get(1).addExit("O", 2); // Oeste hacia la playa

        //Ubicacion 2 - Playa
        ubicaciones.get(2).addExit("N", 5); // Norte hacia el bosque
        ubicaciones.get(2).addExit("S", 4); // Sur hacia el puente
        ubicaciones.get(2).addExit("E", 1); // Este hacia la montaña

        //Ubicacion 3 - Edificio
        ubicaciones.get(3).addExit("O", 1); // Oeste hacia la montaña

        //Ubicacion 4 - Puente
        ubicaciones.get(4).addExit("N", 1); // Norte hacia la montaña
        ubicaciones.get(4).addExit("O", 2); // Oeste hacia la playa

        //Ubicacion 5 - Bosque
        ubicaciones.get(5).addExit("S", 1); // Sur hacia la montaña
        ubicaciones.get(5).addExit("O", 2); // Oeste hacia la playa
    }


    public static void main(String[] args) {
        Main juego = new Main();
        Scanner sc = new Scanner(System.in);
        int ubiActual = 1;

        while(true){
            //Creamos la primera ubicación
            Ubicacion ubicacion = juego.ubicaciones.get(ubiActual);
            // Mostramos la descripción de donde estamos
            System.out.println(ubicacion.getDescripcion());


            // Mostramos las opciones
            System.out.print("\n[*] Tus salidas válidas son ");
            for(String salidas : ubicacion.getExits().keySet()){
                System.out.print(salidas + ", ");
            }
            System.out.print("Q"); // Añadir siempre la opción de salir
            System.out.print("\n[+] Introduce la salida a la que dirigirte: ");
            String direccion = sc.nextLine().toUpperCase();

            //Manejar la opción Q salir del juego
            if(direccion.equals("Q")){
                System.out.println("\n[!] Juego terminado. ¡Hasta pronto!");
                break;
            }

            //Manejar resto de ubicaciones y si es válida
            if(ubicacion.getExits().containsKey(direccion)){
                ubiActual = ubicacion.getExits().get(direccion); // cambiamos a la nueva dirección
            } else{
                System.out.println("\n[!]No se puede ir en esa dirección");
            }
        }
        sc.close();
    }
}
