import request from '@/utils/request'



export function searchList(params) {
  return request({
    url: '/loginLog/searchList',
    method: 'get',
    params: params
  })
}



