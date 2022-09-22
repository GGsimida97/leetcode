package com.wangjf.nokia.mytest;

public class CheckerA extends AbstractFunctionAChecker {
    @Override
    public void preDo() {
        super.preDo();
        System.out.println("CheckerA具体【前处理】逻辑");
    }

    @Override
    public void postDo() {
        super.postDo();
        System.out.println("CheckerA具体【后处理】逻辑");
    }

    @Override
    public void run() {
        this.preDo();
        System.out.println("CheckerA具体【业务】逻辑");
        this.postDo();
    }
}
