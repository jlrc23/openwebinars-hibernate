package com.gvm.reportes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value="/create")
    @ResponseBody
    public String create(String name, String message){
        try{
            User user = new User();
            Random r = new Random();
            int randomId = r.nextInt(Integer.MAX_VALUE);
            user.setId(randomId);
            user.setUserName(name);
            user.setUserMessage(message);
            userDao.create(user);
            return "Usuario creado correctamente";
        }catch(Exception e){
            e.printStackTrace();
            return "Error en la creacion del usuario";
        }
    }

    @RequestMapping(value="delete")
    @ResponseBody
    public String delete(int id){
        try{
            User user = new User();
            user.setId(id);
            userDao.delete(user);
        }catch (Exception ex){
            return "Error eliminando el usuario: " + ex.toString();
        }
        return "Usuario eliminado correctamente";

    }


}
