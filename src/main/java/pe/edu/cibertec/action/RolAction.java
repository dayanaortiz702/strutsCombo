package pe.edu.cibertec.action;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.RolBean;
import pe.edu.cibertec.dao.RolDAO;


public class RolAction extends ActionSupport{
private List<RolBean> lstRol;
	
	public String execute() {
		return SUCCESS;
	}
	
	public String cargaComboRol(){
		RolDAO service = new RolDAO();
		
		try {
			lstRol = service.listarRol();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "ROL";
	}

	public List<RolBean> getLstRol() {
		return lstRol;
	}

	public void setLstRol(List<RolBean> lstRol) {
		this.lstRol = lstRol;
	}
	
}
