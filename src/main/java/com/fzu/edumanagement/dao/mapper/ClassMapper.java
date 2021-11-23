package com.fzu.edumanagement.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fzu.edumanagement.model.entity.ClassEntity;
import com.fzu.edumanagement.model.vo.response.table.MajorItemVO;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassMapper extends BaseMapper<ClassEntity> {
    Integer count(String departmentName, String majorName, String name);

    IPage<MajorItemVO> getPage(IPage<MajorItemVO> page, String departmentName, String majorName, String name);
}
