package com.haeyo.web.board.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haeyo.biz.user.UserVO;
import com.haeyo.biz.board.impl.TogetherPagingVO;
import com.haeyo.biz.board.impl.TogetherBoardServiceImpl;
import com.haeyo.biz.board.impl.TogetherBoardVO;
import com.haeyo.biz.board.impl.TogetherDestinationVO;
import com.haeyo.biz.board.impl.TogetherMemberVO;
import com.haeyo.biz.board.impl.TogetherReplyVO;

@Controller
public class TogetherBoardController {
	private static final Logger logger = LoggerFactory.getLogger(TogetherBoardController.class);
	
	@Autowired
	public TogetherBoardServiceImpl togetherBoardServiceImpl;
	
	@Autowired
	HttpSession session;
	
	@PostMapping("/t_insertBoard.do")
	public String insertBoard(@ModelAttribute TogetherBoardVO togetherBoardVO, @ModelAttribute TogetherDestinationVO togetherDestinationVO) throws Exception {
		logger.info("togetherBoardVO:"+togetherBoardVO+"togetherDestinationVO: "+togetherDestinationVO);
		togetherBoardVO = togetherBoardServiceImpl.uploadBoard(togetherBoardVO);
		logger.info("togetherBoardVO:"+togetherBoardVO);
		togetherBoardServiceImpl.insertBoard(togetherBoardVO,togetherDestinationVO);
		return "redirect:t_openBoardList.do";
	}
	
	@RequestMapping("/t_getUpdateBoard.do")
	public String getUpdateBoard(Model model, @RequestParam int tNo) {
		logger.info("tNo:"+tNo);
		model.addAttribute("board",togetherBoardServiceImpl.getUpdateBoard(tNo));
		return "board.updateBoard";
	}
	
	@PostMapping("/t_updateBoard.do")
	public String updateBoard(@ModelAttribute TogetherBoardVO togetherBoardVO, @ModelAttribute TogetherDestinationVO togetherDestinationVO) throws Exception {
		logger.info("??? ????????????:"+togetherBoardVO+"togetherDestinationVO: "+togetherDestinationVO);
		
		UserVO userVO = (UserVO) session.getAttribute("user");
		togetherBoardVO = togetherBoardServiceImpl.uploadBoard(togetherBoardVO);
		logger.info("????????? ??? ????????????:"+togetherBoardVO);
		togetherBoardServiceImpl.updateBoard(togetherBoardVO,togetherDestinationVO);
		return "redirect:t_openBoardList.do";
	}

	@RequestMapping("/t_deleteBoard.do")
	public String deleteBoard(@RequestParam("tNo") int tNo) {
		logger.info("");
		togetherBoardServiceImpl.deleteBoard(tNo);
		return "redirect:t_openBoardList.do";
	}

	@RequestMapping(value="/t_getBoard.do", method=RequestMethod.GET)
	public String getBoard(@RequestParam("tNo") int tNo, Model model) {
		logger.info("tNo"+tNo);
		UserVO userVO = (UserVO) session.getAttribute("user");
		int uNo = userVO.getuNo();
		
		//????????? ??????
		model.addAttribute("board", togetherBoardServiceImpl.getBoard(tNo, uNo));
		//?????? ??????
		model.addAttribute("ReplyList", togetherBoardServiceImpl.getReply(tNo));
		//?????? ???????????? ????????? ??????
		model.addAttribute("userVO", togetherBoardServiceImpl.getUserInfo(userVO));
		
		return "board.board";
	}
	

	//main=>?????? ?????? ?????????
	@RequestMapping("/t_getBoardMainTime.do")
	@ResponseBody
	public List<TogetherBoardVO> getBoardMainTime(Model model) {
		logger.info("");
		return togetherBoardServiceImpl.getBoardMainTime();
		
	}
	
	//main=>?????? ?????????
	@RequestMapping("/t_getBoardMain.do")
	public String getBoardMain(Model model) {
		logger.info("");
		UserVO userVO = (UserVO) session.getAttribute("user");
		model.addAttribute("boardList",togetherBoardServiceImpl.getBoardMain(userVO));
		return "board.main"; //jsp??? ??????
	}
	
	//??????????????? ????????? ?????????
	@RequestMapping("/t_getBoardList.do")
	@ResponseBody
	public Map<String,Object> getBoardList(Model model, HttpSession session, @RequestParam String tHeader,
			@RequestParam int nowPage, @ModelAttribute UserVO userVO) {
		logger.info("tHeader: " + tHeader+", nowPage: "+nowPage+", userVO: "+userVO);
//		UserVO userVO = (UserVO) session.getAttribute("user");
		
		//?????? ????????????
		int total = togetherBoardServiceImpl.countTotalBoard(tHeader);
		if(nowPage == 0) {
			nowPage = 1;
		}
		
		//?????? ??????????????? ?????? ???????????? ????????? ??????
		TogetherPagingVO pagingVO = new TogetherPagingVO(nowPage, total);
		
		//?????? ???????????? ???????????? ??????????????? ?????????
//		userVO = togetherBoardServiceImpl.getUserLocation(userVO);
		List<TogetherBoardVO> boardList = togetherBoardServiceImpl.getBoardList(userVO, tHeader, pagingVO);
		logger.info("boardList: "+boardList);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("paging", pagingVO);
		result.put("boardList", boardList);
		return result; //ajax???????????? ??????
	}
	
	@RequestMapping("/t_openBoardList.do")
	public String openBoardList(Model model, String tHeader) {
		logger.info("tHeader: " + tHeader);
		UserVO userVO = (UserVO) session.getAttribute("user");
		model.addAttribute("userVO", togetherBoardServiceImpl.getUaddress(userVO));
		model.addAttribute("tHeader", tHeader);
		return "board.boardList";
	}
	
	@RequestMapping("/t_getWritingBoard.do")
	public String getWritingBoard(Model model) {
		return "board.insertBoard";
	}
	
	//????????? ?????? ??????
	@RequestMapping("/t_insertReply.do")
	@ResponseBody 
	public TogetherReplyVO insertReply(@ModelAttribute TogetherReplyVO togetherReplyVO) {
		logger.info("togetherReplyVO:"+togetherReplyVO);
		return togetherBoardServiceImpl.insertReply(togetherReplyVO);
	}
	
	@RequestMapping("/t_updateReply.do")
	@ResponseBody
	public TogetherReplyVO updateReply(@ModelAttribute TogetherReplyVO togetherReplyVO) {
		logger.info("togetherReplyVO:"+togetherReplyVO);
		return togetherBoardServiceImpl.updateReply(togetherReplyVO);
	}
	
	@RequestMapping("/t_deleteReply.do")
	@ResponseBody
	public int deleteReply(@RequestParam int trNo) {
		logger.info("trNo:"+trNo);
		int result = togetherBoardServiceImpl.deleteReply(trNo);
		System.out.println(result);
		return result;
	}
	
	//?????? ??????,??????
	@RequestMapping("/t_checkJoin.do")
	@ResponseBody
	public TogetherBoardVO checkJoin(@ModelAttribute TogetherMemberVO togetherMemberVO, @RequestParam String joinOrCancle,HttpSession session) {
		logger.info("togetherMemberVO"+togetherMemberVO+"joinOrCancle"+joinOrCancle);
		UserVO user = (UserVO) session.getAttribute("user");
		int uNo = user.getuNo();
		togetherMemberVO.setgNo(uNo);
//		togetherMemberVO.setgNo(10001);
		return togetherBoardServiceImpl.checkJoin(togetherMemberVO, joinOrCancle);
	}

	//????????? ??????,??????
	@RequestMapping("/t_checkBookmark.do")
	@ResponseBody
	public int checkBookmark(@RequestParam int tNo, @RequestParam int bookmark, HttpSession session) {
		UserVO user = (UserVO) session.getAttribute("user");
		int uNo = user.getuNo();
		logger.info("tNo: "+tNo+",tNo: "+ bookmark+",uNO: "+ uNo);
		return togetherBoardServiceImpl.checkBookmark(tNo, bookmark, uNo);
	}
	
	//?????????
	@RequestMapping("/t_searchBoardList.do")
	@ResponseBody
	public Map<String,Object> searchBoardList(@RequestParam String searchInput, @RequestParam int nowPage){
		logger.info("searchInput: "+searchInput+", nowPage: "+nowPage);

		int total = togetherBoardServiceImpl.countTotalSearch(searchInput);
		logger.info("total: "+total);
		if(nowPage == 0) {
			nowPage = 1;
		}
		
		TogetherPagingVO pagingVO = new TogetherPagingVO(nowPage, total);
		int startNo = pagingVO.getStartNo();
		List<TogetherBoardVO> boardList = togetherBoardServiceImpl.searchBoardList(searchInput, startNo);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("paging", pagingVO);
		result.put("boardList", boardList);
		
		return result;
	}
	
	//????????? ????????????
	@RequestMapping("/t_previewBoardList.do")
	@ResponseBody
	public List<TogetherBoardVO> previewBoardList(@RequestParam String searchInput){
		logger.info("searchInput: "+searchInput);
		return togetherBoardServiceImpl.previewBoardList(searchInput);
	}
	
	//????????? ??????
	@RequestMapping("/t_sortBoardList.do")
	@ResponseBody
	public Map<String,Object> sortBoardList(HttpSession session, @RequestParam String sortInput , @RequestParam String tHeader
			, @RequestParam int nowPage){
		
		UserVO user = (UserVO) session.getAttribute("user");
		int uNo = user.getuNo();
		
		logger.info("sortInput: "+sortInput+", tHeader: "+ tHeader+",nowPage: "+nowPage);
		
		int total = togetherBoardServiceImpl.countTotalBoard(tHeader);
		if(nowPage == 0) {
			nowPage = 1;
		}
		
		TogetherPagingVO pagingVO = new TogetherPagingVO(nowPage, total);
		int startNo = pagingVO.getStartNo();
		List<TogetherBoardVO> boardList = togetherBoardServiceImpl.sortBoardList(sortInput, tHeader, startNo, uNo);
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("paging", pagingVO);
		result.put("boardList", boardList);
		
		return result;
	}
	
}
