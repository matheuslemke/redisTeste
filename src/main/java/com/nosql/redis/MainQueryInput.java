package com.nosql.redis;

import java.util.List;

public class MainQueryInput extends MainQuery {

	private String input;
	private List<String> fieldsToFiltrate;

	/**
	 * @param input
	 *            Texto a ser pesquisado
	 * @param fieldsToFiltrate
	 *            Lista com os nomes dos campos a serem filtrados
	 */
	public MainQueryInput(String input, List<String> fieldsToFiltrate) {
		super();
		this.input = input;
		this.fieldsToFiltrate = fieldsToFiltrate;
	}

	/**
	 * Consulta principal com restrição que lista todos os registros que atendem
	 * a restrição em pares (chave-valor), contendo respectivamente o nome do
	 * campo e o valor
	 * 
	 */
	@Override
	public void nextResult() {
		for (String key : redisUtil.localKeys())
			if (redisUtil.isUseful(key, input, fieldsToFiltrate))
				System.out.println(Constants.getJedis().hgetAll(key));
	}

}
