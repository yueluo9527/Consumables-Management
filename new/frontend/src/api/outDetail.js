import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/outDetail/list',
    method:'get',
    params:params
  })
}
export function getOutDetail(billCode) {
  return request({
    url:'/outDetail/'+billCode,
    method:'get'
  });
}


export function deleteOutBillDetail(params) {
  return request({
    url: '/outDetail/delete',
    method: 'post',
    params: params
  })
}
export function outSummary(params) {
  return request({
    url: '/outDetail/outSummary',
    method: 'get',
    params: params
  })
}
