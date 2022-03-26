import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/device/list',
    method: 'get',
    params: params
  })
}

export function createDevice(data) {
  return request({
    url: '/device/create',
    method: 'post',
    data: data
  })
}

export function updateDevice(id, data) {
  return request({
    url: '/device/update/' + id,
    method: 'post',
    data: data
  })
}


export function deleteDevice(id) {
  return request({
    url: '/device/delete/' + id,
    method: 'post'
  })
}


export function getDeviceList(username) {
  return request({
    url: '/device/getDeviceList/' + username,
    method: 'get'
  })
}

export function updateStatus(id, params) {
  return request({
    url: '/device/updateStatus/' + id,
    method: 'post',
    params: params
  })
}
