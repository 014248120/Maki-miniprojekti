/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author alrial
 */
public class Field {
    
    private String name;
    private JTextField field;
    private JLabel text;
    
    public Field(String name, Container container){
        this.name = name;
        this.field = new JTextField();
        this.text = new JLabel(this.name);       
        container.add(this.field);
        container.add(this.text);
    }
    
    public String getText(){
        return this.field.getText();
    }
    
    public void setPosition(int x, int y){        
        this.text.setBounds(x, y, 100, 30);
        this.field.setBounds(x+120, y, 300, 30);
    }
    
    
}
