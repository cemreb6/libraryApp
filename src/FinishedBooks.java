
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FinishedBooks extends javax.swing.JFrame {

    /**
     * Creates new form FinishedBooks
     */
    public FinishedBooks() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        enteredYear = new javax.swing.JTextField();
        display = new javax.swing.JButton();
        returnOptions = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Display Finished Books");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Year");

        enteredYear.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        display.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        display.setText("Display");
        display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayActionPerformed(evt);
            }
        });

        returnOptions.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        returnOptions.setText("Return Options");
        returnOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnOptionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(returnOptions))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(enteredYear, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(display)))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(returnOptions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enteredYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(display)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void displayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayActionPerformed
        //for create the bookList and read the books from the file.
        FILEIO file=new FILEIO();
        ArrayList<Books> bookList=file.createBookList();
        
        String year=enteredYear.getText();//gets the year
        int iYear =0;
        try{//we have to check if the entered year is valid ,it cannot be a char or string or double.
           iYear=Integer.parseInt(year);
    
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Invalid Year");
        }//if the format of the entered value is wrong and an exception caught by the catch part the remaining part cannot be executed.
        
        if(iYear!=0){//if the format is true then we can contiune the process.
          
            int counter=0;//in order to count the finished books in the given year
            for(int i=0;i<bookList.size();i++){//check all years in the list ,if year is as same as the entered year counter increases by 1.
                if(iYear==bookList.get(i).year){
                counter++;
                }
            }
            if(counter>0){// If there is at least one book 
                JOptionPane.showMessageDialog(null, "Number of books that read in "+year+" are "+counter);
            }
            else{//if there are no books in the given year
                JOptionPane.showMessageDialog(null, "There is no book that is read in this year.");
            } 
            }
        enteredYear.setText("");
    }//GEN-LAST:event_displayActionPerformed

    private void returnOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnOptionsActionPerformed
        //When user clicks to return options button then ,this window will be invisivle and options window will be visible for user.
        Options option=new Options();
        this.setVisible(false);
        option.setVisible(true);
    }//GEN-LAST:event_returnOptionsActionPerformed

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
            java.util.logging.Logger.getLogger(FinishedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinishedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinishedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinishedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinishedBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton display;
    private javax.swing.JTextField enteredYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton returnOptions;
    // End of variables declaration//GEN-END:variables
}
