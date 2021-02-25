/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
/**
 *
 * @author user
 */
public class Notification extends javax.swing.JFrame {

    /**
     * Creates new form Notification
     */
	private NotificationManager nmgr;
	
    public Notification(NotificationManager nmgr) {
    	this.nmgr = nmgr;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		if(jComboBox1.getSelectedItem().equals("1 week ago") || jComboBox1.getSelectedItem().equals("2 weeks ago") || jComboBox1.getSelectedItem().equals("1 month ago")) {
	        		 jLabel9.setText("No notifications available");
	        		 jList2.setVisible(false);
	        		 
        		}
        		else {
        			jLabel9.setText("Notifications of 1 day ago");
	        		 jList2.setVisible(true);
	        		 
        		}
        	}
        	
        });
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Notification_Neha Jhawar-A-86");
        setPreferredSize(new java.awt.Dimension(600, 600));
        setSize(new java.awt.Dimension(600, 600));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel1.setText("Logout");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setText("Notifications");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("My Answers");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setText("My Questions");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setText("Home");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setText("jLabel6");
        ImageIcon ilogo=new ImageIcon("src/img/QueryFixedLogo.jpg");
        jLabel6.setIcon(ilogo);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel7.setText("QueryFixed");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(19)
        			.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabel7)
        			.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
        			.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(25))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(66, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel1)
        						.addComponent(jLabel2)
        						.addComponent(jLabel3)
        						.addComponent(jLabel4)
        						.addComponent(jLabel7)
        						.addComponent(jLabel5))
        					.addContainerGap())
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
        					.addGap(21))))
        );
        jPanel1.setLayout(jPanel1Layout);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel8.setText("Notifications");

        List<String> strings = new ArrayList<String>();
        
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
        	
        
            //String[] strings = { "Neha1609 posted a question \"What are different event listeners?...\"\t  13 mins ago", "Deepak737313 posted an answer of \"How to optimise the Matrix Multipli...\"\t  2 hours ago", "Ruby345 reviewed your answer of question \"What is Material Management?\"\t  4 hours ago", "Hemangee4700 posted an answer of \"Why Economics is studied in Engine...\"\t  9 hours ago" };
            String[] strings=nmgr.generatedNoti(nmgr.qf.dispmgr.userLogId);
        	public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
			
        });
        
        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Browse older Notifications");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }}
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 day ago", "1 week ago", "2 weeks ago", "1 month ago" }));
        /*jComboBox1.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }}
        );*/
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        /*jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "CrazyProgrammer posted a question \"How to improve Dynamic Programming?...\"  9 hours ago", "Kundan26262 posted an answer of \"How to optimise the Matrix Multipli...\"  10 hours ago", "Rahul reviewed your answer of question \"What is Material Management?\"  10 hours ago", "Tua556 posted an answer of \"Why Economics is studied in Engine...\"  10 hours ago", "Sandy007 posted a question \"How to download Tally Counter?\"  13 hours ago", "Ronit335 posted an answer of \"How to optimise the Matrix Multipli...\"  16 hours ago", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });*/
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = nmgr.oneDayAgo();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i];}});
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jButton1)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanel2.setVisible(false);

        pack();
    }// </editor-fold>                        

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
        jPanel2.setVisible(true);
        jLabel9.setText("Notifications 1 day ago");
    }
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
    	nmgr.qf.dispmgr.showNotification();
    }
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
    	nmgr.qf.dispmgr.showNotification();
    }
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
    	nmgr.qf.dispmgr.showMyQuestion();
    }
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
    	nmgr.qf.dispmgr.showMyAnswer();
    }
    /*private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
    	if(jComboBox1.getSelectedIndex()==0){
            System.out.println("Notifications of 1 day ago");
            jLabel9.setText("Notifications of 1 day ago");
            jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = nmgr.oneDayAgo();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        }
        else if(jComboBox1.getSelectedIndex()==1){
            System.out.println("Notifications of 1 week ago");
            jLabel9.setText("Notifications of 1 week ago");
            jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = nmgr.oneDayAgo();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        }
        else if(jComboBox1.getSelectedIndex()==2){
            System.out.println("Notifications of 2 week ago");
            jLabel9.setText("Notifications of 2 weeks ago");
            jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = nmgr.oneDayAgo();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        }
        else if(jComboBox1.getSelectedIndex()==3){
            System.out.println("Notifications of 1 month ago");
            jLabel9.setText("Notifications of 1 month ago");
            jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = nmgr.oneDayAgo();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        }
    }*/
    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {                                            
        // TODO add your handling code here:
        if(evt.getSource()==jComboBox1){
            if(jComboBox1.getSelectedItem().equals("1 day ago")){
            System.out.println("Notifications of 1 day ago");
            jLabel9.setText("Notifications of 1 day ago");
            jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = nmgr.oneDayAgo();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        }
            if(jComboBox1.getSelectedItem().equals("1 week ago")){
            System.out.println("Notifications of 1 week ago");
            jLabel9.setText("Notifications of 1 week ago");
            jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = nmgr.oneWeekAgo();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        }
            if(jComboBox1.getSelectedItem().equals("2 week ago")){
            System.out.println("Notifications of 2 week ago");
            jLabel9.setText("Notifications of 2 week ago");
            jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = nmgr.twoWeekAgo();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        }
            if(jComboBox1.getSelectedItem().equals("1 month ago")){
            System.out.println("Notifications of 1 month ago");
            jLabel9.setText("Notifications of 1 month ago");
            jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = nmgr.oneMonthAgo();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        }
        }
    }

    
    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notification(new NotificationManager()).setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify                    
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration                  
}
