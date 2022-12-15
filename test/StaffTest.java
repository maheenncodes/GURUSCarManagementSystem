/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import staff.Staff;

/**
 *
 * @author hamiz
 */
public class StaffTest {
    
     @Test
    public void CusSave()
    {
         String expex = "true";
     Staff instance = new Staff();
     String val =  instance.checkSaveC("check","123-1234-123459","township","03497238821");
       assertEquals(expex, val);
    }
    @Test
    public void CusEdit()
    {
         String expex = "true";
     Staff instance = new Staff();
     String val =  instance.checkEditC("fizza","123-456789-1111","model Town","03497238821");
       assertEquals(expex, val);
    }
    @Test
    public void CusDelete()
    {
        String expex = "true";
       Staff instance = new Staff();
        String val =  instance.checkDeleteC("123-1234-123456");
     assertEquals(expex, val);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    
    //Rent Cars Test
    
      @Test
    public void RentSave()
    {
         String expex = "true";
     Staff instance = new Staff();
     String val =  instance.checkSaveCar("LEA-1123","Honda","City","Available","123456");
       assertEquals(expex, val);
    }
    @Test
    public void RentEdit()
    {
         String expex = "true";
     Staff instance = new Staff();
     String val =  instance.checkEditCar("LEA-1234","Honda","City","Booked","1234567");
       assertEquals(expex, val);
    }
    @Test
    public void RentDelete()
    {
        String expex = "true";
       Staff instance = new Staff();
        String val =  instance.checkDeleteCar("LEA-111");
     assertEquals(expex, val);
    }
    
    
    //Sale Cars Test
    
      @Test
    public void SaleSave()
    {
         String expex = "true";
     Staff instance = new Staff();
     String val =  instance.checkSaveSale("LEA-1154","Honda","City","Available","123456");
       assertEquals(expex, val);
    }
    @Test
    public void SaleEdit()
    {
         String expex = "true";
     Staff instance = new Staff();
     String val =  instance.checkEditSale("LEE-2733-13","honda","city","Available","1234567");
       assertEquals(expex, val);
    }
    @Test
    public void SaleDelete()
    {
        String expex = "true";
       Staff instance = new Staff();
        String val =  instance.checkDeleteSale("LEA-1122");
     assertEquals(expex, val);
    }
    
    //Maintain Cars Test
    
      @Test
    public void MaintainSave()
    {
         String expex = "true";
     Staff instance = new Staff();
     String val =  instance.checkSaveMaintain("LEA-1123","Wed Dec 05 00:00:00 PKT 2021","Thu Dec 09 12:33:22 PKT 2022");
       assertEquals(expex, val);
    }
    @Test
    public void MaintainEdit()
    {
         String expex = "true";
     Staff instance = new Staff();
     String val =  instance.checkEditMaintain("BAD-935","Wed Dec 08 00:00:00 PKT 2021","Thu Dec 09 12:33:22 PKT 2022");
       assertEquals(expex, val);
    }
    @Test
    public void MaintainDelete()
    {
        String expex = "true";
       Staff instance = new Staff();
        String val =  instance.checkDeleteMaintain("BAD-937");
     assertEquals(expex, val);
    }
}
