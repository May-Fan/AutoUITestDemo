package com.hizuche.page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @program: SNOW
 * @description:
 * @author: May
 * @create: 2020-01-05 13:54
 */
public class lalala {
  @Test
  public void test() {
    String a = new String("heihei");
    String b = a.substring(1,2);
    System.out.println(b);

    a.split("a");

    String jsonStr = "{'name':'fanlilin','age':34,'sex':'female','department':'qa'}";

    //将json字符串转换成json对象
    JSONObject jsonObject = JSON.parseObject(jsonStr);
    Object o = jsonObject.get("name");
    System.out.println(o);
    //将json对象转换成字符串

    //将json字符串转换成数组
    String[] arr = jsonStr.substring(1,jsonStr.length()-1).split(",");
    List<String> list = Arrays.asList(arr);
    for(String str:list) {
      System.out.println(str);
    }

    //数组转集合
    String[] arr2 = {"l","o","v","e"};
    List<String> list2 = Arrays.asList(arr2);

    //集合转数组
    String[] arr3 = list2.toArray(new String[list.size()]);
    
  }
}
