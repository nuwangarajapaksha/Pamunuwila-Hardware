/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.HomeModel;
import org.apache.log4j.Logger;

/**
 *
 * @author EZIO AUDITORY
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    private HomeModel homeModel;
    static Logger logger = Logger.getLogger(HomePage.class.getName());

    int userNoThis;
    String usernameCheckedThis;
    int jobroleNoThis;
    String jobroleNameThis;

    public HomePage(int userNo, String usernameChecked, int jobroleNo, String jobroleName) {
        initComponents();
        logger.debug("Access to HomePage.java");
        setExtendedState(MAXIMIZED_BOTH);
        homeModel = new HomeModel();

        userNoThis = userNo;
        usernameCheckedThis = usernameChecked;
        jobroleNoThis = jobroleNo;
        jobroleNameThis = jobroleName;

        if (jobroleNoThis == 1 && jobroleNameThis.equals("Admin")) {
            homeButton.setEnabled(true);
            grnButton.setEnabled(true);
            salesButton.setEnabled(true);
            deliveryButton.setEnabled(true);
            productButton.setEnabled(true);
            supplierButton.setEnabled(true);
            customerButton.setEnabled(true);
            companyButton.setEnabled(true);
            aboutButton.setEnabled(true);
            grnHistoryButton.setEnabled(true);
            grnItemHistoryButton.setEnabled(true);
            invoiceHistoryButton.setEnabled(true);
            salesHistoyButton.setEnabled(true);
            deliveryHistoryButton.setEnabled(true);
            userButton.setEnabled(true);
            transporterButton.setEnabled(true);
            settingsButton.setEnabled(true);
            backupRestoreButton.setEnabled(true);
        } else if (jobroleNoThis == 2 && jobroleNameThis.equals("Accountant")) {
            homeButton.setEnabled(true);
            grnButton.setEnabled(false);
            salesButton.setEnabled(false);
            deliveryButton.setEnabled(false);
            productButton.setEnabled(false);
            supplierButton.setEnabled(false);
            customerButton.setEnabled(false);
            companyButton.setEnabled(false);
            aboutButton.setEnabled(true);
            grnHistoryButton.setEnabled(true);
            grnItemHistoryButton.setEnabled(true);
            invoiceHistoryButton.setEnabled(true);
            salesHistoyButton.setEnabled(true);
            deliveryHistoryButton.setEnabled(true);
            userButton.setEnabled(false);
            transporterButton.setEnabled(false);
            settingsButton.setEnabled(false);
            backupRestoreButton.setEnabled(false);
        } else if (jobroleNoThis == 3 && jobroleNameThis.equals("Cashier")) {
            homeButton.setEnabled(true);
            grnButton.setEnabled(true);
            salesButton.setEnabled(true);
            deliveryButton.setEnabled(true);
            productButton.setEnabled(true);
            supplierButton.setEnabled(true);
            customerButton.setEnabled(true);
            companyButton.setEnabled(true);
            aboutButton.setEnabled(true);
            grnHistoryButton.setEnabled(true);
            grnItemHistoryButton.setEnabled(true);
            invoiceHistoryButton.setEnabled(true);
            salesHistoyButton.setEnabled(true);
            deliveryHistoryButton.setEnabled(true);
            userButton.setEnabled(false);
            transporterButton.setEnabled(true);
            settingsButton.setEnabled(false);
            backupRestoreButton.setEnabled(false);
        } else if (jobroleNoThis == 4 && jobroleNameThis.equals("Employee")) {
            homeButton.setEnabled(true);
            grnButton.setEnabled(false);
            salesButton.setEnabled(false);
            deliveryButton.setEnabled(false);
            productButton.setEnabled(true);
            supplierButton.setEnabled(true);
            customerButton.setEnabled(true);
            companyButton.setEnabled(true);
            aboutButton.setEnabled(true);
            grnHistoryButton.setEnabled(false);
            grnItemHistoryButton.setEnabled(false);
            invoiceHistoryButton.setEnabled(false);
            salesHistoyButton.setEnabled(false);
            deliveryHistoryButton.setEnabled(false);
            userButton.setEnabled(false);
            transporterButton.setEnabled(true);
            settingsButton.setEnabled(false);
            backupRestoreButton.setEnabled(false);
        } else if (jobroleNoThis == 5 && jobroleNameThis.equals("Manager")) {
            homeButton.setEnabled(true);
            grnButton.setEnabled(true);
            salesButton.setEnabled(true);
            deliveryButton.setEnabled(true);
            productButton.setEnabled(true);
            supplierButton.setEnabled(true);
            customerButton.setEnabled(true);
            companyButton.setEnabled(true);
            aboutButton.setEnabled(true);
            grnHistoryButton.setEnabled(true);
            grnItemHistoryButton.setEnabled(true);
            invoiceHistoryButton.setEnabled(true);
            salesHistoyButton.setEnabled(true);
            deliveryHistoryButton.setEnabled(true);
            userButton.setEnabled(false);
            transporterButton.setEnabled(true);
            settingsButton.setEnabled(true);
            backupRestoreButton.setEnabled(true);
        } else {
            homeButton.setEnabled(false);
            grnButton.setEnabled(false);
            salesButton.setEnabled(false);
            deliveryButton.setEnabled(false);
            productButton.setEnabled(false);
            supplierButton.setEnabled(false);
            customerButton.setEnabled(false);
            companyButton.setEnabled(false);
            aboutButton.setEnabled(false);
            grnHistoryButton.setEnabled(false);
            grnItemHistoryButton.setEnabled(false);
            invoiceHistoryButton.setEnabled(false);
            salesHistoyButton.setEnabled(false);
            deliveryHistoryButton.setEnabled(false);
            userButton.setEnabled(false);
            transporterButton.setEnabled(false);
            settingsButton.setEnabled(false);
            backupRestoreButton.setEnabled(false);
        }
        logger.debug("Give User Access");

        userNoLabel.setText(String.valueOf(userNoThis));
        usernameLabel.setText(usernameCheckedThis);
        jobroleNoLabel.setText(String.valueOf(jobroleNoThis));
        jobroleNameLabel.setText(jobroleNameThis);
        datetimeLabel.setText(new Date().toString());
        jDateChooser1.setDate(new Date());

        Object[] purchaseAmount = homeModel.getPurchaseAmount();
        purchaseAmountLabel.setText(new String(purchaseAmount[0] + ""));
        logger.debug("Set Purchase Amount");

        Object[] salesAmount = homeModel.getSalesAmount();
        salesAmountLabel.setText(new String(salesAmount[0] + ""));
        logger.debug("Set Sales Amount");

        double transaction = (double) salesAmount[0] - (double) purchaseAmount[0];
        transactionLabel.setText(String.valueOf(transaction));
        logger.debug("Set Transaction");

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Exit();
            }

        });
    }

    private HomePage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void Exit() {
        int a = JOptionPane.showConfirmDialog(rootPane, "Do you Want to exit ?", "Message", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            logger.debug("Exit Program [END]");
            System.exit(0);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        grnButton = new javax.swing.JButton();
        salesButton = new javax.swing.JButton();
        deliveryButton = new javax.swing.JButton();
        productButton = new javax.swing.JButton();
        supplierButton = new javax.swing.JButton();
        customerButton = new javax.swing.JButton();
        companyButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        grnHistoryButton = new javax.swing.JButton();
        grnItemHistoryButton = new javax.swing.JButton();
        invoiceHistoryButton = new javax.swing.JButton();
        salesHistoyButton = new javax.swing.JButton();
        deliveryHistoryButton = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        userButton = new javax.swing.JButton();
        transporterButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        backupRestoreButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        purchaseAmountLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        transactionLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        salesAmountLabel = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        userNoLabel = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jobroleNoLabel = new javax.swing.JLabel();
        jobroleNameLabel = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        datetimeLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("PAMUNUWILA HARDWARE (Pvt) Ltd");

        jPanel1.setBackground(new java.awt.Color(227, 227, 227));

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-home-page-50.png"))); // NOI18N
        homeButton.setText("Home");
        homeButton.setContentAreaFilled(false);
        homeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        homeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeButtonMouseExited(evt);
            }
        });
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        grnButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-goodnotes-50.png"))); // NOI18N
        grnButton.setText("GRN");
        grnButton.setContentAreaFilled(false);
        grnButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        grnButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        grnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                grnButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                grnButtonMouseExited(evt);
            }
        });
        grnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grnButtonActionPerformed(evt);
            }
        });

        salesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-invoice-50.png"))); // NOI18N
        salesButton.setText("Sales");
        salesButton.setContentAreaFilled(false);
        salesButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salesButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        salesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salesButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salesButtonMouseExited(evt);
            }
        });
        salesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesButtonActionPerformed(evt);
            }
        });

        deliveryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-in-transit-50.png"))); // NOI18N
        deliveryButton.setText("Delivery");
        deliveryButton.setContentAreaFilled(false);
        deliveryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deliveryButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deliveryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deliveryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deliveryButtonMouseExited(evt);
            }
        });
        deliveryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveryButtonActionPerformed(evt);
            }
        });

        productButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-product-50.png"))); // NOI18N
        productButton.setText("Products");
        productButton.setContentAreaFilled(false);
        productButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        productButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        productButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                productButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                productButtonMouseExited(evt);
            }
        });
        productButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productButtonActionPerformed(evt);
            }
        });

        supplierButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-supplier-50.png"))); // NOI18N
        supplierButton.setText("Suppliers");
        supplierButton.setContentAreaFilled(false);
        supplierButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        supplierButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        supplierButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                supplierButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                supplierButtonMouseExited(evt);
            }
        });
        supplierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierButtonActionPerformed(evt);
            }
        });

        customerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-customer-50.png"))); // NOI18N
        customerButton.setText("Customers");
        customerButton.setContentAreaFilled(false);
        customerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        customerButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        customerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                customerButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                customerButtonMouseExited(evt);
            }
        });
        customerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerButtonActionPerformed(evt);
            }
        });

        companyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-company-50.png"))); // NOI18N
        companyButton.setText("Company");
        companyButton.setContentAreaFilled(false);
        companyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        companyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        companyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                companyButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                companyButtonMouseExited(evt);
            }
        });
        companyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyButtonActionPerformed(evt);
            }
        });

        aboutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-about-50.png"))); // NOI18N
        aboutButton.setText("About");
        aboutButton.setContentAreaFilled(false);
        aboutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aboutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        aboutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutButtonMouseExited(evt);
            }
        });
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeButton)
                .addGap(0, 0, 0)
                .addComponent(grnButton)
                .addGap(0, 0, 0)
                .addComponent(salesButton)
                .addGap(0, 0, 0)
                .addComponent(deliveryButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supplierButton)
                .addGap(0, 0, 0)
                .addComponent(customerButton)
                .addGap(0, 0, 0)
                .addComponent(companyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutButton)
                .addContainerGap(1094, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grnButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(homeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salesButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(deliveryButton, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(productButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(supplierButton, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(customerButton, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(companyButton, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(aboutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparator3)
        );

        jTabbedPane1.addTab("Home", jPanel1);

        jPanel2.setBackground(new java.awt.Color(227, 227, 227));

        grnHistoryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-list-view-50.png"))); // NOI18N
        grnHistoryButton.setText("GRN History");
        grnHistoryButton.setContentAreaFilled(false);
        grnHistoryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        grnHistoryButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        grnHistoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                grnHistoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                grnHistoryButtonMouseExited(evt);
            }
        });
        grnHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grnHistoryButtonActionPerformed(evt);
            }
        });

        grnItemHistoryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-list-view-50.png"))); // NOI18N
        grnItemHistoryButton.setText("GRN Item History");
        grnItemHistoryButton.setContentAreaFilled(false);
        grnItemHistoryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        grnItemHistoryButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        grnItemHistoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                grnItemHistoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                grnItemHistoryButtonMouseExited(evt);
            }
        });
        grnItemHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grnItemHistoryButtonActionPerformed(evt);
            }
        });

        invoiceHistoryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-list-view-50.png"))); // NOI18N
        invoiceHistoryButton.setText("Invoice History");
        invoiceHistoryButton.setContentAreaFilled(false);
        invoiceHistoryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        invoiceHistoryButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        invoiceHistoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                invoiceHistoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                invoiceHistoryButtonMouseExited(evt);
            }
        });
        invoiceHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceHistoryButtonActionPerformed(evt);
            }
        });

        salesHistoyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-list-view-50.png"))); // NOI18N
        salesHistoyButton.setText("Sales History");
        salesHistoyButton.setContentAreaFilled(false);
        salesHistoyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salesHistoyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        salesHistoyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salesHistoyButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salesHistoyButtonMouseExited(evt);
            }
        });
        salesHistoyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesHistoyButtonActionPerformed(evt);
            }
        });

        deliveryHistoryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-list-view-50.png"))); // NOI18N
        deliveryHistoryButton.setText("Delivery History");
        deliveryHistoryButton.setContentAreaFilled(false);
        deliveryHistoryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deliveryHistoryButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deliveryHistoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deliveryHistoryButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deliveryHistoryButtonMouseExited(evt);
            }
        });
        deliveryHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveryHistoryButtonActionPerformed(evt);
            }
        });

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(grnHistoryButton)
                .addGap(0, 0, 0)
                .addComponent(grnItemHistoryButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invoiceHistoryButton)
                .addGap(0, 0, 0)
                .addComponent(salesHistoyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deliveryHistoryButton)
                .addContainerGap(1300, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grnItemHistoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(grnHistoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(invoiceHistoryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salesHistoyButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deliveryHistoryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparator5)
        );

        jTabbedPane1.addTab("Reports", jPanel2);

        jPanel3.setBackground(new java.awt.Color(227, 227, 227));

        userButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-user-50.png"))); // NOI18N
        userButton.setText("Usres");
        userButton.setContentAreaFilled(false);
        userButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        userButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userButtonMouseExited(evt);
            }
        });
        userButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userButtonActionPerformed(evt);
            }
        });

        transporterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-account-50.png"))); // NOI18N
        transporterButton.setText("Transporters");
        transporterButton.setContentAreaFilled(false);
        transporterButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        transporterButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        transporterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                transporterButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                transporterButtonMouseExited(evt);
            }
        });
        transporterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transporterButtonActionPerformed(evt);
            }
        });

        settingsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-settings-50.png"))); // NOI18N
        settingsButton.setText("Settings");
        settingsButton.setContentAreaFilled(false);
        settingsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        settingsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        settingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsButtonMouseExited(evt);
            }
        });
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        backupRestoreButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-cloud-backup-restore-50.png"))); // NOI18N
        backupRestoreButton.setText("Backup & Restore");
        backupRestoreButton.setContentAreaFilled(false);
        backupRestoreButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backupRestoreButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        backupRestoreButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backupRestoreButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backupRestoreButtonMouseExited(evt);
            }
        });
        backupRestoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupRestoreButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userButton)
                .addGap(0, 0, 0)
                .addComponent(transporterButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settingsButton)
                .addGap(0, 0, 0)
                .addComponent(backupRestoreButton)
                .addContainerGap(1481, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(transporterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userButton, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(settingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backupRestoreButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.addTab("Others", jPanel3);

        jPanel4.setBackground(new java.awt.Color(227, 227, 227));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText(" Login Date :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(188, 255, 188));

        purchaseAmountLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        purchaseAmountLabel.setText("0.00");
        purchaseAmountLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Purchase");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(purchaseAmountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(purchaseAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bar-chart-grap-of-a-function.png"))); // NOI18N

        jPanel9.setBackground(new java.awt.Color(188, 255, 188));

        transactionLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        transactionLabel.setText("0.00");
        transactionLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Transaction");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(transactionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(transactionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(188, 255, 188));

        salesAmountLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        salesAmountLabel.setText("0.00");
        salesAmountLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Sales");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salesAmountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(salesAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(597, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(231, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("PAMUNUWILA HARDWARE (Pvt) Ltd");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("PAMUNUWILA HARDWARE is a HARDWARE SHOP. This Hardware Shop Management System (HSMS) is developed to make their day-to-day operations easier and more efficient.");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Email : pamunuwilahardware@gmail.com");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Contact No : 0775561834");

        jLabel6.setText("All Rights Reserved to PAMUNUWILA HARDWARE");

        jPanel8.setBackground(new java.awt.Color(252, 209, 167));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("User");

        usernameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        userNoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jobroleNoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jobroleNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Login Date");

        datetimeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jobroleNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jobroleNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datetimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator8)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userNoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jobroleNoLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jobroleNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datetimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Developed By : M.R.P.N.Tharuksha Rajapaksha");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setText("( Ver 1.1 )");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addComponent(jLabel3)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(73, 73, 73)
                                .addComponent(jLabel5)))
                        .addGap(0, 558, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)))
                .addContainerGap())
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseEntered
        // TODO add your handling code here:
        homeButton.setContentAreaFilled(true);
    }//GEN-LAST:event_homeButtonMouseEntered

    private void homeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseExited
        // TODO add your handling code here:
        homeButton.setContentAreaFilled(false);
    }//GEN-LAST:event_homeButtonMouseExited

    private void grnButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grnButtonMouseEntered
        // TODO add your handling code here:
        grnButton.setContentAreaFilled(true);
    }//GEN-LAST:event_grnButtonMouseEntered

    private void grnButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grnButtonMouseExited
        // TODO add your handling code here:
        grnButton.setContentAreaFilled(false);
    }//GEN-LAST:event_grnButtonMouseExited

    private void salesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesButtonMouseEntered
        // TODO add your handling code here:
        salesButton.setContentAreaFilled(true);
    }//GEN-LAST:event_salesButtonMouseEntered

    private void salesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesButtonMouseExited
        // TODO add your handling code here:
        salesButton.setContentAreaFilled(false);
    }//GEN-LAST:event_salesButtonMouseExited

    private void deliveryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deliveryButtonMouseEntered
        // TODO add your handling code here:
        deliveryButton.setContentAreaFilled(true);
    }//GEN-LAST:event_deliveryButtonMouseEntered

    private void deliveryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deliveryButtonMouseExited
        // TODO add your handling code here:
        deliveryButton.setContentAreaFilled(false);
    }//GEN-LAST:event_deliveryButtonMouseExited

    private void productButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productButtonMouseEntered
        // TODO add your handling code here:
        productButton.setContentAreaFilled(true);
    }//GEN-LAST:event_productButtonMouseEntered

    private void productButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productButtonMouseExited
        // TODO add your handling code here:
        productButton.setContentAreaFilled(false);
    }//GEN-LAST:event_productButtonMouseExited

    private void supplierButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierButtonMouseEntered
        // TODO add your handling code here:
        supplierButton.setContentAreaFilled(true);
    }//GEN-LAST:event_supplierButtonMouseEntered

    private void supplierButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierButtonMouseExited
        // TODO add your handling code here:
        supplierButton.setContentAreaFilled(false);
    }//GEN-LAST:event_supplierButtonMouseExited

    private void customerButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerButtonMouseEntered
        // TODO add your handling code here:
        customerButton.setContentAreaFilled(true);
    }//GEN-LAST:event_customerButtonMouseEntered

    private void customerButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerButtonMouseExited
        // TODO add your handling code here:
        customerButton.setContentAreaFilled(false);
    }//GEN-LAST:event_customerButtonMouseExited

    private void companyButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_companyButtonMouseEntered
        // TODO add your handling code here:
        companyButton.setContentAreaFilled(true);
    }//GEN-LAST:event_companyButtonMouseEntered

    private void companyButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_companyButtonMouseExited
        // TODO add your handling code here:
        companyButton.setContentAreaFilled(false);
    }//GEN-LAST:event_companyButtonMouseExited

    private void aboutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonMouseEntered
        // TODO add your handling code here:
        aboutButton.setContentAreaFilled(true);
    }//GEN-LAST:event_aboutButtonMouseEntered

    private void aboutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonMouseExited
        // TODO add your handling code here:
        aboutButton.setContentAreaFilled(false);
    }//GEN-LAST:event_aboutButtonMouseExited

    private void grnHistoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grnHistoryButtonMouseEntered
        // TODO add your handling code here:
        grnHistoryButton.setContentAreaFilled(true);
    }//GEN-LAST:event_grnHistoryButtonMouseEntered

    private void grnHistoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grnHistoryButtonMouseExited
        // TODO add your handling code here:
        grnHistoryButton.setContentAreaFilled(false);
    }//GEN-LAST:event_grnHistoryButtonMouseExited

    private void grnItemHistoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grnItemHistoryButtonMouseEntered
        // TODO add your handling code here:
        grnItemHistoryButton.setContentAreaFilled(true);
    }//GEN-LAST:event_grnItemHistoryButtonMouseEntered

    private void grnItemHistoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grnItemHistoryButtonMouseExited
        // TODO add your handling code here:
        grnItemHistoryButton.setContentAreaFilled(false);
    }//GEN-LAST:event_grnItemHistoryButtonMouseExited

    private void invoiceHistoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceHistoryButtonMouseEntered
        // TODO add your handling code here:
        invoiceHistoryButton.setContentAreaFilled(true);
    }//GEN-LAST:event_invoiceHistoryButtonMouseEntered

    private void invoiceHistoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceHistoryButtonMouseExited
        // TODO add your handling code here:
        invoiceHistoryButton.setContentAreaFilled(false);
    }//GEN-LAST:event_invoiceHistoryButtonMouseExited

    private void salesHistoyButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesHistoyButtonMouseEntered
        // TODO add your handling code here:
        salesHistoyButton.setContentAreaFilled(true);
    }//GEN-LAST:event_salesHistoyButtonMouseEntered

    private void salesHistoyButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesHistoyButtonMouseExited
        // TODO add your handling code here:
        salesHistoyButton.setContentAreaFilled(false);
    }//GEN-LAST:event_salesHistoyButtonMouseExited

    private void deliveryHistoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deliveryHistoryButtonMouseEntered
        // TODO add your handling code here:
        deliveryHistoryButton.setContentAreaFilled(true);
    }//GEN-LAST:event_deliveryHistoryButtonMouseEntered

    private void deliveryHistoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deliveryHistoryButtonMouseExited
        // TODO add your handling code here:
        deliveryHistoryButton.setContentAreaFilled(false);
    }//GEN-LAST:event_deliveryHistoryButtonMouseExited

    private void userButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userButtonMouseEntered
        // TODO add your handling code here:
        userButton.setContentAreaFilled(true);
    }//GEN-LAST:event_userButtonMouseEntered

    private void userButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userButtonMouseExited
        // TODO add your handling code here:
        userButton.setContentAreaFilled(false);
    }//GEN-LAST:event_userButtonMouseExited

    private void transporterButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transporterButtonMouseEntered
        // TODO add your handling code here:
        transporterButton.setContentAreaFilled(true);
    }//GEN-LAST:event_transporterButtonMouseEntered

    private void transporterButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transporterButtonMouseExited
        // TODO add your handling code here:
        transporterButton.setContentAreaFilled(false);
    }//GEN-LAST:event_transporterButtonMouseExited

    private void settingsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsButtonMouseEntered
        // TODO add your handling code here:
        settingsButton.setContentAreaFilled(true);
    }//GEN-LAST:event_settingsButtonMouseEntered

    private void settingsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsButtonMouseExited
        // TODO add your handling code here:
        settingsButton.setContentAreaFilled(false);
    }//GEN-LAST:event_settingsButtonMouseExited

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        new HomePage(userNoThis, usernameCheckedThis, jobroleNoThis, jobroleNameThis).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeButtonActionPerformed

    private void grnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grnButtonActionPerformed
        // TODO add your handling code here:
        new GrnManager().setVisible(true);
    }//GEN-LAST:event_grnButtonActionPerformed

    private void salesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesButtonActionPerformed
        // TODO add your handling code here:
        new SalesManager().setVisible(true);
    }//GEN-LAST:event_salesButtonActionPerformed

    private void deliveryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveryButtonActionPerformed
        // TODO add your handling code here:
        new DeliveryManager().setVisible(true);
    }//GEN-LAST:event_deliveryButtonActionPerformed

    private void productButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productButtonActionPerformed
        // TODO add your handling code here:
        new ProductManager().setVisible(true);
    }//GEN-LAST:event_productButtonActionPerformed

    private void supplierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierButtonActionPerformed
        // TODO add your handling code here:
        new SupplierManager().setVisible(true);
    }//GEN-LAST:event_supplierButtonActionPerformed

    private void customerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerButtonActionPerformed
        // TODO add your handling code here:
        new CustomerManager().setVisible(true);
    }//GEN-LAST:event_customerButtonActionPerformed

    private void companyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyButtonActionPerformed
        // TODO add your handling code here:
        new CompanyManager().setVisible(true);
    }//GEN-LAST:event_companyButtonActionPerformed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        // TODO add your handling code here:
        new About().setVisible(true);
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void grnHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grnHistoryButtonActionPerformed
        // TODO add your handling code here:
        new GenerateGrnHistoryDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_grnHistoryButtonActionPerformed

    private void grnItemHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grnItemHistoryButtonActionPerformed
        // TODO add your handling code here:
        new GenerateGrnItemHistoryDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_grnItemHistoryButtonActionPerformed

    private void invoiceHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceHistoryButtonActionPerformed
        // TODO add your handling code here:
        new GenerateInvoiceHistoryDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_invoiceHistoryButtonActionPerformed

    private void salesHistoyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesHistoyButtonActionPerformed
        // TODO add your handling code here:
        new GenerateSalesHistoryDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_salesHistoyButtonActionPerformed

    private void deliveryHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveryHistoryButtonActionPerformed
        // TODO add your handling code here:
        new GenerateDeliveryHistoryDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_deliveryHistoryButtonActionPerformed

    private void userButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userButtonActionPerformed
        // TODO add your handling code here:
        new UserManager().setVisible(true);
    }//GEN-LAST:event_userButtonActionPerformed

    private void transporterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transporterButtonActionPerformed
        // TODO add your handling code here:
        new TransporterManager().setVisible(true);
    }//GEN-LAST:event_transporterButtonActionPerformed

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        // TODO add your handling code here:
        //new ProductManager().setVisible(true);
    }//GEN-LAST:event_settingsButtonActionPerformed

    private void backupRestoreButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backupRestoreButtonMouseEntered
        // TODO add your handling code here:
        backupRestoreButton.setContentAreaFilled(true);
    }//GEN-LAST:event_backupRestoreButtonMouseEntered

    private void backupRestoreButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backupRestoreButtonMouseExited
        // TODO add your handling code here:
        backupRestoreButton.setContentAreaFilled(false);
    }//GEN-LAST:event_backupRestoreButtonMouseExited

    private void backupRestoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupRestoreButtonActionPerformed
        // TODO add your handling code here:
        new BackupAndRestore().setVisible(true);
    }//GEN-LAST:event_backupRestoreButtonActionPerformed

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
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            UIManager.put("Table.showHorizontalLines", true);
            UIManager.put("Table.showVerticalLines", true);
            UIManager.put("ScrollBar.showButtons", true);
            UIManager.put("ScrollBar.width", 16);
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JButton backupRestoreButton;
    private javax.swing.JButton companyButton;
    private javax.swing.JButton customerButton;
    private javax.swing.JLabel datetimeLabel;
    private javax.swing.JButton deliveryButton;
    private javax.swing.JButton deliveryHistoryButton;
    private javax.swing.JButton grnButton;
    private javax.swing.JButton grnHistoryButton;
    private javax.swing.JButton grnItemHistoryButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JButton invoiceHistoryButton;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jobroleNameLabel;
    private javax.swing.JLabel jobroleNoLabel;
    private javax.swing.JButton productButton;
    private javax.swing.JLabel purchaseAmountLabel;
    private javax.swing.JLabel salesAmountLabel;
    private javax.swing.JButton salesButton;
    private javax.swing.JButton salesHistoyButton;
    private javax.swing.JButton settingsButton;
    private javax.swing.JButton supplierButton;
    private javax.swing.JLabel transactionLabel;
    private javax.swing.JButton transporterButton;
    private javax.swing.JButton userButton;
    private javax.swing.JLabel userNoLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
