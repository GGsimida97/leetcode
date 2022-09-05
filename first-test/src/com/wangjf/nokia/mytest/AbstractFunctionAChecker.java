package com.wangjf.nokia.mytest;

public abstract class AbstractFunctionAChecker implements GlobalCheckerAPI{
    @Override
    public void preDo() {
        System.out.println("下载源数据");
        System.out.println("A类checker【独有的】前处理");
    }
    @Override
    public void run() {
//        preDo();
        System.out.println("A类checker共同处理逻辑");
//        postDo();
    }

    @Override
    public void postDo() {
        System.out.println("A类checker【独有的】后处理");
        System.out.println("数据持久化");
    }
}
