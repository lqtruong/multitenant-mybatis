package com.turong.multitenant.mybatis.mapper;

import lombok.Getter;

public enum SupportedTenant {

    UFO("ufo"),
    TR("tr"),
    IND("ind"),
    VN("vn");

    @Getter
    private final String tenant;

    SupportedTenant(final String tenant) {
        this.tenant = tenant;
    }

}
