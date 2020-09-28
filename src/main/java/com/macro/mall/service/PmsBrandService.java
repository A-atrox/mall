package com.macro.mall.service;

import com.macro.mall.entity.PmsBrand;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guoyf
 * @Date 2020/9/25
 * @describe
 */
@Service
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
