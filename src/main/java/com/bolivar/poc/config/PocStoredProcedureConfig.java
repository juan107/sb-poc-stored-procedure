package com.bolivar.poc.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@MapperScan(value = { "com.bolivar.poc.repository" }, sqlSessionFactoryRef = "sqlSessionFactory")
public class PocStoredProcedureConfig {

	@Value("${application.external.db.username}")
	private String dbUser;
	@Value("${application.external.db.password}")
	private String dbPassword;
	@Value("${application.external.db.host}")
	private String dbHost;
	@Value("${application.external.db.database}")
	private String dbDatabase;
	@Value("${application.external.db.port}")
	private int dbPort;
	@Value("${application.external.db.driver}")
	private String dbDriver;
	@Value("${application.external.config.mapper-batis-location}")
	private String mapperLocation;

	@Bean(name = "dataSource")
	@Primary
	public DataSource dataSource() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setServerName(dbHost);
		dataSource.setPortNumber(dbPort);
		dataSource.setDriverType(dbDriver);
		dataSource.setUser(dbUser);
		dataSource.setPassword(dbPassword);
		dataSource.setDatabaseName(dbDatabase);
		return dataSource;
	}

	@Bean(name = "sqlSessionFactory")
	@Primary
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		PathMatchingResourcePatternResolver pathM3R = new PathMatchingResourcePatternResolver();
		factoryBean.setMapperLocations(pathM3R.getResources("classpath*:config/mybatis/*.xml"));
		return factoryBean.getObject();
	}
}
