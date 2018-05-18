import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SettingsScreen {

    private AndroidDriver androidDriver;

    public SettingsScreen(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    //back button
    private String backButtonID = "Navigate up";

    //username field
    private String usernameOrPasswordLabelId = "title";
    int usernameLabelElementIndex = 0;

    //username field from pop-up
    private String usernamePopupId = "edit";

    //ok button from username pop-up
    private String okButtonID = "button1";

    //

    //back button displayed
    public boolean isBackButtonDisplayed() {

        MobileElement backButton = (MobileElement) androidDriver.findElementByAccessibilityId(backButtonID);
        boolean buttonDisplayed = backButton.isDisplayed();
        return buttonDisplayed;

    }

    public void tapUsername() {

        MobileElement usernameLabelElement = (MobileElement) androidDriver.findElementsById(usernameOrPasswordLabelId).get(usernameLabelElementIndex);
        usernameLabelElement.click();

    }

    public String retriveFromUsername() {

        MobileElement usernameTextElement = (MobileElement) androidDriver.findElementById(usernamePopupId);
        String usernameText = usernameTextElement.getText();
        return usernameText;

    }


    public void enterUsername(String usernameText) {

        MobileElement usernameTextElement = (MobileElement) androidDriver.findElementById(usernamePopupId);
        usernameTextElement.sendKeys(usernameText);

    }

    public void clickOkFromUsername() {

        MobileElement okButton = (MobileElement) androidDriver.findElement(By.id(okButtonID));
        okButton.click();

    }



}
