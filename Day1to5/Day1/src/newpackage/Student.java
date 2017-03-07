package newpackage;
/*
 * 学生属性：学号、姓名、年龄、成绩
 * 方法：构造、学习和输出成绩的方法
 * 在MyClass的main方法中生成学生对象，并调用学习和输出成绩的方法
 */
class student
{
	private int id;
	private String name;
	private int age;
	private double score;
	//特殊的方法，称为构造方法或称为构造器，用于初始化字段值
	student(int id,String name,int age,double score)
	{
		this.id=id;       //字段跟局部变量不同名，字段不是必须加this（如，stuId=id）；否则字段必须加this
		this.name=name;
		this.age=age;
		this.score=score;		
	}
	
	//普通的方法
	
	void display()
	{
		System.out.println(name+"的成绩是："+score);
	}
	
}
public class Student 
{
	public static void main(String[] args) 
	{
		student s=new student(000001,"周瑜",24,99);
		s.display();	
	}

}
