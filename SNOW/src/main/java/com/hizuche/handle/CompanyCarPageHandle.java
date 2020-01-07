package com.hizuche.handle;

import com.hizuche.base.BaseDriver;
import com.hizuche.page.CompanyCarPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

/**
 * @Author hp
// * @Description: CompanyCarPageHandle类，定义了对【公司车辆】页面中元素的操作，如点击、输入等
 * @date: Create in 2018/10/18 17:51
 */
public class CompanyCarPageHandle {

    public BaseDriver driver;
    public CompanyCarPage companyCarPage;
    public WebDriver driver1;
    public Actions action;
    int i=0;
    public CompanyCarPageHandle(BaseDriver driver) {
        this.driver = driver;
        companyCarPage = new CompanyCarPage(driver);
    }

    /**
     * 在【公司车辆】-车牌号搜索框中，输入搜索内容
     * @param car_no 传入搜索车牌号的关键字参数
     */
    public void inputCarNo(String car_no) {
        companyCarPage.sendKeys(companyCarPage.getCarNo(),car_no);
    }

    /**
     * 在【公司车辆】-车架号搜索框中，输入搜索内容
     * @param vin 传入搜索车架号的关键字参数
     */
    public void inputVin(String vin) {
        companyCarPage.sendKeys(companyCarPage.getVin(),vin);
    }

    /**
     * 在【公司车辆】中点击车型搜索框
     */
    public void clickGenres() {
        companyCarPage.click(companyCarPage.getGenres());
    }

    /**
     * 在【公司车辆】中已点击车型的前提下，选择车型中的ER30
     */
    public void clickGenres_ER30() {
        companyCarPage.click(companyCarPage.getGenres_ER30());
    }


    /**
     * 在【公司车辆】中已点击车辆用途的前提下，选择车辆用途中的租赁车
     */
    public void chooseCarOperate() {
        driver1 = driver.returnWebDriver();
        action = new Actions(driver1);
        action.sendKeys(Keys.TAB).perform();
        for(int j=0;j<1;j++) {
            action.sendKeys(Keys.DOWN).perform();
        }
        action.sendKeys(Keys.ENTER).perform();
    }

    /**
     * 在【公司车辆】中点击城市搜索框
     */
    public void clickCity() {
        companyCarPage.click(companyCarPage.getCity());
    }

    /**
     * 在【公司车辆】中已点击城市的前提下，点击"浙江"
     */
    public void clickCity_zhejiang() {
        companyCarPage.click(companyCarPage.getCity_zhejiang());
    }

    /**
     * 在【公司车辆】中已点击城市-浙江的前提下，点击"杭州"
     */
    public void clickCity_hangzhou() {
        companyCarPage.click(companyCarPage.getCity_hangzhou());
    }

    public void clickOperateCompany() {
        companyCarPage.click(companyCarPage.getOperationCompany());
    }
    /**
     * 在【公司车辆】中已点击运营公司的前提下，点击杭州小车东
     */
    public void chooseOperateCompany() {
        driver1 = driver.returnWebDriver();
        action = new Actions(driver1);
        //action.sendKeys(Keys.TAB).perform();
        //action.sendKeys(Keys.ENTER).perform();
        /*
        JavascriptExecutor js =(JavascriptExecutor)driver1;
        WebElement element = driver1.findElement(By.xpath("/html/body/div[2]/div/div/div"));
        String jsCommand = "document.getElementByXpath('/html/body/div[2]/div/div/div').style.overflow='visible'";
        js.executeScript(jsCommand);
        */

        /*
        while (!(companyCarPage.doseWebElementExist("operation_company_hz"))){
            //System.out.println(companyCarPage.doseWebElementExist("operation_company_hz"));
            System.out.println((i));
            i++;
            action.sendKeys(Keys.DOWN).perform();
        }
        */
        for(int j=0;j<55;j++) {
            action.sendKeys(Keys.DOWN).perform();
        }
        action.sendKeys(Keys.ENTER).perform();
    }

    /**
     * 在【公司车辆】中点击发车状态搜索框，模拟键盘操作
     */
    public void chooseCarState() throws InterruptedException {
        driver1 = driver.returnWebDriver();
        action = new Actions(driver1);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ENTER).perform();
        action.sendKeys(Keys.DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
    }

    /**
     * 在【公司车辆】中点击搜索按钮
     */
    public void clickSearchBtn() {
        companyCarPage.click(companyCarPage.getSearchBtn());
    }

    /**
     * 在【公司车辆】中获取到右下角搜索统计按钮到文本内容
     * @return 返回统计的文本信息
     */
    public String getTotalText() {
        String totalText = companyCarPage.getTotalText().getText();
        return totalText;
    }

    /**
     * 在【公司车辆】中点击清除按钮
     */
    public void clickClearSearBtn() {
        companyCarPage.click(companyCarPage.getClearSearchBtn());
    }

}
