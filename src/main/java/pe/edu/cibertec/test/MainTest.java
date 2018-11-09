package pe.edu.cibertec.test;

import java.util.List;

import pe.edu.cibertec.bean.RolBean;
import pe.edu.cibertec.dao.RolDAO;

public class MainTest {
	public static void main(String[] args) {
		listarRoles();
	}
	
	private static void listarRoles(){
		RolDAO dao = new RolDAO();
		List<RolBean> lst = dao.listarRol();	
		System.out.println("----------------------------------------------");
		for(RolBean objRol : lst){
			System.out.println("ID: "+objRol.getIdRol()+" Descripcion: "+objRol.getDescripcion());
		}
	}
	
}
