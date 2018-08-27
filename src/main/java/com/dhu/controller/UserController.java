package com.dhu.controller;
import com.dhu.annotation.AuthValidate;
import com.dhu.domain.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login.do")
    public String login(HttpServletRequest request){
        User user=new User();
        user.setUser_name("cherish");
        user.setAuth_id(1);
        request.getSession().setAttribute("user",user);
        return user.getUser_name();
    }

    @AuthValidate(value = 2)
    @RequestMapping("/user.do")
    public String user(HttpServletRequest request){
        User user=new User();
        user.setUser_name("cherish");
        request.setAttribute("user",user);
        return "user";
    }

    @RequestMapping("/space.do")
    public String space(){
        return "space";
    }

    @RequestMapping("/users.do")
    public String users(@RequestBody User user){
      return user.toString();
    }

    @RequestMapping("/strings.do")
    public String strings(@RequestBody String strings){
        return strings;
    }
}
