package com.libedi.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
//@SequenceGenerator(
//		name = "BOARD_SEQ_GENERATOR",
//		sequenceName = "BOARD_SEQ",		// 매핑할 데이터베이스 시퀀스 이름
//		initialValue = 1,
//		allocationSize = 1
//		)
@TableGenerator(
		name = "BOARD_SEQ_GENERATOR",
		table = "MY_SEQUENCES",			// 매핑할 키생성 테이블 이름
		pkColumnValue = "BOARD_SEQ",
		allocationSize = 1
		)
public class Board {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "BOARD_SEQ_GENERATOR")
	private long id;
	
	@Column
	private String data;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
