package com.traventure.company.test.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping("/")

    public ModelAndView helloWorld() {
        return new
                ModelAndView("welcome","message","Hello World");
    }

    @RequestMapping("/loginform")
    public ModelAndView userform(){

        return new ModelAndView("loginform","log","Login Information");
    }


    @RequestMapping("/formhandler")
    public ModelAndView formhandler (@RequestParam("FirstName") String FirstName,
                                    @RequestParam("LastName") String LastName,
                                    @RequestParam("Email") String Email,
                                    @RequestParam("Password") String Password)

    {
        ModelAndView mv = new ModelAndView("loginresponse");
        mv.addObject("FirstName", FirstName);
        mv.addObject("LastName", LastName);
        mv.addObject("Email",Email);
        mv.addObject("Password", Password);

        return mv;
    }
    @RequestMapping("/profileform")
    public ModelAndView profileform(){

        return new ModelAndView("profileform","profile","Profile Information");
    }
    @RequestMapping("/formhandler2")
    public ModelAndView formhandler2 (@RequestParam("UserName") String UserName,
                                  @RequestParam("Profession") String Profession,
                                  @RequestParam("Birthday") int Birthday,
                                  @RequestParam("Gender") String Gender,
                                  @RequestParam("City") String City,
                                  @RequestParam("State") String State,
                                  @RequestParam("DesiredDestination") String DesiredDestination,
                                  @RequestParam("Interests") String Interests,
                                  @RequestParam("Smoker") String Smoker,
                                  @RequestParam("Drinker") String Drinker)

    {
        ModelAndView mv = new ModelAndView("profileresponse");
        mv.addObject("UserName",UserName);
        mv.addObject("Profession",Profession);
        mv.addObject("Birthday",Birthday);
        mv.addObject("Gender",Gender);
        mv.addObject("City",City);
        mv.addObject("State",State);
        mv.addObject("DesiredDestiation",DesiredDestination);
        mv.addObject("Interests",Interests);
        mv.addObject("Smoker",Smoker);
        mv.addObject("Drinker",Drinker);

        return mv;
    }

}
