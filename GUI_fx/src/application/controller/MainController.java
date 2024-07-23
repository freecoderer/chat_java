package application.controller;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import client.LoginClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import message.MainClient;


public class MainController implements Initializable {

	@FXML
	private Button btn_login;
	@FXML
	private Button btn_logout;
	@FXML
	private TextField strID;
	@FXML 
	private TextField strPW;
	@FXML
	private Button btn_groupchat;
	@FXML
	private Button btn_chat_1;
	@FXML
	private Button btn_chat_2;
	@FXML
	private Button btn_chat_3;
	@FXML
	private Button btn_chat_4;
	@FXML
	private Button btn_chat_5;
	@FXML
	private Button btn_chat_6;
	@FXML
	private TabPane myTabPane;
	@FXML
	private Tab tab_friend;
	@FXML
	private Tab tab_home;
	@FXML
	private Tab tab_chatlist;
	@FXML
	private AnchorPane anchorpane_chat;
	@FXML
	private Button btn_close;
	/*
	@FXML
	private ImageView btn_friendhome_1;
	@FXML
	private ImageView btn_friendhome_2;
	@FXML
	private ImageView btn_friendhome_3;
	@FXML
	private ImageView btn_friendhome_4;
	@FXML
	private ImageView btn_friendhome_5;
	@FXML
	private ImageView btn_friendhome_6;
	*/
	@FXML
	private Button btn_write;
	
	@FXML
	private Button btnsend; 
	
	@FXML
	private TextField writearea; 
	
	@FXML
	public TextArea textArea; 
	
	
	public static String inputvalueID;
	public static String inputvaluePW;
	public static String Msg;

	int i = 0;

	public void loggedinScreen(ActionEvent event) throws IOException {
		// Stage newStage = new Stage();

		Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/loggedin.fxml")); 
		
		
		
		Scene tableViewScene = new Scene(tableViewParent); // Scene�� ���̾ƿ� �߰�

		// getting the stage info
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		 inputvalueID = strID.getText();
	     inputvaluePW = strPW.getText();  
	     
	     LoginClient loginCli = new LoginClient(inputvalueID, inputvaluePW);
	     
	     if (loginCli.getLoginResult()) {
	    	 window.setScene(tableViewScene);
	    	 window.show();
	    	 Stage login = (Stage) btn_login.getScene().getWindow();
	     }
	     else {
	    	 strID.setText("");
	    	 strPW.setText("");
	     }
		// tab_friend.isSelected();
	}

	@FXML
	public void chatScreen(ActionEvent event) throws IOException {
		
		AnchorPane chat = FXMLLoader.load(getClass().getResource("../view/chatscreen.fxml")); // chatscreen.fxml is loaded
		// Scene tableViewScene = new Scene(tableViewParent); // Scene�� ���̾ƿ� �߰�
		
		// Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		// ArrayList<Integer> tab_num = new ArrayList<Integer>();
		
	
		
		Tab chat_tab = new Tab();
        chat_tab.setText("Friend");
        chat_tab.setContent(chat);
        chat_tab.setClosable(true);
       
        myTabPane.getTabs().add(chat_tab);
        
        i++;        
       		        
		myTabPane.getSelectionModel().select(chat_tab);
		
		i = myTabPane.getSelectionModel().getSelectedIndex();
		
		
		Msg = writearea.getText();
		
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
	}
	
		
	public void logout(ActionEvent event) throws IOException {
		
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
		Scene tableViewScene = new Scene(tableViewParent); // Scene�� ���̾ƿ� �߰�
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(tableViewScene);
		window.show();
		
		Stage chat = (Stage) btn_logout.getScene().getWindow();
		
		
		
	}
	
	public void friendHome(ActionEvent event) throws IOException {
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
