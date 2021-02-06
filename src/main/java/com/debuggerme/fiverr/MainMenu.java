package com.debuggerme.fiverr;

import com.sun.pisces.Surface;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainMenu
        extends JFrame {
    public MainMenu() {
        this.PageWidth = "";
        this.PageHight = "";
        this.pgcount = "";
        initComponents();
        AddMainColoursToCombo();
        clearTemp(".tmp32/");
        clearFolder("temp32");
        setIconImage(Toolkit.getDefaultToolkit().getImage("data/ico.png"));
        OpenDef();
        if (ckValid())
            try {
                createAnImg(ColorCode);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, (String) null, ex);
            }
    }

    public static String Title = "";
    public static String ImgPath = "";
    public static String txtSaveFilePath = "";
    public static String txtSaveMultiFilePath = "";
    public static String txtSaveMultiFileName = "";
    public String PageWidth;
    public String PageHight;
    public String pgcount;
    public static int Pagecount = 0;
    public static String ColorCode = "";
    public static String MultiColorCode = "";
    public static String FontColor = "";
    public static String FC = "";
    public static String ImgType = "";
    public static String MultiGenaratedFileName = "";
    public static String GenaratedFileName = "";
    public static String GenaratedFileName1 = "";
    public static String GenaratedTMPFileName = "";
    public static int pgWd = 0;
    public static int pgHd = 0;
    public static int new_width = 0;
    public static int new_height = 0;
    public static int org_att_img_height = 0;
    public static int org_att_img_width = 0;
    private JFileChooser SavePDFChooser;
    private JButton btnGenarate;
    private JButton btnImgOpen;
    private JButton btnMltGenarate;
    private JButton btnPrieview;
    private JButton btnReset;
    private JComboBox<String> cmbColorCode;
    private JComboBox<String> cmbFontColor;
    private JComboBox<String> cmbImgType;
    private JComboBox<String> cmbMainColor;
    private JFileChooser imgChooser;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;

    private void initComponents() {
        this.imgChooser = new JFileChooser();
        this.SavePDFChooser = new JFileChooser();
        this.jPanel3 = new JPanel();
        this.jLabel10 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.jSeparator2 = new JSeparator();
        this.jSeparator3 = new JSeparator();
        this.lblSampleView = new JLabel();
        this.jPanel2 = new JPanel();
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jPanel4 = new JPanel();
        this.txtTitle = new JTextField();
        this.btnImgOpen = new JButton();
        this.txtImgPath = new JTextField();
        this.snpPageSize = new JSpinner();
        this.snpPageCount = new JSpinner();
        this.cmbMainColor = new JComboBox<>();
        this.cmbColorCode = new JComboBox<>();
        this.pnlColor = new JPanel();
        this.lblColrCode = new JLabel();
        this.cmbFontColor = new JComboBox<>();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.cmbImgType = new JComboBox<>();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.txtAtt_img_scl = new JSpinner();
        this.btnGenarate = new JButton();
        this.btnPrieview = new JButton();
        this.btnReset = new JButton();
        this.jLabel13 = new JLabel();
        this.btnMltGenarate = new JButton();
        this.jLabel14 = new JLabel();

        this.SavePDFChooser.setDialogType(1);

        setDefaultCloseOperation(0);
        setTitle("Artwork & Templates Genarator");
        setCursor(new Cursor(0));
        setMinimumSize(new Dimension(810, 430));
        setPreferredSize(new Dimension(830, 480));
        setResizable(false);
        setType(Window.Type.POPUP);
        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent evt) {
                MainMenu.this.formWindowClosed(evt);
            }

            public void windowClosing(WindowEvent evt) {
                MainMenu.this.formWindowClosing(evt);
            }
        });
        getContentPane().setLayout((LayoutManager) new AbsoluteLayout());

        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel3.setPreferredSize(new Dimension(810, 420));
        this.jPanel3.setLayout((LayoutManager) new AbsoluteLayout());

        this.jLabel10.setFont(new Font("Century Gothic", 1, 18));
        this.jLabel10.setText("- Artwork & Templates Genarator -");
        this.jPanel3.add(this.jLabel10, new AbsoluteConstraints(250, 2, -1, -1));

        this.jLabel8.setText("Copyright © 2018, Ðinu Solutions - All rights reserved.   ");
        this.jPanel3.add(this.jLabel8, new AbsoluteConstraints(70, 410, -1, 17));

        this.jLabel9.setText("Support - <info.dinusolutions@gmail.com>");
        this.jPanel3.add(this.jLabel9, new AbsoluteConstraints(520, 410, -1, -1));

        this.jSeparator1.setOrientation(1);
        this.jSeparator1.setCursor(new Cursor(0));
        this.jPanel3.add(this.jSeparator1, new AbsoluteConstraints(507, 55, 12, 294));
        this.jPanel3.add(this.jSeparator2, new AbsoluteConstraints(50, 380, 733, 10));
        this.jPanel3.add(this.jSeparator3, new AbsoluteConstraints(54, 31, 733, 10));

        this.lblSampleView.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.jPanel3.add(this.lblSampleView, new AbsoluteConstraints(530, 70, 250, 230));

        this.jLabel1.setText("Trim Size");

        this.jLabel2.setText("Title");
        this.jLabel2.setToolTipText("Enter title. ** NOTE : That will be displayed on the spine as shown in the example.");

        this.jLabel3.setText("Number of Pages");

        this.jLabel4.setText("Page Color");

        this.jLabel5.setText("Select Image");
        this.jLabel5.setToolTipText("Please select an image.  ** NOTE : An image, only PNG Format.");

        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(this.jLabel4, -2, 100, -2)
                                .addComponent(this.jLabel2, -2, 100, -2)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(this.jLabel5, GroupLayout.Alignment.LEADING, -1, -1, 32767)
                                        .addComponent(this.jLabel1, GroupLayout.Alignment.LEADING, -1, -1, 32767)
                                        .addComponent(this.jLabel3, GroupLayout.Alignment.LEADING, -2, 100, -2)))
                        .addContainerGap(-1, 32767)));

        jPanel1Layout.setVerticalGroup(jPanel1Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(this.jLabel2, -2, 31, -2)
                        .addGap(13, 13, 13)
                        .addComponent(this.jLabel5, -2, 31, -2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(this.jLabel1, -2, 31, -2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(this.jLabel3, -2, 31, -2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(this.jLabel4, -2, 31, -2)
                        .addContainerGap(20, 32767)));


        this.txtTitle.setFont(new Font("Tahoma", 1, 14));
        this.txtTitle.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                MainMenu.this.txtTitleFocusLost(evt);
            }
        });
        this.txtTitle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainMenu.this.txtTitleActionPerformed(evt);
            }
        });
        this.txtTitle.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                MainMenu.this.txtTitleKeyReleased(evt);
            }
        });

        this.btnImgOpen.setText("Open");
        this.btnImgOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainMenu.this.btnImgOpenActionPerformed(evt);
            }
        });

        this.txtImgPath.setEditable(false);
        this.txtImgPath.setText("data/feather1.png");

        this.snpPageSize.setFont(new Font("Tahoma", 1, 11));
        this.snpPageSize.setModel(new SpinnerListModel((Object[]) new String[]{"5 x 8", "6 x 9", "7 x 10", "8 x10", "8.5 x 11"}));
        this.snpPageSize.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                MainMenu.this.snpPageSizeStateChanged(evt);
            }
        });

        this.snpPageCount.setFont(new Font("Tahoma", 1, 11));
        this.snpPageCount.setModel(new SpinnerListModel((Object[]) new String[]{"50 Pages", "100 Pages", "150 Pages", "200 Pages", "250 Pages", "300 Pages", "350 Pages", "400 Pages", "450 Pages", "500 Pages", "550 Pages", "600 Pages", "650 Pages", "700 Pages", "750 Pages", "800 Pages"}));
        this.snpPageCount.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                MainMenu.this.snpPageCountStateChanged(evt);
            }
        });

        this.cmbMainColor.setFont(new Font("Tahoma", 1, 11));
        this.cmbMainColor.setMaximumRowCount(7);
        this.cmbMainColor.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                MainMenu.this.cmbMainColorItemStateChanged(evt);
            }
        });
        this.cmbMainColor.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                MainMenu.this.cmbMainColorFocusLost(evt);
            }
        });
        this.cmbMainColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainMenu.this.cmbMainColorActionPerformed(evt);
            }
        });

        this.cmbColorCode.setFont(new Font("Tahoma", 1, 11));
        this.cmbColorCode.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                MainMenu.this.cmbColorCodeFocusLost(evt);
            }
        });
        this.cmbColorCode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainMenu.this.cmbColorCodeActionPerformed(evt);
            }
        });

        this.pnlColor.setBorder(BorderFactory.createEtchedBorder());

        this.lblColrCode.setFont(new Font("Tahoma", 1, 17));
        this.lblColrCode.setForeground(new Color(255, 255, 255));

        GroupLayout pnlColorLayout = new GroupLayout(this.pnlColor);
        this.pnlColor.setLayout(pnlColorLayout);
        pnlColorLayout.setHorizontalGroup(pnlColorLayout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.lblColrCode, GroupLayout.Alignment.TRAILING, -1, -1, 32767));

        pnlColorLayout.setVerticalGroup(pnlColorLayout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.lblColrCode, -1, -1, 32767));


        this.cmbFontColor.setFont(new Font("Tahoma", 1, 11));
        this.cmbFontColor.setModel(new DefaultComboBoxModel<>(new String[]{"Black", "White"}));
        this.cmbFontColor.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                MainMenu.this.cmbFontColorItemStateChanged(evt);
            }
        });

        this.jLabel6.setText("Font Color");

        this.jLabel7.setText("Image Type");

        this.cmbImgType.setModel(new DefaultComboBoxModel<>(new String[]{"Center", "Pattern"}));
        this.cmbImgType.setEnabled(false);

        this.jLabel11.setText("Selected Image Size");
        this.jLabel11.setToolTipText("Please select an image.  ** NOTE : An image, only PNG Format.");

        this.jLabel12.setFont(new Font("Tahoma", 0, 14));
        this.jLabel12.setText("%");

        this.txtAtt_img_scl.setFont(new Font("Tahoma", 1, 11));
        this.txtAtt_img_scl.setModel(new SpinnerNumberModel(100, 1, 100, 1));
        this.txtAtt_img_scl.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                MainMenu.this.txtAtt_img_sclStateChanged(evt);
            }
        });

        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(this.jLabel6)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(this.cmbFontColor, -2, 76, -2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                                        .addComponent(this.cmbImgType, -2, 95, -2))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(this.jLabel7)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(this.snpPageCount, -1, 100, 32767)
                                                                .addComponent(this.cmbMainColor, 0, -1, 32767))
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(this.cmbColorCode, -2, 108, -2)))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(this.pnlColor, -1, -1, 32767))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(this.txtTitle, -2, 320, -2)
                                        .addGap(0, 0, 32767))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(this.snpPageSize, -2, 100, -2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                                        .addComponent(this.txtAtt_img_scl, -2, -1, -2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(this.jLabel12))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(this.jLabel11)
                                                .addComponent(this.txtImgPath, -2, 230, -2))
                                        .addGap(18, 18, 32767)
                                        .addComponent(this.btnImgOpen, -2, 68, -2)
                                        .addGap(4, 4, 4)))
                        .addContainerGap()));

        jPanel4Layout.setVerticalGroup(jPanel4Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(this.txtTitle, -2, 32, -2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.txtImgPath, -2, 30, -2)
                                .addComponent(this.btnImgOpen))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.snpPageSize, -2, 31, -2)
                                .addComponent(this.jLabel11)
                                .addComponent(this.jLabel12)
                                .addComponent(this.txtAtt_img_scl, -2, -1, -2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(this.snpPageCount, -2, 30, -2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(this.cmbMainColor, GroupLayout.Alignment.TRAILING)
                                .addComponent(this.cmbColorCode)
                                .addComponent(this.pnlColor, -1, -1, 32767))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.cmbFontColor, -2, -1, -2)
                                .addComponent(this.jLabel6)
                                .addComponent(this.jLabel7)
                                .addComponent(this.cmbImgType, -2, -1, -2))
                        .addContainerGap()));


        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(this.jPanel1, -2, 110, -2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(this.jPanel4, -1, -1, 32767)
                        .addContainerGap()));

        jPanel2Layout.setVerticalGroup(jPanel2Layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(this.jPanel1, -2, -1, -2)
                                        .addGap(0, 0, 32767))
                                .addComponent(this.jPanel4, -1, -1, 32767))
                        .addContainerGap()));


        this.jPanel3.add(this.jPanel2, new AbsoluteConstraints(13, 47, -1, -1));

        this.btnGenarate.setBackground(new Color(0, 204, 51));
        this.btnGenarate.setFont(new Font("Tahoma", 1, 12));
        this.btnGenarate.setText("GENARATE A PDF");
        this.btnGenarate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainMenu.this.btnGenarateActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.btnGenarate, new AbsoluteConstraints(130, 330, -1, -1));

        this.btnPrieview.setBackground(new Color(0, 102, 204));
        this.btnPrieview.setFont(new Font("Tahoma", 1, 12));
        this.btnPrieview.setText("PREVIEW");
        this.btnPrieview.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainMenu.this.btnPrieviewActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.btnPrieview, new AbsoluteConstraints(530, 310, 240, -1));

        this.btnReset.setFont(new Font("Tahoma", 1, 14));
        this.btnReset.setText("RESET");
        this.btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainMenu.this.btnResetActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.btnReset, new AbsoluteConstraints(350, 330, 114, 26));

        this.jLabel13.setText("Software Version - ÐV_1.4");
        this.jPanel3.add(this.jLabel13, new AbsoluteConstraints(70, 390, -1, -1));

        this.btnMltGenarate.setFont(new Font("Tahoma", 1, 14));
        this.btnMltGenarate.setText("GENARATE   PDF");
        this.btnMltGenarate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainMenu.this.btnMltGenarateActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.btnMltGenarate, new AbsoluteConstraints(547, 340, 200, -1));

        this.jLabel14.setText("- Sample preview -");
        this.jLabel14.setToolTipText("Sample preview");
        this.jPanel3.add(this.jLabel14, new AbsoluteConstraints(540, 60, 150, 20));

        getContentPane().add(this.jPanel3, new AbsoluteConstraints(10, 10, 800, 430));

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo((Component) null);
    }

    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JLabel lblColrCode;
    private JLabel lblSampleView;
    private JPanel pnlColor;
    private JSpinner snpPageCount;
    private JSpinner snpPageSize;
    private JSpinner txtAtt_img_scl;
    private JTextField txtImgPath;
    private JTextField txtTitle;

    private void btnImgOpenActionPerformed(ActionEvent evt) {
        try {
            JFileChooser imgChooser = new JFileChooser();
            imgChooser.setDialogTitle("Select an image");
            imgChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG images", new String[]{"png"});
            imgChooser.addChoosableFileFilter(filter);
            int returnValue = imgChooser.showOpenDialog(this);
            if (returnValue == 0) {
                File f = imgChooser.getSelectedFile();
                String mainColorConfigFile = f.getAbsolutePath();
                this.txtImgPath.setText(mainColorConfigFile);

                getDetails();
                this.txtAtt_img_scl.setValue(Integer.valueOf(100));
                if (ckValid()) {
                    try {
                        createAnImg(ColorCode);
                    } catch (IOException ex) {
                        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, (String) null, ex);
                    }
                }
            }
        } catch (Exception exception) {
        }
    }


    private void btnGenarateActionPerformed(ActionEvent evt) {
        getDetails();
        if (Title.equalsIgnoreCase("")) {
            String[] ObjButtons = {"Yes", "No"};
            int PromptResult = JOptionPane.showOptionDialog(null, "The Title is empty. Add sample title?", "confirm", -1, 2, null, (Object[]) ObjButtons, ObjButtons[1]);
            if (PromptResult == 0) {

                Title = "SAMPLE_TITLE";
                this.txtTitle.setText(Title);
            }
        }
        if (ckValid()) {
            try {
                if (SaveAsPDF(this.txtTitle.getText() + "_" + this.PageWidth + "x" + this.PageHight + "_" + Pagecount + "_" + this.cmbColorCode.getSelectedItem().toString() + "_" + FC)) {
                    printPDF.PngToPdf(createAnImg(ColorCode));
                }
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, (String) null, ex);
            }
        }
    }

    private void cmbMainColorActionPerformed(ActionEvent evt) {
        AddSubColoursToCombo();
    }

    private void cmbColorCodeActionPerformed(ActionEvent evt) {
        if (this.cmbColorCode.getSelectedItem() != null) {

            checkColorHexValue(this.cmbMainColor.getSelectedItem().toString(), this.cmbColorCode.getSelectedItem().toString());
        }
    }

    private void btnPrieviewActionPerformed(ActionEvent evt) {
        getDetails();
        if (ckValid()) {
            try {
                createAnImg(ColorCode);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, (String) null, ex);
            }
        }
    }

    private void btnResetActionPerformed(ActionEvent evt) {
        OpenDef();
        this.txtTitle.setText("");
        if (ckValid()) {
            try {
                createAnImg(ColorCode);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, (String) null, ex);
            }
        }
    }

    private void formWindowClosing(WindowEvent evt) {
        String[] ObjButtons = {"Yes", "No"};
        int PromptResult = JOptionPane.showOptionDialog(null, "Do you want to exit?", "Exit", -1, 2, null, (Object[]) ObjButtons, ObjButtons[1]);
        if (PromptResult == 0) {

            clearTemp(".tmp32/");
            clearFolder("temp32");
            System.exit(0);
        }
    }


    private void formWindowClosed(WindowEvent evt) {
    }


    private void txtTitleActionPerformed(ActionEvent evt) {
    }


    private void txtTitleKeyReleased(KeyEvent evt) {
    }


    private void snpPageSizeStateChanged(ChangeEvent evt) {
        getDetails();
        if (ckValid()) {
            try {
                createAnImg(ColorCode);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, (String) null, ex);
            }
        }
    }

    private void txtAtt_img_sclStateChanged(ChangeEvent evt) {
        getDetails();
        if (ckValid()) {
            try {
                createAnImg(ColorCode);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, (String) null, ex);
            }
        }
    }

    private void snpPageCountStateChanged(ChangeEvent evt) {
        getDetails();
        if (ckValid()) {
            try {
                createAnImg(ColorCode);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, (String) null, ex);
            }
        }
    }


    private void cmbMainColorItemStateChanged(ItemEvent evt) {
    }


    private void cmbFontColorItemStateChanged(ItemEvent evt) {
        getDetails();
        if (ckValid()) {
            try {
                createAnImg(ColorCode);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, (String) null, ex);
            }
        }
    }

    private void txtTitleFocusLost(FocusEvent evt) {
        getDetails();
        if (ckValid()) {
            try {
                createAnImg(ColorCode);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, (String) null, ex);
            }
        }
    }

    private void cmbMainColorFocusLost(FocusEvent evt) {
        getDetails();
        if (ckValid()) {
            try {
                createAnImg(ColorCode);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, (String) null, ex);
            }
        }
    }


    private void cmbColorCodeFocusLost(FocusEvent evt) {
        getDetails();
        if (ckValid()) {
            try {
                createAnImg(ColorCode);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, (String) null, ex);
            }
        }
    }

    private void btnMltGenarateActionPerformed(ActionEvent evt) {
        String[] ObjButtons = {"Yes", "No"};
        int PromptResult = JOptionPane.showOptionDialog(null, "Genarate multiple colours PDF?\n NOTE : Get several times.\n Please Wait..", "confirm", -1, 2, null, (Object[]) ObjButtons, ObjButtons[1]);
        if (PromptResult == 0) {

            genarateMultiPDF();
            try {
                ZipUtils.pack(printPDF.y, SaveAsMultiPDF(printPDF.y));
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, (String) null, ex);
            }
        }
    }


    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, (String) null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, (String) null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, (String) null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, (String) null, ex);
        }


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new MainMenu()).setVisible(true);
            }
        });
    }


    private void getDetails() {
        Title = this.txtTitle.getText();
        ImgPath = this.txtImgPath.getText();
        String[] parts = this.snpPageSize.getValue().toString().split("x", 2);
        this.PageWidth = parts[0].trim();
        this.PageHight = parts[1].trim();
        String[] part = this.snpPageCount.getValue().toString().split(" ", 2);
        Pagecount = Integer.parseInt(part[0].trim());
        FC = this.cmbFontColor.getSelectedItem().toString().trim();
        ImgType = this.cmbImgType.getSelectedItem().toString();
        if (FC.equalsIgnoreCase("Black")) {
            FontColor = "#000000";
        } else {

            FontColor = "#FFFFFF";
        }
        GenaratedFileName1 = this.txtTitle.getText() + "_" + this.PageWidth + "x" + this.PageHight + "_" + Pagecount + "_" + this.cmbColorCode.getSelectedItem().toString() + "_" + FC;
    }

    private boolean ckValid() {
        if (ImgPath.equalsIgnoreCase("")) {
            this.btnImgOpen.requestFocus();
            this.btnImgOpen.setBackground(Color.RED);
            return false;
        }

        this.btnImgOpen.setBackground(Color.decode("#dddddd"));
        return true;
    }

    private void AddMainColoursToCombo() {
        String mainColorConfigFile = "ColorVar-config.xml";
        String line = "";

        try {
            FileReader fileReader = new FileReader(mainColorConfigFile);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] txt = line.split(",");
                for (int i = 0; i < txt.length; i++) {
                    this.cmbMainColor.addItem(txt[i]);
                }
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            JOptionPane optionPane = new JOptionPane("Unable to open file '" + mainColorConfigFile + "'", 0);
            JDialog dialog = optionPane.createDialog("Failure");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        } catch (IOException ex) {
            JOptionPane optionPane = new JOptionPane("Error reading file '" + mainColorConfigFile + "'", 0);
            JDialog dialog = optionPane.createDialog("Failure");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
    }

    private void showSelectColor(String hexVal) {
        this.pnlColor.setBackground(Color.decode(hexVal));
        this.lblColrCode.setText(hexVal);
    }

    public String checkColorHexValue(String fn, String selectedcolor) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("./data/" + fn + ".json"));
            JSONArray array = (JSONArray) obj;
            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject = (JSONObject) array.get(i);
                if (jsonObject.containsValue(selectedcolor)) {
                    String colorHexValue = (String) jsonObject.get("value");
                    showSelectColor(colorHexValue);
                    ColorCode = colorHexValue;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void AddSubColoursToCombo() {
        this.cmbColorCode.removeAllItems();
        String fn = this.cmbMainColor.getSelectedItem().toString();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("./data/" + fn + ".json"));
            JSONArray array = (JSONArray) obj;
            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject = (JSONObject) array.get(i);
                String name = (String) jsonObject.get("name");
                this.cmbColorCode.addItem(name);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    private String createAnImg(String hexVal) throws IOException {
        String ConfigFile = "Page-config.xml";
        int DPI = 0;
        int IMGPx = 0;
        double PGT = 0.0D;
        int FontSize = 0;
        String FontFamily = "";
        String line = "";

        try {
            FileReader fileReader = new FileReader(ConfigFile);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] txt = line.split(",");
                DPI = Integer.parseInt(txt[0]);
                PGT = Double.parseDouble(txt[1]);
                FontSize = Integer.parseInt(txt[2]);
                FontFamily = txt[3];
            }


            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            JOptionPane optionPane = new JOptionPane("Unable to open file '" + ConfigFile + "'", 0);
            JDialog dialog = optionPane.createDialog("Failure");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        } catch (IOException ex) {
            JOptionPane optionPane = new JOptionPane("Error reading file '" + ConfigFile + "'", 0);
            JDialog dialog = optionPane.createDialog("Failure");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
        double pgWPx = Double.parseDouble(this.PageWidth) * DPI;
        double pgHPx = Double.parseDouble(this.PageHight) * DPI;
        double pgSpinPx = PGT * Pagecount * DPI;
        int pgDefWPxInt = (int) pgWPx;
        int pgSpinWPxInt = (int) Math.round(pgSpinPx);
        int pgSWInt = (int) (pgDefWPxInt + Math.round(pgSpinPx / 2.0D));
        int pgCalWPxInt = (int) (pgWPx * 2.0D + Math.ceil(pgSpinPx)) + 18;
        int pgHPxInt = (int) pgHPx + 18;

        pgHd = pgHPxInt;
        pgWd = pgCalWPxInt;

        BufferedImage buffImg = new BufferedImage(pgCalWPxInt, pgHPxInt, 1);
        Graphics2D grp = buffImg.createGraphics();
        Graphics2D grp2 = buffImg.createGraphics();


        grp.setColor(Color.decode(hexVal));
        grp.fillRect(0, 0, pgCalWPxInt, pgHPxInt);


        Image tmp = loadImage(ImgPath).getScaledInstance(new_width, new_height, 4);
        int imglocX = pgSpinWPxInt + pgDefWPxInt + pgDefWPxInt / 2 - new_width / 2;
        int imglocY = pgHPxInt / 2 - new_height / 2;
        grp.drawImage(tmp, imglocX, imglocY, (ImageObserver) null);
        grp.setComposite(AlphaComposite.getInstance(6));
        float opacity = 0.4F;
        float fadeHeight = 0.3F;
        grp.setPaint(new GradientPaint(0.0F, 100.0F * fadeHeight, new Color(0.0F, 0.0F, 0.0F, 0.0F), 0.0F, 100.0F, new Color(0.0F, 0.0F, 0.0F, opacity)));


        Map<TextAttribute, Object> attributes = new HashMap<>();
        attributes.put(TextAttribute.FAMILY, FontFamily);
        attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_EXTRA_LIGHT);
        attributes.put(TextAttribute.SIZE, Integer.valueOf(FontSize));
        Font newFont = Font.getFont((Map) attributes);
        grp2.setColor(Color.decode(FontColor));
        grp2.setFont(newFont);
        AffineTransform at = AffineTransform.getQuadrantRotateInstance(3);
        grp2.setTransform(at);
        int titleLen = Title.length();
        grp2.drawString(Title, -(pgHPxInt / 2 + 2 * titleLen), pgCalWPxInt / 2);

        grp.dispose();
        grp2.dispose();


        GenaratedFileName = this.txtTitle.getText() + "_" + this.PageWidth + "x" + this.PageHight + "_" + Pagecount + "_" + this.cmbColorCode.getSelectedItem().toString() + "_" + FC + ".png";
        File file = new File(".tmp32/" + GenaratedFileName);
        ImageIO.write(buffImg, "png", file);


        ImageIcon TmpPreImage = new ImageIcon(buffImg.getScaledInstance(238, 211, 300));
        this.lblSampleView.setIcon(TmpPreImage);
        return GenaratedFileName;
    }

    private String SaveAsMultiPDF(String GenaratedFileName) throws IOException {
        try {
            JFileChooser fileChooser = new JFileChooser();
            String[] fn = GenaratedFileName.split("/");
            this.SavePDFChooser.setSelectedFile(new File(fn[1] + ".zip"));
            this.SavePDFChooser.setDialogTitle("Select the Save Location");
            this.SavePDFChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("ZIP", new String[]{"zip"});
            this.SavePDFChooser.addChoosableFileFilter(filter);
            int returnValue = this.SavePDFChooser.showSaveDialog(this);
            if (returnValue == 0) {
                File f = this.SavePDFChooser.getSelectedFile();
                return f.getAbsolutePath();

            }

        } catch (Exception exception) {
        }


        return null;
    }

    private boolean SaveAsPDF(String GenaratedFileName1) throws IOException {
        try {
            JFileChooser fileChooser = new JFileChooser();
            this.SavePDFChooser.setSelectedFile(new File(GenaratedFileName1 + ".pdf"));
            this.SavePDFChooser.setDialogTitle("Select the Save Location");
            this.SavePDFChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", new String[]{"pdf"});
            this.SavePDFChooser.addChoosableFileFilter(filter);
            int returnValue = this.SavePDFChooser.showSaveDialog(this);
            if (returnValue == 0) {
                File f = this.SavePDFChooser.getSelectedFile();
                String mainColorConfigFile = f.getAbsolutePath();
                txtSaveFilePath = mainColorConfigFile;
                return true;
            }
        } catch (Exception exception) {
        }


        return false;
    }

    private BufferedImage loadImage(String path) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            org_att_img_width = image.getWidth();
            org_att_img_height = image.getHeight();
            double nH = image.getHeight() * Integer.parseInt(this.txtAtt_img_scl.getValue().toString()) / 100.0D;
            double nW = image.getWidth() * Integer.parseInt(this.txtAtt_img_scl.getValue().toString()) / 100.0D;
            new_height = (int) nH;
            new_width = (int) nW;
            return image;
        } catch (Exception ex) {
            Logger.getLogger(Surface.class.getName()).log(Level.WARNING, (String) null, ex);
            return null;
        }
    }

    private void clearTemp(String path) {
        File file = new File(path);

        if (file.isDirectory()) {
            String[] myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }
    }

    private void clearFolder(String path) {
        File index = new File(path);
        String[] entries = index.list();
        for (String s : entries) {
            File currentFile = new File(index.getAbsolutePath(), s);
            clearTemp(currentFile.getAbsolutePath());
        }
    }

    private void OpenDef() {
        this.txtImgPath.setText("data/feather1.png");
        Title = this.txtTitle.getText();
        ImgPath = this.txtImgPath.getText();
        String[] parts = this.snpPageSize.getValue().toString().split("x", 2);
        this.PageWidth = parts[0].trim();
        this.PageHight = parts[1].trim();
        String[] part = this.snpPageCount.getValue().toString().split(" ", 2);
        Pagecount = Integer.parseInt(part[0].trim());
        FC = this.cmbFontColor.getSelectedItem().toString().trim();
        ImgType = this.cmbImgType.getSelectedItem().toString();
        this.txtAtt_img_scl.setValue(Integer.valueOf(45));
        if (FC.equalsIgnoreCase("Black")) {
            FontColor = "#000000";
        } else {

            FontColor = "#FFFFFF";
        }
        GenaratedFileName1 = this.txtTitle.getText() + "_" + this.PageWidth + "x" + this.PageHight + "_" + Pagecount + "_" + this.cmbColorCode.getSelectedItem().toString() + "_" + FC;
    }

    private void genarateMultiPDF() {
        getDetails();
        if (Title.equalsIgnoreCase("")) {
            String[] ObjButtons = {"Yes", "No"};
            int PromptResult = JOptionPane.showOptionDialog(null, "The Title is empty. Add sample title?", "confirm", -1, 2, null, (Object[]) ObjButtons, ObjButtons[1]);
            if (PromptResult == 0) {

                Title = "SAMPLE_TITLE";
                this.txtTitle.setText(Title);
            }
        }
        txtSaveMultiFileName = this.txtTitle.getText() + "_" + this.PageWidth + "x" + this.PageHight + "_" + Pagecount + "_" + FC;

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("./data/multi.json"));
            JSONArray array = (JSONArray) obj;
            System.out.println(array.size());
            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject = (JSONObject) array.get(i);
                String colorName = (String) jsonObject.get("name");
                String colorHexValue = (String) jsonObject.get("value");
                try {
                    printPDF.MultiPngToPdf(createMultiImg(colorHexValue, colorName));
                } catch (IOException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, (String) null, ex);
                }

                if (i == array.size() - 1) {
                    JOptionPane.showMessageDialog(null, "All PDF are created successful.");
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    private String createMultiImg(String hexVal, String colorName) throws IOException {
        String ConfigFile = "Page-config.xml";
        int DPI = 0;
        int IMGPx = 0;
        double PGT = 0.0D;
        int FontSize = 0;
        String FontFamily = "";
        String line = "";

        try {
            FileReader fileReader = new FileReader(ConfigFile);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] txt = line.split(",");
                DPI = Integer.parseInt(txt[0]);
                PGT = Double.parseDouble(txt[1]);
                FontSize = Integer.parseInt(txt[2]);
                FontFamily = txt[3];
            }


            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            JOptionPane optionPane = new JOptionPane("Unable to open file '" + ConfigFile + "'", 0);
            JDialog dialog = optionPane.createDialog("Failure");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        } catch (IOException ex) {
            JOptionPane optionPane = new JOptionPane("Error reading file '" + ConfigFile + "'", 0);
            JDialog dialog = optionPane.createDialog("Failure");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
        double pgWPx = Double.parseDouble(this.PageWidth) * DPI;
        double pgHPx = Double.parseDouble(this.PageHight) * DPI;
        double pgSpinPx = PGT * Pagecount * DPI;
        int pgDefWPxInt = (int) pgWPx;
        int pgSpinWPxInt = (int) Math.round(pgSpinPx);
        int pgSWInt = (int) (pgDefWPxInt + Math.round(pgSpinPx / 2.0D));
        int pgCalWPxInt = (int) (pgWPx * 2.0D + Math.ceil(pgSpinPx)) + 18;
        int pgHPxInt = (int) pgHPx + 18;

        pgHd = pgHPxInt;
        pgWd = pgCalWPxInt;

        BufferedImage buffImg = new BufferedImage(pgCalWPxInt, pgHPxInt, 1);
        Graphics2D grp = buffImg.createGraphics();
        Graphics2D grp2 = buffImg.createGraphics();


        grp.setColor(Color.decode(hexVal));
        grp.fillRect(0, 0, pgCalWPxInt, pgHPxInt);


        Image tmp = loadImage(ImgPath).getScaledInstance(new_width, new_height, 4);
        int imglocX = pgSpinWPxInt + pgDefWPxInt + pgDefWPxInt / 2 - new_width / 2;
        int imglocY = pgHPxInt / 2 - new_height / 2;
        grp.drawImage(tmp, imglocX, imglocY, (ImageObserver) null);
        grp.setComposite(AlphaComposite.getInstance(6));
        float opacity = 0.4F;
        float fadeHeight = 0.3F;
        grp.setPaint(new GradientPaint(0.0F, 100.0F * fadeHeight, new Color(0.0F, 0.0F, 0.0F, 0.0F), 0.0F, 100.0F, new Color(0.0F, 0.0F, 0.0F, opacity)));


        Map<TextAttribute, Object> attributes = new HashMap<>();
        attributes.put(TextAttribute.FAMILY, FontFamily);
        attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_EXTRA_LIGHT);
        attributes.put(TextAttribute.SIZE, Integer.valueOf(FontSize));
        Font newFont = Font.getFont((Map) attributes);
        grp2.setColor(Color.decode(FontColor));
        grp2.setFont(newFont);
        AffineTransform at = AffineTransform.getQuadrantRotateInstance(3);
        grp2.setTransform(at);
        int titleLen = Title.length();
        grp2.drawString(Title, -(pgHPxInt / 2 + 2 * titleLen), pgCalWPxInt / 2);

        grp.dispose();
        grp2.dispose();


        MultiGenaratedFileName = colorName + "_" + hexVal;
        File file = new File(".tmp32/" + MultiGenaratedFileName + ".png");
        ImageIO.write(buffImg, "png", file);
        return MultiGenaratedFileName;
    }
}
