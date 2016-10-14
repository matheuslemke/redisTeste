package com.nosql.redis;

import java.util.Iterator;

public class MainQueryPage extends MainQueryPaginable {

	/**
	 * Consulta principal que lista EM PÁGINA todos os registros em pares
	 * (chave-valor), contendo respectivamente o nome do campo e o valor
	 */
	@Override
	public void nextResult() {
		int pageCount = 0, setKeysCount = 0;
		String key;
		for (Iterator<String> iterator = redisUtil.localKeys().iterator(); iterator
				.hasNext() && (pageCount >= 0 && pageCount < pagesize); setKeysCount++) {
			key = iterator.next();
			if (setKeysCount > setKeysStart) {
				pageCount++;
				System.out.println(Constants.getJedis().hgetAll(key));
			}
		}
		setKeysStart += setKeysCount;
	}

}
