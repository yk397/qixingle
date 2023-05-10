package com.sixandone.qixingle.service.userService;

import com.sixandone.qixingle.util.erro.WxErrorException;

import java.io.File;

/**
 * 内容安全相关接口
 */
public interface WxSecCheckService {
    /**
     * <pre>
     * 校验一张图片是否含有违法违规内容.
     * 应用场景举例：
     * 1）图片智能鉴黄：涉及拍照的工具类应用(如美拍，识图类应用)用户拍照上传检测；电商类商品上架图片检测；媒体类用户文章里的图片检测等；
     * 2）敏感人脸识别：用户头像；媒体类用户文章里的图片检测；社交类用户上传的图片检测等。频率限制：单个 appId 调用上限为 1000 次/分钟，100,000 次/天
     * 详情请见: <a href="https://developers.weixin.qq.com/miniprogram/dev/api/open-api/sec-check/imgSecCheck.html">https://developers.weixin.qq.com/miniprogram/dev/api/open-api/sec-check/imgSecCheck.html</a>
     * </pre>
     *
     * @param file the file
     * @return the boolean
     * @throws WxErrorException the wx error exception
     */
    boolean checkImage(File file) throws WxErrorException;


}
