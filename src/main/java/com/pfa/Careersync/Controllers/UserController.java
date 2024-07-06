package com.pfa.Careersync.Controllers;

import com.pfa.Careersync.Model.Role;
import com.pfa.Careersync.Model.User;
import com.pfa.Careersync.Requests.UserInformationRequest;
import com.pfa.Careersync.Services.UserService;
import com.pfa.Careersync.config.JwtService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;
    private final JwtService jwtService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user){
        userService.save(user);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<User> findUser(@RequestHeader("Authorization") String Authorization) throws Exception {
        String email = jwtService.extractUsername(Authorization.substring(7));
        return ResponseEntity.ok(userService.findByUsername(email));
    }

//    @GetMapping
//    public ResponseEntity<List<User>> findAllUsers ()
//    {return ResponseEntity.ok(userService.findAll());}
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String > deleteUser(@PathVariable Integer id )throws Exception{
        userService.remove(id);
        return ResponseEntity.ok("User deleted");

    }
    @PutMapping("/modifyUser/{id}")
    public ResponseEntity<User> modiferUser(
            @RequestBody User user,
            @PathVariable Integer id) throws Exception{
        return userService.update(user,id);
    }

    @CrossOrigin
    @PutMapping("/addUserInformation")
    public ResponseEntity<String> addUserInformation(
            @RequestBody UserInformationRequest userInformationRequest,
            @RequestHeader("Authorization") String Authorization) throws Exception {

        String email = jwtService.extractUsername(Authorization.substring(7));
        User user = userService.findByUsername(email);

        user.setBio(userInformationRequest.getBio());
        user.setCvFile(userInformationRequest.getCvFile());
        user.setSkills(userInformationRequest.getSkills());
        userService.save(user);

        return ResponseEntity.ok("User information was saved.");
    }
}
