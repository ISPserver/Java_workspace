package bank;

//���� ���¸� ����: �������� 
//��Ű���� ���� Ŭ������ public���� �������� ������, �ٸ� ��� Ŭ������ �� Ŭ������ ��� �Ұ�.
public class  Account 
{
	/*���¿� �� ���� �Ӽ��� ����*/
	public String bank="�츮����";//�����
	protected String customer; //���̸�
	private int balance=1000000; //�ݾ� > �߿��� ����
	String num="022-388-85465"; //���¹�ȣ

	//private�� ����� ������ ���� �ܺο��� ���� �� �� �����Ƿ�,
	//������ �����Ϸ��� �޼��带 �̿��ؾ� �Ѵ�.
	public void setBalance(int balance){
		this.balance=balance;
	}
	//�̿� ���� private�� ����� ������ ���� �����ϴ� �޼��带 getter ��� �Ѵ�!
	//���� setBalanceó�� ���� �����ϴ� �޼��带 setter��� �Ѵ�!
	//���Ϳ� ���ʹ� ���� ���� ������ �޼��� ���� ���
	//�ܰ�Ȯ�� �޼��� ����	
	public int getBalance(){
		return balance;
	}
}
/*
class customer{
	private String name;
	private int age;
	private boolean isMarry;
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}

	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}

	public void setIsMarry(boolean isMarry){
		this.isMarry=isMarry;
	}
	public boolean getIsMarry(){
		return IsMarry;
	}

}

*/

