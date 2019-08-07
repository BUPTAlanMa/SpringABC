package com.springboot.chapter3.config;

import com.springboot.chapter3.condition.DatabaseConditional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.util.Properties;
// 根据配置文件AppConfig java配置文件装配bean
/*
@Configuration
public class AppConfig {
    @Bean(name = "user")
    public User initUser() {
        User user = new User();
        user.setId(1L);
        user.setUserName("user_name_1");
        user.setNote("note_1");
        return user;
    }
}
*/

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Configuration
@ComponentScan(value = "com.springboot.chapter3.*",
                excludeFilters = {@Filter(classes = {Service.class})}) //扫描类AppConfig所在包及自子包
public class AppConfig {

//    @Bean(name = "dataSource", destroyMethod = "close")
    @Bean(name = "dataSource")
//	@Conditional(DatabaseConditional.class)
	public DataSource getDataSource() {
//			@Value("${database.driverName}") String driver,
//			@Value("${database.url}") String url,
//			@Value("${database.username}") String username,
//			@Value("${database.password}") String password
//			) {
		Properties props = new Properties();
		props.setProperty("driver", "com.mysql.jdbc.Driver");
		props.setProperty("url", "jdbc:mysql://localhost:3306/chapter3");
		props.setProperty("username", "root");
		props.setProperty("password", "admin");
		DataSource dataSource = null;
		try {
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}

}