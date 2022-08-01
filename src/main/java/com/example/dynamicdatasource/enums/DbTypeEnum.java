package com.example.dynamicdatasource.enums;

/**
 *
 * Title: DbTypeEnum
 * Description: 数据库枚举类
 */
public enum DbTypeEnum {
    T100019("t100019"), T100049("t100049"), T100138("t100138");

    private String value;

    DbTypeEnum(final String value) {

        this.value = value;
    }

    public String getValue() {

        return value;
    }
}
