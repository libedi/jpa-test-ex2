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
	
	@Test
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
	
	@Test
	public void testStrategyIdentity(){
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		
		Board board = new Board();
		em.persist(board);
		assertEquals(board.getId(), (long) 1);
		
		tx.commit();
		em.close();
	}
	
	@After
	public void afterSetup(){
		emf.close();
	}

}
