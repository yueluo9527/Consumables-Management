import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/orderDetail/list',
    method: 'get',
    params: params
  })
}

export function fetchListPre(params) {
  return request({
    url: '/orderDetail/listPre',
    method: 'get',
    params: params
  })
}

export function getOrderDetail(orderNo) {
  return request({
    url: '/orderDetail/' + orderNo,
    method: 'get'
  });
}

export function updateOrderDetail(id, data) {
  return request({
    url: '/orderDetail/update/' + id,
    method: 'post',
    data: data
  })
}

export function deleteOrderDetail(params) {
  return request({
    url: '/orderDetail/delete',
    method: 'post',
    params: params
  })
}

export function deleteOrderDetailItem(id) {
  return request({
    url: '/orderDetail/delete/' + id,
    method: 'post'
  })
}
