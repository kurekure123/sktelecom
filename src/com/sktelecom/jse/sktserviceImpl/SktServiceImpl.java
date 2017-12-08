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
		members = new MemberBean[4];
		phones = new PhoneBean[4];
		// 멤버 변수
	}
	@Override
	public void addCustomer(MemberBean member, 
			PhoneBean phone) {
		String customNum = createCustomeNum();
		member.setCustomNum(customNum);
		phone.setCustomNum(customNum);
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
						+ " %s 이 개통되었습니다 ",
						member.getName(), phone.getNumber(), 
						phone.getBrand());
		return message;
	}
	@Override
	public String makeNumber() {
		int res1 = (int)(Math.random()*8999+1000);
		int res2 = (int)(Math.random()*8999+1000);
		String res = "010-" + res1 +"-"+ res2;
		return res;
	}
	@Override
	public String createCustomeNum() {
		return String.valueOf(customeNum++);
	}
	@Override
	public String memberList() {
		String res = "";
		for(int i = 0; i < memberCount || i < phoneCount; i++ ) {
			if(members[i].getCustomNum().equals(phones[i].getCustomNum())) {
				res  = res.concat("[고객명] :" + members[i].getName()+"\n".
						concat("[고객번호] :" + members[i].getCustomNum()+"\n".
						concat("[고객 번호] :" + phones[i].getNumber()+"\n")));
			}
		}
		
		return res;
	
	}
	@Override
	public String findBykey(String key) {
		String res = "";
		for(int i = 0; i < phoneCount; i++) {
			if(key.equals(members[i].getCustomNum())) {
				res = res.concat("[고객명] :" + members[i].getName()+"\n".
						concat("[고객번호] :" + members[i].getCustomNum()+"\n".
						concat("[고객 번호] :" + phones[i].getNumber()+"\n")));
				break;
			}
			/* name.equals(this.students[i].getName())
			 * */
		}
		return res;
	}
	@Override
	public String findByName(String name) {
		String res = "";
		for(int i = 0; i < phoneCount; i++) {
			if(name.equals(members[i].getName())) {
				res = res.concat("[고객명] :" + members[i].getName()+"\n".
						concat("[고객번호] :" + members[i].getCustomNum()+"\n".
						concat("[고객 번호] :" + phones[i].getNumber()+"\n")));
			}
		}
		return res;
	}
	
	@Override
	public void updatePhoneNumber(String key, PhoneBean phone) {
		for(int i = 0; i < phoneCount; i++) {
			if(key.equals(members[i].getCustomNum())) {
				phones[i].setNumber(makeNumber());
			}
			String res = String.format("[변경 후 전화번호] : " + phones[i].getNumber());
					
			break;
		}
	}
	
	@Override
	public void deleteMember(String key) {
		// TODO Auto-generated method stub
		
	}
}
/*
 * 	public void addCustomer(MemberBean member, 
			PhoneBean phone) {
			String customNum = createCustomeNum();
			member.setCustomNum(customNum);
			phone.setCustomNum(customNum);
			this.members[memberCount++] = member;
			this.phones[phoneCount++] = phone; 
 * */

