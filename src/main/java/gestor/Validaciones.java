package gestor;

import java.util.UUID;

public class Validaciones {
    //se hace todo con FOR
    //Método llamado esNum que devuelve true o false dependiendo de si una cadena que se pasa como parámetro contiene valores numéricos
    public static boolean esNum(String cadena){
        //si no se pone nada o esta vacio devuelve false
        if (cadena == null || cadena.isEmpty()) {
            return false;
        }

        //recorrer la cadena con un for y buscar si hay o no valores diferentes a 0-9
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);

            //verificar cadena y buscar valores diferentes a 0-9 y si no es o hay otra cosa que no sea un numero devuelve false
            if (caracter < '0' || caracter > '9') {
                return false;
            }
        }
        //Si ha pasado por todos los caracteres y todos son numéricos, devolver true
        return true;
    }


    public static boolean validarOpcionNum(String opcion) {
        // Verifica si la cadena contiene solo un carácter que sea 1, 2, 3 o 4
        if (opcion.matches("[1-4]")) {
            return true;
        } else {
            return false;
        }
    }


    //validar una cadena y comprobar que sólo tiene letras y números (permite espacios y acentos):
    public static boolean validarLetrasYNumeros(String cadena){
        if (!cadena.matches("[áéíóúÁÉÍÓÚa-zA-ZñÑ0-9 ]*")) {
            return false;
        } else {
            return true;
        }
    }



    //Validador Contraseña:
    public static boolean validarContrasena(String contrasena){
        if (!contrasena.matches("[A-Za-z0-9.-_]*")) {
            return false;
        } else {
            return true;
        }
    }

    //validar alfabeto latino (permite espacios y acentos):
    public static boolean validarAlfabetoLatino(String palabra){
        if (!palabra.matches("[áéíóúÁÉÍÓÚa-zA-ZñÑ ]*")) {
            return false;
        } else {
            return true;
        }
    }



    //validar el email:
    public static boolean validarEmail(String email){
        if (!email.matches("[A-Za-z0-9.-_]*")) {
            return false;
        }else if (!(email.contains("@") && email.contains(".") && email.indexOf(".") > email.indexOf("@"))){
            return false;
        }else {
            return true;
        }
    }


    //Validar DNI:
    public static boolean validarDNI(String dni) {
        if (dni.length() != 9) {
            return false;
        }

        String numeros = dni.substring(0, 8);
        char letra = dni.charAt(8);

        return esNum(numeros) && Character.isLetter(letra);
    }


    public static boolean validarTelefono(String telefono) {
        // Eliminar espacios y luego verificar la longitud
        String telefonoSinEspacios = telefono.replaceAll("\\s+", "");
        if (telefonoSinEspacios.length() > 9) {
            return false;
        }
        // Verificar que el número restante solo contenga dígitos
        return esNum(telefonoSinEspacios);
    }


    //Token UUID (Universal Unique Identifier):
    public class GenerarUUID{
        public static void main(String[] args) {
            //Generar una UUID aleatoria
            UUID uuid = UUID.randomUUID();

            //Imprimir la UUID
            System.out.println("UUID generada: " + uuid.toString());
        }
    }



}
