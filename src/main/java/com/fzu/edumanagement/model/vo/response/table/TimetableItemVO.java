package com.fzu.edumanagement.model.vo.response.table;

import lombok.Data;

@Data
public class TimetableItemVO {
    private String time;
    private String courseName;
    private String teacherName;
    private String location;
}
