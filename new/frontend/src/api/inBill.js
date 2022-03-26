import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/inBill/list',
    method: 'get',
    params: params
  })
}

export function searchCodeList(params) {
  return request({
    url: '/inBill/searchCodeList',
    method: 'get',
    params: params
  })
}

export function deleteInBill(params) {
  return request({
    url: '/inBill/delete',
    method: 'post',
    params: params
  })
}

export function updateInBillByBC(billCode, data) {
  return request({
    url: '/inBill/updateByBC/' + billCode,
    method: 'post',
    data: data,
  })
}

export function deleteBillByBC(params) {
  return request({
    url: '/inBill/deleteByBC',
    method: 'post',
    params: {
      billCode: params
    }
  })
}

export function createInBillItem(data) {
  return request({
    url: '/inBill/create',
    method: 'post',
    data: data
  })
}

export function createInBillPDA(data) {
  return request({
    url: '/inBill/pda',
    method: 'post',
    data: data
  })
}




