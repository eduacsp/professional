package com.eduacsp.cv.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

public class CacheUtil {

	private static CacheManager cacheManager = CacheManager.getInstance();
	
	private static final String CACHE_ID_CV = "cvCache";

	public static Cache getCacheCv() {
		return cacheManager.getCache(CACHE_ID_CV);
	}
	
	
}
