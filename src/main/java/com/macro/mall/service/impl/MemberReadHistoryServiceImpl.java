package com.macro.mall.service.impl;

import com.macro.mall.nosql.mongo.document.MemberReadHistory;
import com.macro.mall.nosql.mongo.repository.MemberReadHistoryRepository;
import com.macro.mall.service.MemberReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 会员浏览记录管理Service实现类
 *
 * @author guoyf
 * @Date 2020/10/27
 */
@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {
    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;
    @Override
    public int create(MemberReadHistory memberReadHistory) {
        memberReadHistory.setId(null);
        memberReadHistory.setCreateTime(new Date());
        memberReadHistoryRepository.save(memberReadHistory);
        return 1;
    }

    @Override
    public int delete(List<String> ids) {
        List<MemberReadHistory> deleteList = ids.stream().map(value->{
            MemberReadHistory memberReadHistory = new MemberReadHistory();
            memberReadHistory.setId(value);
            return memberReadHistory;
        }).collect(Collectors.toList());
        memberReadHistoryRepository.deleteAll(deleteList);
        return deleteList.size();
    }

    @Override
    public List<MemberReadHistory> list(Long memberId) {
        return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }
}
