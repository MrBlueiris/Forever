package com.forever.dao;

import com.forever.pojo.Pay_info;

public interface Pay_infoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pay_info record);

    int insertSelective(Pay_info record);

    Pay_info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pay_info record);

    int updateByPrimaryKey(Pay_info record);
}