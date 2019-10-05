package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

    static BufferedReader bufferedReaderr;

    // the try-with-resources method will automatically close the stream
    static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            bufferedReaderr = br;
            return br.readLine();
        }
    }

    // use this method to see that stream will not be closed automatically
    static String readFirstLineFromFile(String path, int diff) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        bufferedReaderr = br;
        return br.readLine();
    }


    public static void main(String[] args) {

        try {
            // change method call here!
            int error = Integer.parseInt(TryWithResources.readFirstLineFromFile("OutFile.txt",0));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println(TryWithResources.bufferedReaderr.ready());
                TryWithResources.bufferedReaderr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
