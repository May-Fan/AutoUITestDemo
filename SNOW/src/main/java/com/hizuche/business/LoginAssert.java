package com.hizuche.business;

import com.hizuche.base.BaseDriver;
import com.hizuche.handle.HomePageHandle;
import com.hizuche.handle.LoginPageHandle;
import com.hizuche.util.ReadProperties;
import org.testng.Reporter;

/**
 * @Author hp
 * @Description: 确认当前登录用户是否正确
 * @date: Create in 2018/10/8 14:57
 */
public class LoginAssert {
    public BaseDriver driver;
    public HomePageHandle hph;
    public LoginPageHandle loginPageHandle;
    public ReadProperties users;
    public LoginAssert(BaseDriver driver) {
        this.driver = driver;
        hph = new HomePageHandle(driver);
        users = new ReadProperties("/Library/SeleniumTestcase/SNOW/src/Users.properties");
    }

    /**
     * 封装登陆函数，获取配置文件中的用户名，密码，在输入框中输入
     */
    public void logIn() {
        String username = users.getProperty("username_1");
        String password = users.getProperty("password_1");
        loginPageHandle = new LoginPageHandle(driver);
        /*try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        loginPageHandle.inputUserNamme(username);
        loginPageHandle.inputPassword(password);
        loginPageHandle.clickLoginBtn();
        Reporter.log(username+ "登陆成功！",true);
    }

    /**
     * 将获取到的当前用户文本信息，与断言进行比较
     * @param username 定义的断言
     * @return 返回比较结果，相同则为true
     */
    public Boolean assertLogin(String username) {
        hph.clickUser();
        return hph.getUserName().equals(username);
    }
}
