import request from '@/utils/request'

export function copList(params) {
  return request({
    url: '/qualification/copList',
    method: 'get',
    params: params
  })
}
export function prodList(params) {
  return request({
    url: '/qualification/prodList',
    method: 'get',
    params: params
  })
}
export function getReportPath(params) {
  return request({
    url: '/qualification/getReportPath',
    method: 'get',
    params: params
  })
}
