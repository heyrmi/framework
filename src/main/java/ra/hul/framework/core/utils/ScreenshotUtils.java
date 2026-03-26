package ra.hul.framework.core.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public final class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static byte[] captureAsBytes(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static String captureAsBase64(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

    public static void captureToFile(WebDriver driver, String filePath) {
        byte[] screenshot = captureAsBytes(driver);
        try {
            Path path = Path.of(filePath);
            Files.createDirectories(path.getParent());
            Files.write(path, screenshot);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot to: " + filePath, e);
        }
    }
}
