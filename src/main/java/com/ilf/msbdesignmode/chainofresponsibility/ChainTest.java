package com.ilf.msbdesignmode.chainofresponsibility;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: msb-design-mode
 * @description: 责任链模式
 * @author: carl.zhang
 * @create: 2022-11-13  20:46
 **/
public class ChainTest {


    public static void main(String[] args) {

        String info = "<script>, :), 干掉本拉登，开开信息。";
        Msg msg = new Msg(info);
    /*    msg = HtmlFilter(msg);
        msg = FaceFilter(msg);
        msg = TextFilter(msg);
        System.out.println(msg.toString());*/
/*        List<InfoFilter> myFilters = new ArrayList<>();

        HtmlFilter hf = new HtmlFilter();
        FaceFilter ff = new FaceFilter();
        TextFilter iff = new TextFilter();

        myFilters.add(hf);
        myFilters.add(ff);
        myFilters.add(iff);*/
        MyFilterChain wcao = new MyFilterChain();
        wcao.addMyFilter(new HtmlFilter()).addMyFilter(new FaceFilter()).addMyFilter(new TextFilter());

        wcao.ddd(msg);
        System.out.println(msg.toString());

    }


}


class MyFilterChain {

    List<InfoFilter> myFilters = new ArrayList<>();

    MyFilterChain addMyFilter(InfoFilter cc) {
        this.myFilters.add(cc);
        return this;
    }

    boolean ddd(Msg msg) {
        for (InfoFilter f : this.myFilters) {
            if (!f.doFilter(msg)) return false;
        }
        return true;
    }

}

class HtmlFilter implements InfoFilter {


    @Override
    public boolean doFilter(Msg msg) {
        String info = msg.getInfo();
        info = info.replace("<", "[");
        info = info.replace(">", "]");
        msg.setInfo(info);
        //return msg;
        return false;
    }

}

class FaceFilter implements InfoFilter {
    @Override
    public boolean doFilter(Msg msg) {
        String info = msg.getInfo();
        info = info.replace(":)", "~v~");
        msg.setInfo(info);
        //return msg;
        return true;
    }

}


class TextFilter implements InfoFilter {
    @Override
    public boolean doFilter(Msg msg) {
        String info = msg.getInfo();
        info = info.replace("本拉登", "***");
        msg.setInfo(info);
        //return msg;
        return true;
    }


}


interface InfoFilter {

    boolean doFilter(Msg msg);

}


@Data
@AllArgsConstructor
class Msg {
    private String info;

    @Override
    public String toString() {
        return "Msg{" +
                "info='" + info + '\'' +
                '}';
    }
}
