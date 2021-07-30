package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.MemberDto;

@Mapper
@Repository 
public interface MemberDao {
	
	public List<MemberDto> allMember(); // 반드시 id와 매칭시키기!
	
}
