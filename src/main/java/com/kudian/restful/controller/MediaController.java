package com.kudian.restful.controller;

import com.kudian.common.utils.StringUtils;
import com.kudian.restful.service.MediaResService;
import com.kudian.restful.vo.media.ResInfoRetVO;
import com.wordnik.swagger.annotations.ApiParam;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/4/17.
 */
@RestController
@RequestMapping("media")
public class MediaController {

    @Autowired
    private MediaResService mediaResService;

    @RequestMapping(value="/upload/{access_token}", method= RequestMethod.POST)
    public ResInfoRetVO upload(@ApiParam(required = true, name = "access_token", value = "操作令牌") @PathVariable String access_token, @RequestParam MultipartFile[] myfiles, HttpServletRequest request) throws IOException {
        //如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解
        //如果想上传多个文件，那么这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解
        //并且上传多个文件时，前台表单中的所有<input type="file"/>的name都应该是myfiles，否则参数里的myfiles无法获取到所有上传的文件
        ResInfoRetVO o = new ResInfoRetVO();
        try {
            String resId = "";
            for (MultipartFile myfile : myfiles) {
                if (myfile.isEmpty()) {
                    System.out.println("文件未上传");
                } else {
                    System.out.println("文件长度: " + myfile.getSize());
                    System.out.println("文件类型: " + myfile.getContentType());
                    System.out.println("文件名称: " + myfile.getName());
                    System.out.println("文件原名: " + myfile.getOriginalFilename());
                    System.out.println("========================================");

                    resId = mediaResService.saveMedia(access_token, myfile.getOriginalFilename(), myfile.getSize());
                    //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中
                    String realPath = request.getSession().getServletContext().getRealPath("/upload");
                    String extName  = getExtName(myfile.getOriginalFilename());

                    String fname = "";
                    if (StringUtils.isNotBlank(extName)) {
                        fname = resId+"."+extName;
                    } else {
                        fname = resId;
                    }
                    //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的
                    FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, fname));
                }
            }

            o.setErrcode(0);
            o.setErrmsg("成功上传");
            o.setResId(resId);
        } catch (Exception e) {
            o.setErrcode(9999);
            o.setErrmsg("上传文件失败");
        }
        return o;
    }

    /**
     * 取得文件后缀
     * @param fileName
     * @return
     */
    private String getExtName(String fileName) {
        final int offset = fileName.lastIndexOf(".");
        if (offset < 0) {
            return "";
        }
        return fileName.substring(offset +1);
    }
}
