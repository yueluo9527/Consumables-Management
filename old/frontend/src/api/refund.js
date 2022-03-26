import request from '@/utils/request'


export function fetchList(params) {
  return request({
    url: '/refund/list',
    method: 'get',
    params: params
  })
}
export function countRefund(params) {
  return request({
    url: '/refund/countRefund',
    method: 'get',
    params: params
  })
}

export function searchByDate(params){
  return request({
    url:'/refund/searchByDate',
    method: 'get',
    params: params
  })
}

export function deleteRefund(params) {
  return request({
    url: '/refund/delete',
    method: 'post',
    params: params
  })
}


export function deleteRefundByReCo(params) {
  return request({
    url: '/refund/deleteByReCo',
    method: 'post',
    params: {
      refundCode: params
    }
  })
}

export function getRefundDetail(id) {
  return request({
    url: '/refund/' + id,
    method: 'get'
  });
}






