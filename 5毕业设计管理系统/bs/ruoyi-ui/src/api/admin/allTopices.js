import request from '@/utils/request'

// 查询选题信息表列表
export function listAllTopices(query) {
  return request({
    url: '/admin/allTopices/list',
    method: 'get',
    params: query
  })
}

// 查询选题信息表详细
export function getAllTopices(id) {
  return request({
    url: '/admin/allTopices/' + id,
    method: 'get'
  })
}

// 新增选题信息表
export function addAllTopices(data) {
  return request({
    url: '/admin/allTopices',
    method: 'post',
    data: data
  })
}

// 修改选题信息表
export function updateAllTopices(data) {
  return request({
    url: '/admin/allTopices',
    method: 'put',
    data: data
  })
}

// 删除选题信息表
export function delAllTopices(id) {
  return request({
    url: '/admin/allTopices/' + id,
    method: 'delete'
  })
}

// 导出选题信息表
export function exportAllTopices(query) {
  return request({
    url: '/admin/allTopices/export',
    method: 'get',
    params: query
  })
}