package ra.ss16.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.ss16.model.User;
import ra.ss16.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user,
                           BindingResult result,
                           Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        // Mặc định role là USER, trạng thái hoạt động
        user.setRole("USER");
        user.setStatus(true);
        userService.save(user);  // lưu vào DB

        return "redirect:/auth/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {
        User user = userService.findByUsernameAndPassword(username, password);

        if (user == null || !user.isStatus()) {
            model.addAttribute("error", "Sai thông tin đăng nhập hoặc tài khoản bị khóa");
            return "login";
        }

        session.setAttribute("user", user);
        if ("ADMIN".equals(user.getRole())) {
            return "redirect:/admin/dashboard";
        } else {
            return "redirect:/home";
        }
    }
}
