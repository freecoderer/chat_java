package application;

import java.io.IOException;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("view/login.fxml")); // getResource => get the file
		root.getStylesheets().add(getClass().getResource("view/application.css").toExternalForm());
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("Gamsung Talk");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	}

