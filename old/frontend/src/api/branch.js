import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/branch/list',
    method: 'get',
    params: params
  })
}

export function createBranch(data) {
  return request({
    url: '/branch/create',
    method: 'post',
    data: data
  })
}

export function updateBranch(id, data) {
  return request({
    url: '/branch/update/' + id,
    method: 'post',
    data: data
  })
}


export function deleteBranch(id) {
  return request({
    url: '/branch/delete/' + id,
    method: 'post'
  })
}


export function fetchAllBranchList() {
  return request({
    url: '/branch/listAll',
    method: 'get'
  })
}



