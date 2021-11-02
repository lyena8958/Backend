package model.board;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
//ȸ����� �޶�����, Mybatis ibatis�� ����
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
// mybatis �� �̿��ϴ� xml�� �������� Sqlsession��ü�� �ʿ��ϴ�.(���丮�� ���� �������)
// SqlSessionFactoryBean > sql-map-config �� ������ sessionFactory�� ������ �� �ְ� ��

// board-mapping.xml�� ����ϱ����� sqlsession�� ������
//FB -> SqlSession ��ü ������ �����ִ� ģ��

public class SqlSessionFactoryBean {

	private static SqlSessionFactory sessionFactory = null;
	// instance (��ü)
 
	static {
		try {// �̱��������� �����ϱ� ���� ���ǹ�
			if(sessionFactory==null) { 
				Reader reader=Resources.getResourceAsReader("sql-map-config.xml"); // �⺻ ���������� reader�� �о�鿩��
				sessionFactory = new SqlSessionFactoryBuilder().build(reader); // ������ �� �� �ִ� ��� �����
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SqlSession getSqlSessionInstance() {
		//sessionFactory ���ǰ�ü������¾�
		return sessionFactory.openSession(); // ��üȭ�� �ϰڴ� ��� �ǹ�
	}
}
