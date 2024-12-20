package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//handles action EVENTS, interacts with COMPONENTS(e.g Clicking on a button)
public class Calculator implements ActionListener {
    JFrame frame;//Creats the frame where every actions will happen
    JTextField textField;//holds all the numbers and results we type in
    JButton[] numberButtons = new JButton[10];//number from 0-9
    JButton[] functionalButtons = new JButton[12];//operator +,-,*,/,.,=,CLEAR,DELETE
    JButton leftBracket, rightBracket, Percentage, negativeButton;
    JButton addButton, subButton, multiplyButton, divisionButton;
    JButton decimalButton, clearButton, deleteButton, equalButton;
    JPanel panel;//adds a Panel for operators to be displayed

    Font myFont = new Font("Georgia", Font.BOLD, 26);

    double num1 = 0, num2 = 0, result = 0;//initialzing NUMS and RESULT as 0
    char operator;//holds ARITHMETIC operation of +-*/
        Calculator() {

        frame = new JFrame("Calculator");//Title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//executes the CLOSE button
        frame.setSize(550,650);//declaring width and heigth
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLayout(null);//layout manager as null, so we have to set size yourself

        textField = new JTextField();//adds the Panel
        textField.setBounds(60,30,400,60);//x-Right,Left/y-Top,Bottom/width,height
        textField.setFont(myFont);//set the font of nums and texts in the panel
        textField.setEditable(false);//cant put anything in the panel unless operators

        //creates button for the Calculator
        leftBracket = new JButton("(");
        rightBracket = new JButton(")");
        Percentage = new JButton("%");
        negativeButton = new JButton("(-)");
        addButton = new JButton("+");
        subButton = new JButton("-");
        multiplyButton = new JButton("*");
        divisionButton = new JButton("/");
        decimalButton = new JButton(".");
        clearButton = new JButton("CLEAR");
        deleteButton = new JButton("DELETE");
        equalButton = new JButton("=");

        functionalButtons[0] = leftBracket;
        functionalButtons[1] = rightBracket;
        functionalButtons[2] = Percentage;
        functionalButtons[3] = negativeButton;
        functionalButtons[4] = addButton;
        functionalButtons[5] = subButton;
        functionalButtons[6] = multiplyButton;
        functionalButtons[7] = divisionButton;
        functionalButtons[8] = decimalButton;
        functionalButtons[9] = clearButton;
        functionalButtons[10] = deleteButton;
        functionalButtons[11] = equalButton;

        for(int i=0; i<12; i++) {
            functionalButtons[i].addActionListener(this);//allowing it to respond to user interactions.
            functionalButtons[i].setFont(myFont);//Sets the font of each button to a custom font
            functionalButtons[i].setFocusable(false);//Disables the focus border around the button when it is clicked
        }

        for(int i=0; i<10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);/*This adds an ActionListener to each number button. 
            The this keyword refers to the current instance of the class, which is expected to implement the ActionListener interface*/
            numberButtons[i].setFont(myFont);//Sets the font of each button to a custom font
            numberButtons[i].setFocusable(false);//Disables the focus border around the button when it is clicked
        }

        deleteButton.setBounds(70,520,180,50);//set the position x,y and size (width, height)
        clearButton.setBounds(270,520,180,50);//set the position x,y and size (width, height)

        panel = new JPanel();// Create a new JPanel (a container that can store and manage other components)
        panel.setBounds(74,133,370,370);// Set the position x,y: and size (width,height) of the panel
        panel.setLayout(new GridLayout(5,4,10,10));// Set the layout of the panel to a 4x4 grid with horizontal and vertical gaps of 10 pixels
        panel.setBackground(Color.DARK_GRAY);

        panel.add(leftBracket);
        panel.add(rightBracket);
        panel.add(Percentage);
        panel.add(negativeButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divisionButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(multiplyButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);
        panel.add(numberButtons[0]);
        panel.add(decimalButton);
        panel.add(equalButton);
        panel.add(addButton);
       
        frame.add(panel);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textField);//adding the panel into the Frame
        frame.setVisible(true);
    }
    public static void main(String[] args) {
       Calculator calc = new Calculator();
       }

        @Override
    public void actionPerformed(ActionEvent e) {
        //Number Button
      for(int i=0; i<10; i++) {
    if(e.getSource() == numberButtons[i]) {
        textField.setText(textField.getText().concat(String.valueOf(i)));
      }
    }
        //Decimal Button
        if (e.getSource() == decimalButton) {
            if (!textField.getText().contains(".")) {  // Prevent multiple decimals
                textField.setText(textField.getText().concat("."));
            }
        }
    

        //Addition Button
    if(e.getSource() == addButton) {
       num1 = Double.parseDouble(textField.getText());
       operator = '+';
       textField.setText("");
          }
        
          //Substraction Button
    if(e.getSource() == subButton) {
        num1 = Double.parseDouble(textField.getText());
        operator = '-';
        textField.setText("");
            }
        
        //Multiplication Button
    if(e.getSource() == multiplyButton) {
        num1 = Double.parseDouble(textField.getText());
         operator = '*';
        textField.setText("");
            }

        //Division Button
    if(e.getSource() == divisionButton) {
        num1 = Double.parseDouble(textField.getText());
         operator = '/';
        textField.setText("");
            }
        
        // Equal Button
    if (e.getSource() == equalButton) {
        num2 = Double.parseDouble(textField.getText());

        switch(operator) {
        case '+' :
            result = num1 + num2;
            break;
        case '-' :
            result = num1 - num2;
            break;
        case '*' :
            result = num1 * num2;
            break;
        case '/' :
        if (num2 != 0) {  // Check for division by zero
            result = num1 / num2;
        } else {
            textField.setText("Error");
            return;
        }
        break;
        
        }

        textField.setText(String.valueOf(result)); 
        num1 = result;
    }
        //Clear Button
        if (e.getSource() == clearButton) {
            textField.setText("");
        }
    
        //Delete Button
        if(e.getSource() == deleteButton) {
            String string = textField.getText();
            if(!string.isEmpty()) {
                textField.setText(string.substring(0,string.length()-1));
            }
        }
         // Negative Button
    if (e.getSource() == negativeButton) {
        try {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        } catch (NumberFormatException ex) {
            textField.setText("Error");  // Handle invalid input
        }
    }
        //Percentage
        if (e.getSource() == Percentage) {
            try {
                double temp = Double.parseDouble(textField.getText());
                temp = temp / 100;
                textField.setText(String.valueOf(temp));
            } catch (NumberFormatException ex) {
                textField.setText("Error");  // Handle invalid input
            }
        }
        //Bracket
        if (e.getSource() == leftBracket) {
            textField.setText(textField.getText().concat("("));
        }
    
        if (e.getSource() == rightBracket) {
            textField.setText(textField.getText().concat(")"));
        }
    }
}