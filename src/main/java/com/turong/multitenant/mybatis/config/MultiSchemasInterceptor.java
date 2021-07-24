package com.turong.multitenant.mybatis.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.Connection;

@Intercepts(
        @Signature(
                type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class, Integer.class}
        )
)
@Slf4j
public class MultiSchemasInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        Connection con = (Connection) args[0];
        con.setCatalog(AppContextHolder.getTenant()); // mysql
        log.debug("Connection Schema={}", con.getCatalog());
        return invocation.proceed();
    }

}
