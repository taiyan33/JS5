 import java.math.*;
 import java.lang.*;
import java.text.DecimalFormat;
import java.util.*;
 
//// BigDecimalDemo
 public class hw2 {
	 public static void Q1(){
//		 ref: //	      http://tw.gitbook.net/java/java_mapentry_interface.html
		 
		 Map<Integer,Integer> dice100 = new HashMap();
		 
		 for(int i=3;i<=36;i++){
			 dice100.put(i, 0);
		 }
		 int _1=0, _2=0,_3=0;
		 int sum=0;
		 for(int i=0;i<100;i++){
			  _1=(int)(Math.random()*6+1);
			  _2=(int)(Math.random()*6+1);
			  _3=(int)(Math.random()*6+1);
			  sum=_1+_2+_3;
			  
				 Set set = dice100.entrySet();
				 int balance = ((int)dice100.get(sum));
				 dice100.put(sum, new Integer(balance + 1));
				 
//				 System.out.println(dice100.entrySet() );
				 
		 }
		 Set set = dice100.entrySet();
	      // Get an iterator
	      Iterator i = set.iterator();
	      // Display elements
	      while(i.hasNext()) {
	         Map.Entry me = (Map.Entry)i.next();
	         if(!me.getValue().toString().equals("0")){
	        	 System.out.printf("%2d ",Integer.parseInt(me.getKey().toString()));
//	        	 System.out.print(me.getKey() + " ");
	        	 for(int j=1;j<=Integer.parseInt(me.getValue().toString());j++){
	        		 System.out.print("*");
	        	 }
	        	 System.out.println();
//	        	 System.out.println(me.getValue());
	        	 
	         }
	      }
		 
//		 System.out.println(idx+" new balance: " + dice100.get(idx));
		 
	 }
	 
	 public static void Q2(){

	      ////create 3 BigDecimal objects
	       BigDecimal bg1, bg2, bg3;

	       bg1 = new BigDecimal("15.123");
	       bg2 = new BigDecimal("2.123");

	      ////divide bg1 with bg2 with 3 scale
	       bg3 = bg1.add(bg2);
bg3.setScale( 3, RoundingMode.HALF_UP);
	       String str = "Division result is " +bg3;

	      ////print bg3 value
	       System.out.println( str );
	       
	       BigDecimal test = new BigDecimal(0);
	       System.out.println(test);
	       test.add(new BigDecimal(30));
	       
	       double d = 45.617;
	       BigDecimal value = new BigDecimal(d,
	    	        new MathContext(5, RoundingMode.HALF_UP));
	       System.out.println(value);
	       
	 }
	//10*10*3
		public  static void Q22(){
//			ArrayList<Double> nnum15 = new ArrayList<Double>(); 
//			Double [] arr = new Double[15];
//			ArrayList<Double> nnum15= new ArrayList<Double>(Arrays.asList(arr));
//			Collections.fill(nnum15, 5.0);//fills all 40 entries with 0
//			System.out.println(nnum15);
			
			ArrayList<Double> nnum15= new ArrayList<Double>();
			
//			double [] num15 = new double[15];
			Random ran = new Random();
			double sum=0;
				int _1=(int)(Math.random()*9+0);
				int _10=(int)(Math.random()*9+0);
				int _100=(int)(Math.random()*9+0);
				
				BigDecimal bg1, bg2, bg3, bg4,btmp, bsum;
				bsum = new BigDecimal(0.0);
			for(int i=0;i<15;i++)
			{
				int ii=(int)(Math.random()*9+1);
				
				
			       bg1 = new BigDecimal(ii);
			       bg2 = new BigDecimal(_1).divide(  new BigDecimal(10) );
			       bg3 = new BigDecimal(_10).divide(  new BigDecimal(100) );
			       bg4 = new BigDecimal(_100).divide(  new BigDecimal(1000) );
			       
			       btmp=bg1.add(bg2).add(bg3).add(bg4);
//			       System.out.print(bg1+" " +bg2+" "+bg3+" "+bg4+" ___" );
//			       System.out.println(  btmp );
			       
//			       nnum15.set(i, Double.parseDouble(btmp.toString()));
			       nnum15.add(btmp.doubleValue());
//			       nnum15.set(i, btmp.doubleValue());
			       bsum=bsum.add(btmp).setScale( 3, RoundingMode.HALF_UP);
			       
			       
//				int tmp=
//				ii*1000+
//				(_1)*100+
//				(_10)*10+
//				(_100);
//				
//				num15[i]= tmp/1000.0;
//				sum=sum+num15[i];
				
				
				_1=_1+1;
				_10=_10+i%3;
				_100=_100+i%3;
				_1=_1%10;
				_10=_10%10;
				_100=_100%10;

			}
//			四捨五入//			http://java-reference.com/java_number_round.html
			System.out.print("\n陣列: ");
			Collections.sort(nnum15);
			for(int i=0;i<15;i++)
			{ 
				if(i==14)	{
					System.out.println( nnum15.get(i) );
				}
				else{
					System.out.print( nnum15.get(i)+ ", " );
				}
			}
			System.out.println( "總合:" +bsum );
			 
			System.out.println( "平均數: " + bsum.divide(new BigDecimal(15),3, RoundingMode.HALF_UP) );
	}
		
    public static void main(String[] args) {
//    	Q1();
    	
    	Q22();
    }
 }