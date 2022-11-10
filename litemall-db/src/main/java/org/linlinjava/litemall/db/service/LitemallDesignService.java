package org.linlinjava.litemall.db.service;

import org.linlinjava.litemall.db.dao.LitemallDesignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jchen
 * @date 2022/11/10 15:40
 */
@Service
public class LitemallDesignService {
    @Autowired
    private LitemallDesignMapper litemallDesignMapper;
}
