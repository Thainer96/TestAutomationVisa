export const payload = JSON.stringify({
  id: 10,
  petId: 198772,
  quantity: 7,
  shipDate: new Date().toISOString(),
  status: 'approved',
  complete: true
});

export const params = {
  headers: {
    'Content-Type': 'application/json',
    'Accept': 'application/json',
  },
};
