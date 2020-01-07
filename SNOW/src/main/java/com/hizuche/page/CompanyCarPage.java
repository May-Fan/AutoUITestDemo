package com.hizuche.page;

import com.hizuche.base.BaseDriver;
import com.hizuche.util.LocateWay;
import org.openqa.selenium.WebElement;

/**
 * @Author mac
 * @Description: 获取公司车辆页面各元素的定位方法，并返回出去
 * @date: Create in 2018/10/18 16:39
 */
public class CompanyCarPage extends BasePage {
    public CompanyCarPage(BaseDriver driver) {
        super(driver);
    }

    /**
     * 获取【公司车辆】-搜索条件-车牌号搜索框的元素定位方法
     * @return 返回车牌号搜索框的定位方法
     */
    public WebElement getCarNo() {
        return findElement(LocateWay.getLocateWay("car_no"));
    }

    /**
     * 获取【公司车辆】-搜索条件-车架号搜索框的元素定位方法
     * @return 返回车架号搜索框的定位方法
     */
    public WebElement getVin() {
        return findElement(LocateWay.getLocateWay("vin"));
    }

    /**
     * 获取【公司车辆】-搜索条件-车型搜索框的元素定位方法
     * @return 返回车型搜索框的定位方法
     */
    public WebElement getGenres() {
        return findElement(LocateWay.getLocateWay("genres"));
    }

    /**
     * 获取【公司车辆】-搜索条件-ER30车型的元素定位方法
     * @return 返回车型ER30的定位方法
     */
    public WebElement getGenres_ER30() {
        return findElement(LocateWay.getLocateWay("genres_ER30"));
    }

    /**
     * 获取【公司车辆】-搜索条件-车辆用途搜索框的元素定位方法
     * @return 返回车辆用途搜索框的定位方法
     */
    public WebElement getCarOperate() {
        return findElement(LocateWay.getLocateWay("car_operate"));
    }

    /**
     * 获取【公司车辆】-搜索条件-城市搜索框的元素定位方法
     * @return 返回城市搜索框的元素定位方法
     */
    public WebElement getCity() {
        return findElement(LocateWay.getLocateWay("city"));
    }

    /**
     * 获取【公司车辆】-搜索条件-城市是浙江的元素定位方法
     * @return 返回城市是浙江的元素定位方法
     */
    public WebElement getCity_zhejiang() {
        return findElement(LocateWay.getLocateWay("city_zhejiang"));
    }

    /**
     * 获取【公司车辆】-搜索条件-城市是杭州的元素定位方法
     * @return 返回城市是杭州的元素定位方法
     */
    public WebElement getCity_hangzhou() {
        return findElement(LocateWay.getLocateWay("city_hangzhou"));
    }

    /**
     * 获取【公司车辆】-搜索条件-运营公司搜索框的元素定位方法
     * @return 返回运营公司搜索框的元素定位方法
     */
    public WebElement getOperationCompany() {
        return findElement(LocateWay.getLocateWay("operation_company"));
    }

    /**
     * 获取【公司车辆】-搜索条件-发车状态搜索框的元素定位方法
     * @return 返回发车状态搜索框的元素定位方法
     */
    public WebElement getCarState() {
        return findElement(LocateWay.getLocateWay("car_state"));
    }

    /**
     * 获取【公司车辆】-搜索条件-发车状态-空闲搜索框的元素定位方法
     * @return 返回发车状态是空闲的元素定位方法
     */
    public WebElement getCarState_free() {
        return findElement(LocateWay.getLocateWay("car_state_free"));
    }

    /**
     * 获取【公司车辆】-搜索按钮的元素定位方法
     * @return 返回搜索按钮的元素定位方式
     */
    public WebElement getSearchBtn() {
        return findElement(LocateWay.getLocateWay("searchCarBtn"));
    }

    /**
     * 获取【公司车辆】-清楚按钮的元素定位方法
     * @return 返回清楚按钮的元素定位方法
     */
    public WebElement getClearSearchBtn() {
        return findElement(LocateWay.getLocateWay("clearSearchBtn"));
    }
    /**
     * 获取【公司车辆】右下角统计的搜索条数文本
     * @return 将显示"共X条"的元素返回出去
     */
    public WebElement getTotalText() {
        return findElement(LocateWay.getLocateWay("result_total_text"));
    }
}
