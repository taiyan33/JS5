import java.util.Calendar;
import java.util.GregorianCalendar;


public class hw3 {
//	https://www.javaworld.com.tw/jute/post/view?bid=29&id=320113
	 private static final Runtime s_runtime = Runtime.getRuntime (); 
	  private static long usedMemory () 
	  { 
	    return s_runtime.totalMemory () - s_runtime.freeMemory ();
	  } 
	  private static void runGC () throws Exception 
	  { 
	    long usedMem1 = usedMemory (), usedMem2 = Long.MAX_VALUE; 
	    for (int i = 0; (usedMem1 < usedMem2) && (i < 500); ++ i) 
	    { 
	      s_runtime.runFinalization (); 
	      s_runtime.gc (); 
	      Thread.currentThread ().yield (); 
	      usedMem2 = usedMem1; 
	      usedMem1 = usedMemory (); 
	    }
	  }
	 public static void Q1(){
			StringBuilder sb = new StringBuilder(); 
			String s ="";
			
			
			int wan =10000;
//			System.out.println(wan);
			
			long m1= s_runtime.freeMemory ();
			long t1=System.currentTimeMillis();
			for(int i=1;i<=1*wan;i++){
				s=s+"a"; 
			}
			long t2=System.currentTimeMillis();
			long m2= s_runtime.freeMemory ();
			System.out.println("String memory:"+ (m1-m2) +"\ttime: "+(t2-t1));
			try{
				runGC ();
			}catch(Exception e){}
			
			
			m1= s_runtime.freeMemory ();
			t1=System.currentTimeMillis();
			for(int i=1;i<=1*wan;i++){
				sb.append("a"); 
			}
			t2=System.currentTimeMillis();
			m2= s_runtime.freeMemory ();
			System.out.println("String memory:"+ (m1-m2) +"\ttime: "+(t2-t1));
			System.out.println();
			try{
				runGC ();
			}catch(Exception e){}
			
			//////////////////////////////////////////////////////////////
			m1= s_runtime.freeMemory ();
			t1=System.currentTimeMillis();
			for(int i=1;i<=5*wan;i++){
				s=s+"a"; 
			}
			t2=System.currentTimeMillis();
			m2= s_runtime.freeMemory ();
			System.out.println("String memory:"+ (m1-m2) +"\ttime: "+(t2-t1));
			try{
				runGC ();
			}catch(Exception e){}
			
			m1= s_runtime.freeMemory ();
			t1=System.currentTimeMillis();
			for(int i=1;i<=5*wan;i++){
				sb.append("a"); 
			}
			t2=System.currentTimeMillis();
			m2= s_runtime.freeMemory ();
			System.out.println("String memory:"+ (m1-m2) +"\ttime: "+(t2-t1));
			System.out.println();
			try{
				runGC ();
			}catch(Exception e){}
			
			////////////////////////////////////////////////////////
			
			m1= s_runtime.freeMemory ();
			t1=System.currentTimeMillis();
			for(int i=1;i<=10*wan;i++){
				s=s+"a"; 
			}
			t2=System.currentTimeMillis();
			m2= s_runtime.freeMemory ();
			System.out.println("String memory:"+ (m1-m2) +"\ttime: "+(t2-t1));
			try{
				runGC ();
			}catch(Exception e){}
			
			
			m1= s_runtime.freeMemory ();
			t1=System.currentTimeMillis();
			for(int i=1;i<=10*wan;i++){
				sb.append("a"); 
			}
			t2=System.currentTimeMillis();
			m2= s_runtime.freeMemory ();
			System.out.println("String memory:"+ (m1-m2) +"\ttime: "+(t2-t1));
			////////////////////////////////////////////////////////
		    
	 }
	 public static void Q2(){
		 int ann=2011;//Integer.parseInt(args[0]);   //輸入值，年
		    int mois=1;//Integer.parseInt(args[1]);  //輸入值，月
		    
		    System.out.println( "    "+ann +  " 年 " + mois + "月");
		    System.out.println("====================");
		    System.out.println( "日   一   二   三   四   五   六 " );
		    System.out.println("--------------------");
		    
		    int remois = mois - 1;
		    Calendar cal = new GregorianCalendar(ann,remois,1);  
		    int day = cal. getActualMaximum(Calendar.DATE); //取得當月最大天數
		    int day_of_week = cal.get(Calendar.DAY_OF_WEEK);//當月的第一天星期幾?  
		    int day_of_month = cal.get(Calendar.DAY_OF_MONTH);//當月的第一天
		    
		    for(int k = 1 ; k < day_of_week ; k++){
		      System.out.print("   "); //3 space
		    } //先把空格空出來
		      
		    for(day_of_month = 1 ; day_of_month <= day ; day_of_month++){//此FOR迴圈是要將日期印出來
		      if(day_of_month<10){  //若那一天是個位數的印法
		        System.out.print(" "+day_of_month+" ");
		        }else{  //十位數的印法
		        System.out.print(day_of_month+" ");
		        } //整個IF迴圈是為了要設定格式
		               
		       if (cal.get(Calendar.DAY_OF_WEEK) == 7) {  //每到星期六則跳行
		                  System.out.println("");
		              }
		       cal.add(Calendar.DAY_OF_MONTH, 1);
		    }
		//    
	 }
	public static void main(String[] args) {
//		Q1();
		
		Q2();
	}

}
