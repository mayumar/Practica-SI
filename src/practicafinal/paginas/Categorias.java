package practicafinal.paginas;

import javax.swing.*;

import practicafinal.componentes.Titulo;

import java.awt.*;

public class Categorias extends JPanel{
    public Categorias(){
        setLayout(new BorderLayout());
        
        add(new Titulo("Categorias", false), BorderLayout.NORTH);
    }
}
