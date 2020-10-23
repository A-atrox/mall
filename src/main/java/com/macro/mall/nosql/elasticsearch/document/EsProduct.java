package com.macro.mall.nosql.elasticsearch.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 搜索商品信息
 *
 * @author guoyf
 * @Date 2020/10/23
 */
@Data
@Document(indexName = "pms",type = "product",shards = 1,replicas = 0)
public class EsProduct implements Serializable {
    private static final long serialVersionUID = -2327425503544813849L;
    @Id
    private  Long ID;
    @Field(type = FieldType.Keyword)
    private String productSn;
    private String brandId;
    @Field(type = FieldType.Keyword)
    private String brandName;
    private String productCategoryId;
    @Field(type = FieldType.Keyword)
    private String productCategoryName;
    private String pic;
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String name;
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String subTitle;
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String keywords;
    private BigDecimal price;
    private Integer sale;
    private Integer newStatus;
    private Integer recommendStatus;
    private Integer stock;
    private Integer promotionType;
    private Integer sort;
    private List<EsProductAttributeValue> attValueList;

}
