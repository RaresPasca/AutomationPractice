import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MySetup {

    public AndroidDriver androidDriver;

    @Before
    public void setUp() throws MalformedURLException {


        System.out.println("Starting the Android Driver session in setUp method");
        URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub/");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PLATFORM, "Android");
        capabilities.setCapability(MobileCapabilityType.UDID, "192.168.88.101:5555");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "EmulatorS7");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, "false");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "600");

        //this path is Relative to the project directory path: src/main/resources/yamba-debug.apk
        //in order to use this copy paste the yamba-debug.apk in src/main/resources/
        //otherwise, copy paste here the full path from File Explorer to the yamba-debug.apk, including the name of the file itself yamba-debug.apk
        String appPath = "C:\\Users\\rapasca\\Desktop\\training-mobile-appium-desktop-master\\apps\\yamba-debug.apk";
        capabilities.setCapability(MobileCapabilityType.APP, appPath);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.android.yamba");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.example.android.yamba.MainActivity");

        androidDriver = new AndroidDriver(serverUrl, capabilities);
        System.out.println("Android Driver session started successfully in setUp method");
    }

    @After
    public void tearDown() {
        System.out.println("Trying to close Android Driver session in tearDown method");
        //Closes the session
        androidDriver.quit();
        System.out.println("Android Driver session closed successfully in tearDown method");
    }

}
