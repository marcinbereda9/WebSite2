package net.mb.WebSite2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("witam", "welcome to spring mvc");
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value = {"/contact"})
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	/*@RequestMapping(value = {"/about"})
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
		@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="witam", required=false)String witam){
		if(witam == null){
			witam="dupa";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("witam", witam);
		return mv;
		
	}
	
	@RequestMapping(value="/test/{witam}")
	public ModelAndView test2(@PathVariable("witam")String witam){
		if(witam == null){
			witam="dupa";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("witam", witam);
		
		
		return mv;
		
	}*/
}
