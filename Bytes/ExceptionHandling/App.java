
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.IIOException;

public class App {
    LocalStorage localStorage = new LocalStorage();
    NetworkStorage networkStorage = new NetworkStorage();

    public String loginOffline(String username, String inputPassword) {
        String expectedPassword;

        try {
            expectedPassword = localStorage.getPassword(username);
            throw new FileNotFoundException(
                    "Dealing from here, will not get printed because we catching it next?");
        } catch (IOException exceptionObject) {
            // OLD: We were returning an error message string
            // exceptionObject.printStackTrace();
            // return "Internal Error, please try again later";

            try {
                expectedPassword = networkStorage.getPassword(username);
            } catch (IOException e) {
                e.printStackTrace();
                return "Internal Error, please try again later";
            }
        }
        // catch (IOException e){
        // return "Internal Error, please try again later";
        // }

        if (expectedPassword == (null)) {
            return "Invalid UserName";
        } else if (expectedPassword.equals(inputPassword)) {
            return "Login successful";
        } else {
            return "Invalid password!";
        }

    }

    // Uncomment the code for loginOnline method in Milestone 4

    public String loginOnline(String username, String password) {
        try {
            String expected = networkStorage.getPassword(username);

            if (expected.equals(password)) {
                return "Login successful";
            } else {
                return "Invalid password!";
            }

        } catch (IOException e) {
            // log error trace to file
            e.printStackTrace();
            return "Internal error, please try again later";
        }
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.loginOffline("Dhoni", "dhoniPassword"));

        
        // Below lines are to be commented out in Milestone 5 only
        // final ExecutorService executor = Executors.newFixedThreadPool(5);
        // // it's just an arbitrary number
        // final List<Future<?>> futures = new ArrayList<>();
        // for (int i = 0; i < 1000; i++) {
        //     Future<?> future = executor.submit(() -> {
        //         app.loginOnline("Dhoni", "dhoni");
        //     });
        //     System.out.println(i);
        //     futures.add(future);
        // }
        // try {
        //     for (Future<?> future : futures) {
        //         future.get(); // do anything you need, e.g. isDone(), ...
        //     }
        // } catch (InterruptedException | ExecutionException e) {
        //     e.printStackTrace();
        // }
    }
}
