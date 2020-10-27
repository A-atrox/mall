package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.nosql.elasticsearch.document.EsProduct;
import com.macro.mall.service.EsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 搜索商品管理
 * @author guoyf
 * @Date 2020/10/23
 */
@RestController
@Api(tags = {"搜索商品管理"},value = "EsProductController")
@RequestMapping("/v1/esProduct")
public class EsProductController {
    @Autowired
    private EsProductService esProductService;

    @ApiOperation("导入所有数据库中商品到ES")
    @PostMapping("/importAll")
    public CommonResult<Integer> importAllList() {
        int count = esProductService.importAll();
        return CommonResult.success(count);
    }

    @ApiOperation("根据id删除商品")
    @GetMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id){
        esProductService.delete(id);
        return CommonResult.success("");
    }
    @ApiOperation("根据id批量删除商品")
    @PostMapping("/deleteAll")
    public CommonResult deleteAll(@RequestParam("ids") List<Long> ids){
        esProductService.delete(ids);
        return CommonResult.success("");
    }
    @ApiOperation("根据Id创建商品")
    @PostMapping("/create")
    public CommonResult<EsProduct> create(@RequestParam(value = "id") Long id){
        EsProduct esProduct = esProductService.create(id);
        if(esProduct != null){
            return CommonResult.success(esProduct);
        }
        return CommonResult.failed();
    }

    @ApiOperation("简单搜索")
    @GetMapping("/search/simple")
    public CommonResult<CommonPage<EsProduct>> search(@RequestParam(value = "keywords") String keywords,
                                                      @RequestParam(value = "pageNum",required = false,defaultValue = "0") Integer pageNum,
                                                      @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize){
        Page<EsProduct> esProductPage = esProductService.search(keywords, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(esProductPage));
    }
}
