package org.mapper.dynamic.xml;

import java.util.List;

import org.mybatis.ext.utils.ClassUtils;

public class FindClassTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Class<?>> list = ClassUtils.getClasses("org.mybatis.ext.matedata");
        System.out.println(list.size());
    }

}
