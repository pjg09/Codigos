package logicadeprogramacion;

import javax.swing.JOptionPane;

public class asd {

    public static void main(String[] args) {
        
        String usuario = "";        
        byte opcion = 0;
        boolean input = false;

        try {

            while(!input) {

                try {

                    usuario = JOptionPane.showInputDialog("Selecciona tu opción.\n1.\n2.\n3.\n4.");

                    if(usuario == null || usuario.matches(".*[a-zA-Z].*") || usuario.matches(".*[^a-zA-Z0-9 ].*")) {

                        throw new IllegalArgumentException("Error: no puedes dejar vacía tu opción y esta solo puede contener números enteros.");

                    }

                    opcion = Byte.parseByte(usuario);

                    if(opcion < 1 || opcion > 4) {

                        throw new IllegalArgumentException("Error: solo puedes ingresar numeros entre 1 y 4 para seleccionar tu opción.");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    JOptionPane.showMessageDialog(null, e.getMessage());

                }

            }

        } finally {

            JOptionPane.showMessageDialog(null, "pene");

        }

    }
    
}