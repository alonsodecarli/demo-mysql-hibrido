package br.com.viasoft.demo_mysql.routing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "br.com.viasoft.demo_mysql.produto.repository")
public class DataSourceConfig {

    @Value("${spring.datasource.master.url}")
    private String masterUrl;

    @Value("${spring.datasource.master.username}")
    private String masterUsername;

    @Value("${spring.datasource.master.password}")
    private String masterPassword;

    @Value("${spring.datasource.replica.url}")
    private String replicaUrl;

    @Value("${spring.datasource.replica.username}")
    private String replicaUsername;

    @Value("${spring.datasource.replica.password}")
    private String replicaPassword;

    @Primary
    @Bean
    public DataSource dataSource() {
        RoutingDataSource routingDataSource = new RoutingDataSource();
        routingDataSource.setDefaultTargetDataSource(masterDataSource());  // Mestre como padrão
        routingDataSource.setTargetDataSources(targetDataSources());  // Fontes de dados para leitura e escrita
        return routingDataSource;
    }

    @Bean
    public DataSource masterDataSource() {
        return DataSourceBuilder.create()
                .url(masterUrl)
                .username(masterUsername)
                .password(masterPassword)
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    @Bean
    public DataSource replicaDataSource() {
        return DataSourceBuilder.create()
                .url(replicaUrl)
                .username(replicaUsername)
                .password(replicaPassword)
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    // Definindo as fontes de dados
    private Map<Object, Object> targetDataSources() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.MASTER, masterDataSource());
        targetDataSources.put(DataSourceType.REPLICA, replicaDataSource());
        return targetDataSources;
    }

    // Criando enum para identificação do tipo de fonte de dados
    public enum DataSourceType {
        MASTER, REPLICA
    }
}
