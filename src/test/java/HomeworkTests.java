import org.junit.Assert;

import org.junit.Test;


public class HomeworkTests extends MySetup {


    //primul test care face click pe more options , settings si apoi verifica daca ajungem pe pagina care trebuie
    @Test
    public void testNavigateToSettings() throws InterruptedException {
        //the screen objects need to be created either by an action in another screen, either by constructor itself
        //here is the homecreen initialized with constructor
        HomeScreen homeScreen = new HomeScreen(androidDriver);
        homeScreen.tapMoreOptions();
        Thread.sleep(1000);
        //here is the settings screen initialized by tapping settings in homescreen
        SettingsScreen settingsScreen = homeScreen.tapSettings();
        Thread.sleep(1000);
        Assert.assertTrue(settingsScreen.isBackButtonDisplayed());

    }

    //
    @Test
    public void testRetrive() throws InterruptedException {

        SettingsScreen settingsScreen = new SettingsScreen(androidDriver);

        testNavigateToSettings();
        settingsScreen.tapUsername();
        //step 7
        Assert.assertTrue("Username is not null!" ,settingsScreen.retriveFromUsername() !=null );
        settingsScreen.enterUsername("student");
        settingsScreen.clickOkFromUsername();
        Assert.assertTrue("back button is still displayed!",settingsScreen.isBackButtonDisplayed());

    }

    @Test
    public void testPostMessage() throws InterruptedException {

        PostMsgScreen postmsgscreen = new PostMsgScreen(androidDriver);

        postmsgscreen.clickPostButton();
        Assert.assertEquals("test123" , postmsgscreen.postMessage("test123"));

    }

}
