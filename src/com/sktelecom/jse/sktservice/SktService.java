package com.sktelecom.jse.sktservice;

import com.sktelecom.jse.sktdomain.MemberBean;
import com.sktelecom.jse.sktdomain.PhoneBean;

public interface SktService {
	public String showMessage(MemberBean member, PhoneBean phone);
	public String makeNumber();
	public String createCustomeNum();
	public void addCustomer(MemberBean member, 
			PhoneBean phone);
	
}
