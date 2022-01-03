import request from '@/utils/request'

// 查询学生成绩表列表
export function listScore(query) {
  return request({
    url: '/teacher/score/list',
    method: 'get',
    params: query
  })
}

// 查询学生成绩表详细
export function getScore(id) {
  return request({
    url: '/teacher/score/' + id,
    method: 'get'
  })
}

// 新增学生成绩表
export function addScore(data) {
  return request({
    url: '/teacher/score',
    method: 'post',
    data: data
  })
}

// 修改学生成绩表
export function updateScore(data) {
  return request({
    url: '/teacher/score',
    method: 'put',
    data: data
  })
}

// 删除学生成绩表
export function delScore(id) {
  return request({
    url: '/teacher/score/' + id,
    method: 'delete'
  })
}

// 导出学生成绩表
export function exportScore(query) {
  return request({
    url: '/teacher/score/export',
    method: 'get',
    params: query
  })
}