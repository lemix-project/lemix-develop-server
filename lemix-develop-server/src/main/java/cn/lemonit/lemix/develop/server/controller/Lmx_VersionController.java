package cn.lemonit.lemix.develop.server.controller;

import cn.lemonit.lemix.develop.server.entity.Lmx_Version;
import cn.lemonit.lemix.develop.server.entity.Result;
import cn.lemonit.lemix.develop.server.service.Lmx_VersionService;
import cn.lemonit.lemix.develop.server.utils.ResultUtil;
import cn.lemonit.lemix.develop.server.utils.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;

@RestController
@RequestMapping("/version")
public class Lmx_VersionController {
    @Autowired
    private Lmx_VersionService lmx_versionService;
    //增,上传版本
    @PutMapping("/upload:POST")
    public Result<Lmx_Version> add(@RequestBody Lmx_Version lmx_version,BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return ResultUtil.error(10000, false);
        }
        lmx_versionService.add(lmx_version);
        return ResultUtil.success();
    }
    //查所有版本信息
    @GetMapping("/list")
    public Result<Lmx_Version> list(@Valid Lmx_Version lmx_version, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return ResultUtil.error(10000, false);
        }
        return ResultUtil.success(lmx_versionService.list());
    }
    //下载程序包
    @GetMapping("/download:GET")
    public String download(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "hello.txt";// 设置文件名，根据业务需要替换成要下载的文件名
        if (fileName != null) {
            //设置文件路径
            String realPath = "D:\\ideaworkspace\\app_icon\\";
            File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition","attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer,0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}
