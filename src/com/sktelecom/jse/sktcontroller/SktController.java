package com.sktelecom.jse.sktcontroller;

import java.util.Random;

import javax.swing.JOptionPane;

import com.sktelecom.jse.sktdomain.MemberBean;
import com.sktelecom.jse.sktdomain.PhoneBean;
import com.sktelecom.jse.sktserviceImpl.SktServiceImpl;

public class SktController {
	public static void main(String[] args) {
		String res = "";
		PhoneBean phone = null;
		MemberBean member = null;
		SktServiceImpl service = new SktServiceImpl();
		while(true) {
			switch(Integer.parseInt(JOptionPane.showInputDialog("0. 종료, 1.개통, 2. 목록,  \n"
					+ "3. 고객번호 검색, 4. 고객명 검색 \n"
					+ "5. 번호 변경"))) {
			case 0 : 
				JOptionPane.showMessageDialog(null, "종료");
				return;
			case 1 : 
				phone = new PhoneBean();
				member = new MemberBean();
				phone.setBrand(JOptionPane.showInputDialog("어떤 폰으로 하시려구요? \n"
						+ " (1 걘역시, 2. 아이뻐)").equals("1")? "걘역시 " : "아이뻐");
				member.setName(JOptionPane.showInputDialog("가입하신 분의 성함을 입력해주세요"));
				JOptionPane.showMessageDialog(null, service.showMessage(member, phone));
				//sktBean.toString()
				break;
			case 2 : 
				JOptionPane.showMessageDialog(null, service.memberList());
					break;
				//service.list
			case 3 :
				JOptionPane.showMessageDialog(null, service.findBykey(JOptionPane.showInputDialog("찾으시는 고객번호 입력")));
				break;

			case 4 :
				JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("찾으시는 고객이름 입력")));
				break;
				
			case 5 :
				break;
			}
			
		}
	}
}
