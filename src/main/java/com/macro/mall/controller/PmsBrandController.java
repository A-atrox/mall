package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.entity.PmsBrand;
import com.macro.mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author guoyf
 * @Date 2020/9/25
 * @describe 品牌管理controller
 */
@Api(value = "商品品牌管理服务API",tags = {"商品品牌管理服务API"})
@RestController
@RequestMapping("/v1/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsBrandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    /**
     * 查询所有的商品记录
     * @return CommonResult<List < PmsBrand>>
     * @author guoyf
     * @Date 2020/9/27
     */
    @ApiOperation("获取所有品牌列表")
    @GetMapping("/listAll")
    @PreAuthorize("hasAnyAuthority('pms:brand:read')")
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(pmsBrandService.listAllBrand());
    }

    /**
     * 创建一条商品记录
     *
     * @return CommonResult
     * @params [pmsBrand]
     * @author guoyf
     * @Date 2020/9/27
     */
    @ApiOperation("添加品牌")
    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('pms:brand:create')")
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand) {
        CommonResult commonResult;
        int count = pmsBrandService.createBrand(pmsBrand);
        if (count == 1) {
            LOGGER.debug("createBrand success:{}", pmsBrand);
            commonResult = CommonResult.success(pmsBrand);
        } else {
            LOGGER.debug("createBrand failed：{}", pmsBrand);
            commonResult = CommonResult.failed("操作失败");
        }
        return commonResult;
    }
    @ApiOperation("更新指定id 的品牌")
    @PostMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('pms:brand:update')")
    public CommonResult updateBrand(@PathVariable("id")Long id, @RequestBody @Valid PmsBrand pmsBrandDto, BindingResult result){
        System.out.println(result);
        CommonResult commonResult;
        int count = pmsBrandService.updateBrand(id,pmsBrandDto);
        if(count==1){
            commonResult = CommonResult.success(pmsBrandDto);
            LOGGER.debug("updateBrand success:{}",pmsBrandDto);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updateBrand failed:{}",pmsBrandDto);
        }
        return commonResult;
    }
    @ApiOperation("删除指定id的品牌")
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('pms:brand:delete')")
    public CommonResult deleteBrand(@PathVariable("id") Long id){
        CommonResult commonResult;
        int count = pmsBrandService.deleteBrand(id);
        if(count == 1){
            commonResult = CommonResult.success(null);
            LOGGER.debug("deleteBrand success: id={}",id);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("deleteBrand failed: id={}",id);
        }
        return commonResult;
    }
    @ApiOperation("查新指定id的品牌详情")
    @GetMapping("/{id}")
    public  CommonResult getBrand(@PathVariable("id") Long id){
       PmsBrand pmsBrand = pmsBrandService.getBrand(id);
        return CommonResult.success(pmsBrand);
    }
    @ApiOperation("分页查询品牌列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                                        @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize ){
        List<PmsBrand> list = pmsBrandService.listBrand(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(list));
    }


}
