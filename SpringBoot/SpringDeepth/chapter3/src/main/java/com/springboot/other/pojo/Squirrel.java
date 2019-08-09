package com.springboot.other.pojo;

import com.springboot.chapter3.pojo.definition.Animal;

/**
 * @param
 * @param
 * @param
 * @author
 * @Title:
 * @Description:
 * @return
 * @date 2019/8/9 16:42
 * @throws
 */
public class Squirrel implements Animal {

    @Override
    public void use() {
        System.out.println("松鼠可以采集松果");
    }

}
