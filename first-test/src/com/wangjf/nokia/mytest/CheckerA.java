package com.wangjf.nokia.mytest;

public class CheckerA extends AbstractFunctionAChecker {


    @Override
    public void run() {
        super.preDo();
        System.out.println("CheckerA具体【前处理】逻辑");
        super.run();
        System.out.println("CheckerA具体【后处理】逻辑");
        super.postDo();
    }
}
