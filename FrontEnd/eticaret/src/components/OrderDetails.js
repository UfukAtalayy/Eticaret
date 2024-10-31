import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

const OrderDetails = () => {
  const { id } = useParams();
  const [order, setOrder] = useState(null);

  useEffect(() => {
    // Tek bir siparişi GET ile getir
    fetch(`http://localhost:8080/api/orders/${id}`)
      .then(response => response.json())
      .then(data => setOrder(data))
      .catch(error => console.error('Error:', error));
  }, [id]);

  if (!order) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <h2>Order Details</h2>
      <p>Order ID: {order.id}</p>
      <p>User ID: {order.user_id}</p>
      <p>Total Amount: {order.totalAmount}</p>
      <p>Status: {order.status}</p>
      <p>Order Date: {order.orderDate}</p>
    </div>
  );
};

export default OrderDetails;
