//Maui M. Santos & Liam Joshua Salunga Final Project OOP

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.io.FileFilter;

import java.io.FilterOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class productForm extends javax.swing.JFrame {


    public productForm() {
        initComponents();
        Connect();
        LoadProductNo();
        Fetch();
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadProductNo(){
    
        try {
            pst = con.prepareStatement("SELECT id FROM product_tbl");
            rs = pst.executeQuery();
            txtpId.removeAllItems();
            while(rs.next()){
            txtpId.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM product_tbl");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                  Vector v2 = new Vector();
                  for(int a=1; a<=q; a++){
                       v2.add(rs.getString("id"));
                       v2.add(rs.getString("pname"));
                       v2.add(rs.getString("price"));
                       v2.add(rs.getString("qty"));
                       v2.add(rs.getString("dsc"));
                       
                  }
                  df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPname = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        txtpId = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtDsc = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Product Name:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Product Price:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Product Qty:");

        txtpId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Product Id");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnExport.setText("Export to CSV");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnPDF.setText("Export to PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPDF)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnExport)
                    .addComponent(btnPDF))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Description:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Price", "Quantity", "Description"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("JAVA CRUD Operation");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtQty))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPrice))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPname, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtpId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSearch))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDsc))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)
                                .addGap(160, 160, 160)))
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtDsc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(txtPname.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Product name is required"); 
        }
         else if(txtPrice.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Product price is required");
         }
        else if(txtQty.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Product quantity is required");
         }
        else if(txtDsc.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Product description is required");
         }else{
        try {
            // TODO add your handling code here:
            
            String pname = txtPname.getText();
            String price = txtPrice.getText();
            String qty = txtQty.getText();
            String dsc = txtDsc.getText();
            
            pst = con.prepareStatement("INSERT INTO product_tbl (pname,price,qty,dsc)VALUES(?,?,?,?)");
            pst.setString(1,pname);
            pst.setString(2,price);
            pst.setString(3,qty);
            pst.setString(4,dsc);
            
            int k = pst.executeUpdate();
            
            if(k==1){
            JOptionPane.showMessageDialog(this,"Record Added!! succesfully");
            txtPname.setText("");
            txtPrice.setText("");
            txtQty.setText("");
            txtDsc.setText("");
            Fetch();
            LoadProductNo();
            }else{
            JOptionPane.showMessageDialog(this,"Record failed to save!!!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed
    }
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            // TODO add your handling code here:
            
            String pId = txtpId.getSelectedItem().toString();
            
            pst = con.prepareStatement("SELECT * FROM product_tbl WHERE id=?");
            pst.setString(1,pId);
            rs = pst.executeQuery();
            
            if(rs.next()==true){
                txtPname.setText(rs.getString(2));
                txtPrice.setText(rs.getString(3));
                txtQty.setText(rs.getString(4));
                txtDsc.setText(rs.getString(5));
                
            }else{
             JOptionPane.showMessageDialog(this,"No record found!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
               if(txtPname.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Product name is required"); 
        }
         else if(txtPrice.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Product price is required");
         }
        else if(txtQty.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Product quantity is required");
         }
        else if(txtDsc.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Product description is required");
         }else{
        try {
            // TODO add your handling code here:
            
            String pname = txtPname.getText();
            String price = txtPrice.getText();
            String qty = txtQty.getText();
            String dsc = txtDsc.getText();
            String pId = txtpId.getSelectedItem().toString();
            
            pst = con.prepareStatement("UPDATE product_tbl SET pname=?,price=?,qty=?,dsc=? WHERE id =?");
            
            pst.setString(1,pname);
            pst.setString(2,price);
            pst.setString(3,qty);
            pst.setString(4,dsc);
            pst.setString(5,pId);
            
            int k=pst.executeUpdate();
            if(k==1){
             JOptionPane.showMessageDialog(this,"Record has been successfully update!!");
                txtPname.setText("");
                txtPrice.setText("");
                txtQty.setText("");
                txtDsc.setText("");
                txtPname.requestFocus();
                Fetch();
                LoadProductNo();
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            // TODO add your handling code here:
            
            String pId = txtpId.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM product_tbl WHERE id=?");
            pst.setString(1,pId);
            
            int k = pst.executeUpdate();
            if(k==1){
            JOptionPane.showMessageDialog(this,"Record has been successfully Deleted!!");
            txtPname.setText("");
                txtPrice.setText("");
                txtQty.setText("");
                txtDsc.setText("");
                txtPname.requestFocus();
                Fetch();
                LoadProductNo();
            }else{
            JOptionPane.showMessageDialog(this,"Record failed to delete!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        
        String filename = "C:\\Users\\Maui Mendoza Santos\\Documents\\ExportedFileJava.csv";
        
        
        try {
            FileWriter fw = new FileWriter(filename);
            pst = con.prepareStatement("SELECT * FROM product_tbl");
            rs = pst.executeQuery();
            
            while(rs.next()){
               fw.append(rs.getString(1));
               fw.append(',');
               fw.append(rs.getString(2));
               fw.append(',');
               fw.append(rs.getString(3));
               fw.append(',');
               fw.append(rs.getString(4));
               fw.append(',');
               fw.append(rs.getString(5));
               fw.append('\n');
               
            }
            JOptionPane.showMessageDialog(this,"CSV file is exported successfully!!");
            fw.flush();
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        try {
            // TODO add your handling code here:
         
            pst = con.prepareStatement("SELECT * FROM product_tbl");
            rs = pst.executeQuery();
            
            Document PDFreport = new Document();
            PdfWriter.getInstance(PDFreport, new FileOutputStream("C:\\Users\\Maui Mendoza Santos\\Documents\\OutputReportJava.pdf"));
            
            PDFreport.open();
            
            PdfPTable PDFTable = new PdfPTable(5);
            PdfPCell table_cell;
            
            while(rs.next()){
            
                String pId = rs.getString("id");
                table_cell = new PdfPCell(new Phrase(pId));
                PDFTable.addCell(table_cell);
                
                String pname = rs.getString("pname");
                table_cell = new PdfPCell(new Phrase(pname));
                PDFTable.addCell(table_cell);
                
                String pprice = rs.getString("price");
                table_cell = new PdfPCell(new Phrase(pprice));
                PDFTable.addCell(table_cell);
                
                String pqty = rs.getString("qty");
                table_cell = new PdfPCell(new Phrase(pqty));
                PDFTable.addCell(table_cell);
                
                String pdsc = rs.getString("dsc");
                table_cell = new PdfPCell(new Phrase(pdsc));
                PDFTable.addCell(table_cell);
                
                
                
            }
            JOptionPane.showMessageDialog(this,"PDF file is exported successfully!!");
            
            PDFreport.add(PDFTable);
            PDFreport.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPDFActionPerformed

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
            java.util.logging.Logger.getLogger(productForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtDsc;
    private javax.swing.JTextField txtPname;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQty;
    private javax.swing.JComboBox<String> txtpId;
    // End of variables declaration//GEN-END:variables
}
