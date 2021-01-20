package cn.tedu;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DBUtil {
    private static   DruidDataSource dds;
    static {
        //创建数据库连接池对象,
         dds =new DruidDataSource();

        Properties p =new Properties();
        InputStream ips = DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            p.load(ips);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置数据库连接信息
        dds.setDriverClassName(p.getProperty("db.driver"));
        dds.setUrl(p.getProperty("db.url"));
        dds.setUsername(p.getProperty("db.username"));
        dds.setPassword(p.getProperty("db.password"));

        //设置初始连接数量
        dds.setInitialSize(Integer.parseInt(p.getProperty("db.initialSize")));
        //设置最大连接数
        dds.setMaxActive(Integer.parseInt(p.getProperty("db.maxActive")));
        //获取连接

    }


    public  static Connection getConn() throws Exception{
        //创建数据库连接池对象,
        Connection conn=dds.getConnection();
        System.out.println(conn);
        return  conn;
    }

}
