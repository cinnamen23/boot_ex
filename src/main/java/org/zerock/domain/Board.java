package org.zerock.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name="tbl_boards")
public class Board { //엔티티 클래스  crud 하는게 엔티티다  

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //오토 인크리먼트 
	private Long bno;
	private String title;
	private String content;
	private String writer;
	
}
