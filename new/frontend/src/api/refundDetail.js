import request from '@/utils/request'


export function fetchList(params) {
  return request({
    url: '/refundDetail/list',
    method: 'get',
    params: params
  })
}

export function getRefundDetail(refundCode) {
  return request({
    url: '/refundDetail/' + refundCode,
    method: 'get'
  });
}

export function updateRefundDetail(id, data) {
  return request({
    url: '/refundDetail/update/' + id,
    method: 'post',
    data: data
  })
}

export function deleteRefundDetail(params) {
  return request({
    url: '/refundDetail/delete',
    method: 'post',
    params: params
  })
}

export function deleteRefundDetailItem(id) {
  return request({
    url: '/refundDetail/delete/' + id,
    method: 'post'
  })
}
