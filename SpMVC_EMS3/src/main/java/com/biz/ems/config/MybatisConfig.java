package com.biz.ems.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.biz.ems.mapper")
@EnableTransactionManagement
public class MybatisConfig {

	// datasource, sqlSessionFactoryBean,transactionManager(sqlSessionTemplate)

	@Bean
	public DataSource ds() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("user1");
		ds.setPassword("user1");
		return ds;
	}

	@Bean
	public SqlSessionFactoryBean sessionFactory() {

		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(this.ds());
		// bean.setMapperLocations("");
		bean.setTypeAliasesPackage("com.biz.ems.model");

		org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
		config.setJdbcTypeForNull(JdbcType.VARCHAR);
		bean.setConfiguration(config);

		return bean;
	}

	public PlatformTransactionManager transactionManager() {

		DataSourceTransactionManager trans = new DataSourceTransactionManager();
		trans.setDataSource(this.ds());
		return trans;

	}

}
