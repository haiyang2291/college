import request from '@/utils/request'

// 查询高校管理列表
export function listCollege(query) {
  return request({
    url: '/college/college/list',
    method: 'get',
    params: query
  })
}

// 查询高校管理详细
export function getCollege(id) {
  return request({
    url: '/college/college/' + id,
    method: 'get'
  })
}

// 新增高校管理
export function addCollege(data) {
  return request({
    url: '/college/college',
    method: 'post',
    data: data
  })
}

// 修改高校管理
export function updateCollege(data) {
  return request({
    url: '/college/college',
    method: 'put',
    data: data
  })
}

// 删除高校管理
export function delCollege(id) {
  return request({
    url: '/college/college/' + id,
    method: 'delete'
  })
}
//查寻所有高校信息
export function getColleges() {
  return request({
    url: '/college/college/getColleges',
    method: 'get'
  })
}
