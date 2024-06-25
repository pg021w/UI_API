package utils;

import io.restassured.path.json.JsonPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class GenericUtils {
    public static WebDriver driver;
    public static Properties prop;

    public static Properties getPropertyinstance() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//global.properties");
        prop = new Properties();
        prop.load(fis);
        return  prop;
    }
    public static WebDriver initializeDriver() throws IOException {

        String url = getPropertyinstance().getProperty("QAUrl");
        String browser_properties = getPropertyinstance().getProperty("browser");
        if (driver == null) {
            if (browser_properties.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            }
            if (browser_properties.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
        }
        return driver;
    }

    public static String getbaseURL() throws IOException {
        String baseURL= getPropertyinstance().getProperty("Endpoint");
         return baseURL;
    }

    public static String createPayload(String name,String job) {
        return "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}";
    }

    public static Object getJson(String response,String path) {
        JsonPath jsonPath =  new JsonPath(response);
        return jsonPath.get(path);
    }
}
