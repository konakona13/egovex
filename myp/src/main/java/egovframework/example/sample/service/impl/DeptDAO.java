package egovframework.example.sample.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractDAO;
import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.DeptVO;

@Repository("deptDAO")
public class DeptDAO extends EgovAbstractDAO{

	public String insertDept(DeptVO vo) throws Exception{
		return (String) insert("deptDAO.insertDept",vo);
	}

	public List<?> selectDeptList(DeptVO vo) {
		// TODO Auto-generated method stub
		return list("deptDAO.selectDeptList", vo);
	}

	public DeptVO selectDeptDetail(String deptno) {
		// TODO Auto-generated method stub
		return (DeptVO) select("deptDAO.selectDeptDetail", deptno);
	}

	public int deleteDept(String deptno) {
		// TODO Auto-generated method stub
		return delete("deptDAO.deleteDept", deptno);
	}

	public int updateDept(DeptVO vo) {
		// TODO Auto-generated method stub
		return update("deptDAO.updateDept",vo);
	}


}
