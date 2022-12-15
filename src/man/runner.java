/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package man;




import Login.starting;

import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author user
 */
public class runner {
    
    public static void main(String[] args)
    {
        
        
       starting Start = new starting();
       Start.setContentPane(Start.getPanel());
       Start.setSize(1050,820);
        Start.setResizable(false);
       Start.setVisible(true);
       
       for(int i= 0 ;i<=100;i++)
       {
           try {
               Thread.sleep(70);
               Start.num.setText(Integer.toString(i)+"%");
               Start.bar2.setValue(i);
               
           } catch (InterruptedException ex) {
               Logger.getLogger(runner.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            Logger.getLogger(runner.class.getName()).log(Level.SEVERE, null, ex);
        }
       Start.run();
       
       /* LoginPane frame = new LoginPane();

       
        frame.setContentPane(frame.getPanel());
        frame.setSize(650,420);
        frame.setResizable(false);
        frame.setVisible(true);
        */
        
     

//        SignUp Sframe = new SignUp();
//
//       
//        Sframe.setContentPane(Sframe.getPanel());
//        Sframe.setSize(650,420);
//        Sframe.setResizable(false);
//        Sframe.setVisible(true);
//        
//          ManageCars Cframe = new ManageCars();
//          
//          
//           Cframe.setContentPane(Cframe.getPanel());
//           Cframe.setResizable(false);
//        Cframe.setVisible(true);
//          
//          
//        adminMain Aframe = new adminMain();
//
//       
//        Aframe.setContentPane(Aframe.getPanel());
//       // Sframe.setSize(650,420);
//        Aframe.setResizable(false);
//        Aframe.setVisible(true);
//        
//         maintain manframe = new maintain();
//         manframe.setResizable(false);
//         manframe.setVisible(true);
//         
//         RentACar Rframe = new RentACar();
//         Rframe.setContentPane(Rframe.getPanel());
//           Rframe.setResizable(false);
//        Rframe.setVisible(true);
//        
//         Query Qframe = new Query();
//         Qframe.setContentPane(Qframe.getPanel());
//           Qframe.setResizable(false);
//        Qframe.setVisible(true);
//         
//        EnterComplaint Eframe = new EnterComplaint();
//         Eframe.setContentPane(Eframe.getPanel());
//           Eframe.setResizable(false);
//        Eframe.setVisible(true);
//        
//        Cutomers cusframe = new Cutomers();
//        cusframe.setContentPane(cusframe.getPanel());
//           cusframe.setResizable(false);
//        cusframe.setVisible(true);
//        
//        
//        
//          Employee eeframe = new Employee();
//          
//        
//        eeframe.setContentPane(eeframe.getPanel());
//        eeframe.setSize(750,620);
//           eeframe.setResizable(false);
//        eeframe.setVisible(true);
//        
//        
          
        
        
        
        
        
         
          
          
          

        
        
          
               
                
                
            
       
    
        
        
         

    




    }
    
}
