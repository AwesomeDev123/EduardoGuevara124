package spring.sfgapp.controllers;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.sfgapp.entity.AppImg;
import spring.sfgapp.services.AppImgService;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin
@RequestMapping({"/appimgs","/appimg"})
public class AppImgController {
    private final AppImgService  appImgService;

    public AppImgController(AppImgService appImgService) {
        this.appImgService = appImgService;
    }
    //private static final String VIEWS_APP_TXT_CREATE_OR_UPDATE_FORM = "appimgs/createOrUpdateAppImgForm.html";
    @GetMapping({"/list","/lists"})
    public ResponseEntity<List<AppImg>> AppImgList(){
        List<AppImg> list = appImgService.lfindAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("/new")
    public ResponseEntity<Object> processCreationForm(@RequestBody AppImg request, @Valid AppImg appimg, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.OK);
        } else {
            AppImg savedAppImg =  appImgService.save(request);
            return new ResponseEntity<>(savedAppImg,HttpStatus.CREATED);
        }
    }
    @GetMapping("/{appimgId}/edit")
    public ResponseEntity<Object> initUpdateAppImgForm(@Valid AppImg appimg, BindingResult result, @PathVariable Long appimgId) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } else {
            AppImg editedAppImg =  appImgService.findById(appimgId );
            return new ResponseEntity<>(editedAppImg, HttpStatus.OK);
        }
    }
    @GetMapping("/{appimgId}/delete")
    public void deleteById(@PathVariable String appimgId){
        appImgService.deleteById(Long.valueOf(appimgId));
    }
}
