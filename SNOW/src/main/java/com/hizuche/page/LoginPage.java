package com.hizuche.page;

import com.hizuche.base.BaseDriver;
import com.hizuche.util.LocateWay;
import org.openqa.selenium.WebElement;

/**
 * @Author hp
 * @Description:
 * @date: Create in 2018/9/21 9:35
 * LoginPage类中，获取登录页面的元素定位，并返回出去
 */
public class LoginPage extends BasePage {
    public LoginPage(BaseDriver driver) {
        super(driver);
    }

    /**
     * 调用继承自BasePage的findElement方法，根据传入的username，在LocateWay类的getLocateWay方法获取定位方法
     * 获取用户名输入框
     * @return 返回用户名输入框
     */
    public WebElement getUserName() {
        return findElement(LocateWay.getLocateWay("username"));
    }

    /**
     * 获取密码输入框
     * @return 返回密码输入框
     */
    public WebElement getPassword(){
        return findElement(LocateWay.getLocateWay("password"));
    }

    /**
     * 获取登录按钮
     * @return 返回登录按钮
     */
    public WebElement getLoginBtn(){
        return findElement(LocateWay.getLocateWay("loginBtn"));
    }

}
