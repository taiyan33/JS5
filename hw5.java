import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class car {
    private String Manufacturer = "", Type = "";

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

    BigDecimal Min_Price = BigDecimal.ZERO, Price = BigDecimal.ZERO;

    car(String Manufacturer, String Type, BigDecimal Min_Price, BigDecimal Price) {

        this.Manufacturer = Manufacturer;
        this.Type = Type;
        this.Min_Price = Min_Price;
        this.Price = Price;

    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }
}

class a_Comparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        // TODO 自動產生方法 Stub
        /*return (((car) o1).getPrice().subtract(((car) o2).getPrice()).doubleValue() > 0.0) ? 1 : (((car) o1).getPrice().subtract(
            ((car) o2).getPrice()).doubleValue() == 0.0) ? 0 : -1;*/
        return ((car) o1).getPrice().compareTo(((car) o2).getPrice());
    }
}

class b_Comparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
	

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
    public static void a() {
        // TODO 自動產生方法 Stub
        BufferedReader br = null;
		BufferedWriter bw = null;
        String file = System.getProperty("user.dir").replace('\\', '/') + "/cars.csv";
		String fileout = System.getProperty("user.dir").replace('\\', '/')+"/cars2.csv";
		System.out.println(file);
//		D:\01 新人專區\workspace\hw./src/cars2.csv
        FileReader fr;
		
		FileWriter fw ;
        try {
            fr = new FileReader(new File(file));
            br = new BufferedReader(fr);

			fw = new FileWriter(new File(fileout));
			bw = new BufferedWriter(fw);
		
            String sCurrentLine;
            String name = "";
            ArrayList<car> items = new ArrayList<car>();
            int i = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                if (i != 0) {
                    //					System.out.println(sCurrentLine);
                    name = java.net.URLDecoder.decode(sCurrentLine, "UTF-8");
                    //					System.out.println(name);
                    String[] tmp = name.split(",");

                    items.add(new car(tmp[0], tmp[1], new BigDecimal(tmp[2]), new BigDecimal(tmp[3])));
                }
                i++;
            }
            Collections.sort(items, Collections.reverseOrder(new a_Comparator()));
            System.out.println("Manufacturer\tType\t\tMin_Price\tPrice");
			bw.append("Manufacturer,Type,Min_Price,Price");
			bw.newLine();
            for (car element : items) {
                System.out.printf("%12S\t", element.getManufacturer());
                System.out.println(element.getType() + "\t\t" + element.getMin_Price() + "\t\t" + element.getPrice());
				
				bw.append(""+element.getManufacturer()+","+element.getType() + "," + element.getMin_Price() + "," + element.getPrice());
				bw.newLine();
                
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
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO 自動產生 catch 區塊
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    // TODO 自動產生 catch 區塊
                    e.printStackTrace();
                }
            }

        }

    }

    public static void b() {
        // TODO 自動產生方法 Stub
        BufferedReader br = null;
        String file = System.getProperty("user.dir")+"/cars.csv";

        FileReader fr;
        try {
            fr = new FileReader(new File(file));
            br = new BufferedReader(fr);

            String sCurrentLine;
            String name = "";
            ArrayList<car> items = new ArrayList<car>();
            int i = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                if (i != 0) {
                    //					System.out.println(sCurrentLine);
                    name = java.net.URLDecoder.decode(sCurrentLine, "UTF-8");
                    //					System.out.println(name);
                    String[] tmp = name.split(",");

                    items.add(new car(tmp[0], tmp[1], new BigDecimal(tmp[2]), new BigDecimal(tmp[3])));
                }
                i++;
            }
            Collections.sort(items, Collections.reverseOrder(new b_Comparator()));
            System.out.println("Manufacturer\tType\t\tMin_Price\tPrice");
			String currentManufacturer="";
			BigDecimal priceSum=BigDecimal.ZERO, MinPriceSum=BigDecimal.ZERO, AllPriceSum=BigDecimal.ZERO, AllMinPriceSum=BigDecimal.ZERO ;
			currentManufacturer= items.get(0).getManufacturer();
			int ii=1;
			car lastCar;
            for (car element : items) {
                
				if( element.getManufacturer().equals(currentManufacturer) ){
					priceSum= priceSum.add(element.getPrice()  );
					MinPriceSum=MinPriceSum.add( element.getMin_Price() );
					
					ii++;
				} else{
					
					System.out.println( "小計:" + MinPriceSum.doubleValue()+"\t"+  priceSum.doubleValue() );
					System.out.printf("%12S\t", element.getManufacturer());
					System.out.println(element.getType() + "\t\t" + element.getMin_Price() + "\t\t" + element.getPrice());
					
					AllPriceSum=AllPriceSum.add(priceSum);
					AllMinPriceSum=AllMinPriceSum.add(MinPriceSum);
					priceSum=element.getPrice();
					MinPriceSum=  element.getMin_Price() ;
					currentManufacturer=element.getManufacturer();
					ii++;
					continue;
				}
				System.out.printf("%12S\t", element.getManufacturer());
				System.out.println(element.getType() + "\t\t" + element.getMin_Price() + "\t\t" + element.getPrice());
				lastCar=element;
            }
			System.out.println( "小計:" + MinPriceSum.doubleValue()+"\t"+ priceSum.doubleValue());
			AllPriceSum=AllPriceSum.add(priceSum);
				System.out.println("總計:"+AllMinPriceSum.doubleValue()+"\t"+ AllPriceSum.doubleValue());	
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

        a();
        System.out.println("");
         b();

    }

}
