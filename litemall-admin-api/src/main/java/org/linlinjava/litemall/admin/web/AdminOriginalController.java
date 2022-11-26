package org.linlinjava.litemall.admin.web;

import com.qiniu.util.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.linlinjava.litemall.admin.annotation.RequiresPermissionsDesc;
import org.linlinjava.litemall.admin.vo.OriginalVo;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.core.validator.Order;
import org.linlinjava.litemall.core.validator.Sort;
import org.linlinjava.litemall.db.domain.LitemallOriginal;
import org.linlinjava.litemall.db.service.LitemallOriginalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/original")
@Validated
public class AdminOriginalController {
    private final Log logger = LogFactory.getLog(AdminOriginalController.class);

    @Autowired
    private LitemallOriginalService originalService;

    @RequiresPermissions("admin:original:list")
    @RequiresPermissionsDesc(menu = {"图片管理","原图"},button = "查询")
    @GetMapping("/list")
    public Object list(Integer oriId, Integer userId,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order){
            List<LitemallOriginal> originalList=originalService.querySelective(oriId, userId, page, limit, sort, order);
            return ResponseUtil.okList(originalList);
    }

    @RequiresPermissions("admin:original:create")
    @RequiresPermissionsDesc(menu = {"图片管理", "原图"}, button = "添加")
    @PostMapping("/create")
    public Object create(@RequestBody LitemallOriginal original) {
        Object error = validate(original);
        if (error != null) {
            return error;
        }
        originalService.add(original);
        return ResponseUtil.ok(original);
    }

    @RequiresPermissions("admin:original:delete")
    @RequiresPermissionsDesc(menu = {"图片管理","原图"},button = "删除")
    @PostMapping("/delete")
    public Object delete(@RequestBody LitemallOriginal original){
        System.out.print(original.getOriId());
        Integer ori_id=original.getOriId();
        if(ori_id==null){
            return ResponseUtil.badArgument();
        }
        originalService.deleteById(ori_id);
        return ResponseUtil.ok();
    }

    @RequiresPermissions("admin:original:update")
    @RequiresPermissionsDesc(menu = {"图片管理","原图"},button = "编辑")
    @PostMapping("/update")
    public Object update(@RequestBody LitemallOriginal original){
        Object error=validate(original);
        if (error != null) {
            return error;
        }

        if(originalService.updateById(original)==0) {
            return ResponseUtil.updatedDataFailed();
        }
        return ResponseUtil.ok();
    }

    private Object validate(LitemallOriginal original){
        Integer ori_id=original.getOriId();
        String ori_url=original.getOriUrl();
        Integer user_id=original.getUserId();
        if(ori_id==null){
            return ResponseUtil.badArgument();
        }
        if(user_id==null){
            return ResponseUtil.badArgument();
        }
        if(StringUtils.isNullOrEmpty(ori_url)){
            return ResponseUtil.badArgument();
        }
        return null;
    }
}
