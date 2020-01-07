package com.hizuche.page;

import com.hizuche.base.BaseDriver;
import com.hizuche.util.LocateWay;
import org.openqa.selenium.WebElement;

/**
 * @Author hp
 * @Description: 获取主页中各元素的定位，并返回出去
 * @date: Create in 2018/10/9 9:59
 */
public class HomePage extends BasePage {
    public HomePage(BaseDriver driver) {
        super(driver);
    }

    /**
     * 获取右上角用户信息按钮的元素位置
     * @return 返回用户信息按钮的定位方法
     */
    public WebElement getUserElement() {
        return findElement(LocateWay.getLocateWay("userInfo"));
    }

    /**
     * 在已点击用户信息按钮的情况下，获取下拉框中显示用户名的元素
     * @return 返回显示用户名的元素
     */
    public WebElement getUserInfo(){
        return findElement(LocateWay.getLocateWay("presentUser"));
    }

}
