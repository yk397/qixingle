package com.sixandone.qixingle.service.userService.ServiceImpl;

import com.sixandone.qixingle.util.erro.WxErrorException;
import com.sixandone.qixingle.service.userService.WxSecCheckService;

import java.io.File;

/**
 * @ClassName yk
 * @Descprition:实现用户内容安全检查
 * @Autor DELL
 * @Date 2023/5/9 22:38
 **/
public class WxSecCheckServiceImpl implements WxSecCheckService {

    @Override
    public boolean checkImage(File file) throws WxErrorException {
        return false;
    }
}
