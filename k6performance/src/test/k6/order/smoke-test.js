import http from 'k6/http';
import { check } from 'k6';
import { payload, params } from './utils/order-payload.js';

export const options = {
  vus: 1,
  duration: '5s',
};

export default function () {
  const res = http.post('http://localhost:8080/api/v3/store/order', payload, params);

  check(res, {
    'status is 200': (r) => r.status === 200,
    'petId is correct': (r) => r.json().petId === 198772,
  });
}