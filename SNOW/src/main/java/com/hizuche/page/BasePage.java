package com.hizuche.page;

import com.hizuche.base.BaseDriver;
import com.hizuche.util.LocateWay;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author hp
 * @date 2018/9/20 15:40
 * BasePage类中，定义了页面基础的操作方法，元素定位，单击，输入，悬停等
 */
public class BasePage {
    public BaseDriver driver;
    public WebDriver driver_1;
    public BasePage(BaseDriver driver) {
        this.driver = driver;
    }

    /**
     * findElement方法，在其他类中构造的是BasePage，而不是WebDriver，因此要单独封装这个方法
     * @param elementLocate 传入具体的定位方式，根据这个查找元素并返回
     * @return 查找到页面元素后返回出去
     */
    public WebElement findElement(By elementLocate) {
        WebElement element = driver.findElement(elementLocate);
        if (element != null) {
            return element;
        } else {
            System.out.println("没有在页面中定位到元素！");
            return null;
        }
    }

    /**
     * 封装页面中，单击元素的click方法
     * @param element 传入页面元素，点击
     */
    public void click(WebElement element) {
        if (element != null) {
            element.click();
        } else {
            System.out.println(element + "元素点击失败！");
        }
    }

    /**
     * 封装页面中，input输入框的sendKey方法
     * @param element 传入input类型的页面元素
     * @param value 传入需要输入的字符串
     */
    public void sendKeys(WebElement element, String value) {
        if (element != null) {
            element.sendKeys(value);
        } else {
            System.out.println("在" + element + "输入框中，输入" + value + "失败！");
        }
    }

    /**
     * 封装页面中，对元素的悬停操作
     * @param element 传入的页面元素
     */
    public void moveToElement(WebElement element) {
        driver_1 = driver.returnWebDriver();
        Actions action = new Actions((WebDriver) driver_1);
        if (element != null) {
            action.moveToElement(element).perform();
        } else {
            System.out.println(element + "元素悬停失败！");
        }
    }

    /**
     * 封装页面中，对元素获取文本的方法
     * @param element 传入的页面元素
     * @return 返回获取的文本信息
     */
    public String  getText(WebElement element) {
        if (element != null) {
            return element.getText();
        } else {
            System.out.println("无法获取到" + element + "元素的文本信息！");
        }
        return null;
    }

    /**
     * 传入对应的定位关键字，判断该元素是否存在
     * @param elementLocateKey 传入的关键字
     * @return 返回布尔值
     */
    public boolean doseWebElementExist(String elementLocateKey) throws Exception{
        try{
            Thread.sleep(500);
            driver.findElement(LocateWay.getLocateWay(elementLocateKey));
            return true;
        }catch(NoSuchElementException e) {
            return false;
        }
    }
}
