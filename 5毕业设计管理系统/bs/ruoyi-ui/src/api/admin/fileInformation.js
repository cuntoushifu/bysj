import request from '@/utils/request'

// 查询文档提交表列表
export function listFileInformation(query) {
  return request({
    url: '/admin/fileInformation/list',
    method: 'get',
    params: query
  })
}

// 查询文档提交表详细
export function getFileInformation(id) {
  return request({
    url: '/admin/fileInformation/' + id,
    method: 'get'
  })
}

// 新增文档提交表
export function addFileInformation(data) {
  return request({
    url: '/admin/fileInformation',
    method: 'post',
    data: data
  })
}

// 修改文档提交表
export function updateFileInformation(data) {
  return request({
    url: '/admin/fileInformation',
    method: 'put',
    data: data
  })
}

// 删除文档提交表
export function delFileInformation(id) {
  return request({
    url: '/admin/fileInformation/' + id,
    method: 'delete'
  })
}

// 导出文档提交表
export function exportFileInformation(query) {
  return request({
    url: '/admin/fileInformation/export',
    method: 'get',
    params: query
  })
}