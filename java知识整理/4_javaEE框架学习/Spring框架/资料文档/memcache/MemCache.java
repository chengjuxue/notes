/*
 * Project Name: spring-demo
 * File Name: MemCache.java
 * Class Name: MemCache
 *
 * Copyright 2014 Hengtian Software Inc
 *
 * Licensed under the Hengtiansoft
 *
 * http://www.hengtiansoft.com
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.imooc.common.memcache;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

/**
* Class Name: MemCache
* Description: memcache缓存连接.
* @author xiaoxiazhang1
*
*/
public class MemCache {
    private static Logger log = LoggerFactory.getLogger(MemCache.class);

    private Set<String> keySet = new HashSet<String>();
    private final String name;
    private final int expire;
    private final MemcachedClient memcachedClient;

    public MemCache(String name, int expire, MemcachedClient memcachedClient) {
        this.name = name;
        this.expire = expire;
        this.memcachedClient = memcachedClient;
    }

    public Object get(String key) {
        Object value = null;
        try {
            key = this.getKey(key);
            value = memcachedClient.get(key);
        } catch (TimeoutException e) {
            log.warn("获取 Memcached 缓存超时", e);
        } catch (InterruptedException e) {
            log.warn("获取 Memcached 缓存被中断", e);
        } catch (MemcachedException e) {
            log.warn("获取 Memcached 缓存错误", e);
        }
        return value;
    }

    public void put(String key, Object value) {
        if (value == null)
            return;
        try {
            key = this.getKey(key);
            memcachedClient.setWithNoReply(key, expire, value);
            keySet.add(key);
        } catch (InterruptedException e) {
            log.warn("更新 Memcached 缓存被中断", e);
        } catch (MemcachedException e) {
            log.warn("更新 Memcached 缓存错误", e);
        }
    }

    public void clear() {
        for (String key : keySet) {
            try {
                memcachedClient.deleteWithNoReply(this.getKey(key));
            } catch (InterruptedException e) {
                log.warn("删除 Memcached 缓存被中断", e);
            } catch (MemcachedException e) {
                log.warn("删除 Memcached 缓存错误", e);
            }
        }
    }

    public void delete(String key) {
        try {
            key = this.getKey(key);
            memcachedClient.deleteWithNoReply(key);
        } catch (InterruptedException e) {
            log.warn("删除 Memcached 缓存被中断", e);
        } catch (MemcachedException e) {
            log.warn("删除 Memcached 缓存错误", e);
        }
    }

    private String getKey(String key) {
        return name + "_" + key;
    }

}
