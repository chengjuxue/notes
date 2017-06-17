/*
 * Project Name: spring-demo
 * File Name: MemcachedCache.java
 * Class Name: MemcachedCache
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

import java.util.concurrent.Callable;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import net.rubyeye.xmemcached.MemcachedClient;

/**
* Class Name: MemcachedCache
* Description: 缓存类.
* @author xiaoxiazhang1
*
*/
public class MemcachedCache implements Cache {
    private final String name;
    private final MemcachedClient memcachedClient;
    private final MemCache memCache;

    public MemcachedCache(String name, int expire, MemcachedClient memcachedClient) {
        this.name = name;
        this.memcachedClient = memcachedClient;
        this.memCache = new MemCache(name, expire, memcachedClient);
    }

    @Override
    public void clear() {
        memCache.clear();
    }

    @Override
    public void evict(Object key) {
        memCache.delete(key.toString());
    }

    @Override
    public ValueWrapper get(Object key) {
        ValueWrapper wrapper = null;
        Object value = memCache.get(key.toString());
        if (value != null) {
            wrapper = new SimpleValueWrapper(value);
        }
        return wrapper;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public MemcachedClient getNativeCache() {
        return this.memcachedClient;
    }

    @Override
    public void put(Object key, Object value) {
        memCache.put(key.toString(), value);
    }

    @Override
    public <T> T get(Object arg0, Class<T> arg1) {
        return null;
    }

    @Override
    public <T> T get(Object arg0, Callable<T> arg1) {
        return null;

    }

    @Override
    public ValueWrapper putIfAbsent(Object arg0, Object arg1) {
        return null;

    }

}
