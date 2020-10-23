package com.macro.mall.nosql.elasticsearch.repository;

import com.macro.mall.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author guoyf
 * @Date 2020/10/23
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct,Long> {
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable page);
}
