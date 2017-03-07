/*
 * 1、基本类型 
 *        boolean 表示真假值，true，false
 *        char  2字节  可以表示一个汉字
 * 2、引用类型：类  接口  数组
 * 3、常量     final 类型  变量名 = val;//申请最终变量,需要赋初值。赋初值后，该变量值不可变
 *   变量   类型  变量名      int age;//申请多大空间，空间位置,数据存储的格式
 */
public class Test2 {
	public static void main(String[] args) {
		int age = 18;
		final char sex = '男';
		System.out.println("年龄："+age+" 性别："+sex);
		age = age+4;
		//sex = '女';
		System.out.println("大学毕业 年龄："+age+" 性别："+sex);
		
	}
}
//1M 0---1024*1024
//0   1023