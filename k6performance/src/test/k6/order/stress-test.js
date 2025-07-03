import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  stages: [
    { duration: '30s', target: 10 },  
    { duration: '1m', target: 20 },  
    { duration: '1m', target: 40 },  
    { duration: '30s', target: 0 },   
  ],
};

export default function () {
  const url = 'http://localhost:8080/api/v3/store/order';

  const payload = JSON.stringify({
    id: Math.floor(Math.random() * 100000),  
    petId: 198772,
    quantity: 1,
    shipDate: new Date().toISOString(),      
    status: 'approved',
    complete: true
  });

  const params = {
    headers: {
      'Content-Type': 'application/json'
    }
  };

  const res = http.post(url, payload, params);


  check(res, {
    'status is 200 or 201': (r) => r.status === 200 || r.status === 201,
    'response time < 500ms': (r) => r.timings.duration < 500,
  });

  sleep(1); 
}
