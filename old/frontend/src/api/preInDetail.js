import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/preInDetail/list',
    method: 'get',
    params: params
  })
}

export function searchByBillCode(params) {
  return request({
    url: '/preInDetail/searchByBillCode',
    method: 'get',
    params: params
  })
}

export function getPreInDetail(billCode) {
  return request({
    url: '/preInDetail/' + billCode,
    method: 'get'
  });
}

export function deletePreInBillDetail(params) {
  return request({
    url: '/preInDetail/delete',
    method: 'post',
    params: params
  })
}

export function getReportPath(params) {
  return request({
    url: '/preInDetail/getReportPath',
    method: 'get',
    params: params
  })
}
