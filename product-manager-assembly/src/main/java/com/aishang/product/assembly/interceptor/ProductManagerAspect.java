package com.aishang.product.assembly.interceptor;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hc.support.spring.aspect.BaseAspect;

@Aspect
public class ProductManagerAspect extends BaseAspect {
	private final Logger logger = LoggerFactory.getLogger( this.getClass() );

	@Override
	protected void info( String log, Object... arguments ) {
		logger.info( log, arguments );
	}

	@Override
	protected void debug( String log, Object... arguments ) {
		logger.debug( log, arguments );
	}

	@Override
	protected void error( String log, Object... arguments ) {
		logger.error( log, arguments );
	}

}
