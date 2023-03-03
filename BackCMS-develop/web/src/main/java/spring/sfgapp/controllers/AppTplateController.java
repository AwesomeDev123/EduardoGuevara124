package spring.sfgapp.controllers;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import spring.sfgapp.entity.AppTplate;
import spring.sfgapp.services.AppTplateService;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin
@RequestMapping({"/apptplates","/apptplate"})
public class    AppTplateController {
    private final AppTplateService apptplateService;
    public AppTplateController(AppTplateService apptplateService) {
        this.apptplateService = apptplateService;
    }
    //private static final String VIEWS_USER_CREATE_OR_UPDATE_FORM = "apptplates/createOrUpdateAppTplateForm.html";
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
    @GetMapping({"/list", "/lists"})
    public ResponseEntity<List<AppTplate>> AppTplateList(){
        List<AppTplate> list = apptplateService.lfindAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("/new")
    public ResponseEntity<Object> processCreationForm(@RequestBody AppTplate request, @Valid AppTplate apptplate, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.OK);
        } else {
            AppTplate savedAppTplate = apptplateService.save(request);
            return new ResponseEntity<>(savedAppTplate, HttpStatus.CREATED);
        }
    }
    @GetMapping("/{apptplateId}/edit")
    public ResponseEntity<Object> initUpdateAppTplateForm(@Valid AppTplate apptplate, BindingResult result, @PathVariable Long apptplateId) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } else {
            AppTplate editedAppTplate = apptplateService.findById(apptplateId);
            return new ResponseEntity<>(editedAppTplate, HttpStatus.OK);
        }
    }
}

/*    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("apptplate", AppTplate.builder().build());
        return VIEWS_USER_CREATE_OR_UPDATE_FORM;
    }*/
/*
    @PostMapping("/{apptplateId}/edit")
    public String processUpdateAppTplateForm(@Valid AppTplate apptplate, BindingResult result, @PathVariable Long apptplateId) {
        if (result.hasErrors()) {
            return VIEWS_USER_CREATE_OR_UPDATE_FORM;
        } else {
            apptplate.setId(apptplateId);
            AppTplate savedAppTplate = apptplateService.save(apptplate);
            return "redirect:/apptplates/" + savedAppTplate.getId() + "/show";
        }
    }
*/