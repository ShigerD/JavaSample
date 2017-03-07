/*
 * String系统定义表示字符串的类，类首字母大写
 * 访问权限public公有(任何地方都可以访问) private私有(仅在本类中访问)  [default]缺省  protected保护
 * static静态  类的方法或属性
 * \
 * 
 * java程序：
 *   项目-> 多个java源文件
 *         -> 每个java源文件中可以有多个类, 但一个java源文件中只能有一个public修饰的类，并且该类名跟文件名要一致
 *         ->   每个类中可以有多个属性和方法,属性表示类的值，方法表示类的功能
 */
public class Test {
	//程序的入口
	public static void main(String[] args) {//int main(int argc, char*[] args)
		Student stu = new Student();//生成学生对象
		stu.name = "zhangsan";
//		stu.study();
		
		Student.num = Student.num+1;//所有类对象共用同一个值
		stu.id = Student.num;//某个对象单独有的值
		System.out.println(stu.toString());//syso  快捷方式:alt+/
		
		Student stu2 = new Student();
		stu2.name = "lisi";
		Student.num++;
		stu2.id = Student.num;
		System.out.println(stu2.toString());
	}
} 
//新类型
class Student{
	//定义学生类型的属性
	String name ;//字符串  char[20]
	private int    age   = 20;
	float  score = 89.5f;
	public int id = 0;//学号
	public static int num = 0;//总人数
		
	void study(){
		System.out.println(name+" "+age+" 正在学习...");
	}
	
	//	public void setAge(int a){
	//		age = a;
	//	}
	//将学生信息转为字符串
	public String toString(){
		return "姓名："+name+"  学号："+id;
	}
}

