package ProyectoUno;

import java.util.Scanner;

public class Proyect {
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        int selector;
        boolean exit = false;
        String inputRoute = "C:\\Users\\david\\OneDrive - Centro de Enseñanza Técnica Industrial\\Documentos\\CodeGym Proyects\\Proyecto uno\\Codificador\\src\\ProyectoUno\\entrada.txt";
        String outputRoute = "C:\\Users\\david\\OneDrive - Centro de Enseñanza Técnica Industrial\\Documentos\\CodeGym Proyects\\Proyecto uno\\Codificador\\src\\ProyectoUno\\salida.txt";
        String archivoCifrado = "C:\\Users\\david\\OneDrive - Centro de Enseñanza Técnica Industrial\\Documentos\\CodeGym Proyects\\Proyecto uno\\Codificador\\src\\ProyectoUno\\cifrado.txt";
        int key;
     

        while (exit == false) {
            System.out.println("Elije una opción: ");
            System.out.println("1. Cifrar");
            System.out.println("2. Descifrar con llave");
            System.out.println("3. Descifrar por fuerza bruta");
            System.out.println("4. Descifrar por estadística");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            selector = console.nextInt();
            switch (selector) {
                case 1:
                    System.out.println("1 - Cifrar un archivo");
                    System.out.println("Captura la ruta del archivo a descifrar: ");
                    //inputRoute = console.nextLine();
                    System.out.println("Captura la ruta del archivo de salida:");
                    //archivoCifrado = console.nextLine();
                    System.out.println("Captura la llave numérica: ");
                    key = console.nextInt();
                    System.out.println("Procesando...");
                    Cifrado cifrado = new Cifrado(inputRoute, key, archivoCifrado);
                    cifrado.cifrar();
                    break;
                case 2:
                    System.out.println("2 - Descifrar con llave");
                    System.out.println("Captura la ruta del archivo cifrado: ");
                    //archivoCifrado = console.nextLine();
                    System.out.println("Captura la ruta del archivo de salida: ");
                    //outputRoute = console.nextLine();
                    System.out.println("Captura la llave numérica: ");
                    key = console.nextInt();
                    System.out.println("Procesando...");
                    Descifrado descifrado = new Descifrado(archivoCifrado, key, outputRoute);
                    descifrado.descifrarConLlave(key);
                    break;
                case 3:

                case 4:
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}
