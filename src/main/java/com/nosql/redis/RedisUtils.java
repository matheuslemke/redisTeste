package com.nosql.redis;

import java.util.List;
import java.util.Set;

public class RedisUtils {
	/**
	 * Todas as chaves de local
	 * 
	 * @return Conjunto contendo as strings das chaves
	 */
	public Set<String> localKeys() {
		return Constants.getJedis().keys("local:*");
	}

	/**
	 * Verifica se pelo menos um valor contém o texto de entrada
	 * 
	 * @param key
	 *            Chave do registro
	 * @param input
	 *            Texto a ser pesquisado
	 * @return Existe a correspondência do texto em pelo menos um valor?
	 */
	public boolean isUseful(String key, String input, List<String> fieldsToFiltrate) {
		for (String fieldName : fieldsToFiltrate)
			if (isUseful(key, fieldName, input))
				return true;
		return false;
	}

	/**
	 * Verifica se o valor de um campo corresponde ao texto de entrada
	 * 
	 * @param key
	 *            Chave do registro
	 * @param fieldName
	 *            Nome do campo
	 * @param input
	 *            Texto a ser pesquisado
	 * @return Existe a correspondência do texto no valor do campo?
	 */
	private boolean isUseful(String key, String fieldName, String input) {
		String field = Constants.getJedis().hget(key, fieldName);
		if (field != null && field.matches("(?i).*" + input + ".*"))
			return true;
		return false;
	}
}
