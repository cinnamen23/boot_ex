package org.zerock.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>,QueryDslPredicateExecutor<Board> {

	
	public Board findByBno(Long bno); //앞에 bno 틀리면 못시행 
	
	
	public Board getByTitle(String title);
	
	
//	public List<Board> findByTitleContaining(String keyword,Pageable pagebale);//와 정렬이 안되 있었는데  그녕 붙여버리면 되버리네 ....무조건 페이지어블은 마지감 파라미터로 넣어여  
	
	@Query("SELECT b From Board b WHERE b.bno > 0")  //@Query("")이러고 실행하면 오류 로딩 안됨 
	public List<Board> findAll(Pageable page);
	
	
	public Page<Board> findByTitleContaining(String keyword,Pageable pagebale);//와 정렬이 안되 있었는데  그녕 붙여버리면 되버리네 ....무조건 페이지어블은 마지감 파라미터로 넣어여  
	
	
}
