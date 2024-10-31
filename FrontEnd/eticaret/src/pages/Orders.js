import React, { useEffect, useState } from 'react';
import api from '../services/api';

const Orders = () => {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    api.get('/orders')
      .then(response => setOrders(response.data))
      .catch(error => console.error(error));
  }, []);

  return (
    <div>
      <h1>Siparişler</h1>
      <ul>
        {orders.map(order => (
          <li key={order.id}>
            {order.id} - {order.status} - {order.totalAmount}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Orders;
