package com.smart.sso.base.entity;

/**
 * 含时效功能的对象包装器
 *
 * @param <T>
 * @author Joe
 */
public class ExpirationWrapper<T> {

    private T object;

    /**
     * 过期时间
     */
    private Long expired;

    public ExpirationWrapper() {
        super();
    }

    public ExpirationWrapper(T object, int expiresIn) {
        super();
        this.object = object;
        this.expired = System.currentTimeMillis() + expiresIn * 1000;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Long getExpired() {
        return expired;
    }

    public void setExpired(Long expired) {
        this.expired = expired;
    }

    /**
     * 校验是否过期，true为已过期，false未未过期
     *
     * @return
     */
    public boolean checkExpired() {
        return System.currentTimeMillis() > getExpired();
    }
}