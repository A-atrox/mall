package com.macro.mall.service;

import com.macro.mall.nosql.mongo.document.MemberReadHistory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员浏览记录管理Service
 * @author guoyf
 * @Date 2020/10/27
 */
public interface MemberReadHistoryService {
    /***
     * 生成浏览记录
     * @param memberReadHistory
     * @return
     */
    int create(MemberReadHistory memberReadHistory);

    /***
     * 批量删除浏览记录
     * @param ids
     * @return
     */
    int delete(List<String> ids);

    /***
     * 获取用户浏览历史记录
     * @param memberId
     * @return
     */
    List<MemberReadHistory> list(Long memberId);
}
