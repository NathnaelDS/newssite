import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class automatednews {
    static File file = new File("mysite.html");

    static StringBuilder content = new StringBuilder();

    public static void main(String[] args) {
        method1();

    }
    public static void method1() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.get("https://www.thereporterethiopia.com/news");

        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }
        content.append("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>Main - Basic Necessities</title>\n" +
                "\t<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
                "\t<!-- <meta charset=\"utf-8\">\n" +
                "\t<meta name=\"description\" content=\"This is very basic html tags example\">\n" +
                "\t<meta name=\"keyword\" content=\"music, rap, jazz, pop, r&b\"> -->\n" +
                "</head>\n" +
                "<body>");
        List<WebElement> items = driver.findElements(By.className("item"));
        for (WebElement item : items){
//            System.out.println(item.getText());
//            System.out.println(" WooW");

            content.append("<div class=\"newsitem\">");
            content.append("<h5>" + item.findElement(By.className("post-created")).getText() + "</h5>\n");
            content.append("<a href=\""+ item.findElement(By.className("post-title")).findElement(By.tagName("a")).getAttribute("href") +"\">\n");
            content.append(item.findElement(By.className("post-title")).getText());
            content.append("</a>\n");
            content.append("<p>" + item.findElement(By.className("post-body")).getText() + "</p>");
            content.append("</div>\n");
        }
        try {
            fileWriter.write(String.valueOf(content));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        content.append("</body>\n" +
                "</html>");

        System.out.println(content);
        //File f = new File();

        driver.close();
    }
}
