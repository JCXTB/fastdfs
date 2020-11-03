/**
 * Project Name: cis-pro
 * FileService Name: FileService
 * Package Name: cn.cxinternet.paas.file.service
 * Date: 2020/10/26 10:01
 * Author: 方瑞冬
 */
package com.example.fastdfs.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 方瑞冬
 */
public interface FileService {
    /**
     * <p>项目名称: cis-pro </p>
     * <p>文件名称: FileService.java </p>
     * <p>方法描述: 文件上传 </p>
     * <p>创建时间: 2020/10/26 10:40 </p>
     *
     * @param multipartFile 上传文件内容
     * @return java.lang.String
     * @author 方瑞冬
     * @version 1.0
     */
    String upload(MultipartFile multipartFile);

//    /**
//     * <p>项目名称: cis-pro </p>
//     * <p>文件名称: FileService.java </p>
//     * <p>方法描述: 通过 ID 查询文件信息 </p>
//     * <p>创建时间: 2020/10/27 9:20 </p>
//     *
//     * @param id 文件 ID
//     * @return cn.cxinternet.paas.file.entity.File
//     * @author 方瑞冬
//     * @version 1.0
//     */
//    File getFileInfoById(String id);
//
//    /**
//     * <p>项目名称: cis-pro </p>
//     * <p>文件名称: FileService.java </p>
//     * <p>方法描述: 文件下载 </p>
//     * <p>创建时间: 2020/10/26 10:40 </p>
//     *
//     * @param id 文件 ID
//     * @return void
//     * @author 方瑞冬
//     * @version 1.0
//     */
//    void download(String id);
//
//    /**
//     * <p>项目名称: cis-pro </p>
//     * <p>文件名称: FileService.java </p>
//     * <p>方法描述: 文件删除 </p>
//     * <p>创建时间: 2020/10/26 10:41 </p>
//     *
//     * @param id 文件 ID
//     * @return void
//     * @author 方瑞冬
//     * @version 1.0
//     */
//    void delete(String id);
}
