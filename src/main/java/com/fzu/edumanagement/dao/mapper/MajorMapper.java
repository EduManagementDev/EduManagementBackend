package com.fzu.edumanagement.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fzu.edumanagement.model.entity.MajorEntity;
import com.fzu.edumanagement.model.vo.response.table.MajorItemVO;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorMapper extends BaseMapper<MajorEntity> {
    Integer count(String departmentName, String name);

    IPage<MajorItemVO> getPage(IPage<MajorItemVO> page, String departmentName, String name);
}
