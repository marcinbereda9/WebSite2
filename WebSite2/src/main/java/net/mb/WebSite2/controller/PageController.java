package net.mb.WebSite2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.mb.backend.dao.CategoryDAO;
import net.mb.backend.dao.ProductDAO;
import net.mb.backend.dto.Category;
import net.mb.backend.dto.Product;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("title", "home");
		mv.addObject("userClickHome", true);
		logger.info("Inside PageController index method  - Info");
		logger.debug("Inside PageController index method  - debug");
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
	}

	@RequestMapping(value = "show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = "/custom")
	public ModelAndView showCustom(){
		ModelAndView view = new ModelAndView("page");
		view.addObject("title","Custom");
		view.addObject("userClickCustom", true);
		return view;
	}
	
	@RequestMapping(value = "show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		// categoryDAO

		Category category = null;
		category = categoryDAO.get(id);

		mv.addObject("title", category.getName());
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

	@RequestMapping(value = "show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		
		//update wyswetlen produktu
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		
		
		return mv;
		
	}
	
	/*
	 * @RequestMapping(value = {"/about"}) public ModelAndView about(){
	 * ModelAndView mv = new ModelAndView("page"); mv.addObject("title",
	 * "About us"); mv.addObject("userClickAbout", true); return mv; }
	 * 
	 * @RequestMapping(value="/test") public ModelAndView
	 * test(@RequestParam(value="witam", required=false)String witam){ if(witam
	 * == null){ witam="dupa"; } ModelAndView mv = new ModelAndView("page");
	 * mv.addObject("witam", witam); return mv;
	 * 
	 * }
	 * 
	 * @RequestMapping(value="/test/{witam}") public ModelAndView
	 * test2(@PathVariable("witam")String witam){ if(witam == null){
	 * witam="dupa"; } ModelAndView mv = new ModelAndView("page");
	 * mv.addObject("witam", witam);
	 * 
	 * 
	 * return mv;
	 * 
	 * }
	 */
}
