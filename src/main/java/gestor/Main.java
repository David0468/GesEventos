package gestor;

import gestor.clases.Asistente;
import gestor.clases.Usuario;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Usuario activo = null;
        System.out.println("1. " + Validaciones.validarAlfabetoLatino("Niño NiñÁ"));
        System.out.println("2. " + Validaciones.validarLetrasYNumeros("1234567890 Niño NiñÁ"));
        System.out.println("3. " + Validaciones.esNum("1234567890"));
        System.out.println("3. " + Validaciones.validarEmail("murciacasesdav17@elcampico.org"));


        //GestorEventos migestor=new GestorEventos();
        //migestor.login();



        /*System.out.println("                                ");
        System.out.println("###  DELECTARE MULTIEVENTOS  ###");
        System.out.println("--------------------------------");
        System.out.println("                                ");
        System.out.println("     1. Seleccionar evento      ");
        System.out.println("     2. Información reservas    ");
        System.out.println("     3. Salir                   ");
        System.out.println("                                ");
        System.out.println(" Por favor, escoja una opción:  ");
        System.out.println("                                ");*/

        //TODO: Menú autenticación: Login, o registro
        GestorEventos gestor = new GestorEventos();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("                                ");
            System.out.println("###      Menú de Inicio      ###");
            System.out.println("--------------------------------");
            System.out.println("                                ");
            System.out.println("            a. Login            ");
            System.out.println("           b. Registro          ");
            System.out.println("            c. Salir            ");
            System.out.println("                                ");
            System.out.println("  Por favor, escoja una opción: ");
            String opcion = sc.next().trim();

            switch (opcion) {
                case "a":
                    Usuario usuario = gestor.login();
                    if (usuario instanceof gestor.clases.Administrador) {
                        while (!salir) {
                            System.out.println("Panel Administrador:");
                            System.out.println("1 Agregar Evento");
                            System.out.println("2 Eliminar Evento");
                            System.out.println("3 Listar Eventos");
                            System.out.println("4 Salir");
                            System.out.print("Seleccione una opción: ");
                            String opcionAdmin = sc.next().trim();

                            switch (opcionAdmin) {
                                case "1":
                                    gestor.agregarEvento();
                                    break;
                                case "2":
                                    gestor.eliminarEvento();
                                    break;
                                case "3":
                                    gestor.listarEventos();
                                    break;
                                case "4":
                                    salir = true;
                                    System.out.println("Saliendo...");
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("Opción no válida, intente nuevamente.");
                            }
                        }
                    } else
                        break;
                case "b":
                    gestor.registro();
                    break;
                case "c":
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
