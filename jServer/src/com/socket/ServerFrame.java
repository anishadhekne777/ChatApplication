package com.socket;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

public class ServerFrame extends javax.swing.JFrame {

    public SocketServer server;
    public Thread serverThread;
    public String filePath = "C:/Users/anish/workspace/NewChatApp/Data.xml";
    public JFileChooser fileChooser;
    
    public ServerFrame() {
        initComponents();     
        jTextField3.setEditable(false);
        jTextField3.setBackground(Color.WHITE);
        
        fileChooser = new JFileChooser();
        jTextArea1.setEditable(false);
    }
    
    public boolean isWin32(){
        return System.getProperty("os.name").startsWith("Windows");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jB1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jL1 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jB2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("jServer");

        jB1.setText("Connect Server");
        jB1.setEnabled(false);
        jB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 12)); 
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jL1.setText("Connect to DB File : ");

        jB2.setText("Browse");
        jB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jL1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jB2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jB1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL1)
                    .addComponent(jB2)
                    .addComponent(jB1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    private void jB1ActionPerformed(java.awt.event.ActionEvent evt)
    {
        server = new SocketServer(this);
        jB1.setEnabled(false); jB2.setEnabled(false);
    }

    public void RetryStart(int port){
        if(server != null){ server.stop(); }
        server = new SocketServer(this, port);
    }
    
    private void jB2ActionPerformed(java.awt.event.ActionEvent evt) 
    {
        fileChooser.showDialog(this, "Select");
        File file = fileChooser.getSelectedFile();
        
        if(file != null){
            filePath = file.getPath();
            if(this.isWin32()){ filePath = filePath.replace("\\", "/"); }
            jTextField3.setText(filePath);
            jB1.setEnabled(true);
        }
    }

    public static void main(String args[]) {

        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception ex){
            System.out.println("Exception");
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerFrame().setVisible(true);
            }
        });
    }
  
    private javax.swing.JButton jB1;
    private javax.swing.JButton jB2;
    private javax.swing.JLabel jL1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField3;
  
}
