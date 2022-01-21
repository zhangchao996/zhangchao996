package com.zc.web;

import com.zc.pojo.Hero;
import com.zc.service.HeroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(value="用户controller",tags={"用户操作接口"})
@Controller
public class LoginController {
    @Autowired
    private HeroService heroService;

    @GetMapping("/main")
    public String login(Model model){
        List<Hero> allHero = heroService.getAllHero();
        model.addAttribute("heroAll",allHero);
        System.out.println(allHero);
        return "main";
    }


    @GetMapping("/add")
    public String add(){
        return "add";
    }

    @PostMapping("/addHero")
    public String addHero(Hero hero){
        heroService.addHero(hero);
        return "redirect:/main";
    }

    @PutMapping ("/addHero")
    public String alterHero(Hero hero){
        heroService.alterHero(hero);
        return "redirect:/main";
    }



    @RequestMapping("/alter/{id}")
    public String alter(@PathVariable("id")Integer id,Model model){
        Hero hero = heroService.selectOne(id);
        model.addAttribute("hero",hero);
        return "add";
    }

    @ApiOperation(value="删除用户信息",notes="注意问题点",httpMethod="DELETE")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value="用户id",dataType="Long", paramType = "path")})
    @DeleteMapping ("/alter/{id}")
    public String delete(@PathVariable("id")Integer id){
        heroService.deleteHero(id);
        return "redirect:/main";
    }



    @ApiOperation(value="获取用户信息",notes="注意问题点",httpMethod="GET")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value="用户id",dataType="Long", paramType = "path")})
    //@ApiIgnore()   忽略方法
    @GetMapping("/add/{id}")
    public Hero Hero(@PathVariable("id")Integer id){
        return heroService.getHero(id);
    }


    /**
     * 将传进来的日期进行处理
     * @param dataBinder
     */
    @InitBinder
    public void InitBinder(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(Date.class,new PropertyEditorSupport(){
            public void setAsText(String value){
                try {
                    setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
                } catch (ParseException e) {
                    setValue(null);
                }
            }

            public String getAsText(){
                return new SimpleDateFormat("yyyy-MM-dd").format((Date) getValue());
            }
        });
    }
}
