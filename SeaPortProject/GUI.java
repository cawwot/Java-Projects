package seaport;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 * @date created
 * @author Ian Spooner
 */
public class GUI extends JDialog {

    // <editor-fold defaultstate="collapsed" desc="Declarations">
    public static JFileChooser fc = new JFileChooser(".");
    Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);
    static JFrame popup = new JFrame("Popup Window");
    private javax.swing.JButton loadButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JScrollPane outputBox;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTextArea outLog;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel BLANK;
    public static ArrayList<ArrayList<Integer>> adjLists = new ArrayList<>();
    public static List<String> wholeList = new ArrayList<>();
    public static int bigChoice = -1;
    // </editor-fold> FOLD ALL THE BLOCKS!

    public GUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        super.setSize(500, 550);
        Build();
    }

    private void Build() {
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        loadButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        searchLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        outputBox = new javax.swing.JScrollPane();
        outLog = new javax.swing.JTextArea();
        outputLabel = new javax.swing.JLabel();
        fileNameLabel = new javax.swing.JLabel();
        BLANK = new javax.swing.JLabel();

        outputLabel.setText("Output:");
        fileNameLabel.setText("Load Data From File");
        loadButton.setText("Load...");
        searchButton.setText("Search");
        searchField.setText("Enter string to search for...");
        searchLabel.setText("Search target: ");
        BLANK.setText(" ");
        outLog.setEditable(false);
        outLog.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        outputBox.setViewportView(outLog);
        loadButton.requestFocusInWindow();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
                jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
                jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
                jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
                jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );
        loadButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                loadButtonPressed(evt);
            } catch (IOException ex) {
                warning("IO Error!");
            }
        });
        searchButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            searchButtonActionPerformed(evt);
        });
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                entryFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(outputBox, javax.swing.GroupLayout.Alignment.CENTER)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(searchLabel)
                                                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(fileNameLabel)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(BLANK, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(loadButton)
                                                .addComponent(searchButton)))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(outputLabel)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(loadButton)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BLANK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fileNameLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(searchButton)
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outputLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outputBox, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
        );
        //pack();
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (searchField.getText().equals("") || searchField.getText().equals(" ")) {
            warning("You didn't enter anything...");
        } else {
            //search logic
        }
    }

//    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
//        String newFile = fileName.getText();
//        outLog.append("Contents of File " + newFile + ":\n-----------------\n");
//        File file = new File(newFile);
//        try {
//            BufferedReader outPrint = new BufferedReader(new FileReader(file));
//            String line = outPrint.readLine();
//            int i = 0;
//            while (line != null) {
//                outLog.append(line + "\n");
//
//                List<String> putList = new ArrayList<>();
//                String[] items = line.split(" ");
//                putList.addAll(Arrays.asList(items));
//                int f = putList.size();
//                wholeList.addAll(Arrays.asList(items));
//                adjLists.add(new ArrayList<>());
//                for (int d = 0; d < f; d++) {
//                    int h = -1;
//                    switch (putList.get(d)) {
//                        case "ClassA":
//                            h = 0;
//                            break;
//                        case "ClassB":
//                            h = 1;
//                            break;
//                        case "ClassC":
//                            h = 2;
//                            break;
//                        case "ClassD":
//                            h = 3;
//                            break;
//                        case "ClassE":
//                            h = 4;
//                            break;
//                        case "ClassF":
//                            h = 5;
//                            break;
//                        case "ClassG":
//                            h = 6;
//                            break;
//                        case "ClassH":
//                            h = 7;
//                            break;
//                        default:
//                            warning("Class entered is invalid");
//                            break;
//                    }
//                    adjLists.get(i).add(h);
//                }
//                //vertexes.put(i, putList);
//                i++;
//                line = outPrint.readLine();
//            }
//            //project4Sort.assignList(wholeList);
//            outLog.append("\n-----------------\n");
//            warning("Graph Built Sucessfully!");
//        } catch (FileNotFoundException ex) {
//            warning("That's not a file that this program can read.");
//        }
//    }
    private void entryFocusGained(java.awt.event.FocusEvent evt) {
        searchField.setText("");
    }

    private void loadButtonPressed(java.awt.event.ActionEvent evt) throws IOException {
        //Handle open button action.
        if (evt.getSource() == loadButton) {
            int fileSelected = fc.showOpenDialog(GUI.this);

            if (fileSelected == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();

                String fileName = file.getName();
                outLog.append("Contents of File " + fileName + ":\n-----------------\n");//print header //debug
                try {
                    try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = in.readLine()) != null) {
                            outLog.append(line + "\n");//debug
                            FileLoader.Parse(file);
                        }
                    }
                    System.out.println("Opened file " + fileName);//debug
                } 
                catch (IOException ex) {
                    warning("That's not a file that this program can read.");
                }
            } else {
                System.out.println("Open command cancelled by user." + "\n");//debug
            }
        }
    }

    public static void warning(String error) {
        JOptionPane.showMessageDialog(popup,
                "Message: \n"
                + error,
                "Try again",
                JOptionPane.WARNING_MESSAGE);
    }

}
