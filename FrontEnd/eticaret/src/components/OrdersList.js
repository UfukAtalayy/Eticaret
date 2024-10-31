import React, { useState, useEffect } from 'react';

const OrdersList = () => {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    // API'ye GET isteği atarak siparişleri getir
    fetch('http://localhost:8080/api/orders')
      .then(response => response.json())
      .then(data => setOrders(data))
      .catch(error => console.error('Error:', error));
  }, []);

  return (
    <div>
      <h2>Orders</h2>
      <ul>
        {orders.map(order => (
          <li key={order.id}>Order ID: {order.id}, Status: {order.status}</li>
        ))}
      </ul>
    </div>
  );
};

export default OrdersList;
