package com.ilf.msbdesignmode.chainofresponsibility;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: msb-design-mode
 * @description: 模拟http 的filter
 * http的 filter 和刚刚demo的区别在于， 执行过程是 先执行 request 链的逻辑，之后 从责任链的最后一个 相回执行 response的逻辑。
 * 一个filter 同时执行 req和response 的两个逻辑
 * @author: carl.zhang
 * @create: 2022-11-14  00:31
 **/
public class HttpRequestFilterTest {

    public static void main(String[] args) {
        String req = "<script>, :), 干掉本拉登，开开信息。";
        String res = "开开信息。";
        MyHttpFilterChain chain = new MyHttpFilterChain();
        chain.addMyFc(new MyFilter01()).addMyFc(new MyFilter02()).addMyFc(new MyFilter03());
        Request request = new Request(req);
        Response response = new Response(res);
        chain.dof(request, response);

        System.out.println(request.str);
        System.out.println(response.str);

    }
}

class MyHttpFilterChain {
    List<MyHttpFilter> myHttpFilterList = new ArrayList<>();
    int index = 0;

    MyHttpFilterChain addMyFc(MyHttpFilter mhf) {
        myHttpFilterList.add(mhf);
        return this;
    }

    boolean dof(Request request, Response response) {
        if (index >= myHttpFilterList.size()) {
            return true;
        }
        MyHttpFilter cc = myHttpFilterList.get(index);
        index++;
        cc.doMyFilter(request, response, this);
        return true;
    }

   /* boolean doMyHttpFilterChain(Request request, Response response) {
        for (int i = 0; i < myHttpFilterList.size(); i++) {
            if (!myHttpFilterList.get(i).doMyFilter(request, response, this)) return false;
        }
        return true;
    }*/

}

class MyFilter03 implements MyHttpFilter {
    @Override
    public boolean doMyFilter(Request request, Response response, MyHttpFilterChain fuck) {
        request.str = request.str.replace("本拉登", "***").concat("03f");
        fuck.dof(request, response);
        response.str += "03F,";
        return true;
    }
}

class MyFilter02 implements MyHttpFilter {
    @Override
    public boolean doMyFilter(Request request, Response response, MyHttpFilterChain fuck) {
        request.str = request.str.replace(":)", "~v~").concat("02f");
        fuck.dof(request, response);
        response.str += "02F,";
        return true;
    }
}

class MyFilter01 implements MyHttpFilter {
    @Override
    public boolean doMyFilter(Request request, Response response, MyHttpFilterChain fuck) {
        request.str = request.str.replace("<", "[").replace(">", "]").concat("01f");
        fuck.dof(request, response);
        response.str += "01F,";
        return true;
    }
}


interface MyHttpFilter {
    boolean doMyFilter(Request request, Response response, MyHttpFilterChain myHttpFilterChain);
}

@Data
@AllArgsConstructor
class Request {
    public String str;
}

@Data
@AllArgsConstructor
class Response {
    public String str;
}

