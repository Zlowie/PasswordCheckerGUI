import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class User {
	private String username;
	private String passhash;
	
	private static ArrayList<User> userList = new ArrayList<User>();
	
	private User(){
		
	}
	
	public User(String name, String pass){
		username = name;
		passhash = Hashing.MD5Hash(pass);
		userList.add(this);
	}
	
	public static void addUser(String name, String hash) {
		User tempUser = new User();
		tempUser.username = name;
		tempUser.passhash = hash;
		userList.add(tempUser);
	}
	
	public static boolean UserExists(String name) {
		int length = userList.size();
	      for (int i = 0; i < length; i++) {
	    	  if(userList.get(i).username.equals(name)) return true;
	      }
	      return false;
	}
	
	public static boolean HashMatch(String name, String pass) {
		String hash = Hashing.MD5Hash(pass);
		boolean result = false;
		
		int length = userList.size();
	      for (int i = 0; i < length; i++) {
	    	  if(userList.get(i).username.equals(name)) {
	    		  if (userList.get(i).passhash.equals(hash)) {
	    			  result = true;
	    		  }else {
	    			  
	    		  }
	    		  
	    	  }
	      }
	      return result;
	}
	
	public static void SingleUserToFile(String name, String pass) {
		try {
			File myFile = new File("C:\\Temp\\userpass.txt");
			//if we wish to append to the file, it needs to exist in the first place
			if(!myFile.exists()) myFile.createNewFile();
			//new set FileWriter append setting to true so we can continue an exisitng file
			FileWriter myFileWriter = new FileWriter(myFile);
			BufferedWriter myBufferedWriter = new BufferedWriter(myFileWriter);
			
			myBufferedWriter.write(name+"\n");
			myBufferedWriter.write(Hashing.MD5Hash(pass)+"\n");
			myBufferedWriter.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ReadUserFile() {
		try {
			File myFile = new File("C:\\\\Temp\\\\userpass.txt");
			FileReader myFileReader = new FileReader(myFile);
			BufferedReader myReader = new BufferedReader(myFileReader);
			
			//time to read the entire user file
			String user, hash;
			while((user = myReader.readLine())!=null) {
				hash = myReader.readLine();
				
				addUser(user, hash);
				
			}
			
			myReader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
