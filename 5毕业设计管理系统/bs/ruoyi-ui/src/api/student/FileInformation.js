import request from '@/utils/request'

// 查询文档提交表列表
export function listFileInformation(query) {
  return request({
    url: '/student/FileInformation/list',
    method: 'get',
    params: query
  })
}

// 查询文档提交表详细
export function getFileInformation(studentNo) {
  return request({
    url: '/student/FileInformation/' + studentNo,
    method: 'get'
  })
}

// 新增文档提交表
export function addFileInformation(data) {
  return request({
    url: '/student/FileInformation',
    method: 'post',
    data: data
  })
}

// 修改文档提交表
export function updateFileInformation(data) {
  return request({
    url: '/student/FileInformation/edit',
    method: 'put',
    data: data
  })
}

// 删除文档提交表
export function delFileInformation(id) {
  return request({
    url: '/student/FileInformation/' + id,
    method: 'delete'
  })
}

// 导出文档提交表
export function exportFileInformation(query) {
  return request({
    url: '/student/FileInformation/export',
    method: 'get',
    params: query
  })
}
