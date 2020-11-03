/**
 * Project Name: cis-pro
 * File Name: File
 * Package Name: cn.cxinternet.paas.file.entity
 * Date: 2020/10/26 10:04
 * Author: 方瑞冬
 */
package com.example.fastdfs.entity;

import lombok.Data;

import java.util.UUID;

/**
 * @author 方瑞冬
 */
@Data
//@Entity
//@Table(name = "file")
//@Where(clause = "del_flag=0")
//public class File extends FunpfBaseEntity {
public class File {
    private static final long serialVersionUID = 1L;

    private String id = UUID.randomUUID().toString();

    /**
     * 文件全称=名称 + 后缀
     */
//    @Column(name = "full_name", nullable = false, length = 200)
    private String fullName;

    /**
     * 文件名称
     */
//    @Column(name = "name", nullable = false, length = 200)
    private String name;

    /**
     * 文件后缀
     */
//    @Column(name = "suffix", nullable = false, length = 50)
    private String suffix;

    /**
     * 文件大小
     */
//    @Column(name = "size", nullable = false)
    private Long size;

    /**
     * 文件地址
     */
//    @Column(name = "address", nullable = false, length = 100)
    private String address;

    /**
     * 文件组
     */
//    @Column(name = "file_group", nullable = false, length = 50)
    private String group;

    /**
     * 文件目录
     */
//    @Column(name = "file_directory", nullable = false, length = 300)
    private String directory;
}
