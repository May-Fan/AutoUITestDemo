package com.hizuche.testcase.log;

import com.hizuche.base.BaseDriver;
import com.hizuche.business.LoginAssert;
import com.hizuche.handle.HomePageHandle;
import com.hizuche.handle.LoginPageHandle;
import com.hizuche.util.ReadProperties;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @Author hp
 * @Description: 登录的测试用例
 * @date: Create in 2018/9/21 14:09
 */
public class Login  {
    private BaseDriver driver;
    public LoginPageHandle loginPageHandle;
    public HomePageHandle homePageHandle;
    private ReadProperties users;
    private LoginAssert loginAssert;
    private static Logger logger = LogManager.getLogger(Login.class.getName());
    public ExtentReports extentReports;
    public ExtentTest extentTest;

    /**
     * 构造方法
     * 在构造方法中定义浏览器，并调用handle操作层
     */
    public Login() {
        this.driver = new BaseDriver("chrome");
        loginPageHandle = new LoginPageHandle(driver);
        homePageHandle = new HomePageHandle(driver);
        loginAssert = new LoginAssert(driver);
        //新建一个HandleCookie对象，以便将登陆信息的cookie穿进去
        //handleCookie = new HandleCookie(driver);
    }

    /**
     * 浏览器打开snow测试环境地址，该函数中读取配置文件是为了获取用户名，用于断言做比较
     */
    @BeforeClass
    public void getHome() {
        extentReports = new ExtentReports("/Library/SeleniumTestcase/SNOW/extentreports/report.html");
        extentTest = extentReports.startTest("用户登陆");
        driver.get("https://crms.hizuche.cn/");
        try{
            Thread.sleep(4000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        extentTest.log(LogStatus.INFO,"opening LogIn page ...");
        users = new ReadProperties("/Library/SeleniumTestcase/SNOW/src/Users.properties");
    }

    /**
     * 在登录页登录后，核对登录信息
     * @throws InterruptedException 为延时函数抛出异常
     */
    @Test
    public void testLogin() {

        loginAssert.logIn();
        extentTest.log(LogStatus.INFO,"Log In ... ");
        try{
            Thread.sleep(4000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        String username = users.getProperty("username_1");//用于断言的对比
        loginAssert = new LoginAssert(driver); //底层操作中需要运用driver
        if (loginAssert.assertLogin(username)) {
            /*测试报告中输出信息，并在日志中记录*/
            Reporter.log(username + "登录信息正确！",true);
            extentTest.log(LogStatus.PASS,"用户登陆功能-测试通过！");
            logger.debug("用户登陆功能-测试通过！");
            //handleCookie.writeCookies();
        } else {
            Reporter.log(username + "当前用户信息与登录用户不符合！",true);
            extentTest.log(LogStatus.ERROR,"当前用户信息与登录用户不符合！");
            logger.warn("用户登陆功能出错！当前用户信息与登陆用户不符合！");
        }
    }

    /**
     * 用例运行结束后，关闭浏览器
     */

    @AfterClass
    public void closeBrowser(){
        driver.close();
        extentReports.endTest(extentTest);
        extentReports.flush();
    }


}
