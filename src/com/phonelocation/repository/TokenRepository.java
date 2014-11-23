package com.phonelocation.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.phonelocation.model.Token;

/**
 * Token仓库。在内存中保存Token，未写入数据库
 * 
 * @author sumy
 *
 */
@Repository
public class TokenRepository {

    private HashMap<String, Token> map = new HashMap<String, Token>();

    /**
     * 保存Token
     * 
     * @param token
     *            需要保存的Token
     * @return 保存后的Token
     */
    public Token insert(Token token) {
        token.setTokenid(UUID.randomUUID().toString()); // 生成TokenID
        map.put(token.getTokenid(), token);
        return token;
    }

    /**
     * 通过TokenID查找Token
     * 
     * @param tokenId
     *            查找字段
     * @return 查找到的Token
     */
    public Token findByTokenId(String tokenId) {
        Token token = map.get(tokenId);
        return token;
    }

    /**
     * 清除过期的Token（测试用）
     * 
     * @return 清除的Token数量
     */
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
