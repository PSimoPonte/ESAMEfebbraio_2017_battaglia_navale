package battaglia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Simone.Pontalti
 */
public class battaglia_navale extends Application {
    
    GridPane gp;
    VBox vb;
    HBox hb;
    BorderPane bp;
    int nRow=10;
    int nCol=10;
    double base=400;
    double altezza = 500;
    Button btnReset;
    Button btnF2;
    ToggleGroup tg; 
    static BtnCount btn1 ;
    static BtnCount btn2 ;
    static BtnCount btn3 ;
    static Griglia gl,gr2 ;
    Scene scene;
    static Stage mainWindow=null; 
    
    @Override
    public void start(Stage primaryStage) {

        
        
       gl = new Griglia("f1");  // la stringa f1 fa scegliere la classe 
                              //gestoreEvento che si occupa il clik della cella
    
       tg = new ToggleGroup();

        btn1 = new BtnCount("1", 3,tg);
        btn1.setId("1");

        btn2 = new BtnCount("2H", 2,tg);
        btn2.setId("2H");

        btn3 = new BtnCount("2V", 2,tg);
        btn3.setId("2V");
        btnReset = new Button("Reset");
        btnF2 = new Button("Finestra di gioco");
        
        hb = new HBox(10);
        hb.getChildren().addAll(btnReset, btnF2);


       vb= new VBox(10);
       vb.getChildren().addAll(btn1,btn2,btn3,hb);
       vb.setPadding(new Insets(20, 10, 10, 10));
       
      
       bp = new BorderPane();
       bp.setCenter(gl);
       
       bp.setBottom(vb);
       bp.setAlignment(gl, Pos.CENTER);
       bp.setPadding(new Insets(5, 5, 5, 5));
        
        btnReset.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
           
                     System.out.println("Hai cliccato sul bottone reset");
                     reset();
                
            }
        });
//#############################################################################
//#############       Pulsante per creare seconda finestra    #################
      
        btnF2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               
                double base2=400;
                double altezza2 = 400;
               
               gr2 = new Griglia("f2");
               BorderPane root2 = new BorderPane();

               Scene scene2 = new Scene(root2, base2, altezza2);
                
               Stage secondaryStage = new Stage();
               root2.setCenter(gr2);
               root2.setPadding(new Insets(5, 5, 5, 5));
               secondaryStage.setTitle("Finestra di gioco");
               secondaryStage.setScene(scene2);
               secondaryStage.setX(1300);
               secondaryStage.setY(250);
               secondaryStage.show();
               
 //############################################################################
 //################      Per chiudere la finestra di gioco!    ################

              secondaryStage.setOnCloseRequest((new EventHandler<WindowEvent>(){

              @Override
              public void handle(WindowEvent arg0) {
                  Platform.exit();
              }
              }));
            }
        });
//#############################################################################
//#############################################################################

         scene = new Scene(bp, base, altezza);
        
        primaryStage.setTitle("Finestra di setup");
        primaryStage.setScene(scene);
        primaryStage.show();
        
//#############################################################################
//################      Per chiudere la finestra principale!   ################

              primaryStage.setOnCloseRequest((new EventHandler<WindowEvent>(){

              @Override
              public void handle(WindowEvent arg0) {
                  Platform.exit();
              }
              }));
  
//#############################################################################
//#############################################################################
    }
 
void reset(){ 

    String color="lightblue";
    try{
     for(int i=0; i<10; i++){
      for(int j=0; j<10; j++){
        Acqua x1= (Acqua) gl.getAcquaAT(i, j);
        x1.presenzaNave=false;
        x1.setStyle("-fx-background-color: "+color+";-fx-border-color: black;");

        Acqua x2= (Acqua) gr2.getAcquaAT(i, j);
        x2.presenzaNave=false;
        x2.setStyle("-fx-background-color: "+color+";-fx-border-color: black;");

        }
     }

            btn1.ripristinaContatore(3);
            btn2.ripristinaContatore(2);
            btn3.ripristinaContatore(2);
       
            
        }catch(Exception e){
       
            System.out.println( e.getMessage());
        }
    }
    
    static void TheEnd(){
    
        boolean giocoFinito=true; // cioè non ci sono navi nella griglia
        for(int i=0; i<10; i++){
            
                for(int j=0; j<10; j++){
                    Acqua x1= (Acqua) gl.getAcquaAT(i, j);
                     if(x1.presenzaNave==true){
                        giocoFinito=false; // trovata presenza di nave in 
                                            //una delle 100 celle
                        break;
                    }
                }
            }
         
        
             if(giocoFinito==true){
                    
                       showPopup("Hai vinto, navi affondate ");
                   
              }
        
    }    
//un metodo static può accedere solo ad una variabile che è static
// se accedo ad un a variabile non static avrò errore!
      public static void showPopup(String message) { 
          
        Label label = new Label(message);
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        Scene sc = new Scene(label, 500, 200);
        Stage stage = new Stage();
        stage.setScene(sc);
        stage.setX(100);
        stage.setY(100);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(mainWindow);
        stage.show();
    }
      
 public static  void mostraFinestra2(){
      
    showPopup(" funzione mostraFinestra2 viene eseguita");
          
    if( btn1.tb.isDisable()==true && btn2.tb.isDisable()==true && btn3.tb.isDisable()==true) { 
           
                double base2=400;
                double altezza2 = 400;
               
               gr2 = new Griglia("f2");
               BorderPane root2 = new BorderPane();

               Scene scene2 = new Scene(root2, base2, altezza2);
                
               Stage secondaryStage = new Stage();
               root2.setCenter(gr2);
               root2.setPadding(new Insets(5, 5, 5, 5));
               secondaryStage.setTitle("Finestra di gioco");
               secondaryStage.setScene(scene2);
               secondaryStage.setX(1300);
               secondaryStage.setY(250);
               secondaryStage.show();
           }
      }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
