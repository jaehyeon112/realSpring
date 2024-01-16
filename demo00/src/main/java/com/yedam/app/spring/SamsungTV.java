package com.yedam.app.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV{
	@Autowired
	
	Speaker speaker;
	
	SamsungTV(Speaker speaker){
		this.speaker =speaker;
	}
	
	SamsungTV(){}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	
@Override
public void on() {
	// TODO Auto-generated method stub
	System.out.println("삼성 TV를 켰습니다.");
	speaker.on();
}
	
}
