package google_formfill;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google_formfill {
    WebDriver driver;
    public Google_formfill(){
        System.out.println("Constructor: Google_foemfill");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     }

     public void google_formfill() throws InterruptedException{
       
        // Navigate to https://forms.gle/wjPkzeSEk1CM7KgGA
        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA");
        // Identify the search box Using Locator "ID"  'APjFqb'
        WebElement namefield = driver.findElement(By.xpath("//div[@class = 'AgroKb']//div/input"));
        Thread.sleep(2000);
        searchbar.sendKeys("Sruthakeerthi");
        Thread.sleep(2000);
        WebElement whyAutomation = driver.findElement(By.xpath("//div[@class = 'AgroKb']//div/textarea"));
        whyAutomation.sendKeys("I want to be the best QA Engineer! 1710572021");
        Thread.sleep(2000);
        WebElement radioButton = driver.findElement(By.xpath("//div[@role = 'listitem']//div[@id='i13']"));
        radioButton.click();
        WebElement multipleselectButton = driver.findElements(By.xpath("//div[@class = 'PkgjBf MbhUzd']/../..//div/span"));
        for (WebElement checkbox : multipleselectButton.findElements(By.xpath("//div[@class = 'PkgjBf MbhUzd']/../..//div/span"))) {
            if (!checkbox.getText().equals("Springboot")) { 
              checkbox.click();
            }
          }
          WebElement dropdown = driver.findElement(By.xpath("//div[@class = 'MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R']"));
          Select select = new Select(dropdown);
          select.selectByVisibleText("Mrs");
          Thread.sleep(2000);
          WebElement date = driver.findElement(By.xpath("//input[@type='date']"));
          LocalDate currentDate = LocalDate.now();
          date.sendKeys(currentDate-7);
          Thread.sleep(2000);
          LocalTime currentTime = LocalTime.now();
          DateTimeFormatter hourMinuteFormatter = DateTimeFormatter.ofPattern("h:mm");
          String formattedHourMinute = currentTime.format(hourMinuteFormatter);
          String[] hourMinuteAMPM = formattedHourMinute.split(":");
          String hour = hourMinuteAMPM[0];
          String minute = hourMinuteAMPM[1];
          String ampm = currentTime.getHour() < 12 ? "AM" : "PM";
  
          WebElement hourfield = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
          hourfield.sendKeys(hour);
          WebElement minutefield = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
          minutefield.sendKeys(minute);
          WebElement ampmDropdown = driver.findElement(By.xpath("//div[@class='jgvuAb ybOdnf f0pfFe t9kgXb llrsB']"));
          Select ampmselect = new Select(ampmDropdown);
          ampmselect.selectByVisibleText(ampm);

          driver.get("https://www.amazon.in");
          driver.switchTo().alert().dismiss();

          WebElement submit = driver.findElement(By.text("Submit"));
          submit.click();
          WebElement response = driver.findElement(By.xpath("//div[@class='pdLVYe LgNcQe']"));
          System.out.println(response.getText());
          
            }

     public void endTest()
    {
        System.out.println("End Test: Google_formfill");
        driver.close();
        driver.quit();

    }

}
