package com.nosql.redis;

public class MainQueryImpl extends MainQuery {

	/**
	 * Consulta principal que lista todos os registros em pares (chave-valor),
	 * contendo respectivamente o nome do campo e o valor
	 * 
	 */
	@Override
	public void nextResult() {
		for (String key : redisUtil.localKeys())
			System.out.println(Constants.getJedis().hgetAll(key));
	}

}
