/**
 * Project Name: cis-pro
 * File Name: FileInfoVO
 * Package Name: cn.cxinternet.paas.file.vo
 * Date: 2020/10/27 9:12
 * Author: 方瑞冬
 */
package com.example.fastdfs.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 方瑞冬
 */
@Data
@ApiModel(value = "FileInfoVO",description = "文件信息返回")
public class FileInfoVO {
    @ApiModelProperty(value = "文件 ID")
    private String id;

    @ApiModelProperty(value = "文件全称=名称 + 后缀")
    private String fullName;

    @ApiModelProperty(value = "文件名称")
    private String name;

    @ApiModelProperty(value = "文件后缀")
    private String suffix;

    @ApiModelProperty(value = "文件大小")
    private Long size;

    @ApiModelProperty(value = "文件地址")
    private String address;
}
