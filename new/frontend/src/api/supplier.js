import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/supplier/list',
    method: 'get',
    params: params
  })
}

export function createSupplier(data) {
  return request({
    url: '/supplier/create',
    method: 'post',
    data: data
  })
}

export function updateSupplier(id, data) {
  return request({
    url: '/supplier/update/' + id,
    method: 'post',
    data: data
  })
}

export function deleteSupplier(id) {
  return request({
    url: '/supplier/delete/' + id,
    method: 'post'
  })
}

export function fetchAllSupplierList() {
  return request({
    url: '/supplier/listAll',
    method: 'get'
  })
}
export function updateStatus(id, params) {
  return request({
    url: '/supplier/updateStatus/' + id,
    method: 'post',
    params: params
  })
}
