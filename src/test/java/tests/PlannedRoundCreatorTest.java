package tests;

import common.Config;
import common.ElementLocators;
import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class PlannedRoundCreatorTest extends BaseTest {

    private static final Logger LOGGER = Logger.getLogger(PlannedRoundCreatorTest.class.getName());

    @Test
    public void createPlannedRound() {
        try {
            handleLogin();
            navigateToPlannedRoundSection();
            createNewPlannedRound();
            verifyRoundDetails();
        }  catch (Exception e) {
            LOGGER.severe("An error occurred: " + e.getMessage());
        }
    }

    private void handleLogin()  {
        WebElement skipButton = findElementById(ElementLocators.SKIP_BUTTON_ID);
        if (skipButton != null) {
            skipButton.click();
        }

        WebElement signinButton = findElementById(ElementLocators.SIGNIN_BUTTON_ID);
        if (signinButton != null) {
            signinButton.click();
        } else {
            throw new NoSuchElementException("Sign In button not found");
        }

        WebElement usernameField = findElementByXpath(ElementLocators.USERNAME_FIELD_XPATH);
        WebElement passwordField = findElementByXpath(ElementLocators.PASSWORD_FIELD_XPATH);
        WebElement loginButton = findElementByXpath(ElementLocators.LOGIN_BUTTON_XPATH);

        if (usernameField != null && passwordField != null && loginButton != null) {
            usernameField.sendKeys(Config.USERNAME);
            passwordField.sendKeys(Config.PASSWORD);
            loginButton.click();
        } else {
            throw new NoSuchElementException("Login elements not found");
        }

        WebElement notificationPopupDenyButton = findElementByXpath(ElementLocators.NOTIFICATION_POPUP_DENY_BUTTON_XPATH);
        if (notificationPopupDenyButton != null) {
            notificationPopupDenyButton.click();
        } else {
            LOGGER.severe("Notification popup deny button not found. Continuing without clicking.");
        }
    }

    private void navigateToPlannedRoundSection() {
        WebElement plannedRoundButton = findElementByXpath(ElementLocators.PLANNED_ROUND_BUTTON_XPATH);
        if (plannedRoundButton != null) {
            plannedRoundButton.click();
        } else {
            throw new NoSuchElementException("Planned Round button not found");
        }

        WebElement imageViewCloseButton = findElementById(ElementLocators.CLOSE_IMAGE_VIEW_ID);
        if (imageViewCloseButton != null) {
            imageViewCloseButton.click();
        } else {
            LOGGER.severe("Close Image View button not found. Continuing without closing.");
            throw new NoSuchElementException("Close Image View Button not found");
        }
    }

    private void createNewPlannedRound() {
        WebElement addRoundButton = findElementById(ElementLocators.ADD_ROUND_BUTTON_ID);
        if (addRoundButton != null) {
            addRoundButton.click();
        } else {
            throw new NoSuchElementException("Add Round button not found");
        }

        WebElement courseSelection = findElementByXpath(ElementLocators.COURSE_SELECTION_XPATH);
        if (courseSelection != null) {
            courseSelection.click();
        } else {
            throw new NoSuchElementException("Course selection element not found");
        }

        WebElement planVirtualGolfRoundButton = findElementById(ElementLocators.SELECT_BUTTON_ID);
        if (planVirtualGolfRoundButton != null) {
            planVirtualGolfRoundButton.click();
        } else {
            throw new NoSuchElementException("Plan Virtual Golf Round button not found");
        }

        WebElement confirmButton = findElementByXpath(ElementLocators.CONFIRM_BUTTON_XPATH);
        if (confirmButton != null) {
            confirmButton.click();
        } else {
            throw new NoSuchElementException("Confirm button not found");
        }
    }

    private void verifyRoundDetails() throws InterruptedException {
       // WebElement closeImageButton = findElementByXpath(ElementLocators.CLOSE_IMAGE_BUTTON_XPATH);

        WebElement closeImageButton = findElementById(ElementLocators.CLOSE_IMAGE_BUTTON_ID);
        if (closeImageButton != null) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30));
            WebElement closeImage = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id(ElementLocators.CLOSE_IMAGE_BUTTON_ID)));
            Assert.assertNotNull(closeImage,"Planned Round has been created");
            closeImage.click();

            }
        else {
            LOGGER.severe("Close Image Button not found. Continuing without closing.");
            throw new NoSuchElementException("Close Image Button not found");
        }

    }


}
