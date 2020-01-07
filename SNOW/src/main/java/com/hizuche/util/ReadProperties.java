package com.hizuche.util;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ReadProperties类中，定义了一个带参(路径)的构造方法；
 *                     在定义的reaProperty方法中，根据路径读取配置文件并寄放在缓存中，读取完成后返回；
 *                     在定义的getProperty方法中，根据传入的key参数，在配置文件中查找对应的值并返回出去；
 */
public class ReadProperties {
    private String propPath;
    private Properties properties;

    /*在构造函数中传入配置文件路径*/
    public ReadProperties(String propPath_1) {
        this.propPath = propPath_1;
        this.properties = readProperty();
    }

    /*根据路径读取配置文件并返回*/
    private Properties readProperty() {
        properties = new Properties();
        try {
            InputStream readPro = new FileInputStream(propPath);//读取配置文件
            BufferedInputStream in = new BufferedInputStream(readPro);//将读取出来的配置文件放到缓存中
            properties.load(in);//使用load方法读取配置文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties; //prop读取配置文件完毕，将其返回出去
    }

    /**
     * 根据传入的键名，获取到对应值
     * @param key 传入的配置文件中的键名
     * @return 返回对应的值
     */
    public String getProperty(String key) {
        if (properties.containsKey(key)) {
            String value = properties.getProperty(key);
            return value;
        } else {
            System.out.println("没有在配置文件中找到" + key + "键的值！");
            return "";
        }
    }

    /**
     * 根据传入的键名、值，重新设置配置文件中的值
     * @param key 传入的键名
     * @param value 重置的值
     */
    public void writeProperty(String key, String value) {
        if (properties.containsKey(key)) {
            properties.setProperty(key, value);
        }
    }
}
