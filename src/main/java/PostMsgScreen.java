import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PostMsgScreen {

    private AndroidDriver androidDriver;

    public PostMsgScreen(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    private String postMsgFieldElement = "status_text";
    private String postButtonElement = "action_post";

    public String postMessage(String messageToPost){

        MobileElement postMessageField = (MobileElement) androidDriver.findElement(By.id(postMsgFieldElement));
        postMessageField.click();
        postMessageField.clear();
        postMessageField.sendKeys(messageToPost);
        return messageToPost;

    }

    //click post button

    public void clickPostButton(){

        MobileElement postButton = (MobileElement) androidDriver.findElement(By.id(postButtonElement));
        postButton.click();

    }

}
