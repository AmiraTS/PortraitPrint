package org.linlinjava.litemall.wx.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

@Service
public class PictureService {

    public int uploadPicture(MultipartFile file){
        if(file==null) return 0;
        int status = 1;
        // 图片保存路径
        String basePath = "litemall-wx-api\\src\\main\\java\\org\\linlinjava\\litemall\\wx\\userPicture\\";
        String oldFileName = file.getOriginalFilename();
        String suffix = oldFileName.substring(oldFileName.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString() + suffix;
        File dir = new File(basePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try {
            //将临时文件转存到指定位置
            file.transferTo(new File(dir.getAbsolutePath()+"\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
            status = 0;
        }
        return status;
    }

    public byte[] downloadPicture(String imageName) throws IOException {
        String imageUrl = "litemall-wx-api\\src\\main\\java\\org\\linlinjava\\litemall\\wx\\userPicture\\"+imageName;
        File file = new File(imageUrl);
        if(!file.exists()) return null;
        byte[] bytes = new byte[1024];
        int b;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            InputStream bufferedReader = new FileInputStream(imageUrl);
            while((b = bufferedReader.read(bytes))!=-1){
                stream.write(bytes,0,b);
            }
            return stream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            stream.close();
        }
        return null;
    }
}
