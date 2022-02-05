package com.cdac.diexample2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("gamercomponent")
public class Gamer implements User {

	@Autowired
	@Qualifier("mygame")
	MyGamingService mygameservice;

	@Override
	public void doWork() {
		String gameName = mygameservice.gameInfo();
		System.out.println("Game is " + gameName);
	}

}
