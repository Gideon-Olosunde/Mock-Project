import java.io.FileReader;
import java.io.BufferedReader;
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
    private static ArrayList<Address> AddressArrList = new ArrayList<Address>();
    private static Address currentlySelectedAddress = null;
    private static TextField txtFieldAddress1;
    private static TextField txtFieldAddress2;
    private static TextField txtFieldPostcode;
    private static TextField txtFieldCountry;
    private static TextField txtFieldPhone;
    private static TextField txtFieldTown;
    private static TextField txtFieldname;
    private static TextField txtFieldemail;
    private static int listviewsize;
    public static void main(String args[])throws IOException{

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
        AddressListView.setLayoutX(300);
        AddressListView.setLayoutY(50);
        AddressListView.setPrefWidth(700);
        AddressListView.setOnMouseClicked((MouseEvent me) -> {
                currentlySelectedAddress = AddressListView.getSelectionModel().getSelectedItem();
            });
        rootPane.getChildren().add(AddressListView);
        updateListView();

        txtFieldname = new TextField(); 
        txtFieldname.setLayoutX(10);
        txtFieldname.setLayoutY(50);
        txtFieldname.setPrefWidth(100);
        txtFieldname.setPromptText("Name");
        rootPane.getChildren().add(txtFieldname);

        txtFieldAddress1 = new TextField();
        txtFieldAddress1.setLayoutX(10);
        txtFieldAddress1.setLayoutY(100);
        txtFieldAddress1.setPrefWidth(100);
        txtFieldAddress1.setPromptText("Address 1");
        rootPane.getChildren().add(txtFieldAddress1);

        txtFieldAddress2 = new TextField();
        txtFieldAddress2.setLayoutX(10);
        txtFieldAddress2.setLayoutY(250);
        txtFieldAddress2.setPrefWidth(100);
        txtFieldAddress2.setPromptText("Address 2");
        rootPane.getChildren().add(txtFieldAddress2);

        txtFieldPhone = new TextField();
        txtFieldPhone.setLayoutX(10);
        txtFieldPhone.setLayoutY(150);
        txtFieldPhone.setPrefWidth(100);
        txtFieldPhone.setPromptText("Phone Number");
        rootPane.getChildren().add(txtFieldPhone);

        txtFieldPostcode = new TextField(); 
        txtFieldPostcode.setLayoutX(10);
        txtFieldPostcode.setLayoutY(200);
        txtFieldPostcode.setPrefWidth(100);
        txtFieldPostcode.setPromptText("Postcode");
        rootPane.getChildren().add(txtFieldPostcode);

        txtFieldemail = new TextField();
        txtFieldemail.setLayoutX(10);
        txtFieldemail.setLayoutY(250);
        txtFieldemail.setPrefWidth(100);
        txtFieldemail.setPromptText("Email");
        rootPane.getChildren().add(txtFieldemail);

        Button Add = new Button();
        Add.setText("Add item");
        Add.setLayoutX(25);
        Add.setLayoutY(700);
        Add.setOnAction((ActionEvent ae) -> addnewItem());
        rootPane.getChildren().add(Add);

        Button Readfile = new Button();
        Readfile.setText("Read File");
        Readfile.setLayoutX(125);
        Readfile.setLayoutY(700);
        Readfile.setOnAction((ActionEvent ae) -> Readfromfile());
        rootPane.getChildren().add(Readfile);

        Button save = new Button();
        save.setText("Save");
        save.setLayoutX(225);
        save.setLayoutY(700);
        save.setOnAction((ActionEvent ae) -> saveaddress());
        rootPane.getChildren().add(save);

        Button delete = new Button();
        delete.setText("delete item");
        delete.setLayoutX(325);
        delete.setLayoutY(700);
        delete.setOnAction((ActionEvent ae) -> deleteItem());
        rootPane.getChildren().add(delete);

        Label Title = new Label("Address Details");
        rootPane.getChildren().add(Title);

    }

    private static void addnewItem(){
        String Address1 = txtFieldAddress1.getText();
        String Address2 = txtFieldAddress2.getText();
        String Phone = txtFieldPhone.getText();
        String Email = txtFieldemail.getText();
        String name = txtFieldname.getText();
        String Postcode = txtFieldPostcode.getText();
        AddressArrList.add(new Address(name,Address1,Address2,Phone,Postcode,Email));
        AddressListView.getItems().clear();

        for(Address Address : AddressArrList){
            AddressListView.getItems().add(Address);
            listviewsize++;
        }
    }

    private static void terminate()
    {
        System.out.println("bye!");
        System.exit(0);
    }

    private static void Readfromfile(){
        try{
            FileReader fr = new FileReader("U:\\Computing\\Mock Project\\Address.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) !=null){
                String[] values = line.split(",");
                Address addresses = new Address(values[0],values[1],values[2],values[3],values[4],values[5]);
                AddressArrList.add(addresses);
            }
            br.close();
            updateListView();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private static void saveaddress(){
        FileWriter fw = new FileWriter("U:\\Computing\\Mock Project\\Address.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i= 0; i<listviewsize;i++){
            String Selected = AddressListView.getSelectionModel().getSelectedItem(i);
        }
        bw.close();
    }


    private static void updateListView(){
        AddressListView.getItems().clear();

        for(Address Address : AddressArrList){
            AddressListView.getItems().add(Address);
        }
    }

    private static void deleteItem() {
        AddressArrList.remove(currentlySelectedAddress);
        listviewsize--;
        updateListView();

    }
}
