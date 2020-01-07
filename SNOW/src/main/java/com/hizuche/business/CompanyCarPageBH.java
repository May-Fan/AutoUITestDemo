package com.hizuche.business;

import com.hizuche.base.BaseDriver;
import com.hizuche.handle.CompanyCarPageHandle;

public class CompanyCarPageBH {
    public BaseDriver driver;
    public CompanyCarPageHandle companyCarPageHandle;
    public CompanyCarPageBH(BaseDriver driver) {
        this.driver = driver;
        companyCarPageHandle= new CompanyCarPageHandle(driver);
    }

    /**
     * 封装【公司车辆】的搜索操作
     */
    public void searchCompanyCar() throws Exception {
        companyCarPageHandle.inputCarNo("浙a59");
        companyCarPageHandle.inputVin("LDp");

        companyCarPageHandle.clickGenres();
        companyCarPageHandle.clickGenres_ER30();

        companyCarPageHandle.chooseCarOperate();

        companyCarPageHandle.clickCity();
        companyCarPageHandle.clickCity_zhejiang();
        companyCarPageHandle.clickCity_hangzhou();

        companyCarPageHandle.clickOperateCompany();
        companyCarPageHandle.chooseOperateCompany();
        companyCarPageHandle.chooseCarState();

        companyCarPageHandle.clickSearchBtn();
        Thread.sleep(500);
    }

    /**
     * 调用点击清除按钮的方法，清除已有的搜索结果
     */
    public void clearSearResult() throws InterruptedException {
        companyCarPageHandle.clickClearSearBtn();
        companyCarPageHandle.clickSearchBtn();
        Thread.sleep(500);
    }

    /**
     * 获取到右下角统计搜索条数文本信息中的数字部分
     * @return 返回搜索到的条数
     */
    public String getTotalCount() {
        String totalText = companyCarPageHandle.getTotalText();
        String totalCount = totalText.split(" ")[1];
        return totalCount;
    }
}
