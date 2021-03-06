package com.nosql.redis;

import java.util.Iterator;
import java.util.List;

public class MainQueryPageInput extends MainQueryPaginable {

	private String input;
	private List<String> fieldsToFiltrate;

	/**
	 * @param input
	 *            Texto a ser pesquisado
	 * @param fieldsToFiltrate
	 *            Lista com os nomes dos campos a serem filtrados
	 */
	public MainQueryPageInput(String input, List<String> fieldsToFiltrate) {
		super();
		this.input = input;
		this.fieldsToFiltrate = fieldsToFiltrate;
	}

	/**
	 * Consulta principal com restrição que lista todos os registros EM PÁGINA
	 * que atendem a restrição em pares (chave-valor), contendo respectivamente
	 * o nome do campo e o valor
	 * 
	 */
	@Override
	public void nextResult() {
		int pageCount = 0, setKeysCount = 0;
		String key;
		for (Iterator<String> iterator = redisUtil.localKeys().iterator(); iterator
				.hasNext() && (pageCount >= 0 && pageCount < pagesize); setKeysCount++) {
			key = iterator.next();
			if (setKeysCount > setKeysStart)
				if (redisUtil.isUseful(key, input, fieldsToFiltrate)) {
					pageCount++;
					System.out.println(Constants.getJedis().hgetAll(key));
				}
		}
		setKeysStart += setKeysCount;
	}
}
