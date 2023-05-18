package com.sixandone.qixingle.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.constant.WxMaConstants;
import cn.binarywang.wx.miniapp.util.WxMaConfigHolder;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.sixandone.qixingle.service.userServiceImpl.bicycleService;
import com.sixandone.qixingle.service.businessService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName WxMediaController
 * @Descprition:微信临时素材上传下载接口
 * @Autor DELL
 * @Date 2023/5/11 8:05
 **/

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/wx/media/{appid}")

public class WxMediaController {

    private final WxMaService wxMaService;

    private final bicycleService bicycleService;

    private final businessService businessService;

    /**
     * 上传临时素材
     *
     * @return 素材的media_id列表，实际上如果有的话，只会有一个
     */
    @PostMapping("/upload")
    public List<String> uploadMedia(@PathVariable String appid, HttpServletRequest request) throws WxErrorException {
        if (!wxMaService.switchover(appid)) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appid));
        }

        CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());

        if (!resolver.isMultipart(request)) {
            WxMaConfigHolder.remove();//清理ThreadLocal
            return Lists.newArrayList();
        }

        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        Iterator<String> it = multiRequest.getFileNames();
        List<String> result = Lists.newArrayList();
        while (it.hasNext()) {
            try {
                MultipartFile file = multiRequest.getFile(it.next());
                File newFile = new File(Files.createTempDir(), file.getOriginalFilename());
                log.info("filePath is ：" + newFile.toString());
                file.transferTo(newFile);
                WxMediaUploadResult uploadResult = wxMaService.getMediaService().uploadMedia(WxMaConstants.KefuMsgType.IMAGE, newFile);
                log.info("media_id ： " + uploadResult.getMediaId());
                result.add(uploadResult.getMediaId());
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
        WxMaConfigHolder.remove();//清理ThreadLocal
        return result;
    }

    /**
     * 下载临时素材
     */
    @GetMapping("/download/{mediaId}")
    public File getMedia(@PathVariable String appid, @PathVariable String mediaId) throws WxErrorException {
        if (!wxMaService.switchover(appid)) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appid));
        }
        File media = wxMaService.getMediaService().getMedia(mediaId);
        WxMaConfigHolder.remove();//清理ThreadLocal
        return media;
    }

    /**
     * 返回响应自行车图片
     * @param appid
     * @param bicycleId
     * @return
     */
    @GetMapping(value = "/img/{bicycleid}",
            produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE} )
    public byte[] getBicycleImg(
            @PathVariable(name = "appid")String appid,
            @PathVariable(name = "bicycleid")String bicycleId
    ) throws IOException{
        byte[] bytes = bicycleService.queryBicycleImg(bicycleId);
        return bytes;

    }


    /**
     * 返回响应店铺图片
     * @param appid
     * @param businessId
     * @return
     */
    @GetMapping(value = "/img/{businessid}",
            produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE})
    public byte[] getBusinessImg(
            @PathVariable(name = "appid")String appid,
            @PathVariable(name = "businessid")String businessId
    )throws IOException{
        byte[] bytes = businessService.queryBusinessImg(businessId);
        return bytes;

    }





}
