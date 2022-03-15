package aula1;

import java.io.*;
import java.util.*;


public class WSSolver {
	
	public static void main(String[] args) {
		boolean timer = false;
		String path = "kebab.txt";
		for (String arg:args) {
			if (arg.equals("-timing")) {
				timer = true;
			}
			else {
				path=arg;
			}
		}
		long time1 = System.nanoTime();
		char[][] soup = null;
		int size = 0;
		LinkedHashMap<String,ArrayList<String>> list = new LinkedHashMap<String, ArrayList<String>>();
		try {
			File text = new File(path);
			Scanner sc = new Scanner(text);
			String line = sc.nextLine();
			size = line.length();
			soup = new char[size][size];
			soup[0] = line.toCharArray();
			for (int i = 1; i < size; i++) {
				String soupline = sc.nextLine();
				if (!soupline.equals(soupline.toUpperCase())||soupline.length()!=size) {System.out.println("Soup disformed or with a lower case.");System.exit(0);}
				soup[i] = soupline.toCharArray();
			}
			String listtxt = "";
			while (sc.hasNext()) {
				String linetxt = sc.nextLine();
				if (linetxt.equals(linetxt.toUpperCase()) && !linetxt.isBlank()) {System.out.println("List line cannot be all upper case.");System.exit(0);};
				listtxt += linetxt+"\n";
			}
			String[] listtmp = listtxt.split("[,; \n]");
			for (int i = 0; i < listtmp.length; i++) {
				listtmp[i] = listtmp[i].trim();
				if (listtmp[i].matches("^.*[^a-zA-Z ].*$")) {System.out.println("List has a non alphabetic character.");System.exit(0);}; 
			}
			for (String s : listtmp) {
				if (!s.isBlank()) {
					if (s.length() < 4) {System.out.println("List word too short (<4).");System.exit(0);};
					list.put(s.toUpperCase(), new ArrayList<String>());
				}
			}
			for (String x : list.keySet()) {
				for (String y : list.keySet()) {
					if ((x.contains(y)||y.contains(x))&&!(x.contains(y)&&y.contains(x))) {System.out.println("List word contained in another.");System.exit(0);};;
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str = "";
		String rstr = "";
		int i;
		int j;
		for (i = 0; i < size; i++) {
			str = new String(soup[i]);
			rstr = new StringBuilder(str).reverse().toString();
			for (String item : list.keySet()) {
				if ((str.contains(item)||rstr.contains(item))&&!list.get(item).isEmpty()) {System.out.println("Word found twice in soup.");System.exit(0);};
				if (str.contains(item)) {
					if (str.indexOf(item) != str.lastIndexOf(item)) {System.out.println("Word found twice in soup.");System.exit(0);};
					list.get(item).add(Integer.toString(i+1));
					list.get(item).add(Integer.toString(str.indexOf(item)+1));
					list.get(item).add("right");
				}
				if (rstr.contains(item)) {
					if (str.indexOf(item) != str.lastIndexOf(item)) {System.out.println("Word found twice in soup.");System.exit(0);};
					list.get(item).add(Integer.toString(i+1));
					list.get(item).add(Integer.toString(size-rstr.indexOf(item)));
					list.get(item).add("left");
				}
			}
		}
		for (i = 0; i < size; i++) {
			str = "";
			for (j = 0; j < size; j++) {
				str += soup[j][i];
			}
			rstr = new StringBuilder(str).reverse().toString();
			for (String item : list.keySet()) {
				if ((str.contains(item)||rstr.contains(item))&&!list.get(item).isEmpty()) {System.out.println("Word found twice in soup.");System.exit(0);};
				if (str.contains(item)) {
					if (str.indexOf(item) != str.lastIndexOf(item)) {System.out.println("Word found twice in soup.");System.exit(0);};
					list.get(item).add(Integer.toString(str.indexOf(item)+1));
					list.get(item).add(Integer.toString(i+1));
					list.get(item).add("down");
				}
				if (rstr.contains(item)) {
					if (str.indexOf(item) != str.lastIndexOf(item)) {System.out.println("Word found twice in soup.");System.exit(0);};
					list.get(item).add(Integer.toString(size-rstr.indexOf(item)));
					list.get(item).add(Integer.toString(i+1));
					list.get(item).add("up");
				}
			}
		}
		for (i = 0; i < size; i++) {
			str = "";
			for (j = 0; i+j < size; j++) {
				str += soup[i+j][j];
			}
			rstr = new StringBuilder(str).reverse().toString();
			for (String item : list.keySet()) {
				if ((str.contains(item)||rstr.contains(item))&&!list.get(item).isEmpty()) {System.out.println("Word found twice in soup.");System.exit(0);};
				if (str.contains(item)) {
					if (str.indexOf(item) != str.lastIndexOf(item)) {System.out.println("Word found twice in soup.");System.exit(0);};
					list.get(item).add(Integer.toString(str.indexOf(item)+1+i));
					list.get(item).add(Integer.toString(str.indexOf(item)+1));
					list.get(item).add("downright");
				}
				if (rstr.contains(item)) {
					if (str.indexOf(item) != str.lastIndexOf(item)) {System.out.println("Word found twice in soup.");System.exit(0);};
					list.get(item).add(Integer.toString(size-rstr.indexOf(item)));
					list.get(item).add(Integer.toString(size-rstr.indexOf(item)-i));
					list.get(item).add("upleft");
				}
			}
		}
		for (i = 1; i < size; i++) {
			str = "";
			for (j = 0; i+j < size; j++) {
				str += soup[j][i+j];
			}
			rstr = new StringBuilder(str).reverse().toString();
			for (String item : list.keySet()) {
				if ((str.contains(item)||rstr.contains(item))&&!list.get(item).isEmpty()) {System.out.println("Word found twice in soup.");System.exit(0);};
				if (str.contains(item)) {
					if (str.indexOf(item) != str.lastIndexOf(item)) {System.out.println("Word found twice in soup.");System.exit(0);};
					list.get(item).add(Integer.toString(str.indexOf(item)+1));
					list.get(item).add(Integer.toString(str.indexOf(item)+1+i));
					list.get(item).add("downright");
				}
				if (rstr.contains(item)) {
					if (str.indexOf(item) != str.lastIndexOf(item)) {System.out.println("Word found twice in soup.");System.exit(0);};
					list.get(item).add(Integer.toString(size-rstr.indexOf(item)-i));
					list.get(item).add(Integer.toString(size-rstr.indexOf(item)));
					list.get(item).add("upleft");
				}
			}
		}
		for (i = size-1; i >= 0; i--) {
			str = "";
			for (j = 0; i-j >= 0; j++) {
				str += soup[i-j][j];
			}
			rstr = new StringBuilder(str).reverse().toString();
			for (String item : list.keySet()) {
				if ((str.contains(item)||rstr.contains(item))&&!list.get(item).isEmpty()) {System.out.println("Word found twice in soup.");System.exit(0);};
				if (str.contains(item)) {
					if (str.indexOf(item) != str.lastIndexOf(item)) {System.out.println("Word found twice in soup.");System.exit(0);};
					list.get(item).add(Integer.toString(i-str.indexOf(item)+1));
					list.get(item).add(Integer.toString(str.indexOf(item)+1));
					list.get(item).add("upright");
				}
				if (rstr.contains(item)) {
					if (str.indexOf(item) != str.lastIndexOf(item)) {System.out.println("Word found twice in soup.");System.exit(0);};
					list.get(item).add(Integer.toString(rstr.indexOf(item)+1));
					list.get(item).add(Integer.toString(i-rstr.indexOf(item)+1));
					list.get(item).add("downleft");
				}
			}
		}
		for (i = 1; i < size; i++) {
			str = "";
			for (j = size-1; i+size-1-j < size; j--) {
				str += soup[j][i+size-1-j];
			}
			rstr = new StringBuilder(str).reverse().toString();
			for (String item : list.keySet()) {
				if ((str.contains(item)||rstr.contains(item))&&!list.get(item).isEmpty()) {System.out.println("Word found twice in soup.");System.exit(0);};
				if (str.contains(item)) {
					if (str.indexOf(item) != str.lastIndexOf(item)) {System.out.println("Word found twice in soup.");System.exit(0);};
					list.get(item).add(Integer.toString(size-str.indexOf(item)));
					list.get(item).add(Integer.toString(i+str.indexOf(item)+1));
					list.get(item).add("upright");
				}
				if (rstr.contains(item)) {
					if (str.indexOf(item) != str.lastIndexOf(item)) {System.out.println("Word found twice in soup.");System.exit(0);};
					list.get(item).add(Integer.toString(rstr.indexOf(item)+i+1));
					list.get(item).add(Integer.toString(size-rstr.indexOf(item)));
					list.get(item).add("downleft");
				}
			}
		}
		long time2 = System.nanoTime();
		if (timer) {
			System.out.printf("Elapsed time (secs): %.3f\n",(time2-time1)/1000000000.0);
		}
		for (String key : list.keySet()) {
			if (list.get(key).isEmpty()) {System.out.println("Word "+key+" not found in soup.");System.exit(0);}
		}
		for (String key : list.keySet()) {
			for (int x = 0; x < (list.get(key).size()-1)/2; x++) {
				String coord = list.get(key).get(0+x*3)+","+list.get(key).get(1+x*3);
				System.out.printf("%-15s %-5d %-7s %s\n",key,key.length(),coord,list.get(key).get(2+x*3));
			}
		}
	}
}
