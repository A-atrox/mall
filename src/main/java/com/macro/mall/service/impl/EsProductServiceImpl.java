package com.macro.mall.service.impl;

import com.macro.mall.dao.EsProductDao;
import com.macro.mall.dao.PmsProductMapper;
import com.macro.mall.entity.PmsProduct;
import com.macro.mall.entity.PmsProductExample;
import com.macro.mall.nosql.elasticsearch.document.EsProduct;
import com.macro.mall.nosql.elasticsearch.repository.EsProductRepository;
import com.macro.mall.service.EsProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author guoyf
 * @Date 2020/10/23
 */
@Service
@Slf4j
public class EsProductServiceImpl implements EsProductService {
    @Autowired
    private EsProductDao esProductDao;
    @Autowired
    private EsProductRepository productRepository;

    @Override
    public int importAll() {
        List<EsProduct> esProductList =esProductDao.getAllEsProductList(null);
        productRepository.saveAll(esProductList);
        return esProductList.size();
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public EsProduct create(Long id) {
        EsProduct result = null;
        List<EsProduct> esProductList = esProductDao.getAllEsProductList(id);
        if(esProductList.size()>0){
            EsProduct esProduct = esProductList.get(0);
            result = productRepository.save(esProduct);
        }
        return result;
    }

    @Override
    public void delete(List<Long> ids) {
        if(!CollectionUtils.isEmpty(ids)){
            List<EsProduct> esProductList = new ArrayList<>();
            ids.forEach(id ->{
                EsProduct esProduct = new EsProduct();
                esProduct.setId(id);
                esProductList.add(esProduct);
            });
            productRepository.deleteAll(esProductList);
        }
    }

    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return productRepository.findByNameOrSubTitleOrKeywords(keyword,keyword,keyword,pageable);
    }
}
