/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Habitacion;
/**
 *
 * @author EduardOnnichannn
 */
public class FicheroHabitaciones {
    
    private static String rutaArchivo = System.getProperty("user.dir") + File.separator + "src" + File.separator + "datos" + File.separator + "habitaciones.txt";
    
    private static final File rutaCarpeta = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "datos");
    private static final File fileArchivo = new File(rutaArchivo);
    
    static BufferedReader br;
    static FileReader fr;
    
    static BufferedWriter bw;
    static FileWriter fw;
    
    static String line;
        
    public static void crearFichero() {
        try {
            if (!rutaCarpeta.exists()) {
                rutaCarpeta.mkdir();
            }

            if (!fileArchivo.exists()) {
                fileArchivo.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error");
        }

    }
    
    public static ArrayList<Habitacion> cargar(){
        ArrayList<Habitacion> habitacion = new ArrayList<>();
        
        try{
            fr = new FileReader(fileArchivo);
            br = new BufferedReader(fr);
            
            while((line = br.readLine()) != null){
                String[] atributos = line.split(";");
                habitacion.add(new Habitacion(Integer.parseInt(atributos[0]), atributos[1],Integer.parseInt(atributos[2]), Boolean.parseBoolean(atributos[3])));
            }           
            br.close();
            fr.close();
            
        }catch(IOException e){
            System.err.println("Error en la carga de la carpeta");
            
        }
        return habitacion;
    }
    
    public static void guardar(ArrayList<Habitacion> habitaciones){
        try{
        fw = new FileWriter(fileArchivo, false);
        bw = new BufferedWriter(fw);
        for(Habitacion habitacion : habitaciones){
            bw.write(habitacion.toString());
            bw.newLine();
            bw.flush();
        
        }
        bw.close();
        fw.close();
        }catch(IOException e){
            System.err.println("Error en la carga de la carpeta");
        }
    }
    
}
