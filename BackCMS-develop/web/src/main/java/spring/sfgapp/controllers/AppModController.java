package spring.sfgapp.controllers;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.sfgapp.entity.AppMod;
import spring.sfgapp.services.AppModService;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin
@RequestMapping({"/appmods","/appmod"})
public class AppModController {
    private final AppModService  appModService;

    public AppModController(AppModService appModService) {
        this.appModService = appModService;
    }
    //private static final String VIEWS_APP_TXT_CREATE_OR_UPDATE_FORM = "appmods/createOrUpdateAppModForm.html";
    @GetMapping({"/list","/lists"})
    public ResponseEntity<List<AppMod>> AppModList(){
        List<AppMod> list = appModService.lfindAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("/new")
    public ResponseEntity<Object> processCreationForm(@RequestBody AppMod request, @Valid AppMod appmod, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.OK);
        } else {
            AppMod savedAppMod =  appModService.save(request);
            return new ResponseEntity<>(savedAppMod,HttpStatus.CREATED);
        }
    }
    @GetMapping("/{appmodId}/edit")
    public ResponseEntity<Object> initUpdateAppModForm(@Valid AppMod appmod, BindingResult result, @PathVariable Long appmodId) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } else {
            AppMod editedAppMod =  appModService.findById(appmodId );
            return new ResponseEntity<>(editedAppMod, HttpStatus.OK);
        }
    }
    @GetMapping
    @RequestMapping("/{appmodId}/delete")
    public void deleteById(@PathVariable String appmodId){
        appModService.deleteById(Long.valueOf(appmodId));
    }

    @GetMapping("/{appmodName}/{appmodIndex}/edit")
    public ResponseEntity<Object> paramsdUpdateAppModForm(@Valid AppMod appmod, BindingResult result, @PathVariable String appmodName,@PathVariable String appmodIndex ) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } else {
            List editedAppModNameAndIndex =  appModService.findByAppModNameAndAppModIndex(appmodName,appmodIndex);
            return new ResponseEntity<>(editedAppModNameAndIndex, HttpStatus.OK);
        }
    }

}
