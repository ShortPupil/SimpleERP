package ui.mainui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import rmi.ClientLink;
import ui.payandreceiveui.MainPageController;

public class StockMain extends Application
{
	private static StockMain instance;
    static AnchorPane indexPage,mainPage;
    private static AnchorPane customerPanel;
	private static AnchorPane classPanel;
	private static AnchorPane coursePanel;
	private static AnchorPane teacherPanel;
	private static AnchorPane takeCoursePanel;
    
    private Stage stage;
    
    public static StockMain getInstance(){
        return instance;
    }
    
    public static void main(String[] args) {
    	ClientLink c = new ClientLink();
        Application.launch(StockMain.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        instance = this;
        this.stage = stage;
        indexPage = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        mainPage = FXMLLoader.load(getClass().getResource("/ui/stockui/MainPage.fxml"));
        //setTeacherPanel(FXMLLoader.load(getClass().getResource("/ui/stockui/TeacherPanel.fxml")));
        setCustomerPanel(FXMLLoader.load(getClass().getResource("/ui/stockui/CustomerPanel.fxml")));
        //setClassPanel(FXMLLoader.load(getClass().getResource("/ui/stockui/ClassPanel.fxml")));
        //setCoursePanel(FXMLLoader.load(getClass().getResource("/ui/stockui/CoursePanel.fxml")));
        //setTakeCoursePanel(FXMLLoader.load(getClass().getResource("/ui/stockui/TakeCoursePanel.fxml")));
        
        stage.setTitle("进销存系统 V1.0");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
        stage.setMinHeight(520);
        stage.setMinWidth(650);
        stage.setScene(new Scene(indexPage));
        stage.show();
    }
    
    public void enterMainScene(String userid){
        this.stage.setScene(new Scene(mainPage));
        MainPageController.getInstance().showAnimation();
        MainPageController.getInstance().initPanel(userid);
    }

	public static AnchorPane getCustomerPanel() {
		return customerPanel;
	}

	public static void setCustomerPanel(AnchorPane customerPanel) {
		StockMain.customerPanel = customerPanel;
	}

	public static AnchorPane getClassPanel() {
		return classPanel;
	}

	public static void setClassPanel(AnchorPane classPanel) {
		StockMain.classPanel = classPanel;
	}

	public static AnchorPane getCoursePanel() {
		return coursePanel;
	}

	public static void setCoursePanel(AnchorPane coursePanel) {
		StockMain.coursePanel = coursePanel;
	}

	public static AnchorPane getTeacherPanel() {
		return teacherPanel;
	}

	public static void setTeacherPanel(AnchorPane teacherPanel) {
		StockMain.teacherPanel = teacherPanel;
	}

	public static AnchorPane getTakeCoursePanel() {
		return takeCoursePanel;
	}

	public static void setTakeCoursePanel(AnchorPane takeCoursePanel) {
		StockMain.takeCoursePanel = takeCoursePanel;
	}
}
