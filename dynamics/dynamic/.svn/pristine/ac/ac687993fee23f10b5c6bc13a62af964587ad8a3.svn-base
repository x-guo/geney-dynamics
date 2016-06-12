package org.mybatis.ext.model;

import org.mybatis.ext.annotation.Module;

public class ModuleModel {
	private String moduleName;

	public ModuleModel(Class<?> entity) {
		Module module = entity.getAnnotation(Module.class);
		this.moduleName = module.name();
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

}
