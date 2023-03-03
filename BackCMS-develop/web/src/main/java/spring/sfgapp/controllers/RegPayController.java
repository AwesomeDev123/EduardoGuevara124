package spring.sfgapp.controllers;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.sfgapp.entity.RegPay;
import spring.sfgapp.services.RegPayService;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Controller
@CrossOrigin
@RequestMapping({"regpay","regpays"})
public class    RegPayController {
    private final RegPayService regPayService;
    public RegPayController(RegPayService regPayService) {
        this.regPayService = regPayService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/list")
    public ResponseEntity RegPayList(){
        Set<RegPay> list = regPayService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("regpay", RegPay.builder().build());
        return null;
    }

    @PostMapping("/new")
    public ResponseEntity<Object> processCreationForm(@RequestBody RegPay request,@Valid RegPay regpay, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.OK);
        } else {
            RegPay savedRegPay =  regPayService.save(request);
            return new ResponseEntity<>(savedRegPay,HttpStatus.CREATED);
        }
    }


    @GetMapping("/{regpayId}")
    public ModelAndView passParametersWithModelAndView(@PathVariable Long regpayId) {
        ModelAndView modelAndView = new ModelAndView("regpays/regPayDetails.html");
        modelAndView.addObject(regPayService.findById(regpayId));
        return modelAndView;
    }

    @PostMapping("/{regpayId}/edit")
    public String processUpdateUserForm(@Valid RegPay regpay, BindingResult result, @PathVariable Long regpayId) {
        if (result.hasErrors()) {
            return null;
        } else {
            regpay.setId(regpayId);
            RegPay savedRegPay = regPayService.save(regpay);
            return "redirect:/regpays/" + savedRegPay.getId();
        }
    }

    @GetMapping("/{regpayId}/edit")
    public ResponseEntity initUpdateRegPayForm(@Valid RegPay regPay, BindingResult result, @PathVariable Long regpayId) {
        RegPay editedRegPay =  regPayService.findById(regpayId);
        return new ResponseEntity<>(editedRegPay, HttpStatus.OK);
    }


    @RequestMapping("/find")
    public String findRegPays(Model model){
        model.addAttribute("regpay", RegPay.builder().build());
        return "regpays/findRegPays.html";
    }

    @RequestMapping("/{regpayId}/delete")
    public String deleteById(@PathVariable String regpayId){
        regPayService.deleteById(Long.valueOf(regpayId));
        return "redirect:/";
    }

}
/*    @GetMapping
    public ResponseEntity processFindForm(RegPay regpay, BindingResult result, Model model){
        // allow parameterless GET request for /regpays to return all records
        if (regpay.getRegPayDoc() == null) {
            regpay.setRegPayDoc(""); // empty string signifies the broadest possible search
        }
        // find regpays by last name
        Set<RegPay> results = regPayService.findAll();

        if (results.isEmpty()) {
            // no regpays found
            result.rejectValue("regPayDoc", "notFound", "not found");
            return new ResponseEntity<>(results, HttpStatus.NOT_FOUND);
        } else if (results.size() == 1) {
            // 1 regpay found
//            regpay = results.get(0);
//            return "redirect:/regpays/" + regpay.getId();
            return new ResponseEntity<>(results, HttpStatus.OK);
        } else {
            // multiple regpays found
            model.addAttribute("selections", results);
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
    }*/

