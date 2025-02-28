import request from '@/utils/request'

// 查询院系管理列表
export function listDepartment(query) {
  return request({
    url: '/department/department/list',
    method: 'get',
    params: query
  })
}

// 查询院系管理详细
export function getDepartment(id) {
  return request({
    url: '/department/department/' + id,
    method: 'get'
  })
}

// 新增院系管理
export function addDepartment(data) {
  return request({
    url: '/department/department',
    method: 'post',
    data: data
  })
}

// 修改院系管理
export function updateDepartment(data) {
  return request({
    url: '/department/department',
    method: 'put',
    data: data
  })
}

// 删除院系管理
export function delDepartment(id) {
  return request({
    url: '/department/department/' + id,
    method: 'delete'
  })
}
export function getCollegeIdDepartment(collegeId){
  return request({
    url: '/department/department/getCollegeIdDepartment/'+collegeId,
    method: 'get'
  })
}
