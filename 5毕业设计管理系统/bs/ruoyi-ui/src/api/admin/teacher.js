import request from '@/utils/request'

// 查询教师表列表
export function listTeacher(query) {
  return request({
    url: '/admin/teacher/list',
    method: 'get',
    params: query
  })
}

// 查询教师表详细
export function getTeacher(id) {
  return request({
    url: '/admin/teacher/' + id,
    method: 'get'
  })
}

// 新增教师表
export function addTeacher(data) {
  return request({
    url: '/admin/teacher',
    method: 'post',
    data: data
  })
}

// 修改教师表
export function updateTeacher(data) {
  return request({
    url: '/admin/teacher',
    method: 'put',
    data: data
  })
}

// 删除教师表
export function delTeacher(id) {
  return request({
    url: '/admin/teacher/' + id,
    method: 'delete'
  })
}

// 导出教师表
export function exportTeacher(query) {
  return request({
    url: '/admin/teacher/export',
    method: 'get',
    params: query
  })
}