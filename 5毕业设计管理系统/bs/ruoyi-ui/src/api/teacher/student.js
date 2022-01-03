import request from '@/utils/request'

// 查询学生表列表
export function listStudent(query) {
  return request({
    url: '/teacher/student/list',
    method: 'get',
    params: query
  })
}

// 查询学生表详细
export function getStudent(id) {
  return request({
    url: '/teacher/student/' + id,
    method: 'get'
  })
}

// 新增学生表
export function addStudent(data) {
  return request({
    url: '/teacher/student',
    method: 'post',
    data: data
  })
}

// 修改学生表
export function updateStudent(data) {
  return request({
    url: '/teacher/student',
    method: 'put',
    data: data
  })
}

// 删除学生表
export function delStudent(id) {
  return request({
    url: '/teacher/student/' + id,
    method: 'delete'
  })
}

// 导出学生表
export function exportStudent(query) {
  return request({
    url: '/teacher/student/export',
    method: 'get',
    params: query
  })
}