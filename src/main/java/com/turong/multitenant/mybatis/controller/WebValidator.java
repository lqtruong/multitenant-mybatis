package com.turong.multitenant.mybatis.controller;

public interface WebValidator<WebRequest> {

    boolean validate(final WebRequest request);

}
