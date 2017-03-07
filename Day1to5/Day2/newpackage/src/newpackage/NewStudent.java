package newpackage;
/*
 * 学生也是一个人，让学生类从人类继承。
 * 继承了父类的属性和方法，可以在子类中直接使用父类中非私有的属性和方法
 * 子类继承父类
 */

public class NewStudent extends Person
{
	private int id;
	private double score;
	//特殊的方法，称为构造方法或称为构造器，用于初始化字段值
	public NewStudent(int id,String name,int age,double score)
	{
		super(name,age);  // 调用父类的构造器，给父类的字段赋初值
		this.id=id;       //字段跟局部变量不同名，字段不是必须加this（如，stuId=id）；否则字段必须加this
		this.score=score;		
	}
	
	void display()
	{
		System.out.println(getName()+"的成绩是："+score);
	}
	
	/*
	 * 多态：多种状态
	 * 子类重写父类的方法
	 */
	public String toString()
	{
		return "学号："+id+" 分数："+score;
	}
}

	