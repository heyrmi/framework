package ra.hul.framework.mobile.screens;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FormScreen extends BaseScreen {

    private final By textInput = AppiumBy.accessibilityId("text-input");
    private final By inputResult = AppiumBy.accessibilityId("input-text-result");
    private final By switchToggle = AppiumBy.accessibilityId("switch");
    private final By switchText = AppiumBy.accessibilityId("switch-text");
    private final By dropdownButton = AppiumBy.accessibilityId("Dropdown");
    private final By activeButton = AppiumBy.accessibilityId("button-Active");

    @Step("Type '{text}' into text input")
    public FormScreen typeInInput(String text) {
        type(textInput, text);
        hideKeyboard();
        return this;
    }

    public String getInputResult() {
        return getText(inputResult);
    }

    @Step("Toggle switch")
    public FormScreen toggleSwitch() {
        tap(switchToggle);
        return this;
    }

    public String getSwitchText() {
        return getText(switchText);
    }

    @Step("Click active button")
    public FormScreen clickActiveButton() {
        tap(activeButton);
        return this;
    }

    @Override
    public boolean isLoaded() {
        return isDisplayed(textInput);
    }
}
