package org.linlinjava.litemall.db.service;

import org.apache.ibatis.annotations.Mapper;
import org.linlinjava.litemall.db.dao.LitemallUserPicMapper;
import org.linlinjava.litemall.db.domain.LitemallStorage;
import org.linlinjava.litemall.db.domain.LitemallUserPic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jchen
 * @date 2022/11/10 15:39
 */
@Service
public class LitemallUserPicService {
    @Resource
    private LitemallUserPicMapper litemallUserPicMapper;
    public boolean store(LitemallStorage storage,Integer userId){
        LitemallUserPic litemallUserPic = new LitemallUserPic();
        litemallUserPic.setPicUrl(storage.getUrl());
        litemallUserPic.setUserId(userId);
        litemallUserPic.setType(1);
        int insert = litemallUserPicMapper.insert(litemallUserPic);
        return insert == 1;
    }
}
