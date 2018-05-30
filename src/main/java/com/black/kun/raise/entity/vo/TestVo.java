package com.black.kun.raise.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TestVo {

    public static interface test1{}
    public static interface test2{}

    @NotNull(message = "userId不允许为空")
    private Integer userId;
    @NotEmpty(message = "name不能为空",groups = {test1.class})
    private String name;

}
