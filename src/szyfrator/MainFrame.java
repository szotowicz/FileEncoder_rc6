/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package szyfrator;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.javafx.scene.traversal.Direction;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author Mikołaj
 */
public class MainFrame extends javax.swing.JFrame {

    private String sessionKeyEncryptPanel = ""; //creatting in createEncryptedXML()
    private String sessionKeyDecryptPanel = ""; //read from setting xml for user
    
    private File encryptionFile;
    private File decryptionFile;
    private File encryptionFileResult;
    private File decryptionFileResult;
    private String operatingMode = "ECB";
    private int keySize = 128;
    private int subblockSize = 8;   
    private ArrayList<String> recipientList = new ArrayList();
    
    private SecureRandom secureRandom = new SecureRandom();
    private static final SecureRandom secureRandomIV = new SecureRandom();
    
    // my paths
    String pathSavedUsers = "lib/users.xml";
    String pathChooserDefaultDirectory = "myworkspace/";
    String pathMyPrivateKeys = "lib/private/";
    String pathMyPublicKeys = "lib/public/";
    //String nameReslutFile = "/result_";
    
    ///TODO... del//
    MyRC6 myRC6 = new MyRC6();
    
    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);
        ImageIcon img;
        
        //encryption panel
        img = new ImageIcon(new ImageIcon("images/select.png").getImage().getScaledInstance(45, 36, Image.SCALE_DEFAULT));
        encryptionFileButton.setIcon(img);
        img = new ImageIcon(new ImageIcon("images/save.png").getImage().getScaledInstance(45, 36, Image.SCALE_DEFAULT));
        encryptionFileResultButton.setIcon(img);
        
        usersPanel.setBorder(BorderFactory.createTitledBorder("Odbiorcy"));
        usersList.setSelectionMode(SINGLE_SELECTION);
        jProgressBar1.setStringPainted(true);
        
        img = new ImageIcon(new ImageIcon("images/padlock.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        runEncryptionButton.setIcon(img);
        
        
        //decryption panel
        img = new ImageIcon(new ImageIcon("images/select.png").getImage().getScaledInstance(45, 36, Image.SCALE_DEFAULT));
        decryptionFileButton.setIcon(img);
        img = new ImageIcon(new ImageIcon("images/save.png").getImage().getScaledInstance(45, 36, Image.SCALE_DEFAULT));
        decryptionFileResultButton.setIcon(img);
        
        usersList2.setSelectionMode(SINGLE_SELECTION);
        jProgressBar2.setStringPainted(true);
        
        img = new ImageIcon(new ImageIcon("images/padlock.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        runDescryptionButton.setIcon(img);
        
        
        //settings program window
        ImageIcon imageIcon = new ImageIcon("images/icon.jpg");
        setIconImage(imageIcon.getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        mainTabbedPane = new javax.swing.JTabbedPane();
        ecryptionPanel = new javax.swing.JPanel();
        encryptionFileLabel = new javax.swing.JLabel();
        encryptionFileTextField = new javax.swing.JTextField();
        encryptionResultFileLabel = new javax.swing.JLabel();
        encryptionResultFileTextField = new javax.swing.JTextField();
        encryptionFileButton = new javax.swing.JButton();
        encryptionFileResultButton = new javax.swing.JButton();
        operatingModeLabel = new javax.swing.JLabel();
        operatingModeComboBox = new javax.swing.JComboBox<>();
        keySizeLabel = new javax.swing.JLabel();
        keySizeComboBox = new javax.swing.JComboBox<>();
        subblockSizeLabel = new javax.swing.JLabel();
        subblockSizeLabelComboBox = new javax.swing.JComboBox<>();
        usersPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersList = new javax.swing.JList<>();
        addNewUserButton = new javax.swing.JButton();
        deleteUserButton = new javax.swing.JButton();
        runEncryptionButton = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        decryptionPanel = new javax.swing.JPanel();
        decryptionFileLabel = new javax.swing.JLabel();
        decryptionFileButton = new javax.swing.JButton();
        decryptionFileTextField = new javax.swing.JTextField();
        decryptionResultFileTextField = new javax.swing.JTextField();
        decryptionFileResultButton = new javax.swing.JButton();
        decryptionResultFileLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        passwordLabel = new javax.swing.JLabel();
        runDescryptionButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        usersList2 = new javax.swing.JList<>();
        jProgressBar2 = new javax.swing.JProgressBar();
        recipientsListLabel = new javax.swing.JLabel();
        mainManuBar = new javax.swing.JMenuBar();
        fileMenuBar = new javax.swing.JMenu();
        programMenuItem2 = new javax.swing.JMenuItem();
        authorMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenuBar = new javax.swing.JMenu();
        instructionMenuItem = new javax.swing.JMenuItem();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Szyfrator");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(360, 550));
        setPreferredSize(new java.awt.Dimension(360, 550));
        setSize(new java.awt.Dimension(360, 550));

        ecryptionPanel.setLayout(null);

        encryptionFileLabel.setText("Plik do zaszyfrowania:");
        ecryptionPanel.add(encryptionFileLabel);
        encryptionFileLabel.setBounds(8, 11, 180, 14);

        encryptionFileTextField.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        encryptionFileTextField.setEnabled(false);
        ecryptionPanel.add(encryptionFileTextField);
        encryptionFileTextField.setBounds(8, 31, 271, 17);

        encryptionResultFileLabel.setText("Plik wynikowy:");
        ecryptionPanel.add(encryptionResultFileLabel);
        encryptionResultFileLabel.setBounds(8, 78, 110, 14);

        encryptionResultFileTextField.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        encryptionResultFileTextField.setEnabled(false);
        ecryptionPanel.add(encryptionResultFileTextField);
        encryptionResultFileTextField.setBounds(8, 98, 271, 17);

        encryptionFileButton.setIconTextGap(0);
        encryptionFileButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        encryptionFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptionFileButtonActionPerformed(evt);
            }
        });
        ecryptionPanel.add(encryptionFileButton);
        encryptionFileButton.setBounds(289, 11, 47, 40);

        encryptionFileResultButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        encryptionFileResultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptionFileResultButtonActionPerformed(evt);
            }
        });
        ecryptionPanel.add(encryptionFileResultButton);
        encryptionFileResultButton.setBounds(289, 78, 47, 40);

        operatingModeLabel.setText("Tryb pracy:");
        ecryptionPanel.add(operatingModeLabel);
        operatingModeLabel.setBounds(30, 140, 90, 14);

        operatingModeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ECB", "CBC", "CFB", "OFB" }));
        operatingModeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operatingModeComboBoxActionPerformed(evt);
            }
        });
        ecryptionPanel.add(operatingModeComboBox);
        operatingModeComboBox.setBounds(30, 160, 60, 20);

        keySizeLabel.setText("Dł. klucza:");
        ecryptionPanel.add(keySizeLabel);
        keySizeLabel.setBounds(130, 140, 70, 14);

        keySizeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "128", "192", "256" }));
        keySizeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keySizeComboBoxActionPerformed(evt);
            }
        });
        ecryptionPanel.add(keySizeComboBox);
        keySizeComboBox.setBounds(130, 160, 60, 20);

        subblockSizeLabel.setText("Dł. podbloku:");
        ecryptionPanel.add(subblockSizeLabel);
        subblockSizeLabel.setBounds(230, 140, 90, 14);

        subblockSizeLabelComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8", "16", "24", "32", "40", "48", "56", "64", "72", "80", "88", "96", "104", "112", "120", "128" }));
        subblockSizeLabelComboBox.setEnabled(false);
        subblockSizeLabelComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subblockSizeLabelComboBoxActionPerformed(evt);
            }
        });
        ecryptionPanel.add(subblockSizeLabelComboBox);
        subblockSizeLabelComboBox.setBounds(230, 160, 70, 20);

        usersList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(usersList);

        addNewUserButton.setBackground(new java.awt.Color(102, 153, 255));
        addNewUserButton.setText("Dodaj nowy");
        addNewUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewUserButtonActionPerformed(evt);
            }
        });

        deleteUserButton.setBackground(new java.awt.Color(102, 153, 255));
        deleteUserButton.setText("Usuń");
        deleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout usersPanelLayout = new javax.swing.GroupLayout(usersPanel);
        usersPanel.setLayout(usersPanelLayout);
        usersPanelLayout.setHorizontalGroup(
            usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addNewUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(deleteUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        usersPanelLayout.setVerticalGroup(
            usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usersPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(usersPanelLayout.createSequentialGroup()
                        .addComponent(addNewUserButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteUserButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        ecryptionPanel.add(usersPanel);
        usersPanel.setBounds(10, 200, 330, 150);

        runEncryptionButton.setBackground(new java.awt.Color(51, 255, 51));
        runEncryptionButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        runEncryptionButton.setText("  SZYFRUJ");
        runEncryptionButton.setMargin(new java.awt.Insets(5, 14, 5, 14));
        runEncryptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runEncryptionButtonActionPerformed(evt);
            }
        });
        ecryptionPanel.add(runEncryptionButton);
        runEncryptionButton.setBounds(80, 380, 200, 50);
        ecryptionPanel.add(jProgressBar1);
        jProgressBar1.setBounds(20, 360, 310, 14);

        mainTabbedPane.addTab("Szyfrowanie", ecryptionPanel);

        decryptionFileLabel.setText("Plik do odszyfrowania:");

        decryptionFileButton.setIconTextGap(0);
        decryptionFileButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        decryptionFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptionFileButtonActionPerformed(evt);
            }
        });

        decryptionFileTextField.setEnabled(false);

        decryptionResultFileTextField.setEnabled(false);

        decryptionFileResultButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        decryptionFileResultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptionFileResultButtonActionPerformed(evt);
            }
        });

        decryptionResultFileLabel.setText("Plik wynikowy:");

        passwordLabel.setText("Hasło:");

        runDescryptionButton.setBackground(new java.awt.Color(51, 255, 51));
        runDescryptionButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        runDescryptionButton.setText("  DESZYFRUJ");
        runDescryptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runDescryptionButtonActionPerformed(evt);
            }
        });

        usersList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(usersList2);

        recipientsListLabel.setText("Lista odbiorców:");

        javax.swing.GroupLayout decryptionPanelLayout = new javax.swing.GroupLayout(decryptionPanel);
        decryptionPanel.setLayout(decryptionPanelLayout);
        decryptionPanelLayout.setHorizontalGroup(
            decryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(decryptionPanelLayout.createSequentialGroup()
                .addGroup(decryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(decryptionPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(decryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(decryptionPanelLayout.createSequentialGroup()
                                .addGroup(decryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(decryptionFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(decryptionFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(decryptionFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(decryptionPanelLayout.createSequentialGroup()
                                .addGroup(decryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(decryptionResultFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(decryptionResultFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(decryptionFileResultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(decryptionPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, decryptionPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(runDescryptionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(decryptionPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(decryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(recipientsListLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        decryptionPanelLayout.setVerticalGroup(
            decryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(decryptionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(decryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(decryptionPanelLayout.createSequentialGroup()
                        .addComponent(decryptionFileLabel)
                        .addGap(6, 6, 6)
                        .addComponent(decryptionFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(decryptionFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(decryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(decryptionPanelLayout.createSequentialGroup()
                        .addComponent(decryptionResultFileLabel)
                        .addGap(6, 6, 6)
                        .addComponent(decryptionResultFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(decryptionFileResultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(recipientsListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(runDescryptionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Deszyfrowanie", decryptionPanel);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane)
        );

        mainTabbedPane.getAccessibleContext().setAccessibleDescription("");

        fileMenuBar.setText("Plik");

        programMenuItem2.setText("O programie");
        programMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programMenuItem2ActionPerformed(evt);
            }
        });
        fileMenuBar.add(programMenuItem2);

        authorMenuItem.setText("O Autorze");
        authorMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorMenuItemActionPerformed(evt);
            }
        });
        fileMenuBar.add(authorMenuItem);

        exitMenuItem.setText("Zakończ");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenuBar.add(exitMenuItem);

        mainManuBar.add(fileMenuBar);

        helpMenuBar.setText("Pomoc");

        instructionMenuItem.setText("Instrukcja");
        instructionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructionMenuItemActionPerformed(evt);
            }
        });
        helpMenuBar.add(instructionMenuItem);

        mainManuBar.add(helpMenuBar);

        setJMenuBar(mainManuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void authorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorMenuItemActionPerformed
        JOptionPane.showMessageDialog(null, "Twórcą i właścicielem programu jest Mikołaj Szotowicz. "
                + "\n  \t\t     Copyright (C) 2017. All rights reserved.", "O autorze", 1);
        
// ciphering private keys
//        RC6BouncyCastle rc6BouncyCastle = new RC6BouncyCastle();
//        rc6BouncyCastle.encrypt("C:\\Users\\Mikołaj\\Desktop\\BSK 2017\\BSK projekt\\Szyfrator\\lib\\private\\odbiorca1.key", 
//                "C:\\Users\\Mikołaj\\Desktop\\BSK 2017\\BSK projekt\\Szyfrator\\lib\\private\\odbiorca1-enc.key", 
//                encryptPassword("odbiorca1"), 
//                "ECB", 
//                128, 
//                8);
//        rc6BouncyCastle.encrypt("C:\\Users\\Mikołaj\\Desktop\\BSK 2017\\BSK projekt\\Szyfrator\\lib\\private\\odbiorca2.key", 
//                "C:\\Users\\Mikołaj\\Desktop\\BSK 2017\\BSK projekt\\Szyfrator\\lib\\private\\odbiorca2-enc.key", 
//                encryptPassword("odbiorca2"), 
//                "ECB", 
//                128, 
//                8);
//        rc6BouncyCastle.encrypt("C:\\Users\\Mikołaj\\Desktop\\BSK 2017\\BSK projekt\\Szyfrator\\lib\\private\\odbiorca3.key", 
//                "C:\\Users\\Mikołaj\\Desktop\\BSK 2017\\BSK projekt\\Szyfrator\\lib\\private\\odbiorca3-enc.key", 
//                encryptPassword("odbiorca3"), 
//                "ECB", 
//                128, 
//                8);
//        rc6BouncyCastle.encrypt("C:\\Users\\Mikołaj\\Desktop\\BSK 2017\\BSK projekt\\Szyfrator\\lib\\private\\odbiorca4.key", 
//                "C:\\Users\\Mikołaj\\Desktop\\BSK 2017\\BSK projekt\\Szyfrator\\lib\\private\\odbiorca4-enc.key", 
//                encryptPassword("odbiorca4"),  
//                "ECB", 
//                128, 
//                8);
//        rc6BouncyCastle.encrypt("C:\\Users\\Mikołaj\\Desktop\\BSK 2017\\BSK projekt\\Szyfrator\\lib\\private\\odbiorca5.key", 
//                "C:\\Users\\Mikołaj\\Desktop\\BSK 2017\\BSK projekt\\Szyfrator\\lib\\private\\odbiorca5-enc.key", 
//                encryptPassword("odbiorca5"), 
//                "ECB", 
//                128, 
//                8);
//        rc6BouncyCastle.encrypt("C:\\Users\\Mikołaj\\Desktop\\BSK 2017\\BSK projekt\\Szyfrator\\lib\\private\\odbiorca6.key", 
//                "C:\\Users\\Mikołaj\\Desktop\\BSK 2017\\BSK projekt\\Szyfrator\\lib\\private\\odbiorca6-enc.key", 
//                encryptPassword("odbiorca6"),  
//                "ECB", 
//                128, 
//                8);
//        rc6BouncyCastle.decrypt("C:\\Users\\Mikołaj\\Desktop\\BSK 2017\\BSK projekt\\Szyfrator\\lib\\private\\odbiorca1-enc.key", 
//                "C:\\Users\\Mikołaj\\Desktop\\BSK 2017\\BSK projekt\\Szyfrator\\lib\\private\\odbiorca1-dec.key", 
//                encryptPassword("odbiorca1"), 
//                "ECB", 
//                128, 
//                8);
                              
    }//GEN-LAST:event_authorMenuItemActionPerformed

    private void programMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programMenuItem2ActionPerformed
        JOptionPane.showMessageDialog(null, "Aplikacja została stworzona w ramach zajęć projektowych z "
                + "przedmiotu:   \n                           bezpieczeństwo systemów komputerowych. "
                + "\n\n -wykorzystana technologia: Java + Swing"
                + "\n -wykorzystana biblioteka: Bouncy Castle", "O programie", 1);
    }//GEN-LAST:event_programMenuItem2ActionPerformed

    private void instructionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructionMenuItemActionPerformed
        JOptionPane.showMessageDialog(null, "                >>> SZYFROWANIE: <<< " 
                + "\n 1. Wybierz plik do zaszyfrowania"
                + "\n 2. Podaj lokalizację i nazwę pliku wynikowego"
                + "\n 3. Ustaw preferencje szyfrowania (tryb pracy, dł. klucza i podbloku)"
                + "\n 4a. Korzystając z przycisku \"Dodaj nowy\" dodaj odbiorców (wybierając z domyślnego folderu)"
                + "\n 4b. Pamiętaj, że każdego odbiorce możesz usunąć, wystarczy go zaznaczyć i skorzystać z przycisku \"Usuń\""
                + "\n 5. Po zrealizowaniu powyższych instrukcji, należy sfinalizwać proces szyfrowania (\"Szyfruj\")"
                + "\n\n           >>> ODSZYFROWYWANIE <<<"
                + "\n 1. Wybierz plik do odszyfrowania, pamiętaj, że powinien być on oryginalnym plikiem programu"
                + "\n 2. Podaj lokalizację i nazwę pliku wynikowego"
                + "\n 3. Z listy odbiorców wybranego pliku należy wybrać swój identyfikator (nazwę) oraz wprowadzić hasło w polu tekstowym poniżej"
                + "\n 4. Po zrealizowaniu powyższych instrukcji, należy sfinalizwać proces odszyfrowania (\"Deszyfruj\")", "Instrukcja", 1);
        
    }//GEN-LAST:event_instructionMenuItemActionPerformed

    private void encryptionFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptionFileButtonActionPerformed
        JFileChooser fc = new JFileChooser(pathChooserDefaultDirectory);
        fc.setDialogTitle("Wybierz plik do zaszyfrowania");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.showOpenDialog(this);
        try {
            if (fc.getSelectedFile().exists()) {
                encryptionFile = fc.getSelectedFile();
                encryptionFileTextField.setText(encryptionFile.getAbsolutePath());
//                System.out.println(encryptionFile.getAbsolutePath());
            } else {
                encryptionFileTextField.setText("");
                JOptionPane.showMessageDialog(null, "Podany plik nie istnieje!", "Uwaga", 0);
            }
        } catch (Exception e) {
            System.out.println("file is not selected");
        }
    }//GEN-LAST:event_encryptionFileButtonActionPerformed

    private void encryptionFileResultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptionFileResultButtonActionPerformed
        JFileChooser fc = new JFileChooser(pathChooserDefaultDirectory);
        fc.setDialogTitle("Zapisz jako");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        fc.showOpenDialog(this);

        try {
//            String extension = "";
//            extension = fc.getSelectedFile().getName().substring(fc.getSelectedFile().getName().lastIndexOf('.'));
//          
            if (!fc.getSelectedFile().exists()) {
                encryptionFileResult = fc.getSelectedFile();
                encryptionResultFileTextField.setText(encryptionFileResult.getAbsolutePath());
                //System.out.println(encryptionFileResult);
            } else {
                int reply = JOptionPane.showConfirmDialog(null, "Czy chcesz nadpisać istniejący plik?", "Uwaga", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    encryptionFileResult = fc.getSelectedFile();
                    encryptionResultFileTextField.setText(encryptionFileResult.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            System.out.println("file result is not selected");
        }
    }//GEN-LAST:event_encryptionFileResultButtonActionPerformed

    private void operatingModeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operatingModeComboBoxActionPerformed
        operatingMode = operatingModeComboBox.getSelectedItem().toString();
        if(operatingMode.equals("CFB") || operatingMode.equals("OFB")){
            subblockSizeLabelComboBox.setEnabled(true);
        } else{
            subblockSizeLabelComboBox.setEnabled(false);
        }
        //System.out.println(operatingMode);
    }//GEN-LAST:event_operatingModeComboBoxActionPerformed

    private void keySizeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keySizeComboBoxActionPerformed
        keySize = Integer.parseInt( keySizeComboBox.getSelectedItem().toString() );
        //System.out.println(keySize);
    }//GEN-LAST:event_keySizeComboBoxActionPerformed

    private void subblockSizeLabelComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subblockSizeLabelComboBoxActionPerformed
        subblockSize = Integer.parseInt( subblockSizeLabelComboBox.getSelectedItem().toString() );
        //System.out.println(subblockSize);
    }//GEN-LAST:event_subblockSizeLabelComboBoxActionPerformed

    private void addNewUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewUserButtonActionPerformed
        try {
            JFileChooser fc = new JFileChooser(pathMyPublicKeys);
            fc.setDialogTitle("Wybierz odbiorce:");
            fc.showOpenDialog(this);
            try {
                
                ListModel<String> myModel = usersList.getModel();
                DefaultListModel newModel = new DefaultListModel();
                if (myModel == null) {
                    myModel = new DefaultListModel();
                    System.out.println("myModel == null");
                }else{
                    for (int i = 0; i < myModel.getSize(); i++) {
                        newModel.addElement(myModel.getElementAt(i));
                    }
                    
                    Object newRecipient = (Object) fc.getSelectedFile().getName().replaceFirst("[.][^.]+$", "");

                    String absolutePath = fc.getSelectedFile().getParent().replace('\\', '/') + '/';
                    if (!absolutePath.contains(pathMyPublicKeys)) {
                        JOptionPane.showMessageDialog(null, "Błąd! Wybierz odbiorców z katalogu domyślnego ("
                                + pathMyPublicKeys + ")", "Błąd", 0);
                    } else {
                        boolean isExist = false;
                        for (int i = 0; i < newModel.size(); i++) {
                            if (newModel.get(i).equals(newRecipient)) {
                                JOptionPane.showMessageDialog(null, "Wybrany odbiorca jest już obecny na liście", "Uwaga", 2);
                                isExist = true;
                                break;
                            }
                        }
                        if (!isExist) {
                            newModel.addElement(newRecipient);
                            usersList.setModel(newModel);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: file is not selected / add recipient");
            }
        } catch (Exception e) {
            System.out.println("Error: add recipient");
        }

    }//GEN-LAST:event_addNewUserButtonActionPerformed

    private void deleteUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserButtonActionPerformed
        try {
            ListModel myModel = usersList.getModel();
            DefaultListModel newModel = new DefaultListModel();
                    for (int i = 0; i < myModel.getSize(); i++) {
                        newModel.addElement(myModel.getElementAt(i));
                    }
            int selectedIndex = usersList.getSelectedIndex();
            if(selectedIndex != -1){
                newModel.remove(selectedIndex);
                usersList.setModel(newModel);
            }
        } catch (Exception e) {
            System.out.println("Error: delete recipient");
        }
    }//GEN-LAST:event_deleteUserButtonActionPerformed

    private void runEncryptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runEncryptionButtonActionPerformed
        
        if(encryptionFileTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nie wybrano pliku!", "Warning", 2);
        }else if(encryptionResultFileTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nie wybrano miejsca zapisu!", "Warning", 2);
        }else if(usersList.getModel().getSize() < 1){
            JOptionPane.showMessageDialog(null, "Nie wybrano odbiorców!", "Warning", 2);
        }else{
            jProgressBar1.setValue(0);
            jProgressBar1.setString("0%");
            
            sessionKeyEncryptPanel = generateSessionKey();
            System.out.println("sesyjny: " + sessionKeyEncryptPanel);
            
            for(int i = 0; i < usersList.getModel().getSize(); i++){
                recipientList.add(usersList.getModel().getElementAt(i));
            }
            
            byte[] IV = generateIV(16);

            if (createXmlAfterEncrypting(IV)) {
                
                RC6BouncyCastle algr = new RC6BouncyCastle();
                algr.encrypt(encryptionFile.getAbsolutePath(), encryptionFileResult.getAbsolutePath(), sessionKeyEncryptPanel, operatingMode, keySize, subblockSize, IV);
//                algr.decrypt(encryptionFileResult.getAbsolutePath(), "C:\\Users\\Mikołaj\\Desktop\\BSK 2017\\BSK projekt\\Szyfrator\\myworkspace\\chuj.xml", sessionKeyEncryptPanel, operatingMode, keySize, subblockSize);
//                algr.readCryptogram(encryptionFileResult.getAbsolutePath());
                

                //END
                String nameFile = encryptionFile.getName();
                clearDataAfterEncrypting();
                jProgressBar1.setValue(100);
                jProgressBar1.setString("100%");
                JOptionPane.showMessageDialog(null, "Plik \"" + nameFile + "\" został pomyślnie zaszyfrowany", "Success", 1);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Coś poszło nie tak! Upewnij się, że wszystkie wymagane dane są prawidłowo podane. "
                        + "W razie problemu skorzystać z instrukcji dostępnej w menu programu.", "Error", 0);
            }
        }
    }//GEN-LAST:event_runEncryptionButtonActionPerformed
        
    /*
        DESCRYPTION METHODS
    */
    private void decryptionFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptionFileButtonActionPerformed
        JFileChooser fc = new JFileChooser(pathChooserDefaultDirectory);
        fc.setDialogTitle("Wybierz plik do odszyfrowania");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.showOpenDialog(this);
        try {
            
            if (fc.getSelectedFile().exists()) {
                decryptionFile = fc.getSelectedFile();
                if (setRecipiensToList()) {
                    decryptionFileTextField.setText(decryptionFile.getAbsolutePath());
                } else {
                    decryptionFile = null;
                    JOptionPane.showMessageDialog(null, "Upewnij się, że wybrałeś poprawny plik", "Błąd", 0);
                }
                //System.out.println(decryptionFile.getAbsolutePath());
            } else {
                encryptionFileTextField.setText("");
                JOptionPane.showMessageDialog(null, "Podany plik nie istnieje!", "Uwaga", 0);
            }
            
        } catch (Exception e) {
            System.out.println("file is not selected");
        }
        
    }//GEN-LAST:event_decryptionFileButtonActionPerformed

    private void decryptionFileResultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptionFileResultButtonActionPerformed
        JFileChooser fc = new JFileChooser(pathChooserDefaultDirectory);
        fc.setDialogTitle("Zapisz jako");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.showOpenDialog(this);
        try {
            if (!fc.getSelectedFile().exists()) {
                decryptionFileResult = fc.getSelectedFile();
                decryptionResultFileTextField.setText(decryptionFileResult.toString());
//                System.out.println(encryptionFileResult);
            } else {
                int reply = JOptionPane.showConfirmDialog(null, "Czy chcesz nadpisać istniejący plik?", "Uwaga", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    decryptionFileResult = fc.getSelectedFile();
                    decryptionResultFileTextField.setText(decryptionFileResult.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            System.out.println("file result is not selected");
        }
    }//GEN-LAST:event_decryptionFileResultButtonActionPerformed

    private void runDescryptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runDescryptionButtonActionPerformed
        if(decryptionFileTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nie wybrano pliku!", "Warning", 2);
        }else if(decryptionResultFileTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nie wybrano miejsca zapisu!", "Warning", 2);
        }else if(passwordField.getPassword().length == 0){
            JOptionPane.showMessageDialog(null, "Nie podano hasła!", "Warning", 2);
        }else{
            if(usersList2.isSelectionEmpty()){
                JOptionPane.showMessageDialog(null, "Z listy odbiorców wybierz swój identyfikator!", "Warning", 2);
            }else{
                jProgressBar2.setValue(0);
                jProgressBar2.setString("0%");
                
                String cipherMode = getCipherMode(); 
                
                if(cipherMode.equals("ECB") || cipherMode.equals("CBC") || cipherMode.equals("CFB") || cipherMode.equals("OFB")){
                    int currentKeySize = 0;
                    int currentSubblockSize = 0;
                    byte[] currentVector = null;
                    
                    currentKeySize = getKeySize();
                    if(cipherMode.equals("CFB") || cipherMode.equals("OFB")){
                        currentSubblockSize = getSubblockSize();
                    }
                    if(!cipherMode.equals("ECB")){
                        currentVector = getVector();
                    }
//                    JOptionPane.showMessageDialog(null, "mode: " + cipherMode + " key: " + currentKeySize + " sub: " + currentSubblockSize , "Warning", 2);
                    
                    String passwordSHA = new String(passwordField.getPassword());
                    passwordSHA = encryptPassword(passwordSHA);
                    String inPath = pathMyPrivateKeys + usersList2.getSelectedValue() + ".key";
                    inPath = inPath.replace("/", "\\");
                    String outPath = pathMyPrivateKeys + usersList2.getSelectedValue() + "-2.key";
                    
                    System.out.println("aaaa " + inPath);
                    
                    inPath = "C:\\Users\\Mikołaj\\Desktop\\BSK 2017\\BSK projekt\\Szyfrator\\" + (pathMyPrivateKeys + usersList2.getSelectedValue() + ".key").replace("/", "\\");
                    
                    char[] userNameChar = usersList2.getSelectedValue().toCharArray();
                    int len = 0;
                    for(int i = 0; i < userNameChar.length; i++){
                        if(userNameChar[i] > 0)
                            len++;
                    }
                    String userName = "";
                    for(int i = 0; i < len; i++){
                        userName += userNameChar[i];
                    }
                    
                    RC6BouncyCastle rc6 = new RC6BouncyCastle();
                    switch(userName){
                        case "odbiorca1":{
                            rc6.decryptKey("lib\\private\\odbiorca1.key", "bin\\odbiorca1.key", passwordSHA, "ECB", 128, 8, null);
                            break;
                        }
                        case "odbiorca2":{
                            rc6.decryptKey("lib\\private\\odbiorca2.key", "bin\\odbiorca2.key", passwordSHA, "ECB", 128, 8, null);
                            break;
                        }
                        case "odbiorca3":{
                            rc6.decryptKey("lib\\private\\odbiorca3.key", "bin\\odbiorca3.key", passwordSHA, "ECB", 128, 8, null);
                            break;
                        }
                        case "odbiorca4":{
                            rc6.decryptKey("lib\\private\\odbiorca4.key", "bin\\odbiorca4.key", passwordSHA, "ECB", 128, 8, null);
                            break;
                        }
                        case "odbiorca5":{
                            rc6.decryptKey("lib\\private\\odbiorca5.key", "bin\\odbiorca5.key", passwordSHA, "ECB", 128, 8, null);
                            break;
                        }
                        case "odbiorca6":{
                            rc6.decryptKey("lib\\private\\odbiorca6.key", "bin\\odbiorca6.key", passwordSHA, "ECB", 128, 8, null);
                            break;
                        }
                    }
//                    rc6.decryptKey("lib\\private\\odbiorca4.key", "bin\\odbiorca4.key", passwordSHA, "ECB", 128, 8, null);
                    
                    String myPrivKey = "";
                    try {
                        FileReader input = new FileReader(new File("bin\\" + userName + ".key"));
                        BufferedReader bufRead = new BufferedReader(input);
                        myPrivKey = bufRead.readLine();
                    
                        System.out.println("KLUCZ: " + myPrivKey);
                        input.close();
                        bufRead.close();
                        
                        byte[] keyBytes2 = Base64.decode(myPrivKey);
                        PKCS8EncodedKeySpec spec2 = new PKCS8EncodedKeySpec(keyBytes2);
                        KeyFactory kf2 = KeyFactory.getInstance("RSA");
                        PrivateKey privateKey = kf2.generatePrivate(spec2);

                        byte[] cipherTextSK = getSessionKeyFromFile(userName);

                        String odp = decryptToStringRSA(cipherTextSK, privateKey);
                        System.out.println("Raczej sesyjny: " + odp);
                        rc6.decrypt(decryptionFile.getAbsolutePath(), decryptionFileResult.getAbsolutePath(), odp, cipherMode, currentKeySize, currentSubblockSize, currentVector);
                        
                    } catch (Exception e) {
                        System.out.println("Error: decrypt");
                        rc6.decrypt(decryptionFile.getAbsolutePath(), decryptionFileResult.getAbsolutePath(), passwordSHA, cipherMode, currentKeySize, currentSubblockSize, currentVector);
                    }
                    
                    
                    switch(userName){
                        case "odbiorca1":{
                            File f = new File("bin\\odbiorca1.key");
                            f.delete();
                            break;
                        }
                        case "odbiorca2":{
                            File f = new File("bin\\odbiorca2.key");
                            f.delete();
                            break;
                        }
                        case "odbiorca3":{
                            File f = new File("bin\\odbiorca3.key");
                            f.delete();
                            break;
                        }
                        case "odbiorca4":{
                        try {
                            System.out.println("DEL");
                            Files.delete(Paths.get("bin\\odbiorca4.key"));
                        } catch (IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                            break;
                        }
                        case "odbiorca5":{
                            File f = new File("bin\\odbiorca5.key");
                            f.delete();
                            break;
                        }
                        case "odbiorca6":{
                            File f = new File("bin\\odbiorca6.key");
                            f.delete();
                            break;
                        }
                    }
                    
                    //TODO
//                    RC6BouncyCastle rc6 = new RC6BouncyCastle();
//                    rc6.decrypt(decryptionFile.getAbsolutePath(), decryptionFileResult.getAbsolutePath(), "yYNGx9jm0InXtvSUcjLDPnaAffFGahRdhOG5o3xvokw=", cipherMode, currentKeySize, currentSubblockSize, currentVector);
                    
                    jProgressBar2.setValue(100);
                    jProgressBar2.setString("100%");
                    JOptionPane.showMessageDialog(null, "Deszyfrowanie pliku zakończone", "Success", 1);
                    clearDataAfterEncrypting();
                    
                } else{
                    JOptionPane.showMessageDialog(null, "Wybrany plik nie jest obsługiwany przez deszyfrator, upewnij się, że wybrano poprawny plik.", "Warning", 2);
                }
            }
        }
    }//GEN-LAST:event_runDescryptionButtonActionPerformed
    
    ////////////////////////////////////////////////////////////////////////////////////////////
    /*
        ADDITIONAL METHODS
    */
    ////////////////////////////////////////////////////////////////////////////////////////////
    
    private static String encryptPassword(String password) {
        
        MessageDigest crypt = null;
        try {
            crypt = MessageDigest.getInstance("SHA-256");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return new BigInteger(1, crypt.digest()).toString(16);
    }
    
    private byte[] encryptStrigRSA(String text, PublicKey key) {
        byte[] cipherText = null;
        try {
            final Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            cipherText = cipher.doFinal(text.getBytes());
        } catch (Exception e) {
            System.out.println("Error: encryptStringRSA");
        }

        return cipherText;
    }

    private String decryptToStringRSA(byte[] text, PrivateKey key) {
        byte[] dectyptedText = null;
        try {
            final Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, key);
            dectyptedText = cipher.doFinal(text);

        } catch (Exception ex) {
            System.out.println("Error: decryptToStringRSA");
        }

        return new String(dectyptedText);
    }
    
    private boolean createXmlAfterEncrypting(byte[] vector) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(encryptionFileResult)));
            out.println("<EncryptedFile>");
            out.println("<Algorith>RC6</Algorith>");
            out.println("<BlockSize>128</<BlockSize>");
            out.println("<CipherMode>" + operatingMode + "</CipherMode>");
            out.println("<KeySize>" + String.valueOf(keySize) + "</KeySize>");
            if(operatingMode.equals("CFB") || operatingMode.equals("OFB")) {
                out.println("<SubblockSize>" + String.valueOf(subblockSize) + "</SubblockSize>");
            }
            if(!operatingMode.equals("ECB")) { 
                out.println("<IV>");
                out.println(Base64.encode(vector));
                out.println("</IV>");
            }
            
            out.println("<ApprovedUsers>");
            
            for (int i = 0; i < recipientList.size(); i++) {
                out.println("<User>");
                out.println("<Name>" + recipientList.get(i).toString() + "</Name>");
                //encrypt session key with publick key reciper
                try {
                    String myPathEncryptedSessionKey = pathMyPublicKeys + recipientList.get(i) + ".key";
                    File publicKeyFile = new File(myPathEncryptedSessionKey);
                    Scanner in = new Scanner(publicKeyFile);
                    String key = in.nextLine();
                    while(!key.equals("<Modulus>")){
                        key = in.nextLine();
                    }
                    key = in.nextLine();
                    byte[] keyBytes = Base64.decode(key);
                    X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
                    KeyFactory kf = KeyFactory.getInstance("RSA");
                    PublicKey publicKey = kf.generatePublic(spec);
                    byte[] cipherText = encryptStrigRSA(sessionKeyEncryptPanel, publicKey);
                    String cipherTextString = Base64.encode(cipherText);
                    
                    ///check
                    System.out.println("pub---- " + key);
//                    
//                    String myPathEncryptedSessionKey2 = pathMyPrivateKeys + recipientList.get(i) + ".key";
//                    File privateKeyFile = new File(myPathEncryptedSessionKey2);
//                    Scanner in2 = new Scanner(privateKeyFile);
//                    String key2 = in2.nextLine();
//                    System.out.println("priv---- " + key2);
//                    
//                    byte[] keyBytes2 = Base64.decode(key2);
//                    PKCS8EncodedKeySpec spec2 = new PKCS8EncodedKeySpec(keyBytes2);
//                    KeyFactory kf2 = KeyFactory.getInstance("RSA");
//                    PrivateKey privateKey = kf2.generatePrivate(spec2);
//                    String odp = decryptToStringRSA(cipherText, privateKey);
//                    System.out.println("ODP: " + odp);
                    ///end of check
                    
                    out.println("<SessionKey>");
                    out.println(cipherTextString);
                    out.println("</SessionKey>");
                    
                } catch (Exception e) {
                    System.out.println("Error: createXmlAfterEncrypting (encrypt session key) ");
                }
                out.println("</User>");
            }
            
            out.println("</ApprovedUsers>");
            out.println("</EncryptedFile>");
            out.close();

            System.out.println("File is saved!");
            return true;
        } catch (Exception e) {
            System.out.println("Error: createEncryptedXML ");
        }
        return false;
    }
    
    private String generateSessionKey(){ 
        byte [] sessionKeyBytes = new byte[keySize / 8];
        secureRandom.nextBytes(sessionKeyBytes);
        return Base64.encode(sessionKeyBytes);

    }
    
    private static byte[] generateIV(int sizeBlock) {
        byte [] ivBytes = new byte[sizeBlock];
        secureRandomIV.nextBytes(ivBytes);
        return ivBytes;
    }
    
    private void clearDataAfterEncrypting(){
        
        encryptionFile = null;
        encryptionFileTextField.setText("");
        encryptionFileResult = null;
        encryptionResultFileTextField.setText("");
        usersList.clearSelection();
        usersList.setModel(new DefaultListModel());
        sessionKeyEncryptPanel = "";
        
        decryptionFile = null;
        decryptionFileTextField.setText("");
        decryptionFileResult = null;
        decryptionResultFileTextField.setText("");
        usersList2.clearSelection();
        usersList2.setModel(new DefaultListModel());
        sessionKeyDecryptPanel = "";
        passwordField.setText("");
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////
    
    private boolean setRecipiensToList() {
        try {
            DefaultListModel newModel = new DefaultListModel();
            FileReader input = new FileReader(decryptionFile);
            BufferedReader bufRead = new BufferedReader(input);
            String myLine = bufRead.readLine();

            while (myLine != null && !myLine.equals("</ApprovedUsers>")) {
                char[] lineCharArray = myLine.toCharArray();
                char[] buffer = new char[lineCharArray.length];
                int count = 0;
                
                if(lineCharArray[1] == 'N' && lineCharArray[2] == 'a'){
                    for(int i = 6; i < lineCharArray.length - 7; i++){
                        buffer[count++] = lineCharArray[i];
                    }
                    newModel.addElement(new String(buffer));
                }
                myLine = bufRead.readLine();
            }
            usersList2.setModel(newModel);
        } catch (Exception e) {
            System.out.println("Error / setRecipiensToList");
            return false;
        }
        return true;
    }
    
    private int getKeySize(){
        int myKeySize = 0;
        try {
            String keyTMP = "";
            FileReader input = new FileReader(decryptionFile);
            BufferedReader bufRead = new BufferedReader(input);
            String myLine = bufRead.readLine();

            while (myLine != null && !myLine.equals("</ApprovedUsers>")) {
                char[] lineCharArray = myLine.toCharArray();
                char[] buffer = new char[3];
                int count = 0;
                
                if(lineCharArray[1] == 'K' && lineCharArray[2] == 'e'){
                    for(int i = 9; i < lineCharArray.length - 10; i++){
                        buffer[count++] = lineCharArray[i];
                    }
                    keyTMP=new String(buffer);
                    myKeySize = Integer.parseInt(keyTMP);
                    break;
                }
                myLine = bufRead.readLine();
            }
            System.out.println("KeySize: " + myKeySize);
            
        } catch (Exception e) {
            System.out.println("Error / getKeySize");
        }
        return myKeySize;
    }
    
    private String getCipherMode(){
        String myMode = "";
        try {
            FileReader input = new FileReader(decryptionFile);
            BufferedReader bufRead = new BufferedReader(input);
            String myLine = bufRead.readLine();

            while (myLine != null && !myLine.equals("</ApprovedUsers>")) {
                char[] lineCharArray = myLine.toCharArray();
                char[] buffer = new char[3];
                int count = 0;
                
                if(lineCharArray[1] == 'C' && lineCharArray[2] == 'i'){
                    for(int i = 12; i < lineCharArray.length - 13; i++){
                        buffer[count++] = lineCharArray[i];
                    }
                    myMode=new String(buffer);
                    break;
                }
                myLine = bufRead.readLine();
            }
            System.out.println("CipherMode: " + myMode);
            
        } catch (Exception e) {
            System.out.println("Error: getCipherMode");
        }
        return myMode;
    }
    
    private int getSubblockSize() {
        int mySubblockSize = 0;
        try {
            String subblockTMP = "";
            FileReader input = new FileReader(decryptionFile);
            BufferedReader bufRead = new BufferedReader(input);
            String myLine = bufRead.readLine();

            while (myLine != null && !myLine.equals("</ApprovedUsers>")) {
                char[] lineCharArray = myLine.toCharArray();
                char[] buffer = new char[3];
                int count = 0;

                if (lineCharArray[1] == 'S' && lineCharArray[2] == 'u') {
                    for (int i = 14; i < lineCharArray.length - 15; i++) {
                        buffer[count++] = lineCharArray[i];
                    }
                    int size = 0;
                    for(int i = 0 ; i < 3 && buffer[i] != 0; i++)
                            size++;
                    
                    char[] tmp = new char[size];
                    for(int i = 0 ; i < size; i++)
                            tmp[i] = buffer[i];
                    
                    subblockTMP = String.copyValueOf(tmp);
                    mySubblockSize = Integer.parseInt(subblockTMP);
                    break;
                }
                myLine = bufRead.readLine();
            }
            System.out.println("mySubblockSize: " + mySubblockSize);
            
        } catch (Exception e) {
            System.out.println("Error: getSubblockSize");
        }
        return mySubblockSize;
    }
    
    private byte[] getVector(){
        byte[] myByteVector = null;
        String myVector = "";
        try {
            String subblockTMP = "";
            FileReader input = new FileReader(decryptionFile);
            BufferedReader bufRead = new BufferedReader(input);
            String myLine = bufRead.readLine();

            while (myLine != null && !myLine.equals("</ApprovedUsers>")) {
                if(myLine.equals("<IV>")){
                    myLine = bufRead.readLine();
                    myByteVector = Base64.decode(myLine);
                    break;
                }
                myLine = bufRead.readLine();
            }
            System.out.println("myVector: " + myLine);
            
        } catch (Exception e) {
            System.out.println("Error: getVector");
        }
        return myByteVector;
    }
    
    private byte[] getSessionKeyFromFile(String name) {
        byte [] myByteSessionKey = null;
        try {
            FileReader input = new FileReader(decryptionFile);
            BufferedReader bufRead = new BufferedReader(input);
            String myLine = bufRead.readLine();

            char[] tmpName = new char[9];
            char[] tmpChar = name.toCharArray();
            for (int i = 0; i < tmpName.length; i++) {
                tmpName[i] = tmpChar[i];
            }
            String nowy = new String(tmpName);

            while (myLine != null && !myLine.equals("</ApprovedUsers>")) {
                if(myLine.equals("<Name>" + name + "</Name>")){
                    myLine = bufRead.readLine();
                    myLine = bufRead.readLine();
                    System.out.println("SESSION READED: " + myLine);
                    myByteSessionKey = Base64.decode(myLine);
                    break;
                }
                myLine = bufRead.readLine();
            }
            
            return myByteSessionKey;
        } catch (Exception e) {
            System.out.println("Error: getSessionKeyFromFile");
        }
        
        return null;
    }
    
    
    
    
    ////////////////////////////////////////////////////
    /////////////////raczej niewazne////////////////////
    ////////////////////////////////////////
    
    private boolean checkInputFile(){
        try {
            File file = decryptionFile;
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            
            String nameAlgoritm = doc.getElementsByTagName("Algorith").item(0).getTextContent();
//            System.out.println("algoritm: " + nameAlgoritm);
            if(!nameAlgoritm.equals("RC6")){
                return false;
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    
    private String getSessionKeyDecrypt(){
        String encryptedSessionKey = "";
        String decryptedSessionKey = "";
        
        try {
            File file = decryptionFile;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            
            NodeList nodeLst = doc.getElementsByTagName("Name");
            for (int s = 0; s < nodeLst.getLength(); s++) {
                if(nodeLst.item(s).getTextContent().equals(usersList2.getSelectedValue())){
                    Node parentNode = nodeLst.item(s).getParentNode();
                    Element passwordElmnt = (Element) parentNode;
                    encryptedSessionKey = passwordElmnt.getElementsByTagName("SessionKey").item(0).getTextContent();
                    break;
                }
            }
//            System.out.println(encryptedSessionKey);
            byte[] encryptedSessionKeyByteVersion = Base64.decode(encryptedSessionKey);
            
            String myPathEncryptedSessionKey = pathMyPrivateKeys + usersList2.getSelectedValue() + ".key";
            File privateKeyFile = new File(myPathEncryptedSessionKey);
            Scanner in2 = new Scanner(privateKeyFile);
            String key2 = in2.nextLine();
//            System.out.println("pvt---- " + key2);

            byte[] keyBytes2 = Base64.decode(key2);
            PKCS8EncodedKeySpec spec2 = new PKCS8EncodedKeySpec(keyBytes2);
            KeyFactory kf2 = KeyFactory.getInstance("RSA");
            PrivateKey pvtKey = kf2.generatePrivate(spec2);

            decryptedSessionKey = decryptToStringRSA(encryptedSessionKeyByteVersion, pvtKey);
//            System.out.println("Decrypted: " + decryptedSessionKey);
            
        } catch (Exception e) {
            System.out.println("Error: getSessionKeyDecrypt");
        }
        
        return decryptedSessionKey;
    }
    
    private String getNameNewFile(){
        String name = "";
        try {
            File file = decryptionFile;
             
            // TODO
            //   parsuj nazwe
            
        } catch (Exception e) {
            System.out.println("Error: getNameNewFile");
        }
        return name;
    }
        
    private boolean checkPasswordCorrectness() {
        try {
            String password = new String(passwordField.getPassword());
            MessageDigest crypt = MessageDigest.getInstance("SHA-256");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));

            String passwordSHA = new BigInteger(1, crypt.digest()).toString(16);
            System.out.println("CHECKpasswordSHA: " + password + " --- " + passwordSHA);
            
            return true;
        } catch (Exception e) {
        }

        

        return false;
    }
    
    
    ///////////////////////////////////////   RC 6   ////////////////////////////////////////
    
    private boolean createEncryptedFile() {
        sessionKeyEncryptPanel = generateSessionKey();
//        System.out.println("sesyjny: " + sessionKeyEncryptPanel);


        if(sessionKeyEncryptPanel.equals("")){
            System.out.println("Error: createEncryptedFile / session key is null");
            return false;
        }
        byte[] data = null;
        byte[] key = null;
        byte[] result = null;
        
        try {
            data = Files.readAllBytes(Paths.get(encryptionFile.getPath()));
        } catch (Exception e) {
            System.out.println("Error: createEncryptedFile / read file");
        }
        
        try {
            key = sessionKeyEncryptPanel.getBytes();
        } catch (Exception e) {
            System.out.println("Error: createEncryptedFile / get session key");
        }
        
        try {
            result = myRC6.encrypt(data, key);
        } catch (Exception e) {
            System.out.println("Error: createEncryptedFile / encrypt RC6");
        }
        
        try {
            String pathResult = encryptionFileResult + "/" + encryptionFile.getName().replaceFirst("[.][^.]+$", "") + ".mss"  ;
            
//            PrintWriter pvt2 = new PrintWriter(pathResult);
//            pvt2.print(Base64.encode(result));
//            pvt2.close();
            
            FileOutputStream fos = new FileOutputStream(pathResult);
            fos.write(result);
            fos.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("Error: createEncryptedFile / save file");
        }
        
        return false;
    }
    
    private boolean createDecryptedFile(String newName){
        
        if(sessionKeyDecryptPanel.equals("")){
            System.out.println("Error: creatDecryptedFile / session key is null");
            return false;
        }
        byte[] data = null;
        byte[] key = null;
        byte[] result = null;
        
        try {
            data = Files.readAllBytes(Paths.get(decryptionFile.getPath()));
//        String as = Files.readAllLines(Paths.get(decryptionFile.getPath().toString())).get(0);
//        System.out.println("as: " + as);
//        data = Base64.decode(as);
        } catch (Exception e) {
            System.out.println("Error: creatDecryptedFile / read file");
        }
        
        try {
            key = sessionKeyDecryptPanel.getBytes();
        } catch (Exception e) {
            System.out.println("Error: creatDecryptedFile / get session key");
        }
        
        try {
            result = myRC6.decrypt(data, key);
        } catch (Exception e) {
            System.out.println("Error: creatDecryptedFile / decrypt RC6");
        }
        
        try {
//            String pathResult = decryptionFileResult + "/" + decryptionFile.getName().replaceFirst("[.][^.]+$", "") + ".xml"  ;
            String pathResult = decryptionFileResult + "/" + newName  ;
//            PrintWriter pvt2 = new PrintWriter(pathResult);
//            pvt2.print(Base64.encode(result));
//            pvt2.close();
            
            FileOutputStream fos = new FileOutputStream(pathResult);
            fos.write(result);
            fos.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("Error: creatDecryptedFile / save file");
        }
        
        return false;
    }
    
    
    private void testRC6(){
        String sesyjny = "NW0QuBLSCxyx5Y4G1XsgGQ==";
        
        Path path = Paths.get("myworkspace/qwerty.xml");
        String pathData = "myworkspace/qwerty.xml";
        String pathData2 = "myworkspace/wynik.xml";
        String pathResult = "myworkspace/wynik.mss";
        try {
            byte[] data = Files.readAllBytes(Paths.get(pathData));
//            System.out.println("lengthData: " + data.length);
            
            byte[] key = sesyjny.getBytes();
//            System.out.println("lengthKey: " + key.length);

            byte[] result = myRC6.encrypt(data, key);
//            System.out.println("lengthResult: " + result.length);
            
            // write byte[] to file  // moze trzeba BASE64?
            FileOutputStream fos = new FileOutputStream(pathResult);
            fos.write(result);
            fos.close();
            
            // try decrypt file
            byte[] data2 = Files.readAllBytes(Paths.get(pathResult));
//            System.out.println("lengthData2: " + data2.length);

            byte[] result2 = myRC6.decrypt(data2, key);

            FileOutputStream fos2 = new FileOutputStream(pathData2);
            fos2.write(result2);
            fos2.close();
            
        } catch (Exception ex) {
            System.out.println("smutno " + ex);;
        }
    }
    
    
    
    
    
    
    
    ///////////////////////////////////////////////////////////////////////
    ///////////////// OLDER VERSION ////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    private void getUsersFromXML(){
        try {
            File file = new File(pathSavedUsers);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            
            DefaultListModel newModel = new DefaultListModel();
            NodeList nodeLst = doc.getElementsByTagName("user");
            for (int s = 0; s < nodeLst.getLength(); s++) {
                Node fstNode = nodeLst.item(s);
                if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element fstElmnt = (Element) fstNode;
                    newModel.addElement(fstElmnt.getElementsByTagName("email").item(0).getTextContent());
                }
            }
            usersList.setModel(newModel);
        } catch (Exception e) {
            System.out.println("File not founds");
        }
    }
    
    private boolean checkEmailAvailability(String email){
        try {
            File file = new File(pathSavedUsers);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            
            NodeList nodeLst = doc.getElementsByTagName("email");
            for (int s = 0; s < nodeLst.getLength(); s++) {
                if(email.equals(nodeLst.item(s).getTextContent())){
                        return false;
                }
            }
        } catch (Exception e) {
            System.out.println("File not founds / checkEmailAvailability");
        }
        return true;
    }
    
    private void addUserToXML(String email, String password){
        try {
            File file = new File(pathSavedUsers);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            
            Node node = null;

            Element newPerson = doc.createElement("user");

            Element newEmail = doc.createElement("email");
            newEmail.setTextContent(email);

            //System.out.println(encryptPassword(password));
            Element newPassword = doc.createElement("password");
            newPassword.setTextContent(encryptPassword(password));

            newPerson.appendChild(newEmail);
            newPerson.appendChild(newPassword);

            node = newPerson;
            
            if(node != null){
                doc.getDocumentElement().appendChild(node);
                saveDataInXML(doc);
            }
            
        } catch (Exception e) {
            System.out.println("File not founds / addUserToXML");
        }
    }
    
    private void deleteUserFromXML(String email){
        try {
            File file = new File(pathSavedUsers);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            
            Node node = null;
            NodeList nodeLst = doc.getElementsByTagName("email");
            for (int s = 0; s < nodeLst.getLength(); s++) {
                String content = nodeLst.item(s).getTextContent();
                if(content.equals(email)){
                    node = nodeLst.item(s).getParentNode();
                }
            }
            
            if(node != null){
                doc.getDocumentElement().removeChild(node);
                saveDataInXML(doc);
            }
            
        } catch (Exception e) {
            System.out.println("File not founds / deleteUserInXML");
        }
        
    }
    
    private void saveDataInXML(Document doc){
        try {
            DOMSource source = new DOMSource(doc);
            Result result = new StreamResult(new File(pathSavedUsers));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            
            //System.out.println("Save success");
        } catch (Exception e) {
            System.out.println("Error: saveDataInXML");
        }
    }

    private void createKeyPair(String email) throws FileNotFoundException, NoSuchAlgorithmException, IOException{
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        gen.initialize(2048);
        KeyPair key = gen.generateKeyPair();
        PrivateKey privateKey = key.getPrivate();
        PublicKey publicKey = key.getPublic();
        
        byte[] privateKeyBytes = privateKey.getEncoded();
        byte[] publicKeyBytes = publicKey.getEncoded();
        
        String keyPath = pathMyPrivateKeys + email + "_pvt_" + encryptionFile.getName().replaceFirst("[.][^.]+$", "") + ".key";
        try {
            /*
            TODO
            klucze prywatnie MUSZĄ być przechowywane w postaci zaszyfrowanej w trybie ECB, 
            a kluczem szyfrującym jest skrót hasła (np. uzyskanym z hasła za pomocą funkcji 
            SHA-1, SHA-256 lub inna dobrej jakości funkcja skrótu) dostępu do klucza 
            prywatnego danego użytkownika
            */ 
            String haselo = "odbiorca1";
            MessageDigest crypt = MessageDigest.getInstance("SHA-256");
            crypt.reset();
            crypt.update(haselo.getBytes("UTF-8"));

            String haselo2 = new BigInteger(1, crypt.digest()).toString(16);
//            System.out.println("haselo: " + haselo + " -- " + haselo2);
            
//            if(checkPasswordCorrectness()){
//                ;
//            }
            
            byte[] haseloByte = haselo.getBytes();
            
            byte[] result = myRC6.encrypt(privateKeyBytes, haseloByte);
            
            String pathResult = pathMyPrivateKeys + email + "_pvt2_" + encryptionFile.getName().replaceFirst("[.][^.]+$", "") + ".key";
//            FileOutputStream fos = new FileOutputStream(pathResult);
//            fos.write(Base64.decode(Base64.encode(result)));
//            fos.close();
            PrintWriter pvt2 = new PrintWriter(pathResult);
            pvt2.print(Base64.encode(result));
            pvt2.close();

            //// end ECB pvt password
            PrintWriter pvt = new PrintWriter(keyPath);
            pvt.print( Base64.encode(privateKeyBytes));
            pvt.close();
        } catch (Exception e) {
             System.out.println("Error: create private key");
        }
        
        keyPath = pathMyPublicKeys + email + "_pub_" + encryptionFile.getName().replaceFirst("[.][^.]+$", "") + ".key";
        try {
            PrintWriter pub = new PrintWriter(keyPath);
            pub.print( Base64.encode(publicKeyBytes) );
            pub.close();
        } catch (Exception e) {
             System.out.println("Error: create public key");
        }
        
        /*
  >>>>>>>>>>      Older version    <<<<<<<<<<<
        */
        
//        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
//        gen.initialize(2048);
//        KeyPair key = gen.generateKeyPair();
//        
//        String keyPath = pathMyPrivateKeys + email + "_pvt_" + encryptionFile.getName().replaceFirst("[.][^.]+$", "") + ".key";
//        try {
//            File privateKeyFile = new File(keyPath);
//            privateKeyFile.createNewFile();
//            ObjectOutputStream privateKeyOS = new ObjectOutputStream(
//                new FileOutputStream(privateKeyFile));
//            privateKeyOS.writeObject(key.getPrivate());
//            privateKeyOS.close();
//        } catch (Exception e) {
//             System.out.println("Error: create private key");
//        }
//        
//        keyPath = pathMyPublicKeys + email + "_pub_" + encryptionFile.getName().replaceFirst("[.][^.]+$", "") + ".key";
//        try {
//            File publicKeyFile = new File(keyPath);
//            publicKeyFile.createNewFile();
//            ObjectOutputStream publicKeyOS = new ObjectOutputStream(
//                new FileOutputStream(publicKeyFile));
//            publicKeyOS.writeObject(key.getPublic());
//            publicKeyOS.close();
//        } catch (Exception e) {
//             System.out.println("Error: create public key");
//        }
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewUserButton;
    private javax.swing.JMenuItem authorMenuItem;
    private javax.swing.JButton decryptionFileButton;
    private javax.swing.JLabel decryptionFileLabel;
    private javax.swing.JButton decryptionFileResultButton;
    private javax.swing.JTextField decryptionFileTextField;
    private javax.swing.JPanel decryptionPanel;
    private javax.swing.JLabel decryptionResultFileLabel;
    private javax.swing.JTextField decryptionResultFileTextField;
    private javax.swing.JButton deleteUserButton;
    private javax.swing.JPanel ecryptionPanel;
    private javax.swing.JButton encryptionFileButton;
    private javax.swing.JLabel encryptionFileLabel;
    private javax.swing.JButton encryptionFileResultButton;
    private javax.swing.JTextField encryptionFileTextField;
    private javax.swing.JLabel encryptionResultFileLabel;
    private javax.swing.JTextField encryptionResultFileTextField;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenuBar;
    private javax.swing.JMenu helpMenuBar;
    private javax.swing.JMenuItem instructionMenuItem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> keySizeComboBox;
    private javax.swing.JLabel keySizeLabel;
    private javax.swing.JMenuBar mainManuBar;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JComboBox<String> operatingModeComboBox;
    private javax.swing.JLabel operatingModeLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JMenuItem programMenuItem2;
    private javax.swing.JLabel recipientsListLabel;
    private javax.swing.JButton runDescryptionButton;
    private javax.swing.JButton runEncryptionButton;
    private javax.swing.JLabel subblockSizeLabel;
    private javax.swing.JComboBox<String> subblockSizeLabelComboBox;
    private javax.swing.JList<String> usersList;
    private javax.swing.JList<String> usersList2;
    private javax.swing.JPanel usersPanel;
    // End of variables declaration//GEN-END:variables

}
