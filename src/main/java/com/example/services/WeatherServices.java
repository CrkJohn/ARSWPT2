package com.example.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HttpConnection.HttpConnectionExample;
import com.example.persistence.repositories.IWeatherRepository;
import com.example.services.contracts.IWeatherServices;


@Service
public class WeatherServices implements IWeatherServices {

	@Autowired
	IWeatherRepository weatherRepository;
	
	@Override
	public String getHttpConnection(String city) {
		try { 
			return weatherRepository.getInfoWeather(city);
		} catch (IOException e) {
			e.printStackTrace();
			return "Error al buscar la ciudad " + city;
		}
	}

}
