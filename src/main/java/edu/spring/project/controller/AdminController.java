package edu.spring.project.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.spring.project.pageutil.PaginationCriteria;
import edu.spring.project.pageutil.PageNumberMaker;
import edu.spring.project.domain.BoardContents;
import edu.spring.project.domain.BoardFree;
import edu.spring.project.domain.Member;
import edu.spring.project.domain.Menu;
import edu.spring.project.service.AdminService;
import edu.spring.project.service.BoardContentsService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	BoardContentsService boardConService;

	private static final String UPLOAD_PATH_IMAGE = "C:\\Users\\scott\\git\\FinalProject\\src\\main\\webapp\\resources\\images";
	private static final String UPLOAD_PATH_MOVIE = "C:\\Users\\scott\\git\\FinalProject\\src\\main\\webapp\\resources\\video";
	
	// 관리자 페이지
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void admin() {

	}

	// 관리자 페이지 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String admin(String userid, String password, HttpServletRequest request) {
		Member m = adminService.login(userid, password);
		if (m == null) {
			return "redirect:/admin/login";
		}else {
			request.getSession().setAttribute("admin", m.getUserid());
			return "admin/main";
		}
		
	}

	// 관리자 페이지 메인
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void adminMain() {

	}

	// 회원 리스트
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public void memberList(Model model) {
		List<Member> memberList = adminService.memberList();
		model.addAttribute("member", memberList);

	}

	// 회원 상세 정보
	@RequestMapping(value = "/memberdetail", method = RequestMethod.GET)
	public void memberDetail(String userid, Model model) {
		Member m = adminService.memberDetail(userid);
		model.addAttribute("member", m);
	}

	// 회원 정보 수정
	@RequestMapping(value = "/memberUpdate", method = RequestMethod.POST)
	public String memberUpdate(Member m) {
		adminService.memberUpdate(m);
		return "redirect:memberList";
	}

	@RequestMapping(value = "/memberGradeUpdate", method = RequestMethod.POST)
	public String memberGradeUpdate(String userid, String grade) {
		adminService.memberGradeUpdate(userid, grade);
		return "redirect:memberList";
	}

	@RequestMapping(value = "/memberdelete", method = RequestMethod.GET)
	public String memberDelete(String userid, Model model) {
		int i = adminService.memberDelete(userid);
		model.addAttribute("result", i);
		return "redirect:/admin/memberList";
	}

	// 로그 아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}

	// 전체 메뉴 select
	@RequestMapping(value = "/menuList", method = RequestMethod.GET)
	public void menuList(Model model) {
		List<Menu> list = adminService.selectMenu();
		model.addAttribute("menu", list);
	}

	// 특정 메뉴 select
	@RequestMapping(value = "/menuUpdate", method = RequestMethod.GET)
	public void menuUpdate(String mnum, Model model) {
		Menu list = adminService.detailMenu(mnum);
		model.addAttribute("menu", list);
	}

	// 메뉴 업데이트
	@RequestMapping(value = "/menuUpdate", method = RequestMethod.POST)
	public String menuUpdate(Menu menu, Model model) {
		int i = adminService.updateMenu(menu);
		return "redirect:/admin/menuList";
	}

	@RequestMapping(value = "/menuInsert", method = RequestMethod.GET)
	public void menuInsert() {
	}

	@RequestMapping(value = "/menuInsert", method = RequestMethod.POST)
	public String menuInsert(Menu menu, Model model) {
		int i = adminService.insertMenu(menu);
		return "redirect:/admin/menuList";
	}

	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public void boardList(Integer page, Integer perPage, String category, Model model) {

		PaginationCriteria c = null;

		if (page != null && perPage != null) {
			c = new PaginationCriteria(page, perPage);
		} else {
			c = new PaginationCriteria();
		}

		List<BoardContents> list = adminService.selectBoard(c);
		model.addAttribute("board", list);

		PageNumberMaker maker = new PageNumberMaker();
		maker.setCriteria(c);
		int count = adminService.getTotalCount();
		maker.setTotalCount(count);
		maker.setPageMakerData();

		model.addAttribute("selectedCategory", category);
		model.addAttribute("pageMaker", maker);
	}

	@RequestMapping(value = "/boardList", method = RequestMethod.POST)
	public String selectByCategory(Integer page, Integer perPage, String category, Model model) {
		PaginationCriteria c = null;
		if (page != null && perPage != null) {
			c = new PaginationCriteria(page, perPage);
		} else {
			c = new PaginationCriteria();
		}
			
		List<Object> list = null;
		
		int count = 0; 
		if (category.equals("free")) {
			count = adminService.getFreeTotalCount();
			list = adminService.selectByConCategory(category,c);
			for (int i = 0; i < list.size(); i++) {
				list.set(i, (BoardFree) list.get(i));
			}
			
		} else {
			count = adminService.getConTotalCount(category);
			list = adminService.selectByConCategory(category,c);
			
			for (int i = 0; i < list.size(); i++) {
				list.set(i, (BoardContents) list.get(i));
			}
		}
		
		PageNumberMaker maker = new PageNumberMaker();
		maker.setCriteria(c);
		
		maker.setTotalCount(count);
		maker.setPageMakerData();

		model.addAttribute("pageMaker", maker);
		model.addAttribute("selectedCategory", category);
		model.addAttribute("board", list);
		
		if(category.equals("free")) {
			return "admin/boardFreeList";
		}
		
		return "admin/boardList";
	}

	// Board Insert
	@RequestMapping(value = "/boardinsert", method = RequestMethod.GET)
	public void boardinsert() {
	}

	@RequestMapping(value = "/boardinsert", method = RequestMethod.POST)
	public String boardinsert(BoardContents content, MultipartFile imageFile, MultipartFile videoFile) {
		String resultimage = saveImageFile(imageFile);
		String resultmovie = saveMovieFile(videoFile);

		String saveImagePath = "/resources/images/" + resultimage;
		String saveVideoPath = "/resources/video/" + resultmovie;
		
		content.setImagePath(saveImagePath);
		content.setVideoPath(saveVideoPath);

		int result = boardConService.insert(content);
		System.out.println("삽입결과: " + result);
		if (result == 1) {
			return "redirect:/admin/main";
		}
		return "redirect:/admin/boardinsert";
	}

	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String boardDetail(Integer bno, String category, Model model) {
		System.out.println("Controller : " + category);
		Object o = adminService.boardDetail(bno, category);
		model.addAttribute("selectCategory", category);
		
		if (category.equals("free")) {
			BoardFree b = (BoardFree) o;
			model.addAttribute("board", b);
			return "/admin/boardFreeDetail";
		} else {
			BoardContents b = (BoardContents) o;
			model.addAttribute("board", b);
			return "/admin/boardConDetail";
		}
	}

	@RequestMapping(value = "/boardConUpdate", method = RequestMethod.POST)
	public String boardConUpdate(BoardContents b, Model model, HttpServletRequest request) {
		int result = adminService.boardConUpdate(b);
		System.out.println("result : " + result);
		
		request.setAttribute("bno", b.getBno());
		request.setAttribute("category", b.getCategory());
		
		return "redirect:/admin/boardList";
	}
	
	@RequestMapping(value = "/boardFreeUpdate", method = RequestMethod.POST)
	public String boardFreeUpdate(BoardFree b, Model model, HttpServletRequest request) {
		int result = adminService.boardFreeUpdate(b);
		System.out.println("result : " + result);
		
		request.setAttribute("bno", b.getFbno());
		request.setAttribute("category", "free");
		
		return "redirect:/admin/boardList";
	}

	@RequestMapping(value = "/boardConDelete", method = RequestMethod.GET)
	public String boardConDelete(int bno) {
		
		int result = adminService.boardConDelete(bno);
		System.out.println("result : " + result);

		return "redirect:/admin/boardList";
	}
	
	@RequestMapping(value = "/boardFreeDelete", method = RequestMethod.GET)
	public String boardFreeDelete(int fbno) {
		int result = adminService.boardFreeDelete(fbno);
		System.out.println("result : " + result);
		
		return "redirect:/admin/boardList?category=free";
	}

	// 이미지 파일 저장객체 생성
	private String saveImageFile(MultipartFile file) {

		String saveName = file.getOriginalFilename();
		System.out.println("saveName: " +saveName);

		// 저장할 File 객체를 생성
		File saveFile = new File(UPLOAD_PATH_IMAGE, saveName);
		System.out.println("saveFile: "+saveFile);

		// 생성된 파일 객체를 저장
		try {
			FileCopyUtils.copy(file.getBytes(), saveFile);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return saveName;
	}

	// 영화파일 저장객체를 생성
	private String saveMovieFile(MultipartFile file) {

		String saveName = file.getOriginalFilename();

		// 저장할 File 객체를 생성
		File saveFile = new File(UPLOAD_PATH_MOVIE, saveName);

		// 생성된 파일 객체를 저장
		try {
			FileCopyUtils.copy(file.getBytes(), saveFile);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return saveName;
	}

}
