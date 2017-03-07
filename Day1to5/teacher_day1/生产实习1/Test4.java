import java.util.Scanner;

/*
 * switch-case语句  只判断一次相等  若执行完语句后不希望继续执行switchcase语句
 *               则需要添加用于结束该结构的关键字break
 * switch(整型表达式){
 * case 常量表达式1：语句1  break;
 * case 常量表达式2：语句2
 * ...
 * default:
 * }
 */
public class Test4 {
	//从键盘输入月份，判断属于哪个季节
	public static void main(String[] args) {
		int month;
		Scanner input = new Scanner(System.in);
		month = input.nextInt();
		
		switch(month){
		case 1:  case 12:case 2:
			System.out.println("冬季");break;
		case 3:case 4:case 5:		
			System.out.println("春季");break;
		case 6:case 7:case 8:
			System.out.println("夏季");break;
		case 9:case 10:case 11:
			System.out.println("秋季");break;
		default:System.out.println("输入出错");
		}
	}
}
