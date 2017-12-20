
package battaglia;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author Simone.Pontalti
 */
public class Griglia extends GridPane {
        
    int nRow=10;
    int nCol=10;
    
    
    /////COSTRUTTORE PER LA GRIGLIA ////////
    public Griglia(String nome){
    
                
        this.setGridLinesVisible(true);
//#############################################################################
//#############################################################################
/////// COSTRUZIONE DELLLA GRIGLIA 10x10 CELLE  //////////

        for(int i=0;i<nRow;i++) 
        {
            for(int j = 0;j<nCol;j++)
                
            {
                  Acqua acq = new Acqua(i,j,nome);
                  
//il metodo add appartiene al GridPane, j sta per colonna e i sta per riga 
//(prima riceve la colonna e poi la riga) ma in una matrice normale prima si 
//mette la riga e poi la colonna
                  this.add(acq, j, i);
                
            }
        }
        
        for (int i = 0; i < nCol; i++) {
            this.getColumnConstraints().add(new ColumnConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            this.getRowConstraints().add(new RowConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }
    
    }
    
    //metodo public void add(int x, int y){}
//#############################################################################
//#############################################################################
    //////funzione che mi restituisce l'elemento nella cella  i - j ////////
    
     public  Acqua getAcquaAT(int i, int j){
    
        for(Node x : this.getChildren()) {
        
          try{
            Acqua y=(Acqua)x;
            System.out.println("=============="+i+"========="+j);
            if((y.colPos==j) && (y.rigaPos==i)) {
                       return y;
            }
            
          }catch(Exception e){
          
              System.out.println(e.getMessage());
          }
        }
        return null;
    }
      
        
    
}
