
package ui.mainui;

import java.net.URL;
import java.util.ResourceBundle;

import blservice.userblservice.UserBLService;
import businesslogic.userbl.UserBLServiceImpl;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * FXML Controller class
 */
public class LoginPageController implements Initializable {
	UserBLService userbl = new UserBLServiceImpl();
	
    @FXML
    RadioButton theuser;
    @FXML
    RadioButton theadministeror;
    @FXML
    TextField user;
    @FXML
    PasswordField password;
    @FXML
    Label message;
    
    @FXML
    private void forgetPassword(ActionEvent event) {
    	
    }

    @FXML
    private void loginFired(ActionEvent event) {
        //final String s = server.getText();
    	final boolean isUser = theuser.isSelected();
    	final boolean isAdministeror = theadministeror.isSelected();
        final String userid = user.getText();
        final String p = password.getText();
        showMessage("请稍后...");

        new BackgroundRunner() {
            String prompt;
            boolean isError;
            boolean ok = false;

            @Override
            public void background() throws Exception {
            	if(userbl.login(isUser, isAdministeror, userid, p)){
            		ok = true;
            	}
            }

            @Override
            public void foreground() throws Exception {
                if (isError) {
                    showErrorMessage(prompt);
                } else {
                    showMessage(prompt);
                }
            }

            @Override
            public void handleException(Exception e) throws Exception {
                showErrorMessage(e.getLocalizedMessage());
                e.printStackTrace();
            }

            @Override
            public void finish() throws Exception {
                if (ok) {
                    showMessage("成功登陆");
                    SalesAndReceiveMain.getInstance().enterMainScene(userid);
                }
                else {
                	showErrorMessage("输入错误，请重试");
                }
            }
        }.run();
    }

    private void showMessage(String msg) {
        System.out.println("[Message]: " + msg);
        message.setTextFill(Color.BLACK);
        message.setText(msg);
        Timeline tl = new Timeline(new KeyFrame(Duration.seconds(0.3), new KeyValue(message.opacityProperty(), 1), new KeyValue(message.translateZProperty(), 10)),
                new KeyFrame(Duration.seconds(3.0), new KeyValue(message.opacityProperty(), 0), new KeyValue(message.translateZProperty(), 0)));
        tl.play();
    }

    private void showErrorMessage(String msg) {
        System.err.println("[Error]: " + msg);
        message.setTextFill(Color.RED);
        message.setText(msg);
        Timeline tl = new Timeline(new KeyFrame(Duration.seconds(0.3), new KeyValue(message.opacityProperty(), 1), new KeyValue(message.translateZProperty(), 10)),
                new KeyFrame(Duration.seconds(3.0), new KeyValue(message.opacityProperty(), 0), new KeyValue(message.translateZProperty(), 0)));
        tl.play();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub	
	}
}
