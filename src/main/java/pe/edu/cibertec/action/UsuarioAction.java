package pe.edu.cibertec.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.RolBean;
import pe.edu.cibertec.bean.UsuarioBean;
import pe.edu.cibertec.dao.RolDAO;
import pe.edu.cibertec.dao.UsuarioDAO;

public class UsuarioAction extends ActionSupport{
	
	private String nombre, usuario, clave, rol;
	private String idUsuario;
	private String msg = "";
	UsuarioDAO admin = null;
	UsuarioDAO admin1 = new UsuarioDAO();
	UsuarioDAO admin2 = new UsuarioDAO();
	UsuarioDAO admin3 = new UsuarioDAO();	
		
	int ctr = 0;
	String submitType;
	
	ResultSet rs = null;
	UsuarioBean bean = null;
	List<UsuarioBean> beanList = null;
	private boolean noData = false;

	
	public String RegistrarUsuario() throws Exception {
		admin = new UsuarioDAO();

		try {
			ctr = admin.registerUsuario(nombre, idUsuario, clave, rol);
			if (ctr > 0) {
				msg = "Registration Successfull";
			} else {
				msg = "Some error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REGISTER";
	}
	

	public String ListarUsuario() throws Exception {
		try {
			beanList = new ArrayList<UsuarioBean>();
			rs = admin1.reportUsuario();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					bean = new UsuarioBean();
					bean.setIdUsuario(rs.getInt("idUsuario"));
					bean.setNombre(rs.getString("nombre"));
					bean.setUsuario(rs.getString("usuario"));
					bean.setClave(rs.getString("clave"));
					bean.setIdRol(rs.getInt("idRol"));
					beanList.add(bean);
				}
			}
			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REPORT";
	}
	
	
	public String EliminarUsuario() throws Exception {
		try {
			int isDeleted = admin2.deletePropietario(idUsuario);
			if (isDeleted > 0) {
				msg = "Record deleted successfully";
			} else {
				msg = "Some error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "DELETE";
	}
	
	public String ActualizarUsuario() throws Exception {
		try {
			if (submitType.equals("updatedata")) {
				rs = admin3.detalleUsuario(idUsuario.trim());
				if (rs != null) {
					while (rs.next()) {
						nombre = rs.getString("nombres");
						usuario = rs.getString("usuario");
						clave = rs.getString("clave");
						rol = rs.getString("idRol");
					}
				}
			} else {
				int i = admin3.updateUsuario(nombre, usuario, clave, rol, idUsuario);
				if (i > 0) {
					msg = "Record Updated Successfuly";
				} else {
					msg = "error";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "UPDATE";
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}


	public String getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public UsuarioDAO getAdmin() {
		return admin;
	}


	public void setAdmin(UsuarioDAO admin) {
		this.admin = admin;
	}


	public UsuarioDAO getAdmin1() {
		return admin1;
	}


	public void setAdmin1(UsuarioDAO admin1) {
		this.admin1 = admin1;
	}


	public UsuarioDAO getAdmin2() {
		return admin2;
	}


	public void setAdmin2(UsuarioDAO admin2) {
		this.admin2 = admin2;
	}


	public UsuarioDAO getAdmin3() {
		return admin3;
	}


	public void setAdmin3(UsuarioDAO admin3) {
		this.admin3 = admin3;
	}


	public int getCtr() {
		return ctr;
	}


	public void setCtr(int ctr) {
		this.ctr = ctr;
	}


	public String getSubmitType() {
		return submitType;
	}


	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}


	public ResultSet getRs() {
		return rs;
	}


	public void setRs(ResultSet rs) {
		this.rs = rs;
	}


	public UsuarioBean getBean() {
		return bean;
	}


	public void setBean(UsuarioBean bean) {
		this.bean = bean;
	}


	public List<UsuarioBean> getBeanList() {
		return beanList;
	}


	public void setBeanList(List<UsuarioBean> beanList) {
		this.beanList = beanList;
	}


	public boolean isNoData() {
		return noData;
	}


	public void setNoData(boolean noData) {
		this.noData = noData;
	}

}
