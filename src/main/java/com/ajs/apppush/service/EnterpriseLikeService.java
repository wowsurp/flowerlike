package com.ajs.apppush.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.ajs.apppush.entity.EnterpriseLike;
import com.ajs.apppush.input.enterpriseLike.SaveEnterpriseLike;

public interface EnterpriseLikeService {

	public List<EnterpriseLike> getAllEnterpriseLike();
	
	public EnterpriseLike getEnterpriseLike(int idx);
	public EnterpriseLike saveEnterpriseLike(SaveEnterpriseLike enterpriseLikeInput) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
}
