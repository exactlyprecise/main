package seedu.address.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import seedu.address.commons.core.UserType;

public class LoginBox {
    private UserType userType = null;
    private TextField textField1;
    private TextField textField2;
    private TextArea textArea;
    private Stage window;

    public UserType display() {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Login");
        window.setMinWidth(500);
        window.setMinHeight(250);

        textField1 = new TextField();
        textField1.setOnAction(e -> findAccount());
        textField2 = new TextField();
        textField2.setOnAction(e -> findAccount());

        textArea = new TextArea();

        VBox layout = new VBox();
        layout.getChildren().addAll(textField1, textField2, textArea);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return userType;

    }

    private void findAccount() {
        if (textField1.getText().equals("General") && textField2.getText().equals("General")) {
            userType = UserType.GENERAL;
            window.close();
        } else if (textField1.getText().equals("Admin") && textField2.getText().equals("Admin")) {
            userType = UserType.ADMIN;
            window.close();
        } else {
            textArea.setText("User not found!");
        }
    }

}

