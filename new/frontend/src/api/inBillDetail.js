import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/inBillDetail/list',
    method: 'get',
    params: params
  })
}

export function getInBillDetail(billCode) {
  return request({
    url: '/inBillDetail/' + billCode,
    method: 'get'
  });
}

export function fetchListInBill(params) {
  return request({
    url: '/inBillDetail/listInBill',
    method: 'get',
    params: params
  })
}

export function updateInDetail(id, data) {
  return request({
    url: '/inBillDetail/update/' + id,
    method: 'post',
    data: data
  })
}

export function deleteInBillDetail(params) {
  return request({
    url: '/inBillDetail/delete',
    method: 'post',
    params: params
  })
}

export function deleteInDetail(id) {
  return request({
    url: '/inBillDetail/delete/' + id,
    method: 'post'
  })
}

export async function editInBillItem(data) {
  return await request({
    url: '/inBillDetail/editInBill',
    method: 'post',
    data: data
  })
}

export function subInBillItem(data) {
  return request({
    url: '/inBillDetail/subInBill',
    method: 'post',
    data: data
  })
}
export function inSummary(params) {
  return request({
    url: '/inBillDetail/inSummary',
    method: 'get',
    params: params
  })
}
