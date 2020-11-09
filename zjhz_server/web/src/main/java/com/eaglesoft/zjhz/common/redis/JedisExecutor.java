package com.eaglesoft.zjhz.common.redis;

import com.eaglesoft.zjhz.common.exception.RedisConnectException;

@FunctionalInterface
public interface JedisExecutor<T, R> {
    R excute(T t) throws RedisConnectException;
}
