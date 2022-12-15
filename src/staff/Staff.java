/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package staff;

import Login.MainPage;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author hamiz
 */
public class Staff extends javax.swing.JFrame {

    Connection Con = null;
    Statement st = null;
    ResultSet rs = null;
    public PreparedStatement pst;
    Date date;
    Date nextDate;
    /**
     * Creates new form Tabbed3
     */
    public Staff() 
    {
        initComponents();
        tab9.setSelectedIndex(0);
        RDisplayCars();
        this.date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String str = formatter.format(date);
        
        
        
    }

    private void Mreset()
    {
        regNoTxtM.setText("");
        LastDateMan.setDate(date);
        nextDateMan.setDate(date);
    }
    
    public void DisplayRecord()
    {
        try
        {
//            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
//            st =  Con.createStatement();
            
             Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
            st =  Con.createStatement();
            
           
            if(searchtct.getText().equals(""))
            {
                rs = st.executeQuery("Select * from maintainRec");
            }
            else
            {
                rs = st.executeQuery("Select * from maintainRec where RegNo like '"+searchtct.getText()+"%'");
            }
            DefaultTableModel model = (DefaultTableModel) MainRec.getModel();
            model.setRowCount(0);
            while(rs.next())
            {
                String regNo = rs.getString("RegNo");
                String LastDate_ = rs.getString("LastMaintained");
                String NextDate__ = rs.getString("NextMaintain");
                String tbData[] = {regNo, LastDate_, NextDate__ };
                model.addRow(tbData);
                
                
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void SDisplayCars()
    {
        try
        {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
            st =  Con.createStatement();
            if(searchTxt.getText().equals("")){
              rs = st.executeQuery("Select * from CarTbl");
            }
            else
            {
                rs = st.executeQuery("Select * from management.CarTbl where Model like '"+searchTxt.getText()+"%'");
            }
            
            DefaultTableModel model = (DefaultTableModel) CarTable.getModel();
            model.setRowCount(0);
            while(rs.next())
            {
                String regNo = rs.getString("RegNum");
                String brand_ = rs.getString("Brand");
                String model_ = rs.getString("Model");
                String status_ = rs.getString("Status");
                String price_ = rs.getString("Price");
                
                String tbData[] = {regNo, brand_, model_ , status_ , price_};
                model.addRow(tbData);
                
                
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void RDisplayCars()
    {
        try
        {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
            st =  Con.createStatement();
            
            if(SearchTxtR.getText().equals("")){
              rs = st.executeQuery("Select * from RentCars");
            }
            else
            {
                rs = st.executeQuery("Select * from management.RentCars where Model like '"+SearchTxtR.getText()+"%'");
            }
            
            DefaultTableModel model = (DefaultTableModel) RentCarsT.getModel();
            model.setRowCount(0);
            while(rs.next())
            {
                String regNo = rs.getString("RegNum");
                String brand_ = rs.getString("Brand");
                String model_ = rs.getString("Model");
                String status_ = rs.getString("BookingStatus");
                String price_ = rs.getString("BookingPrice");
                
                String tbData[] = {regNo, brand_, model_ , status_ , price_};
                model.addRow(tbData);
                
                
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
        
   private void Rreset()
    {
        regNoTxtR.setText("");
        modelNotxtR.setText("");
        brandNametxtR.setText("");
        BookingStatusComboBoxR.setSelectedItem(0);
        pricetxtR.setText("");
        
    }
   private void Sreset()
    {
        regNoTxtS.setText("");
        modelNotxtS.setText("");
        brandNametxtS.setText("");
        statusComboBox.setSelectedItem(0);
        pricetxtS.setText("");
        
    }
   private void Creset()
    {
        CusNametxtCus.setText("");
        CusAdresstxt.setText("");
        CusCnictxt.setText("");
        CusPhonetxt.setText("");
        
    }
   public void DisplayCustomers() 
    {
        try
        {
            
           
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
            st =  Con.createStatement();
             if(SearchTxtC.getText().equals("")){
              rs = st.executeQuery("Select * from Customers");
            }
            else
            {
                rs = st.executeQuery("Select * from management.Customers where CusName like '"+SearchTxtC.getText()+"%'");
            }
           
            DefaultTableModel model = (DefaultTableModel) CustomersTable.getModel();
            model.setRowCount(0);
            while(rs.next())
            {
                String name = rs.getString("CusName");
                String cnic_ = rs.getString("CNIC");
                String address_ = rs.getString("address");
                String phone_ = rs.getString("Phone");
   
                
                String tbData[] = {name, cnic_, address_ , phone_};
                model.addRow(tbData);
                
                
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
   public void DisplayComplaints() 
    {
        try
        {
            
           
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
            st =  Con.createStatement();
            rs = st.executeQuery("Select * from Complaint");
            DefaultTableModel model = (DefaultTableModel) ComplaintsTable.getModel();
            model.setRowCount(0);
            while(rs.next())
            {
                String name = rs.getString("CusName");
                String Date = rs.getString("BookingDate");
                String reg = rs.getString("RegNo");
                String DriverName = rs.getString("DriverName");
                String complaint = rs.getString("complaint_");
   
                
                String tbData[] = {name,Date , reg , DriverName, complaint };
                model.addRow(tbData);
                
                
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        logoutB = new javax.swing.JButton();
        panel3 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        logoutB1 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tab9 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        brandNametxtR = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        RentCarsT = new javax.swing.JTable();
        modelNotxtR = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        pricetxtR = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        BookingStatusComboBoxR = new javax.swing.JComboBox<>();
        editbtn8 = new javax.swing.JButton();
        savebtn8 = new javax.swing.JButton();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        regNoTxtR = new javax.swing.JTextField();
        resetbtn8 = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        deletebtn8 = new javax.swing.JButton();
        AvailablebtnR = new javax.swing.JButton();
        jLabel89 = new javax.swing.JLabel();
        SearchTxtR = new javax.swing.JTextField();
        Searchbtn6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        savebtn1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        CarTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        modelNotxtS = new javax.swing.JTextField();
        regNoTxtS = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        resetbtn1 = new javax.swing.JButton();
        pricetxtS = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        deletebtn1 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox<>();
        brandNametxtS = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        editbtn1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        searchTxt = new javax.swing.JTextField();
        searchbtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        CusNametxtC = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        DriverNametxtC = new javax.swing.JTextField();
        RegCartxtC = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ComplainttxtC = new javax.swing.JTextArea();
        Enterbtn = new javax.swing.JButton();
        BookingDatetxtC = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        MainRec = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        editbtn2 = new javax.swing.JButton();
        savebtn2 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        regNoTxtM = new javax.swing.JTextField();
        resetbtn2 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        deletebtn2 = new javax.swing.JButton();
        LastDateMan = new com.toedter.calendar.JDateChooser();
        nextDateMan = new com.toedter.calendar.JDateChooser();
        searchbtn1 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        searchtct = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ComplaintsTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CusNametxtCus = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CusCnictxt = new javax.swing.JTextField();
        CusAdresstxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CusPhonetxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        editBtnCus = new javax.swing.JButton();
        saveBtnCus = new javax.swing.JButton();
        ResetBtnCus = new javax.swing.JButton();
        deleteBtnCus = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CustomersTable = new javax.swing.JTable();
        SearchC = new javax.swing.JLabel();
        SearchTxtC = new javax.swing.JTextField();
        SearchbtnC = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(153, 0, 102));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Sale A Car");
        jLabel10.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Rent A Car");
        jLabel11.setToolTipText("");

        jLabel12.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Complaints");
        jLabel12.setToolTipText("");

        logoutB.setBackground(new java.awt.Color(153, 0, 102));
        logoutB.setForeground(java.awt.Color.white);
        logoutB.setText("Log Out");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(logoutB)))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(24, 24, 24)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutB)
                .addGap(16, 16, 16))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel3.setBackground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Sale A Car");
        jLabel13.setToolTipText("");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("View Complaints");
        jLabel15.setToolTipText("");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        logoutB1.setBackground(new java.awt.Color(0, 0, 0));
        logoutB1.setForeground(java.awt.Color.white);
        logoutB1.setText("Log Out");
        logoutB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutB1ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Rent A Car");
        jLabel39.setToolTipText("");
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Maintainace Record");
        jLabel41.setToolTipText("");
        jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel41MouseClicked(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Customers");
        jLabel42.setToolTipText("");
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/staff/GURUS.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel16.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        jLabel16.setText("Staff Page");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel41)))
                .addContainerGap(7, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logoutB1)
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addGap(36, 36, 36)
                .addComponent(jLabel39)
                .addGap(30, 30, 30)
                .addComponent(jLabel13)
                .addGap(30, 30, 30)
                .addComponent(jLabel42)
                .addGap(31, 31, 31)
                .addComponent(jLabel15)
                .addGap(28, 28, 28)
                .addComponent(jLabel41)
                .addGap(29, 29, 29)
                .addComponent(logoutB1)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        tab9.setBackground(new java.awt.Color(0, 0, 0));
        tab9.setBorder(javax.swing.BorderFactory.createEmptyBorder(-3, -3, -30, -3));
        tab9.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel15.setBackground(new java.awt.Color(0, 0, 0));

        brandNametxtR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandNametxtRbrandNametxtActionPerformed(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("Car List");
        jLabel82.setToolTipText("");

        RentCarsT.setBackground(new java.awt.Color(0, 0, 0));
        RentCarsT.setForeground(new java.awt.Color(255, 255, 255));
        RentCarsT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Registration No", "Brand", "Model", "Status", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        RentCarsT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RentCarsTRentCarsMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(RentCarsT);

        modelNotxtR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelNotxtRmodelNotxtActionPerformed(evt);
            }
        });

        jLabel83.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("Price");
        jLabel83.setToolTipText("");

        pricetxtR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pricetxtRpricetxtActionPerformed(evt);
            }
        });

        jLabel84.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("Model");
        jLabel84.setToolTipText("");

        jLabel85.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("Bookin Status");
        jLabel85.setToolTipText("");

        BookingStatusComboBoxR.setFont(new java.awt.Font("Californian FB", 0, 12)); // NOI18N
        BookingStatusComboBoxR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Booked" }));
        BookingStatusComboBoxR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookingStatusComboBoxRBookingStatusComboBoxActionPerformed(evt);
            }
        });

        editbtn8.setBackground(new java.awt.Color(102, 153, 255));
        editbtn8.setText("Edit");
        editbtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtn8editbtnActionPerformed(evt);
            }
        });

        savebtn8.setBackground(new java.awt.Color(102, 153, 255));
        savebtn8.setText("Save");
        savebtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtn8savebtnActionPerformed(evt);
            }
        });

        jLabel86.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("Rent A Car");
        jLabel86.setToolTipText("");

        jLabel87.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setText("Registration No");
        jLabel87.setToolTipText("");

        regNoTxtR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regNoTxtRregNoTxtActionPerformed(evt);
            }
        });

        resetbtn8.setBackground(new java.awt.Color(102, 153, 255));
        resetbtn8.setText("Reset");
        resetbtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtn8resetbtnActionPerformed(evt);
            }
        });

        jLabel88.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("Brand");
        jLabel88.setToolTipText("");

        deletebtn8.setBackground(new java.awt.Color(102, 153, 255));
        deletebtn8.setText("Delete");
        deletebtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtn8deletebtnActionPerformed(evt);
            }
        });

        AvailablebtnR.setBackground(new java.awt.Color(102, 153, 255));
        AvailablebtnR.setText("Available Cars");
        AvailablebtnR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvailablebtnRAvailablebtnActionPerformed(evt);
            }
        });

        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText("Search By Model:");

        SearchTxtR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTxtRSearchTxtActionPerformed(evt);
            }
        });

        Searchbtn6.setBackground(new java.awt.Color(102, 153, 255));
        Searchbtn6.setText("Search");
        Searchbtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Searchbtn6SearchbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(savebtn8, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editbtn8, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deletebtn8, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resetbtn8, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addGap(74, 74, 74))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(regNoTxtR, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(brandNametxtR, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modelNotxtR, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addComponent(jLabel84, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BookingStatusComboBoxR, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pricetxtR, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12)
                .addContainerGap())
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AvailablebtnR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel89)
                .addGap(18, 18, 18)
                .addComponent(SearchTxtR, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Searchbtn6)
                .addGap(31, 31, 31))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(jLabel88)
                    .addComponent(jLabel84)
                    .addComponent(jLabel83)
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regNoTxtR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandNametxtR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelNotxtR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BookingStatusComboBoxR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pricetxtR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savebtn8)
                    .addComponent(editbtn8)
                    .addComponent(deletebtn8)
                    .addComponent(resetbtn8))
                .addGap(49, 49, 49)
                .addComponent(jLabel82)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AvailablebtnR)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel89)
                        .addComponent(SearchTxtR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Searchbtn6)))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        tab9.addTab("tab1", jPanel15);

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        savebtn1.setBackground(new java.awt.Color(102, 153, 255));
        savebtn1.setText("Save");
        savebtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtn1ActionPerformed(evt);
            }
        });

        CarTable.setBackground(new java.awt.Color(0, 0, 0));
        CarTable.setForeground(new java.awt.Color(255, 255, 255));
        CarTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Registration No", "Brand", "Model", "Status", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CarTable.setSelectionBackground(new java.awt.Color(102, 153, 255));
        CarTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CarTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(CarTable);

        jLabel6.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Sell A Car");
        jLabel6.setToolTipText("");

        jLabel19.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Registration No");
        jLabel19.setToolTipText("");

        modelNotxtS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelNotxtSActionPerformed(evt);
            }
        });

        regNoTxtS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regNoTxtSActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Price");
        jLabel20.setToolTipText("");

        resetbtn1.setBackground(new java.awt.Color(102, 153, 255));
        resetbtn1.setText("Reset");
        resetbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtn1ActionPerformed(evt);
            }
        });

        pricetxtS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pricetxtSActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Brand");
        jLabel21.setToolTipText("");

        jLabel22.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Model");
        jLabel22.setToolTipText("");

        deletebtn1.setBackground(new java.awt.Color(102, 153, 255));
        deletebtn1.setText("Delete");
        deletebtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtn1ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Selling Status");
        jLabel23.setToolTipText("");

        statusComboBox.setFont(new java.awt.Font("Californian FB", 0, 12)); // NOI18N
        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Sold Out" }));
        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboBoxActionPerformed(evt);
            }
        });

        brandNametxtS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandNametxtSActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Car List");
        jLabel24.setToolTipText("");

        editbtn1.setBackground(new java.awt.Color(102, 153, 255));
        editbtn1.setText("Edit");
        editbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtn1ActionPerformed(evt);
            }
        });

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Search by Model:");

        searchTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTxtActionPerformed(evt);
            }
        });

        searchbtn.setBackground(new java.awt.Color(102, 153, 255));
        searchbtn.setText("Search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 153, 255));
        jButton1.setText("Available Cars");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(savebtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editbtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deletebtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(resetbtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(74, 74, 74))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(regNoTxtS)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(brandNametxtS, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modelNotxtS, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                    .addComponent(statusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pricetxtS, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchbtn)))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel20)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regNoTxtS, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandNametxtS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelNotxtS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pricetxtS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savebtn1)
                    .addComponent(editbtn1)
                    .addComponent(deletebtn1)
                    .addComponent(resetbtn1))
                .addGap(18, 18, 18)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchbtn)
                        .addComponent(jButton1))
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        tab9.addTab("tab2", jPanel5);

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        jLabel18.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Customer Complaint");
        jLabel18.setToolTipText("");

        jLabel27.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Booking Date");
        jLabel27.setToolTipText("");

        CusNametxtC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CusNametxtCActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Customer Name");
        jLabel28.setToolTipText("");

        jLabel29.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Driver Name");
        jLabel29.setToolTipText("");

        jLabel30.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Car Registration No.");
        jLabel30.setToolTipText("");

        DriverNametxtC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DriverNametxtCActionPerformed(evt);
            }
        });

        RegCartxtC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegCartxtCActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Complaint");
        jLabel31.setToolTipText("");

        ComplainttxtC.setColumns(20);
        ComplainttxtC.setRows(5);
        jScrollPane4.setViewportView(ComplainttxtC);

        Enterbtn.setBackground(new java.awt.Color(102, 153, 255));
        Enterbtn.setText("Enter Compaint");
        Enterbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel28)
                            .addComponent(jLabel27)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CusNametxtC)
                            .addComponent(DriverNametxtC, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(RegCartxtC)
                            .addComponent(BookingDatetxtC, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))))
                .addGap(166, 166, 166))
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Enterbtn)
                .addGap(367, 367, 367))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(CusNametxtC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27)
                    .addComponent(BookingDatetxtC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(RegCartxtC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(DriverNametxtC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(Enterbtn)
                .addGap(87, 87, 87))
        );

        tab9.addTab("tab4", jPanel7);

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        jLabel33.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("History");
        jLabel33.setToolTipText("");

        MainRec.setBackground(new java.awt.Color(0, 0, 0));
        MainRec.setForeground(new java.awt.Color(255, 255, 255));
        MainRec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Registration No", "Last Maintained", "Next Tentative Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MainRec.setGridColor(new java.awt.Color(255, 255, 255));
        MainRec.setSelectionBackground(new java.awt.Color(102, 153, 255));
        MainRec.setSelectionForeground(new java.awt.Color(255, 255, 255));
        MainRec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainRecMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(MainRec);

        jLabel34.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Tentative Next Maintanance");
        jLabel34.setToolTipText("");

        editbtn2.setBackground(new java.awt.Color(102, 153, 255));
        editbtn2.setText("Edit");
        editbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtn2ActionPerformed(evt);
            }
        });

        savebtn2.setBackground(new java.awt.Color(102, 153, 255));
        savebtn2.setText("Save");
        savebtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtn2ActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Mantainance Record");
        jLabel35.setToolTipText("");

        jLabel36.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Registration No");
        jLabel36.setToolTipText("");

        regNoTxtM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regNoTxtMActionPerformed(evt);
            }
        });

        resetbtn2.setBackground(new java.awt.Color(102, 153, 255));
        resetbtn2.setText("Reset");
        resetbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtn2ActionPerformed(evt);
            }
        });

        jLabel37.setBackground(new java.awt.Color(102, 153, 255));
        jLabel37.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Last Maintained");
        jLabel37.setToolTipText("");

        deletebtn2.setBackground(new java.awt.Color(102, 153, 255));
        deletebtn2.setText("Delete");
        deletebtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtn2ActionPerformed(evt);
            }
        });

        searchbtn1.setBackground(new java.awt.Color(102, 153, 255));
        searchbtn1.setText("Search");
        searchbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtn1ActionPerformed(evt);
            }
        });

        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Registration No:");

        searchtct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchtctActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(savebtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editbtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deletebtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resetbtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(74, 74, 74))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 590, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchtct, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchbtn1)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(regNoTxtM, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(LastDateMan, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(nextDateMan, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 121, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36)
                        .addComponent(jLabel37)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LastDateMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextDateMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regNoTxtM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savebtn2)
                    .addComponent(editbtn2)
                    .addComponent(deletebtn2)
                    .addComponent(resetbtn2))
                .addGap(18, 18, 18)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchbtn1)
                    .addComponent(jLabel38)
                    .addComponent(searchtct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tab9.addTab("tab6", jPanel8);

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        jLabel17.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Customer Complaints");
        jLabel17.setToolTipText("");

        ComplaintsTable.setBackground(new java.awt.Color(0, 0, 0));
        ComplaintsTable.setForeground(new java.awt.Color(255, 255, 255));
        ComplaintsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Booking Date", "Car Registration No.", "Driver Name", "Complaint"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ComplaintsTable.setSelectionBackground(new java.awt.Color(102, 153, 255));
        ComplaintsTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(ComplaintsTable);

        jButton2.setBackground(new java.awt.Color(102, 153, 255));
        jButton2.setText("Enter Compaint");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Filter By:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188)))
                .addGap(38, 145, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(180, Short.MAX_VALUE))
        );

        tab9.addTab("tab3", jPanel6);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Manage Customers");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Customer Name");
        jLabel4.setToolTipText("");

        CusNametxtCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CusNametxtCusActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CNIC No.");
        jLabel5.setToolTipText("");

        CusCnictxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CusCnictxtActionPerformed(evt);
            }
        });

        CusAdresstxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CusAdresstxtActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Phone No.");
        jLabel7.setToolTipText("");

        CusPhonetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CusPhonetxtActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Address");
        jLabel8.setToolTipText("");

        editBtnCus.setBackground(new java.awt.Color(102, 153, 255));
        editBtnCus.setText("Edit");
        editBtnCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnCusActionPerformed(evt);
            }
        });

        saveBtnCus.setBackground(new java.awt.Color(102, 153, 255));
        saveBtnCus.setText("Save");
        saveBtnCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnCusActionPerformed(evt);
            }
        });

        ResetBtnCus.setBackground(new java.awt.Color(102, 153, 255));
        ResetBtnCus.setText("Reset");
        ResetBtnCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnCusActionPerformed(evt);
            }
        });

        deleteBtnCus.setBackground(new java.awt.Color(102, 153, 255));
        deleteBtnCus.setText("Delete");
        deleteBtnCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnCusActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Customers List");
        jLabel9.setToolTipText("");

        CustomersTable.setBackground(new java.awt.Color(0, 0, 0));
        CustomersTable.setForeground(new java.awt.Color(255, 255, 255));
        CustomersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "CNIC No.", "Address", "Phone No."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CustomersTable.setSelectionBackground(new java.awt.Color(102, 153, 255));
        CustomersTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        CustomersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CustomersTable);

        SearchC.setForeground(new java.awt.Color(255, 255, 255));
        SearchC.setText("Search By Name:");

        SearchTxtC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTxtCSearchTxtActionPerformed(evt);
            }
        });

        SearchbtnC.setBackground(new java.awt.Color(102, 153, 255));
        SearchbtnC.setText("Search");
        SearchbtnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchbtnCSearchbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(saveBtnCus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editBtnCus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(CusNametxtCus, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel3))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CusCnictxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CusAdresstxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(25, 25, 25)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CusPhonetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(deleteBtnCus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ResetBtnCus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(179, 179, 179)))))
                .addGap(0, 200, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(591, 591, 591)
                .addComponent(SearchC)
                .addGap(18, 18, 18)
                .addComponent(SearchTxtC, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchbtnC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CusNametxtCus, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CusCnictxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CusAdresstxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CusPhonetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtnCus)
                    .addComponent(editBtnCus)
                    .addComponent(deleteBtnCus)
                    .addComponent(ResetBtnCus))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SearchC)
                            .addComponent(SearchTxtC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchbtnC))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        tab9.addTab("tab7", jPanel4);

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tab9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tab9)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        // TODO add your handling code here:
        tab9.setSelectedIndex(0);
        RDisplayCars();
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        tab9.setSelectedIndex(4);
        DisplayComplaints();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        tab9.setSelectedIndex(1);
        SDisplayCars();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
        // TODO add your handling code here:
        tab9.setSelectedIndex(3);

        this.date = new Date();
        this.nextDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String str = formatter.format(date);
        //System.out.println("Current date: "+str);
        DisplayRecord();
    }//GEN-LAST:event_jLabel41MouseClicked

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
        // TODO add your handling code here:
        tab9.setSelectedIndex(5);
        DisplayCustomers();
    }//GEN-LAST:event_jLabel42MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        tab9.setSelectedIndex(2);
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CustomersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomersTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)CustomersTable.getModel();
        int rowIndex = CustomersTable.getSelectedRow();
        CusNametxtCus.setText(model.getValueAt(rowIndex, 0).toString());
        CusCnictxt.setText(model.getValueAt(rowIndex, 1).toString());
        CusAdresstxt.setText(model.getValueAt(rowIndex, 2).toString());
        CusPhonetxt.setText(model.getValueAt(rowIndex, 3).toString());
    }//GEN-LAST:event_CustomersTableMouseClicked

    private void deleteBtnCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnCusActionPerformed
        // TODO add your handling code here:
        try
        {

            if(CusCnictxt.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Enter any cnic to  delete customer ");
            }
            else
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                String cnic =  CusCnictxt.getText();
                String sqlQuery = "Delete from management.Customers"+" where CNIC ='"+cnic+"'";
                Statement st = Con.createStatement();
                st.executeUpdate(sqlQuery);
                JOptionPane.showMessageDialog(this, "Customer Deleted Successfully");
                DisplayCustomers();
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Customer deleting failed");
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteBtnCusActionPerformed

    private void ResetBtnCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnCusActionPerformed
        // TODO add your handling code here:
        Creset();
    }//GEN-LAST:event_ResetBtnCusActionPerformed

    private void saveBtnCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnCusActionPerformed
        // TODO add your handling code here:
        try
        {
            if(CusNametxtCus.getText().equals("") || CusCnictxt.getText().equals("") || CusAdresstxt.getText().equals("")  || CusPhonetxt.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Error: All Feilds Should be filled ");
            }
            else if(CusCnictxt.getText().length() <15)
            {
                JOptionPane.showMessageDialog(this, "Error: CNIC length should be 13 digits ");
            }
            else if(CusPhonetxt.getText().length() < 11)
            {
                JOptionPane.showMessageDialog(this, "Error: Phone Number length should be 11 digits ");
            }
            else
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                PreparedStatement add = Con.prepareStatement("insert into Customers values (?,?,?,?)");

                add.setString(1, CusNametxtCus.getText());
                add.setString(2, CusCnictxt.getText());
                add.setString(3, CusAdresstxt.getText());
                add.setString(4,CusPhonetxt.getText());
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Customer adding Successfully");
                DisplayCustomers();
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Can Not add Customer");
            //e.printStackTrace();
        }
    }//GEN-LAST:event_saveBtnCusActionPerformed

    private void editBtnCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnCusActionPerformed
        // TODO add your handling code here:
        try
        {

            if(CusNametxtCus.getText().equals("") || CusCnictxt.getText().equals("") || CusAdresstxt.getText().equals("")  || CusPhonetxt.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Enter Customer to be updated ");
            }
            else if(CusPhonetxt.getText().length() < 11)
            {
                JOptionPane.showMessageDialog(this, "Error: Phone Number length should be 11 digits ");
            }
            else if(CusCnictxt.getText().length() <15)
            {
                JOptionPane.showMessageDialog(this, "Error: CNIC length should be 13 digits ");
            }
            else
            {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                String cnic =  CusCnictxt.getText();
                String sqlQuery = "Update management.Customers set CusName='"+CusNametxtCus.getText()+"', address='"+CusAdresstxt.getText()+"' ,Phone='"+CusPhonetxt.getText()+"' where CNIC ='"+cnic+"'";
                Statement st = Con.createStatement();
                st.executeUpdate(sqlQuery);
                JOptionPane.showMessageDialog(this, "Customer updated Successfully");
                DisplayCustomers();

            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Customer editing failed");
            e.printStackTrace();
        }
    }//GEN-LAST:event_editBtnCusActionPerformed

    private void CusPhonetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CusPhonetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CusPhonetxtActionPerformed

    private void CusAdresstxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CusAdresstxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CusAdresstxtActionPerformed

    private void CusCnictxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CusCnictxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CusCnictxtActionPerformed

    private void CusNametxtCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CusNametxtCusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CusNametxtCusActionPerformed

    private void searchtctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchtctActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchtctActionPerformed

    private void searchbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtn1ActionPerformed
        DisplayRecord();
        searchtct.setText("");
    }//GEN-LAST:event_searchbtn1ActionPerformed

    private void deletebtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtn2ActionPerformed
        // TODO add your handling code here:
        try
        {

            if(regNoTxtM.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Select any Record to be deleted ");
            }
            else
            {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                String reg =  regNoTxtM.getText();
                String sqlQuery = "Delete from management.MaintainRec"+" where RegNo ='"+reg+"'";
                Statement st = Con.createStatement();
                st.executeUpdate(sqlQuery);
                JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
                DisplayRecord();
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Deleting failed");
            e.printStackTrace();
        }
    }//GEN-LAST:event_deletebtn2ActionPerformed

    private void resetbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtn2ActionPerformed
        // TODO add your handling code here:
        Mreset();
    }//GEN-LAST:event_resetbtn2ActionPerformed

    private void regNoTxtMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regNoTxtMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regNoTxtMActionPerformed

    private void savebtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtn2ActionPerformed
        // TODO add your handling code here:
        try
        {
            if(regNoTxtM.getText().equals("") || LastDateMan.getDate().toString().equals("") || nextDateMan.getDate().toString().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Error: All Feilds Should be filled ");
            }
            else
            {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                PreparedStatement add = Con.prepareStatement("insert into MaintainRec values (?,?,?)");

                if(date.before(LastDateMan.getDate()))
                {
                    JOptionPane.showMessageDialog(this, "Invalid Date for Last Mantained !");
                }
                else if(date.after(nextDateMan.getDate()))
                {
                    JOptionPane.showMessageDialog(this, "Invalid Date for Next Mantained !");
                }
                else
                {
                    add.setString(1, regNoTxtM.getText());
                    add.setString(2, LastDateMan.getDate().toString());
                    add.setString(3, nextDateMan.getDate().toString());
                }

                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Record added Successfully");
                DisplayRecord();
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Record adding failed");
            //e.printStackTrace();
        }
    }//GEN-LAST:event_savebtn2ActionPerformed

    private void editbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtn2ActionPerformed
        // TODO add your handling code here:
        try
        {
            if(regNoTxtM.getText().equals("") || LastDateMan.getDate().toString().equals("") || nextDateMan.getDate().toString().equals(""))
            {
                JOptionPane.showMessageDialog(this, "All feilds Should be filled. ");
            }
            else if(date.before(LastDateMan.getDate()))
            {
                JOptionPane.showMessageDialog(this, "Invalid Date for Last Mantained !");
            }
            else if(date.after(nextDateMan.getDate()))
            {
                JOptionPane.showMessageDialog(this, "Invalid Date for Next Mantained !");
            }
            else
            {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                String reg =  regNoTxtM.getText();
                String sqlQuery = "Update management.maintainRec set LastMaintained='"+LastDateMan.getDate().toString()+"', NextMaintain='"+nextDateMan.getDate().toString()+"' where RegNo ='"+reg+"'";
                Statement st = Con.createStatement();
                st.executeUpdate(sqlQuery);
                JOptionPane.showMessageDialog(this, "Record updated Successfully");
                DisplayRecord();
                Mreset();
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Record updating failed");
            e.printStackTrace();
        }
    }//GEN-LAST:event_editbtn2ActionPerformed

    private void MainRecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainRecMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)MainRec.getModel();
        int rowIndex = MainRec.getSelectedRow();
        regNoTxtM.setText(model.getValueAt(rowIndex, 0).toString());
        String str = model.getValueAt(rowIndex, 1).toString();
        //Date date;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(str);

            LastDateMan.setDate(date);
        } catch (ParseException ex) {
            //Logger.getLogger(MantainanceRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        str = model.getValueAt(rowIndex, 2).toString();
        try {
            Date date_ = new SimpleDateFormat("dd/MM/yyyy").parse(str);
            nextDateMan.setDate(date_);
        } catch (ParseException ex) {
            //Logger.getLogger(MantainanceRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MainRecMouseClicked

     
    private void EnterbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterbtnActionPerformed
        // TODO add your handling code here:
        try
        {
            if(CusNametxtC.getText().equals("") || BookingDatetxtC.getDate() == null || RegCartxtC.getText().equals("")  || DriverNametxtC.getText().equals("") || ComplainttxtC.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Error: All Feilds Should be filled ");
            }
            else if(date.before(BookingDatetxtC.getDate()))
            {
                JOptionPane.showMessageDialog(this, "Invalid Date for Booking Date Mantained !");
            }
            else
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                PreparedStatement add = Con.prepareStatement("insert into Complaint values (?,?,?,?,?)");
                String strDate;
                add.setString(1, CusNametxtC.getText());
                Date date = BookingDatetxtC.getDate();
                DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

                strDate = dateFormat.format(date);
                add.setString(2, strDate);
                add.setString(3, RegCartxtC.getText());
                add.setString(4,DriverNametxtC.getText());
                add.setString(5,ComplainttxtC.getText());
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Complaint added Successfully");

            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Can not add Complaint");
            e.printStackTrace();
        }
    }//GEN-LAST:event_EnterbtnActionPerformed

    private void RegCartxtCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegCartxtCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegCartxtCActionPerformed

    private void DriverNametxtCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DriverNametxtCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DriverNametxtCActionPerformed

    private void CusNametxtCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CusNametxtCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CusNametxtCActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            String Ava = "Available";
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
            st =  Con.createStatement();
            rs = st.executeQuery("Select * from management.CarTbl"+" where Status ='"+Ava+"'");
            DefaultTableModel model = (DefaultTableModel) CarTable.getModel();
            model.setRowCount(0);
            while(rs.next())
            {
                String regNo = rs.getString("RegNum");
                String brand_ = rs.getString("Brand");
                String model_ = rs.getString("Model");
                String status_ = rs.getString("Status");
                String price_ = rs.getString("Price");

                String tbData[] = {regNo, brand_, model_ , status_ , price_};
                model.addRow(tbData);

            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        SDisplayCars();
        searchTxt.setText("");
    }//GEN-LAST:event_searchbtnActionPerformed

    private void searchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTxtActionPerformed

    private void editbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtn1ActionPerformed
        // TODO add your handling code here:
        try
        {

            if(regNoTxtS.getText().equals("") || brandNametxtS.getText().equals("") || modelNotxtS.getText().equals("") || statusComboBox.getSelectedItem().toString().equals("") || pricetxtS.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Select Car to be updated ");
            }
            else
            {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                String reg =  regNoTxtS.getText();
                String sqlQuery = "Update management.CarTbl set Brand='"+brandNametxtS.getText()+"', Model='"+modelNotxtS.getText()+"' ,Status='"+statusComboBox.getSelectedItem().toString()+"' ,Price='"+pricetxtS.getText()+"' where RegNum ='"+reg+"'";
                Statement st = Con.createStatement();
                st.executeUpdate(sqlQuery);
                JOptionPane.showMessageDialog(this, "Car updated Successfully");
                SDisplayCars();
                Sreset();
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Car editing failed");
            e.printStackTrace();
        }
    }//GEN-LAST:event_editbtn1ActionPerformed

    private void brandNametxtSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandNametxtSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brandNametxtSActionPerformed

    private void statusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusComboBoxActionPerformed

    private void deletebtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtn1ActionPerformed
        // TODO add your handling code here:
        try
        {

            if(regNoTxtS.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Select any car to be deleted ");
            }
            else
            {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                String reg =  regNoTxtS.getText();
                Statement st = Con.createStatement();
                String sqlQuery = "Delete from management.CarTbl"+" where RegNum ='"+reg+"'";
                st.executeUpdate(sqlQuery);
                JOptionPane.showMessageDialog(this, "Car Deleted Successfully");
                SDisplayCars();
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Car deleting failed");
            e.printStackTrace();
        }
    }//GEN-LAST:event_deletebtn1ActionPerformed

    private void pricetxtSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pricetxtSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pricetxtSActionPerformed

    private void resetbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtn1ActionPerformed
        // TODO add your handling code here:
        Sreset();
    }//GEN-LAST:event_resetbtn1ActionPerformed

    private void regNoTxtSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regNoTxtSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regNoTxtSActionPerformed

    private void modelNotxtSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelNotxtSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modelNotxtSActionPerformed

    private void CarTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)CarTable.getModel();
        int rowIndex = CarTable.getSelectedRow();
        regNoTxtS.setText(model.getValueAt(rowIndex, 0).toString());
        brandNametxtS.setText(model.getValueAt(rowIndex, 1).toString());
        modelNotxtS.setText(model.getValueAt(rowIndex, 2).toString());
        statusComboBox.setSelectedItem(model.getValueAt(rowIndex, 3).toString());
        pricetxtS.setText(model.getValueAt(rowIndex, 4).toString());
    }//GEN-LAST:event_CarTableMouseClicked

    private void savebtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtn1ActionPerformed
        // TODO add your handling code here:
        try
        {
            if(regNoTxtS.getText().equals("") || brandNametxtS.getText().equals("") || modelNotxtS.getText().equals("") || statusComboBox.getSelectedItem().toString().equals("") || pricetxtS.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Error: All Feilds Should be filled ");
            }
            else
            {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                PreparedStatement add = Con.prepareStatement("insert into CarTbl values (?,?,?,?,?)");

                add.setString(1, regNoTxtS.getText());
                add.setString(2, brandNametxtS.getText());
                add.setString(3, modelNotxtS.getText());
                add.setString(4, statusComboBox.getSelectedItem().toString());
                add.setInt(5,Integer.valueOf(pricetxtS.getText()));
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Car added Successfully");
                SDisplayCars();
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Car adding failed");
            //e.printStackTrace();
        }
    }//GEN-LAST:event_savebtn1ActionPerformed

    private void Searchbtn6SearchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Searchbtn6SearchbtnActionPerformed
        // TODO add your handling code here:
        RDisplayCars();
        SearchTxtR.setText("");
    }//GEN-LAST:event_Searchbtn6SearchbtnActionPerformed

    private void SearchTxtRSearchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTxtRSearchTxtActionPerformed
        RDisplayCars();
    }//GEN-LAST:event_SearchTxtRSearchTxtActionPerformed

    private void AvailablebtnRAvailablebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvailablebtnRAvailablebtnActionPerformed
        try
        {
            String Ava = "Available";
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
            st =  Con.createStatement();
            rs = st.executeQuery("Select * from management.RentCars"+" where BookingStatus ='"+Ava+"'");
            DefaultTableModel model = (DefaultTableModel) RentCarsT.getModel();
            model.setRowCount(0);
            while(rs.next())
            {
                String regNo = rs.getString("RegNum");
                String brand_ = rs.getString("Brand");
                String model_ = rs.getString("Model");
                String status_ = rs.getString("BookingStatus");
                String price_ = rs.getString("BookingPrice");

                String tbData[] = {regNo, brand_, model_ , status_ , price_};
                model.addRow(tbData);

            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_AvailablebtnRAvailablebtnActionPerformed

    private void deletebtn8deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtn8deletebtnActionPerformed
        // TODO add your handling code here:
        try
        {

            if(regNoTxtR.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Select any car to be deleted ");
            }
            else
            {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                String reg =  regNoTxtR.getText();
                String sqlQuery = "Delete from management.RentCars"+" where RegNum ='"+reg+"'";
                Statement st = Con.createStatement();
                st.executeUpdate(sqlQuery);
                JOptionPane.showMessageDialog(this, "Car Deleted Successfully");
                RDisplayCars();
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Deleting failed");
            e.printStackTrace();
        }
    }//GEN-LAST:event_deletebtn8deletebtnActionPerformed

    private void resetbtn8resetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtn8resetbtnActionPerformed
        // TODO add your handling code here:
        Rreset();
    }//GEN-LAST:event_resetbtn8resetbtnActionPerformed

    private void regNoTxtRregNoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regNoTxtRregNoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regNoTxtRregNoTxtActionPerformed

    private void savebtn8savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtn8savebtnActionPerformed
        // TODO add your handling code here:
        try
        {
            if(regNoTxtR.getText().equals("") || brandNametxtR.getText().equals("") || modelNotxtR.getText().equals("") || BookingStatusComboBoxR.getSelectedItem().toString().equals("") || pricetxtR.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Error: All Feilds Should be filled ");
            }
            else
            {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                PreparedStatement add = Con.prepareStatement("insert into RentCars values (?,?,?,?,?)");

                add.setString(1, regNoTxtR.getText());
                add.setString(2, brandNametxtR.getText());
                add.setString(3, modelNotxtR.getText());
                add.setString(4, BookingStatusComboBoxR.getSelectedItem().toString());
                add.setInt(5,Integer.valueOf(pricetxtR.getText()));
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Car added Successfully");
                RDisplayCars();
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Car adding failed");
            e.printStackTrace();
        }
    }//GEN-LAST:event_savebtn8savebtnActionPerformed

    private void editbtn8editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtn8editbtnActionPerformed
        // TODO add your handling code here:
        try
        {

            if(regNoTxtR.getText().equals("") || brandNametxtR.getText().equals("") || modelNotxtR.getText().equals("") || BookingStatusComboBoxR.getSelectedItem().toString().equals("") || pricetxtR.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Select Car to be updated ");
            }
            else
            {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                String reg =  regNoTxtR.getText();
                String sqlQuery = "Update management.RentCars set Brand='"+brandNametxtR.getText()+"', Model='"+modelNotxtR.getText()+"' ,BookingStatus='"+BookingStatusComboBoxR.getSelectedItem().toString()+"' ,BookingPrice='"+pricetxtR.getText()+"' where RegNum ='"+reg+"'";
                Statement st = Con.createStatement();
                st.executeUpdate(sqlQuery);
                JOptionPane.showMessageDialog(this, "Car updated Successfully");
                RDisplayCars();
                Rreset();
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Car updating failed");
            e.printStackTrace();
        }
    }//GEN-LAST:event_editbtn8editbtnActionPerformed

    private void BookingStatusComboBoxRBookingStatusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookingStatusComboBoxRBookingStatusComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookingStatusComboBoxRBookingStatusComboBoxActionPerformed

    private void pricetxtRpricetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pricetxtRpricetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pricetxtRpricetxtActionPerformed

    private void modelNotxtRmodelNotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelNotxtRmodelNotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modelNotxtRmodelNotxtActionPerformed

    private void RentCarsTRentCarsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RentCarsTRentCarsMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)RentCarsT.getModel();
        int rowIndex = RentCarsT.getSelectedRow();
        regNoTxtR.setText(model.getValueAt(rowIndex, 0).toString());
        brandNametxtR.setText(model.getValueAt(rowIndex, 1).toString());
        modelNotxtR.setText(model.getValueAt(rowIndex, 2).toString());
        BookingStatusComboBoxR.setSelectedItem(model.getValueAt(rowIndex, 3).toString());
        pricetxtR.setText(model.getValueAt(rowIndex, 4).toString());
    }//GEN-LAST:event_RentCarsTRentCarsMouseClicked

    private void brandNametxtRbrandNametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandNametxtRbrandNametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brandNametxtRbrandNametxtActionPerformed

    private void logoutB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutB1ActionPerformed
        // TODO add your handling code here:
        
        dispose();
        MainPage frame = new MainPage();

       
        frame.setContentPane(frame.getPanel());
        frame.setSize(1050,820);
        frame.setResizable(false);
        frame.setVisible(true);
    }//GEN-LAST:event_logoutB1ActionPerformed

    private void SearchTxtCSearchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTxtCSearchTxtActionPerformed
        
    }//GEN-LAST:event_SearchTxtCSearchTxtActionPerformed

    private void SearchbtnCSearchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchbtnCSearchbtnActionPerformed
        // TODO add your handling code here:
        DisplayCustomers();
        SearchTxtC.setText("");
    }//GEN-LAST:event_SearchbtnCSearchbtnActionPerformed

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
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Staff().setVisible(true);
            }
        });
    }
    
    public JPanel getPanel()
     {
     return panel3;
     }
     public String checkSaveC(String n,String c , String d,String s )
   {
      String check = "false";
        try
        {
             
            if(n.equals("") || c.equals("") || (d.equals("") ||  s.equals("")))
            {
                check="";
              //  JOptionPane.showMessageDialog(this, "Error: All Feilds Should be filled ");
            }
            else
            {
                Class.forName("com.mysql.cj.jdbc.Driver");

                 Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                PreparedStatement add = Con.prepareStatement("insert into Customers values (?,?,?,?)");

                add.setString(1,n);
                add.setString(2,c);
                add.setString(3, d);
                add.setString(4, s);
                int row = add.executeUpdate();
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
    public String checkEditC(String n,String c , String d,String s )
    {
        String check = "";
         try
        {

            if(n.equals("") || c.equals("") || d.equals("")|| s.equals(""))
            {
                check  = "";
               // JOptionPane.showMessageDialog(this, "Enter Employee to be updated ");
            }
            else
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                String cnic =  c;
                String sqlQuery;
                 sqlQuery = "Update management.Customers set CusName='"+n+"', address='"+d+"' ,Phone='"+s+"' where CNIC ='"+c+"'";

                
              

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
    public String checkDeleteC(String c)
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
                String sqlQuery = "Delete from management.Customers"+" where CNIC ='"+c+"'";
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
    
    public String checkSaveCar(String n,String c , String d,String s,String p )
   {
      String check = "false";
        try
        {
             
            if(n.equals("") || c.equals("") || (d.equals("") ||  s.equals("") || p.equals("")))
            {
                check="";
              //  JOptionPane.showMessageDialog(this, "Error: All Feilds Should be filled ");
            }
            else
            {
                Class.forName("com.mysql.cj.jdbc.Driver");

                 Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                PreparedStatement add = Con.prepareStatement("insert into RentCars values (?,?,?,?,?)");

                add.setString(1,n);
                add.setString(2,c);
                add.setString(3, d);
                add.setString(4, s);
                 add.setString(5, p);
                int row = add.executeUpdate();
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
    public String checkEditCar(String n,String c , String d,String s, String p )
    {
        String check = "";
         try
        {

            if(n.equals("") || c.equals("") || d.equals("")|| s.equals("")|| p.equals(""))
            {
                check  = "";
               // JOptionPane.showMessageDialog(this, "Enter Employee to be updated ");
            }
            else
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                String cnic =  c;
                String sqlQuery;
                 sqlQuery = "Update management.RentCars set BookingStatus='"+s+"', BookingPrice='"+p+"', Brand='"+c+"' ,Model='"+d+"' where RegNum ='"+n+"'";

                
              

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
    public String checkDeleteCar(String c)
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
                String sqlQuery = "Delete from management.RentCars"+" where RegNum ='"+c+"'";
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

    public String checkSaveSale(String n,String c , String d,String s,String p )
   {
      String check = "false";
        try
        {
             
            if(n.equals("") || c.equals("") || (d.equals("") ||  s.equals("") || p.equals("")))
            {
                check="";
              //  JOptionPane.showMessageDialog(this, "Error: All Feilds Should be filled ");
            }
            else
            {
                Class.forName("com.mysql.cj.jdbc.Driver");

                 Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                PreparedStatement add = Con.prepareStatement("insert into CarTbl values (?,?,?,?,?)");

                add.setString(1,n);
                add.setString(2,c);
                add.setString(3, d);
                add.setString(4, s);
                 add.setString(5, p);
                int row = add.executeUpdate();
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
    public String checkEditSale(String n,String c , String d,String s, String p )
    {
        String check = "";
         try
        {

            if(n.equals("") || c.equals("") || d.equals("")|| s.equals("")|| p.equals(""))
            {
                check  = "";
               // JOptionPane.showMessageDialog(this, "Enter Employee to be updated ");
            }
            else
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                String cnic =  c;
                String sqlQuery;
                 sqlQuery = "Update management.CarTbl set Status='"+s+"', Price='"+p+"', Brand='"+c+"' ,Model='"+d+"' where RegNum ='"+n+"'";

                
              

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
    public String checkDeleteSale(String c)
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
                String sqlQuery = "Delete from management.CarTbl"+" where RegNum ='"+c+"'";
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
 public String checkSaveMaintain(String n,String c , String d )
   {
      String check = "false";
        try
        {
             
            if(n.equals("") || c.equals("") || (d.equals("") ))
            {
                check="";
              //  JOptionPane.showMessageDialog(this, "Error: All Feilds Should be filled ");
            }
            else
            {
                Class.forName("com.mysql.cj.jdbc.Driver");

                 Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                PreparedStatement add = Con.prepareStatement("insert into MaintainRec values (?,?,?)");

                add.setString(1,n);
                add.setString(2,c);
                add.setString(3, d);
                int row = add.executeUpdate();
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
    public String checkEditMaintain(String n,String c , String d )
    {
        String check = "";
         try
        {

            if(n.equals("") || c.equals("") || d.equals(""))
            {
                check  = "";
               // JOptionPane.showMessageDialog(this, "Enter Employee to be updated ");
            }
            else
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "#maheen123#");
                String cnic =  c;
                String sqlQuery;
                 sqlQuery = "Update management.MaintainRec set LastMaintained='"+c+"', NextMaintain='"+d+"' where RegNo ='"+n+"'";

                
              

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
    public String checkDeleteMaintain(String c)
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
                String sqlQuery = "Delete from management.MaintainRec"+" where RegNo ='"+c+"'";
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
    private javax.swing.JButton AvailablebtnR;
    private com.toedter.calendar.JDateChooser BookingDatetxtC;
    private javax.swing.JComboBox<String> BookingStatusComboBoxR;
    private javax.swing.JTable CarTable;
    private javax.swing.JTable ComplaintsTable;
    private javax.swing.JTextArea ComplainttxtC;
    private javax.swing.JTextField CusAdresstxt;
    private javax.swing.JTextField CusCnictxt;
    private javax.swing.JTextField CusNametxtC;
    private javax.swing.JTextField CusNametxtCus;
    private javax.swing.JTextField CusPhonetxt;
    private javax.swing.JTable CustomersTable;
    private javax.swing.JTextField DriverNametxtC;
    private javax.swing.JButton Enterbtn;
    private com.toedter.calendar.JDateChooser LastDateMan;
    private javax.swing.JTable MainRec;
    private javax.swing.JTextField RegCartxtC;
    private javax.swing.JTable RentCarsT;
    private javax.swing.JButton ResetBtnCus;
    private javax.swing.JLabel SearchC;
    private javax.swing.JTextField SearchTxtC;
    private javax.swing.JTextField SearchTxtR;
    private javax.swing.JButton Searchbtn6;
    private javax.swing.JButton SearchbtnC;
    private javax.swing.JTextField brandNametxtR;
    private javax.swing.JTextField brandNametxtS;
    private javax.swing.JButton deleteBtnCus;
    private javax.swing.JButton deletebtn1;
    private javax.swing.JButton deletebtn2;
    private javax.swing.JButton deletebtn8;
    private javax.swing.JButton editBtnCus;
    private javax.swing.JButton editbtn1;
    private javax.swing.JButton editbtn2;
    private javax.swing.JButton editbtn8;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton logoutB;
    private javax.swing.JButton logoutB1;
    private javax.swing.JTextField modelNotxtR;
    private javax.swing.JTextField modelNotxtS;
    private com.toedter.calendar.JDateChooser nextDateMan;
    private javax.swing.JPanel panel3;
    private javax.swing.JTextField pricetxtR;
    private javax.swing.JTextField pricetxtS;
    private javax.swing.JTextField regNoTxtM;
    private javax.swing.JTextField regNoTxtR;
    private javax.swing.JTextField regNoTxtS;
    private javax.swing.JButton resetbtn1;
    private javax.swing.JButton resetbtn2;
    private javax.swing.JButton resetbtn8;
    private javax.swing.JButton saveBtnCus;
    private javax.swing.JButton savebtn1;
    private javax.swing.JButton savebtn2;
    private javax.swing.JButton savebtn8;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JButton searchbtn;
    private javax.swing.JButton searchbtn1;
    private javax.swing.JTextField searchtct;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JTabbedPane tab9;
    // End of variables declaration//GEN-END:variables
}
