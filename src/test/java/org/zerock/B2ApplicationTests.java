package org.zerock;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
