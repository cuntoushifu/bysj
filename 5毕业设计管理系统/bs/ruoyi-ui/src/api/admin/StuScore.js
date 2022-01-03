import request from '@/utils/request'

// 查询学生成绩表列表
export function listStuScore(query) {
  return request({
    url: '/admin/StuScore/list',
    method: 'get',
    params: query
  })
}

// 查询学生成绩表详细
export function getStuScore(id) {
  return request({
    url: '/admin/StuScore/' + id,
    method: 'get'
  })
}

// 新增学生成绩表
export function addStuScore(data) {
  return request({
    url: '/admin/StuScore',
    method: 'post',
    data: data
  })
}

// 修改学生成绩表
export function updateStuScore(data) {
  return request({
    url: '/admin/StuScore',
    method: 'put',
    data: data
  })
}

// 删除学生成绩表
export function delStuScore(id) {
  return request({
    url: '/admin/StuScore/' + id,
    method: 'delete'
  })
}

// 导出学生成绩表
export function exportStuScore(query) {
  return request({
    url: '/admin/StuScore/export',
    method: 'get',
    params: query
  })
}