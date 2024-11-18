package common;

public class ElementLocators {

    // Locators for the login screen
    public static final String SKIP_BUTTON_ID = "dk.TrackMan.Range:id/skipTextView";
    public static final String SIGNIN_BUTTON_ID = "dk.TrackMan.Range:id/signInButton";
    public static final String USERNAME_FIELD_XPATH = "//android.widget.EditText[@resource-id='Email']";
    public static final String PASSWORD_FIELD_XPATH = "//android.widget.EditText[@resource-id='Password']";
    public static final String LOGIN_BUTTON_XPATH = "//android.widget.Button[@text='SIGN IN']";
    public static final String NOTIFICATION_POPUP_DENY_BUTTON_XPATH = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_deny_button']";

    // Locators for the Planned Round section
    public static final String PLANNED_ROUND_BUTTON_XPATH = "//android.widget.TextView[@resource-id='dk.TrackMan.Range:id/titleTextView' and @text='MY PLANNED ROUNDS']";
    public static final String CLOSE_IMAGE_VIEW_ID = "dk.TrackMan.Range:id/closeImageView";
    public static final String ADD_ROUND_BUTTON_ID = "dk.TrackMan.Range:id/addRoundButton";
    public static final String COURSE_SELECTION_XPATH = "(//android.view.ViewGroup[@resource-id='dk.TrackMan.Range:id/courseOverviewView'])[1]";
    public static final String SELECT_BUTTON_ID = "dk.TrackMan.Range:id/selectButton";
    public static final String CONFIRM_BUTTON_XPATH = "//android.widget.Button[@resource-id='dk.TrackMan.Range:id/saveButton']";
    public static final String CLOSE_IMAGE_BUTTON_XPATH = "//android.widget.ImageView[@resource-id='dk.TrackMan.Range:id/closeButtonImageView']";
    public static final String CLOSE_IMAGE_BUTTON_ID = "dk.TrackMan.Range:id/closeButtonImageView";
}

