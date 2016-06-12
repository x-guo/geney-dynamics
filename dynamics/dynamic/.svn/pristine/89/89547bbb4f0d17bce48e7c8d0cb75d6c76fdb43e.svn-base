package org.mybatis.ext.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({ TYPE })
@Retention(RUNTIME)
public @interface Module {

	/**
	 * 
	 * @return the module name or ""
	 */
	String name() default "";
}
