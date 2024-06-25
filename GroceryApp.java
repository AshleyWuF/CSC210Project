// Team members: Ashley Wu
// Course number: CSC 210
// Course section: 0900
// Description: This is the GroceryApp FX that displays the login and
// menu windows using the GroceryStore class.
// Date: 06/10/2024
// Version: Last version (second version)

package org.example.chapter12;

import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.geometry.HPos;


public class GroceryApp extends Application {
    // Fields
    private TextField userTextField;
    private PasswordField passwordField;
    private Label messageLabel;
    private TextField productNumTextField;
    private TextField quantityTextField;
    private Label resultLabel;
    private Stage primaryStage;

    public static void main(String[] args) {
        // Launch the application.
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // assign primaryStage to class field
        this.primaryStage = primaryStage;

        // Create a Labels to display username and password.
        Label promptLabel1 = new Label("Username: ");
        Label promptLabel2 = new Label("Password: ");

        // Changing and styling font
        promptLabel1.setStyle("-fx-text-fill: blue; -fx-font-family: 'Georgia'; -fx-font-weight: bold; -fx-font-size: 20px;");
        promptLabel2.setStyle("-fx-text-fill: blue; -fx-font-family: 'Georgia'; -fx-font-weight: bold; -fx-font-size: 20px;");

        // Create a TextFields for input of username and password.
        userTextField = new TextField();
        passwordField = new PasswordField();

        // Style the TextField
        userTextField.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 16; -fx-text-fill: black; " +
                "-fx-background-color: lightgrey; -fx-border-color: blue; -fx-border-radius: 5; " +
                "-fx-alignment: center;");
        passwordField.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 16; -fx-text-fill: black; " +
                "-fx-background-color: lightgrey; -fx-border-color: blue; -fx-border-radius: 5; " +
                "-fx-alignment: center;");

        // Create a Button to perform the Login.
        Button LoginButton = new Button("Login");

        // Set button style using setStyle method
        LoginButton.setStyle("-fx-font-family: 'Georgia'; -fx-background-color: green; -fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");


        // Register the event handler.
        LoginButton.setOnAction(new LoginButtonHandler());

        // Create an empty Label to display the message.
        messageLabel = new Label();
        // Style the messageLabel
        messageLabel.setStyle("-fx-text-fill: red; -fx-font-family: 'Georgia'; -fx-font-size: 14px; -fx-font-weight: bold;");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(javafx.geometry.Pos.CENTER); // for center
        gridPane.setHgap(10); // Horizontal gap between cells
        gridPane.setVgap(10); // Vertical gap between cells
        gridPane.add(promptLabel1, 0, 0);
        gridPane.add(promptLabel2, 0, 1);
        gridPane.add(userTextField, 1, 0);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(LoginButton, 1, 2);
        gridPane.add(messageLabel, 1, 3);

        // Create a Scene.
        Scene scene = new Scene(gridPane, 400, 300);

        // Add the Scene to the Stage.
        primaryStage.setScene(scene);

        // Set the stage title.
        primaryStage.setTitle("Login");

        // Set the stage width and height.
        primaryStage.setWidth(400);
        primaryStage.setHeight(300);

        // Show the window.
        primaryStage.show();
    }

    // Event handler class for LoginButton
    class LoginButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

            // call Login method
            login();
        }
    }

    // method handles Login
    private void login() {

        // setting userTextField
        String user = userTextField.getText();
        // setting passwordTextField
        String password = passwordField.getText();

        // if user and password are the same as the ones in the GroceryStore class
        if (user.equals(GroceryStore.getUsername()) && password.equals(GroceryStore.getPassword())) {
            messageLabel.setText("Login successful"); // will display this if user login

            // call the menu method
            menu();

        } else {
            messageLabel.setText("Login failed. Please try again."); // else display try again
        }
    }

    // method handles Menu
    private void menu() {

        // Create a Labels to display products and their cost, and number.
        Label prompt1 = new Label("Products");
        Label prompt2 = new Label("Cost");
        Label num1 = new Label("1");
        Label num2 = new Label("2");
        Label num3 = new Label("3");
        Label num4 = new Label("4");
        Label product1 = new Label("Tuna");
        Label product2 = new Label("Milk");
        Label product3 = new Label("Bread");
        Label product4 = new Label("Juice");
        Label cost1 = new Label("2.60");
        Label cost2 = new Label("10.00");
        Label cost3 = new Label("5.80");
        Label cost4 = new Label("3.40");
        Label prompt3 = new Label("Enter the number for the product ");
        Label prompt4 = new Label("Enter the quantity for the product ");

        // Changing and styling font
        prompt1.setStyle("-fx-text-fill: blue; -fx-font-family: 'Impact'; -fx-font-weight: bold; -fx-font-size: 30px;");
        prompt2.setStyle("-fx-text-fill: blue; -fx-font-family: 'Impact'; -fx-font-weight: bold; -fx-font-size: 30px;");
        num1.setStyle("-fx-text-fill: orange; -fx-font-family: 'Georgia'; -fx-font-weight: bold; -fx-font-size: 20px;");
        num2.setStyle("-fx-text-fill: orange; -fx-font-family: 'Georgia'; -fx-font-weight: bold; -fx-font-size: 20px;");
        num3.setStyle("-fx-text-fill: orange; -fx-font-family: 'Georgia'; -fx-font-weight: bold; -fx-font-size: 20px;");
        num4.setStyle("-fx-text-fill: orange; -fx-font-family: 'Georgia'; -fx-font-weight: bold; -fx-font-size: 20px;");
        product1.setStyle("-fx-text-fill: black; -fx-font-family: 'Georgia'; -fx-font-weight: bold; -fx-font-size: 20px;");
        product2.setStyle("-fx-text-fill: black; -fx-font-family: 'Georgia'; -fx-font-weight: bold; -fx-font-size: 20px;");
        product3.setStyle("-fx-text-fill: black; -fx-font-family: 'Georgia'; -fx-font-weight: bold; -fx-font-size: 20px;");
        product4.setStyle("-fx-text-fill: black; -fx-font-family: 'Georgia'; -fx-font-weight: bold; -fx-font-size: 20px;");
        cost1.setStyle("-fx-text-fill: black; -fx-font-family: 'Georgia'; -fx-font-weight: bold; -fx-font-size: 20px;");
        cost2.setStyle("-fx-text-fill: black; -fx-font-family: 'Georgia'; -fx-font-weight: bold; -fx-font-size: 20px;");
        cost3.setStyle("-fx-text-fill: black; -fx-font-family: 'Georgia'; -fx-font-weight: bold; -fx-font-size: 20px;");
        cost4.setStyle("-fx-text-fill: black; -fx-font-family: 'Georgia'; -fx-font-weight: bold; -fx-font-size: 20px;");
        prompt3.setStyle("-fx-text-fill: gray; -fx-font-family: 'Georgia'; -fx-font-weight: bold; -fx-font-size: 15px;");
        prompt4.setStyle("-fx-text-fill: gray; -fx-font-family: 'Georgia'; -fx-font-weight: bold; -fx-font-size: 15px;");


        // Create a TextFields for input of product number and quantity.
        productNumTextField = new TextField();
        quantityTextField = new TextField();

        // Style the TextField
        productNumTextField.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 20; -fx-text-fill: black; " +
                "-fx-background-color: lightgrey; -fx-border-color: blue; -fx-border-radius: 5;" +
                "-fx-alignment: center;");
        quantityTextField.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 20; -fx-text-fill: black; " +
                "-fx-background-color: lightgrey; -fx-border-color: blue; -fx-border-radius: 5; " +
                "-fx-alignment: center;");

        // Create a Button to perform the Calculation.
        Button calculateButton = new Button("Calculate");

        // Set button style using setStyle method
        calculateButton.setStyle("-fx-font-family: 'Georgia'; -fx-background-color: green; -fx-text-fill: white; -fx-font-size: 20px; -fx-font-weight: bold;");

        // Register the event handler.
        calculateButton.setOnAction(new calcButtonHandler());

        // Create an empty Label to display the result of the calculation.
        resultLabel = new Label();

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(javafx.geometry.Pos.CENTER); // for center
        gridPane.setHgap(10); // Horizontal gap between cells
        gridPane.setVgap(10); // Vertical gap between cells
        gridPane.add(prompt1, 1, 0);
        gridPane.add(prompt2, 2, 0);
        gridPane.add(num1, 0, 1);
        gridPane.add(num2, 0, 2);
        gridPane.add(num3, 0, 3);
        gridPane.add(num4, 0, 4);
        gridPane.add(product1, 1, 1);
        gridPane.add(product2, 1, 2);
        gridPane.add(product3, 1, 3);
        gridPane.add(product4, 1, 4);
        gridPane.add(cost1, 2, 1);
        gridPane.add(cost2, 2, 2);
        gridPane.add(cost3, 2, 3);
        gridPane.add(cost4, 2, 4);

        // Adding spacer Label to create some space
        Label spacer = new Label();
        gridPane.add(spacer, 0, 5);

        gridPane.add(prompt3, 0, 6);
        gridPane.add(prompt4, 0, 7);
        gridPane.add(productNumTextField, 1, 6);
        gridPane.add(quantityTextField, 1, 7);
        gridPane.add(calculateButton, 1, 8);
        gridPane.add(resultLabel, 1, 9);

        // Align num1, num2, num3, and num4 to the right within their cells
        GridPane.setHalignment(num1, HPos.RIGHT);
        GridPane.setHalignment(num2, HPos.RIGHT);
        GridPane.setHalignment(num3, HPos.RIGHT);
        GridPane.setHalignment(num4, HPos.RIGHT);

        // Create a Scene.
        Scene scene2 = new Scene(gridPane, 800, 600);

        // Add the Scene to the Stage.
        primaryStage.setScene(scene2);

        // Set the stage title.
        primaryStage.setTitle("Menu");

        // Set the stage width and height.
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);


        // Show the window.
        primaryStage.show();
    }

    // Event handler class for calculateButton
    class calcButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

            // try exception from Ch.11 -- handles exceptions for productNum and quantity
            try // try block statement
            {
                // Accept the product number and the quantity.
                double productNum = Double.parseDouble(productNumTextField.getText());
                double quantity = Double.parseDouble(quantityTextField.getText());

                // if statement that display invalid if prod. number is not between 1 or 4
                if (productNum < 1 || productNum > 4) {
                    resultLabel.setText("Invalid product number. \nPlease try again.");
                    resultLabel.setStyle("-fx-text-fill: red; -fx-font-family: 'Georgia'; -fx-font-size: 16px; -fx-font-weight: bold;");
                    return;
                }
                // if statement that display invalid if quantity is zero or negative values
                else if (quantity <= 0) {
                    resultLabel.setText("Invalid quantity number. \nPlease try again.");
                    resultLabel.setStyle("-fx-text-fill: red; -fx-font-family: 'Georgia'; -fx-font-size: 16px; -fx-font-weight: bold;");
                    return;
                }

                // Create variable and if condition for each product number
                String item = "";
                if (productNum == 1) {
                    item = "Tuna";
                } else if (productNum == 2) {
                    item = "Milk";
                } else if (productNum == 3) {
                    item = "Bread";
                } else if (productNum == 4) {
                    item = "Juice";
                }

                // Calculate cost, taxes, and total calling the GroceryStore class.
                double cost = GroceryStore.calCost(item) * quantity;
                double taxes = GroceryStore.calTaxes(item) * quantity;
                double total = GroceryStore.calTotal(item) * quantity;

                // Display the results with two decimals.
                resultLabel.setText(String.format("\nCost before taxes: %.2f\nTaxes: %.2f\nTotal " +
                                "Cost: %.2f", cost, taxes, total));
                resultLabel.setStyle("-fx-text-fill: green; -fx-font-family: 'Georgia'; -fx-font-size: 16px; -fx-font-weight: bold;");
            }

            // if the user input a word or character will display invalid
            catch (NumberFormatException e) // catch block statement
            {
                resultLabel.setText("Invalid input. \nPlease try again with numbers.");
                resultLabel.setStyle("-fx-text-fill: red; -fx-font-family: 'Georgia'; -fx-font-size: 16px; -fx-font-weight: bold;");
            }
        }
    }
}