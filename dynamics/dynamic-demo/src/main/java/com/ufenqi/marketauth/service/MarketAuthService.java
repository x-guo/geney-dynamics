package com.ufenqi.marketauth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cheng.common.service.query.ResultPage;
import com.cheng.common.service.validate.ValidationService;
import com.ufenqi.marketauth.dal.entity.MarketAuthDO;
import com.ufenqi.marketauth.dal.mapper.MarketAuthMapper;
import com.ufenqi.marketauth.dal.param.MarketAuthParam;
import com.ufenqi.marketauth.service.query.MarketAuthQuery;

@Service
public class MarketAuthService {

    @Resource
    private MarketAuthMapper mapper;
    @Resource
    private ValidationService validationService;

    public ResultPage<MarketAuthDO> findPage(MarketAuthQuery query) {
        validationService.validate(query);
        MarketAuthParam param = new MarketAuthParam();
        BeanUtils.copyProperties(query, param);
        List<MarketAuthDO> list = mapper.findList(param);

        return new ResultPage<MarketAuthDO>(list, query);
    }

    public List<MarketAuthDO> findAll() {
        return mapper.findAll();
    }

    public MarketAuthDO findOne(Long id) {
        return mapper.findOne(id);
    }

    public void create(MarketAuthDO entity) {
        validationService.validate(entity);
        mapper.insert(entity);
    }

    public void update(MarketAuthDO entity) {
        validationService.validate(entity);
        MarketAuthDO oldEntity=mapper.findOne(entity.getId());
        mergeEntity(entity,oldEntity);
        mapper.update(oldEntity);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }
    
    private void mergeEntity(MarketAuthDO source,MarketAuthDO target){
    	//TODO 
    }
}
