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
public class MysqlMyGenerator {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();

        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setSwagger2(true); // 开启 swagger 注释
        gc.setAuthor("eaglesoft");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setOutputDir("E:\\develop/xtgl_server/zjhz_server");

//         gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://172.16.28.27:3306/officeflyv8?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC");
        dsc.setSchemaName("demo");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("");
//        pc.setController("controller");
        String baseModule = "zjhz";
//        String jcPackage = "jcxx_yh";
        String jcPackage = "jc";
//        pc.setEntity("com.eaglesoft."+baseModule+".entity." + jcPackage);
        pc.setEntity("module.src.main.java.com.eaglesoft."+baseModule+".entity." + jcPackage);
        pc.setMapper("module.src.main.java.com.eaglesoft."+baseModule+".dao." + jcPackage);
        pc.setService("module.src.main.java.com.eaglesoft."+baseModule+".service." + jcPackage);
        pc.setServiceImpl("module.src.main.java.com.eaglesoft."+baseModule+".service." + jcPackage + ".impl");
        pc.setXml("module.src.main.resources.mapper."+ jcPackage);
        pc.setController("web.src.main.java.com.eaglesoft.zjhz.web.jc");

        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
//        strategy.setTablePrefix(new String[]{""});// 此处可以修改为您的表前缀
//        strategy.setNaming(NamingStrategy.removePrefix());// 表名生成策略
//        strategy.setNaming(NamingStrategy.removePrefixAndCamel(""));// 表名生成策略



//        strategy.setInclude(new String[]{"jcxx_yh"}); // 需要生成的表
        strategy.setInclude(new String[]{"xt_czrz"});


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
        strategy.setSuperControllerClass("com.eaglesoft."+baseModule+".web.base.BaseController");
        strategy.setRestControllerStyle(true);
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




//    public static void main(String[] args) {
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//
//        gc.setFileOverride(true);
//        gc.setActiveRecord(true);
//        gc.setEnableCache(false);// XML 二级缓存
//        gc.setBaseResultMap(true);// XML ResultMap
//        gc.setBaseColumnList(true);// XML columList
//        gc.setSwagger2(true); // 开启 swagger 注释
//        gc.setAuthor("eaglesoft");
//
//        // 自定义文件命名，注意 %s 会自动填充表实体属性！
//        gc.setMapperName("%sMapper");
//        gc.setXmlName("%sMapper");
//        gc.setServiceName("I%sService");
//        gc.setServiceImplName("%sServiceImpl");
//        gc.setOutputDir("/xtgl_server/zjhz_server");
//
////         gc.setControllerName("%sController");
//        mpg.setGlobalConfig(gc);
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setDbType(DbType.MYSQL);
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("root");
//        dsc.setUrl("jdbc:mysql://172.16.28.27:3306/officeflyv8?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC");
//        dsc.setSchemaName("demo");
//        mpg.setDataSource(dsc);
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setParent("");
////        pc.setController("controller");
//        String baseModule = "zjhz";
//        String jcPackage = "jc_bmgl";
//        pc.setEntity("com.eaglesoft."+baseModule+".entity." + jcPackage);
//        pc.setMapper("com.eaglesoft."+baseModule+".dao." + jcPackage);
//        pc.setService("com.eaglesoft."+baseModule+".service." + jcPackage);
//        pc.setServiceImpl("com.eaglesoft."+baseModule+".service." + jcPackage + ".impl");
//        pc.setXml("com.eaglesoft."+baseModule+".dao." + jcPackage);
//        pc.setController("com.eaglesoft."+baseModule+".web." + jcPackage);
//
//        mpg.setPackageInfo(pc);
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
////        strategy.setTablePrefix(new String[]{""});// 此处可以修改为您的表前缀
////        strategy.setNaming(NamingStrategy.removePrefix());// 表名生成策略
////        strategy.setNaming(NamingStrategy.removePrefixAndCamel(""));// 表名生成策略
//        strategy.setInclude(new String[]{"jc_bmgl"}); // 需要生成的表
////        strategy.setExclude(new String[]{""}); // 排除生成的表
//        // 字段名生成策略
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setEntityLombokModel(true);
//        // 自定义实体父类
////         strategy.setSuperEntityClass("hello.entity.BaseEntity");
//        // 自定义实体，公共字段
////        strategy.setSuperEntityColumns(new String[]{"id"});
//        // 自定义 mapper 父类
////         strategy.setSuperMapperClass("com.fcs.demo.TestMapper");
//        // 自定义 service 父类
//        // strategy.setSuperServiceClass("com.fcs.demo.TestService");
//        // 自定义 service 实现类父类
//        // strategy.setSuperServiceImplClass("com.fcs.demo.TestServiceImpl");
//        // 自定义 controller 父类
//        strategy.setSuperControllerClass("com.eaglesoft."+baseModule+".web.base.BaseController");
//        strategy.setRestControllerStyle(true);
//        // 【实体】是否生成字段常量（默认 false）
//        // public static final String ID = "test_id";
//        // strategy.setEntityColumnConstant(true);
//        // 【实体】是否为构建者模型（默认 false）
//        // public User setName(String name) {this.name = name; return this;}
//        // strategy.setEntityBuliderModel(true);
//        mpg.setStrategy(strategy);
//
//
//        // 执行生成
//        mpg.execute();
//    }
}
