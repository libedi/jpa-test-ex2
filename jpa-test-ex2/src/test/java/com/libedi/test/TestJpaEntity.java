package com.libedi.test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

public class TestJpaEntity {
	EntityManagerFactory emf;
	
	@Before
	public void setup(){
		emf = Persistence.createEntityManagerFactory("jpatest");
	}
	
	@Test
	public void testCreateEntity(){
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Member member = new Member();
		member.setId("memberA");
		member.setUsername("회원1");
		
		em.persist(member);
		assertEquals(member.getId(), "memberA");
		
		tx.commit();
		
		em.close();
		emf.close();
	}

}
