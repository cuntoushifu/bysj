package pers.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.sms.bean.LoginForm;
import pers.sms.bean.Teacher;
import pers.sms.dao.TeacherMapper;
import pers.sms.service.TeacherService;

import java.util.List;

/**
 * @project: sms
 * @description: 业务层实现类-操控教师信息
 */
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    //注入Mapper接口对象
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher login(LoginForm loginForm) {
        return teacherMapper.login(loginForm);
    }

    @Override
    public List<Teacher> selectList(Teacher teacher) {
        return teacherMapper.selectList(teacher);
    }

    @Override
    public Teacher findByTno(Teacher teacher) {
        return teacherMapper.findByTno(teacher);
    }

    @Override
    public int insert(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

    @Override
    public int update(Teacher teacher) {
        return teacherMapper.update(teacher);
    }

    @Override
    public int updatePassowrd(Teacher teacher) {
        return teacherMapper.updatePassword(teacher);
    }

    @Override
    public int deleteById(Integer[] ids) {
        return teacherMapper.deleteById(ids);
    }
}
