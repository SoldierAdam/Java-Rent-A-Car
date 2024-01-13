package com.tobeto.pair9.controllers;

import com.tobeto.pair9.services.abstracts.UserService;
import com.tobeto.pair9.services.dtos.user.requests.AddUserRequest;
import com.tobeto.pair9.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.pair9.services.dtos.user.responses.GetListUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersController {
    private UserService userService;

    @GetMapping("/getAll")
    public List<GetListUserResponse> getAll(){
        return userService.getAll();
    }
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddUserRequest request){
        userService.add(request);
    }
    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateUserRequest request){
        this.userService.update(request);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }
}
