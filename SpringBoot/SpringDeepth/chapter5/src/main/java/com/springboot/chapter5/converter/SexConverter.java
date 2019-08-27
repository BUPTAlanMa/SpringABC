package com.springboot.chapter5.converter;

import com.springboot.chapter5.enumeration.SexEnum;

import javax.persistence.AttributeConverter;

/**
 * @param
 * @param
 * @param
 * @author
 * @Title:
 * @Description:
 * @return
 * @date 2019/8/18 8:58
 * @throws
 */
public class SexConverter implements AttributeConverter<SexEnum, Integer> {

    // 将枚举转换为数据库列
    @Override
    public Integer convertToDatabaseColumn(SexEnum sex) {
        return sex.getId();
    }

    // 将数据库转换为枚举
    @Override
    public SexEnum convertToEntityAttribute(Integer id) {
        return SexEnum.getEnumById(id);
    }
}
