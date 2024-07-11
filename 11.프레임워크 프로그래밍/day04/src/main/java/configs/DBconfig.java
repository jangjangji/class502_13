package configs;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement//@EnableTransactionManagement 애노테이션을 사용하면 스프링은 자동으로 트랜잭션 프록시를 생성하여, @Transactional 애노테이션이 있는 메서드 호출을 가로채고 트랜잭션을 시작하거나 종료합니다.
@MapperScan("mappers")
@Configuration // 설정 클래스
public class DBconfig {
    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        DataSource ds = new DataSource();
        /* DB 연결 설정 S*/
        //데이터베이스 드라이브 설정
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        //스키마 설정
        ds.setUsername("SPRING");
        ds.setPassword("oracle");
        /* DB 연결 설정 E*/

        /* 커넥션 풀 설정 S*/
        ds.setTestWhileIdle(true);//유휴 객체 유효성 체크
        ds.setInitialSize(2);
        ds.setMaxActive(10);//최대 활성화 개수
        ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
        //10초에 한번씩 연결객체가 연결 되어있는지 체크

        ds.setMinEvictableIdleTimeMillis(36 * 1000); //유휴 객체가 살아있는 시간 설정(1분)
        //1분후에 소멸되고 다시 만들어진다.

        /* 커넥션 풀 설정 E*/
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){ //얘를 통해서 쿼리 수행함
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource());

        return tm;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        return sqlSessionFactory;
    }
}
