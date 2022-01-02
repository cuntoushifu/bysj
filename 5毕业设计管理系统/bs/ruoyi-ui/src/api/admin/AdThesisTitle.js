import request from '@/utils/request'

// 查询教师提交课题表列表
export function listAdThesisTitle(query) {
  return request({
    url: '/admin/AdThesisTitle/list',
    method: 'get',
    params: query
  })
}

// 查询教师提交课题表详细
export function getAdThesisTitle(id) {
  return request({
    url: '/admin/AdThesisTitle/' + id,
    method: 'get'
  })
}

// 新增教师提交课题表
export function addAdThesisTitle(data) {
  return request({
    url: '/admin/AdThesisTitle',
    method: 'post',
    data: data
  })
}

// 修改教师提交课题表
export function updateAdThesisTitle(data) {
  return request({
    url: '/admin/AdThesisTitle',
    method: 'put',
    data: data
  })
}

// 删除教师提交课题表
export function delAdThesisTitle(id) {
  return request({
    url: '/admin/AdThesisTitle/' + id,
    method: 'delete'
  })
}

// 导出教师提交课题表
export function exportAdThesisTitle(query) {
  return request({
    url: '/admin/AdThesisTitle/export',
    method: 'get',
    params: query
  })
}