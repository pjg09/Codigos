package logicadeprogramacion;

import java.io.*;

public class ejerciciomanejoarchivos {

        public static void main(String args[]){
        
        try{
            
            float acumuladorTemperaturas = 0, promedioTemp = 0;
            
            int contador = 0;
            
            File archivoLectura = new File("C:\\Users\\pjgom\\OneDrive\\Desktop\\pene.txt");
            FileReader mediciones = new FileReader(archivoLectura);
            BufferedReader datos = new BufferedReader(mediciones);
            
            String linea = "";
            
            while((linea = datos.readLine()) != null){

                if(linea.trim().isEmpty()) {

                    continue;

                }
                
                String[] lineaSplit = linea.split(";");
                
                for(int i = 0; i < lineaSplit.length; i++){
                    acumuladorTemperaturas += Float.parseFloat(lineaSplit[i]);
                }
                
                contador = lineaSplit.length;
            }
            
            promedioTemp = acumuladorTemperaturas / contador;
            
            System.out.println("Promedio de las temperaturas: " + promedioTemp);
            
            datos.close();
            
        }
        catch(IOException io){
            System.out.println("Error en el archivo: " + io.getMessage());
        }
        catch(Exception e){
            System.out.println("Error en el archivo: " + e.getMessage());
        }
        
    }
    
}