package practicafinal.eventos;

import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * La clase FocusPanelButtonListener maneja los eventos de acción de los botones para cambiar el panel visible en un JFrame.
*/
public class FocusPanelButtonListener implements ActionListener{
    JPanel parentPanel;
    HashMap<String,JPanel> oldPanels;
    JPanel newPanel;
    JFrame frame;
    
    /**
     * Crea una instancia de FocusPanelButtonListener.
     *
     * @param parentPanel El panel padre que contiene los paneles antiguos y el nuevo panel.
     * @param oldPanels   Un HashMap que contiene los paneles antiguos que deben ocultarse.
     * @param newPanel    El nuevo panel que debe mostrarse.
     * @param frame        El JFrame que contiene el parentPanel y necesita ser actualizado.
    */
    public FocusPanelButtonListener(JPanel parentPanel, HashMap<String,JPanel> oldPanels, JPanel newPanel, JFrame frame){
        this.parentPanel = parentPanel;
        this.oldPanels = oldPanels;
        this.newPanel = newPanel;
        this.frame = frame;
    }
    
    /**
     * Método llamado cuando se realiza una acción. Este método oculta todos los paneles antiguos, muestra el nuevo panel
     * y actualiza el JFrame.
     *
     * @param e El evento de acción que dispara este método.
    */
    @Override
    public void actionPerformed(ActionEvent e){
        for(String key: this.oldPanels.keySet()){
            this.oldPanels.get(key).setVisible(false);
            this.parentPanel.remove(this.oldPanels.get(key));
        }
        
        this.newPanel.setVisible(true);
        this.parentPanel.add(this.newPanel, BorderLayout.CENTER);
        
        this.frame.revalidate();
    }
}
