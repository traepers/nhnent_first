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
import com.util.FormUtil;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	//	/*
	@RequestMapping(value = "/writeBoard", method = RequestMethod.GET)
	public ModelAndView writeBoard(
			@RequestParam("email") String email,
			@RequestParam("content") String content,
			@RequestParam("pass") String pass ) {

		// 이메일 형태가 맞는지 확인.
		if( ! FormUtil.isEmailForm(email) )
			return new ModelAndView("writeBoard", "message", "올바른 email이 아니다.");  
			
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });

		BoardDAO bDao = (BoardDAO) ac.getBean("BoardDao");
		BoardVO bVO = new BoardVO();
		bVO.setEmail(email);
		bVO.setContent(content);
		bVO.setPass(pass);
		//	bVO.setTime("this_value_will_set_in_add_method");
		bDao.add(bVO);

		return new ModelAndView("writeBoard", "message", "올바르게 작성돼었습니다.");       
	}  

	@RequestMapping(value = "/updateContent", method = RequestMethod.POST)
	//	@ResponseBody
	public ModelAndView updateContent(
			@RequestParam("id") int id,
			@RequestParam("content") String content,
			@RequestParam("update_pass") String update_pass
			) {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });

		BoardDAO bDao = (BoardDAO) ac.getBean("BoardDao");
		BoardVO bVO = new BoardVO();
		bVO.setId(id);
		bVO.setContent(content);
		bVO.setPass(update_pass);
		boolean isPassCorrect = bDao.update(bVO);
		
		String message;
		if(isPassCorrect)
			message="수정 완료";
		else
			message="비밀번호 불일치";
		return new ModelAndView("updateContent", "message", message);       
	}  

}
