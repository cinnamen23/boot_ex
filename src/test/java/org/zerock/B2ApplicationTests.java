package org.zerock;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Board;
import org.zerock.persistence.BoardRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class B2ApplicationTests {

	@Autowired
	BoardRepository repo;
	
	
	@Test
	public void testFind1(){
		Board board= repo.findByBno(200L);
		
		log.info(""+board);
	}
	
	@Test
	public void testFind2(){
		Board board= repo.getByTitle("Title....196");
		
		log.info(""+board);
	}
	
	@Test
	public void testSearchAndPage(){
		
		Pageable page = new PageRequest(0, 20,Sort.Direction.DESC,"bno");  //정렬해서 뽑아주는거 
		
		List<Board> list= repo.findByTitleContaining("15",page);  //뒤에 L 쓰면  Long형으로 캐스팅됨  
		
		list.forEach(board->log.info(""+board));
		
	}
	
	
	
	
	@Test
	public void contextLoads() {
	}

	
	@Test
	public void insertTest(){
		
		for(int i = 1; i <=200;i++){
			Board board = new Board();
			board.setTitle("Title...."+i);
			board.setContent("Content...."+i);
			board.setWriter("writer...."+(i%10));
			repo.save(board);
		}
		
		List<Board> list=(List<Board>)repo.findAll();
		log.info(" "+list);
				
		
		
	}
	
	@Test
	public void findAll(){
		
//		List<Board> list=(List<Board>)repo.findAll();
		log.info(" "+repo.findAll());
		
			
		
	}
	
	@Test
	public void readOne(){
		
//		List<Board> list=(List<Board>)repo.findAll();
		
		
		log.info(""+repo.findOne((long)200));
		
			
		
	}
	
	
	
	
}
