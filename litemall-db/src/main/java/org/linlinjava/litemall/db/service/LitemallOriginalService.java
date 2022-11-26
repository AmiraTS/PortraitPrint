package org.linlinjava.litemall.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.litemall.db.dao.LitemallOriginalMapper;
import org.linlinjava.litemall.db.domain.LitemallOriginal;
import org.linlinjava.litemall.db.domain.LitemallOriginal.Column;
import org.linlinjava.litemall.db.domain.LitemallOriginalExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LitemallOriginalService {
    @Resource
    private LitemallOriginalMapper originalMapper;
    Column[] columns = new Column[]{Column.oriId, Column.oriUrl, Column.desId, Column.desUrl, Column.userId};

    public List<LitemallOriginal> query(Integer page, Integer limit, String sort, String order) {
        LitemallOriginalExample example = new LitemallOriginalExample();
        example.or().andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, limit);
        return originalMapper.selectByExampleSelective(example, columns);
    }

    public List<LitemallOriginal> query(Integer page, Integer limit) {
        return query(page, limit, null, null);
    }

    public LitemallOriginal findById(Integer id) {
        return originalMapper.selectByPrimaryKey(id);
    }

    public List<LitemallOriginal> querySelective(Integer oriId, Integer userId, Integer page, Integer size, String sort, String order) {
        LitemallOriginalExample example = new LitemallOriginalExample();
        LitemallOriginalExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(oriId)) {
            criteria.andOriIdEqualTo(oriId);
        }
        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(userId);
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return originalMapper.selectByExample(example);
    }

    public int updateById(LitemallOriginal original) {
        original.setUpdateTime(LocalDateTime.now());
        return originalMapper.updateByPrimaryKeySelective(original);
    }

    public void deleteById(Integer ori_id) {
        originalMapper.logicalDeleteByPrimaryKey(ori_id);
    }

    public void add(LitemallOriginal original) {
        original.setAddTime(LocalDateTime.now());
        original.setUpdateTime(LocalDateTime.now());
        originalMapper.insertSelective(original);
    }

    public List<LitemallOriginal> all() {
        LitemallOriginalExample example = new LitemallOriginalExample();
        example.or().andDeletedEqualTo(false);
        return originalMapper.selectByExample(example);
    }

}
