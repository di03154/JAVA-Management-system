package lastExam;
import java.util.Scanner;
public class good {
	Scanner sc = new Scanner(System.in);
	CarPriceList list = new CarPriceList();
	public static void main(String[] args) {
		good go = new good();
		go.mane();
	}
	void mane()	{
		int num = 0;
		do{
			System.out.println("-----------------");
			System.out.println("������ ���α׷�");
			System.out.println("-----------------");
			System.out.println("���ڸ� �Է��Ͻÿ�.");
			System.out.println("1. ��ǰ �԰�");
			System.out.println("2. ��ǰ ���");
			System.out.println("3. ���� ��� ���");
			num = sc.nextInt();
			if(num == 1)
				inn();
			else if(num == 2)
				outt();
			else if(num == 3)
				envi();	
			else	{
				System.out.println("���ڸ� �߸� �Է��ϼ̽��ϴ�.");
				System.out.println("�ٽ� �Է��Ͻÿ�.");
			}
		}while(num < 4 && num >= 1);
	}
	void inn()	{
		System.out.println("-----------------");
		System.out.println("��ǰ �԰�");
		System.out.println("-----------------");
		System.out.print("��ǰ���� �Է��ϼ���: ");
		String model = sc.next();
		System.out.print("�԰� ���� �Է��ϼ���: ");
		int seq = sc.nextInt();
		list.setCarPrice(model, seq);
		return;
	}
	
	void outt()	{
		System.out.println("-----------------");
		System.out.println("��ǰ ���");
		System.out.println("-----------------");
		System.out.print("��ǰ���� �Է��ϼ���: ");
		String model = sc.next();
		System.out.print("��� ���� �Է��ϼ���: ");
		int seq = sc.nextInt();
		list.setCarPrice(model, -seq);
		return;
	}
	void envi()	{
		System.out.println("1)��ǰ��");
		System.out.println(CarPrice.carModel);
		System.out.println("2)�з���");
		System.out.print("Sedan: ");
		System.out.println(list.product[0].amountOfCards + list.product[1].amountOfCards);
		System.out.print("suv: ");
		System.out.println(list.product[2].amountOfCards + list.product[3].amountOfCards);
		System.out.println("�ڻ���Ȳ: ");
		System.out.println(CarPrice.carPrice);
		return;
	}
}
// �԰�, ���
class CarPriceList	{
	// �� �ڵ����� ��ü�� ��´�
	CarPrice carprice;
	Product[] product = {new X5(), new X3(), new M5(), new M3()};
	String carModel;
	// �� �𵨰� ������ �Է��ϸ� �� �� ���� �԰��� �� ������ �� �� �ִ�.
	void setCarPrice(String carModel, int argPrice)	{
		if(carModel.equals("X5"))	{
			this.carModel =  carModel;
			product[0].amountOfCards += argPrice;
			getCarPrice(900*argPrice);
		}
		else if(carModel.equals("X3")) {
			this.carModel =  carModel;
			product[1].amountOfCards += argPrice;
			getCarPrice(500 * argPrice);
		}
		else if(carModel.equals("M5")) {
			this.carModel =  carModel;
			product[2].amountOfCards += argPrice;
			getCarPrice(400 * argPrice);
		}
		else if(carModel.equals("M3")) {
			this.carModel =  carModel;
			product[3].amountOfCards += argPrice;
			getCarPrice(200 * argPrice);
		}
		return;
	}
	// �� ���� ��ü ������ 
	int getCarPrice(int argPrice)	{
		carprice = new CarPrice(carModel, argPrice);
		return argPrice;
	}
}

class CarPrice	{
	static String carModel ="";
	static int carPrice;
	CarPrice(String argModel, int argPrice)	{
		if(argPrice > 0)	{
			carModel += argModel + ": " + argPrice + " ";
		}
		carPrice += argPrice;
	}
}
class Product	{
	
	private String model;
	public String type;
	private int totalPrice;
	static int i = 0;
	private int id;
	int amountOfCards;
	{
		id = i++;
	}
	Product(String argModel)	{
		type = argModel;
	}
	int getId()	{
		return id;
	}
	int getPrice()	{
		return CarPrice.carPrice;
	}
	String getModel()	{
		return model;
	}
	
}
class Suv extends Product	{
	Suv(String argModel)	{
		super(argModel);
		type = "Suv";
	}
}
class Sedan extends Product	{
	Sedan(String argModel){
		super(argModel);
		type = "Sedan";
	}
}
class X5 extends Suv	{
	X5()	{
		super("X5");
	}
}
class X3 extends Suv	{
	X3()	{
		super("X3");
	}
}
class M5 extends Sedan	{
	M5()	{
		super("M5");
	}
}
class M3 extends Sedan	{
	M3()	{
		super("M3");
	}
}
