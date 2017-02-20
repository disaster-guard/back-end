package Controller;

import Pojo.Age;
import Pojo.CompleteIdentification;
import Pojo.Match;
import Pojo.User;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/getUserIdentification")
@MultipartConfig(fileSizeThreshold = 20971520)
public class MachineLearningIdController {

    @RequestMapping("/greeting")
    public CompleteIdentification greeting(
            @RequestHeader(value = "Authorization") String header,
            @RequestParam(value = "user_id") String userId) {
        List<Match> arr = new ArrayList<>();
        arr.add(new Match("dave", 8.8));
        User usr = new User("200", arr);
        Age age = new Age("200", "male", "88", "white");
        return new CompleteIdentification(usr, age);
    }

    @RequestMapping(value = "/upload")
    public String uploadFile(
            @RequestParam("uploadedFile") MultipartFile uploadedFileRef) {
        // Get name of uploaded file.
        String fileName = uploadedFileRef.getOriginalFilename();

        // Path where the uploaded file will be stored.
        String path = "C:\\Users\\Dave\\Documents\\GitHub\\back\\back-end\\" + fileName;

        // This buffer will store the data read from 'uploadedFileRef'
        byte[] buffer = new byte[1000];

        // Now create the output file on the server.
        File outputFile = new File(path);

        FileInputStream reader = null;
        FileOutputStream writer = null;
        int totalBytes = 0;
        try {
            outputFile.createNewFile();

            // Create the input stream to uploaded file to read data from it.
            reader = (FileInputStream) uploadedFileRef.getInputStream();

            // Create writer for 'outputFile' to write data read from
            // 'uploadedFileRef'
            writer = new FileOutputStream(outputFile);

            // Iteratively read data from 'uploadedFileRef' and write to
            // 'outputFile';
            int bytesRead = 0;
            while ((bytesRead = reader.read(buffer)) != -1) {
                writer.write(buffer);
                totalBytes += bytesRead;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Runtime rt = Runtime.getRuntime();
        Process proc = null;
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "C:\\Python27\\python.exe",
                    "C:\\Users\\Dave\\Documents\\GitHub\\back\\back-end\\cla.py",
                    path);
            pb.directory(new File("C:\\"));
            pb. redirectErrorStream(true);
            proc = pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (proc == null) {
            System.out.println("Process is null!");
        }
        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(proc.getInputStream()));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(proc.getErrorStream()));

        // read the output from the command
        System.out.println("Here is the standard output of the command:\n");
        String s = null;
        try {
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read any errors from the attempted command
        System.out.println("Here is the standard error of the command (if any):\n");
        try {
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "File uploaded successfully! Total Bytes Read="+totalBytes + " location=" + path;
    }
}
