import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/order/list',
    method: 'get',
    params: params
  })
}

export function revokeOrder(id) {
  return request({
    url: '/order/revoke/' + id,
    method: 'post',
  })
}

export function closeOrder(id) {
  return request({
    url: '/order/close/' + id,
    method: 'post',
  })
}

export function deleteOrder(params) {
  return request({
    url: '/order/delete',
    method: 'post',
    params: params
  })
}

export function deleteOrderByNo(params) {
  return request({
    url: '/order/deleteByNo',
    method: 'post',
    params: {
      orderNo: params
    }
  })
}

export function updateOrderByON(orderNo, data) {
  return request({
    url: '/order/updateByON/' + orderNo,
    method: 'post',
    data: data,
  })
}

export function createOrderItem(data) {
  return request({
    url: '/order/create',
    method: 'post',
    data: data
  })
}

export function deliveryOrder(data) {
  return request({
    url: '/order/update/delivery',
    method: 'post',
    data: data
  });
}

export function getOrderCount() {
  return request({
    url: '/order/count',
    method: 'get'
  })
}

export function getRole(username) {
  return request({
    url: '/order/getRoleId/' + username,
    method: 'post'
  })
}
export function fetchDetailList(params) {
  return request({
    url: '/orderDetail/list',
    method: 'get',
    params: params
  })
}
