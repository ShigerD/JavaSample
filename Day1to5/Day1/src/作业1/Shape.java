package 作业1;

public class Shape 
{
	private double area;
	
	public Shape()
	{}
	
    public double comArea()
    {
    	return area;
    }
    
    public String toString()
    {
    	return "面积是："+area;
    }
    
    public void setArea(double area)
    {
    	this.area=area;
    }
    public double getArea()
    {
    	return area;
    }
}