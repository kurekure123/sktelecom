package com.sktelecom.jse.sktserviceImpl;

import java.util.Random;

import com.sktelecom.jse.sktdomain.MemberBean;
import com.sktelecom.jse.sktdomain.PhoneBean;
import com.sktelecom.jse.sktservice.SktService;


public class SktServiceImpl implements SktService{
	MemberBean[] members;
	PhoneBean[] phones;
	private int memberCount, phoneCount, customeNum;
	public SktServiceImpl() {
		memberCount = phoneCount = 0;
		customeNum = 1000;
		customeNum++;
		members = new MemberBean[2];
		phones = new PhoneBean[2];
		// 멤버 변수
	}
	@Override
	public void addCustomer(MemberBean member, 
			PhoneBean phone) {
		String customNum = createCustomeNum();
		System.out.println("생성된 커스텀 넘버 : " + customNum);
		member.setCustomNum("");
		phone.setCustomNum("");
		this.members[memberCount++] = member;
		this.phones[phoneCount++] = phone; 
	}
	
	private String number;
	
	@Override
	public String showMessage(MemberBean member, 
			PhoneBean phone) {
		phone.setNumber(makeNumber());
		addCustomer(member,phone);
		String message = 
				String.format("%s 님의 이름으로 \n"
						+  " %s \n"
						+ " %s 폰이 개통되었습니다 ",
						member.getName(), phone.getNumber(), 
						phone.getBrand());
		return message;
	}
	@Override
	public String makeNumber() {
		int res1 = (int)(Math.random()*9999+0000);
		int res2 = (int)(Math.random()*9999+0000);
		String res = "010-" + res1 +"-"+ res2;
		return res;
		   }
	@Override
	public String createCustomeNum() {
		return String.valueOf(customeNum++);
	}
	
	}


