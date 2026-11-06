import java.util.Scanner;

public class Main{
public static void main(String[] args) {

    String id, unidad;
    double valor;
    int opc = 0;
    boolean llenado = false;

    final int MAX = 3;
    SensorTemperatura sensores[] = new SensorTemperatura[MAX];
    Scanner sc = new Scanner(System.in);

    do {
        System.out.println("\n--- MENU SENSORES (ARREGLO COMPLETO) ---");
        System.out.println("1. Ingresar todos los sensores");
        System.out.println("2. Mostrar lecturas de todos los sensores");
        System.out.println("3. Actualizar lecturas de todos los sensores");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opcion: ");
        opc = Integer.parseInt(sc.nextLine());

        switch (opc) {
            case 1:
                for (int i = 0; i < sensores.length; i++) {
                    System.out.println("\n--- Registro del Sensor " + (i + 1) + " ---");
                    System.out.print("Ingrese el ID del sensor: ");
                    id = sc.nextLine();
                    System.out.print("Ingrese el valor actual de temperatura: ");
                    valor = Double.parseDouble(sc.nextLine());
                    System.out.print("Ingrese la unidad (C / F): ");
                    unidad = sc.nextLine();

                    sensores[i] = new SensorTemperatura(id, valor, unidad);
                }
                llenado = true;
                System.out.println("-> Todos los sensores fueron registrados.");
                break;

            case 2:
                if (llenado) {
                    System.out.println("\n--- REPORTE DE SENSORES ---");
                    for (int i = 0; i < sensores.length; i++) {
                        sensores[i].mostrarLectura();
                    }
                } else {
                    System.out.println("Primero debe llenar el arreglo en la opcion 1.");
                }
                break;

            case 3:
                if (llenado) {
                    System.out.println("\n--- ACTUALIZAR TODOS LOS SENSORES ---");
                    for (int i = 0; i < sensores.length; i++) {
                        System.out.println("Actualizando sensor [" + sensores[i].getIdSensor() + "]:");
                        System.out.print("Nuevo valor de temperatura: ");
                        valor = Double.parseDouble(sc.nextLine());
                        System.out.print("Nueva unidad (C / F): ");
                        unidad = sc.nextLine();

                        sensores[i].setValorActual(valor);
                        sensores[i].setUnidad(unidad);
                    }
                    System.out.println("-> Lecturas actualizadas correctamente.");
                } else {
                    System.out.println("Primero debe llenar el arreglo en la opcion 1.");
                }
                break;

            case 4:
                System.out.println("Saliendo del programa...");
                break;

            default:
                System.out.println("Opcion no valida.");
        }
    } while (opc != 4);
    }
}
