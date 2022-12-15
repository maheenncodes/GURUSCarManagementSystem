

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */



import Login.MainPage;
import org.junit.Test;
import static org.junit.Assert.*;




/**
 *
 * @author user
 */
public class MainPageTest {
    
    
    
    public MainPageTest() {
    }
   
    
    
    @Test
    public   void TestAdminLogin()
    {
         
       String expex = "Admin";
       MainPage instance = new MainPage();
     String val =  instance.check("t", "1234");
       assertEquals(expex, val);
       
        
    }
    @Test
      public   void TestStaffLogin()
    {
         
       String expex = "Staff";
     MainPage instance = new MainPage();
     String val =  instance.check("taimoor", "1234");
       assertEquals(expex, val);
       
        
    }
         @Test
      public   void TestLoginEmptyField()
    {
         
       String expex = "empty";
       MainPage instance = new MainPage();
     String val =  instance.check("", "");
       assertEquals(expex, val);
       
        expex = "empty";
       
       val =  instance.check("t", "");
       assertEquals(expex, val);
       
        
    }
      
      
      //SignUp Tests
      
       @Test
    public void SignTest()
    {
         String expex = "True";
      MainPage instance = new MainPage();
     String val =  instance.CheckSignUp("maheen", "1234","new@gmail.com","03096300116","Admin");
       assertEquals(expex, val);
        
    }
    @Test
     public void SignTest2()
    {
         String expex = "";
      MainPage instance = new MainPage();
     String val =  instance.CheckSignUp("", "12000","new@gmail.com","03096300116","Staff");
       assertEquals(expex, val);
        
    }
    
    
  
}
