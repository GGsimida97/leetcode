package com.wangjf;

public enum Singleton {
    MYINSTACNE;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
class T {
    public static void main(String[] args) {
        Singleton.MYINSTACNE.setName("wocao");
        System.out.println(Singleton.MYINSTACNE.getName());
    }
}