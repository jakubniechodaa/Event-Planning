package pl.coderslab.evv.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.evv.repositories.UserRepository;


@Controller
@RequestMapping("/user")
public class UserController {

//    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Autowired
//    public UserController(TweetRepository tweetRepository, UserRepository userRepository) {
//        this.tweetRepository = tweetRepository;
//        this.userRepository = userRepository;
//    }
//    @GetMapping("/add")
//    public String addUserForm(Model model) {
//
//        model.addAttribute("user", new User());
//
//        return "user/form";
//    }
//
//    @PostMapping("/add")
//    public String addUserPost(@Valid User user, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "user/form";
//        }
//
//        userRepository.save(user);
//        return "redirect:/user/users";
//    }
//
//    @GetMapping("/all")
//    public String all(Model model) {
//
//        model.addAttribute("users", userRepository.findAll());
//
//        return "/user/list";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String editUser(Model model, @PathVariable long id) {
//        User user = userRepository.findOne(id);
//        model.addAttribute("user", user);
//
//        return "user/edit";
//    }
//    @GetMapping("/delete/{id}")
//    public String deleteUser(Model model, @PathVariable long id) {
//        userRepository.delete(id);
//        model.addAttribute("us", id);
//        return "user/deleted";
//    }
//
//
//    @GetMapping("/users")
//    public String users(Model model) {
//        model.addAttribute("user", userRepository.findAll());
//
//        return "users";
//    }


}
