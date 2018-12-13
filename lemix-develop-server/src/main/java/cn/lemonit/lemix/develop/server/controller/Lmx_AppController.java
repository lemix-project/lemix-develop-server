package cn.lemonit.lemix.develop.server.controller;

import cn.lemonit.lemix.develop.server.entity.Lmx_App;
import cn.lemonit.lemix.develop.server.entity.Result;
import cn.lemonit.lemix.develop.server.service.Lmx_AppService;
import cn.lemonit.lemix.develop.server.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/app")
public class Lmx_AppController {
    @Autowired
    private Lmx_AppService lmx_appService;

    //增,创建应用
    @PutMapping("/create:PUT")
    @ResponseBody
    public Result<Lmx_App> add(@RequestBody Lmx_App lmx_app,BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return ResultUtil.error(10000, false);
        }
        lmx_appService.add(lmx_app);
        return ResultUtil.success();
    }
    //删除应用
    @DeleteMapping("/delete:DELETE")
    public Object delete(@RequestParam(value = "app_id")int app_id,@RequestParam(value = "app_id")int id){
        int a=lmx_appService.selectApp_Id(id);
        if(a==0){
            return ResultUtil.error(10000,false);
        }
        else{
            lmx_appService.delete(app_id);
            return ResultUtil.success();
        }
    }
    //修改应用信息
    @PostMapping("/update:POST")
    public Result<Lmx_App> update(@RequestBody Lmx_App lmx_app,@Valid BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(10000, false);
        }
        lmx_appService.update(lmx_app);
        return ResultUtil.success();
    }
    //上传应用图标
    private static final Logger logger = LoggerFactory.getLogger(Lmx_AppController.class);
    @PostMapping( "/icon:POST")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = "D:\\ideaworkspace\\app_icon\\";
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
    //查看应用图标
    @GetMapping("/icon:GET")
    public Result<Lmx_App> icon(@Valid Lmx_App lmx_app,@RequestParam(value = "app_key")String app_key, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(10000, false);
        }
        return ResultUtil.success(lmx_appService.selectApp_name(app_key));
    }


}
