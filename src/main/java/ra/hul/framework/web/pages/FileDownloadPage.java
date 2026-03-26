package ra.hul.framework.web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ra.hul.framework.core.constants.Endpoints;

public class FileDownloadPage extends BasePage {

    @Step("Open file download page")
    public FileDownloadPage open() {
        navigateToPath(Endpoints.FILE_DOWNLOAD);
        return this;
    }

    @Step("Click file link: {fileName}")
    public FileDownloadPage clickFile(String fileName) {
        click(By.linkText(fileName));
        return this;
    }

    public boolean isFileLinkPresent(String fileName) {
        return isDisplayed(By.linkText(fileName));
    }

    @Override
    public boolean isLoaded() {
        return getDriver().getCurrentUrl().contains("/download");
    }
}
