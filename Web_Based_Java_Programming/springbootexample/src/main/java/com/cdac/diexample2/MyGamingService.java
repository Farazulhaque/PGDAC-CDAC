package com.cdac.diexample2;

import org.springframework.stereotype.Component;

@Component("mygame")
public class MyGamingService implements GamingService {

	@Override
	public String gameInfo() {
		return "Playing Call Of Duty";
	}

}
