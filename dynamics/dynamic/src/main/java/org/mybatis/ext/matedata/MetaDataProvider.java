/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package org.mybatis.ext.matedata;

import javax.sql.DataSource;

import org.mybatis.ext.data.TableInfo;

public interface MetaDataProvider {

    public TableInfo getTableInfo(String tableName);

    public void setDataSource(DataSource dataSource);
}
