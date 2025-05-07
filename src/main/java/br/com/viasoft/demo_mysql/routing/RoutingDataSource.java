package br.com.viasoft.demo_mysql.routing;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        // Verifica se a transação está marcada como somente leitura
        if (TransactionSynchronizationManager.isCurrentTransactionReadOnly()) {
            return DataSourceConfig.DataSourceType.REPLICA;  // Use a réplica para leituras
        }
        return DataSourceConfig.DataSourceType.MASTER;  // Use a master para gravações
    }
}