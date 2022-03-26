import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/preInBill/list',
    method: 'get',
    params: params
  })
}

export function fetchBill(params) {
  return request({
    url: '/preInBill/getPrintData',
    method: 'get',
    params: params
  })
}

export function searchCodeList(params) {
  return request({
    url: '/preInBill/searchCodeList',
    method: 'get',
    params: params
  })
}

export function createPreInBillItem(data) {
  return request({
    url: '/preInBill/create',
    method: 'post',
    data: data
  })
}

export function deletePreInBill(params) {
  return request({
    url: '/preInBill/delete',
    method: 'post',
    params: params
  })
}

export function fetchListByBS(params) {
  return request({
    url: '/preInBill/listByBS',
    method: 'get',
    params: params
  })
}



