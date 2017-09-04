import java.lang.reflect.Field; 
 
public class AssignFieldDemo {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("TestedField");  //args[0]
            Object targetObj = c.newInstance();
            
            Field testInt = c.getField("testInt");
            testInt.setInt(targetObj, 99);
            
            Field testString = c.getField("testString");
            testString.set(targetObj, "caterpillar");
            
            System.out.println(targetObj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }       
    }
} 