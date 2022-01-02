import request from '@/utils/request'

// 查询选题信息表列表
export function listAllStuTopices(query) {
  return request({
    url: '/student/allStuTopices/list',
    method: 'get',
    params: query
  })
}

// 修改选题信息表
export function updateAllStuTopices(data) {
  return request({
    url: '/student/allStuTopices/edit',
    method: 'put',
    data: data
  })
}

// 导出选题信息表
export function exportAllStuTopices(query) {
  return request({
    url: '/student/allStuTopices/export',
    method: 'get',
    params: query
  })
}
