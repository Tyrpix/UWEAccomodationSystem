package UWE;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.collections.transformation.FilteredList;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainViewController implements Initializable {

    ObservableList<ReadableData> data = FXCollections.observableArrayList();

    private int user;

    /**
     * Initialise TableView
     */
    @FXML
    private TableView<ReadableData> MainView;
    @FXML
    private TableColumn<ReadableData, String> hallNumberCol;
    @FXML
    private TableColumn<ReadableData, String> roomNumberCol;
    @FXML
    private TableColumn<ReadableData, String> forenameCol;
    @FXML
    private TableColumn<ReadableData, String> surnameCol;
    @FXML
    private TableColumn<ReadableData, String> studentNumCol;
    @FXML
    private TableColumn<ReadableData, String> leaseNumberCol;
    @FXML
    private TableColumn<ReadableData, String> cleaningStatusCol;
    @FXML
    private TableColumn<ReadableData, String> roomStatusCol;
    @FXML
    private ChoiceBox cleaningStatusBox;
    @FXML
    private TextField roomStatusBox;
    @FXML
    private TextField searchBox;
    @FXML
    private TextField hallNumberBox;
    @FXML
    private TextField roomNumberBox;
    @FXML
    private TextField leaseNumberBox;
    @FXML
    private TextField forenameBox;
    @FXML
    private TextField surnameBox;
    @FXML
    private TextField studentIdBox;
    @FXML
    private Button deleteButton;


    /**
     * Method: logoutEvent
     * Purpose: Switches scene to login scene
     * @param event
     * @throws IOException
     */
    public void logoutEvent(ActionEvent event) throws IOException {
        Parent loginScreenParent = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        Scene loginScreen = new Scene(loginScreenParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(loginScreen);
        window.show();
    }

    /**
     * Method: initialize
     * Purpose: Initializes the controller class
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Set the columns in the table
        hallNumberCol.setCellValueFactory(
                new PropertyValueFactory<ReadableData, String>("hallNumber"));

        roomNumberCol.setCellValueFactory(
                new PropertyValueFactory<ReadableData, String>("roomNumber"));

        studentNumCol.setCellValueFactory(
                new PropertyValueFactory<ReadableData, String>("studentNumber"));

        forenameCol.setCellValueFactory(
                new PropertyValueFactory<ReadableData, String>("forename"));

        surnameCol.setCellValueFactory(
                new PropertyValueFactory<ReadableData, String>("surname"));

        leaseNumberCol.setCellValueFactory(
                new PropertyValueFactory<ReadableData, String>("leaseNumber"));

        cleaningStatusCol.setCellValueFactory(
                new PropertyValueFactory<ReadableData, String>("cleaningStatus"));

        roomStatusCol.setCellValueFactory(
                new PropertyValueFactory<ReadableData, String>("roomStatus"));

        MainView.setItems(getData());

        cleaningStatusBox.getItems().addAll("Clean", "Dirty", "Offline");

       rowSelection();

    }

    /**
     * Method: rowSelection
     * Purpose: Gets selected row when clicked
     * Returns N/A
     */
    private void rowSelection(){
        MainView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 1) {
                getRow();
            }
        });
    }

    /**
     * Method: fieldsNotCompleted
     * Purpose: Displays message that tells manager all fields must be complete to create a lease
     * Returns: N/A
     */
    private void fieldsNotCompleted() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("All required fields must be added!");
        alert.show();
    }

    /**
     * Method: showOffLine
     * Purpose: Displays message when manager creates a lease for an offline room
     * Returns: N/A
     */
    private void showOffline() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Warning: Creating lease on offline room");
        alert.show();
    }

    /**
     * Method: roomIsOccupied
     * Purpose: Displays message when trying to make an occupied room offline, requires null lease first
     * Returns: N/A
     */
    private void roomIsOccupied() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("cleaning status cannot change to offline if room is occupied");
        alert.show();
    }

    /**
     * Method: setUser
     * Purpose: Disables features for wardens on login, only shows wardens respective halls in table view
     * @param user
     */
    public void setUser(int user) {
        System.out.println("User: " + user);
        // If warden
        if (user > 0) {
            surnameBox.setDisable(true);
            forenameBox.setDisable(true);
            studentIdBox.setDisable(true);
            leaseNumberBox.setDisable(true);
            data.removeIf(obj -> !obj.getHallNumber().contains(String.valueOf(user)));
            deleteButton.setDisable(true);
        }

        this.user = user;
    }

    /**
     * Method: isManager
     * Purpose: If manager logs in set user value
     * @return boolean
     */
    private boolean isManager() {
        return (user == 0);
    }

    /**
     * Method: getRow
     * Purpose: Gets the selected rows data from the table in MainView and displays text in text fields
     * Returns: N/A
     */
    public void getRow() {
        // Check the table's selected item and get selected item
        if (MainView.getSelectionModel().getSelectedItem() != null) {
            ReadableData selectedData = MainView.getSelectionModel().getSelectedItem();
            hallNumberBox.setText(selectedData.getHallNumber());
            roomNumberBox.setText((selectedData.getRoomNumber()));
            studentIdBox.setText((selectedData.getStudentNumber()));
            forenameBox.setText((selectedData.getForename()));
            surnameBox.setText((selectedData.getSurname()));
            leaseNumberBox.setText((selectedData.getLeaseNumber()));
            roomStatusBox.setText((selectedData.getRoomStatus()));

            // Select just choice box
            SingleSelectionModel ssm = cleaningStatusBox.getSelectionModel();
            ssm.select(selectedData.getCleaningStatus());
            cleaningStatusBox.setSelectionModel(ssm);
        }
    }

    /**
     * Method: delete
     * Purpose: Sets selected lease object to null, removes data from table in MainView
     * Returns: N/A
     */
    @FXML
    private void delete() {
        ReadableData selectedData = MainView.getSelectionModel().getSelectedItem();
        Room room = selectedData.getRoom();
        room.setLease(null);

        selectedData.setRoomStatus(room.getRoomStatus());
        selectedData.setStudentNumber("");
        selectedData.setForename("");
        selectedData.setSurname("");
        selectedData.setLeaseNumber("");
        selectedData.setCleaningStatus("Dirty");

        getRow();

    }

    /**
     * Method: update
     * Purpose: Creates lease by creating a student, checks if user is manager so all text fields are completed when creating a lease
     * Returns: N/A
     */
    @FXML
    private void update() {
        ReadableData selectedData = MainView.getSelectionModel().getSelectedItem();
        Room room = selectedData.getRoom();

        // Cannot change status to offline whilst there is a lease
        if (room.isOccupied() && cleaningStatusBox.getSelectionModel().getSelectedItem().equals("Offline")) {
            roomIsOccupied();
            return;
        }

        // If manager ensure all entries have been filled in
        if (isManager()) {
            // assert required info are given
            if (studentIdBox.getText().length() < 1 ||
                    forenameBox.getText().length() < 1 ||
                    surnameBox.getText().length() < 1 ||
                    leaseNumberBox.getText().length() < 1) {
                if (!cleaningStatusBox.getSelectionModel().getSelectedItem().equals("Offline")) {
                    fieldsNotCompleted();
                    return;
                }
            }
        }

        // Update the row in the table with the new values
        selectedData.setStudentNumber(studentIdBox.getText());
        selectedData.setForename(forenameBox.getText());
        selectedData.setSurname(surnameBox.getText());
        selectedData.setLeaseNumber(leaseNumberBox.getText());
        selectedData.setCleaningStatus(cleaningStatusBox.getSelectionModel().getSelectedItem().toString());

        Student student;
        Lease lease = selectedData.getLease();

        // If we are in edit mode, there is already a lease on the room
        // Otherwise if creating a new lease then we require a student instance
        if (lease == null) {
            student = new Student(Integer.valueOf(studentIdBox.getText()),
                    forenameBox.getText(),
                    surnameBox.getText());
        } else {
            // Retrieve the student from the existing lease
            student = lease.getStudent();
        }

        // Either way, set the student id, forename and surname
        student.setStudentID(Integer.valueOf(studentIdBox.getText()));
        student.setForename(forenameBox.getText());
        student.setSurname(surnameBox.getText());

        // If new lease, create one
        if (lease == null) {
            lease = new Lease(student);
            room.setLease(lease);
            if (cleaningStatusBox.getSelectionModel().getSelectedItem().equals("Offline"))
                showOffline();
            return;
        }

        room.setCleaningStatus(cleaningStatusBox.getSelectionModel().getSelectedItem().toString());
        lease.setLeaseNumber(Integer.valueOf(leaseNumberBox.getText()));
        roomStatusBox.setText(room.getRoomStatus());
        selectedData.setRoomStatus(room.getRoomStatus());
    }

    /** Method: searchRecord
     * Purpose: Searches MainView table my student name, sets sorted list to table on key typed event
     * @param event
     */
    @FXML
    private void searchRecord(KeyEvent event) {
        FilteredList<ReadableData> filter = new FilteredList<>(data, e -> true);
        searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(student -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String typedText = newValue.toLowerCase();
                if (student.getSurname().toLowerCase().indexOf(typedText) != -1) {

                    return true;
                }
                if (student.getForename().toLowerCase().indexOf(typedText) != -1) {

                    return true;
                }
                return false;
            });
            SortedList<ReadableData> sortedList = new SortedList<>(filter);
            sortedList.comparatorProperty().bind(MainView.comparatorProperty());
            MainView.setItems(sortedList);
        });
    }

    /**
     * Method: getData
     * Purpose: Calls singleton design pattern, populates MainView table by iterating through halls and then rooms
     * @return Observable Array List of data
     */
    public ObservableList<ReadableData> getData() {

        // Singleton Method gets single instance of the class
        UWESystem uweAccommodationSystemController = UWESystem.getInstance();

        ArrayList<Hall> halls = uweAccommodationSystemController.getHalls();

        // Iterate through halls and rooms and get data for table
        for (int i = 0; i < halls.size(); i++) {
            Hall currentHall = halls.get(i);
            ArrayList<Room> rooms = currentHall.getRooms();

            for (int j = 0; j < rooms.size(); j++) {
                Room room = rooms.get(j);

                Student student = null;
                String leaseString = "";
                Lease lease = null;

                if (room.isOccupied()) {
                    lease = room.getLease();
                    student = lease.getStudent();
                    leaseString = String.valueOf(lease.getLeaseNumber());
                }

                String studentId = "";
                String studentForename = "";
                String studentSurname = "";

                if (student != null) {
                    studentId = String.valueOf(student.getStudentID());
                    studentForename = String.valueOf(student.getForename());
                    studentSurname = String.valueOf(student.getSurname());
                }

                ReadableData row = new ReadableData(

                        String.valueOf(currentHall.getHallNumber()),
                        String.valueOf(room.getRoomNumber()),
                        studentId,
                        studentForename,
                        studentSurname,
                        leaseString,
                        room.getCleaningStatus(),
                        room.getRoomStatus(),
                        currentHall,
                        room,
                        lease);

                data.add(row);
            }
        }

        return data;
    }
}