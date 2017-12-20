/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battaglia;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Simone.Pontalti
 */
public class Acqua extends StackPane{
    
    int rigaPos =0;
    int colPos =0;
    boolean presenzaNave=false;
    boolean cellaColpita = false;
    String color = "lightblue";
    String color1 = "black";
   
   
    public Acqua(int i, int  j , String nome){
       
       this.rigaPos = i;
       this.colPos = j;
      this.setStyle("-fx-background-color: "+color+";-fx-border-color: black;");
          
        if(nome.equals("f1")){
            GestoreEvento ge = new GestoreEvento();
            this.addEventHandler(MouseEvent.MOUSE_PRESSED, ge);
        }
        else if(nome.equals("f2")){
            GestoreEvento2 ge2 = new GestoreEvento2();
            this.addEventHandler(MouseEvent.MOUSE_PRESSED, ge2);
            
        }
    }
    
    
    void DisegnaNave(int i, int j ,  String n)         
    {
        int nextCol = j+1;
        int nextRow = i+1;
        Acqua nd1 = battaglia_navale.gl.getAcquaAT(i, j); //in questo caso i e j sono recuoerati dalla finestra cliccata
        Acqua nd2 = battaglia_navale.gl.getAcquaAT(i, j+1); //Nave orizzontale
        Acqua nd3 = battaglia_navale.gl.getAcquaAT(i+1, j); 
        
//#############################################################################
//#############################################################################
//Se è stato selezionato il ToggleButton con il tasto 1
//#############################################################################
//#############################################################################

  if(n.equals("1")){
      Acqua ac1 = (Acqua)nd1;

     if(ac1.presenzaNave==false){
      System.out.println("Hai cliccato sul bottone ToggleButton 1");
      ac1.setStyle("-fx-background-color: "+color1+";-fx-border-color: black;");
      ac1.presenzaNave=true;
      battaglia_navale.btn1.decrementa();
     }
  }
//#############################################################################
//#############################################################################
//Se è stato selezionato il ToggleButton con il tasto 2H
//#############################################################################
//#############################################################################
        
else if(n.equals("2H")){
    System.out.println("Hai cliccato sul bottone ToggleButton 2H");

  if(nd2 != null){

    Acqua ac1 = (Acqua)nd1;
    Acqua ac2 = (Acqua)nd2;

    if(ac1.presenzaNave == false && ac2.presenzaNave == false) {

          ac1.setStyle("-fx-background-color: "+color1+";-fx-border-color: black;");
          ac2.setStyle("-fx-background-color: "+color1+";-fx-border-color: black;");
          ac1.presenzaNave=true;
          ac2.presenzaNave=true;
          battaglia_navale.btn2.decrementa();

    }else if(ac1.presenzaNave == true && ac2.presenzaNave == false || ac1.presenzaNave == false && ac2.presenzaNave == true){

      System.out.println("Nono, il ToogleButton 2H e' selez. ma la cella e' occupata");
    }else{

      System.out.println("Nono!TogBut 2H selez. ma cella accanto non esiste");
    }
  }
}

//#############################################################################
//Se è stato selezionato il ToggleButton con il tasto 2V
 
        
else if(n.equals("2V")){
   System.out.println("Hai cliccato sul bottone ToggleButton 2V");

   if(nd3 != null){

    Acqua ac1 = (Acqua)nd1;
    Acqua ac3 = (Acqua)nd3;

    if(ac1.presenzaNave == false && ac3.presenzaNave == false) {

          ac1.setStyle("-fx-background-color: "+color1+";-fx-border-color: black;");
          ac3.setStyle("-fx-background-color: "+color1+";-fx-border-color: black;");
          ac1.presenzaNave=true;
          ac3.presenzaNave=true;
          battaglia_navale.btn3.decrementa();

    }else if(ac1.presenzaNave == true && ac3.presenzaNave == false || ac1.presenzaNave == false && ac3.presenzaNave == true){

      System.out.println("Nono,il ToogBut 2V e' selez.ma la cella e' occupata");
    }else{         

      System.out.println("nono!TogBut 2V selez.ma la cella accanto non esiste");
    }               //"Nono!TogBut 2H selez. ma cella accanto non esiste"
   }
  }
}

 
     
}