package use;
//����Ϸ��� Ŭ������ ��ġ �˷��ش�
import bank.Account;

class UseAccount
{
	public static void main(String[] args) 
	{
		Account acc = new Account();//���� Ŭ���� ����(public�̶� ������� ������ ����)
		//���������ں� ����
		//System.out.println(acc.bank); //public
		//System.out.println(acc.customer);//protected: ��Ӱ��質 ���� ��Ű�� ��츸 ����
		//System.out.println(acc.num);//default: ���� ��Ű���� Ŭ���������� �������, protected���� �Ѵܰ� �� ��ٷӴ�.
		//System.out.println(acc.balance);//private: Account Ŭ���� �����θ� ���ٰ���
		//acc.balance=10; //�̰� ���������̹Ƿ� �Ұ���
		acc.setBalance(10);//�޼��带 �̿��� ���ٹ������ ����
		//������ private������ ����ϰ� ������ ������ �� ���� ����-->��� ���� �޼��带 �������־�� �Ѵ�.
		System.out.println(acc.getBalance());
	}
}
