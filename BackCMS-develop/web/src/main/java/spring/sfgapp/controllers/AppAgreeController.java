package spring.sfgapp.controllers;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.sfgapp.entity.AppAgree;
import spring.sfgapp.entity.AppImg;
import spring.sfgapp.services.AppAgreeService;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin
@RequestMapping({"/appagrees","/appagree"})

public class AppAgreeController {
    private final AppAgreeService appAgreeService;

    public AppAgreeController(AppAgreeService appAgreeService) {
        this.appAgreeService = appAgreeService;
    }

    @GetMapping({"/list","/lists"})
    public ResponseEntity<List<AppAgree>> AppAgreeList(){
        List<AppAgree> agreeList = appAgreeService.lfindAll();
        return new ResponseEntity<>(agreeList, HttpStatus.OK);
    }
    @PostMapping("/new")
    public ResponseEntity<Object> processCreationForm(@RequestBody AppAgree request, @Valid AppImg appagree, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.OK);
        } else {
            AppAgree savedAppAgree =  appAgreeService.save(request);
            return new ResponseEntity<>(savedAppAgree,HttpStatus.CREATED);
        }
    }
    @GetMapping("/{appagreeId}/edit")
    public ResponseEntity<Object> initUpdateAppAgreeForm(@Valid AppAgree appagree, BindingResult result, @PathVariable Long appagreeId) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } else {
            AppAgree editedAppAgree =  appAgreeService.findById(appagreeId );
            return new ResponseEntity<>(editedAppAgree, HttpStatus.OK);
        }
    }
    @GetMapping("/{appagreeId}/delete")
     public void deleteById(@PathVariable String appagreeId){
        appAgreeService.deleteById(Long.valueOf(appagreeId));
    }
}
