package com.bit.board.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bit.board.model.ReboardDto;
import com.bit.board.service.AlbumService;
import com.bit.common.service.CommonService;
import com.bit.member.model.MemberDto;
import com.bit.util.PageNavigation;

@Controller
@RequestMapping("/album")
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private CommonService commonService;
	
	
/*	
	@RequestMapping("list.bit")
	  public ModelAndView list(@RequestParam Map<String, String> param) {
	    ModelAndView mav = new ModelAndView();
	    List<AlbumDto> list = albumService.listArticle(param);
	    
	    PageNavigation navigation = commonService.makePageNavigation(param);
	    navigation.setRoot("/board");
	    navigation.makeNavigator();
	    
	    mav.addObject("articlelist", list);
	    mav.addObject("navigator", navigation);
	    mav.setViewName("reboard/list");
	    return mav;
	  }
*/	
	@RequestMapping(value="write.bit", method=RequestMethod.GET)
	  public String write(@RequestParam Map<String, String> param) {
	    return "reboard/write";
	  }
/*	  
	  @RequestMapping(value="write.bit", method=RequestMethod.POST)
	  public String write(ReboardDto albumDto, @RequestParam("picture") MultipartFile multipartFile, HttpSession httpSession, @RequestParam Map<String, String> param, Model model) {
	    MemberDto memberDto =(MemberDto) httpSession.getAttribute("userInfo");
	    if(memberDto != null) {
	      albumDto.setId(memberDto.getId());
	      albumDto.setName(memberDto.getName());
	      albumDto.setEmail(memberDto.getEmail());
	      
	      if(multipartFile != null && multipartFile.isEmpty()) {
	    	  String opicture = multipartFile.getOrginalFilename();
	    	  
	    	  String realPath = servletContext.getRealPath("/img/upload/board");
	    	  DateFormat df = new SimpleDateFormat("yyMMdd");
	    	  String saveFolder = df.format(new Date());//181224
	    	  String fullSaveFolder = realPath + File.separator + saveFolder; 
	    	  File dir = new File(fullSaveFolder);
	    	  if(!dir.exists())
	    		  dir.mkdirs();
	    	  
	    	  String savePicture = UUID.randomUUID().toString() + opicture.substring(opicture.lastIndexOf('.'));
	    	  
	    	  File file = new File(fullSaveFolder, savePicture);
	    	  
	    	  multipartFile.transferTo(file);
	    	  
	    	  albumDto.setOriginPicture(opicture);
	    	  albumDto.setSavePicture(savePicture);
	    	  
	      
	      int seq = reboardService.writeArticle(reboardDto);
	      
	    return "reboard/writeOk";
	  }
	
	
	private void 
	}
*/

}
