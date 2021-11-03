package com.lee.app.board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Client {
	public static void main(String[] args) {
		// 영속성 유닛을 넣어주어야 한다.    // Persistence가 xml을 인지한다.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager(); // == DAO 클래스생성 (CRUD하는 클래스)

		EntityTransaction et = em.getTransaction();

		try {
			et.begin();

			Board board = new Board(); // 자바객체 생성
			board.setTitle("JPA실습");
			board.setWriter("J");
			board.setContent("PA");
      // insert
			// 위의 데이터를 Entity 매니저가 등록함  
			em.persist(board); // insert문을 생성해주는 코드
			et.commit(); // commit
			
	  // select All
			 // JPQL : sql문들의 표준, JPA구현체가 읽어들여서 해당 DBMS의 sql문으로 처리
			String jpql = "select b from Board b"; // b: 별칭 같은의미 (모든 컬럼이라는 의미에 해당)
			List<Board> datas = em.createQuery(jpql, Board.class).getResultList();
			
			for(Board v : datas) {
				System.out.println(v);
			}
			
			
		}
		catch(Exception e) {
			et.rollback(); // 문제가 생기면
			
		}finally {
			em.close();
			emf.close();
		}


	}
}
