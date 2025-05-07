package br.com.viasoft.demo_mysql.routing;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ReadOnlyAspect {


    @Before("@annotation(br.com.viasoft.demo_mysql.routing.ReadOnly)")
    public void setReadOnlyDataSource() {
        TransactionSynchronizationManager.setCurrentTransactionReadOnly(true);
    }
}