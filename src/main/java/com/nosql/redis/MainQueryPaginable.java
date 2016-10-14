package com.nosql.redis;

public abstract class MainQueryPaginable extends MainQuery {
	protected int setKeysStart = 0;

	protected int pagesize;

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
}
