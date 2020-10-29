package com.biz.ems.exec;

import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class NaverSecMack {

	public static void main(String[] args) {

		// 암호화된 네이버 Email 정보를 저장할 파일
		String propsFile = "./src/main/webapp/WEB-INF/spring/naver.sec.properties";

		// 암호화를 수행할때 사용할 salt 추출
		Map<String, String> envList = System.getenv(); // 환경변수 리스트 가져오기
		String saltPass = envList.get("NAVER");

		Scanner scan = new Scanner(System.in);

		System.out.println("Salt Password : " + saltPass);

		if (saltPass == null) {
			System.out.println("\nNAVER 환경변수를 설정한 후 실행해 주세요 ><\n");
			return;
		}

		System.out.print("Email 주소 : ");
		String email = scan.nextLine();
		System.out.print("비밀번호 : ");
		String password = scan.nextLine();
		
		StandardPBEStringEncryptor pbe = new StandardPBEStringEncryptor();
		String encEmail = pbe.encrypt(email);
		String encPass = pbe.encrypt(password);
		
		System.out.println("Email : " + encEmail);
		System.out.println("Pass : " + encPass);

	}
}
