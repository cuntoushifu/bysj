import request from '@/utils/request'

// 查询疑问表列表
export function listDoubt(query) {
  return request({
    url: '/student/doubt/list',
    method: 'get',
    params: query
  })
}

// 查询疑问表详细
export function getDoubt(id) {
  return request({
    url: '/student/doubt/' + id,
    method: 'get'
  })
}

// 新增疑问表
export function addDoubt(data) {
  return request({
    url: '/student/doubt',
    method: 'post',
    data: data
  })
}

// 修改疑问表
export function updateDoubt(data) {
  return request({
    url: '/student/doubt',
    method: 'put',
    data: data
  })
}

// 删除疑问表
export function delDoubt(id) {
  return request({
    url: '/student/doubt/' + id,
    method: 'delete'
  })
}

// 导出疑问表
export function exportDoubt(query) {
  return request({
    url: '/student/doubt/export',
    method: 'get',
    params: query
  })
}