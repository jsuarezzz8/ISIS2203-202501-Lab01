import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static int[][] matriz;

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la ruta del archivo: ");
        String ruta = sc.nextLine();
        sc.close();

        int cajeros = 0;
        int clientes = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea = br.readLine();
            String datos[] = linea.split(";");
            cajeros = Integer.parseInt(datos[0]);
            clientes = Integer.parseInt(datos[1]);
            matriz = new int[cajeros][clientes];
            String linea1 = br.readLine();
            while (linea1 != null) {
                String datos1[] = linea1.split(";");
                for (int i = Integer.parseInt(datos1[0]) - 1 ; i < Integer.parseInt(datos1[0]); i++) {
                    for (int j = 0; j < datos1.length - 1; j++) {
                        matriz[i][j] = Integer.parseInt(datos1[j+1]);
                    }
                }
                linea1 = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }

        for(int i = 1; i < cajeros+1; i++){
            Cajero cajero = new Cajero(i, matriz[i-1]);
            cajero.start();
        }

    }

    
}

/*
 * Respuesta:
 * 
 * El tercer ejemplo por lo que veo, el comportamiento que tiene es que los cajeros (threads) empiezan y terminan al mismo tiempo.
 * Esto se debe a que la suma de los tiempos de los clientes de cada uno de los cajeros, siempre es la misma.
 * Es por eso que los cajeros se demoran el mismo tiempo en atender a todos los clientes, terminando al mismo tiempo.
 * 
 */
