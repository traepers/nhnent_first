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
public class WriteBoardController {
	private static final Logger logger = LoggerFactory.getLogger(WriteBoardController.class);

	//	/*
	@RequestMapping(value = "/writeBoard", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView writeBoard(
			@RequestParam("email") String email,
			@RequestParam("content") String content,
			@RequestParam("pass") String pass ) {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		
		BoardDAO bDao = (BoardDAO) ac.getBean("BoardDao");
		BoardVO bVO = new BoardVO();
			bVO.setEmail(email);
			bVO.setContent(content);
			bVO.setPass(pass);
		//	bVO.setTime("this_value_will_set_in_add_method");
		bDao.add(bVO);

		return new ModelAndView("writeBoard", "message", email + content + pass);       
	}  

}
