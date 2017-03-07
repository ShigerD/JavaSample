package newpackage;
/*
 * 自定义类，描述某一类相同的事物
 * 特殊到一般-> 张三->人
 * 一般到特殊-> 人->李四
 */

public class MyClass extends Object
{
	String type; //字符串 品种
	String name; //字符串 名字
	
	void method() //方法 功能
	{
		
	}
    
	// alt+/
	public static void main(String[] args) 
	{
		/*Person lisi=new Person("李四",22);
		lisi.eating();
		Person a=new Person("李四",22);
		a.sleeping();
		
		NewStudent stu1=new NewStudent(00001,"a",24,99);
		stu1.display(); //NewStudent类自己定义的方法
		stu1.eating();  //NewStudent类继承的父类的方法*/
		
		//Person p1=new Person("a",22);
		//System.out.println(p1.toString());
		//System.out.println(p1);
		
		//NewStudent stu1=new NewStudent(100001,"a",24,99);
		//System.out.print(stu1);
		
		//Object o=new NewStudent(100001,"a",24,99);
		//o.toString();
		
		Object o=new NewStudent(100001,"a",24,99);
		System.out.println(o.toString()); // 同一条语句，调用了不同类中的同名方法
		
		o=new Person("b",24);
		System.out.println(o.toString());
		
	}
}

/*
 * class 类名
 * {
 *   //字段
 *     访问权限 数据类型 字段名；
 *   //方法
 *   访问权限 返回类型 方法名（数据类型 形参名【，数据类型 形参名...】）
 *   {
 *     语句；
 *     ...
 *   }
 * }
 */
    class Person extends Object
    {
    	private String name;
    	private int age;
    	//特殊的方法，称为构造方法或称为构造器，用于初始化字段值
    	Person(String name,int age)
    	{
    		this.name=name;
    		this.age=age;
    		
    	}
    	
    	//普通的方法
    	void eating()
    	{
    		System.out.println(name+"正在吃饭！");
    	}
    	
    	void sleeping()
    	{
    		System.out.println(name+"正在睡觉！");
    	}
    	
    	public String getName()
    	{
    		return name; //将name返回给调用该方法的人
    	}
    	
    	/*
    	 * 将对象以字符串形式显示出来，默认输出hashcode
    	 */
    	public String toString()
    	{
    		return "姓名："+name+" 年龄:"+age;
    	}
	}
    


