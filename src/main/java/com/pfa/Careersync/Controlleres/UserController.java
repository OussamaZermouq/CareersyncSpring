package com.pfa.Careersync.Controlleres;

import com.pfa.Careersync.Model.User;
import com.pfa.Careersync.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor

public class UserController {
    private UserService userService;
    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user){
        userService.save(user);
        return ResponseEntity.accepted().build();
    }
    @GetMapping
    public ResponseEntity<List<User>> findAllUsers ()
    {return ResponseEntity.ok(userService.findAll());}
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
}
