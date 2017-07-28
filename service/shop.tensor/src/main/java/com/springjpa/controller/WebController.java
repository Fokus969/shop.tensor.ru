package com.springjpa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springjpa.model.Goods;
import com.springjpa.model.Category;
import com.springjpa.repo.CategoryRepository;
import com.springjpa.repo.GoodsRepository;

@RestController
public class WebController {
	private static final Logger logger = LoggerFactory.getLogger(WebController.class);
//	Map<Integer, Goods> goodsData = new HashMap<Integer, Goods>();

	@Autowired
	GoodsRepository goodsRepository;

	@Autowired
	CategoryRepository categoryRepository;

/*	@Autowired
	CustomerRepository repository;
*/	



/*	@RequestMapping("/save_goods")
	public String save_goods(){
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");;//LocalDate.parse("03.09.2013", format)
		
				
		goodsRepository.save(new Goods("Ноутбук Dell Inspiron 5748, 5748-8830", 
				"Ноутбук Dell Inspiron 5748 оснащен новыми компонентами, включая цифровую клавиатуру, процессоры Intel и 17,3-дюймовый экран с разрешением HD+ и все это по привлекательной цене."+
				"Производитель процессора: Intel"+
				"Производитель чипсета видео: NVIDIA"+
				"Тип процессора: Intel Core i3"+
				"Предустановленная ОС: MS Windows 8.1"+
				"Цвет: Серебристый"+
				"Поверхность экрана: Глянцевая", 80, new Float(17500.00), 5, false, "03.09.2013"));
		goodsRepository.save(new Goods("DIMM DDR3, 16ГБ (2x8ГБ), Corsair Vengeance Pro blue, CMY16GX3M2A1866C9B", 
				"Модуль памяти для компьютера DIMM DDR3, 16ГБ (2x8ГБ), PC3-14900, 1866МГц, Corsair Vengeance Pro blue, CMY16GX3M2A1866C9B. Модуль памяти."+
				"Комплект: Комплект из двух модулей"+
				"Объем: 16 ГБ (2х8 ГБ)"+
				"Тип процессора: Intel Core i3"+
				"Предустановленная ОС: MS Windows 8.1"+
				"Цвет: Серебристый"+
				"Поверхность экрана: Глянцевая", 280, new Float(11300.00), 3, true, "09.12.2014"));
		return "Done";
	}*/

	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response, HttpServletRequest request) {
		logger.info("Header: "+request.getHeader("Origin"));
	    response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
	}  
 
	@RequestMapping(produces = "application/json", value = RestURI.GET_ALL_GOODS, method = RequestMethod.GET)
	public @ResponseBody List<Goods> findAllGoods() {
		logger.info("Start getAllGoods.");
		List<Goods> goods = new ArrayList<Goods>();
		for(Goods goods_one : goodsRepository.findAll()){
//			logger.info(goods_one.toString());
			goods.add(goods_one);
		}
//		logger.info(goods.toString());
		return goods;
	}

/*	@RequestMapping(produces = "application/json", value = RestURI.GET_GOODS, method = RequestMethod.GET)
	public @ResponseBody Goods getGoods(@PathVariable String goodsId) {
		logger.info("Start getAllGoods.");
		return goodsRepository.findOne(new Long(goodsId));
	}*/
	
	@RequestMapping(produces = "application/json", value = RestURI.GET_GOODS, method = RequestMethod.GET)
	public @ResponseBody Goods getGoods(@PathVariable String id) {
		logger.info("Start getAllGoods.");
		return goodsRepository.findOne(new Long(id));
	}

	@RequestMapping(produces = "application/json", value = RestURI.GET_ALL_CATEGORIES, method = RequestMethod.GET)
	public @ResponseBody List<Category> findAllCategories() {
		logger.info("Start getAllCategory.");
		List<Category> categories = new ArrayList<Category>();
		for(Category category: categoryRepository.findAll()){
//			logger.info(category.toString());
			categories.add(category);
		}
//		logger.info(goods.toString());
		return categories;
	}

	
/*	@RequestMapping("/findallgoods")
	public String findAllGoods_str(){
		String result = "<html>";
		
		for(Goods goods : goodsRepository.findAll()){
			result += "<div>" + goods.toString() + "</div>";
		}
//		result += "<div>Работает</div>";
		
		return result + "</html>";
	}
	
	/*
	 * ex: /findbyid?id=12
	 */
/*
 	@RequestMapping("/findall")
	public String findAll(){
		String result = "<html>";
		
		for(Customer cust : repository.findAll()){
			result += "<div>" + cust.toString() + "</div>";
		}
		
		return result + "</html>";
	}
 	
   @RequestMapping("/findbyid") 
	public String findById(@RequestParam("id") long id){
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}
	
	@RequestMapping("/findbylastname")
	public String fetchDataByLastName(@RequestParam("lastname") String lastName){
		String result = "<html>";
		
		for(Customer cust: repository.findByLastName(lastName)){
			result += "<div>" + cust.toString() + "</div>"; 
		}
		
		return result + "</html>";
	}
*/
}

