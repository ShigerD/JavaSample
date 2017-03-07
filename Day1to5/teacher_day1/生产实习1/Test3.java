import java.util.Scanner;//#include <stdio.h>
/*
 * if-else
 * 定义一个学生成绩变量，输入学生成绩，若成绩超过60分输出及格，否则输出不及格
 */
public class Test3 {
	public static void main(String[] args) {
		float score;
		
		//输入，输入类对象,指明从标准输入设备System.in键盘输入
		Scanner input = new Scanner(System.in);
		score = input.nextFloat();
		
		if(score >= 60){
			System.out.println("及格");
		} else {
			System.out.println("不及格");
		}
		
		//输出等级   A>=90  B>=80  C>=70   D>=60    E<60
		if(score>=90){
			System.out.println("A");
		} else if(score >=80){
		    System.out.println("B");
		} else if(score >=70){
			System.out.println("C");
		} else if(score >= 60){
			System.out.println("D");
		} else
			System.out.println("E");
		
		System.out.println("输入的成绩是："+score);
	}
}
