import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/search/list',
    method: 'get',
    params: params
  })
}
export function searchList(params) {
  return request({
    url: '/search/searchList',
    method: 'get',
    params: params
  })
}

export function createSearch(data) {
  return request({
    url: '/search/create',
    method: 'post',
    data: data
  })
}

export function updateSearch(id, data) {
  return request({
    url: '/search/update/' + id,
    method: 'post',
    data: data
  })
}


export function deleteSearch(id) {
  return request({
    url: '/search/delete/' + id,
    method: 'post'
  })
}











