import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/operationLog/list',
    method: 'get',
    params: params
  })
}

export function searchList(params) {
  return request({
    url: '/operationLog/searchList',
    method: 'get',
    params: params
  })
}



