/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battaglia;

import static battaglia.battaglia_navale.btn1;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 *
 * @author Simone.Pontalti
 */
public class BtnCount extends HBox {
    
    ToggleButton tb; //in partenza contiene null
    Label lbl;      // in partenza null
    int count;     // in partenza contiene 0
    
  public BtnCount(String nome1, int numero,ToggleGroup group){
    this.tb = new ToggleButton(nome1);
    this.tb.setToggleGroup(group);
    this.tb.setId(nome1);
    this.count=numero;
    String name="contatore  :"+count;
    this.lbl= new Label(name);  
    this.setSpacing(20);
    this.getChildren().addAll(tb,lbl);
    System.out.println("BtnCount e stato creato"+nome1+"--"+numero+"---"+group);
        
         
//#############################################################################
//Quando un utente clicca su uno dei 3 ToggleButton viene eseguito il codice
//del corpo del metodo HANDLE. (Viene salvato l'id del ToggleButton cliccato
//nella variabile static chiamata "nome" appartenente alla classe GestoreEvento)
//#############################################################################
//#############################################################################
        this.tb.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
          public void handle(ActionEvent event) {
                
            System.out.println("Hai cliccatto su me : mi chiamo : "+tb.getId());
            GestoreEvento.nome = tb.getId();
            }
        });

      // GestoreEvento ge = new GestoreEvento();
        //this.tb.addEventHandler(ActionEvent.ACTION, ge);
    
    }
    
    void decrementa(){
    
        this.count--;
        this.lbl.setText("contatore  :"+count);
        if(this.count==0){
            GestoreEvento.nome = "";
            this.tb.setDisable(true);
       
            battaglia_navale.mostraFinestra2();
       }
       
    }
    
        void ripristinaContatore(int count){
            
        this.lbl.setText("contatore  :"+count);
        this.tb.setDisable(false);
        this.tb.setSelected(false);
            
    }
    
}
