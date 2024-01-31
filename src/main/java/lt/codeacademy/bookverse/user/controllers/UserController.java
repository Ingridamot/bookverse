package lt.codeacademy.bookverse.user.controllers;

import jakarta.validation.Valid;
import lt.codeacademy.bookverse.user.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import static lt.codeacademy.bookverse.HttpEndpoints.USER_CREATE;

@Controller
public class UserController {

    @GetMapping(USER_CREATE)
    public String getUserForm(Model model) {
        model.addAttribute("userDto", UserDto.builder().build());
        return "user/user";
    }

    @PostMapping(USER_CREATE)
    public String register(Model model, @Valid UserDto userDto, BindingResult errors) {
        if (errors.hasErrors()) {
            return "user/user";
        }
        System.out.println("got a successful registration request");
        System.out.println(userDto);

        return "redirect" + USER_CREATE;
    }
}