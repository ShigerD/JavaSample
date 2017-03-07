import java.util.Scanner;

/*
 * 循环：反复执行部分代码。
 * for(循环开始; 循环执行条件; 使循环能够结束){
 * 		反复执行的语句
 * }
 */
public class Test5 {
	public static void main(String[] args) {
		//输入若干数据，累加输入的数据，输入0结束
		int num = 0;
		int sum = 0;
		Scanner input = new Scanner(System.in);
		
		for(num = input.nextInt(); num != 0; num = input.nextInt()){
			sum += num;
		}
		
		System.out.println("输入的和是："+sum);
	}
}
