import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent; 
import javafx.stage.WindowEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.*;

public class Main
{
    private static ListView<Address> AddressListView;
    private static ArrayList<Address> uniArrList = new ArrayList<Address>();
    private static Address currentlySelectedAddress = null;
    private static TextField txtFieldAddress1;
    private static TextField txtFieldAddress2;
    private static TextField txtFieldPostcode;
    private static TextField txtFieldCountry;
    private static TextField txtFieldPhone;
    public static void main(String args[]){

        launchFX();
    } 

    public static void launchFX(){
        new JFXPanel();
        Platform.runLater(()-> initialiseGUI());

    }

    private static void initialiseGUI(){
        Stage stage = new Stage();
        stage.setTitle("Address Book ");
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.setOnCloseRequest((WindowEvent we) -> terminate()); //this call the function terminate when the X is press to close the GUI
        stage.show();// This presents the GUI

        AddressListView = new ListView<Address>();
        AddressListView.setLayoutX(700);
        AddressListView.setLayoutY(50);
        AddressListView.setOnMouseClicked((MouseEvent me) -> {
                currentlySelectedAddress = AddressListView.getSelectionModel().getSelectedItem();
            });
        rootPane.getChildren().add(AddressListView);
        updateListView();

        txtFieldAddress1 = new TextField(); 
        txtFieldAddress1.setLayoutX(400);
        txtFieldAddress1.setLayoutY(200);
        txtFieldAddress1.setPrefWidth(100);
        txtFieldAddress1.setPromptText("Name");
        rootPane.getChildren().add(txtFieldAddress1);

         txtFieldAddress2 = new TextField(); 
        txtFieldAddress2.setLayoutX(400);
        txtFieldAddress2.setLayoutY(300);
        txtFieldAddress2.setPrefWidth(100);
        txtFieldAddress2.setPromptText("Address 2");
        rootPane.getChildren().add(txtFieldAddress2);
        
        txtFieldPhone = new TextField(); 
        txtFieldPhone.setLayoutX(400);
        txtFieldPhone.setLayoutY(350);
        txtFieldPhone.setPrefWidth(100);
        txtFieldPhone.setPromptText("Phone Number");
        rootPane.getChildren().add(txtFieldPhone);

        txtFieldPostcode = new TextField(); 
        txtFieldPostcode.setLayoutX(400);
        txtFieldPostcode.setLayoutY(400);
        txtFieldPostcode.setPrefWidth(100);
        txtFieldPostcode.setPromptText("Postcode");
        rootPane.getChildren().add(txtFieldPostcode);

        txtFieldAddress1 = new TextField(); 
        txtFieldAddress1.setLayoutX(400);
        txtFieldAddress1.setLayoutY(250);
        txtFieldAddress1.setPrefWidth(100);
        txtFieldAddress1.setPromptText("Address 1");
        rootPane.getChildren().add(txtFieldAddress1);
        

        Button Add = new Button();
        Add.setText("Add item");
        Add.setLayoutX(300);
        Add.setLayoutY(265);
        Add.setOnAction((ActionEvent ae) -> addnewItem());
        rootPane.getChildren().add(Add);

        Button delete = new Button();
        delete.setText("delete item");
        delete.setLayoutX(300);
        delete.setLayoutY(230);
        delete.setOnAction((ActionEvent ae) -> deleteItem());
        rootPane.getChildren().add(delete);

        Label Title = new Label("Address Details");
        Title.setLayoutX(400);
        Title.setLayoutY(220);
        rootPane.getChildren().add(Title);

    }

    private static void addnewItem(){
        String Address1 = txtFieldAddress1.getText();
        String Address2 = txtFieldAddress2.getText();
        String Country = txtFieldCountry.getText();
        String Town = txtFieldTown.getText();
        String Postcode = txtFieldPostcode.getText();
        AddressArrList.add(new Address(Address1, Address2, Postcode,Town,Country));
        AddressListView.getItems().clear();

        for(Address Address : AddressArrList){
            AddressListView.getItems().add(Address); 
        }
    }

    private static void terminate()
    {
        System.out.println("bye bye!");
        System.exit(0);
    }

    private static void updateListView(){
        AddressListView.getItems().clear();

        for(Address Address : AddressArrList){//for every university object in uniArraylist
            AddressListView.getItems().add(Address); // put each object into the list view
        }
    }

    private static void deleteItem() {
        AddressArrList.remove(currentlySelectedAddress);
        updateListView();

    }
}
