package com.sixandone.qixingle.util;

/**errocode 说明
 * <ul>
 *  *
 *  *  *    <li>-41001: encodingAesKey 非法</li>
 *  *  *    <li>-41002: iv 非法
 *  *  *    <li>-41003: aes 解密失败</li>
 *  *  *    <li>-41004: 解密后得到的buffer非法</li>
 *  *  *    <li>-41005: base64加密失败</li>
 *  *  *    <li>-41016: base64解密失败</li>
 *  *  * </ul>
 */
public enum encryptErrcode implements code{
    OK{
        public int getCode(){
            return 0;
        }
    },
    ILLEGAL_AES_KEY{
        public int getCode(){
            return 41001;
        }
    },
    ILLEGAL_IV{
        public int getCode(){
            return 41002;
        }
    },
    ILLEGAL_BUFFER{
        public int getCode(){
            return 41004;
        }
    },
    AES_FAIL{
        public int getCode(){
            return 41003;
        }
    },
    DECODE_BASE64ERROR{
        public int getCode(){
            return 41016;
        }
    };

}

interface code{
    public int getCode();
}
