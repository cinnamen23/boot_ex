package org.zerock.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

	
	public Board findByBno(Long bno); //앞에 bno 틀리면 못시행 
	
	
	public Board getByTitle(String title);
	
	
	public List<Board> findByTitleContaining(String keyword,Pageable pagebale);//와 정렬이 안되 있었는데  그녕 붙여버리면 되버리네 ....무조건 페이지어블은 마지감 파라미터로 넣어여  
	
	
	
}
