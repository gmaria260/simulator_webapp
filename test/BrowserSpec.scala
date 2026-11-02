import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneServerPerTest
import org.openqa.selenium.By
import org.openqa.selenium.Keys

/**
 * Runs a browser test using Fluentium against a play application on a server port.
 */
class BrowserSpec extends PlaySpec
  with OneBrowserPerTest
  with GuiceOneServerPerTest
  with HtmlUnitFactory
  with ServerProvider {

  "Application" should {

    "calculate and predict with linear regression in a browser" in {

      go to ("http://localhost:" + port)

      pageSource must include ("Linear Regression Simulator")
      pageSource must include ("Calculate Regression")
      pageSource must include ("Predict")

      var cells = webDriver.findElements(By.cssSelector("#dataTableBody .data-cell"))
      cells.get(0).sendKeys("1")
      cells.get(1).sendKeys("3", Keys.ENTER)

      cells = webDriver.findElements(By.cssSelector("#dataTableBody .data-cell"))
      cells.get(2).sendKeys("2")
      cells.get(3).sendKeys("5")
      webDriver.findElement(By.cssSelector(".calculate-button")).click()

      webDriver.findElement(By.id("slopeResult")).getText mustBe "2"
      webDriver.findElement(By.id("interceptResult")).getText mustBe "1"
      webDriver.findElement(By.id("rSquaredResult")).getText mustBe "1"

      webDriver.findElement(By.id("predictionX")).sendKeys("3")
      webDriver.findElement(By.id("predictButton")).click()
      webDriver.findElement(By.id("predictedY")).getText mustBe "7"
    }
  }
}
