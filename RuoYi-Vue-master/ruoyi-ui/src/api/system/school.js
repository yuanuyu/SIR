import request from '@/utils/request'

// 查询school列表
export function listSchool(query) {
  return request({
    url: '/system/school/list',
    method: 'get',
    params: query
  })
}

// 查询school详细
export function getSchool(id) {
  return request({
    url: '/system/school/' + id,
    method: 'get'
  })
}

// 新增school
export function addSchool(data) {
  return request({
    url: '/system/school',
    method: 'post',
    data: data
  })
}

// 修改school
export function updateSchool(data) {
  return request({
    url: '/system/school',
    method: 'put',
    data: data
  })
}

// 删除school
export function delSchool(id) {
  return request({
    url: '/system/school/' + id,
    method: 'delete'
  })
}
