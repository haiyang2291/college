import request from '@/utils/request'

// 查询行业管理列表
export function listIndustry(query) {
  return request({
    url: '/industry/industry/list',
    method: 'get',
    params: query
  })
}

// 查询行业管理详细
export function getIndustry(id) {
  return request({
    url: '/industry/industry/' + id,
    method: 'get'
  })
}

// 新增行业管理
export function addIndustry(data) {
  return request({
    url: '/industry/industry',
    method: 'post',
    data: data
  })
}

// 修改行业管理
export function updateIndustry(data) {
  return request({
    url: '/industry/industry',
    method: 'put',
    data: data
  })
}

// 删除行业管理
export function delIndustry(id) {
  return request({
    url: '/industry/industry/' + id,
    method: 'delete'
  })
}
