/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package org.mybatis.ext.mapper;

import java.io.Serializable;
import java.util.List;

import org.mybatis.ext.query.param.Pageable;

public interface CrudMapper<T extends Serializable, ID extends Serializable> {

    long insert(T entity);

    int update(T entity);

    T findOne(ID id);

    List<T> findAll();

    long count();

    List<T> findByIds(Iterable<ID> ids);

    List<T> findList(Pageable<T> pageable);

    long countList(Pageable<T> pageable);

    int delete(ID id);

    int deleteByIds(Iterable<ID> ids);

}
