/*
package com.hizuche.util;

import com.hizuche.base.BaseDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class TakeScreenShot {
    public WebDriver driver_1;

    public void takeScreenShot(BaseDriver driver) {
        driver_1 = (WebDriver) driver;
        long time = System.currentTimeMillis();
        String curPath = System.getProperty("user.dir");
        //将时间戳转换为String类型
        String path = curPath + "/" + String.valueOf(time) + ".png";
        File screenShot = ((TakesScreenshot) driver_1).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenShot,new File(path));
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}*/
