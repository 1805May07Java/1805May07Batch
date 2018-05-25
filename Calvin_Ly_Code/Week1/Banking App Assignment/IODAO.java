package banking;

import java.io.*;
import java.util.ArrayList;
import static java.lang.Double.parseDouble;

public class IODAO {
    final static String accountFile = "src/banking/accounts.txt";
    final static String backup = "src/banking/backup.txt";

    public static ArrayList<User> readUsers(){
        User temp;
        try (BufferedReader reader = new BufferedReader(new FileReader(accountFile))) {
            String line = "";
            ArrayList<User> tempList = new ArrayList<User>();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                temp = new User(data[0], data[1], data[2], data[3], parseDouble(data[4]));
                tempList.add(temp);
            }
            return tempList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    void addUser(User newUser){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(accountFile, true))){
            writer.write(newUser.toString());
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    void overwrite(User user){
        String overwriteUser = user.toString();
        //creating a tempfile.
        File tempfile = new File(backup);
        File oldfile = new File(accountFile);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(tempfile, true));
            BufferedReader reader = new BufferedReader(new FileReader(accountFile))){
            String line;
            //while(there is a non-null line)
            while((line = reader.readLine()) != null){
                //if the line does not contain the username, write.
                //if statement skips over the old values (will write new values after the loop)
                if(!line.contains(user.getUsername())){
                    writer.write(line+"\n");
                    writer.flush();
                }
            }
            //append the new values at the end of the file.
            writer.write(overwriteUser);
            writer.close();
            reader.close();
            //delete the original file with old values
            if(!oldfile.delete()){
                System.out.println("Could not delete file");
                return;
            }
            //rename the temp to the original file. contains new values.
            if(!tempfile.renameTo(oldfile))
                System.out.println("Could not rename file");
        }

        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
