package org.linlinjava.litemall.db.service;

import org.linlinjava.litemall.db.dao.LitemallOrderPicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jchen
 * @date 2022/11/10 15:40
 */
@Service
public class LitemallOrderPicService {
    @Autowired
    private LitemallOrderPicMapper litemallOrderPicMapper;
}
