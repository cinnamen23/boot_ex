package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Board;
import org.zerock.persistence.BoardRepository;

//지금 그 jsp가 없어서 rest 컨트롤러밖에 못쓴다 
@RestController
public class SampleController {

	@Autowired
	BoardRepository repo;
	
	
	@GetMapping
	public Page<Board> list(@PageableDefault(size=10,page=0,direction=Direction.DESC,sort="bno") Pageable page){ //여기서 데이타를 받아야되는데 
								//@PageableDefault(size=10,page=0) 이거 해놓으면 처음에 기본으로 채우는 값 이걸로 채우는거 
		String keyword="1";
		
		
		return repo.findByTitleContaining(keyword, page);
		
		
	}
	
}
