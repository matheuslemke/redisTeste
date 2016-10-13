package com.nosql.redis;

public abstract class MainQuery {
	protected RedisUtils redisUtil = new RedisUtils();

	public abstract void nextResult();

}
