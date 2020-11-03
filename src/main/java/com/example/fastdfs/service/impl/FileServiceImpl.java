/**
 * Project Name: cis-pro
 * File Name: FileServiceImpl
 * Package Name: cn.cxinternet.paas.file.service.impl
 * Date: 2020/10/26 10:02
 * Author: 方瑞冬
 */
package com.example.fastdfs.service.impl;

import com.example.fastdfs.config.FastdfsConfig;
import com.example.fastdfs.entity.File;
import com.example.fastdfs.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 方瑞冬
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {
    public static final String SPLIT_GROUP_NAME_AND_FILENAME_SEPERATOR = "/";

    @Autowired
    private FastdfsConfig fastdfsConfig;

//    @Autowired
//    private LoginApi loginApi;
//
//    @Autowired
//    private FileDAO fileDao;

    @Autowired
    private HttpServletResponse httpServletResponse;

    /**
     * <p>项目名称: cis-pro </p>
     * <p>文件名称: FileServiceImpl.java </p>
     * <p>方法描述: 文件服务器连接初始化 </p>
     * <p>创建时间: 2020/10/26 10:41 </p>
     *
     * @return void
     * @author 方瑞冬
     * @version 1.0
     */
    private void initFdfsConfig() {
        try {
            ClientGlobal.initByTrackers(fastdfsConfig.getTrackerServers());
            ClientGlobal.setG_connect_timeout(fastdfsConfig.getConnectTimeoutInSeconds());
            ClientGlobal.setG_network_timeout(fastdfsConfig.getNetworkTimeoutInSeconds());
            ClientGlobal.setG_charset(fastdfsConfig.getCharset());
        } catch (Exception e) {
            if (fastdfsConfig == null) {
                log.error("文件服务连接初始化失败, 连接信息为空");
            } else {
                log.error("文件服务连接初始化失败, 连接信息 connect_timeout_in_seconds = {} network_timeout_in_seconds = {} charset = {}  tracker_servers = {}",
                        fastdfsConfig.getConnectTimeoutInSeconds(),
                        fastdfsConfig.getNetworkTimeoutInSeconds(),
                        fastdfsConfig.getCharset(),
                        fastdfsConfig.getTrackerServers());
            }
//            throw new BaseRuntimeException(CisProExceptionEnum.INIT_FASTDFS_FAILED);
            throw new RuntimeException("文件服务器连接初始化失败");
        }
    }

    /**
     * <p>项目名称: cis-pro </p>
     * <p>文件名称: FileServiceImpl.java </p>
     * <p>方法描述: 文件上传 </p>
     * <p>创建时间: 2020/10/26 10:41 </p>
     *
     * @param multipartFile 上传的文件内容
     * @return java.lang.String
     * @author 方瑞冬
     * @version 1.0
     */
    @Override
    public String upload(MultipartFile multipartFile) {
        if (multipartFile == null) {
//            throw new BaseRuntimeException(CisProExceptionEnum.FILE_NOT_NULL);
            throw new RuntimeException("上传的文件不能为空");
        }
        String fileFullName = multipartFile.getOriginalFilename();
        if (StringUtils.isEmpty(fileFullName)) {
//            throw new BaseRuntimeException(CisProExceptionEnum.FILE_NAME_NOT_EMPTY);
            throw new RuntimeException("上传的文件名不能为空");
        }
        File file = new File();
        file.setFullName(fileFullName);
        file.setName(fileFullName.substring(0, fileFullName.lastIndexOf(".")));
        file.setSuffix(fileFullName.substring(fileFullName.lastIndexOf(".") + 1));
        file.setSize(multipartFile.getSize());

        String[] storageLocation;
        this.initFdfsConfig();
        try {
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            storageLocation = storageClient.upload_file(multipartFile.getBytes(), file.getSuffix(), null);
            if (storageLocation == null) {
//                throw new BaseRuntimeException(CisProExceptionEnum.FILE_UPLOAD_FAILED);
                throw new RuntimeException("上传文件失败");
            }
        } catch (Exception e) {
//            throw new BaseRuntimeException(CisProExceptionEnum.FILE_UPLOAD_FAILED);
            throw new RuntimeException("上传文件失败");
        }

        file.setGroup(storageLocation[0]);
        file.setDirectory(storageLocation[1]);
        file.setAddress(fastdfsConfig.getStorageServer() + file.getGroup() + SPLIT_GROUP_NAME_AND_FILENAME_SEPERATOR + file.getDirectory());
//        file.setCreateBy(loginApi.getUserName());
//        file.setUpdateBy(loginApi.getUserName());
//        fileDao.save(file);
//        return file.getId();
        return file.getAddress();
    }

//    /**
//     * <p>项目名称: cis-pro </p>
//     * <p>文件名称: FileServiceImpl.java </p>
//     * <p>方法描述: 通过 ID 查询文件信息 </p>
//     * <p>创建时间: 2020/10/27 9:21 </p>
//     *
//     * @param id 文件 ID
//     * @return cn.cxinternet.paas.file.entity.File
//     * @author 方瑞冬
//     * @version 1.0
//     */
//    @Override
//    public File getFileInfoById(String id) {
//        return fileDao.getOne(id);
//    }
//
//    /**
//     * <p>项目名称: cis-pro </p>
//     * <p>文件名称: FileServiceImpl.java </p>
//     * <p>方法描述: 文件下载 </p>
//     * <p>创建时间: 2020/10/26 10:42 </p>
//     *
//     * @param id 文件 ID
//     * @return void
//     * @author 方瑞冬
//     * @version 1.0
//     */
//    @Override
//    public void download(String id) {
//        File file;
//        try {
//            file = fileDao.getOne(id);
//        } catch (Exception e) {
//            throw new BaseRuntimeException(CisProExceptionEnum.FILE_NOT_FOUND);
//        }
//
//        this.initFdfsConfig();
//        try {
//            TrackerClient trackerClient = new TrackerClient();
//            TrackerServer trackerServer = trackerClient.getConnection();
//            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
//            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
//            byte[] bytes = storageClient.download_file(file.getGroup(), file.getDirectory());
//
//            httpServletResponse.setCharacterEncoding(fastdfsConfig.getCharset());
//            httpServletResponse.setHeader("Content-disposition", "attachment;filename=" + file.getFullName());
//            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpServletResponse.getOutputStream());
//            bufferedOutputStream.write(bytes);
//            bufferedOutputStream.close();
//        } catch (Exception e) {
//            throw new BaseRuntimeException(CisProExceptionEnum.FILE_DOWNLOAD_FAILED);
//        }
//    }
//
//    /**
//     * <p>项目名称: cis-pro </p>
//     * <p>文件名称: FileServiceImpl.java </p>
//     * <p>方法描述: 文件删除 </p>
//     * <p>创建时间: 2020/10/26 10:42 </p>
//     *
//     * @param id 文件 ID
//     * @return void
//     * @author 方瑞冬
//     * @version 1.0
//     */
//    @Override
//    public void delete(String id) {
//        File file = fileDao.getOne(id);
//        this.initFdfsConfig();
//        try {
//            TrackerClient trackerClient = new TrackerClient();
//            TrackerServer trackerServer = trackerClient.getConnection();
//            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
//            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
//            storageClient.delete_file(file.getGroup(), file.getDirectory());
//            fileDao.deleteById(id);
//        } catch (Exception e) {
//            throw new BaseRuntimeException(CisProExceptionEnum.FILE_DELETE_FAILED);
//        }
//    }
}
