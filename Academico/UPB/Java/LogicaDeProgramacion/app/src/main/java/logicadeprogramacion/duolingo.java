package logicadeprogramacion;

import java.io.*;

public class duolingo {

    public static void main(String[] args) {
        
        try {

            File voluntarios = new File("C:\\Users\\pjgom\\OneDrive\\Desktop\\voluntarios.csv");
            File proyectos = new File("C:\\Users\\pjgom\\OneDrive\\Desktop\\proyectos.csv");

            FileReader lecturaVoluntarios = new FileReader(voluntarios);

            BufferedReader cargaVoluntarios = new BufferedReader(lecturaVoluntarios);

            String lineaVoluntarios = cargaVoluntarios.readLine();

            while((lineaVoluntarios = cargaVoluntarios.readLine()) != null) {

                String [] informacionVoluntarios = lineaVoluntarios.split(";");

                System.out.println("Voluntario: " + informacionVoluntarios[1] + "\nRol: " + informacionVoluntarios[2] + "\nFecha de inicio: " + informacionVoluntarios[3]);

                FileReader lecturaProyectos = new FileReader(proyectos);
                BufferedReader cargaProyectos = new BufferedReader(lecturaProyectos);
                String lineaProyectos = cargaProyectos.readLine();

                while((lineaProyectos = cargaProyectos.readLine()) != null) {

                    String [] informacionProyectos = lineaProyectos.split(";");

                    if(Byte.parseByte(informacionProyectos[0]) == Byte.parseByte(informacionVoluntarios[0])) {

                        System.out.println("HOLAA");

                    }

                }

                cargaProyectos.close();
                cargaVoluntarios.close();

            }

        } catch(IOException e) {

            System.out.println(e.getMessage());

        }

    }
    
}