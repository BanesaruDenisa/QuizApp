package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CTest extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    // create objects
    JLabel label;
    JRadioButton radioButton[] = new JRadioButton[4];
    JButton btnNext, btnResult;
    ButtonGroup btng;
    int count = 0;
    int current = 0;

    // constructor create JFrame with radioButton and JButton
    CTest(String s) {
        super(s);
        label = new JLabel();
        add(label);
        btng = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            btng.add(radioButton[i]);
        }

        btnNext = new JButton("Next");
        btnResult = new JButton("Result");
        btnResult.setVisible(false);        // hide the button
        btnNext.addActionListener(this);
        btnResult.addActionListener(this);
        add(btnNext);
        add(btnResult);
        set();
        label.setBounds(30, 40, 450, 20);
        radioButton[0].setBounds(50, 80, 450, 20);
        radioButton[1].setBounds(50, 110, 200, 20);
        radioButton[2].setBounds(50, 140, 200, 20);
        btnNext.setBounds(100, 240, 100, 30);
        btnResult.setBounds(270, 240, 100, 30);
        label.setFont(new Font ("TimesRoman", Font.BOLD , 14));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(430, 350);
        Color myc = new Color(224, 71, 221);
        myc.getTransparency();
        getContentPane().setBackground(myc);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            if (check())
                count += 1;
            current++;
            set();
            if (current == 2) {
                btnNext.setEnabled(false);      // can't do next
                btnResult.setVisible(true);     // apear result button
                btnResult.setText("Result");

            }
        }
        if (e.getActionCommand().equals("Result")) {
            if (check())
                count += 1;
            current++;
            JOptionPane.showMessageDialog(this, "Points = " + count + "/3");
            System.exit(0);
        }
    }

    // set questions with options
    void set() {
        radioButton[3].setSelected(true);
        if (current == 0) {
            label.setText("1. On how many bits is a char represented?");
            radioButton[0].setText("16");
            radioButton[1].setText("8");
            radioButton[2].setText("32");

        }
        if (current == 1) {
            label.setText("2. Array elements are accessed by the operator...");
            radioButton[0].setText("[]");
            radioButton[1].setText("{}");
            radioButton[2].setText("()");

        }
        if (current == 2) {
            label.setText("3. How can we find the memory address of a variable?");
            radioButton[0].setText("&");
            radioButton[1].setText("*");
            radioButton[2].setText("@");

        }

        label.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            radioButton[j].setBounds(50, 80 + i, 200, 20);
    }

    // declare the correct answers
    boolean check() {
        if (current == 0)
            return (radioButton[1].isSelected());
        if (current == 1)
            return (radioButton[0].isSelected());
        if (current == 2)
            return (radioButton[0].isSelected());
        return false;
    }

}