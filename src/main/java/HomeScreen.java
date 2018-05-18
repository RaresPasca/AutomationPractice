import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomeScreen {

    private AndroidDriver androidDriver;

    //more options
    private String moreOptionsAccessibilityId = "More options";

    //status update button
    private String statusUpdateId = "action_post";

    //settings button
    private String settingsButtonXpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView";

    /**
     * The driver object which will be used for identification needs to be sent to this
     * page object class
     *
     * @param androidDriver
     */
    public HomeScreen(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /* metodele care exprima actiune
        avem nevoie doar de click
    */
    public void tapMoreOptions() {
        MobileElement moreOptionsElement = (MobileElement) androidDriver.findElementByAccessibilityId(moreOptionsAccessibilityId);
        moreOptionsElement.click();
    }

    public SettingsScreen tapSettings() {
        MobileElement settingsButtonElement = (MobileElement) androidDriver.findElement(By.xpath(settingsButtonXpath));
        settingsButtonElement.click();
        return new SettingsScreen(androidDriver);
    }

    public void tapUpdateStatus() {
        MobileElement statusUpdateHome = (MobileElement) androidDriver.findElements(By.id(statusUpdateId));
        statusUpdateHome.click();
    }
}
