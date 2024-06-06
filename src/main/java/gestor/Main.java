package gestor;

import gestor.clases.Asistente;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. "+Validaciones.validarAlfabeto("Niño NiñÁ"));
        System.out.println("2. "+Validaciones.validarLetrasYNumeros("1234567890 Niño NiñÁ"));
        System.out.println("3. "+Validaciones.esNum("1234567890"));
        System.out.println("3. "+Validaciones.validarEmail("murciacasesdav17@elcampico.org"));


        //TODO: Menú autenticación: Login, o registro
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




    }
}