/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin;

import Login.MainPage;
import com.toedter.calendar.JTextFieldDateEditor;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author hamiz
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Tabbed
     */
    public Admin() {
        initComponents();
       TableColumn testColumn = ATable1.getColumnModel().getColumn(2);
      JComboBox<String> comboBox = new JComboBox<>();
      comboBox.addItem("Present");
      comboBox.addItem("Absent");
      comboBox.addItem("Leave");
      testColumn.setCellEditor(new DefaultCellEditor(comboBox));
      jComboBox2.setVisible(false);
      
      DisplayEmployeesE();
    }
    
    Connection Con = null;
    Statement st = null;
    ResultSet rs = null;
    Date date;
    Date nextDate;
    
    public void DisplayDateAttendence()
    {
        try
        {
            
           
              this.date = new Date();
             // this.nextDate = new Date();
              SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
              String str = formatter.format(date);
              
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
            st =  Con.createStatement();
            
            String strDate;
            Date date1 = ADate.getDate();  
             if(ADate.getDate() != null)
            {
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
                strDate = dateFormat.format(date1);
                rs = st.executeQuery("Select * from Attendence"+" where date_ ='"+strDate+"'");
           
                DefaultTableModel model = (DefaultTableModel) ATable.getModel();
                model.setRowCount(0);
                 
                if(date1.before(date)|| date1.equals(date))
               {
                
                   while(rs.next())
                    {
                    String name = rs.getString("EmpName");
                    String designation_ = rs.getString("designation");
                    String status= rs.getString("status");

                    String tbData[] = {name, designation_,  status};
                    model.addRow(tbData);


                    }
                   if(ATable.getRowCount()== 0)
                   {
                     JOptionPane.showMessageDialog(this, "No Attendence Available on this day");
                   }
                
                }
                else if(date1.after(date))
                {
                
               
                    ef3Attendence.setText("Please Select Appropriate Date");
                     
                }
                 
            }  
           
            if(ADate.getDate() == null)
            {
                
                 ef2Attendence.setText("Select a Date");
            }  
            
           
            
            
           /* try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Attendence.class.getName()).log(Level.SEVERE, null, ex);
            }*/
           
           
        
            
        }
        catch(SQLException e)
        {
            //e.printStackTrace();
        }
        
        
        
            
        
    }
  
    public void DisplayEmployees() 
    {
        try
        {
            
           
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
            st =  Con.createStatement();
            rs = st.executeQuery("Select * from Employees");
            DefaultTableModel model = (DefaultTableModel) ATable1.getModel();
            model.setRowCount(0);
            while(rs.next())
            {
                String name = rs.getString("EmpName");
                String designation_ = rs.getString("designation");
                
   
                
                String tbData[] = {name, designation_};
                 model.addRow(tbData);
                
                
            }
            
        }
        catch(SQLException e)
        {
           // e.printStackTrace();
        }
    }
    public void DisplayEmployeesE() 
    {
        try
        {
            
           
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
            st =  Con.createStatement();
            if(SearchTxtE.getText().equals("")){
              rs = st.executeQuery("Select * from Employees");
            }
            else
            {
                rs = st.executeQuery("Select * from management.Employees where EmpName like '"+SearchTxtE.getText()+"%'");
            }
          
            
            DefaultTableModel model = (DefaultTableModel) EmployeesTable.getModel();
            model.setRowCount(0);
            while(rs.next())
            {
                String name = rs.getString("EmpName");
                String cnic_ = rs.getString("CNIC");
                String designation_ = rs.getString("designation");
                String salary_ = rs.getString("salary");
                String licsense_ = rs.getString("LisenceNo");
   
                
                String tbData[] = {name, cnic_, designation_ , salary_ , licsense_};
                 model.addRow(tbData);
                
                
            }
            
        }
        catch(SQLException e)
        {
           // e.printStackTrace();
        }    
    }
    
    public void Ereset()
    {
          EmpNametxt.setText("");
          EmpCnictxt.setText("");
          EmpDesignationtxt.setText("");
          EmpSalarytxt.setText("");
          EmpLiscensetxt.setText("");
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabbedPanel = new javax.swing.JPanel();
        optionPanel = new javax.swing.JPanel();
        aPageL = new javax.swing.JLabel();
        attendL = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        logoutB = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tab = new javax.swing.JTabbedPane();
        Employees = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        EmpNametxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        EmpCnictxt = new javax.swing.JTextField();
        EmpSalarytxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        EmpLiscensetxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        editBtnEmp = new javax.swing.JButton();
        saveBtnEmp = new javax.swing.JButton();
        resetBtnEmp = new javax.swing.JButton();
        deleteBtnEmp = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        EmployeesTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        EmpDesignationtxt = new javax.swing.JTextField();
        Search = new javax.swing.JLabel();
        SearchTxtE = new javax.swing.JTextField();
        SearchbtnE = new javax.swing.JButton();
        Analytics = new javax.swing.JPanel();
        analyticalL1 = new javax.swing.JLabel();
        ScarLabel = new javax.swing.JLabel();
        rentL = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        totalCars = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        SoldCars = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        availableCars = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        soldPercentage = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        totalForRent = new javax.swing.JTextField();
        rentCars = new javax.swing.JTextField();
        rentAvailable = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        rentPercentage = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        sold_ = new javax.swing.JLabel();
        aval_ = new javax.swing.JLabel();
        red = new javax.swing.JButton();
        blue = new javax.swing.JButton();
        red1 = new javax.swing.JButton();
        rented_ = new javax.swing.JLabel();
        blue1 = new javax.swing.JButton();
        aval_1 = new javax.swing.JLabel();
        Attendence = new javax.swing.JPanel();
        analyticalL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ATable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        Add = new javax.swing.JButton();
        Load = new javax.swing.JButton();
        ADate = new com.toedter.calendar.JDateChooser();
        ef2Attendence = new javax.swing.JLabel();
        Attendence1 = new javax.swing.JPanel();
        analyticalL2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ATable1 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        Add1 = new javax.swing.JButton();
        ADate1 = new com.toedter.calendar.JDateChooser();
        jComboBox2 = new javax.swing.JComboBox<>();
        Back = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        ef3Attendence = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(902, 531));

        TabbedPanel.setBackground(new java.awt.Color(0, 0, 0));

        optionPanel.setBackground(new java.awt.Color(102, 153, 255));

        aPageL.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        aPageL.setText("Manager Page");

        attendL.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        attendL.setText("Manage Attendance");
        attendL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attendLMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel1.setText("Manage Employees");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        logoutB.setBackground(new java.awt.Color(0, 0, 0));
        logoutB.setForeground(java.awt.Color.white);
        logoutB.setText("Log Out");
        logoutB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel18.setText("View Analytics");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin/GURUS.png"))); // NOI18N
        jLabel19.setText("jLabel19");

        javax.swing.GroupLayout optionPanelLayout = new javax.swing.GroupLayout(optionPanel);
        optionPanel.setLayout(optionPanelLayout);
        optionPanelLayout.setHorizontalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logoutB, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(optionPanelLayout.createSequentialGroup()
                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(optionPanelLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(attendL)
                            .addComponent(aPageL, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(optionPanelLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel18)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        optionPanelLayout.setVerticalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aPageL, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(attendL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel18)
                .addGap(194, 194, 194)
                .addComponent(logoutB, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        tab.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        Employees.setBackground(new java.awt.Color(0, 0, 0));
        Employees.setMinimumSize(new java.awt.Dimension(700, 400));

        jLabel3.setFont(new java.awt.Font("Yu Gothic Light", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Manage Employees");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Employee Name");
        jLabel4.setToolTipText("");

        EmpNametxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EmpNametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpNametxtActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CNIC No.");
        jLabel5.setToolTipText("");

        EmpCnictxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EmpCnictxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpCnictxtActionPerformed(evt);
            }
        });

        EmpSalarytxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EmpSalarytxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpSalarytxtActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Liscense No.");
        jLabel7.setToolTipText("");

        EmpLiscensetxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EmpLiscensetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpLiscensetxtActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Salary");
        jLabel8.setToolTipText("");

        editBtnEmp.setBackground(new java.awt.Color(102, 153, 255));
        editBtnEmp.setForeground(new java.awt.Color(74, 31, 61));
        editBtnEmp.setText("Edit");
        editBtnEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnEmpActionPerformed(evt);
            }
        });

        saveBtnEmp.setBackground(new java.awt.Color(102, 153, 255));
        saveBtnEmp.setForeground(new java.awt.Color(74, 31, 61));
        saveBtnEmp.setText("Save");
        saveBtnEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnEmpActionPerformed(evt);
            }
        });

        resetBtnEmp.setBackground(new java.awt.Color(102, 153, 255));
        resetBtnEmp.setForeground(new java.awt.Color(74, 31, 61));
        resetBtnEmp.setText("Reset");
        resetBtnEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnEmpActionPerformed(evt);
            }
        });

        deleteBtnEmp.setBackground(new java.awt.Color(102, 153, 255));
        deleteBtnEmp.setForeground(new java.awt.Color(74, 31, 61));
        deleteBtnEmp.setText("Delete");
        deleteBtnEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnEmpActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Yu Gothic Light", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Employees List");
        jLabel9.setToolTipText("");

        EmployeesTable.setBackground(new java.awt.Color(0, 0, 0));
        EmployeesTable.setForeground(new java.awt.Color(255, 255, 255));
        EmployeesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "CNIC No.", "Designation", "Salary", "Liscence No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EmployeesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmployeesTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(EmployeesTable);

        jLabel6.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Designation");
        jLabel6.setToolTipText("");

        EmpDesignationtxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EmpDesignationtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpDesignationtxtActionPerformed(evt);
            }
        });

        Search.setForeground(new java.awt.Color(255, 255, 255));
        Search.setText("Search By Name:");

        SearchTxtE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTxtESearchTxtActionPerformed(evt);
            }
        });

        SearchbtnE.setBackground(new java.awt.Color(102, 153, 255));
        SearchbtnE.setText("Search");
        SearchbtnE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchbtnESearchbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EmployeesLayout = new javax.swing.GroupLayout(Employees);
        Employees.setLayout(EmployeesLayout);
        EmployeesLayout.setHorizontalGroup(
            EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(EmployeesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmployeesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(Search)
                        .addGap(18, 18, 18)
                        .addComponent(SearchTxtE, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchbtnE)
                        .addGap(16, 16, 16))))
            .addGroup(EmployeesLayout.createSequentialGroup()
                .addGap(570, 570, 570)
                .addComponent(deleteBtnEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(resetBtnEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(EmployeesLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmpNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EmployeesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(saveBtnEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(editBtnEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 564, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmployeesLayout.createSequentialGroup()
                        .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EmployeesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(EmpCnictxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(EmpDesignationtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(EmpSalarytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
                            .addGroup(EmployeesLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)))
                        .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmpLiscensetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(92, 92, 92))))
        );
        EmployeesLayout.setVerticalGroup(
            EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmployeesLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EmployeesLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmployeesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(14, 14, 14)))
                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmpSalarytxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmpLiscensetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmpDesignationtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmpCnictxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmpNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtnEmp)
                    .addComponent(editBtnEmp)
                    .addComponent(deleteBtnEmp)
                    .addComponent(resetBtnEmp))
                .addGap(53, 53, 53)
                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Search)
                        .addComponent(SearchTxtE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SearchbtnE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        tab.addTab("", Employees);

        Analytics.setBackground(new java.awt.Color(0, 0, 0));
        Analytics.setForeground(new java.awt.Color(255, 255, 255));

        analyticalL1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        analyticalL1.setForeground(new java.awt.Color(255, 255, 255));
        analyticalL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        analyticalL1.setText("Analytics");
        analyticalL1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ScarLabel.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        ScarLabel.setForeground(new java.awt.Color(255, 255, 255));
        ScarLabel.setText("Sale Ratio");

        rentL.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        rentL.setForeground(new java.awt.Color(255, 255, 255));
        rentL.setText("Rent Ratio");

        jLabel10.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total Cars Registered :");

        totalCars.setEditable(false);
        totalCars.setText("No of Cars");
        totalCars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalCarsActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total Cars Sold :");

        SoldCars.setEditable(false);
        SoldCars.setText("No of Cars");
        SoldCars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoldCarsActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Total Cars Available:");

        availableCars.setEditable(false);
        availableCars.setText("No of Cars");
        availableCars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableCarsActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Selling Percentage :");

        soldPercentage.setEditable(false);
        soldPercentage.setText("percentage");
        soldPercentage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soldPercentageActionPerformed(evt);
            }
        });

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Total Cars Registered :");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Total Cars Rent out :");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Total Cars Available :");

        totalForRent.setEditable(false);
        totalForRent.setText("No of Cars");
        totalForRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalForRentActionPerformed(evt);
            }
        });

        rentCars.setEditable(false);
        rentCars.setText("No of Cars");
        rentCars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentCarsActionPerformed(evt);
            }
        });

        rentAvailable.setEditable(false);
        rentAvailable.setText("No of Cars");
        rentAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentAvailableActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Renting Percentage :");

        rentPercentage.setEditable(false);
        rentPercentage.setText("percentage");
        rentPercentage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentPercentageActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 153, 255));
        jButton1.setText("Generate Pie Chart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 153, 255));
        jButton2.setText("Generate Pie Chart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        sold_.setForeground(new java.awt.Color(255, 255, 255));
        sold_.setText("sold");
        sold_.setToolTipText("");

        aval_.setBackground(new java.awt.Color(51, 0, 255));
        aval_.setForeground(new java.awt.Color(255, 255, 255));
        aval_.setText("avaliable");

        red.setBackground(new java.awt.Color(204, 0, 0));
        red.setForeground(new java.awt.Color(204, 0, 0));
        red.setText("jButton3");

        blue.setBackground(new java.awt.Color(0, 102, 255));
        blue.setForeground(new java.awt.Color(0, 102, 255));
        blue.setText("jButton3");

        red1.setBackground(new java.awt.Color(204, 0, 0));
        red1.setForeground(new java.awt.Color(204, 0, 0));
        red1.setText("jButton3");

        rented_.setForeground(new java.awt.Color(255, 255, 255));
        rented_.setText("rented");
        rented_.setToolTipText("");

        blue1.setBackground(new java.awt.Color(0, 102, 255));
        blue1.setForeground(new java.awt.Color(0, 102, 255));
        blue1.setText("jButton3");

        aval_1.setBackground(new java.awt.Color(51, 0, 255));
        aval_1.setForeground(new java.awt.Color(255, 255, 255));
        aval_1.setText("avaliable");

        javax.swing.GroupLayout AnalyticsLayout = new javax.swing.GroupLayout(Analytics);
        Analytics.setLayout(AnalyticsLayout);
        AnalyticsLayout.setHorizontalGroup(
            AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AnalyticsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(analyticalL1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AnalyticsLayout.createSequentialGroup()
                .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AnalyticsLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addGap(73, 73, 73)
                        .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SoldCars, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(availableCars, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalCars, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AnalyticsLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(ScarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AnalyticsLayout.createSequentialGroup()
                        .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(81, 81, 81)
                        .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rentCars, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalForRent, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rentAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(rentL, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AnalyticsLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AnalyticsLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(rentPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AnalyticsLayout.createSequentialGroup()
                                .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(blue1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(AnalyticsLayout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(51, 51, 51)
                                        .addComponent(red1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rented_)
                                    .addComponent(aval_1))))))
                .addGap(77, 77, 77))
            .addGroup(AnalyticsLayout.createSequentialGroup()
                .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AnalyticsLayout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jButton1)
                        .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AnalyticsLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(blue, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(aval_))
                            .addGroup(AnalyticsLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(red, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sold_))))
                    .addGroup(AnalyticsLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(soldPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AnalyticsLayout.setVerticalGroup(
            AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnalyticsLayout.createSequentialGroup()
                .addComponent(analyticalL1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ScarLabel)
                    .addComponent(rentL))
                .addGap(45, 45, 45)
                .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(totalCars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(totalForRent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(SoldCars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(rentCars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(availableCars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(rentAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112)
                .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(soldPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(rentPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AnalyticsLayout.createSequentialGroup()
                        .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(sold_)
                            .addComponent(red, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aval_)
                            .addComponent(blue, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AnalyticsLayout.createSequentialGroup()
                        .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rented_)
                            .addComponent(red1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aval_1)
                            .addComponent(blue1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(237, 237, 237))
        );

        tab.addTab("", Analytics);

        Attendence.setBackground(new java.awt.Color(0, 0, 0));

        analyticalL.setFont(new java.awt.Font("Yu Gothic Light", 1, 36)); // NOI18N
        analyticalL.setForeground(new java.awt.Color(255, 255, 255));
        analyticalL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        analyticalL.setText("Attendence");
        analyticalL.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ATable.setBackground(new java.awt.Color(0, 0, 0));
        ATable.setForeground(new java.awt.Color(255, 255, 255));
        ATable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emloye Name", "Designation", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ATable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        ATable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(ATable);
        if (ATable.getColumnModel().getColumnCount() > 0) {
            ATable.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(jComboBox2));
        }

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Date");

        Add.setBackground(new java.awt.Color(102, 153, 255));
        Add.setText("Add New Attendence");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Load.setBackground(new java.awt.Color(102, 153, 255));
        Load.setText("Load");
        Load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadActionPerformed(evt);
            }
        });

        ef2Attendence.setBackground(new java.awt.Color(0, 0, 0));
        ef2Attendence.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout AttendenceLayout = new javax.swing.GroupLayout(Attendence);
        Attendence.setLayout(AttendenceLayout);
        AttendenceLayout.setHorizontalGroup(
            AttendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AttendenceLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(analyticalL, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AttendenceLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AttendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AttendenceLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(AttendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AttendenceLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(ef2Attendence, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AttendenceLayout.createSequentialGroup()
                        .addComponent(ADate, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(536, 536, 536)
                        .addComponent(Load, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );
        AttendenceLayout.setVerticalGroup(
            AttendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AttendenceLayout.createSequentialGroup()
                .addComponent(analyticalL, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(AttendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AttendenceLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Load))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AttendenceLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AttendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ADate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ef2Attendence, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Add)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        tab.addTab("", Attendence);

        Attendence1.setBackground(new java.awt.Color(0, 0, 0));

        analyticalL2.setFont(new java.awt.Font("Yu Gothic Light", 1, 36)); // NOI18N
        analyticalL2.setForeground(new java.awt.Color(255, 255, 255));
        analyticalL2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        analyticalL2.setText("Attendence");
        analyticalL2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ATable1.setBackground(new java.awt.Color(0, 0, 0));
        ATable1.setForeground(new java.awt.Color(255, 255, 255));
        ATable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emloye Name", "Designation", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ATable1.setSelectionBackground(new java.awt.Color(0, 0, 0));
        ATable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(ATable1);
        if (ATable1.getColumnModel().getColumnCount() > 0) {
            ATable1.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(jComboBox2));
        }

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Date");

        Add1.setBackground(new java.awt.Color(102, 153, 255));
        Add1.setText("Add");
        Add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add1ActionPerformed(evt);
            }
        });

        jComboBox2.setBackground(new java.awt.Color(0, 0, 0));
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Present", "Absent", "Leave" }));

        Back.setBackground(new java.awt.Color(102, 153, 255));
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel21.setText("jLabel21");

        ef3Attendence.setForeground(new java.awt.Color(255, 0, 102));

        javax.swing.GroupLayout Attendence1Layout = new javax.swing.GroupLayout(Attendence1);
        Attendence1.setLayout(Attendence1Layout);
        Attendence1Layout.setHorizontalGroup(
            Attendence1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Attendence1Layout.createSequentialGroup()
                .addGroup(Attendence1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Attendence1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Attendence1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addGroup(Attendence1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(Attendence1Layout.createSequentialGroup()
                                .addComponent(ef3Attendence, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(ADate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(533, 533, 533)
                        .addComponent(Add1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addGap(21, 21, 21))
            .addGroup(Attendence1Layout.createSequentialGroup()
                .addGroup(Attendence1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Attendence1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(analyticalL2, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Attendence1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Attendence1Layout.setVerticalGroup(
            Attendence1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Attendence1Layout.createSequentialGroup()
                .addComponent(analyticalL2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(Attendence1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(Add1)
                    .addComponent(ADate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(Attendence1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Attendence1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel21))
                    .addGroup(Attendence1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ef3Attendence)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Attendence1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Back))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab.addTab("", Attendence1);

        javax.swing.GroupLayout TabbedPanelLayout = new javax.swing.GroupLayout(TabbedPanel);
        TabbedPanel.setLayout(TabbedPanelLayout);
        TabbedPanelLayout.setHorizontalGroup(
            TabbedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabbedPanelLayout.createSequentialGroup()
                .addComponent(optionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tab)
                .addContainerGap())
        );
        TabbedPanelLayout.setVerticalGroup(
            TabbedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabbedPanelLayout.createSequentialGroup()
                .addGroup(TabbedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optionPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
        
        tab.setSelectedIndex(3);
        
        DisplayEmployees();
        Date date1 = new Date();  
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
        String strDate = dateFormat.format(date1);
        ADate1.setDate(date1);
        

       
    }//GEN-LAST:event_AddActionPerformed

    private void LoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadActionPerformed
        // TODO add your handling code here:
       DisplayDateAttendence();
       
    }//GEN-LAST:event_LoadActionPerformed

    private void EmpNametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpNametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpNametxtActionPerformed

    private void EmpCnictxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpCnictxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpCnictxtActionPerformed

    private void EmpSalarytxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpSalarytxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpSalarytxtActionPerformed

    private void EmpLiscensetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpLiscensetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpLiscensetxtActionPerformed

    private void editBtnEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnEmpActionPerformed
        // TODO add your handling code here:
        try
        {

            if(EmpNametxt.getText().equals("") || EmpCnictxt.getText().equals("") || (EmpDesignationtxt.getText().equals("") &&  EmpLiscensetxt.getText().equals(""))|| EmpSalarytxt.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Enter Employee to be updated ");
            }
            else if((EmpDesignationtxt.getText().toLowerCase()).equals("driver") && EmpLiscensetxt.getText().equals("") )
            {
                JOptionPane.showMessageDialog(this, "Enter the Liscense No of the Driver ");
            }
            else
            {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                String cnic =  EmpCnictxt.getText();
                String sqlQuery;
                if((EmpDesignationtxt.getText().toLowerCase()).equals("driver"))
                {
                    sqlQuery = "Update management.Employees set EmpName='"+EmpNametxt.getText()+"', designation='"+EmpDesignationtxt.getText()+"' ,salary='"+Integer.valueOf(EmpSalarytxt.getText()) +"' ,LisenceNo ='"+EmpLiscensetxt.getText() +"' where CNIC ='"+cnic+"'";
                }
                else
                {

                    sqlQuery = "Update management.Employees set EmpName='"+EmpNametxt.getText()+"', designation='"+EmpDesignationtxt.getText()+"' ,salary='"+Integer.valueOf(EmpSalarytxt.getText()) +"' ,LisenceNo ='"+null +"' where CNIC ='"+cnic+"'";

                }

                Statement st = Con.createStatement();
                st.executeUpdate(sqlQuery);
                JOptionPane.showMessageDialog(this, "Employee updated Successfully");
                DisplayEmployeesE();

            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Employee editing failed");
           // e.printStackTrace();
        }
    }//GEN-LAST:event_editBtnEmpActionPerformed

    private void saveBtnEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnEmpActionPerformed
        // TODO add your handling code here:
        try
        {
            if(EmpNametxt.getText().equals("") || EmpCnictxt.getText().equals("") || (EmpDesignationtxt.getText().equals("") &&  EmpLiscensetxt.getText().equals(""))|| EmpSalarytxt.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Error: All Feilds Should be filled ");
            }
            else if((EmpDesignationtxt.getText().toLowerCase()).equals("driver") && EmpLiscensetxt.getText().equals("") )
            {
                JOptionPane.showMessageDialog(this, "Enter the Liscense No of the Driver ");
            }
            else
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                PreparedStatement add = Con.prepareStatement("insert into Employees values (?,?,?,?,?)");

                add.setString(1, EmpNametxt.getText());
                add.setString(2, EmpCnictxt.getText());
                add.setString(3, EmpDesignationtxt.getText());
                add.setInt(4,Integer.valueOf(EmpSalarytxt.getText()));
                add.setString(5, EmpLiscensetxt.getText());
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Employee added Successfully");
                DisplayEmployeesE();
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Employee adding failed");
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveBtnEmpActionPerformed

    private void resetBtnEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnEmpActionPerformed
        // TODO add your handling code here:
        Ereset();
    }//GEN-LAST:event_resetBtnEmpActionPerformed

    private void deleteBtnEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnEmpActionPerformed
        // TODO add your handling code here:
        try
        {

            if(EmpCnictxt.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Select any employee to be deleted ");
            }
            else
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                String cnic =  EmpCnictxt.getText();
                String sqlQuery = "Delete from management.Employees"+" where CNIC ='"+cnic+"'";
                Statement st = Con.createStatement();
                st.executeUpdate(sqlQuery);
                JOptionPane.showMessageDialog(this, "Employee Deleted Successfully");
                DisplayEmployeesE();
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Employee deleting failed");
            //e.printStackTrace();
        }
    }//GEN-LAST:event_deleteBtnEmpActionPerformed

    private void EmployeesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeesTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)EmployeesTable.getModel();
        int rowIndex = EmployeesTable.getSelectedRow();
        EmpNametxt.setText(model.getValueAt(rowIndex, 0).toString());
        EmpCnictxt.setText(model.getValueAt(rowIndex, 1).toString());
        EmpDesignationtxt.setText(model.getValueAt(rowIndex, 2).toString());
        EmpSalarytxt.setText(model.getValueAt(rowIndex, 3).toString());
        EmpLiscensetxt.setText(model.getValueAt(rowIndex, 4).toString());

    }//GEN-LAST:event_EmployeesTableMouseClicked

    private void EmpDesignationtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpDesignationtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpDesignationtxtActionPerformed

    private void totalCarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalCarsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalCarsActionPerformed

    private void SoldCarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoldCarsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SoldCarsActionPerformed

    private void availableCarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availableCarsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_availableCarsActionPerformed

    private void soldPercentageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soldPercentageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soldPercentageActionPerformed

    private void totalForRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalForRentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalForRentActionPerformed

    private void rentCarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentCarsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rentCarsActionPerformed

    private void rentAvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentAvailableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rentAvailableActionPerformed

    private void rentPercentageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentPercentageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rentPercentageActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //pie
        String sold = SoldCars.getText();
        String aval = availableCars.getText();

        int s =  Integer.parseInt(sold);
        int a =  Integer.parseInt(aval);

        JFrame frame = new JFrame();
        frame.getContentPane().add(new MyComponent(s,a));
        frame.setSize(300, 200);
        frame.setVisible(true);
        
        red.setVisible(true);
        sold_.setVisible(true);
        aval_.setVisible(true);
        blue.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        String rent = rentCars.getText();
        String ava = rentAvailable.getText();

        int r =  Integer.parseInt(rent);
        int a =  Integer.parseInt(ava);

        JFrame frame2 = new JFrame();
        frame2.getContentPane().add(new MyComponent2(r,a));
        frame2.setSize(300, 200);
        frame2.setVisible(true);
        
        red1.setVisible(true);
        rented_.setVisible(true);
        aval_1.setVisible(true);
        blue1.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void attendLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attendLMouseClicked
        // TODO add your handling code here:
        tab.setSelectedIndex(2);
        
        
    }//GEN-LAST:event_attendLMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        tab.setSelectedIndex(0);
        DisplayEmployeesE();
    }//GEN-LAST:event_jLabel1MouseClicked

    
    public void viewAnalytics()
    {
        try
        {
            int soldCount = 0;
            int rentCount = 0;
            int totalCount = 0;
            int Available =0 ;
            String str = "Booked";
            String str2 = "Sold Out";
            
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
            st =  Con.createStatement();
            ResultSet rs2 = null;
            ResultSet rs1 = null;
            ResultSet rs3 = null;
            rs2 = st.executeQuery("Select * from RentCars");
            while(rs2.next())
            {
               totalCount++; 
            }
            rs = st.executeQuery("Select * from RentCars where BookingStatus='"+ str+"'");
            while(rs.next())
            {
               rentCount++; 
            }
            Available = totalCount - rentCount;
            totalForRent.setText(totalCount + "");
            rentAvailable.setText(Available + "");
            rentCars.setText(rentCount + "");
            float percentage = 0;
            if(totalCount > 0)
            {
                percentage = (rentCount*100)/(totalCount);
            }
            else
            {
                percentage = 0;
            }
            
            rentPercentage.setText(percentage + "%");
            totalCount = 0;
            rs3 = st.executeQuery("Select * from CarTbl");
            while(rs3.next())
            {
               totalCount++; 
            }
            rs1 = st.executeQuery("Select * from CarTbl where Status='"+ str2 +"'");
            while(rs1.next())
            {
               soldCount++; 
            }
            Available = totalCount - soldCount;
            totalCars.setText(totalCount + "");
            SoldCars.setText(soldCount+"");
            availableCars.setText(Available + "");
            if(totalCount > 0)
            {
                percentage = (soldCount*100)/(totalCount);
            }
            else
            {
                percentage = 0;
            }
            soldPercentage.setText(percentage + "");
            
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public JPanel getPanel()
     {
     return TabbedPanel;
     }
    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
        
       tab.setSelectedIndex(1);
        viewAnalytics();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void logoutBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBActionPerformed
        dispose();
        MainPage frame = new MainPage();

       
        frame.setContentPane(frame.getPanel());
        frame.setSize(1050,820);
        frame.setResizable(false);
        frame.setVisible(true);
                



        // TODO add your handling code here:
    }//GEN-LAST:event_logoutBActionPerformed

    private void Add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add1ActionPerformed
        // TODO add your handling code here:
         try
        {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
            PreparedStatement add = Con.prepareStatement("insert into Attendence values (?,?,?,?)");

            DefaultTableModel model = (DefaultTableModel) ATable1.getModel();
            String strDate;
            Date date = ADate1.getDate();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            strDate = dateFormat.format(date);

            for(int i=0;i<model.getRowCount();i++){

                String empName=model.getValueAt(i, 0).toString();
                String designation =model.getValueAt(i,1 ).toString();
                String status=model.getValueAt(i, 2).toString();

                add.setString(1, empName);
                add.setString(2, designation);
                add.setString(3, strDate);
                add.setString(4, status);

                int row = add.executeUpdate();

            }
            JOptionPane.showMessageDialog(this, "Attendence added Successfully");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Attendence already exists");
        }
    }//GEN-LAST:event_Add1ActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        tab.setSelectedIndex(2);
    }//GEN-LAST:event_BackActionPerformed

    private void SearchTxtESearchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTxtESearchTxtActionPerformed
        DisplayEmployeesE();
    }//GEN-LAST:event_SearchTxtESearchTxtActionPerformed

    private void SearchbtnESearchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchbtnESearchbtnActionPerformed
        // TODO add your handling code here:
        DisplayEmployeesE();
        SearchTxtE.setText("");
    }//GEN-LAST:event_SearchbtnESearchbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }
    public String checkSave(String n,String c , String d,String s,String l )
   {
      String check = "false";
        try
        {
             
            if(n.equals("") || c.equals("") || (d.equals("") &&  s.equals(""))|| l.equals(""))
            {
                check="";
              //  JOptionPane.showMessageDialog(this, "Error: All Feilds Should be filled ");
            }
            else if((d.toLowerCase()).equals("driver") && l.equals("") )
            {
                //JOptionPane.showMessageDialog(this, "Enter the Liscense No of the Driver ");
            }
            else
            {
                Class.forName("com.mysql.cj.jdbc.Driver");

                 Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                PreparedStatement add = Con.prepareStatement("insert into Employees values (?,?,?,?,?)");

                add.setString(1,n);
                add.setString(2,c);
                add.setString(3, d);
                add.setInt(4,Integer.valueOf(s));
                add.setString(5, l);
                int row = add.executeUpdate();
                System.out.print("here i am "+row);
                if(row>=0)
                {
                  
                    check = "true";
                }
               
                    
             //   JOptionPane.showMessageDialog(this, "Employee added Successfully");
             //   DisplayEmployees();
            }

        }
        catch (ClassNotFoundException | NumberFormatException | SQLException e)
        {
           // JOptionPane.showMessageDialog(this, "Employee adding failed");
            //e.printStackTrace();
        }
        return check;
       
   }
    public String checkEdit(String n,String c , String d,String s,String l )
    {
        String check = "";
         try
        {

            if(n.equals("") || n.equals("") || (d.equals("") &&  l.equals(""))|| s.equals(""))
            {
                check  = "";
               // JOptionPane.showMessageDialog(this, "Enter Employee to be updated ");
            }
            else if((EmpDesignationtxt.getText().toLowerCase()).equals("driver") && EmpLiscensetxt.getText().equals("") )
            {
                //JOptionPane.showMessageDialog(this, "Enter the Liscense No of the Driver ");
            }
            else
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                String cnic =  c;
                String sqlQuery;
                if((d.toLowerCase()).equals("driver"))
                {
                    sqlQuery = "Update management.Employees set EmpName='"+n+"', designation='"+d+"' ,salary='"+Integer.valueOf(s)+"' ,LisenceNo ='"+l+"' where CNIC ='"+cnic+"'";
                }
                else
                {

                    sqlQuery = "Update management.Employees set EmpName='"+n+"', designation='"+d+"' ,salary='"+Integer.valueOf(s) +"' ,LisenceNo ='"+null +"' where CNIC ='"+cnic+"'";

                }

                Statement st = Con.createStatement();
              int row =  st.executeUpdate(sqlQuery);
                //JOptionPane.showMessageDialog(this, "Employee updated Successfully");
                //DisplayEmployees();
                 if(row>0)
                {
                  
                    check = "true";
                }
                else{
                    check = "false";
                }

            }

        }
        catch (Exception e)
        {
           // JOptionPane.showMessageDialog(this, "Customer editing failed");
            e.printStackTrace();
        }
        return check;
    }
    
    public String checkDelete(String c)
    {
        String check = "";
         try
        {

            if(c.equals(""))
            {
                check = "";
                //JOptionPane.showMessageDialog(this, "Select any employee to be deleted ");
            }
            else
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                String cnic =  c;
                String sqlQuery = "Delete from management.Employees"+" where CNIC ='"+cnic+"'";
                Statement st = Con.createStatement();
               int row =  st.executeUpdate(sqlQuery);
//                JOptionPane.showMessageDialog(this, "Employee Deleted Successfully");
//                DisplayEmployees();
                      if(row>0)
                {
                  
                    check = "true";
                }
                else{
                    check = "false";
                }
            }

        }
        catch (Exception e)
        {
//            JOptionPane.showMessageDialog(this, "failed");
//            e.printStackTrace();
        }
         return check;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser ADate;
    private com.toedter.calendar.JDateChooser ADate1;
    private javax.swing.JTable ATable;
    private javax.swing.JTable ATable1;
    private javax.swing.JButton Add;
    private javax.swing.JButton Add1;
    private javax.swing.JPanel Analytics;
    private javax.swing.JPanel Attendence;
    private javax.swing.JPanel Attendence1;
    private javax.swing.JButton Back;
    private javax.swing.JTextField EmpCnictxt;
    private javax.swing.JTextField EmpDesignationtxt;
    private javax.swing.JTextField EmpLiscensetxt;
    private javax.swing.JTextField EmpNametxt;
    private javax.swing.JTextField EmpSalarytxt;
    private javax.swing.JPanel Employees;
    private javax.swing.JTable EmployeesTable;
    private javax.swing.JButton Load;
    private javax.swing.JLabel ScarLabel;
    private javax.swing.JLabel Search;
    private javax.swing.JTextField SearchTxtE;
    private javax.swing.JButton SearchbtnE;
    private javax.swing.JTextField SoldCars;
    private javax.swing.JPanel TabbedPanel;
    private javax.swing.JLabel aPageL;
    private javax.swing.JLabel analyticalL;
    private javax.swing.JLabel analyticalL1;
    private javax.swing.JLabel analyticalL2;
    private javax.swing.JLabel attendL;
    private javax.swing.JTextField availableCars;
    private javax.swing.JLabel aval_;
    private javax.swing.JLabel aval_1;
    private javax.swing.JButton blue;
    private javax.swing.JButton blue1;
    private javax.swing.JButton deleteBtnEmp;
    private javax.swing.JButton editBtnEmp;
    private javax.swing.JLabel ef2Attendence;
    private javax.swing.JLabel ef3Attendence;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton logoutB;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JButton red;
    private javax.swing.JButton red1;
    private javax.swing.JTextField rentAvailable;
    private javax.swing.JTextField rentCars;
    private javax.swing.JLabel rentL;
    private javax.swing.JTextField rentPercentage;
    private javax.swing.JLabel rented_;
    private javax.swing.JButton resetBtnEmp;
    private javax.swing.JButton saveBtnEmp;
    private javax.swing.JTextField soldPercentage;
    private javax.swing.JLabel sold_;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTextField totalCars;
    private javax.swing.JTextField totalForRent;
    // End of variables declaration//GEN-END:variables
}
