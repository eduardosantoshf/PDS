package aula1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Pds1_2 {

	public static void main(String[] args) {
		
		String path = "wordsoupgen.txt";
		String destination = null;
		int size=0;
		boolean cmdoverride[]= new boolean[2];
		int mode=0;
		for (String s:args) {
			switch(s) {
			case "-i":mode=1;break;
			case "-s":mode=2;break;
			case "-o":mode=3;break;
			default: 
				if (mode==1){path=s;}
				else if (mode==2){size=Integer.parseInt(s);cmdoverride[1]=true;}
				else if (mode==3) {destination=s;cmdoverride[0]=true;}
			}
		}
		
		String content ="";
		ArrayList<String> words = new ArrayList<String>();
		Hashtable<String,Boolean> palindrome = new Hashtable<String,Boolean>();
		try {
		File readwordsoup = new File(path);
		Scanner fileinput = new Scanner(readwordsoup);
		
		while (fileinput.hasNextLine()) {
			content+=fileinput.nextLine()+"\n";
		}
		fileinput.close();
		}catch(FileNotFoundException e) {System.out.println("File not Found");System.exit(0);}
		
		String lines[] = content.split("\n");
		
		if (!cmdoverride[0]) {destination = lines[0].strip();}
		if (!cmdoverride[1]) {size = Integer.parseInt(lines[1]);}
		if (size>50){System.out.println("board too big");System.exit(0);}
		for (String x:lines[2].split("[,; ]")){
			
			palindrome.put(x.toUpperCase(),false);
			if (x.equals(new StringBuilder(x).reverse().toString())) {palindrome.replace(x.toUpperCase(), true);}
			
			
			if (x.length()>size){System.out.println("words larger than board,shutting down");System.exit(0);}
			if (!x.matches("[a-zA-Z]+")) {System.out.println("alpha only");System.exit(0);}
			if (x.length()<4) {System.out.println("word too short");System.exit(0);}
			for (String y: words) {if (y.contains(x)||x.contains(y)) {System.out.println("word is contained by another");System.exit(0);}}
			words.add(x.toUpperCase());
		
		}
		
		char soup[][] = new char[size][size];
		
		
		Hashtable<String,Boolean> assigned = new Hashtable<String,Boolean>();
		for (String toplace:words){assigned.put(toplace,false);}
		
		
		 do{
			for (String toplace:words){assigned.put(toplace,false);}
			
			for(int k=0;k<size;k++) {//random soup
				for(int l=0;l<size;l++){
					soup[k][l]=(char)(Math.random()*26+65);
				}
			}
		for (String toplace:words){
			if (!assigned.get(toplace)){
				
			boolean xoverflow=false;
			boolean xunderflow=false;
			boolean yoverflow=false;
			boolean yunderflow=false;
			
			int x = (int) (Math.random()*size);
			int y = (int) (Math.random()*size);
			
			int dir= (int) (Math.random()*8);// right left down up downright upleft downleft upright
			
			if (x+toplace.length()>size) {xoverflow=true;}
			if (x+1<toplace.length()) {xunderflow=true;}
			if (y+toplace.length()>size) {yoverflow=true;}
			if (y+1<toplace.length()) {yunderflow=true;}
			
			switch(dir) {
			case 0:
				if (!xoverflow) {assigned.replace(toplace, true);
					for(int i=0;i<toplace.length();i++){soup[x++][y]=toplace.charAt(i);}
				}
				break;
			case 1:
				if (!xunderflow) {assigned.replace(toplace, true);
				for(int i=0;i<toplace.length();i++){soup[x--][y]=toplace.charAt(i);}
			}
				break;
			case 2:
				if (!yoverflow) {assigned.replace(toplace, true);
				for(int i=0;i<toplace.length();i++){soup[x][y++]=toplace.charAt(i);}
			}
				break;
			case 3:
				if (!yunderflow) {assigned.replace(toplace, true);
				for(int i=0;i<toplace.length();i++){soup[x][y--]=toplace.charAt(i);}
			}
				break;
			case 4:
				if (!xoverflow && !yoverflow) {assigned.replace(toplace, true);
				for(int i=0;i<toplace.length();i++){soup[x++][y++]=toplace.charAt(i);}
			}
				break;
			case 5:
				if (!xunderflow && !yunderflow) {assigned.replace(toplace, true);
				for(int i=0;i<toplace.length();i++){soup[x--][y--]=toplace.charAt(i);}
			}
				break;
			case 6:
				if (!xunderflow && !yoverflow) {assigned.replace(toplace, true);
				for(int i=0;i<toplace.length();i++){soup[x--][y++]=toplace.charAt(i);}
			}
				break;
			case 7:
				if (!xoverflow && !yunderflow) {assigned.replace(toplace, true);
				for(int i=0;i<toplace.length();i++){soup[x++][y--]=toplace.charAt(i);}
			}
				break;
				
			}//switch
			
			}//if
			
		}//for
		
		for (String placed:words) {//CHECK IF WORD SOUP IS VALID HERE
			int findcounter=0;
			findcounter+=CheckHorizontal(soup,placed); //implementação por funções por questoes de legibilidade
			findcounter+=CheckVertical(soup,placed);
			findcounter+=CheckDiagonal(soup,placed);
			int pal= (palindrome.get(placed))?1:0;
			if (findcounter!=(1+pal)){assigned.replace(placed, false);}
			
		}
		}while(assigned.contains(false));
		 
		 System.out.println(words);
		for(int k=0;k<size;k++) {
			for(int l=0;l<size;l++){
				System.out.print(soup[k][l]+ " ");
			}System.out.println();}
		File writeto = new File(destination);
		try {
			FileWriter writer = new FileWriter(writeto);
			for(int k=0;k<size;k++) {
				for(int l=0;l<size;l++){
					writer.write(soup[k][l]);
				}writer.write("\n");}
			for (String x:words) {writer.write(x.toLowerCase()+" ");}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	public static int CheckHorizontal(char[][] soup,String word) {
		int found=0;
		int size= soup.length;
		for (int i=0;i<size;i++) {
			StringBuilder makestr = new StringBuilder();
			for(int k=0;k<size;k++) {
				makestr.append(soup[i][k]);
			}
			String normal = makestr.toString();
			String rev=makestr.reverse().toString();
			while(normal.indexOf(word)!=-1){found++;normal=normal.substring(normal.indexOf(word)+1);}
			while(rev.indexOf(word)!=-1){found++;rev=rev.substring(rev.indexOf(word)+1);}
		}
		return found;
		

	}
	public static int CheckVertical(char[][] soup,String word) {
		int found=0;
		int size= soup.length;
		for (int i=0;i<size;i++) {
			StringBuilder makestr = new StringBuilder();
			for(int k=0;k<size;k++) {
				makestr.append(soup[k][i]);
			}
			String normal = makestr.toString();
			String rev=makestr.reverse().toString();
			while(normal.indexOf(word)!=-1){found++;normal=normal.substring(normal.indexOf(word)+1);}
			while(rev.indexOf(word)!=-1){found++;rev=rev.substring(rev.indexOf(word)+1);}
		}
		return found;
		

	}
	public static int CheckDiagonal(char[][] soup,String word){
		int found=0;
		int size = soup.length;
		int sizeoffset = size-1;
		for (int i=0;i<size-3;i++) {
			StringBuilder strsideleft = new StringBuilder();
			StringBuilder strsideright = new StringBuilder();
			StringBuilder strtopleft   = new StringBuilder();
			StringBuilder strtopright  = new StringBuilder();
			for (int k=0;k<size-i;k++) {//gen strings
				strsideleft.append(soup[k][i+k]);
				strsideright.append(soup[sizeoffset-k][i+k]);
				strtopleft.append(soup[i+k][k]);
				strtopright.append(soup[sizeoffset-i-k][k]);
			}
			ArrayList<String> diagonals = new ArrayList<String>(); //cleaner code with for loop
			diagonals.add(strsideleft.toString());
			diagonals.add(strsideleft.reverse().toString());
			diagonals.add(strsideright.toString());
			diagonals.add(strsideright.reverse().toString());
			diagonals.add(strtopleft.toString());
			diagonals.add(strtopleft.reverse().toString());
			diagonals.add(strtopright.toString());
			diagonals.add(strtopright.reverse().toString());
			
			for (String check:diagonals) {
				while(check.indexOf(word)!=-1){found++;check=check.substring(check.indexOf(word)+1);}	
			}
		}
		return found;
	}
}
