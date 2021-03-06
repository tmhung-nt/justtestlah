package qa.justtestlah.log;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import qa.justtestlah.utils.SpringContext;

/** {@link WebDriver}-based log handling. */
public class WebDriverLogEnricher implements WebDriverEventListener {

  @Override
  public void beforeAlertAccept(WebDriver driver) {
    // do nothing
  }

  @Override
  public void afterAlertAccept(WebDriver driver) {
    // do nothing
  }

  @Override
  public void afterAlertDismiss(WebDriver driver) {
    // do nothing
  }

  @Override
  public void beforeAlertDismiss(WebDriver driver) {
    // do nothing
  }

  @Override
  public void beforeNavigateTo(String url, WebDriver driver) {
    // do nothing
  }

  @Override
  public void afterNavigateTo(String url, WebDriver driver) {
    SpringContext.getBean(TestLogWriter.class)
        .log(LogLevel.INFO, TestLogWriter.WEBDRIVER_INDENTATION, "Navigating to {}", url);
  }

  @Override
  public void beforeNavigateBack(WebDriver driver) {
    // do nothing
  }

  @Override
  public void afterNavigateBack(WebDriver driver) {
    // do nothing
  }

  @Override
  public void beforeNavigateForward(WebDriver driver) {
    // do nothing
  }

  @Override
  public void afterNavigateForward(WebDriver driver) {
    // do nothing
  }

  @Override
  public void beforeNavigateRefresh(WebDriver driver) {
    // do nothing
  }

  @Override
  public void afterNavigateRefresh(WebDriver driver) {
    // do nothing
  }

  @Override
  public void beforeFindBy(By by, WebElement element, WebDriver driver) {
    SpringContext.getBean(TestLogWriter.class)
        .log(LogLevel.INFO, TestLogWriter.WEBDRIVER_INDENTATION, "Finding element {}", by);
  }

  @Override
  public void afterFindBy(By by, WebElement element, WebDriver driver) {
    // do nothing
  }

  @Override
  public void beforeClickOn(WebElement element, WebDriver driver) {
    SpringContext.getBean(TestLogWriter.class)
        .log(LogLevel.INFO, TestLogWriter.WEBDRIVER_INDENTATION, "Clicking on {}", element);
  }

  @Override
  public void afterClickOn(WebElement element, WebDriver driver) {
    // do nothing
  }

  @Override
  public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
    StringBuilder strBuilder = new StringBuilder();
    for (CharSequence charSequence : keysToSend) {
      // replace new lines with ⏎ (for more clarity and to prevent multi-line log outputs)
      strBuilder.append(charSequence.toString().replaceAll("[\\n\\r]+", "⏎"));
    }
    SpringContext.getBean(TestLogWriter.class)
        .log(
            LogLevel.INFO,
            TestLogWriter.WEBDRIVER_INDENTATION,
            "Typing {} in {}",
            strBuilder.toString(),
            element);
  }

  @Override
  public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
    // do nothing
  }

  @Override
  public void beforeScript(String script, WebDriver driver) {
    SpringContext.getBean(TestLogWriter.class)
        .log(LogLevel.INFO, TestLogWriter.WEBDRIVER_INDENTATION, "Executing script {}", script);
  }

  @Override
  public void afterScript(String script, WebDriver driver) {
    // do nothing
  }

  @Override
  public void beforeSwitchToWindow(String windowName, WebDriver driver) {
    // do nothing
  }

  @Override
  public void afterSwitchToWindow(String windowName, WebDriver driver) {
    // do nothing
  }

  @Override
  public void onException(Throwable throwable, WebDriver driver) {
    // do nothing
  }

  @Override
  public <X> void beforeGetScreenshotAs(OutputType<X> target) {
    // do nothing
  }

  @Override
  public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
    // do nothing
  }

  @Override
  public void beforeGetText(WebElement element, WebDriver driver) {
    SpringContext.getBean(TestLogWriter.class)
        .log(LogLevel.INFO, TestLogWriter.WEBDRIVER_INDENTATION, "Fetching text from {}", element);
  }

  @Override
  public void afterGetText(WebElement element, WebDriver driver, String text) {
    SpringContext.getBean(TestLogWriter.class)
        .log(
            LogLevel.INFO,
            TestLogWriter.WEBDRIVER_INDENTATION,
            "Fetched text {} from {}",
            text,
            element);
  }
}
