package Test1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import Admin.Admin;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class AdminTest {
    
    public AdminTest()
    {
    }
    
    @Test
    public void EmployeeSave()
    {
         String expex = "true";
     Admin instance = new Admin();
     String val =  instance.checkSave("p","111111111126","driver","12000","1235675556");
       assertEquals(expex, val);
    }
    //@Test
    /*public void EmployeeEdit()
    {
         String expex = "true";
     Admin instance = new Admin();
     String val =  instance.checkEdit("p","111111111126","driver","1234","1235675556");
       assertEquals(expex, val);
    }*/
    @Test
    public void EmployeeDelete()
    {
        String expex = "true";
        Admin instance = new Admin();
        String val =  instance.checkDelete("111111111126");
     assertEquals(expex, val);
    }
    
     
}
