package com.lppz.stock.platform.base;



public enum Channel {

    MEITUAN("meituan", "美团"),
    EB("eb", "饿百渠道, 可能包含多种子渠道，eb_nc eb_wh..."),
    BD("bd", "百度"),
    KB("kb", "口碑");

    String source;
    String name;

    Channel(String source, String name) {
        this.source = source;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }



}
