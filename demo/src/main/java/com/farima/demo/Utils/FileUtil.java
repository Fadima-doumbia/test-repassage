package com.farima.demo.Utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUtil {
    static String uploadDir = "src/main/webapp/WEB-INF/images/";
    public static long saveFileAndReplace(String lastFile, MultipartFile file, String newFile, long id) throws IOException{
        Path uploadPath = Paths.get(uploadDir + "/" + id);
        if(!Files.exists(uploadPath)){
            Files.createDirectory(uploadPath);
        }
        try {
            if (lastFile != null){
                if (!lastFile.equals(newFile)){
                    Files.delete(uploadPath.resolve(lastFile));
                }
            }

            return Files.copy(file.getInputStream(), uploadPath.resolve(newFile), StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void saveFile(long demoId, String fileName,
                                MultipartFile multipartFile) throws IOException {

        Path uploadPath = Paths.get(uploadDir + "/" + demoId);

            //si le dosier n'existe pas il le creer
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            // i le dosier existe il fait la methode resolve
                    Path filePath = uploadPath.resolve(fileName);

            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }
}
