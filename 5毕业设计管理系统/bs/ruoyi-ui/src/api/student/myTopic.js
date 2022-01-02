import request from '@/utils/request'

// 查询选题信息表列表
export function listMyTopic(query) {
  return request({
    url: '/student/myTopic/list',
    method: 'get',
    params: query
  })
}

// 查询选题信息表详细
export function getMyTopic(id) {
  return request({
    url: '/student/myTopic/' + id,
    method: 'get'
  })
}

// 新增选题信息表
export function addMyTopic(data) {
  return request({
    url: '/student/myTopic',
    method: 'post',
    data: data
  })
}

// 修改选题信息表
export function updateMyTopic(data) {
  return request({
    url: '/student/myTopic',
    method: 'put',
    data: data
  })
}

// 删除选题信息表
export function delMyTopic(id) {
  return request({
    url: '/student/myTopic/' + id,
    method: 'delete'
  })
}

// 导出选题信息表
export function exportMyTopic(query) {
  return request({
    url: '/student/myTopic/export',
    method: 'get',
    params: query
  })
}