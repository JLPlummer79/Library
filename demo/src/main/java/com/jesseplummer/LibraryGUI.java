package com.librarydata.demo;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class LibraryGUI extends JPanel implements ActionListener {
    public LibraryGUI() {
        super(new GridLayout(4, 4));
         
        JTabbedPane tabbedPane = new JTabbedPane();
        //ImageIcon icon = createImageIcon("images/middle.gif");
         
        JComponent panel1 = makeSearchPanel();
        tabbedPane.addTab("Search Books", null, panel1,
                "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
         
        JComponent panel2 = makeTextPanel("Customer Panel");
        tabbedPane.addTab("Search Card Holders", null, panel2,
                "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
         
        JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Tab 3", null, panel3,
                "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
         
        JComponent panel4 = makeTextPanel(
                "Panel #4 (has a preferred size of 410 x 50).");
        panel4.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab("Tab 4", null, panel4,
                "Does nothing at all");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
         
        //Add the tabbed pane to this panel.
        add(tabbedPane);
         
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
    protected JComponent makeSearchPanel() {
        JPanel panel = new JPanel();
        GridBagConstraints layoutConst = null;
        JLabel searchName = new JLabel("Enter Author Name:");
        JTextField nameField = new JTextField(10);
        JLabel searchTitle = new JLabel("Enter Book Title:");
        JTextField titleField = new JTextField(10);
        JLabel searchGenere = new JLabel("Enter Genere:");
        JTextField genereField = new JTextField(10);
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 5, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        layoutConst.gridwidth = 4;
        layoutConst.gridheight = 4;
        panel.add(searchName, layoutConst);
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 5, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        layoutConst.gridwidth = 4;
        layoutConst.gridheight = 4;
        panel.add(nameField, layoutConst);
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 5, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        layoutConst.gridwidth = 4;
        layoutConst.gridheight = 4;
        panel.add(searchTitle, layoutConst);
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 5, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        layoutConst.gridwidth = 4;
        layoutConst.gridheight = 4;
        panel.add(titleField, layoutConst);
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 5, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        layoutConst.gridwidth = 4;
        layoutConst.gridheight = 4;
        panel.add(searchGenere, layoutConst);
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 5, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 2;
        layoutConst.gridwidth = 4;
        layoutConst.gridheight = 4;
        panel.add(genereField, layoutConst);


        return panel;
    }
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel();
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        //String author = nameField.getText();
    }
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Librarian GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Add content to the window.
        frame.add(new LibraryGUI(), BorderLayout.CENTER);
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        createAndShowGUI();
            }
        });
    }
}
