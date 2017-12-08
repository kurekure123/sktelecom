package com.sktelecom.jse.sktcontroller;

import java.util.Random;

import javax.swing.JOptionPane;

import com.sktelecom.jse.sktdomain.MemberBean;
import com.sktelecom.jse.sktdomain.PhoneBean;
import com.sktelecom.jse.sktserviceImpl.SktServiceImpl;

public class SktController {
	public static void main(String[] args) {
		PhoneBean phone = null;
		MemberBean member = null;
		SktServiceImpl service = new SktServiceImpl();
		while(true) {
			switch(Integer.parseInt(JOptionPane.showInputDialog("0. 종료, 1.개통, 2. 목록"))) {
			case 0 : 
				JOptionPane.showMessageDialog(null, "종료");
				return;
			case 1 : 
				phone = new PhoneBean();
				member = new MemberBean();
				phone.setBrand(JOptionPane.showInputDialog("어떤 폰으로 하시려구요? \n"
						+ " 1 갤럭시, 2. 아이폰"));
				member.setName(JOptionPane.showInputDialog("가입하신 분의 성함을 입력해주세요"));
				JOptionPane.showMessageDialog(null, service.showMessage(member, phone));
				//sktBean.toString()
				break;
			case 2 : 
				phone = new PhoneBean();
				member = new MemberBean();
				
				JOptionPane.showMessageDialog(null, "");
				//service.list
				break;
			}
			
		}
	}
}
