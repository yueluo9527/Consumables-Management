import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url: '/preInItem/list',
    method: 'get',
    params: params
  })
}

export function getPreInItemByID(inDetailId) {
  return request({
    url: '/preInItem/getItemByID/' + inDetailId,
    method: 'get'
  });
}

export function getPreInItemByBC(billCode) {
  return request({
    url: '/preInItem/getItemByBC/' + billCode,
    method: 'get'
  });
}

export function deletePreInBillItem(params) {
  return request({
    url: '/preInItem/delete',
    method: 'post',
    params: params
  })
}

export function searchList(params) {
  return request({
    url: '/preInItem/searchList',
    method: 'get',
  })
}
