package com.ilf.msbdesignmode.componentseit;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: msb-design-mode
 * @description: 组合模式，就是树状结构管理模式
 * @author: carl.zhang
 * @create: 2022-11-19  20:59
 **/
public class Main {

    public static void main(String[] args) {


        LeafNode l1 = new LeafNode("l1");
        LeafNode l2 = new LeafNode("l2");

        LeafNode l3 = new LeafNode("l3");
        LeafNode l4 = new LeafNode("l4");

        List<Node> b1_sub = new ArrayList<>();
        b1_sub.add(l1);
        b1_sub.add(l2);
        //----------
        List<Node> b2_sub = new ArrayList<>();
        b2_sub.add(l3);
        b2_sub.add(l4);
        BranchNode b1 = new BranchNode("b1", b1_sub);


        BranchNode b2 = new BranchNode("b2", b2_sub);

        List<Node> rootChild = new ArrayList<>();
        rootChild.add(b1);
        rootChild.add(b2);
        BranchNode root = new BranchNode("root", rootChild);
        print(root, 0);
    }

    /**
     * 递归遍历一下就行
     *
     * @param root
     * @param deep
     */
    private static void print(Node root, int deep) {
        for (int i = 0; i < deep; i++) {
            System.out.print("--");
        }
        root.p();

        if (root instanceof BranchNode) {
            for (int i = 0; i < ((BranchNode) root).getChildrenList().size(); i++) {
                print(((BranchNode) root).childrenList.get(i), deep + 1);
            }
        }

    }

}


/**
 * 节点，包括两个类型，目录&文件
 */
interface Node {

    void p();

}

/**
 * 目录节点
 */
@AllArgsConstructor
@Data
class BranchNode implements Node {

    String name;
    List<Node> childrenList;


    @Override
    public void p() {
        System.out.println(this.name);
    }
}

/**
 * 叶子
 */
@AllArgsConstructor
@Data
class LeafNode implements Node {

    String name;

    @Override
    public void p() {
        System.out.println(this.name);
    }
}