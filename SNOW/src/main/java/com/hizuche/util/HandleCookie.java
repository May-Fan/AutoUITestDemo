package com.hizuche.util;

import com.hizuche.base.BaseDriver;
import org.openqa.selenium.Cookie;

import java.util.Set;


/**
 * @Author hp
 * @Description: 用于操作配置文件中的Cookie信息
 * @date: Create in 2018/10/16 9:46
 */
public class HandleCookie {
    public BaseDriver driver;
    public ReadProperties properties1;
    /**
     * 创建一个带参的HandleCookie构造函数
     * @param driver 传入浏览器驱动
     */
    public HandleCookie(BaseDriver driver) {
        this.driver = driver;
        properties1 = new ReadProperties("/Library/SeleniumTestcase/SNOW/src/Cookie.properties");
    }

    /**
     * 浏览器打开网页后，将网页上的cookie值设置给浏览器驱动driver
     */
    public void setCookies() {
        String value = properties1.getProperty("skioToken");
        Cookie cookie = new Cookie("skioToken", value, "hizuche.cn", "/", null);
        driver.setCookie(cookie);
    }

    /**
     * 检索配置文件中是否存在该键名，如果有，则将获取到的cookie写入
     */
    public void writeCookies() {
        Set<Cookie> cookies =  driver.getCookie();
        for (Cookie cookie:cookies) {
            if (cookie.getName().equals("skioToken")) {
                properties1.writeProperty(cookie.getName(), cookie.getValue());
            }
        }
    }
}
