package com.eaglesoft.zjhz.geneator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @作者：huchengjie
 * @时间：2019/10/8 2:06 PM
 * @功能：
 */
public class SqlServerMyGenerator {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("~/dto");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(false);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("eaglesoft");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
//         gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.SQL_SERVER);
        dsc.setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dsc.setUsername("sa");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:sqlserver://172.16.28.23:1433;DatabaseName=slcf");
        dsc.setSchemaName("slcf");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("");
//        pc.setController("controller");
        String baseModule = "demo";
        String jcPackage = "gzl";
        pc.setEntity("com.eaglesoft."+baseModule+".entity." + jcPackage);
        pc.setMapper("com.eaglesoft."+baseModule+"dao." + jcPackage);
        pc.setService("com.eaglesoft."+baseModule+".service." + jcPackage);
        pc.setServiceImpl("com.eaglesoft."+baseModule+".service." + jcPackage + ".impl");
        pc.setXml("com.eaglesoft."+baseModule+"." + jcPackage);
        pc.setController("com.eaglesoft."+baseModule+".web." + jcPackage);

        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
//        strategy.setTablePrefix(new String[]{""});// 此处可以修改为您的表前缀
//        strategy.setNaming(NamingStrategy.removePrefix());// 表名生成策略
//        strategy.setNaming(NamingStrategy.removePrefixAndCamel(""));// 表名生成策略
        strategy.setInclude(new String[]{"anjianbaobei"}); // 需要生成的表
//        strategy.setExclude(new String[]{""}); // 排除生成的表
        // 字段名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        // 自定义实体父类
//         strategy.setSuperEntityClass("hello.entity.BaseEntity");
        // 自定义实体，公共字段
//        strategy.setSuperEntityColumns(new String[]{"id"});
        // 自定义 mapper 父类
//         strategy.setSuperMapperClass("com.fcs.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.fcs.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.fcs.demo.TestServiceImpl");
        // 自定义 controller 父类
//         strategy.setSuperControllerClass("com.risk.controller.BaseController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuliderModel(true);
        mpg.setStrategy(strategy);


        // 执行生成
        mpg.execute();
    }
}
