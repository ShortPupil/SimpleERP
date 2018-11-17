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

public class SalesAndReceiveMain extends Application
{
	private static SalesAndReceiveMain instance;
    static AnchorPane indexPage,mainPage;
    private static AnchorPane customerPanel;
	private static AnchorPane classPanel;
	private static AnchorPane coursePanel;
	private static AnchorPane teacherPanel;
	private static AnchorPane takeCoursePanel;
    
    private Stage stage;
    
    public static SalesAndReceiveMain getInstance(){
        return instance;
    }
    
    public static void main(String[] args) {
    	ClientLink c = new ClientLink();
        Application.launch(SalesAndReceiveMain.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        instance = this;
        this.stage = stage;
        indexPage = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        mainPage = FXMLLoader.load(getClass().getResource("/ui/payandreceiveui/MainPage.fxml"));
        //setTeacherPanel(FXMLLoader.load(getClass().getResource("/ui/payandreceiveui/TeacherPanel.fxml")));
        setCustomerPanel(FXMLLoader.load(getClass().getResource("/ui/payandreceiveui/CustomerPanel.fxml")));
        //setClassPanel(FXMLLoader.load(getClass().getResource("/ui/payandreceiveui/ClassPanel.fxml")));
        //setCoursePanel(FXMLLoader.load(getClass().getResource("/ui/payandreceiveui/CoursePanel.fxml")));
        //setTakeCoursePanel(FXMLLoader.load(getClass().getResource("/ui/payandreceiveui/TakeCoursePanel.fxml")));
        
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
		SalesAndReceiveMain.customerPanel = customerPanel;
	}

	public static AnchorPane getClassPanel() {
		return classPanel;
	}

	public static void setClassPanel(AnchorPane classPanel) {
		SalesAndReceiveMain.classPanel = classPanel;
	}

	public static AnchorPane getCoursePanel() {
		return coursePanel;
	}

	public static void setCoursePanel(AnchorPane coursePanel) {
		SalesAndReceiveMain.coursePanel = coursePanel;
	}

	public static AnchorPane getTeacherPanel() {
		return teacherPanel;
	}

	public static void setTeacherPanel(AnchorPane teacherPanel) {
		SalesAndReceiveMain.teacherPanel = teacherPanel;
	}

	public static AnchorPane getTakeCoursePanel() {
		return takeCoursePanel;
	}

	public static void setTakeCoursePanel(AnchorPane takeCoursePanel) {
		SalesAndReceiveMain.takeCoursePanel = takeCoursePanel;
	}
}
