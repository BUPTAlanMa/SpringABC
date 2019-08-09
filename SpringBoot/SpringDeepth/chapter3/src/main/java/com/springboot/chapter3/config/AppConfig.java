package com.springboot.chapter3.config;

import javax.sql.DataSource;
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

@Configuration
@ComponentScan(value = "com.springboot.chapter3.*",
                excludeFilters = {@Filter(classes = {Service.class})}) //扫描类AppConfig所在包及自子包
public class AppConfig {
	@Bean(name = "dataSource", destroyMethod = "close")
	@Conditional(DatabaseConditional.class)
	/**
	 * @Conditional 根据条件来决定是否装配Bean
	 * 用在连接数据库时，如果漏掉一些数据库连接配置，导致连接失败时，如果不加管控，IoC仍进行数据库资源装配，会导致抛出异常
	 * 为了避免这种情况，可使用@Conditional 关键字，配合另外一个接口Condition使用，要写一个类，实现Condition接口，
	 * 同时给出matches方法，根据matches方法返回的boolean值决定是否装配Bean
	 */
	public DataSource getDataSource(
			@Value("${database.driverName}") String driver,
			@Value("${database.url}") String url,
			@Value("${database.username}") String username,
			@Value("${database.password}") String password
			) {
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