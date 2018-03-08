/*
 * Project Name: spring-demo
 * File Name: MemcachedCacheManager.java
 * Class Name: MemcachedCacheManager
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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.cache.Cache;
import org.springframework.cache.transaction.AbstractTransactionSupportingCacheManager;

import net.rubyeye.xmemcached.MemcachedClient;

/**
* Class Name: MemcachedCacheManager
* Description: 缓存管理类.
* @author xiaoxiazhang1
*
*/
public class MemcachedCacheManager extends AbstractTransactionSupportingCacheManager {
    private ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap<String, Cache>();
    private Map<String, Integer> expireMap = new HashMap<String, Integer>();

    private MemcachedClient memcachedClient;

    public MemcachedCacheManager() {
    }

    @Override
    protected Collection<? extends Cache> loadCaches() {
        Collection<Cache> values = cacheMap.values();
        return values;
    }

    @Override
    public Cache getCache(String name) {
        Cache cache = cacheMap.get(name);
        if (cache == null) {
            Integer expire = expireMap.get(name);
            if (expire == null) {
                expire = 0;
                expireMap.put(name, expire);
            }
            cache = new MemcachedCache(name, expire.intValue(), memcachedClient);
            cacheMap.put(name, cache);
        }
        return cache;
    }

    public void setMemcachedClient(MemcachedClient memcachedClient) {
        this.memcachedClient = memcachedClient;
    }

    public void setConfigMap(Map<String, Integer> configMap) {
        this.expireMap = configMap;
    }

}
