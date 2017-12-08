package com.sktelecom.jse.sktservice;

import javax.xml.ws.Service;

import com.sktelecom.jse.sktdomain.MemberBean;
import com.sktelecom.jse.sktdomain.PhoneBean;

public interface SktService {
	public String showMessage(MemberBean member, PhoneBean phone);
	public String makeNumber();
	public String createCustomeNum();
	public void addCustomer(MemberBean member, 
			PhoneBean phone);
	public String memberList();
	public String findBykey(String key);
	public String findByName(String name);
	public void updatePhoneNumber(String key, PhoneBean phone);
	public void deleteMember(String key);
}
