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
import spring.sfgapp.entity.User;
import spring.sfgapp.services.UserService;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin
@RequestMapping({"/users","/user"})
public class    UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    private static final String VIEWS_USER_CREATE_OR_UPDATE_FORM = "users/createOrUpdateUserForm.html";
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping({"/list","/lists"})
    public ResponseEntity<List<User>> UserList(){
        List<User> list = userService.lFindAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("user", User.builder().build());
        return VIEWS_USER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public ResponseEntity<Object> processCreationForm(@RequestBody User request,@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.OK);
        } else {
                User savedUser =  userService.save(request);
                return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
                }
    }

    @GetMapping("/{userId}/edit")
    public ResponseEntity initUpdateUserForm(@Valid User user, BindingResult result, @PathVariable Long userId) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } else {
            User editedUser =  userService.findById(userId );
            return new ResponseEntity<>(editedUser, HttpStatus.OK);
        }
    }

    @PostMapping("/{userId}/edit")
    public String processUpdateUserForm(@Valid User user, BindingResult result, @PathVariable Long userId) {
        if (result.hasErrors()) {
            return VIEWS_USER_CREATE_OR_UPDATE_FORM;
        } else {
            user.setId(userId);
            User savedUser = userService.save(user);
            return "redirect:/users/" + savedUser.getId() +"/show";
        }
    }

    @GetMapping
    @RequestMapping("/{userId}/delete")
    public void deleteById(@PathVariable String userId){
        userService.deleteById(Long.valueOf(userId));
    }
}

//https://www.baeldung.com/spring-data-java-8
    /*    @GetMapping("/{userId}/edit")
    public ResponseEntity initUpdateUserForm(@PathVariable Long userId, Model model, BindingResult result) {
        //model.addAttribute(userService.findById(userId ));
        User editedUser =  userService.findById(userId );
        return new ResponseEntity<>(editedUser, HttpStatus.OK);
    }*/
//https://wahz.blogspot.com/2017/03/using-spring-validation-in-angular.html
/*    public ResponseEntity<List<User>> UserList(BindingResult result){
        if (result.hasErrors()) {
            List<User> list = new ArrayList<>();
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
        } else {
            List<User> list = userService.lFindAll();
            return new ResponseEntity<>(list, HttpStatus.FOUND);
        }
    }
        @GetMapping
    public String processFindForm(User user, BindingResult result, Model model){
        // allow parameterless GET request for /users to return all records
        if (user.getLastName() == null) {
            user.setLastName(""); // empty string signifies the broadest possible search
        }
        // find users by last name
        List<User> results = userService.findAllByLastNameLike("%"+ user.getLastName() + "%");

        if (results.isEmpty()) {
            // no users found
            result.rejectValue("lastName", "notFound", "not found");
            return "users/findUsers.html";
        } else if (results.size() == 1) {
            // 1 user found
            user = results.get(0);
            return "redirect:/users/" + user.getId();
        } else {
            // multiple users found
            model.addAttribute("selections", results);
            return "users/usersList.html";
        }
    }
        @GetMapping("/{userId}/show")
    public ModelAndView passParametersWithModelAndView(@PathVariable Long userId) {
        ModelAndView modelAndView = new ModelAndView("users/userDetails.html");
        modelAndView.addObject(userService.findById(userId));
        return modelAndView;
    }

        @GetMapping
    public String processFindForm(User user, BindingResult result, Model model){
        // allow parameterless GET request for /users to return all records
        if (user.getLastName() == null) {
            user.setLastName(""); // empty string signifies the broadest possible search
        }
        // find users by last name
        List<User> results = userService.findAllByLastNameLike("%"+ user.getLastName() + "%");

        if (results.isEmpty()) {
            // no users found
            result.rejectValue("lastName", "notFound", "not found");
            return "users/findUsers.html";
        } else if (results.size() == 1) {
            // 1 user found
            user = results.get(0);
            return "redirect:/users/" + user.getId();
        } else {
            // multiple users found
            model.addAttribute("selections", results);
            return "users/usersList.html";
        }
    }
    */
