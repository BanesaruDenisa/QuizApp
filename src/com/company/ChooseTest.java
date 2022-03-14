package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ChooseTest extends JFrame implements ActionListener {

    String [] test = {"C++", "Java", "Python"};
    JComboBox<String> cmbtest = new JComboBox<>(test);
    JLabel labelText = new JLabel();

    public ChooseTest(){


        setLayout(new FlowLayout());
        setSize(610, 610);
        setTitle("Quiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        labelText.setText("Choose the language for the test");
        labelText.setBounds(30, 40, 450, 20);
        cmbtest.setSelectedIndex(0);
        cmbtest.addActionListener(this);
        cmbtest.setBounds(50,40,60,30);
        add(cmbtest);
        add(labelText);

        ImageIcon image = new ImageIcon("C:\\Users\\Denisa\\IdeaProjects\\QuizApp\\quiz.jpg");
        add(new JLabel(image));

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == cmbtest) {
            JComboBox cb = (JComboBox)e.getSource();
            String msg = (String)cb.getSelectedItem();


            switch (msg) {
                case "C++" : new CTest("C++ Test");
                    break;
                case "Java" :
                            new JavaTest("Java Test");
                    break;
                case "Python" : new PythonTest("Python Test");
                    break;
                default : labelText.setText("You didn't choose the language");
            }
        }
    }

    public static void main(String[] args){

        ChooseTest frame = new ChooseTest();
        frame.setVisible(true);
    }
}