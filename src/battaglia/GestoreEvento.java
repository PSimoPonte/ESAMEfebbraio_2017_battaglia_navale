package battaglia;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Simone.Pontalti
 */
public class GestoreEvento implements EventHandler<MouseEvent>{
    
    String color= "black";
    // variabile di appoggio per salvare Id del toggleButton Cliccato
    static String nome = ""; 
    
//questo codice(handle)verrà eseguito se viene cliccata una cella della griglia  
    public void handle(MouseEvent e){  
 

        if(e.getTarget() instanceof Acqua){
        
//se nome --> (che contiene l'ID del togglebutton cliccato)            
            if(nome.equals("")){ 

                battaglia_navale.showPopup("Non hai cliccato il ToggleButton,\n "
                        + "clicca prima su uno dei 3 ToggleButton");
               
            }else{
                
             Acqua acq = (Acqua)e.getSource(); //cella cliccata
             int x= acq.rigaPos;  ////--> riga della cella cliccata 
             int y= acq.colPos; ////--> colonna della cella cliccata
             System.out.println("Cella cliccata: "+acq.colPos+"//"+acq.rigaPos);
             acq.DisegnaNave(x,y, nome);

            }
    
        }
        
         else if(e.getTarget() instanceof Button){
         
             
         
         }

 
   }
   
}
