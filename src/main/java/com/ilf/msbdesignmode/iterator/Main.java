package com.ilf.msbdesignmode.iterator;

/**
 * @program: msb-design-mode
 * @description: 迭代器模式
 * @author: carl.zhang
 * @create: 2022-11-19  23:57
 **/
public class Main {

    /*(
    比较简单，这里不做实现了。
    1、所有的 集合类，都是由 数组或者链表组成
    2、为了能通用，则可以为所有容器定义接口 Collection 实现 添加 & size 或者其他
    3、迭代器模式，是为了方便所有类型的容器都能被遍历。因此，需要定义个接口 Iterator ，里面定义两个方法：bool hasNext  ，Object Next
    由每个容器来自己实现。

    4、我们可以让容器，通过内部类的方式 实现Iterator（jdk的方式） ，或者 自己实现也可以。
    5、 实现了后，可以通过具体的容器，获取当前容器实例的迭代器，里面记录了当前位置的坐标，方便获取下一个，或者判断是否下一个item是否存在。
    6、至此 就完成了迭代能力
     */

}
