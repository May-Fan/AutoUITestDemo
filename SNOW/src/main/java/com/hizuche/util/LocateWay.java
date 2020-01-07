package com.hizuche.util;

import org.openqa.selenium.By;

/**
 * LocateWay类中，仅定义了一个getLocateWay方法：
 */
public class LocateWay {

    /**
     * 根据传入的元素名称key，调用配置文件中的getProperty方法，并返回具体的定位方法，如By.id("username")
     * static修饰的类方法，需用类名调用
     * @param key 键值对中的键名
     * @return 返还具体的定位方法
     */
    public static By getLocateWay(String key) {

        ReadProperties property = new ReadProperties("/Library/SeleniumTestcase/SNOW/src/ElementLocate.properties");
        /*构造一个新的ReadProperties对象，使用传入的元素名称key，调用该类中的getProperty方法*/
        String locator = property.getProperty(key);
        String locateWay = locator.split(">")[0]; //获取定位方式
        String locateValue = locator.split(">")[1]; //获取具体的定位值

        /*根据定位方式，返回对应的定位表达式，该表达式为By类型*/
        if (locateWay.equals("id")) {
            return By.id(locateValue);
        } else if (locateWay.equals("name")) {
            return By.name(locateValue);
        } else if (locateWay.equals("className")) {
            return By.className(locateValue);
        } else if (locateWay.equals("xpath")) {
            return By.xpath(locateValue);
        } else if (locateWay.equals("cssSelector")) {
            return By.cssSelector(locateValue);
        } else if (locateWay.equals("linkText")) {
            return By.linkText(locateValue);
        }
        return null;
    }
}
