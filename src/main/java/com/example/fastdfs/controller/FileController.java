/**
 * Project Name: cis-pro
 * FileService Name: FileController
 * Package Name: cn.cxinternet.paas.file.controller
 * Date: 2020/10/26 9:56
 * Author: 方瑞冬
 */
package com.example.fastdfs.controller;

import com.example.fastdfs.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 方瑞冬
 */
@Api(tags = "文件接口")
@RequestMapping("/file")
@RestController
public class FileController {
    @Autowired
    private FileService fileService;

    /**
     * <p>项目名称: cis-pro </p>
     * <p>文件名称: FileController.java </p>
     * <p>方法描述: 文件上传 </p>
     * <p>创建时间: 2020/10/26 10:39 </p>
     *
     * @param multipartFile 上传文件内容
     * @return cn.cxinternet.commons.reult.Result<java.lang.String>
     * @author 方瑞冬
     * @version 1.0
     */
    @ApiOperation(value = "文件上传", notes = "upload")
    @PostMapping("/upload")
//    public Result<String> upload(@RequestParam MultipartFile multipartFile) {
    public String upload(@RequestParam MultipartFile multipartFile) {
//        return ResultUtil.successWithData(fileService.upload(multipartFile));
        return fileService.upload(multipartFile);
    }

//    /**
//     * <p>项目名称: cis-pro </p>
//     * <p>文件名称: FileController.java </p>
//     * <p>方法描述: 通过 ID 查询文件信息 </p>
//     * <p>创建时间: 2020/10/27 9:22 </p>
//     *
//     * @param id 文件 ID
//     * @return cn.cxinternet.commons.reult.Result<cn.cxinternet.paas.file.vo.FileInfoVO>
//     * @author 方瑞冬
//     * @version 1.0
//     */
//    @ApiOperation(value = "通过 ID 查询文件信息", notes = "getFileInfo")
//    @GetMapping("/getFileInfo")
//    public Result<FileInfoVO> getFileInfo(@RequestParam String id) {
//        return ResultUtil.successWithData(BeanCopyUtil.copy(fileService.getFileInfoById(id), FileInfoVO.class));
//    }
//
//    /**
//     * <p>项目名称: cis-pro </p>
//     * <p>文件名称: FileController.java </p>
//     * <p>方法描述: 文件下载 </p>
//     * <p>创建时间: 2020/10/26 10:39 </p>
//     *
//     * @param id 文件 ID
//     * @return cn.cxinternet.commons.reult.Result<java.lang.String>
//     * @author 方瑞冬
//     * @version 1.0
//     */
//    @ApiOperation(value = "文件下载", notes = "download")
//    @GetMapping("/download")
//    public Result<String> download(@RequestParam String id) {
//        fileService.download(id);
//        return ResultUtil.success();
//    }
//
//    /**
//     * <p>项目名称: cis-pro </p>
//     * <p>文件名称: FileController.java </p>
//     * <p>方法描述: 文件删除 </p>
//     * <p>创建时间: 2020/10/26 10:39 </p>
//     *
//     * @param id 文件 ID
//     * @return cn.cxinternet.commons.reult.Result<java.lang.String>
//     * @author 方瑞冬
//     * @version 1.0
//     */
//    @ApiOperation(value = "文件删除", notes = "delete")
//    @DeleteMapping("/delete")
//    public Result<String> delete(@RequestParam String id) {
//        fileService.delete(id);
//        return ResultUtil.success();
//    }
}
