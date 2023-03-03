package spring.sfgapp.services;
import org.springframework.web.multipart.MultipartFile;

public interface AppUpService {

    void saveImageFile(Long recipeId, MultipartFile file);
}