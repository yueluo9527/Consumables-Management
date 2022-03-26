import Cookies from "js-cookie";

const SupportKey = 'supportKey';

export function getSupport() {
  return Cookies.get(SupportKey)
}

export function setSupport(isSupport) {
  return Cookies.set(SupportKey, isSupport, {expires: 3})
}

export function setCookie(key, value, expires) {
  return Cookies.set(key, value, {expires: expires})
}

export function getCookie(key) {
  return Cookies.get(key)
}
export function clearCookie(name) {
  setCookie(name, '', -1) // 修改2值都为空，天数为负1天就好了
}
