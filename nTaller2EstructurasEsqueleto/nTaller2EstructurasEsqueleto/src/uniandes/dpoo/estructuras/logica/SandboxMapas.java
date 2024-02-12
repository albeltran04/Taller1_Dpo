package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SandboxMapas {

    private Map<String, String> mapaCadenas;

    public SandboxMapas() {
        mapaCadenas = new HashMap<>();
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     *
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista() {
        List<String> valores = new ArrayList<>(mapaCadenas.values());
        Collections.sort(valores);
        return valores;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     *
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida() {
        List<String> llaves = new ArrayList<>(mapaCadenas.keySet());
        Collections.sort(llaves, Collections.reverseOrder());
        return llaves;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa.
     *
     * Si el mapa está vacío, debe retornar null.
     *
     * @return La cadena lexicográficamente menor dentro de las llaves del mapa
     */
    public String getPrimera() {
        if (mapaCadenas.isEmpty()) {
            return null;
        }
        return Collections.min(mapaCadenas.keySet());
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     *
     * Si el conjunto está vacío, debe retornar null.
     *
     * @return La cadena lexicográficamente mayor dentro de los valores del mapa
     */
    public String getUltima() {
        if (mapaCadenas.isEmpty()) {
            return null;
        }
        return Collections.max(mapaCadenas.values());
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     *
     * El orden de las llaves retornadas no importa.
     *
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves() {
        List<String> llavesMayusculas = new ArrayList<>();
        for (String llave : mapaCadenas.keySet()) {
            llavesMayusculas.add(llave.toUpperCase());
        }
        return llavesMayusculas;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     *
     * @return La cantidad de valores diferentes en el mapa
     */
    public int getCantidadCadenasDiferentes() {
        return new HashSet<>(mapaCadenas.values()).size();
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     *
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     *
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena(String cadena) {
        String cadenaInvertida = new StringBuilder(cadena).reverse().toString();
        mapaCadenas.put(cadenaInvertida, cadena);
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     *
     * @param llave La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave(String llave) {
        mapaCadenas.remove(llave);
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     *
     * @param valor El valor que se debe eliminar
     */
    public void eliminarCadenaConValor(String valor) {
        mapaCadenas.values().remove(valor);
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     *
     * Use el método toString para convertir los objetos a cadenas.
     *
     * @param objetos Una lista de objetos
     */
    public void reiniciarMapaCadenas(List<Object> objetos) {
        mapaCadenas.clear();
        for (Object obj : objetos) {
            agregarCadena(obj.toString());
        }
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas() {
        Map<String, String> nuevoMapa = new HashMap<>();
        for (Map.Entry<String, String> entry : mapaCadenas.entrySet()) {
            nuevoMapa.put(entry.getKey().toUpperCase(), entry.getValue());
        }
        mapaCadenas = nuevoMapa;
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     *
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores(String[] otroArreglo) {
        for (String valor : otroArreglo) {
            if (!mapaCadenas.containsValue(valor)) {
                return false;
            }
        }
        return true;
    }

