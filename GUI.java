package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI implements ActionListener {

    private static JLabel label;
    private static JLabel result;
    private static JTextField text;
    private static JButton convertFahrenheit;
    private static JButton convertCelsius;
    private static JButton convertKelvin;
    private static JRadioButton cSelect;
    private static JRadioButton fSelect;
    private static JRadioButton kSelect;
    private static ButtonGroup group;

    public static void main(String[] args) {

        JPanel panel = new JPanel();
        JFrame frame = new JFrame("ConvTemp");
        frame.setSize(260, 120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        label = new JLabel("Temperatura:");
        label.setBounds(10, 10, 100, 15);
        panel.add(label);

        result = new JLabel("");
        result.setBounds(10, 55, 150, 10);
        panel.add(result);

        text = new JTextField();
        text.setBounds(100, 10, 100, 15);
        panel.add(text);

        convertFahrenheit = new JButton("F");
        convertFahrenheit.setBounds(75, 30, 60, 20);
        convertFahrenheit.addActionListener(new GUI());
        convertFahrenheit.setActionCommand("f");
        panel.add(convertFahrenheit);

        convertCelsius = new JButton("C");
        convertCelsius.setBounds(10, 30, 60, 20);
        convertCelsius.addActionListener(new GUI());
        convertCelsius.setActionCommand("c");
        panel.add(convertCelsius);

        convertKelvin = new JButton("K");
        convertKelvin.setBounds(140, 30, 60, 20);
        convertKelvin.addActionListener(new GUI());
        convertKelvin.setActionCommand("k");
        panel.add(convertKelvin);

        cSelect = new JRadioButton("C");
        cSelect.setBounds(205, 10, 75, 15);
        cSelect.addActionListener(new GUI());
        cSelect.setSelected(true);
        panel.add(cSelect);

        fSelect = new JRadioButton("F");
        fSelect.setBounds(205, 30, 75, 15);
        fSelect.addActionListener(new GUI());
        fSelect.setSelected(false);
        panel.add(fSelect);

        kSelect = new JRadioButton("K");
        kSelect.setBounds(205, 50, 75, 15);
        kSelect.addActionListener(new GUI());
        kSelect.setSelected(false);
        panel.add(kSelect);

        group = new ButtonGroup();
        group.add(cSelect);
        group.add(fSelect);
        group.add(kSelect);
        frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        double input = Double.parseDouble(text.getText());
        double output = 0;

        if(e.getActionCommand() == "c" && cSelect.isSelected()) {
            result.setText("Grade Celsius: "+input);
        }
        else if(e.getActionCommand() == "f" && cSelect.isSelected()) {
            output = ((input * 9) / 5) + 32;
            result.setText("Grade Fahrenheit: " + output);
        }
        else if(e.getActionCommand() == "k" && cSelect.isSelected()) {
            output = input + 273.15;
            result.setText("Grade Kelvin: " + output);
        }
        else if(e.getActionCommand() == "c" && fSelect.isSelected()) {
            output = (((input - 32) * 5)/9);
            result.setText("Grade Celsius: " + output);
        }
        else if(e.getActionCommand() == "f" && fSelect.isSelected()) {
            result.setText("Grade Fahrenheit: "+input);
        }
        else if(e.getActionCommand() == "k" && fSelect.isSelected()) {
            output = (((input - 32) * 5)/9) + 273.15;
            result.setText("Grade Kelvin: " + output);
        }
        else if(e.getActionCommand() == "c" && kSelect.isSelected()) {
            output = input - 273.15;
            result.setText("Grade Celsius: " + output);
        }
        else if(e.getActionCommand() == "f" && kSelect.isSelected()) {
            output = (((input - 273.15)*9)/5)+32;
            result.setText("Grade Fahrenheit: " + output);
        }
        else if(e.getActionCommand() == "k" && kSelect.isSelected()) {
            result.setText("Grade Kelvin: " + input);
        }
    }
}