package process;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
	Scanner input;
	public void login() {
		input = new Scanner(System.in);
        System.out.println("input Username: ");
        String username = input.nextLine();
        System.out.println("input Password: ");
        String password = input.nextLine();

        login(username,password);
	}
	public void register() {
		input = new Scanner(System.in);
        System.out.println("input Username: ");
        String username = input.nextLine();
        System.out.println("input Password: ");
        String password = input.nextLine();
        String account = "\n"+username+"-"+password;
        System.out.println(username + "  "+ password);
        try {
        		BufferedWriter writer = new BufferedWriter(new FileWriter("document/login.txt",true));
        		writer.append(account);
        		writer.close();
        }catch(IOException e) {
        		System.out.println("Problem when writing file!");
        }
        System.out.println("Successfully Register!!! -- Welcome: "+ username+"\n");
	}
	public boolean login(String user, String pass){
        List<String> list;
        list = isList("document/login.txt");

       if(isRegisterd(list,user,pass)){
           System.out.println("Successfully Login!!!");
           return true;
       }
       else {
           System.out.println("Wrong userID or password!!!");
           return false;
       }
       	
        /*
        for(String line : list){
            //String [] res = line.split(";");
            System.out.println(line);
        }*/
    }

    public Boolean isRegisterd(List<String> list, String username, String password){
        boolean isCheck = false;
        String[] res;
        for(String line : list){
            res = line.split("-");
            if(res[0].equals(username) && res[1].equals(password)){
                isCheck = true;
                break;
            }
        }
        return isCheck;
    }

    public void showLoginPage(){

    }

    public List<String> isList(String filename){
        List<String> list = new ArrayList<String>();

        File file = new File(filename);
        if(file.exists()){
            try {
                list = Files.readAllLines(file.toPath(), Charset.defaultCharset());
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }

    public void printMenu(){
        System.out.println(" ---------");
        System.out.println("| jMoSS |");
        System.out.println(" --------");
        System.out.print("1. Login \n" + "2. Register\n"+ "3. Exit");
    }
}
