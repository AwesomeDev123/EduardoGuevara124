package spring.sfgapp.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.sfgapp.entity.RegApp;
import spring.sfgapp.services.RegAppService;
import javax.validation.Valid;
import java.util.Set;

@Controller
@CrossOrigin
@RequestMapping({"regapps","regapp"})
public class RegAppController {
    //private static final String VIEWS_REG_APPS_CREATE_OR_UPDATE_FORM = "regapps/createOrUpdateRegAppForm.html";
    private final RegAppService regAppService;
    public RegAppController(RegAppService regAppService) {
        this.regAppService = regAppService;
    }
    @GetMapping({"/list","/lists"})
    public ResponseEntity<Set<RegApp>> RegAppList(){
        Set<RegApp> regAppList = regAppService.findAll();
        return new ResponseEntity<>(regAppList, HttpStatus.OK);
    }
    @GetMapping("/{regappId}/edit")
    public ResponseEntity<Object> initUpdateRegAppForm(@Valid RegApp regApp, BindingResult result, @PathVariable Long regappId) {
        RegApp editedRegApp =  regAppService.findById(regappId);
        return new ResponseEntity<>(editedRegApp, HttpStatus.OK);
    }
    @RequestMapping("/{regappId}/delete")
    public void deleteById(@PathVariable String regappId){
        regAppService.deleteById(Long.valueOf(regappId));
    }
    @PostMapping("/new")
    public ResponseEntity<Object> processCreationFormPosRegApp(@RequestBody RegApp request, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(request, HttpStatus.NOT_ACCEPTABLE);
        } else {
            RegApp savedRegApp =  regAppService.save(request);
            return new ResponseEntity<>(request, HttpStatus.OK);
        }
    }

 }

/*
    @PostMapping("/new")
    public String processCreationForm(@Valid RegApp regApp ,BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_REG_APPS_CREATE_OR_UPDATE_FORM;
        } else {
            RegApp savedApp =  regAppService.save(regApp);
            return "redirect:/regapps/" + savedApp.getId();
        }
    }

        @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("regapp", RegApp.builder().build());
        return null;
    }
         @GetMapping("/{regAppId}")
    public ModelAndView passParametersWithModelAndView(@PathVariable Long regAppId) {
        ModelAndView modelAndView = new ModelAndView("regapps/regAppDetails.html");
        modelAndView.addObject(regAppService.findById(regAppId));
        return modelAndView;
    }

    /*    @RequestMapping("/find")
    public String findRegApps(Model model){
        model.addAttribute("regapp", RegApp.builder().build());
        return "regapps/findRegApps.html";
    }*/

