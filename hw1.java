import java.util.Random;
import java.text.DecimalFormat;


public class hw1 {
	
	public static void Q1(){
		        // System.out.println("Hello World");
		int [] dice20 = new int[21];
		Random ran = new Random();
		for(int i=1;i<=20;i++)
		{
			dice20[(int)(Math.random()*6+1)]++;
			
		}
		// int j=0;
		for(int i=1;i<=6;i++)
		{
		 System.out.println( i+" :" + dice20[i] + '次');
		 // j=j+dice20[i];
		}
		// System.out.println( j );
	}
	
	//10*10*3
	public  static void Q2(){
		double [] num15 = new double[15];
		Random ran = new Random();
		double sum=0;
			int _1=(int)(Math.random()*9+0);
			int _10=(int)(Math.random()*9+0);
			int _100=(int)(Math.random()*9+0);
		for(int i=0;i<15;i++)
		{
			

			int ii=(int)(Math.random()*9+1);
			
			int tmp=
			ii*1000+
			(_1)*100+
			(_10)*10+
			(_100);
			
			num15[i]= tmp/1000.0;
			sum=sum+num15[i];
			
			
			System.out.println(ii+" " +_1+" "+_10+" "+_100+" ___"+ num15[i] + ", ");
			// System.out.println(ii+" " +  (_1/10.0)+" "+  (_10/100.0)+" "+  (_100/1000.0)+" ___"+ num15[i] + ", ");
			
			_1=_1+1;
			_10=_10+i%3;
			_100=_100+i%3;
			_1=_1%10;
			_10=_10%10;
			_100=_100%10;

			
		}

		System.out.print("\n陣列: ");
		
		for(int i=0;i<15;i++)
		{
			if(i==14)System.out.print( num15[i] );
			else
		 System.out.print( num15[i] + ", ");
		}
		
		DecimalFormat df = new DecimalFormat("#.000"); //自動補0
		String s=df.format(sum);   
		System.out.println( "\n總合:" +s );
		
		 
		 s=df.format(sum/15.0);   
		System.out.println( "平均數: " + s );
	}
	
    public static void main(String[] args) {
		Q1();
		Q2();
		System.out.println( );
    }
}


// import java.math.*;
// import java.lang.*;
//// BigDecimalDemo
// public class hw2 {

   // public static void main(String[] args) {

      ////create 3 BigDecimal objects
      // BigDecimal bg1, bg2, bg3;

      // bg1 = new BigDecimal("15");
      // bg2 = new BigDecimal("2");

      ////divide bg1 with bg2 with 3 scale
      // bg3 = bg1.divide(bg2, 3, RoundingMode.HALF_UP);

      // String str = "Division result is " +bg3;

      ////print bg3 value
      // System.out.println( str );
   // }
// }
