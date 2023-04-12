package egovframework.example.sample.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.sample.service.DeptService;
import egovframework.example.sample.service.DeptVO;

@Controller
public class DeptController {
	
	@Resource(name="deptService")
	private DeptService deptService;
	
	
	@RequestMapping("/deptWrite.do")
	public String deptWrite() {
		
		return "dept/deptWrite";
	}
	
	//deptWriteSave.do
	@RequestMapping("/deptWriteSave.do")
	public String insertDept(DeptVO vo) throws Exception {
		
		System.out.println("부서번호 : " + vo.getDeptno());
		System.out.println("부서이름 : " + vo.getDname());
		System.out.println("부서위치 : " + vo.getLoc());
		
		String result = deptService.insertDept(vo);
		
		if(result == null) {//ok
			System.out.println("저장 완료");
		}else {
			System.out.println("저장 실패");
		}
		
		return "dept/deptList";
	}
	
	@RequestMapping("/deptList.do")
	public String selectDeptList(DeptVO vo, ModelMap model) throws Exception{
		
		List<?> list = deptService.selectDeptList(vo);
		model.addAttribute("resultList",list);
		return "dept/deptList";
	}
	
	@RequestMapping("/deptDetail.do")
	public String selectDeptDetail(String deptno, ModelMap model) throws Exception{
		
		DeptVO vo = deptService.selectDeptDetail(deptno);
		System.out.println("부서번호 : " + vo.getDeptno());
		
		model.addAttribute("deptVO", vo);
		
		return "dept/deptDetail";
	}
	
	@RequestMapping("/deptDelete.do")
	public String deleteDept(String deptno) throws Exception{
		
		int result = deptService.deleteDept(deptno);
		if(result == 1) {
			System.out.println("완료");
		}else {
			System.out.println("실패");
		}
		
		return "";
	}
	
	@RequestMapping("/deptModify.do")
	public String deptModify(String deptno, ModelMap model) throws Exception{
		
		DeptVO vo = deptService.selectDeptDetail(deptno);
		
		model.addAttribute("deptVO", vo);
		
		return "dept/deptModify";
		
	}
	
	@RequestMapping("/deptModifySave.do")
	public String deptModifySave(DeptVO vo) throws Exception{
		
		int result = deptService.updateDept(vo);
		if(result == 1) {
			System.out.println("수정완료");
		}else {
			System.out.println("수정실패");
		}
		
		return "";
	}
	
}

