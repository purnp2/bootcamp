
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import java.util.HashMap;

public class LocalStorage {

    public String getPassword(String username) throws FileNotFoundException, IOException {
        Map<String, String> unameToPassMap = new HashMap<>();

        unameToPassMap = getUsernameToPasswordMapping();

        String password = unameToPassMap.get(username);

        return password;
    }

  

    public Map<String, String> getUsernameToPasswordMapping() throws FileNotFoundException, IOException {
        // read login data from file
        File loginDataFile = new File("resources/UnameToPass23.txt");
        FileReader fileReader = new FileReader(loginDataFile); 
        BufferedReader bufferedReader = new BufferedReader(fileReader); 
        System.out.println("Opened resource");

        String inputLine, userName, password;
        Map<String, String> unameToPassMap = new HashMap<String, String>();
        
        // map each username password pair
        while ((inputLine = bufferedReader.readLine()) != null)
        {
            userName = inputLine.split(":")[0];
            password = inputLine.split(":")[1];
            unameToPassMap.put(userName, password);
        }

        bufferedReader.close();
        fileReader.close();
        System.out.println("Closed resource");

        return unameToPassMap;
    }
}

