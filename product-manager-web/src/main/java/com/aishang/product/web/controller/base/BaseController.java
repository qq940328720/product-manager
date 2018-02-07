package com.aishang.product.web.controller.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected final static String PATH_PRE_REST = "rest";
    protected final static String ADMIN_SESSION_KEY = "_admin_session_key";
}