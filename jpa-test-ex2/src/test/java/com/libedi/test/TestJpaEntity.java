package com.libedi.test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestJpaEntity {
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	@Before
	public void setup(){
		emf = Persistence.createEntityManagerFactory("jpatest");
	}
	
//	@Test
	public void testCreateEntity(){
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		
		Member member = new Member();
		member.setId("memberA");
		member.setUsername("회원1");
		
		em.persist(member);
		assertEquals(member.getId(), "memberA");
		
		tx.commit();
		
		em.close();
	}
	
//	@Test
	public void testStrategyIdentity(){
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		
		Board board = new Board();
		em.persist(board);		// 이 시점에서 INSERT SQL 실행하여 ID를 가져온다.
		assertEquals(board.getId(), 1);
		
		tx.commit();
		em.close();
	}
	
//	@Test
	public void testStrategySequence(){
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		
		Board board = new Board();
		em.persist(board);		// DB 시퀀스를 사용하여 ID조회. 조회한 ID를 엔티티에 할당하여 영속성 컨텍스트에 저장.
		assertEquals(board.getId(), 1);
		
		tx.commit();		// INSERT SQL 실행
		em.close();
	}
	
	@Test
	public void testStrategyTable(){
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		
		Board board = new Board();
		em.persist(board);
		assertEquals(board.getId(), 1);
		
		tx.commit();
		em.close();
	}
	
	@After
	public void afterSetup(){
		emf.close();
	}

}
