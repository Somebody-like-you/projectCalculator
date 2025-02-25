package org.example.projectcalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;

import java.util.regex.*;

class DegreesToRadiansConverter {


    public static String convertDegreesToRadians(String expression) {
        String regex = "(sin|cos|tan)\\((-?\\d+\\.?\\d*)\\)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);

        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            String function = matcher.group(1);
            double degrees = Double.parseDouble(matcher.group(2));

            double radians = Math.toRadians(degrees);

            matcher.appendReplacement(result, function + "(" + radians + ")");
        }
        matcher.appendTail(result);

        return result.toString();
    }
}

public class controller1 {
    @FXML
    private Label input;
    @FXML
    private  Label output;
    String expression = "";
    double ANS;
    boolean deg = false;
    public void numericButton(ActionEvent e) {
        Button b = (Button) (e.getSource());
        expression += b.getText();
        input.setText(expression);

    }

    public void funSin() {
        expression += "sin";
        input.setText(expression);

    }

    public void funCos() {
        expression += "cos";
        input.setText(expression);

    }

    public void funTan() {
        expression += "tan";
        input.setText(expression);

    }

    public void funLn() {
        expression += "log";
        input.setText(expression);

    }


    public void pi() {
        expression += "π";
        input.setText(expression);

    }

    public void e() {
        expression += "e";
        input.setText(expression);

    }

    public void opLeftBracket() {
        expression += "(";
        input.setText(expression);

    }

    public void opRightBracket() {
        expression += ")";
        input.setText(expression);
    }


    public void funSquared()
    {
        expression += "xx";
        input.setText(expression);
    }

    public void funRoot()
    {
        expression += " √";
        input.setText(expression);
    }

    public void funLog()
    {
        expression += "Log";
        input.setText(expression);
    }

    public void funFactorial()
    {
        expression += "!";
        input.setText(expression);
    }



    public void plus()
    {
        expression += "+";
        input.setText(expression);
    }


    public void minus()
    {
        expression += "-";
        input.setText(expression);
    }

    public void mul()
    {
        expression += "*";
        input.setText(expression);
    }
    public void back()
    {
        if(!expression.isEmpty())
        {
            expression = expression.substring(0, expression.length() - 1);
            input.setText(expression);
        }

    }


    public void div()
    {
        expression += "/";
        input.setText(expression);
    }

    public void ANS()
    {
        if(!output.getText().isEmpty())
        {
            expression = String.valueOf(ANS);
            input.setText("ANS");
        }
        else
        {
            output.setText("there is no previous answer");
        }

    }

    public void clear()
    {
        expression = "";
        output.setText("");
        input.setText(expression);
    }


    public void equals()
    {
        System.out.println(expression);
        try
        {
            if(deg)
            {
                expression = DegreesToRadiansConverter.convertDegreesToRadians(expression);
            }
            double x  = MathEvaluator.evaluate(expression.replace("π", "pi"));
            output.setText(String.valueOf(x));
            ANS = x;

        }
        catch(ArithmeticException e)
        {
            output.setText("Division by zero is not defined");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

    public void radians()
    {
        deg = false;
    }

    public void degrees()
    {
        deg = true;
    }


    public void expression()
    {
    }

    public void equation()
    {

    }

}
