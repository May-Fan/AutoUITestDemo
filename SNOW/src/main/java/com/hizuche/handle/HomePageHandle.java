package com.hizuche.handle;

import com.hizuche.base.BaseDriver;
import com.hizuche.page.HomePage;

/**
 * @Author hp
 * @Description: HomePageHandle类，定义了对主页中元素的操作，如点击，获取text等
 * @date: Create in 2018/10/9 10:21
 */
public class HomePageHandle {
    public BaseDriver driver;
    public HomePage homePage;
    public HomePageHandle(BaseDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
    }

    /**
     * 点击右上角的用户信息按钮，呼出信息框
     */
    public void clickUser() {
        homePage.click(homePage.getUserElement());
    }

    /**
     * 获取当前的登录用户信息
     * @return 返回获取到的用户名
     */
    public String getUserName() {
        String username = homePage.getText(homePage.getUserInfo());
        //System.out.println("获取到的用户名是:" + username);
        return username;
    }

}
