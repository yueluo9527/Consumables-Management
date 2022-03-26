import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/outBill/list',
    method: 'get',
    params: params
  })
}

export function deleteOutBill(params) {
  return request({
    url: '/outBill/delete',
    method: 'post',
    params: params
  })
}




