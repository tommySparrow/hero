package com.house.hero.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 */
public class RedisUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisUtil.class);

    private RedisTemplate<String, Object> redisTemplate;

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 执行set操作
     *
     * @param key   key值
     * @param value value值
     * @return boolean 是否设置成功 true:成功 false:失败
     */
    public boolean set(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            LOGGER.error("Redis设置获取缓存失败,key:[{}],value:[{}],原因:[{}]", key, value, e.getMessage());
        }
        return false;
    }

    /**
     * 执行set操作并且设置生存时间，单位为：秒
     *
     * @param seconds 有效时间
     * @param key     key值
     * @param value   value值
     * @return boolean 是否设置成功 true:成功 false:失败
     */
    public boolean set(String key, String value, Integer seconds) {
        try {
            if (seconds > 0) {
                redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            LOGGER.error("Redis设置获取缓存失败,key:[{}],value:[{}],原因:[{}]", key, value, e.getMessage());
        }
        return false;
    }

    /**
     * 执行incr操作,将值加1
     *
     * @param key   key值
     * @param value value值
     * @return Long 加1后的值
     */
    public Long incr(String key, Long value) {
        try {
            return redisTemplate.opsForValue().increment(key, value);
        } catch (Exception e) {
            LOGGER.error("Redis根据key:[{}]incr失败,原因:[{}]", key, value, e.getMessage());
        }
        return null;
    }

    /**
     * 执行get操作
     *
     * @param key key值
     * @return String
     */
    public String get(String key) {
        try {
            Object object = redisTemplate.opsForValue().get(key);

            if (null != object) {
                return Objects.requireNonNull(redisTemplate.opsForValue().get(key)).toString();
            }
        } catch (Exception e) {
            LOGGER.error("Redis根据[{}]获取缓存失败,原因:[{}]", key, e.getMessage());
        }
        return null;
    }

    /**
     * 执行删除操作
     *
     * @param key key值
     * @return boolean 是否删除成功 true:成功 false:失败
     */
    public boolean delete(String key) {
        try {
            return redisTemplate.delete(key);
        } catch (Exception e) {
            LOGGER.error("Redis根据key:[{}]删除失败,原因:[{}]", key, e.getMessage());
        }
        return false;
    }

    /**
     * 设置生存时间，单位为：秒
     *
     * @param seconds 生存时间
     * @param key     key值
     * @return boolean 是否设置成功 true:成功 false:失败
     */
    public boolean expire(String key, Integer seconds) {
        try {
            if (seconds > 0) {
                redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            LOGGER.error("Redis根据key:[{}]删除失败,原因:[{}]", key, e.getMessage());
        }
        return false;
    }
}
