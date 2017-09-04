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

           /* (Begin)=============== �ͦ����� ===============(Begin) */

           //���wConstructor�ҨϥΪ��Ѽƫ��A
           Class[] oParam = new Class[2];
           oParam[0] = String.class;
           oParam[1] = Integer.TYPE;

           //����Constructor
           Constructor constructor = c.getConstructor(oParam);

           //���w�Ѽƪ����e
           Object[] paramObjs = new Object[2];
           paramObjs[0] = "godleon";
           paramObjs[1] = new Integer(90);

           //�z�LConstructor���ͪ���
           Object obj = constructor.newInstance(paramObjs);
           System.out.println(obj);

           /* (End)=============== �ͦ����� ===============(End) */


           /* (Begin)=============== �I�s��k ===============(Begin) */

           //���wMethod�ҨϥΪ��Ѽ�����
           Class[] mParam1 = {String.class}; //�u���@�ӰѼ�

           //����Method(���wmethod�W�ٻP�Ѽ�)
           Method setName = c.getMethod("setName", mParam1);

           //���w�ѼƤ��e
           Object[] mParamObjs1 = {"godleon"};

           //�I�s��k
           setName.invoke(obj, mParamObjs1); //�I�ssetName��k

           //���wMethod�ҨϥΪ��Ѽ�����
           Class[] mParam2 = {Integer.TYPE};

           //����Method(���wmethod�W�ٻP�Ѽ�)
           Method setScore = c.getMethod("setScore", mParam2);

           //���w�ѼƤ��e
           Object[] mParamObjs2 = {new Integer(90)};

           //�I�s��k
           setScore.invoke(obj, mParamObjs2); //�I�ssetScore��k

           //����Method(���wmethod�W�ٻP�Ѽ�)
           Method showData = c.getMethod("showData", null);

           //�I�s��k
           showData.invoke(obj, null);  //�I�sshowData��k

           /* (End)=============== �I�s��k ===============(End) */
       }
       catch(Exception e) {
           e.printStackTrace();
       }
   }
}