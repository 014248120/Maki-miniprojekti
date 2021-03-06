package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import referencechampion.Book;

/**
 * @author alrial
 */
public class UI implements Runnable {

    private int windowWidth;
    private int windowHeight;
    private JFrame window;
    private Map<String, Field> fields;
    private int fieldPosX = 20;
    private int fieldPosY = 60; 
    private Book book;

    public UI(int width, int height) {
     this.windowWidth = width;
     this.windowHeight = height;
    }

    @Override
    public void run() {
        constructWindow();

    }
    
    private void constructWindow(){
        window = new JFrame("Reference Champion");


        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension dimension = new Dimension(windowWidth, windowHeight);
        window.setResizable(false);
        contructWindowComponents(window.getContentPane());
        window.setPreferredSize(dimension);

        window.pack();
        window.setVisible(true);
    }

    private void contructWindowComponents(Container container) {
        container.setBackground(Color.DARK_GRAY);
        container.setLayout(new GroupLayout(container));       
        
        JTabbedPane tabs = new JTabbedPane();    
      
        Container addReferencePage = new Container();   
        
        tabs.addTab("Add reference", addReferencePage); 

        tabs.setBounds(0, 0, windowWidth, windowHeight);
        container.add(tabs);
        
        JLabel pagetitle = new JLabel("Create a new book");
        pagetitle.setBounds(20, 10, 300, 30);
        addReferencePage.add(pagetitle);
               

        this.fields = FieldCreator.createFields(new Book().getFields(), addReferencePage);
        
        setFieldsPosition(fieldPosX, fieldPosY, 40);              
        
        
        JButton createReference = new JButton("Create a reference");  
        createReference.setBounds(20, 520, 300, 30);
        addReferencePage.add(createReference);
        
        
    }
    
    
    private void setFieldsPosition(int x, int y, int gap){
        for (Field field: this.fields.values()) {
            field.setPosition(x, y);
            y += gap;
        }  
    }
    
    
}
