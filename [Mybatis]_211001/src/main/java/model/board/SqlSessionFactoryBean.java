package model.board;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
//회사명이 달라질뿐, Mybatis ibatis와 같다
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
// mybatis 를 이용하는 xml을 수행해줄 Sqlsession객체가 필요하다.(팩토리를 통해 만들어짐)
// SqlSessionFactoryBean > sql-map-config 로 가져와 sessionFactory를 가져올 수 있게 됨

// board-mapping.xml을 사용하기위해 sqlsession을 가져옴
//FB -> SqlSession 객체 생성을 도와주는 친구

public class SqlSessionFactoryBean {

	private static SqlSessionFactory sessionFactory = null;
	// instance (객체)
 
	static {
		try {// 싱글톤패턴을 유지하기 위한 조건문
			if(sessionFactory==null) { 
				Reader reader=Resources.getResourceAsReader("sql-map-config.xml"); // 기본 설정파일을 reader로 읽어들여서
				sessionFactory = new SqlSessionFactoryBuilder().build(reader); // 세션을 줄 수 있는 얘로 만들고
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SqlSession getSqlSessionInstance() {
		//sessionFactory 세션객체를만드는애
		return sessionFactory.openSession(); // 객체화를 하겠다 라는 의미
	}
}
