package com.nosql.redis;

import java.util.Arrays;
import java.util.List;

import redis.clients.jedis.Jedis;

public class Constants {
	private final static Jedis jedis = new Jedis("localhost");
	private final static int pageSize = 20;
	private final static int maxCount = 2000000;
	private static List<String> fieldsToFiltrate = Arrays.asList("PARCEIRONOME",
			"CNPJCPF", "MATRICULA", "NUMERO", "ENDERECO", "CIDADE", "UFSIGLA");

	public static int getPagesize() {
		return pageSize;
	}

	public static int getMaxcount() {
		return maxCount;
	}

	public static Jedis getJedis() {
		return jedis;
	}

	public static List<String> getFieldsToFiltrate() {
		return fieldsToFiltrate;
	}

	public static void setFieldsToFiltrate(List<String> fieldsToFiltrate) {
		Constants.fieldsToFiltrate = fieldsToFiltrate;
	}
}
