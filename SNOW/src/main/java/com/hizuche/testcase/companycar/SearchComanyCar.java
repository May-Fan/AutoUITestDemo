package com.hizuche.testcase.companycar;

import com.hizuche.base.BaseDriver;
import com.hizuche.business.CompanyCarPageBH;
import com.hizuche.business.LoginAssert;
import com.hizuche.page.CompanyCarPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * @Author hp
 * @Description:
 * @date: Create in 2018/10/15 16:59
 */
public class SearchComanyCar {
    private BaseDriver driver;
    private LoginAssert loginAssert;
    private CompanyCarPageBH companyCarPageBH;
    private CompanyCarPage companyCarPage;
    private static Logger logger = LogManager.getLogger(SearchComanyCar.class.getName());
    public ExtentReports extentReports2;
    public ExtentTest extentTest2;
    /**
     * 在搜索脚本运行前，创建handleCookie对象，打开网页后将cookie值传进去
     */
    @BeforeClass
    public void beforeClass() throws InterruptedException {
        this.driver = new BaseDriver("chrome");
        loginAssert = new LoginAssert(driver);
        companyCarPageBH = new CompanyCarPageBH(driver);
        Thread.sleep(2000);

        extentReports2 = new ExtentReports("/Users/fanlilin/workspace/snow/AutoUITestDemo/SNOW/extentreports/report.html");
        extentTest2 = extentReports2.startTest("【车库车辆】搜索功能");

        driver.get("https://crms.hpzuche.cn/");
        Thread.sleep(3000);

        loginAssert.logIn();
        Thread.sleep(2000);

        driver.get("https://crms.hpzuche.cn/inventory_cars");
        extentTest2.log(LogStatus.INFO,"正在打开【车库车辆】页面...");
        Thread.sleep(500);
    }

    /**
     * 搜索
     */
    @Test
    public void testSearchCompanyCar() throws Exception {
        companyCarPageBH.searchCompanyCar();
        companyCarPage = new CompanyCarPage(driver);
        if(companyCarPage.doseWebElementExist("result_total_text")) {
            String totalCount = companyCarPageBH.getTotalCount();
            Reporter.log("在【车辆管理-公司车辆】中共搜索到 " + totalCount + " 条结果",true);
            extentTest2.log(LogStatus.INFO,"在【车辆管理-公司车辆】中共搜索到 " + totalCount + " 条结果");
            logger.debug("【车辆管理-公司车辆】搜索功能-测试通过！");
        }
        else {
            //Reporter.log("【车辆管理-公司车辆】搜索功能出错！",true);
            extentTest2.log(LogStatus.INFO,"【车辆管理-公司车辆】搜索功能出错！");
            logger.error("【车辆管理-公司车辆】搜索功能-出错！");
        }

        Thread.sleep(500);
        companyCarPageBH.clearSearResult();
        if(companyCarPage.doseWebElementExist("result_total_text")) {
            String totalCount = companyCarPageBH.getTotalCount();
            Reporter.log("清除搜索条件后，在【车辆管理-公司车辆】中共有 " + totalCount + " 条车辆信息",true);
            extentTest2.log(LogStatus.PASS,"【车辆管理-公司车辆】搜索功能-测试通过！");
            logger.debug("【车辆管理-公司车辆】清除搜索功能-测试通过！");
        }
        else {
            Reporter.log("清除搜索条件后，【车辆管理-公司车辆】搜索功能出错！",true);
            logger.error("【车辆管理-公司车辆】清除搜索功能-出错！");
        }

    }

    /**
     * 完成本条测试用例后，自动关闭浏览器
     */

    @AfterClass
    public void closeBrowser() {
        driver.close();
        extentReports2.endTest(extentTest2);
        extentReports2.flush();
    }

}

