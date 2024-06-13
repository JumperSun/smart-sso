package com.smart.sso.server.token;

import com.smart.sso.base.entity.Expiration;
import com.smart.sso.base.entity.LifecycleManager;
import com.smart.sso.server.entity.CodeContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * 授权码code管理
 *
 * @author Joe
 */
public abstract class CodeManager implements LifecycleManager<CodeContent>, Expiration {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 生成授权码
     *
     * @param tgt
     * @param redirectUri
     * @return
     */
    public String generate(String tgt, String redirectUri) {
        String code = "code-" + UUID.randomUUID().toString().replaceAll("-", "");
        create(code, new CodeContent(tgt, redirectUri));
        return code;
    }

    /*
     * code失效时间默认为10分钟
     */
    @Override
    public int getExpiresIn() {
        return 600;
    }
}
