import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/refundItem/list',
    method: 'get',
    params: params
  })
}

export function getRefundItemByRDI(refundDetailId) {
  return request({
    url: '/refundItem/refundItemByRDI/' + refundDetailId,
    method: 'get'
  });
}

export function getPreInItemByRC(refundCode) {
  return request({
    url: '/refundItem/getItemByRC/' + refundCode,
    method: 'get'
  });
}

export function searchList(params) {
  return request({
    url: '/refundItem/searchList',
    method: 'get',
  })
}


export function deleteRefundDetailItem(params) {
  return request({
    url: '/refundItem/delete',
    method: 'post',
    params: params
  })
}
