import request from '@/utils/request'

// 查询教师提交课题表列表
export function listTeaThesisTitle(query) {
  return request({
    url: '/teacher/teaThesisTitle/list',
    method: 'get',
    params: query
  })
}

// 查询教师提交课题表详细
export function getTeaThesisTitle(id) {
  return request({
    url: '/teacher/teaThesisTitle/' + id,
    method: 'get'
  })
}

// 新增教师提交课题表
export function addTeaThesisTitle(data) {
  return request({
    url: '/teacher/teaThesisTitle',
    method: 'post',
    data: data
  })
}

// 修改教师提交课题表
export function updateTeaThesisTitle(data) {
  return request({
    url: '/teacher/teaThesisTitle',
    method: 'put',
    data: data
  })
}

// 删除教师提交课题表
export function delTeaThesisTitle(id) {
  return request({
    url: '/teacher/teaThesisTitle/' + id,
    method: 'delete'
  })
}

// 导出教师提交课题表
export function exportTeaThesisTitle(query) {
  return request({
    url: '/teacher/teaThesisTitle/export',
    method: 'get',
    params: query
  })
}