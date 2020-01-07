package com.hizuche.base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

/**
 * @author May
 * @date 2018/9/20 15:40
 * BaseDriver类，定义了带参的构造方法,selectDriver方法，根据传入的参数对浏览器进行选择，并定义浏览器初始化、关闭等
 */
public class BaseDriver {
    private WebDriver driver;

    public BaseDriver(String browser) {
        this.driver = selectDriver(browser);
    }

    /**
     * 根据传入的字符串，选择浏览器
     * @param browser  传入的浏览器名称
     * @return 返还具体的浏览器驱动
     */
    public WebDriver selectDriver(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Library/Selenium Webdriver/geckodriver");
            return new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Library/Selenium Webdriver/chromedriver");
            return new ChromeDriver();
        }
        return null;
    }

    /**
     * 因为在BasePage中调用的是BaseDriver类，而不是WebDriver，因此要在此类中单独定义该方法
     * @param elementLocate 传入具体的定位方法
     * @return
     */
    public WebElement findElement(By elementLocate) {
        WebElement element = driver.findElement(elementLocate);
        return element;
    }

    /**
     * 为BaseDriver类定义get方法
     * @param url 输入的网址
     */
    public void get(String url){
        driver.get(url);
    }

    /**
     * 为BaseDriver定义浏览器关闭操作
     */
    public void close(){
        driver.close();
    }

    /**
     * 在浏览器驱动中添加cookie
     * @param cookie 传入的cookie值
     */
    public void setCookie(Cookie cookie){
        driver.manage().addCookie(cookie);
    }

    /**
     * 获取已有的cookie
     * @return 返回获取到的cookie值
     */
    public Set<Cookie> getCookie() {
        Set<Cookie> cookies = driver.manage().getCookies();
        return cookies;
    }

    /**
     * 为需要webdriver类型驱动的地方返回驱动
     * @return 返回类型是webdriver类型的驱动
     */
    public WebDriver returnWebDriver() {
        return driver;
    }

    /**
     * 最大化浏览器窗口
     */
    public void maximize() {
        driver.manage().window().maximize();
    }

}
