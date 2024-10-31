import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Products = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    // API'den ürünleri çek
    axios.get('http://localhost:8080/api/products')
      .then(response => {
        console.log(response.data);  // Verilerin yapısını görmek için
        setProducts(response.data);
      })
      .catch(error => {
        console.error('There was an error fetching the products!', error);
      });
  }, []);

  return (
    <div>
      <h1>Products</h1>
      <ul>
        {products.map(product => (
          <li key={product.id}>
            <h2>{product.name}</h2>
            <p>{product.description}</p>
            <p>Price: ${product.price}</p>
            <p>Stock: {product.stockQuantity}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Products;
