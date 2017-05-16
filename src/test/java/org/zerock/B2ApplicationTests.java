package org.zerock;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Board;
import org.zerock.domain.QBoard;
import org.zerock.persistence.BoardRepository;

import com.querydsl.core.BooleanBuilder;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class B2ApplicationTests {

	@Autowired
	BoardRepository repo;
	
	
	
//  동적sql 사용하는것 	
	@Test 
	public void testPrediacte(){
		String type= "t";
		String keyword = "17";
		BooleanBuilder builder = new BooleanBuilder();
		
		QBoard board = QBoard.board;

		 if(type.equals("t")){
		 builder.and(board.title.like("%" + keyword +"%"));
		 }

		 //bno > 0
		 builder.and(board.bno.gt(0L));

		 Pageable pageable = new PageRequest(0, 10);

		 Page<Board> result = repo.findAll(builder,pageable);

		 System.out.println("PAGE SIZE: " + result.getSize());
		 System.out.println("TOTAL PAGES: " + result.getTotalPages());
		 System.out.println("TOTAL COUNT: " + result.getTotalElements());
		 System.out.println("NEXT: " + result.nextPageable());

		 List<Board> list = result.getContent();

		 list.forEach(b -> System.out.println(b)); 

		
		
	}
	
	
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
		
		Page<Board> result= repo.findByTitleContaining("1",page);  //뒤에 L 쓰면  Long형으로 캐스팅됨  
		
		result.forEach(board->log.info(""+board));
		
		log.info(""+result);
		log.info(""+result.getTotalPages());
		log.info(""+result.getSize());
		log.info(""+result.getNumber());
		log.info(""+result.getTotalElements());
		//쿼리 두개 날아갈경우 페이지가 1페이지안에만 있으면 추가 쿼리 안날림 
		//페이지가 10p넘어가면 추가쿼리를 날림 

		result.getContent().forEach(b->log.info(""+b));
		
		
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
