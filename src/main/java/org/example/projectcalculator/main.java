package org.example.projectcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.operator.Operator;

class MathEvaluator {
    public static double evaluate(String exp) throws Exception
    {
        Operator factorial = new Operator("!", 1, true, Operator.PRECEDENCE_POWER + 1) {
            @Override
            public double apply(double... args) {
                int n = (int) args[0];
                if (n < 0) throw new IllegalArgumentException("Factorial of negative numbers is undefined.");
                return factorial(n);
            }

            private double factorial(int n) {
                double result = 1;
                for (int i = 2; i <= n; i++) result *= i;
                return result;
            }
        };
        Expression expression = new ExpressionBuilder(exp).operator(factorial)
                .build();

        double result = expression.evaluate();
        return result;
    }
}


public class main extends Application
{
    @Override
    public void start(Stage stage) throws IOException {
        Parent root;
        FXMLLoader fx = new FXMLLoader(getClass().getResource("scene1.fxml"));
        root = fx.load();
        Scene scene = new Scene(root);
        String css = this.getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String ...args)
    {
        launch(args);
    }

}
