package com.sktelecom.jse.sktserviceImpl;

import java.util.Random;

import com.sktelecom.jse.sktdomain.MemberBean;
import com.sktelecom.jse.sktdomain.PhoneBean;
import com.sktelecom.jse.sktservice.SktService;


public class SktServiceImpl implements SktService{
	MemberBean[] members;
	PhoneBean[] phones;
	private int memberCount, phoneCount;
	public SktServiceImpl() {
		members = new MemberBean[2];
		phones = new PhoneBean[2];
	}
	public void addCustomer(MemberBean member, 
			PhoneBean phone) {
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
		int res1 = (int)(Math.random()*10000+1);
		int res2 = (int)(Math.random()*10000+1);
		String res = "010-" + res1 +"-"+ res2;
		return res;
		   }
	}

