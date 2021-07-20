package com.lagou.transfer.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.lagou.transfer.factory.BeanFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;


public class DruidUtils {

    private DruidUtils(){
    }

    private static DruidDataSource druidDataSource = new DruidDataSource();


    static {
        Properties properties = readPropertiesFile();
        druidDataSource.setDriverClassName(properties.getProperty("jdbc.driver-class"));
        druidDataSource.setUrl(properties.getProperty("jdbc.url"));
        druidDataSource.setUsername(properties.getProperty("jdbc.username"));
        druidDataSource.setPassword(properties.getProperty("jdbc.password"));
    }

    public static DruidDataSource getInstance() {
        return druidDataSource;
    }

    /**
     * 通过配置文件名读取内容
     */
    private static Properties readPropertiesFile() {
        Properties pros = new Properties();
        try {
            InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("application.properties");
            pros.load(new InputStreamReader(resourceAsStream, "UTF-8"));
            return pros;
        } catch (Exception e) {
            System.err.println("读取配置文件出现异常，读取失败");
            e.printStackTrace();
        }
        return null;
    }

}
