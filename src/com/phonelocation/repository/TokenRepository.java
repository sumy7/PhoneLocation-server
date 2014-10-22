package com.phonelocation.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.phonelocation.model.Token;

@Repository
public class TokenRepository {

	private HashMap<String, Token> map = new HashMap<String, Token>();

	public Token insert(Token token) {
		token.setTokenid(UUID.randomUUID().toString());
		map.put(token.getTokenid(), token);
		return token;
	}

	public Token findByTokenId(String tokenId) {
		Token token = map.get(tokenId);
		return token;
	}

	public int cleanUp() {
		List<String> cleanset = new ArrayList<String>();
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			String key = (String) entry.getKey();
			Token val = (Token) entry.getValue();
			if (System.currentTimeMillis() > val.getDeadline()) {
				cleanset.add(key);
			}
		}
		for (String key : cleanset) {
			map.remove(key);
		}
		return cleanset.size();
	}
}
