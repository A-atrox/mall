package com.macro.mall.service;

import com.macro.mall.entiy.PmsBrand;

import java.util.List;

/**
 * @author guoyf
 * @Date 2020/9/25
 * @describe
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
