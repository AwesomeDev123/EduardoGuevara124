package spring.sfgapp.controllers;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.sfgapp.entity.AppOpt;
import spring.sfgapp.services.AppOptService;
import spring.sfgapp.services.AppUpService;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
@Controller
@CrossOrigin
@RequestMapping({"/appups","/appup"})
public class AppUpController {
    private final AppUpService appUpService;
    private final AppOptService appoptService;

    public AppUpController(AppUpService appUpService, AppOptService appoptService) {
        this.appUpService = appUpService;
        this.appoptService = appoptService;
    }

    @GetMapping("appopt/{id}/image")
    public ResponseEntity<Object> showUploadForm(@PathVariable String id, Model model){
        AppOpt editedAppOpt =  appoptService.findById(Long.valueOf(id));
        return new ResponseEntity<>(editedAppOpt, HttpStatus.OK);
    }

    @PostMapping("appopt/{id}/image")
    public ResponseEntity<Object> handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file){

        appUpService.saveImageFile(Long.valueOf(id), file);
        return  null;
    }

    @GetMapping("appopt/{id}/appoptimage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        AppOpt editedAppOpt = appoptService.findById(Long.valueOf(id));

//        if (editedAppOpt.getOptSrcImg() != null) {
//            byte[] byteArray = new byte[editedAppOpt.getOptSrcImg().length];
//            int i = 0;
//
//            for (Byte wrappedByte : editedAppOpt.getOptSrcImg()){
//                byteArray[i++] = wrappedByte; //auto unboxing
//            }
//
//            response.setContentType("image/jpeg");
//            InputStream is = new ByteArrayInputStream(byteArray);
//            IOUtils.copy(is, response.getOutputStream());
//        }
    }

}
