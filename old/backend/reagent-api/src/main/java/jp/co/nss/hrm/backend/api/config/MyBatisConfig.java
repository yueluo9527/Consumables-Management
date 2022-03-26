package jp.co.nss.hrm.backend.api.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 * Created by macro on 2019/4/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"jp.co.nss.hrm.backend.mapper","jp.co.nss.hrm.backend.api.dao"})
public class MyBatisConfig {
}
