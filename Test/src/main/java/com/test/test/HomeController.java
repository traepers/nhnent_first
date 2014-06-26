package com.test.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.BoardVO;
import com.board.dao.BoardDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
//		/*
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
//		 */
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });

		// EmpDao 객체를 생성.
		BoardDAO bDao = (BoardDAO) ac.getBean("BoardDao");
		//			//= new EmpDao();  //  
		//			Emp emp = new Emp();
		//			emp.setName("hong gil dong");
		//			emp.setTitle("사원");
		//			emp.setEmail("hong@korea.com");
		//			emp.setPhone("010-123-4567");
		//			empdao.add(emp);	
		List lboard = (List)bDao.searchAll();
		Iterator empIter= lboard.iterator();
		model.addAttribute("board_length", lboard.size() );
		
		String [] emArr = new String[lboard.size()];
		BoardVO [] boardVOArr = new BoardVO[lboard.size()];
		
		int i = 0;
		while(empIter.hasNext()){
			BoardVO b = (BoardVO)empIter.next();
			boardVOArr[i] = new BoardVO();
			boardVOArr[i] = b;
//			emArr[i] = b.getEmail();
			i++;
		}
		model.addAttribute("boardVOArr", boardVOArr );
		return "home";
	}

}
