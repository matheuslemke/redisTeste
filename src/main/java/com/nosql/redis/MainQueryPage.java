package com.nosql.redis;

import java.util.Iterator;

public class MainQueryPage extends MainQueryPaginable {

	/**
	 * Consulta principal que lista EM PÁGINA todos os registros em pares
	 * (chave-valor), contendo respectivamente o nome do campo e o valor
	 */
	@Override
	public void nextResult() {
		int i = 0;
		for (Iterator<String> iterator = redisUtil.localKeys().iterator(); iterator
				.hasNext() && (i >= pageStart && i < pagesize + pageStart); i++) {
			System.out.println(Constants.getJedis().hgetAll(iterator.next()));
		}
		pageStart = pagesize + pageStart;
	}

}
