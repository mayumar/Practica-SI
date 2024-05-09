package practicafinal.paginas;

import java.awt.*;
import javax.swing.*;

public class Inicio {

    public static JPanel createInicio(){

        JPanel inicio = new JPanel(new BorderLayout());

        inicio.add(Titulo.createTitulo("EXPLORA, JUEGA, DECIDE: LA GUÍA DEFINITVA PARA GAMERS", true), BorderLayout.NORTH);


        return inicio;
    }
}
