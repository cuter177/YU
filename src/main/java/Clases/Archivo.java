package Clases;

import java.io.*;
import java.util.regex.*;
import java.util.ArrayList;

public class Archivo {

    // Metodo para leer datos del archivo y llenar la lista de estudiantes
    public static ListaEstudiantes leerArchivo(String ruta) throws IOException {
        ListaEstudiantes listaEstudiantes = new ListaEstudiantes();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                // Usar expresiones regulares para extraer datos entre corchetes
                Pattern pattern = Pattern.compile("\\[(.*?)]");
                Matcher matcher = pattern.matcher(linea);

                ArrayList<String> partes = new ArrayList<>();
                while (matcher.find()) {
                    partes.add(matcher.group(1).trim()); // Capturar contenido dentro de los corchetes
                }

                // Validar si hay suficientes partes para procesar
                if (partes.size() < 3) {
                    throw new IllegalArgumentException("Formato de línea incorrecto: " + linea);
                }

                // Extraer información básica del estudiante
                String nombre = partes.get(0);
                String matricula = partes.get(1);
                int edad;
                try {
                    edad = Integer.parseInt(partes.get(2));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Edad inválida en línea: " + linea, e);
                }

                // Crear el objeto Estudiante
                Estudiante estudiante = new Estudiante(nombre, edad, matricula);

                // Procesar las calificaciones
                for (int i = 3; i < partes.size(); i++) {
                    String entradaCalificacion = partes.get(i); // Ejemplo: "Fisica, 8"
                    String[] califPartes = entradaCalificacion.split(",");
                    if (califPartes.length == 2) {
                        String materia = califPartes[0].trim();
                        double calificacion;
                        try {
                            calificacion = Double.parseDouble(califPartes[1].trim());
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("Calificación inválida: " + entradaCalificacion, e);
                        }

                        // Crear y agregar calificación al estudiante
                        Calificaciones calificaciones = new Calificaciones();
                        calificaciones.setMateria(materia);
                        calificaciones.setCalificacion(calificacion);
                        estudiante.agregarCalificacion(calificaciones);
                    } else {
                        System.err.println("Formato incorrecto para calificación: " + entradaCalificacion);
                    }
                }

                // Calcular el promedio general del estudiante
                estudiante.calcularPromedio();
                estudiante.calcularMediana();
                estudiante.calcularDesviacionE();

                // Agregar estudiante a la lista
                listaEstudiantes.agregarEstudiante(estudiante);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            throw e;
        }

        return listaEstudiantes;
    }


    // Metodo para guardar la lista de estudiantes en un archivo
    public static void guardarArchivo(String rutaArchivo, ListaEstudiantes listaEstudiantes) throws IOException {
        // Intentar guardar el archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Estudiante estudiante : listaEstudiantes.getListaEstudiantes()) {
                bw.write("[" + estudiante.getNombre() + "] ");
                bw.write("[" + estudiante.getMatricula() + "] ");
                bw.write("[" + estudiante.getEdad() + "] ");

                for (Calificaciones calif : estudiante.getCalificaciones()) {
                    bw.write("[" + calif.getMateria() + ", " + calif.getCalificacion() + "] ");
                }
                bw.write("[Promedio Gerneral: " + estudiante.getPromedioG() + "]");
                bw.write("[Mediana: " + estudiante.getMediana() + "]");
                bw.write("[Desviacion Estandar: " + estudiante.getDesviacionE() + "]");

                bw.newLine(); // Salto de línea para el próximo estudiante
            }
        }
    }
}
