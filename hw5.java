import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class car{
	String Manufacturer="",Type="";
	public String getManufacturer() {
		return Manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public BigDecimal getMin_Price() {
		return Min_Price;
	}
	public void setMin_Price(BigDecimal min_Price) {
		Min_Price = min_Price;
	}
	BigDecimal Min_Price= new BigDecimal(0.0),Price= new BigDecimal(0.0);
	car(String Manufacturer,String  Type, BigDecimal Min_Price,BigDecimal Price){

		this.Manufacturer=Manufacturer;
		this.Type=Type;
		this.Min_Price=Min_Price;
		this.Price=Price;
		
	}
	public BigDecimal getPrice() {
		return Price;
	}
	public void setPrice(BigDecimal price) {
		Price = price;
	}
}
class a_Comparator implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		// TODO 自動產生方法 Stub
		return ( ((car)o1).getPrice().subtract( ((car)o2).getPrice()).doubleValue()  > 0.0)? 1:( ((car)o1).getPrice().subtract( ((car)o2).getPrice()).doubleValue()  == 0.0)?  0: -1 ;
	}
}

class b_Comparator implements Comparator{
//	https://stackoverflow.com/questions/6850611/sort-a-list-of-objects-by-multiple-fields
	@Override
	public int compare(Object o1, Object o2) {
		// TODO 自動產生方法 Stub
//		System.out.println(((car)o1).getManufacturer());
//		System.out.println(((car)o2).getManufacturer());
//		System.out.println(((car)o1).getPrice());
//		System.out.println(((car)o2).getPrice());

//		if( ((car)o1).getManufacturer().compareTo( ((car)o2).getManufacturer() )==1  ){
//			System.out.println( "big");
//			return 1;
//		}
//		else if(  ((car)o1).getManufacturer().compareTo( ((car)o2).getManufacturer() )==0 ){
//			
//			System.out.println( "equal");
//			return ( ((car)o1).getPrice().subtract( ((car)o2).getPrice()).doubleValue()  > 0.0)? 1:( ((car)o1).getPrice().subtract( ((car)o2).getPrice()).doubleValue()  == 0.0)?  0: -1 ;
//		}else{
//			System.out.println( "less");
//			return -1;
//		}
		
//		
		if(  ((car)o1).getManufacturer().compareTo( ((car)o2).getManufacturer() )==0 ){
			
//			System.out.println( "equal");
			return ( ((car)o1).getPrice().subtract( ((car)o2).getPrice()).doubleValue()  > 0.0)? 1:( ((car)o1).getPrice().subtract( ((car)o2).getPrice()).doubleValue()  == 0.0)?  0: -1 ;
		}else{
			return ((car)o1).getManufacturer().compareTo( ((car)o2).getManufacturer() );
		}
		
		 
	}
}
public class hw5 {

	/**
	 * @param args
	 */
	public static void a(){
		// TODO 自動產生方法 Stub
		 BufferedReader br = null;
		 String file = "D:/01 新人專區/workspace/hw/src/cars.csv";
		 
		 FileReader fr;
		try {
			fr = new FileReader( new File(file) );
			br = new BufferedReader(fr);
			
			String sCurrentLine;
			String name="";
			ArrayList<car> items = new ArrayList<car>();
			int i=0;
			while ((sCurrentLine = br.readLine()) != null) {
				if(i!=0){
//					System.out.println(sCurrentLine);
					name = java.net.URLDecoder.decode(sCurrentLine, "UTF-8");
//					System.out.println(name);
					String [] tmp = name.split(",");
					
					items.add( new car( tmp[0],tmp[1],new BigDecimal(tmp[2]),new BigDecimal(tmp[3]) ) );
				}
				i++;
			}
			Collections.sort(items,  Collections.reverseOrder(new a_Comparator() ));
			System.out.println( "Manufacturer\tType\t\tMin_Price\tPrice");
		   for(car element : items) {
			   System.out.printf("%12S\t",element.getManufacturer());
		        System.out.println(element.getType()+"\t\t"+element.getMin_Price()+"\t\t"+element.getPrice());
		    }
		
		} catch (FileNotFoundException e) {
			// TODO 自動產生 catch 區塊
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO 自動產生 catch 區塊
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動產生 catch 區塊
			e.printStackTrace();
		}
		 
	}
	public static void b(){
		// TODO 自動產生方法 Stub
		 BufferedReader br = null;
		 String file = "D:/01 新人專區/workspace/hw/src/cars.csv";
		 
		 FileReader fr;
		try {
			fr = new FileReader( new File(file) );
			br = new BufferedReader(fr);
			
			String sCurrentLine;
			String name="";
			ArrayList<car> items = new ArrayList<car>();
			int i=0;
			while ((sCurrentLine = br.readLine()) != null) {
				if(i!=0){
//					System.out.println(sCurrentLine);
					name = java.net.URLDecoder.decode(sCurrentLine, "UTF-8");
//					System.out.println(name);
					String [] tmp = name.split(",");
					
					items.add( new car( tmp[0],tmp[1],new BigDecimal(tmp[2]),new BigDecimal(tmp[3]) ) );
				}
				i++;
			}
			Collections.sort(items,  Collections.reverseOrder(new b_Comparator() ) );
			System.out.println( "Manufacturer\tType\t\tMin_Price\tPrice");
		   for(car element : items) {
			   System.out.printf("%12S\t",element.getManufacturer());
		        System.out.println(element.getType()+"\t\t"+element.getMin_Price()+"\t\t"+element.getPrice());
		    }
		
		} catch (FileNotFoundException e) {
			// TODO 自動產生 catch 區塊
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO 自動產生 catch 區塊
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動產生 catch 區塊
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
//		a();
		b();
		 
	}


}
