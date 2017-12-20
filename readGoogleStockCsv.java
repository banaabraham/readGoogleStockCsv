class readCSV{
	
	InputStream f;
	ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
	ArrayList<Double> close = new ArrayList<Double>();
	ArrayList<Integer> volume = new ArrayList<Integer>();
	readCSV(String dir){
		try{
			f = new FileInputStream(dir);
		}catch(Exception e){
			System.out.println(e);
		}		
		getData();
	}
	ArrayList<ArrayList<String>> getData(){
		int c;
		StringBuffer s = new StringBuffer();
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> open = new ArrayList<String>();
		ArrayList<String> high = new ArrayList<String>();
		ArrayList<String> low = new ArrayList<String>();
		ArrayList<String>  close = new ArrayList<String>();
		ArrayList<String> volume = new ArrayList<String>();	
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
					//System.out.println(s.toString());
					s.delete(0,s.length());
					index = index+1;			
				}											
			}						
		}catch(Exception e){
			System.out.println(e);
		}
		return data;
	}
	
	ArrayList<Double> getClose(){
		ArrayList<String> temp = data.get(4);
		temp.remove(0);
		ArrayList<Double> close = new ArrayList<Double>();
		for(String s: temp){
			try{
				double d = Double.parseDouble(s);
				close.add(d);
			}catch(Exception e){
				continue;
			}
			
		}
		return close;	
	}
	
	ArrayList<Integer> getVolume(){
		ArrayList<String> temp = data.get(5);
		temp.remove(0);
		ArrayList<Integer> volume = new ArrayList<Integer>();
		for(String s: temp){
			try{
				int d = Integer.parseInt(s);
				volume.add(d);
			}catch(Exception e){
				continue;
			}			
		}
		return volume;	
	}
	
}


public class readGoogleStockCsv extends plotCSV{
	
	readGoogStockCsv(String title, String dir) {
		super(dir);
	}

	public static void main(String[] args) {
		String dir = "D:\\goog.csv";
		plotCSV plot = new plotCSV(dir);
	}
}
