/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package org.mapper.dynamic.xml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class VelocityTest {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Properties p = new Properties();
        // 设置输入输出编码类型。和这次说的解决的问题无关
        p.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        p.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
        // 这里加载类路径里的模板而不是文件系统路径里的模板
        p.setProperty("file.resource.loader.class",
                      "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        // 也可以用下面方法指定一个绝对路径，不过这样要求你所有的模板都放在该路径下，是有局限的
        // URL url = VelocityTest.class.getClassLoader().getResource("mytemplate.vm");
        String path = TestPath.class.getResource("/").toString().replaceAll("^file:/", "");
        p.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, path);

        Velocity.init(p);

        VelocityContext context = new VelocityContext();

        // VelocityMapperContext map = new VelocityMapperContext(BaseEntity.class,new TableInfo());
        // context.put("tableName", map.getTableName());
        // context.put("className", map.getClassName());
        // context.put("classShortName", map.getClassShortName());
        // context.put("allProps", map.getAllProps());
        // context.put("allColumns", map.getAllColumns());
        // context.put("resultMaps", map.getResultMaps());

        Template template = null;

        template = Velocity.getTemplate("mytemplate.vm");

        StringWriter sw = new StringWriter();
        FileWriter file = new FileWriter("src/test/java/org/mapper/dynamic/xml/" + "UserMapper.xml");

        template.merge(context, file);
        file.flush();
        template.merge(context, sw);
        System.out.println(sw.toString());
    }

}
