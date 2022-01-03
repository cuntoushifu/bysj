package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Doctor;
import bean.Question;
import utils.Util;
import utils.jdbc.JdbcUtil;

/**
 * 
 * @instruction
 * question表对应的dao
 */
public class QuestionDao {
	
	JdbcUtil jdbcUtil = new JdbcUtil();
	
	/**
	 * 添加一个预约问题
	 * @param question 要添加的问题对象
	 * @return 受影响行数
	 */
	public int addQuestion(Question question) {
		
		String sql = "INSERT INTO question (question_num, context, answer_yes_score,answer_no_score) ";
		
		sql += "VALUES (?,?,?,?)";

		return jdbcUtil.executeUpdate(sql, question.getQuestionNum(),question.getContext(),
				question.getAnswerYesScore(),question.getAnswerNoScore());
		
	}
	
	/**
	 * 查看所有的问题
	 * @param context 查询条件（根据问题的内容context字段）
	 * @return 问题对象集合
	 */
	public ArrayList<Question> listQuestion(String context){
		
		ArrayList<Question> list = new ArrayList<Question>();
		
		String sql = "SELECT 	`question_id`, `question_num`, `context`, `answer_yes_score`,`answer_no_score` ";
		
		sql += "FROM `question` WHERE 1=1 ";
		
		ResultSet rs = null;
		
		if(Util.isNotEmpty(context)) {
			
			sql += " AND context like concat('%',?,'%')";
			sql += " ORDER BY question_num";
			rs = jdbcUtil.executeQuery(sql,context);
			
		}else {
			sql += " ORDER BY question_num";
			rs = jdbcUtil.executeQuery(sql);
		}

		try {
			while (rs.next()) {
				
				Question question = new Question();
				question.setQuestionId(rs.getInt("question_id"));
				question.setQuestionNum(rs.getInt("question_num"));
				question.setContext(rs.getString("context"));
				question.setAnswerYesScore(rs.getInt("answer_yes_score"));
				question.setAnswerNoScore(rs.getInt("answer_no_score"));
				
				
				list.add(question);

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
	 * 修改一个问题
	 * @param question 要更新的问题对象
	 * @return 受影响行数
	 */
	public int updateQuestion(Question question) {

		String sql = "UPDATE question  ";
		
		sql += " SET question_num=?,context=? ,answer_yes_score=?,answer_no_score=? ";
		
		sql += " WHERE question_id=?";
		
		return jdbcUtil.executeUpdate(sql, question.getQuestionNum(),question.getContext(),question.getAnswerYesScore(),
				question.getAnswerYesScore(),question.getQuestionId());
	}

	
	/**
	 *  删除一个问题
	 * @param questionId 问题id
	 * @return 受影响行数
	 */
	public int deleteQuestion(int questionId) {

		String sql = "DELETE FROM question WHERE question_id=?";
		
		return jdbcUtil.executeUpdate(sql, questionId);
	}

	/**
	 * 查询一个问题
	 * @param questionId 问题id
	 * @return 问题对象 
	 */
	public Question getQuestionByQuestionId(int questionId) {
		
		
		String sql = "SELECT 	`question_id`, `question_num`, `context`, `answer_yes_score`,`answer_no_score` ";
		
		sql += "FROM `question` WHERE question_id=? ";
		
		ResultSet	rs = jdbcUtil.executeQuery(sql,questionId);
		
		Question question = null;

		try {
			while (rs.next()) {
				
				question = new Question();
				question.setQuestionId(rs.getInt("question_id"));
				question.setQuestionNum(rs.getInt("question_num"));
				question.setContext(rs.getString("context"));
				question.setAnswerYesScore(rs.getInt("answer_yes_score"));
				question.setAnswerNoScore(rs.getInt("answer_no_score"));

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

		return question;
		
	}
	
}
