package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class JavaFXCalculatorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField display;

    double result=0;
    double temp=0;
    String operator="";
    boolean isOperatorPressed;

    CheckNumbers check = new CheckNumbers();
    Calculator calculator = new Calculator();

    @FXML
    void onNumberClick(ActionEvent event) {
        if(event.getSource() instanceof Button) {
            Button buttonNumber = (Button) event.getSource();

            String buttonString = buttonNumber.getText();
            boolean checkDisplayZero = check.checkIfZero(display.getText());
            boolean checkDisplayDot = check.checkIfDot(display.getText());

            if (isOperatorPressed == false) {
                if ((buttonString.equals("0") && checkDisplayZero == true)) {
                    display.setText(display.getText());
                } else if (buttonString.equals(".") && checkDisplayDot == true) {
                    display.setText(display.getText());
                } else if (checkDisplayZero == true && buttonString.equals(".") == false) {
                    display.setText(buttonString);
                } else if (display.getText().equals("") && buttonString.equals(".")) {
                    display.setText("0.");
                } else {
                    display.setText(display.getText() + buttonString);
                }
            } else {
                if (display.getText().equals("") && buttonString.equals(".")) {
                    display.setText("0.");
                } else {
                    display.setText(buttonString);
                }
            }
            isOperatorPressed = false;
        }
    }


    @FXML
    void onOperatorClick(ActionEvent event) {
        if(event.getSource() instanceof Button) {
            Button buttonOperator = (Button) event.getSource();

            if (display.getText().isEmpty() == false) {
                temp = Double.valueOf(display.getText());

                if(buttonOperator.getText().equals("+/-") || buttonOperator.getText().equals("%")){
                    result = calculator.other(buttonOperator.getText(), temp);
                    display.setText(String.valueOf(result));
                    operator="";
                }
                else{
                    result =  calculator.calculate(operator, result, temp);
                }
            }
            if (buttonOperator.getText().equals("=")) {
                display.setText(String.valueOf(result));
                operator="";
            }
            else{
                operator=buttonOperator.getText();
            }

            isOperatorPressed = true;
        }
    }


    @FXML
    void onClearClick(ActionEvent event) {
        display.setText("");
        isOperatorPressed=false;
        operator="";
        result=0;
        temp=0;
    }

    @FXML
    void initialize() {
        assert display != null : "fx:id=\"display\" was not injected: check your FXML file 'calculator.fxml'.";

    }
}
