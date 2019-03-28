package com.example.persistence;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.HttpConnection.HttpConnectionExample;
import com.example.persistence.repositories.IWeatherRepository;
import com.zaxxer.hikari.util.ConcurrentBag;


@Component
public class inMemoryWeatherRepository implements IWeatherRepository{
	
	@Autowired
	HttpConnectionExample connectionExample;
	

	ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();

	ConcurrentHashMap<String,Long> mapTime = new ConcurrentHashMap<>();
	
	@Override
	public String getInfoWeather(String city) throws IOException {
		long fiveMinutes = 1000000000 * 5;
		if(mapTime.contains(city)) {
			long time = System.nanoTime() - mapTime.get(city);
			if(time > fiveMinutes) {
				String newInfo = connectionExample.getHttpConnection(city);
				Long  newTime = System.nanoTime();
				map.replace(city, newInfo);
				mapTime.replace(city, newTime);
				return newInfo;
			}else {
				return map.get(city);
			}
		}else {
			String newInfo = connectionExample.getHttpConnection(city);
			Long  newTime = System.nanoTime();
			map.put(city, newInfo);
			mapTime.put(city, newTime);
			return newInfo;
		}
	}
	
	
	
	
}
