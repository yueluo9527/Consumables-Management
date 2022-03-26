import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/outItem/list',
    method: 'get',
    params: params
  })
}

export function getOutItem(outDetailId) {
  return request({
    url: '/outItem/' + outDetailId,
    method: 'get'
  });
}

export function deleteOutBillDetailItem(params) {
  return request({
    url: '/outItem/delete',
    method: 'post',
    params: params
  })
}
