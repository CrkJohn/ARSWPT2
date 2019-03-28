package com.example.persistence.repositories;

import java.io.IOException;

public interface IWeatherRepository {
	public String getInfoWeather(String city) throws IOException;
}
