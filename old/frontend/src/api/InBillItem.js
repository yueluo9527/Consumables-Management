import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/inBillItem/list',
    method: 'get',
    params: params
  })
}

export function getInBillItem(inDetailId) {
  return request({
    url: '/inBillItem/' + inDetailId,
    method: 'get'
  });
}

export function deleteInBillDetailItem(params) {
  return request({
    url: '/inBillItem/delete',
    method: 'post',
    params: params
  })
}
