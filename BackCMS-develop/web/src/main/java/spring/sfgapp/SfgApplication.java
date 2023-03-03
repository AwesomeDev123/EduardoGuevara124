package spring.sfgapp;
import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.sfgapp.services.FilesStorageService;

@SpringBootApplication
public class SfgApplication implements CommandLineRunner{

    @Resource
    FilesStorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(SfgApplication.class, args);
    }
    @Override
    public void run(String... arg) throws Exception {
//    storageService.deleteAll();
        storageService.init();
    }
}
