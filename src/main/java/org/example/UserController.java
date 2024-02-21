package org.example;

import org.example.dao.UserDAO;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

//@RequestMapping("/people")
public class UserController {

    @GetMapping("/hello-world")
    public String sayHello() {
        return "hello_world";
    }

//        private final UserDAO userDAO;

//        @Autowired
//        public UserController(UserDAO userDAO) {
//            this.userDAO = userDAO;
//        }

//        @GetMapping()
//        public String index(Model model) {
//            model.addAttribute("people", userDAO.allUsers());
//            return "user/index";
//        }

//        @GetMapping("/{user_id}")
//        public String show(@PathVariable("user_id") Long id, Model model) {
//            model.addAttribute("person", userDAO.getBalance(id));
//            return "people/show";
//        }

//        @GetMapping("/new")
//        public String newPerson(@ModelAttribute("user") User user) {
//            return "people/new";
//        }

//       @GetMapping("/{id}/edit")
//        public String edit(Model model, @PathVariable("id") int id) {
//            model.addAttribute("person", userDAO.takeMoney(id));
//            return "people/edit";
//        }

}
