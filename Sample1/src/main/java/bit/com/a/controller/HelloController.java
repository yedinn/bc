package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@RestController  // == @Controller + @Responsebody (ajax사용할때) -> Restful
public class HelloController {

	@Autowired
	MemberService service;
	
	
	@RequestMapping(value="//", method=RequestMethod.GET)
	public String hello() {   // 여기서 String은 jsp명칭이 아님 
		System.out.println("HelloController hello()"+ new Date()); // boot에서는 logger 사용안함 
		
		return "hello"; // hello.jsp가 아님 !!
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test() {   // 여기서 String은 jsp명칭이 아님 
		System.out.println("HelloController test()"+ new Date()); // boot에서는 logger 사용안함 
		
		return "테스트"; // test.jsp가 아님 !!
	}
	
	@RequestMapping(value="/member", method=RequestMethod.GET)
	public MemberDto getMember() {
		System.out.println("HelloController getMember()"+ new Date()); 
		
		MemberDto dto = new MemberDto("abc", "123", "홍길동", "abc@gamil.com", 3);
		
		return dto; // 백엔드에서 웹으로 내보내는것 
	}
	
	
	@RequestMapping(value="/conn_param", method= RequestMethod.GET)
	public String conn_param(String title) {
		System.out.println("HelloController conn_param()"+ new Date()); 
		System.out.println("title:"+ title);
		
		return "conn success";
	}
	
	
	@RequestMapping(value="/conn_param_obj", method= RequestMethod.GET)
	public String conn_param_obj(MemberDto dto) {
		System.out.println("HelloController conn_param_obj()" + new Date());
		System.out.println(dto.toString());
		
		return "YES";
	}
	
	
	@RequestMapping(value="/dbtest", method= RequestMethod.GET)
	public List<MemberDto> dbtest(){
		System.out.println("HelloController dbtest()" + new Date());
		
		List<MemberDto> list = service.allMember();
		return list;
		
		
	}
	

	
}
