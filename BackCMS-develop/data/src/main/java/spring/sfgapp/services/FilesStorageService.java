package spring.sfgapp.services;

import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import spring.sfgapp.entity.DatabaseFile;
import spring.sfgapp.model.Response;

public interface FilesStorageService {
    public void init();

    public Response save(MultipartFile file);

    public Resource load(String filename);
    
    public DatabaseFile getFile(Long fileId, String fileName) throws Exception;

    public void deleteAll();

    public Stream<Path> loadAll();
}