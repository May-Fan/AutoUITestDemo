package com.hizuche.handle;

import com.hizuche.base.BaseDriver;
import com.hizuche.page.LoginPage;

/**
 * @Author hp
 * @Description:
 * @date: Create in 2018/9/21 9:57
 * LoginPageHandle类中，定义了登录页面对各元素的操作方法，如输入用户名/密码，点击登录按钮
 */
public class LoginPageHandle {
    public BaseDriver driver;
    public LoginPage loginPage;

    /**
     * 定义带参的构造方法，使得可以传入driver，并创建LoginPage对象
     * @param driver
     */
    public LoginPageHandle(BaseDriver driver){
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }

    /**
     * 在用户名输入框中，输入用户名
     * @param username 输入的用户名
     */
    public void inputUserNamme(String username){
        //调用BasePage中的sendKeys方法
        loginPage.sendKeys(loginPage.getUserName(),username);
    }

    /**
     * 在密码输入框中，输入密码
     * @param password 输入的密码
     */
    public void inputPassword(String password) {
        loginPage.sendKeys(loginPage.getPassword(),password);
    }

    /**
     * 点击登录按钮
     */
    public void clickLoginBtn() {
        loginPage.click(loginPage.getLoginBtn());
    }
}
