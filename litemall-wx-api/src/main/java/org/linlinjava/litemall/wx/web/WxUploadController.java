package org.linlinjava.litemall.wx.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.wx.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/wx/upload")
public class WxUploadController {
    private final Log logger = LogFactory.getLog(WxUploadController.class);

    @Autowired
    private PictureService pictureService;

    @PostMapping("/sendPicture")
    private Object sendPicture(@RequestParam(value = "fileName") MultipartFile file){
//        PictureService pictureService = new PictureService();
        int status = pictureService.uploadPicture(file);
        if(status==0) ResponseUtil.fail();
        //返回文件名到前端
        return ResponseUtil.ok("上传成功");
    }


    @GetMapping("/downloadPicture/{imageName}")
    private ResponseEntity<Object> downLoadPicture(@PathVariable("imageName") String imageName){
        byte[] imageData=null;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "image/png");
        try {
//            PictureService pictureService = new PictureService();
            imageData = pictureService.downloadPicture(imageName);
            if(imageData == null){
                return ResponseEntity.ok().body("找不到图片");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().headers(httpHeaders).body(imageData);
    }
}
