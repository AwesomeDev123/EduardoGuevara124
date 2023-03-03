package spring.sfgapp.controllers;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.sfgapp.entity.AppTxt;
import spring.sfgapp.services.AppTxtService;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin
@RequestMapping({"/apptxts","/apptxt"})
public class AppTxTController {

    private final AppTxtService  appTxtService;

    public AppTxTController(AppTxtService appTxtService) {
        this.appTxtService = appTxtService;
    }
    //private static final String VIEWS_APP_TXT_CREATE_OR_UPDATE_FORM = "apptxts/createOrUpdateAppTxtForm.html";

    @GetMapping({"/list","/lists"})
    public ResponseEntity<List<AppTxt>> AppTxtList(){
        List<AppTxt> list = appTxtService.lfindAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Object> processCreationForm(@RequestBody AppTxt request, @Valid AppTxt apptxt, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.OK);
        } else {
            AppTxt savedAppTxt =  appTxtService.save(request);
            return new ResponseEntity<>(savedAppTxt,HttpStatus.CREATED);
        }
    }

    @GetMapping("/{apptxtId}/edit")
    public ResponseEntity<Object> initUpdateAppTxtForm(@Valid AppTxt apptxt, BindingResult result, @PathVariable Long apptxtId) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } else {
            AppTxt editedAppTxt =  appTxtService.findById(apptxtId );
            return new ResponseEntity<>(editedAppTxt, HttpStatus.OK);
        }
    }

    @GetMapping
    @RequestMapping("/{apptxtId}/delete")
    public void deleteById(@PathVariable String apptxtId){
        appTxtService.deleteById(Long.valueOf(apptxtId));
    }
}
