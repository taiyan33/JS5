import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// https://openhome.cc/Gossip/JavaGossip-V2/ModifyField.htm
// file:///C:/Users/user/Desktop/20170904/%E5%B0%8F%E4%BF%A1%E8%B1%AC%E7%9A%84%E5%8E%9F%E5%A7%8B%E9%83%A8%E8%90%BD_%20Java%20%E5%AD%B8%E7%BF%92%E7%AD%86%E8%A8%98%20(10)%20-%20Reflection.html

public class newInstanceDemo {
   public static void main(String[] args) {
       Class c = null;
       try {
           c = Class.forName("Student");  //args[0]

           /* (Begin)=============== ネΘン ===============(Begin) */

           //﹚Constructor┮ㄏノ把计篈
           Class[] oParam = new Class[2];
           oParam[0] = String.class;
           oParam[1] = Integer.TYPE;

           //玻ネConstructor
           Constructor constructor = c.getConstructor(oParam);

           //﹚把计ず甧
           Object[] paramObjs = new Object[2];
           paramObjs[0] = "godleon";
           paramObjs[1] = new Integer(90);

           //硓筁Constructor玻ネン
           Object obj = constructor.newInstance(paramObjs);
           System.out.println(obj);

           /* (End)=============== ネΘン ===============(End) */


           /* (Begin)=============== ㊣よ猭 ===============(Begin) */

           //﹚Method┮ㄏノ把计摸
           Class[] mParam1 = {String.class}; //Τ把计

           //玻ネMethod(﹚method嘿籔把计)
           Method setName = c.getMethod("setName", mParam1);

           //﹚把计ず甧
           Object[] mParamObjs1 = {"godleon"};

           //㊣よ猭
           setName.invoke(obj, mParamObjs1); //㊣setNameよ猭

           //﹚Method┮ㄏノ把计摸
           Class[] mParam2 = {Integer.TYPE};

           //玻ネMethod(﹚method嘿籔把计)
           Method setScore = c.getMethod("setScore", mParam2);

           //﹚把计ず甧
           Object[] mParamObjs2 = {new Integer(90)};

           //㊣よ猭
           setScore.invoke(obj, mParamObjs2); //㊣setScoreよ猭

           //玻ネMethod(﹚method嘿籔把计)
           Method showData = c.getMethod("showData", null);

           //㊣よ猭
           showData.invoke(obj, null);  //㊣showDataよ猭

           /* (End)=============== ㊣よ猭 ===============(End) */
       }
       catch(Exception e) {
           e.printStackTrace();
       }
   }
}