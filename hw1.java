import java.util.Random;
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
			// if(_1+1>9)_1=0; else _1++;
			// if(_10+1>9)_10=0; else _1++;
			// if(_100+1>9)_100=0; else _1++;
			
		}
		// if(num15[0]==num15[9] ){
			// num15[9]
		// }
		System.out.print("\n陣列: ");
		
		for(int i=0;i<15;i++)
		{
		 System.out.print( num15[i] + ", ");
		}
		System.out.println( "\n總合:" +sum);
		System.out.println( "平均數: " + (sum/num15.length) );
	}
	
    public static void main(String[] args) {
		Q1();
		Q2();
		System.out.println( );
    }
}

