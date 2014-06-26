package com.test.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.board.BoardVO;
import com.board.dao.BoardDAO;

@Controller
public class UpdateContentController {
	private static final Logger logger = LoggerFactory.getLogger(UpdateContentController.class);

	//	/*
	@RequestMapping(value = "/updateContent", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView updateContent(
			@RequestParam("id") int id,
			@RequestParam("content") String content ) {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		
		BoardDAO bDao = (BoardDAO) ac.getBean("BoardDao");
		bDao.update(id, content);

		logger.error("updateContent!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		return new ModelAndView("updateContent", "message", "");       
	}  


}
