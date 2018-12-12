/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import datechooser.beans.DateChooserCombo;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author alejandro.delmedico
 */
public abstract class Utiles {
    
    public static String setDataFrom(JComboBox comboBox){
        String data = "";
        if(comboBox.getSelectedIndex() != 0){
            data = (String)comboBox.getSelectedItem();
        }
        return data;
    }
    
    public static double setDoubleFrom(JTextField textField){
        double numero = 0;
        try{
            numero = Double.parseDouble(textField.getText());
        }catch(Exception e){}
        return numero;
    }
    
    public static Date setDateFrom(DateChooserCombo dateChooser){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = null;
        try{
            date = new Date(sdf.parse(dateChooser.getText()).getTime());
        }catch(Exception e){}
        return date;
    }
}
