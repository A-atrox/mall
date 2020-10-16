package com.macro.mall.service;

import com.macro.mall.common.api.CommonResult;

/**
 * 会员管理Service
 *
 * @author guoyf
 * @Date 2020/10/16
 * @describe
 */
public interface UmsMemberService {
    /***
     * 生成验证码
     *
     */
    CommonResult generateAuthCode(String telephone);

    /***
     * 判断验证码和手机号是否匹配
     *
     */
    CommonResult verifyAuthCode(String telephone,String authCode);

}
