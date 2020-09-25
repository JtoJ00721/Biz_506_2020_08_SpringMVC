package com.biz.book.service.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/*
 * spring security 프로젝트에서 
 * 사용자 인가와 권한을 관리하는 클래스
 * UserDetailService를 Customizing
 * 
 *  Customizing
 *  패키지형 솔루션을 가지고 있는 IT 회사에서
 *  어떤 회사에 솔루션을 판매하면서
 *  회사의 실정, 업무환경, 여러가지 여건들을 요구분석하여
 *  솔루션을 사용하는 회사에 최적화 하는 것
 */
public class UserDetailServiceImplV1 implements UserDetailsService{

	/*
	 * 이 프로젝트에서 사용할 member(user)관련 테이블에서 username으로
	 * 사용자 정보를 SELECT하고
	 * 사용자의 ROLL 정보를 기준으로 사용자의 권한을 설정하여
	 * 기능수행을 제인하는 설정을 하고
	 * 사용자의 여러 세부 정보를 VO 객체에 담아주는 역할을 수행
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return null;
	}
	
	
	
}
