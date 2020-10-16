package com.macro.mall.dao;

import com.macro.mall.entity.UmsAdminRoleRelation;
import com.macro.mall.entity.UmsAdminRoleRelationExample;
import java.util.List;

import com.macro.mall.entity.UmsPermission;
import org.apache.ibatis.annotations.Param;

public interface UmsAdminRoleRelationMapper {
    /**
     * 获取用户所有权限
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}