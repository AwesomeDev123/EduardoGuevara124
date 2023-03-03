package spring.sfgapp.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.sfgapp.entity.RegUser;
import spring.sfgapp.services.RegUserService;
import spring.sfgapp.services.UserService;

import java.util.*;

@Controller
@CrossOrigin
@RequestMapping({"/regusers","/reguser"})
public class RegUserController {
    private static final String VIEWS_REG_USER_CREATE_OR_UPDATE_FORM = "regusers/createOrUpdateRegUserForm.html";
    private final RegUserService regUserService;
    private final UserService userService;

    public RegUserController(RegUserService regUserService, UserService userService) {
        this.regUserService = regUserService;
        this.userService = userService;
    }

    @GetMapping({"/list","/lists"})
    public ResponseEntity<Set<RegUser>> RegUserList(){
        Set<RegUser> regUserList = regUserService.findAll();
        return new ResponseEntity<>(regUserList, HttpStatus.OK);
    }
    @GetMapping({"/{userId}/list","/{userId}/lists"})
    public ResponseEntity<List<RegUser>> RegUserList(@PathVariable String userId){
        List<RegUser> regUserList = regUserService.findByIdUser(userId);
        return new ResponseEntity<>(regUserList, HttpStatus.OK);
    }
    @GetMapping("/new")
    public ResponseEntity processCreationFormGet(@RequestBody RegUser request, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(request, HttpStatus.NOT_ACCEPTABLE);
        } else {
            RegUser savedRegUser =  regUserService.save(request);
            return new ResponseEntity<>(request, HttpStatus.OK);
        }
    }
    @GetMapping("/{idRegUser}/edit")
    public ResponseEntity initUpdateRegUserForm(@PathVariable Long idRegUser, Model model) {
        RegUser editedRegUser =  regUserService.findById(idRegUser );
        return new ResponseEntity<>(editedRegUser, HttpStatus.OK);
    }
    @GetMapping("/{idUser}/usedit")
    public ResponseEntity initUpdateUserForm(@PathVariable String idUser, Model model) {
        List<RegUser> editedRegUser =  regUserService.findByIdUser(idUser);
        return new ResponseEntity<>(editedRegUser, HttpStatus.OK);
    }
    @GetMapping
    @RequestMapping("/{regUserId}/delete")
    public void deleteById(@PathVariable String regUserId){
        regUserService.deleteById(Long.valueOf(regUserId));
    }
    @PostMapping("/new")
    public ResponseEntity processCreationFormPosRegUserUser(@RequestBody RegUser request, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(request, HttpStatus.NOT_ACCEPTABLE);
        } else {
            RegUser savedRegUser =  regUserService.save(request);
            return new ResponseEntity<>(request, HttpStatus.OK);
        }
    }
}
/*
            User queriedUser = new User();
            List<User> userListSet = new ArrayList<>();
            userListSet = userService.lfindById(request.getIdUser());
            List<User> userListSet = new ArrayList<>();
            userListSet = userService.lFindById(request.getIdUser());
            queryUser.setRegUserHashSet(Collections.singleton(request));
            queryUser.setRegUserHashSet((Set<RegUser>) request);
            queryUser.setRegUserList((List<RegUser>) request);
            queryUser.setRegUserList(new User(request));
            User savedUser = userService.save(userListSet);
            List<User> savedUser = (List<User>) userService.save(queriedUser);

            /*    @PostMapping("/new")
    public ResponseEntity processCreationFormPos(@RequestBody RegUser request, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(request, HttpStatus.NOT_ACCEPTABLE);
        } else {
            RegUser savedRegUser =  regUserService.save(request);
            return new ResponseEntity<>(request, HttpStatus.OK);
        }
    }*/