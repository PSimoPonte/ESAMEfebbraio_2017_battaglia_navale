
package battaglia;

import static battaglia.GestoreEvento.nome;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Simone.Pontalti
 */
public class GestoreEvento2 implements EventHandler<MouseEvent>{
       
    String color3= "red";
    String color4= "blue";

public void handle(MouseEvent t){

 if(t.getTarget() instanceof Acqua){

    Acqua acqf2 = (Acqua)t.getSource(); //cella cliccata nella seconda finestra
    int x= acqf2.rigaPos;  ////--> riga della cella cliccata della finestra 2
    int y= acqf2.colPos; ////--> colonna della cella cliccata della finestra 2
    System.out.println("Cella cliccata: "+acqf2.colPos+"//"+acqf2.rigaPos);

//recupero la corrispondente cella della finestra 1
    Acqua acqf1  =  battaglia_navale.gl.getAcquaAT(x,y); 
//  se Acqua della cella corispondente della finestra f1 contine nave=> colpito
    if (acqf1.presenzaNave==true){  


    acqf2.setStyle("-fx-background-color: "+color3+";-fx-border-color: black;"); 
    System.out.println("Cella colpita!!!!!!");
    acqf2.presenzaNave=false;
    acqf2.cellaColpita = true;

    acqf1.setStyle("-fx-background-color: "+color3+";-fx-border-color: black;");
    System.out.println("Cella colpita!!!!!!");
    acqf1.presenzaNave=false;
    acqf1.cellaColpita = true;


   }else if(acqf1.presenzaNave==false && acqf1.cellaColpita == false){

    System.out.println("MANCATO");
    acqf2.setStyle("-fx-background-color: "+color4+";-fx-border-color: black;");
      System.out.println("Cella colpita!!!!!!");


    acqf1.setStyle("-fx-background-color: "+color4+";-fx-border-color: black;");
    System.out.println("Cella colpita!!!!!!");


     }

          battaglia_navale.TheEnd();
   }
 }
}
