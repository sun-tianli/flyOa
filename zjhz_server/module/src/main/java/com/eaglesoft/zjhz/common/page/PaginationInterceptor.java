//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.eaglesoft.zjhz.common.page;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.MybatisDefaultParameterHandler;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.parser.SqlInfo;
import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.baomidou.mybatisplus.core.toolkit.ExceptionUtils;
import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.handlers.AbstractSqlParserHandler;
import com.baomidou.mybatisplus.extension.plugins.pagination.DialectFactory;
import com.baomidou.mybatisplus.extension.plugins.pagination.DialectModel;
import com.baomidou.mybatisplus.extension.toolkit.JdbcUtils;
import com.baomidou.mybatisplus.extension.toolkit.SqlParserUtils;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Collectors;

@Intercepts({@Signature( type = StatementHandler.class,  method = "prepare", args = {Connection.class, Integer.class})})
public class PaginationInterceptor extends AbstractSqlParserHandler implements Interceptor {
    private ISqlParser sqlParser;
    private boolean overflow = false;
    private String dialectType;
    private String dialectClazz;

    public PaginationInterceptor() {
    }

    public static String concatOrderBy(String originalSql, IPage page, boolean orderBy) {
       /*if (!orderBy || !ArrayUtils.isNotEmpty(page.ascs()) && !ArrayUtils.isNotEmpty(page.descs())) {
            return originalSql;
        } else {
            StringBuilder buildSql = new StringBuilder(originalSql);
            String ascStr = concatOrderBuilder(page.ascs(), " ASC");
            String descStr = concatOrderBuilder(page.descs(), " DESC");
            if (StringUtils.isNotEmpty(ascStr) && StringUtils.isNotEmpty(descStr)) {
                ascStr = ascStr + ", ";
            }

            if (StringUtils.isNotEmpty(ascStr) || StringUtils.isNotEmpty(descStr)) {
                buildSql.append(" ORDER BY ").append(ascStr).append(descStr);
            }

            return buildSql.toString();
        }*/
        if (!orderBy || ArrayUtils.isEmpty(page.ascs())) {
            return originalSql;
        }
        StringBuilder buildSql = new StringBuilder(originalSql);
        String orderby = page.ascs()[0];
        if(StringUtils.isNotEmpty(orderby)){
            buildSql.append(" ORDER BY ").append(orderby);
        }
        return  buildSql.toString();
    }

    private static String concatOrderBuilder(String[] columns, String orderWord) {
        return ArrayUtils.isNotEmpty(columns) ? (String)Arrays.stream(columns).filter(StringUtils::isNotEmpty).map((i) -> {
            return i + orderWord;
        }).collect(Collectors.joining(",")) : "";
    }

    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler)PluginUtils.realTarget(invocation.getTarget());
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        this.sqlParser(metaObject);
        MappedStatement mappedStatement = (MappedStatement)metaObject.getValue("delegate.mappedStatement");
        if (!SqlCommandType.SELECT.equals(mappedStatement.getSqlCommandType())) {
            return invocation.proceed();
        } else {
            BoundSql boundSql = (BoundSql)metaObject.getValue("delegate.boundSql");
            Object paramObj = boundSql.getParameterObject();
            IPage page = null;
            if (paramObj instanceof IPage) {
                page = (IPage)paramObj;
            } else if (paramObj instanceof Map) {
                Iterator var8 = ((Map)paramObj).values().iterator();

                while(var8.hasNext()) {
                    Object arg = var8.next();
                    if (arg instanceof IPage) {
                        page = (IPage)arg;
                        break;
                    }
                }
            }

            if (null != page && page.getSize() >= 0L) {
                String originalSql = boundSql.getSql();
                Connection connection = (Connection)invocation.getArgs()[0];
                DbType dbType = StringUtils.isNotEmpty(this.dialectType) ? DbType.getDbType(this.dialectType) : JdbcUtils.getDbType(connection.getMetaData().getURL());
                boolean orderBy = true;
                if (page.isSearchCount()) {
                    SqlInfo sqlInfo = SqlParserUtils.getOptimizeCountSql(page.optimizeCountSql(), this.sqlParser, originalSql);
                    orderBy = sqlInfo.isOrderBy();
                    this.queryTotal(this.overflow, sqlInfo.getSql(), mappedStatement, boundSql, page, connection);
                    if (page.getTotal() <= 0L) {
                        return invocation.proceed();
                    }
                }

                String buildSql = concatOrderBy(originalSql, page, orderBy);
                DialectModel model = DialectFactory.buildPaginationSql(page, buildSql, dbType, this.dialectClazz);
                Configuration configuration = mappedStatement.getConfiguration();
                List<ParameterMapping> mappings = new ArrayList(boundSql.getParameterMappings());
                Map<String, Object> additionalParameters = (Map)metaObject.getValue("delegate.boundSql.additionalParameters");
                model.consumers(mappings, configuration, additionalParameters);
                metaObject.setValue("delegate.boundSql.sql", model.getDialectSql());
                metaObject.setValue("delegate.boundSql.parameterMappings", mappings);
                return invocation.proceed();
            } else {
                return invocation.proceed();
            }
        }
    }

    protected void queryTotal(boolean overflowCurrent, String sql, MappedStatement mappedStatement, BoundSql boundSql, IPage page, Connection connection) {
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            Throwable var8 = null;

            try {
                DefaultParameterHandler parameterHandler = new MybatisDefaultParameterHandler(mappedStatement, boundSql.getParameterObject(), boundSql);
                parameterHandler.setParameters(statement);
                long total = 0L;
                ResultSet resultSet = statement.executeQuery();
                Throwable var13 = null;

                try {
                    if (resultSet.next()) {
                        total = resultSet.getLong(1);
                    }
                } catch (Throwable var38) {
                    var13 = var38;
                    throw var38;
                } finally {
                    if (resultSet != null) {
                        if (var13 != null) {
                            try {
                                resultSet.close();
                            } catch (Throwable var37) {
                                var13.addSuppressed(var37);
                            }
                        } else {
                            resultSet.close();
                        }
                    }

                }

                page.setTotal(total);
                long pages = page.getPages();
                if (overflowCurrent && page.getCurrent() > pages) {
                    page.setCurrent(1L);
                }
            } catch (Throwable var40) {
                var8 = var40;
                throw var40;
            } finally {
                if (statement != null) {
                    if (var8 != null) {
                        try {
                            statement.close();
                        } catch (Throwable var36) {
                            var8.addSuppressed(var36);
                        }
                    } else {
                        statement.close();
                    }
                }

            }

        } catch (Exception var42) {
            throw ExceptionUtils.mpe("Error: Method queryTotal execution error of sql : \n %s \n", var42, new Object[]{sql});
        }
    }

    public Object plugin(Object target) {
        return target instanceof StatementHandler ? Plugin.wrap(target, this) : target;
    }

    public void setProperties(Properties prop) {
        String dialectType = prop.getProperty("dialectType");
        String dialectClazz = prop.getProperty("dialectClazz");
        if (StringUtils.isNotEmpty(dialectType)) {
            this.dialectType = dialectType;
        }

        if (StringUtils.isNotEmpty(dialectClazz)) {
            this.dialectClazz = dialectClazz;
        }

    }

    public PaginationInterceptor setSqlParser(final ISqlParser sqlParser) {
        this.sqlParser = sqlParser;
        return this;
    }

    public PaginationInterceptor setOverflow(final boolean overflow) {
        this.overflow = overflow;
        return this;
    }

    public PaginationInterceptor setDialectType(final String dialectType) {
        this.dialectType = dialectType;
        return this;
    }

    public PaginationInterceptor setDialectClazz(final String dialectClazz) {
        this.dialectClazz = dialectClazz;
        return this;
    }
}
