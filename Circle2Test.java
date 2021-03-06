
/***
* Example JUnit testing class for Circle2 (and Circle)
*
* - must have your classpath set to include the JUnit jarfiles
* - to run the test do:
*     java org.junit.runner.JUnitCore Circle1Test
* - note that the commented out main is another way to run tests
* - note that normally you would not have print statements in
*   a JUnit testing class; they are here just so you see what is
*   happening. You should not have them in your test cases.
***/

import org.junit.*;

public class Circle2Test
{
   // Data you need for each test case
   private Circle2 circle2;
   private Circle2 circle2Overlap;
   private Circle2 circle2Touch;
   private Circle2 circle2Away;
   private Circle2 circle2ContainedTouch;
   private Circle2 circle2ContainedAway;
   private Circle2 circle2CompleteOverlap;

// 
// Stuff you want to do before each test case
//
@Before
public void setup()
{
   System.out.println("\nTest starting...");
   circle2 = new Circle2(1,2,3);
   circle2Overlap = new Circle2(5,3,2);
   circle2Touch = new Circle2(4,6,2);
   circle2Away = new Circle2(5,6,2);
   circle2ContainedTouch = new Circle2(2,2,2);
   circle2ContainedAway = new Circle2(2,2,1);
   circle2CompleteOverlap = new Circle2(1,2,3);
}

//
// Stuff you want to do after each test case
//
@After
public void teardown()
{
   System.out.println("\nTest finished.");
}

//
// Test a simple positive move
//
@Test
public void simpleMove()
{
   Point p;
   System.out.println("Running test simpleMove.");
   p = circle2.moveBy(1,1);
   Assert.assertTrue(p.x == 2 && p.y == 3);
}

// 
// Test a simple negative move
//
@Test
public void simpleMoveNeg()
{
   Point p;
   System.out.println("Running test simpleMoveNeg.");
   p = circle2.moveBy(-1,-1);
   Assert.assertTrue(p.x == 0 && p.y == 1);
}

//
//-------- Begining of my tests -----------
//

//
// Test a simple scale (should double the size of the circle) with factor greater than 1
//
@Test
public void doubleSize()
{
   double r;
   r = circle2.scale(2.0);
   Assert.assertTrue(Double.compare(r,6.0)==0);
}

//
// Test a simple scale (should make the size of the circle 50% as big) with factor less than 1
//
@Test
public void halfSize()
{
   double r;
   r = circle2.scale(0.5);
   Assert.assertTrue(Double.compare(r,1.5)==0);
}

//
// Test a simple scale (should leave the size of the circle unchanged) with factor of 1
//
@Test
public void keepSize()
{
   double r;
   r = circle2.scale(1.0);
   Assert.assertTrue(Double.compare(r,3.0)==0);
}

//
// Test a no move where center should not change (both coordinates should remain unchanged)
//
@Test
public void simpleNoMove()
{
   Point p;
   p = circle2.moveBy(0,0);
   Assert.assertTrue(p.x == 1 && p.y == 2);
}

//
// Test a simple positive move in x direction only (x coordinate should increase by 1)
//
@Test
public void simplePositiveMoveXOnly()
{
   Point p;
   p = circle2.moveBy(1,0);
   Assert.assertTrue(p.x == 2 && p.y == 2);
}

//
// Test a simple negative move in x direction only (x coordinate should decrease by 1)
//
@Test
public void simpleNegativeMoveXOnly()
{
   Point p;
   p = circle2.moveBy(-1,0);
   Assert.assertTrue(p.x == 0 && p.y == 2);
}

//
// Test a simple positive move in y direction only (y coordinate should increase by 1)
//
@Test
public void simplePositiveMoveYOnly()
{
   Point p;
   p = circle2.moveBy(0,1);
   Assert.assertTrue(p.x == 1 && p.y == 3);
}

//
// Test a simple negative move in y direction only (y coordinate should decrease by 1)
//
@Test
public void simpleNegativeMoveYOnly()
{
   Point p;
   p = circle2.moveBy(0,-1);
   Assert.assertTrue(p.x == 1 && p.y == 1);
}

//
// Test a positive move in x direction and negative move in y direction
// (x coordinate should increase by 1 and y coordinate should decrease by 1
//
@Test
public void posXNegYMove()
{
   Point p;
   p = circle2.moveBy(1,-1);
   Assert.assertTrue(p.x == 2 && p.y == 1);
}

//
// Test a negative move in x direction and positive move in y direction
// (x coordinate should decrease by 1 and y coordinate should increase by 1)
//
@Test
public void negXPosYMove()
{
   Point p;
   p = circle2.moveBy(-1,1);
   Assert.assertTrue(p.x == 0 && p.y == 3);
}

//
// Test to see if an overlapping circle intersects (should return true)
//
@Test
public void overlapIntersect()
{
   boolean p;
   p = circle2.intersects(circle2Overlap);
   Assert.assertTrue(p);
}

//
// Test to see if a touching circle intersects (should return true)
//
@Test
public void touchIntersect()
{
   boolean p;
   p = circle2.intersects(circle2Touch);
   Assert.assertTrue(p);
}

//
// Test to see if a circle that doesn't touch or overlap intersects (should return false)
//
@Test
public void awayIntersect()
{
   boolean p;
   p = circle2.intersects(circle2Away);
   Assert.assertFalse(p);
}

//
// Test to see if a circle that is contained but does touch edges intersects (should return true)
//
@Test
public void containedTouchIntersect()
{
   boolean p;
   p = circle2.intersects(circle2ContainedTouch);
   Assert.assertTrue(p);
}

//
// Test to see if a circle that is contained but does not touch edges intersects (should return false)
//
@Test
public void containedAwayIntersect()
{
   boolean p;
   p = circle2.intersects(circle2ContainedAway);
   Assert.assertFalse(p);
}

//
// Test to see if a circle that has the same center point and radius intersects (should return true)
//
@Test
public void completeOverlapIntersect()
{
   boolean p;
   p = circle2.intersects(circle2CompleteOverlap);
   Assert.assertTrue(p);
}

/*** NOT USED
public static void main(String args[])
{
   try {
      org.junit.runner.JUnitCore.runClasses(
               java.lang.Class.forName("Circle1Test"));
   } catch (Exception e) {
      System.out.println("Exception: " + e);
   }
}
***/

}

