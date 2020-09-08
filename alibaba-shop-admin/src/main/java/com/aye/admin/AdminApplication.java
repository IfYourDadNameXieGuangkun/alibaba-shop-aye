package com.aye.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName AdminApplication
 * @Description admin模块
 * @Author Aye
 * @Date 2020/9/8 17:43
 * @Version 1.0
 */
@SpringBootApplication
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AdminApplication {
    public static void main(String[] args) {

        SpringApplication.run(AdminApplication.class, args);
        System.out.println("*******************************************\n" +
                "* 后台管理                                  *\n" +
                "* 开始                                     *\n" +
                "*                                         *\n" +
                "*******************************************\n" +
                "           _.._        ,-------------------.\n" +
                "        ,'      `.    ( 启动成功！开启学习之旅！      )\n" +
                "       /  __) __` \\    `-,-----------------'\n" +
                "      (  (`-`(-')  ) _.-'\n" +
                "      /)  \\  = /  (\n" +
                "     /'    |--' .  \\\n" +
                "    (  ,---|  `-.)__`\n" +
                "     )(  `-.,--'   _`-.\n" +
                "    '/,'          (  Uu\",\n" +
                "     (_       ,    `/,-' )\n" +
                "     `.__,  : `-'/  /`--'\n" +
                "       |     `--'  |\n" +
                "       `   `-._   /\n" +
                "        \\        (\n" +
                "        /\\ .      \\. \n" +
                "       / |` \\     ,-\\\n" +
                "      /  \\| .)   /   \\\n" +
                "     ( ,'|\\    ,'     :\n" +
                "     | \\,`.`--\"/      }\n" +
                "     `,'    \\  |,'    /\n" +
                "    / \"-._   `-/      |\n" +
                "    \"-.   \"-.,'|     ;\n" +
                "   /        _/[\"---'\"\"]\n" +
                "  :        /  |\"-     '\n" +
                "  '           |      /\n" +
                "              `      |");
    }
}