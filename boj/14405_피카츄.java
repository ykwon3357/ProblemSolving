import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String S = br.readLine().trim();
    	
    	S = S.replaceAll("pi|ka|chu", "");
    	
    	if(S.length()>0) 
    		System.out.println("NO");
    	else 
    		System.out.println("YES");

    }
}
