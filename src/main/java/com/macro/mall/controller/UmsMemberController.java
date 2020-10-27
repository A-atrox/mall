package com.macro.mall.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author guoyf
 * @Date 2020/10/16
 * @describe
 */
@Api(tags = {"会员登录注册管理"}, value = "会员登录注册管理")
@RestController
@RequestMapping("/v1/sso")
public class UmsMemberController {
    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("获取验证码")
    @GetMapping("/getAuthCode")
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @PostMapping("/verifyAuthCode")
    public CommonResult verifyAuthCode(@RequestParam String telephone, @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone, authCode);
    }

}
