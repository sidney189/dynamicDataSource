package com.example.dynamicdatasource.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.example.dynamicdatasource.enums.DbTypeEnum;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan("com.example.dynamicdatasource.*.dao")
public class DataSourceConfig {

    @Bean(name = "t19DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.t100019")
    public DataSource t19DataSource() {

        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "t49DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.t100049")
    public DataSource t49DataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "t138DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.t100138")
    public DataSource t138DataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 动态数据源配置
     *
     * @return
     */
    @Bean("multipleDataSource")
    @Primary
    public DynamicDataSource multipleDataSource(@Qualifier("t19DataSource") final DataSource t19DataSource,
                                                @Qualifier("t49DataSource") final DataSource t49DataSource,
                                                @Qualifier("t138DataSource") final DataSource t138DataSource) {

        final DynamicDataSource dynamicDataSource = new DynamicDataSource();
        final Map<Object, Object> targetDataSources = new HashMap<>(3);
        targetDataSources.put(DbTypeEnum.T100019.getValue(), t19DataSource);
        targetDataSources.put(DbTypeEnum.T100049.getValue(), t49DataSource);
        targetDataSources.put(DbTypeEnum.T100138.getValue(), t138DataSource);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(t19DataSource);
        return dynamicDataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(multipleDataSource(t19DataSource(), t49DataSource(), t138DataSource()));
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*/*Mapper.xml"));
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("transactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("multipleDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
