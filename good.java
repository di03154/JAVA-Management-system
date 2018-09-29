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
			System.out.println("재고관리 프로그램");
			System.out.println("-----------------");
			System.out.println("숫자를 입력하시오.");
			System.out.println("1. 물품 입고");
			System.out.println("2. 물품 출고");
			System.out.println("3. 현재 재고 출력");
			num = sc.nextInt();
			if(num == 1)
				inn();
			else if(num == 2)
				outt();
			else if(num == 3)
				envi();	
			else	{
				System.out.println("숫자를 잘못 입력하셨습니다.");
				System.out.println("다시 입력하시오.");
			}
		}while(num < 4 && num >= 1);
	}
	void inn()	{
		System.out.println("-----------------");
		System.out.println("물품 입고");
		System.out.println("-----------------");
		System.out.print("제품명을 입력하세요: ");
		String model = sc.next();
		System.out.print("입고 량을 입력하세요: ");
		int seq = sc.nextInt();
		list.setCarPrice(model, seq);
		return;
	}
	
	void outt()	{
		System.out.println("-----------------");
		System.out.println("물품 출고");
		System.out.println("-----------------");
		System.out.print("제품명을 입력하세요: ");
		String model = sc.next();
		System.out.print("출고 량을 입력하세요: ");
		int seq = sc.nextInt();
		list.setCarPrice(model, -seq);
		return;
	}
	void envi()	{
		System.out.println("1)제품별");
		System.out.println(CarPrice.carModel);
		System.out.println("2)분류별");
		System.out.print("Sedan: ");
		System.out.println(list.product[0].amountOfCards + list.product[1].amountOfCards);
		System.out.print("suv: ");
		System.out.println(list.product[2].amountOfCards + list.product[3].amountOfCards);
		System.out.println("자산현황: ");
		System.out.println(CarPrice.carPrice);
		return;
	}
}
// 입고, 출고
class CarPriceList	{
	// 각 자동차의 객체를 찍는다
	CarPrice carprice;
	Product[] product = {new X5(), new X3(), new M5(), new M3()};
	String carModel;
	// 차 모델과 가격을 입력하면 각 차 들의 입고량과 총 가격을 알 수 있다.
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
	// 각 차의 전체 가격을 
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
