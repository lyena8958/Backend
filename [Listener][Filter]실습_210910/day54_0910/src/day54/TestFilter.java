package day54;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class TestFliter
 */
//@WebFilter("/TestFilter") // 어노테이션을 보고 기억해두었다가 실행시킬수가 있다. 컨테이너가
@WebFilter("*.jsp") // ★ 모든 jsp페이지가 필터가 작용되게 설정
public class TestFilter implements Filter {

	private String encoding; // 다국어 처리 //web.xml에서 설정해놓은 파라미터를 가져와야한다.
	
    /**
     * Default constructor. 
     */
    public TestFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */ //③ 동작 해제 (conn close처럼)  (1회)
    // 톰캣 꺼진 이후에 실행
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 *///②필터가 작동할 때마다 동작 (.jsp를 부를 때마다)									// 다음필터를 의미
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(this.encoding);

		// pass the request along the filter chain
		chain.doFilter(request, response); // 다음 체인(필터)를 의미, 없으면 알아서 사라짐!
	}

	/**
	 * @see Filter#init(FilterConfig)
	 *
	 */
	// 서버가 동작하면 아래 필터를 인지함!!
	
	// ①필터를 초기화하는 작업
	// 동작될 때 필터를 생성 초기생성   (1회)
	// web.xml에서 설정해놓은 초기화 매개변수로 동작을 수행(외부에 설정해놓은 초기화 인코딩을 할거야!)
	public void init(FilterConfig fConfig) throws ServletException {
		// 외부파일 web.xml에서 등록해놓은 초기화 매개변수 값(==UTF-8)을
		// 멤버변수로 가져옴
		this.encoding = fConfig.getServletContext().getInitParameter("encoding");
	}

}
