
public class Circle1 extends Circle
{

public Circle1(double x, double y, double radius)
{
   super(x,y,radius);
}

public boolean intersects(Circle other)
{
   //added condition to check for contained circles
   if (Math.sqrt(Math.pow(Math.abs(center.x - other.center.x), 2) + Math.pow(Math.abs(center.y - other.center.y), 2)) < radius && other.radius < (radius - Math.sqrt(Math.pow(Math.abs(center.x - other.center.x), 2) + Math.pow(Math.abs(center.y - other.center.y), 2))))
      return false;

   // changed if condition from 'if (Math.abs(center.x - other.center.x) < radius && Math.abs(center.y - other.center.y) < radius)
   if (Math.pow(Math.abs(center.x - other.center.x), 2) + Math.pow(Math.abs(center.y - other.center.y), 2) <= Math.pow(radius+other.radius, 2))
      return true;

   return false;
}

}

