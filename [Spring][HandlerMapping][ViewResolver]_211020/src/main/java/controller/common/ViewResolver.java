package controller.common;

// �ڵ鷯������ �����ڷ� �ʱ�ȭ�� �ϴ� �ݸ�,
// ViewResolver�� Setter�� �ʱ�ȭ�Ѵ�.
public class ViewResolver {
	
	//�Ӹ���
	public String prefix; // head
	//������
	public String suffix; // tail
	
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	// ��Ʈ�ѷ��� ������ ��ġ��, ���� �����ϴ��� ������ �ִ� ��
	//  ����Ʈ�ѷ��� �����
	public String getView(String view) {
		return prefix+view+suffix;
	}
	
	
}
