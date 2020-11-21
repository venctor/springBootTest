package com.springboot.utils;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author guangxi.dong01@hand-china.com
 * @description 代码生成器
 * @date 2020/11/20
 */
public class MpGenerator {
    private static final String PACK = "D:\\test\\";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hap_dev?useUnicode=true&characterEncoding=UTF-8&rewriteBatchedStatements=true&autoReconnect=true&failOverReadOnly=false&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "hap_dev";
    private static final String PASSWORD = "hap_dev";

    private static String modulesName = "告警误报记录";

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setBaseResultMap(true); //使用resultMap返回结果集
        gc.setIdType(IdType.ASSIGN_ID); //基本的字段映射
        gc.setBaseColumnList(true); //基本的sql片段
        gc.setSwagger2(false); //开启Swagger2
        gc.setFileOverride(true); //是否覆盖已有文件
        gc.setOutputDir(PACK); //文件输出目录
        gc.setAuthor("guangxi.dong@hand-china.com"); //作者名称
        gc.setOpen(false); //是否打开文件目录
        gc.setEnableCache(false); //开启xml二级缓存
        gc.setControllerName("%sController"); //设置controller层bean名称
        gc.setServiceImplName("%sServiceImpl"); //设置server.impl层bean名称
        gc.setServiceName("%sService"); //设置server层bean名称
        gc.setXmlName("%sMapper"); //设置mapper层bean名称
        gc.setMapperName("%sDao"); //设置dao层bean名称
        mpg.setGlobalConfig(gc);
        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DB_URL); //数据库连接
        dsc.setDriverName(DRIVER_NAME); //驱动类
        dsc.setUsername(USERNAME); //数据库用户名
        dsc.setPassword(PASSWORD); //数据库连接密码
        mpg.setDataSource(dsc);
        //包设置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.springboot"); //包名
        pc.setEntity("model"); //pojo包
        pc.setXml("mapper"); //mapper包
        pc.setController("controller"); //controller包
        pc.setService("service"); //service包
        pc.setServiceImpl("service.impl"); //service.impl包
        String models = scanner("模块名");
        pc.setModuleName(models);//父包模块名
        mpg.setPackageInfo(pc);
        //注入初始化配置
        setTemplateMapper(mpg, models);
        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel); //数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); //数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setEntityLombokModel(false); //使用lombok
        strategy.setInclude(scanner("表名")); //需要生成的表 "tbl_dept","tbl_file"
        strategy.setControllerMappingHyphenStyle(true); //驼峰转连字符
        strategy.setEntityColumnConstant(false); //是否生成字段常量,默认:false
        strategy.setRestControllerStyle(true); //生成 @RestController 控制器
        mpg.setStrategy(strategy);
        //模板设置
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        TemplateConfig tc = new TemplateConfig();
        /*tc.setController("/templates/mp/controller.java");
        tc.setService("/templates/mp/service.java");
        tc.setServiceImpl("/templates/mp/serviceImpl.java");
        tc.setEntity("/templates/mp/entity.java");
        tc.setMapper("/templates/mp/mapper.java");
        tc.setXml("/templates/mp/mapper.xml");*/
        tc.setXml(null);
        mpg.setTemplate(tc);
        mpg.execute();

    }

    private static void setTemplateMapper(AutoGenerator mpg, String models) {
        String modulesUp = models.substring(0, 1).toUpperCase() + models.substring(1);
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("modulesName", modulesName);
                map.put("modulesApi",models);
                map.put("modules",modulesUp);
                this.setMap(map);
            }
        };
        mpg.setCfg(cfg);
    }
}
