package controller;

// ���������޹��, ���(��������)
public class ActionForward {
	
	// ������ ���޹��
	private boolean redirect; //redirect�� ������ �ַ� �ȳ��� �� ���ȴ�. (������ �� ������ url Query�� �̿��ϸ� �� control.jsp?action...)
	// true
	// false == forward����� ���(������ ������ ���� �� request��� ��)
	
	// ���
	private String path;
	
	
	//boolean�� get�� �ƴ� is�� ��Ī�� �����ϴ�. (���� �ڹٿ��� isEmpty..�� �̷����!)
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
