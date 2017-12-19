import java.util.*;
import java.io.*;

public class readGoogleStockCsv {
	
	static ArrayList<ArrayList<String>> getData(InputStream f){
		int c;
		StringBuffer s = new StringBuffer();
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> open = new ArrayList<String>();
		ArrayList<String> high = new ArrayList<String>();
		ArrayList<String> low = new ArrayList<String>();
		ArrayList<String>  close = new ArrayList<String>();
		ArrayList<String> volume = new ArrayList<String>();
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		data.add(date);
		data.add(open);
		data.add(high);
		data.add(low);
		data.add(close);
		data.add(volume);
		int index = 0;
		try{		
			while((c=f.read())!=-1){
				if (index==6){
					index=0;
				}
				if ((char)c!=',' && (char)c!='\n'){
					s.append((char) c);
				}else{
					ArrayList<String> temp = data.get(index);
					temp.add(s.toString());
					s.delete(0,s.length());
					index = index+1;			
				}											
			}						
		}catch(Exception e){
			System.out.println(e);
		}
		return data;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Directory = "CSV Dir";
		try{
			InputStream f = new FileInputStream(Directory);
			ArrayList<ArrayList<String>> data = getData(f);
		} catch(Exception e){
			System.out.println(e);
		}		
	}
}
