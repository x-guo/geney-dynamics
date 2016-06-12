package org.mapper.dynamic.xml;

import java.io.IOException;

import org.mybatis.ext.mapper.BaseEntity;

public class TestPath {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) {

        String name = BaseEntity.class.getName();
        System.out.println(name);
        System.out.println(BaseEntity.class.getSimpleName());
        String packageName = BaseEntity.class.getPackage().getName();
        String path=packageName.replace("entity", "mapper").replace("dataobject", "mapper");
        System.out.println(path);
        // System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        //
        // System.out.println(TestPath.class.getClassLoader().getResource(""));
        //
        // System.out.println(ClassLoader.getSystemResource(""));
        // System.out.println(TestPath.class.getResource(""));
        // System.out.println(TestPath.class.getResource("/"));
        // // Class文件所在路径
        // System.out.println(new File("/").getAbsolutePath());
        // System.out.println(System.getProperty("user.dir"));
    }

}
