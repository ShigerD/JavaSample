import java.util.Scanner;

/*
 * 猜数字
 * 1、系统生成不超过100的正整数
 * 2、给你10次猜数字的机会
 *    若10次机会内你猜中了，则提前结束游戏                           if+break
 *    若猜的数跟随机的数不想等提示输入的数据是偏大还是偏小   if+else
 *    若10次都没有猜中，提示脑子有问题.               循环结束后根据i值判断
 */
public class Test6 {
	public static void main(String[] args) {		
		int num = (int)(Math.random()*100);
		int a = 0;
		int i;
		Scanner input = new Scanner(System.in);
		
		for(i=0; i<10; i++){
			System.out.println("请输入第"+(i+1)+"个数");
			//输入a
			a = input.nextInt();
			//判断
			if(num == a){
				break;//满足某些条件时，提前结束循环
			} else if(num > a){
				System.out.println("输入的数偏小");
			} else 
				System.out.println("输入的数偏大");
		}
		//i>=10  正常结束
		//i<10  提前结束
		if(i >= 10){
			System.out.println("脑子有问题");
		} else
			System.out.println("没问题");
	}
}
