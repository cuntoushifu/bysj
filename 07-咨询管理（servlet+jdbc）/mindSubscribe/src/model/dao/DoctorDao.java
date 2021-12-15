package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Doctor;
import utils.Util;
import utils.jdbc.JdbcUtil;

/**
 * 
 * @instruction
 * doctor表，对应的dao
 */
public class DoctorDao {

	JdbcUtil jdbcUtil = new JdbcUtil();

	

	/**
	 * 修改doctor表中is_active的值，是否为激活状态
	 * 
	 * @param doctorId 咨询师id
	 * @param action 要更新的值
	 * @return 受影响行数
	 */
	public int toggleDoctorActive(String doctorId, String action) {

		String sql = "UPDATE doctor SET is_active=?  WHERE doctor_id=?";

		return jdbcUtil.executeUpdate(sql, action, doctorId);

	}

	/**
	 * 查询符合条件的咨询师
	 * 
	 * @param search 查询条件
	 * @return 咨询师对象集合
	 */
	public List<Doctor> listSearch(Map<String, String> search) {

		ArrayList<Doctor> list = new ArrayList<>();

		List<Object> searchList = new ArrayList<Object>();

		String sql = "SELECT * FROM doctor WHERE 1=1 ";

		// 姓名
		if (Util.isNotEmpty(search.get("name"))) {

			sql += " AND name like concat('%',?,'%')";
			searchList.add(search.get("name"));
		}

		// 性别
		if (Util.isNotEmpty(search.get("sex"))) {

			sql += " AND sex=?";
			searchList.add(search.get("sex"));
		}

		// 年龄,从xx起
		if (Util.isNotEmpty(search.get("startAge"))) {
			sql += " AND age >= ? ";
			searchList.add(search.get("startAge"));
		}
		// 年龄，止到xx
		if (Util.isNotEmpty(search.get("endAge"))) {
			sql += " AND age <= ? ";
			searchList.add(search.get("endAge"));
		}

		// 电话
		if (Util.isNotEmpty(search.get("phone"))) {

			sql += " AND phone like concat('%',?,'%')";
			searchList.add(search.get("phone"));
		}

		// 电子邮件
		if (Util.isNotEmpty(search.get("email"))) {

			sql += " AND email like concat('%',?,'%')";
			searchList.add(search.get("email"));
		}

		ResultSet rs = jdbcUtil.executeQuery(sql,searchList.toArray());

		try {
			while (rs.next()) {

				Doctor doctor = new Doctor();
				doctor.setDoctorId(rs.getInt("doctor_id"));
				doctor.setDoctorName(rs.getString("doctor_name"));
				doctor.setDoctorPwd(rs.getString("doctor_pwd"));
				doctor.setName(rs.getString("name"));
				doctor.setSex(rs.getInt("sex"));
				doctor.setAge(rs.getInt("age"));
				doctor.setPhone(rs.getString("phone"));
				doctor.setEmail(rs.getString("email"));
				doctor.setIsActive(rs.getInt("is_active"));
				doctor.setLevel(rs.getString("level"));
				doctor.setSkill(rs.getString("skill"));
				doctor.setImg(rs.getString("img"));
				doctor.setPlace(rs.getString("place"));

				list.add(doctor);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			jdbcUtil.close();

		}

		return list;
	}

	/**
	 * 根据doctorId 删除 doctor
	 * @param doctorId 咨询师id
	 * @return 受影响行数
	 */
	public int deleteDoctor(Integer doctorId) {
		
		String sql = "DELETE FROM doctor WHERE doctor_id=?";
		
		return jdbcUtil.executeUpdate(sql, doctorId);
	}

	
	/**
	 * 通过doctor的doctorId 查询doctor
	 * @param doctorId 咨询师id
	 * @return 咨询师对象
	 */
	public Doctor getDoctorByDoctorId(int doctorId) {

		String sql = "SELECT * FROM doctor WHERE doctor_id=?";
		
		ResultSet rs = jdbcUtil.executeQuery(sql, doctorId);
		
		Doctor doctor = null;
		
		try {
			if(rs.next()) {
				
				doctor = new Doctor();
				doctor.setDoctorId(rs.getInt("doctor_id"));
				doctor.setDoctorName(rs.getString("doctor_name"));
				doctor.setDoctorPwd(rs.getString("doctor_pwd"));
				doctor.setName(rs.getString("name"));
				doctor.setSex(rs.getInt("sex"));
				doctor.setAge(rs.getInt("age"));
				doctor.setPhone(rs.getString("phone"));
				doctor.setEmail(rs.getString("email"));
				doctor.setIsActive(rs.getInt("is_active"));
				doctor.setLevel(rs.getString("level"));
				doctor.setSkill(rs.getString("skill"));
				doctor.setImg(rs.getString("img"));
				doctor.setPlace(rs.getString("place"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			jdbcUtil.close();
		}
		
		return doctor;
	}

	/**
	 * 修改Doctor
	 * @param doctor 要更新的咨询师对象
	 * @return 受影响行数
	 */
	public int updateDoctor(Doctor doctor) {

		String sql = "UPDATE doctor SET ";
		
		sql += "name=?, sex=?, age=?, phone=?, email=?, is_active=?, level=?, skill=?, img=?, place=?";
		
		sql += "WHERE doctor_id = ?";
		
		return jdbcUtil.executeUpdate(sql, doctor.getName(),doctor.getSex(),
				doctor.getAge(),doctor.getPhone(),doctor.getEmail(),doctor.getIsActive(),doctor.getLevel(),
				doctor.getSkill(),doctor.getImg(),doctor.getPlace(),doctor.getDoctorId());
	}

	/**
	 * 增加一个Doctor
	 * @param doctor 要添加的咨询师对象
	 * @return 受影响行数
	 */
	public int addDoctor(Doctor doctor) {

		String sql = "INSERT INTO doctor ";
		
		sql += " (doctor_name, doctor_pwd, name, sex, age, phone, email, is_active, level, skill, img, place) ";
		
		sql +="VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		return jdbcUtil.executeUpdate(sql, doctor.getDoctorName(),doctor.getDoctorPwd(),doctor.getName(),doctor.getSex(),
				doctor.getAge(),doctor.getPhone(),doctor.getEmail(),doctor.getIsActive(),doctor.getLevel(),
				doctor.getSkill(),doctor.getImg(),doctor.getPlace());
	}

	
	/**
	 * 查询咨询师总数
	 * @return 咨询师数量
	 */
	public int getDoctorNum() {
		
		String sql = "SELECT COUNT(1) FROM doctor";
		
		ResultSet rs = jdbcUtil.executeQuery(sql);
		
		int num = 0;
		
		try {
			if(rs.next()) {
				
				num = rs.getInt("count(1)");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			jdbcUtil.close();
		}
		
		return num;
	}

	
	/**
	 * 通过doctorName获得咨询师(支持电话登录)
	 * @param doctorName 咨询师账号
	 * @return 咨询师对象
	 */
	public Doctor getDoctor(String doctorName) {

		String sql = "SELECT * FROM doctor WHERE doctor_name=? OR phone=?";
		
		ResultSet rs = jdbcUtil.executeQuery(sql, doctorName,doctorName);
		
		Doctor doctor = null;
		
		try {
			if(rs.next()) {
				
				doctor = new Doctor();
				doctor.setDoctorId(rs.getInt("doctor_id"));
				doctor.setDoctorName(rs.getString("doctor_name"));
				doctor.setDoctorPwd(rs.getString("doctor_pwd"));
				doctor.setName(rs.getString("name"));
				doctor.setSex(rs.getInt("sex"));
				doctor.setAge(rs.getInt("age"));
				doctor.setPhone(rs.getString("phone"));
				doctor.setEmail(rs.getString("email"));
				doctor.setIsActive(rs.getInt("is_active"));
				doctor.setLevel(rs.getString("level"));
				doctor.setSkill(rs.getString("skill"));
				doctor.setImg(rs.getString("img"));
				doctor.setPlace(rs.getString("place"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			jdbcUtil.close();
		}
		
		return doctor;
	}

	
	/**
	 * 修改咨询师密码
	 * @param doctorId 咨询师id
	 * @param newPwd 新密码
	 * @return 受影响行数
	 */
	public int updateDoctorPwd(Integer doctorId, String newPwd) {

		String sql = "UPDATE doctor SET ";
		
		sql += "doctor_pwd=?";
		
		sql += "WHERE doctor_id = ?";
		
		return jdbcUtil.executeUpdate(sql,newPwd,doctorId);
	}

}
